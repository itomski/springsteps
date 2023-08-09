package de.lubowiecki.springsteps.converter;

import org.springframework.core.convert.converter.Converter;

public class DoubleToStringConverter implements Converter<Double, String> {

    @Override
    public String convert(Double source) {
        return String.format("%.2f", source);
    }
}