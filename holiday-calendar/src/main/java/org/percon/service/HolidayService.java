package org.percon.service;

import org.percon.dao.IHolidayDao;
import org.percon.models.Country;
import org.percon.models.Holiday;
import org.percon.models.HolidayResponse;
import org.percon.models.Regions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HolidayService {
    @Autowired
    IHolidayDao holidayDao;

    public ResponseEntity<List<Country>> getCountries() {
        List<Country> countries = holidayDao.getCountries();
        if (countries == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(countries);
    }
    public ResponseEntity<List<Regions>> getRegions(int countryId) {
        List<Regions> regions = holidayDao.getRegions(countryId);
        if (regions == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(regions);
    }

    public ResponseEntity<HolidayResponse> getHolidays(int regionId) {
        HolidayResponse response = holidayDao.getHolidays(regionId);
        if (response == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(response);
    }


}
