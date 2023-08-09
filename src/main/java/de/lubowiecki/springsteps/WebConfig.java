package de.lubowiecki.springsteps;

import de.lubowiecki.springsteps.converter.DoubleToStringConverter;
import de.lubowiecki.springsteps.converter.LocalDateToStringConverter;
import de.lubowiecki.springsteps.converter.StringToDoubleConverter;
import de.lubowiecki.springsteps.converter.StringToLocalDateConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    // Converter werden als StandardConverter registrieret

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new StringToDoubleConverter());
        registry.addConverter(new DoubleToStringConverter());
        registry.addConverter(new StringToLocalDateConverter());
        registry.addConverter(new LocalDateToStringConverter());
    }
}
