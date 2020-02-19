package com.jelif.daycounter.domain;

import java.util.Objects;

public class Result {
	private Direction direction;
	private int days;

	public Direction getDirection() {
		return direction;
	}
	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	public Result(Direction direction, int days) {
		super();
		this.direction = direction;
		this.days = days;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} else if (obj == null) {
			return false;
		} else if (obj.getClass() != Result.class) {
			return false;
		} else {
			Result that = (Result) obj;
			return Objects.equals(this.getDirection(), that.getDirection())
					&& Objects.equals(this.getDays(), that.getDays());
		}
	}
	@Override
	public int hashCode() {
		return Objects.hash(direction, days);
	}
}
