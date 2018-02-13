package com.springboard.project.service;

import com.springboard.project.domain.Journal;
import com.springboard.project.domain.User;
import com.springboard.project.repository.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.Errors;

import java.util.List;

@Service @Transactional(readOnly = true)
public class JournalServiceImpl implements JournalService {

    @Autowired JournalRepository journalRepository;

    @Override @Transactional(readOnly = false)
    public Journal post(Journal journal, Errors errors) {
        validateUser(journal.getUser(),errors);
        boolean valid = !errors.hasErrors();
        if(valid) { journalRepository.save(journal); }
        return valid ? journal : null;
    }

    @Override
    public Journal getJournal(Long id, Errors errors) {
        Journal journal = new Journal();
        validateJournalId(id,errors);
        boolean valid = !errors.hasErrors();
        if(valid) { journal = journalRepository.getOne(id); }
        return valid ? journal : null;
    }


    @Override @Transactional(readOnly = false)
    public Journal update(Journal journal, Errors errors) {
        getJournal(journal.getId(), errors);

        return !errors.hasErrors() ? journalRepository.save(journal) : null;
    }

    @Override @Transactional(readOnly = false)
    public void delete(Long id,Errors errors) {
        getJournal(id,errors);
        if(!errors.hasErrors()) { journalRepository.deleteById(id); }
    }

    @Override
    public List<Journal> getJournals() {
        return journalRepository.findAll();
    }

    private void validateUser(User user, Errors errors) {
        if(ObjectUtils.isEmpty(user)){
            errors.rejectValue("user","error.required");
        }
    }

    private void validateJournalId(Long id, Errors errors) {
        if(ObjectUtils.isEmpty(id) || !journalRepository.existsById(id)){
            errors.rejectValue("id","error.notExists");
        }
    }

}
