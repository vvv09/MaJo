package com.valunskii.majo.service;

import java.util.Calendar;
import java.util.Map;

public interface AstrologyService {

    Map<String, String> getAllAstroData(String date, double lantitude, double longitude);

}
