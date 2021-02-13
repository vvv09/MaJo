package com.valunskii.majo.controller;

import com.valunskii.majo.domain.Entry;
import com.valunskii.majo.service.EntryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entry")
@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
@AllArgsConstructor
public class EntryController {

    private final EntryService service;

    @GetMapping
    public List<Entry> getAll() {
        return service.getAll();
    }

    @GetMapping("{id}")
    public Entry getById(@PathVariable("id") Entry entry) {
        return entry;
    }

    @GetMapping("/today")
    public Entry getTodayEntry(
            @RequestParam(name = "sr", required = false) String sunriseTime,
            @RequestParam(name = "ss", required = false) String sunsetTime,
            @RequestParam(name = "m", required = false) String moonPhase
            ) {
        return service.getEntryForToday(sunriseTime, sunsetTime, moonPhase);
    }

    @PostMapping
    public Entry create(@RequestBody Entry entry) {
        return service.create(entry);
    }

    @PutMapping("{id}")
    public Entry update(
            @PathVariable("id") Entry entryFromDb,
            @RequestBody Entry entry) {
        return service.update(entryFromDb, entry);
    }

    @DeleteMapping("{id}")
    public void delete(
            @PathVariable("id") Entry entry) {
        service.delete(entry);
    }

}
