package com.jelif.daycounter.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.jelif.daycounter.domain.Result;
import com.jelif.daycounter.domain.Direction;

@Service
public class DayCounterService {
	
	@Autowired
	private JdbcTemplate jdbc;
	
	public Result calculate(LocalDate date, LocalDate now) {
		int minus = (int) (date.toEpochDay() - now.toEpochDay());
		if (minus >= 0) {
			return new Result(Direction.DECEED, minus);
		} else {
			return new Result(Direction.EXCEED, -minus);
		}
	}
}
