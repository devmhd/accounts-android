package me.mehedee.accounts.persistence;

import androidx.room.TypeConverter;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class TypeConverters {

    @TypeConverter
    public static Long convert(LocalDateTime localDateTime) {
        if (localDateTime == null)
            return null;

        return localDateTime.atZone(ZoneId.systemDefault()).toEpochSecond();
    }

    @TypeConverter
    public static LocalDateTime convert(Long epochSecond) {
        return Instant.ofEpochSecond(epochSecond).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }
}
