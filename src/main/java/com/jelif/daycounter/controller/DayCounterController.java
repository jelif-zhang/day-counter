package com.jelif.daycounter.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jelif.daycounter.domain.ConfigItem;
import com.jelif.daycounter.domain.Result;
import com.jelif.daycounter.repository.ConfigItemJdbcRepository;
import com.jelif.daycounter.service.DayCounterService;

@Controller
@RequestMapping("/daycounter")
public class DayCounterController {
	private static String DASHBOARD = "dashboard";
	private static String SETTING = "setting";
	
	@Autowired
	private DayCounterService dayCounterService;
	
	@Autowired
	private ConfigItemJdbcRepository configItemRepository;
	
	@ModelAttribute("setting")
	private ConfigItem prepareSetting() {
		return configItemRepository.getConfigItem();
	}

	@ModelAttribute("result")
	private Result prepareCountResult(@ModelAttribute("setting") ConfigItem setting) {
		return dayCounterService.calculate(setting.getDate(), LocalDate.now());
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String showDashBoard() {
		return DASHBOARD;
	}
	
	@RequestMapping(value = "/setting", method = RequestMethod.GET)
	public String gotoSetting() {
		return SETTING;
	}
	
	@RequestMapping(value = "/setting", method = RequestMethod.POST)
	public String setting(ConfigItem configItem) {
		configItemRepository.setConfigItem(configItem);
		return "redirect:/daycounter";
	}
	
	@RequestMapping(value = "/api/result", method = RequestMethod.GET)
	@ResponseBody
	public Result getResult(@ModelAttribute("result") Result result) {
		return result;
	}
	
	@RequestMapping(value = "/api/setting", method = RequestMethod.GET)
	@ResponseBody
	public ConfigItem getSetting(@ModelAttribute("setting") ConfigItem setting) {
		return setting;
	}
	
	@RequestMapping(value = "/api/setting", method = RequestMethod.PUT)
	@ResponseBody
	public ConfigItem restSetting(@RequestBody ConfigItem configItem) {
		configItemRepository.setConfigItem(configItem);
		return configItemRepository.getConfigItem();
	}
}
