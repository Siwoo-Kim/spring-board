package com.springboard.project.controller;

import com.springboard.project.domain.Journal;
import com.springboard.project.domain.User;
import com.springboard.project.repository.UserRepository;
import com.springboard.project.service.JournalService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Log
@Controller
@RequestMapping("/journal")
public class JournalController {

    @Autowired JournalService journalService;
    @Autowired UserRepository userRepository;
    @Autowired @Qualifier("postFormView") String postFormView;
    @Autowired @Qualifier("listView") String listView;

    @InitBinder("newJournal")
    public void newJournalDataBinder(WebDataBinder binder){
        binder.setAllowedFields(new String[]{"title","content","user.id"});
    }

    @GetMapping("/post")
    public String postForm(@ModelAttribute("newJournal") Journal journal){
        return postFormView;
    }

    /*creating mock user*/
    private User user = User.builder().username("user1").build();
    private boolean isFirstCall = true;

    @PostMapping("/post")
    public String postProcess(@ModelAttribute("newJournal") Journal journal, BindingResult bindingResult){
        log.warning(journal::toString);

        /*inserting mock user*/
        if(isFirstCall){ userRepository.create(user); isFirstCall = false; }
        journal.setUser(user);
        journal = journalService.post(journal,bindingResult);
        log.warning(journal::toString);

        if(bindingResult.hasErrors()){  return postFormView; }
        return "redirect:/success";
    }

    @GetMapping
    public String listAll(Model model){
        model.addAttribute(journalService.getJournals());
        return listView;
    }

}
