package com.valunskii.majo.service;

import com.valunskii.majo.domain.Entry;

import java.util.List;
import java.util.Optional;

public interface EntryService {
    List<Entry> getAll();
    Optional<Entry> getById(Long id);
    Entry create(Entry entry);
    Entry update(Entry entryFromDb, Entry entry);
    void delete(Entry entry);
    Entry getEntryForToday(String sunriseTime,String sunsetTime,String moonPhase);
}
