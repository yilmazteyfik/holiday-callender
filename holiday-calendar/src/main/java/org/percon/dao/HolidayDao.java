package org.percon.dao;

import org.percon.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class HolidayDao implements IHolidayDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Country> getCountries() {
        String sql = "SELECT * FROM countries";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Country country = new Country();
            country.setCountryId(rs.getInt("country_id")); // Assuming a field countryId exists in your Country class
            country.setCountryName(rs.getString("country_name")); // Assuming a field countryName exists in your Country class
            return country;
        });
    }

    @Override
    public List<Regions> getRegions(int countryId) {
        String sql = "SELECT * FROM regions WHERE country_id = ?";
        return jdbcTemplate.query(sql, new Object[]{countryId}, (rs, rowNum) -> {
            Regions region = new Regions();
            region.setRegionId(rs.getInt("region_id"));
            region.setCountryId(rs.getInt("country_id"));
            region.setRegionName(rs.getString("region_name"));
            return region;
        });
    }
    @Override
    public Regions getRegionByRegionId(int regionId) {
        String sql = "SELECT * FROM regions WHERE region_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{regionId}, (rs, rowNum) -> {
            Regions region = new Regions();
            region.setRegionId(rs.getInt("region_id"));
            region.setCountryId(rs.getInt("country_id"));
            region.setRegionName(rs.getString("region_name"));
            return region;
        });
    }


    @Override
    public HolidayResponse getHolidays(int regionId) {
        String sql = "SELECT * FROM holidays WHERE region_id = ?";

        List<Holiday> holidays = jdbcTemplate.query(sql, new Object[]{regionId}, (rs, rowNum) -> {
            Holiday holiday = new Holiday();
            holiday.setHolidayId(rs.getInt("holiday_id"));
            holiday.setHolidayName(rs.getString("holiday_name"));
            holiday.setHolidayDate(rs.getDate("holiday_date"));
            holiday.setRegionId(rs.getInt("region_id"));
            int holidayTypeId = rs.getInt("holiday_type_id");
            switch (holidayTypeId){
                case 1:
                    holiday.setHolidayType(HolidayType.RESMI_TATIL);
                    break;
                case 2:
                    holiday.setHolidayType(HolidayType.DINI_TATIL);
                    break;
                case 3:
                    holiday.setHolidayType(HolidayType.OZEL_GUN);
                    break;
            }
            return holiday;
        });

        HolidayResponse response = new HolidayResponse();
        Regions region1 = getRegionByRegionId(regionId);
        response.setRegion(region1);

        for (Holiday holiday : holidays) {
            if (holiday.getHolidayType().equals(HolidayType.RESMI_TATIL)) {
                response.addPublicHoliday(holiday);
            }
            else if (holiday.getHolidayType().equals(HolidayType.DINI_TATIL)) {
                response.addReligiousHoliday(holiday);
            }
            else {
                response.addSpecialHoliday(holiday);
            }
        }
        response.setTotalHolidaysCount(holidays.size());
        return response;
    }





}
