package com.jelif.daycounter.config;

import java.time.LocalDate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

import com.jelif.daycounter.util.DateUtil;


@Configuration
public class LocalDateTimeConverterConfiguration {
	
	@Bean
	public Converter<String, LocalDate> localDateTimeConverter() {
		return new Converter<String, LocalDate>() {
			@Override
			public LocalDate convert(String source) {
				return DateUtil.convertStringToLocalDate(source);
			}
		};
	}
}
