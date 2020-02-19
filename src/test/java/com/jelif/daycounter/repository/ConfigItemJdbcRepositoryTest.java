package com.jelif.daycounter.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.Objects;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.jelif.daycounter.domain.ConfigItem;

@SpringBootTest
@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ConfigItemJdbcRepositoryTest {
	@Autowired
	private ConfigItemJdbcRepository configItemRepository;
	
	private ConfigItem INITIAL_CONFIG_ITEM;
	
	private ConfigItem MODIFIED_CONFIG_ITEM;
	
	@BeforeAll
	private void BeforeAll() {
		INITIAL_CONFIG_ITEM = new ConfigItem();
		INITIAL_CONFIG_ITEM.setId(0);
		INITIAL_CONFIG_ITEM.setDate(LocalDate.of(2020, 1, 1));
		INITIAL_CONFIG_ITEM.setTitle("2020年第一天");
		MODIFIED_CONFIG_ITEM = new ConfigItem();
		MODIFIED_CONFIG_ITEM.setId(0);
		MODIFIED_CONFIG_ITEM.setDate(LocalDate.of(2020, 2, 1));
		MODIFIED_CONFIG_ITEM.setTitle("2020年二月第一天");
	}
	
	private boolean compareConfigItem(ConfigItem configItem, ConfigItem configItem2) {
		if (configItem == null || configItem2 == null) {
			return false;
		} else {
			return Objects.equals(configItem.getId(), configItem2.getId())
					&& Objects.equals(configItem.getDate(), configItem2.getDate())
					&& Objects.equals(configItem.getTitle(), configItem2.getTitle());
		}
	}
	
	@Test
	void testGetConfigItem() {
		assertTrue(compareConfigItem(INITIAL_CONFIG_ITEM,
				configItemRepository.getConfigItem()));
	}

	@Test
	void testSetConfigItem() {
		configItemRepository.setConfigItem(MODIFIED_CONFIG_ITEM);
		assertTrue(compareConfigItem(MODIFIED_CONFIG_ITEM,
				configItemRepository.getConfigItem()));
	}

}
