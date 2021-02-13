package com.valunskii.majo.controller;

import com.valunskii.majo.domain.Entry;
import com.valunskii.majo.payload.response.DataResponse;
import com.valunskii.majo.service.AstrologyService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/astrology")
@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
@AllArgsConstructor
public class AstrologyController {

    private final AstrologyService service;

    @GetMapping
    public DataResponse getForDayPlace(
            @RequestParam(name = "date", required = true) String date,
            @RequestParam(name = "lan", required = true) Double lan,
            @RequestParam(name = "lon", required = true) Double lon
    ) {
        DataResponse response = new DataResponse();
        Map<String, String> data = service.getAllAstroData(date, lan, lon);
        response.setData(data);
        return response;
    }
}
