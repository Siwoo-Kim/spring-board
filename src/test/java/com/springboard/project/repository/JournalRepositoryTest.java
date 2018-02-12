package com.springboard.project.repository;

import com.springboard.project.domain.Journal;
import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@Log
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/rootConfig.xml")
public class JournalRepositoryTest {

    @Autowired JournalRepository journalRepository;

    @Test
    public void persist(){
        Journal journal = createJournal();
        journalRepository.save(journal);
        Journal foundJournal = journalRepository.findById(journal.getId()).orElseThrow(NullPointerException::new);

        assertThat(journal,is(foundJournal));
        log.warning(journal::toString);
    }

    private Journal createJournal() {
        return Journal.builder()
                .title("title1")
                .content("content should enough space to hold many characters content should enough space to hold many characters content should enough space to hold many characters ")
                .postDate(LocalDate.now())
                .build();
    }
}
