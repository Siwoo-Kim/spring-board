package com.springboard.project.service;

import com.springboard.project.domain.Journal;
import com.springboard.project.domain.User;
import com.springboard.project.repository.JournalRepository;
import com.springboard.project.repository.UserRepository;
import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BeanPropertyBindingResult;

import static com.springboard.project.repository.JournalRepositoryTest.createJournal;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

@Log
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/rootConfig.xml")
public class JournalServiceTest {

    @Autowired JournalService journalService;
    @Autowired JournalRepository journalRepository;
    @Autowired UserRepository userRepository;
    @Test
    public void post(){
        Journal journal = createJournal();

        BeanPropertyBindingResult beanPropertyBindingResult =
                new BeanPropertyBindingResult(journal,"journal");
        journalService.post(journal,beanPropertyBindingResult);
        assertThat("User must exsits before posting journal",
                beanPropertyBindingResult.hasErrors(),is(true));
        assertThat(beanPropertyBindingResult.getFieldError("user"),is(notNullValue()));
        log.warning(beanPropertyBindingResult::toString);

        User user = User.builder().build();
        userRepository.create(user);
        journal.setUser(user);
        beanPropertyBindingResult = new BeanPropertyBindingResult(journal,"journal");
        Journal savedJournal = journalService.post(journal,beanPropertyBindingResult);
        assertThat(savedJournal,is(notNullValue()));
        assertThat(savedJournal,is(journal));
        assertThat(beanPropertyBindingResult.hasErrors(),is(false));

    }

    @Test
    public void getJournal(){

        BeanPropertyBindingResult beanPropertyBindingResult =
                new BeanPropertyBindingResult(Journal.builder().build(),"journal");
        Journal emptyJournal = journalService.getJournal(9999L,beanPropertyBindingResult);

        assertThat("Empty Journal should be empty object",emptyJournal,is(nullValue()));
        assertThat(beanPropertyBindingResult.getFieldError("id"),is(notNullValue()));

        Journal journal = createJournal();
        journalRepository.save(journal);
        beanPropertyBindingResult =
                new BeanPropertyBindingResult(journal,"journal");
        Journal foundJournal = journalService.getJournal(journal.getId(),beanPropertyBindingResult);
        assertThat(foundJournal,is(notNullValue()));
        assertThat(beanPropertyBindingResult.hasErrors(),is(false));

    }

    @Test
    public void update(){
        BeanPropertyBindingResult beanPropertyBindingResult =
                new BeanPropertyBindingResult(Journal.builder().build(),"journal");
        Journal journal = createJournal();
        journalRepository.save(journal);
        String changedContent = "Hello SpringBoard!";
        journal.setContent(changedContent);
        journalService.update(journal,beanPropertyBindingResult);

        journalRepository.flush();
        Journal foundJournal = journalRepository.findById(journal.getId()).get();
        assertThat(foundJournal.getContent(),is(changedContent));
        assertThat(beanPropertyBindingResult.hasErrors(),is(false));
        log.warning(foundJournal::toString);

        beanPropertyBindingResult =
                new BeanPropertyBindingResult(Journal.builder().build(),"journal");
        journal = createJournal();
        journal.setId(9999L);
        journal.setContent("Not exists journal in database");
        journalService.update(journal,beanPropertyBindingResult);

        assertThat("No-exist journal cannot be updated",
                beanPropertyBindingResult.getFieldError("id").getCode(),is("error.notExists"));
        assertFalse(journalRepository.existsById(9999L));
    }

    @Test
    public void delete(){
        BeanPropertyBindingResult beanPropertyBindingResult =
                new BeanPropertyBindingResult(Journal.builder().build(),"journal");
        Journal journal = createJournal();
        journalRepository.save(journal);
        journalService.delete(journal.getId(),beanPropertyBindingResult);

        assertFalse(journalRepository.existsById(journal.getId()));
        assertFalse(beanPropertyBindingResult.hasErrors());
    }

}