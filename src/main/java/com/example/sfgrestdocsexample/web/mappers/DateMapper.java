package com.example.sfgrestdocsexample.web.mappers;

import org.springframework.stereotype.Component;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

/**
 * @author <a href="pulkit.aggarwal@upgrad.com">Pulkit Aggarwal</a>
 * @version 1.0
 * @since 06/03/22
 */
@Component
public class DateMapper {
    public OffsetDateTime asOffsetDateTime(Timestamp ts){
        if(ts != null){
            return OffsetDateTime.of(ts.toLocalDateTime().getYear(), ts.toLocalDateTime().getMonthValue(),
                    ts.toLocalDateTime().getDayOfMonth(), ts.toLocalDateTime().getHour(), ts.toLocalDateTime().getMinute(),
                    ts.toLocalDateTime().getSecond(), ts.toLocalDateTime().getNano(), ZoneOffset.UTC);
        }else{
            return null;
        }
    }

    public Timestamp asTimeStamp(OffsetDateTime offsetDateTime){
        if(offsetDateTime!=null){
            return Timestamp.valueOf(offsetDateTime.atZoneSameInstant(ZoneOffset.UTC).toLocalDateTime());
        }else {
            return null;
        }
    }
}
