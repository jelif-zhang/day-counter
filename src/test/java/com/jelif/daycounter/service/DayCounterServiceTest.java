package com.jelif.daycounter.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.jelif.daycounter.domain.Direction;
import com.jelif.daycounter.domain.Result;

@SpringBootTest
@ActiveProfiles("test")
class DayCounterServiceTest {
	@Autowired
	private DayCounterService dayCounterService;
	
	@Test
	void testCalculate() {
		LocalDate date = LocalDate.of(2020, 1, 5);
		assertEquals(dayCounterService.calculate(date,
				LocalDate.of(2020, 1, 6)),
				new Result(Direction.EXCEED, 1));
		assertEquals(dayCounterService.calculate(date,
				LocalDate.of(2020, 1, 5)),
				new Result(Direction.DECEED, 0));
		assertEquals(dayCounterService.calculate(date,
				LocalDate.of(2020, 1, 4)),
				new Result(Direction.DECEED, 1));
	}

}
