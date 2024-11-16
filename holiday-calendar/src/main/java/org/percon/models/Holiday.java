package org.percon.models;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;
public class Holiday {
    @Getter @Setter private int holidayId;
    @Getter @Setter private String holidayName;
    @Getter @Setter private Date holidayDate;
    @Getter @Setter private int regionId;
    @Getter @Setter private HolidayType holidayType;
}
