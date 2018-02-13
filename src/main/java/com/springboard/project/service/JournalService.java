package com.springboard.project.service;

import com.springboard.project.domain.Journal;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;

import java.util.List;

public interface JournalService {

    @Transactional(readOnly = false)
    Journal post(Journal journal, Errors errors);

    Journal getJournal(Long id, Errors errors);
    @Transactional(readOnly = false)
    Journal update(Journal journal, Errors errors);

    @Transactional(readOnly = false)
    void delete(Long id, Errors errors);
    List<Journal> getJournals();

}
