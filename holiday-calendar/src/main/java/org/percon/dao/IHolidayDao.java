package org.percon.dao;

import org.percon.models.Country;
import org.percon.models.Holiday;
import org.percon.models.HolidayResponse;
import org.percon.models.Regions;

import java.util.List;

public interface IHolidayDao {
    List<Country> getCountries();
    List<Regions> getRegions(int countryId);
    HolidayResponse getHolidays(int regionId);
    Regions getRegionByRegionId(int regionId);
}
