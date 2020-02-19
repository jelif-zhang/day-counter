package com.jelif.daycounter.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import org.springframework.jdbc.core.RowMapper;

import com.jelif.daycounter.util.DateUtil;

public class ConfigItem implements RowMapper<ConfigItem> {
	private int id;
	private LocalDate date;
	private String title;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public ConfigItem mapRow(ResultSet rs, int rowNum) throws SQLException {
		ConfigItem configItem = new ConfigItem();
		configItem.setId(rs.getInt("id"));
		configItem.setDate(DateUtil.convertStringToLocalDate(rs.getString("date")));
		configItem.setTitle(rs.getString("title"));
		return configItem;
	}
}
