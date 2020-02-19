package com.jelif.daycounter.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jelif.daycounter.domain.ConfigItem;

@Repository
public class ConfigItemJdbcRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public ConfigItem getConfigItem() {
		return jdbcTemplate.queryForObject("select * from config where id = 0", new ConfigItem());
	}
	
	public void setConfigItem(ConfigItem configItem) {
		jdbcTemplate.update("update config set date=?, title=? where id=?",
				configItem.getDate(), configItem.getTitle(), configItem.getId());
	}
}
