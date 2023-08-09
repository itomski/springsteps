package de.lubowiecki.springsteps;

import org.springframework.core.convert.converter.Converter;

public class StringToDoubleConverter implements Converter<String, Double> {

    @Override
    public Double convert(String source) {
        source = source.replace(",", ".");
        return Double.parseDouble(source);
    }
}
