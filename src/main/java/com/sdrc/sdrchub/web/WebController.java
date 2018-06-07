package com.sdrc.sdrchub.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sdrc.sdrchub.domain.EntryDetails;
import com.sdrc.sdrchub.domain.TypeDetails;
import com.sdrc.sdrchub.models.ViewDataModel;
import com.sdrc.sdrchub.service.DataEntryService;
import com.sdrc.sdrchub.service.ViewDataService;

@RestController
@RequestMapping("/api")
public class WebController {
	
	@Autowired
	private ViewDataService viewDataService;
	
	@Autowired
	private DataEntryService dataEntryService;
	
	@RequestMapping("/getModulesPlatforms")
	public List<TypeDetails> getModulesPlatforms() throws Exception {
		return dataEntryService.getModulesAndPlatforms();
	}
	
	@RequestMapping(value="/viewData",method=RequestMethod.GET)
	@ResponseBody
	public List<EntryDetails> exceptionHandlerTest(@RequestParam Integer moduleId, @RequestParam Integer platformId) throws Exception {
		return viewDataService.getAllData(moduleId, platformId);
	}
	
	@RequestMapping("/saveData")
	@ResponseBody
	public String  saveData(@RequestBody EntryDetails entryData) throws Exception {
		try{
			return dataEntryService.saveData(entryData);
		}catch(Exception e){
//			UserModel user = (UserModel) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//			_log.error("ERR-saveData Failed to save data from user : {} with request payload : {} ",user.getUsername(),submissionData.toString(),e);
			throw e;
		}
		
	}
}
