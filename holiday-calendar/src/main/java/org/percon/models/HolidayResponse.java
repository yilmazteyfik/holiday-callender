package org.percon.models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class HolidayResponse {
    @Getter @Setter
    private Regions region;
    @Getter
    @Setter
    private List<Holiday> publicHolidays;
    @Getter
    @Setter
    private List<Holiday> religiousHolidays;
    @Getter
    @Setter
    private List<Holiday> specialHolidays;
    @Getter
    @Setter
    private int totalHolidaysCount = 0;

    public HolidayResponse() {
        publicHolidays = new ArrayList<>();
        religiousHolidays = new ArrayList<>();
        specialHolidays = new ArrayList<>();
    }

    public void addPublicHoliday(Holiday holiday) {
        publicHolidays.add(holiday);
    }
    public void addReligiousHoliday(Holiday holiday) {
        religiousHolidays.add(holiday);
    }
    public void addSpecialHoliday(Holiday holiday) {
        specialHolidays.add(holiday);
    }
}
