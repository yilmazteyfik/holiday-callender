package org.percon.controllers;

import org.percon.models.Country;
import org.percon.models.Holiday;
import org.percon.models.HolidayResponse;
import org.percon.models.Regions;
import org.percon.service.HolidayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/holiday")
public class HolidayController {
    @Autowired
    HolidayService holidayService;

    @GetMapping("/getCountries")
    public ResponseEntity<List<Country>> getCountries() {
        return holidayService.getCountries();
    }
    @GetMapping("/getRegions/{countryId}")
    public ResponseEntity<List<Regions>> getRegions(@PathVariable int countryId) {
        return holidayService.getRegions(countryId);
    }
    @GetMapping("/getHolidays/{regionId}")
    public ResponseEntity<HolidayResponse> getHolidays(@PathVariable int regionId) {
        return holidayService.getHolidays(regionId);
    }






}
