package com.valunskii.majo.service;

import com.valunskii.majo.domain.Entry;
import com.valunskii.majo.repo.EntryRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EntryServiceImpl implements EntryService {

    private EntryRepo repo;
    private AstrologyService astrologyService;

    @Override
    public List<Entry> getAll() {
        return repo.findAllByOrderByDateDesc();
    }

    @Override
    public Optional<Entry> getById(Long id) {
        return repo.findById(id);
    }

    @Override
    public Entry create(Entry entry) {
        return repo.save(entry);
    }

    @Override
    public Entry update(Entry entryFromDb, Entry entry) {
        BeanUtils.copyProperties(entry, entryFromDb, "id");
        return repo.save(entryFromDb);
    }

    @Override
    public void delete(Entry entry) {
        repo.delete(entry);
    }

    @Override
    public Entry getEntryForToday(String sunriseTime, String sunsetTime, String moonPhase) {
        Optional<Entry> entry = repo.getByDate(LocalDate.now());
        if (entry.isPresent()) {
            return entry.get();
        } else {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            Map<String, String> astroData = astrologyService.getAllAstroData(LocalDate.now().format(formatter));
            return create(new Entry(
                    LocalDate.now(),
                    LocalDate.now().getDayOfWeek().getValue(),
                    astroData.get("sunrise"),
                    astroData.get("sunset"),
                    astroData.get("moonphase")
            ));
        }
    }
}
