package de.lubowiecki.springsteps.converter;

import org.springframework.core.convert.converter.Converter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class StringToLocalDateConverter implements Converter<String, LocalDate> {

    //private static DateTimeFormatter DATE_FMT = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    private static DateTimeFormatter DATE_FMT = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);


    @Override
    public LocalDate convert(String source) {
        return LocalDate.parse(source, DATE_FMT);
    }
}
