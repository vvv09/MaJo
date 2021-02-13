package com.valunskii.majo.repo;

import com.valunskii.majo.domain.Entry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface EntryRepo extends JpaRepository<Entry, Long> {

    Optional<Entry> getByDate(LocalDate date);

    List<Entry> findAllByOrderByDateDesc();
}
