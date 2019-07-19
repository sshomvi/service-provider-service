package com.examples.microserv.sp.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examples.microserv.sp.model.ServiceProvider;
import com.examples.microserv.sp.service.ServiceProviderService;


@RestController
@RequestMapping("/sps")
public class ServiceProviderController {

	@Autowired
	ServiceProviderService spService;
	
	//Get All sps
	@GetMapping(produces= {"application/json"})
	public List<ServiceProvider> getAllServiceProviders() {		
			
		return spService.getAllSps();
	}
	
	//Get ServiceProvider by Id
	@GetMapping(value = "{spId}",produces= {"application/json","application/xml"})
	public ServiceProvider getServiceProvider(@PathVariable Long spId)
	{	
		return spService.getSpById(spId);
	}

	//Create ServiceProvider
	@PostMapping(consumes= {"application/json"},produces= {"application/json"})
	public ServiceProvider createPaymentServiceProvider(@RequestBody ServiceProvider sp) {
		
		return spService.createOrSaveSp(sp);
	}
	
	//Update ServiceProvider
	@PutMapping(value = "{spId}",consumes= {"application/json"},produces= {"application/json"})
	public ServiceProvider updatePaymentServiceProvider(@RequestBody ServiceProvider sp,@PathVariable Long spId) {
		
		return spService.updateSp(sp, spId);
	}
	
	//Delete ServiceProvider
	@DeleteMapping(value = "{spId}",produces= {"application/json","application/xml"})
	public Map<String, String> deleteServiceProvider(@PathVariable Long spId) {
		Map<String, String> result = new HashMap<>();
		
		result.put("Status", "Delete Fail");
		if (spService.deleteEmployee(spId)) {
			result.put("Status", "Delete Successful");
		}	
		return result;
	}
	
	@GetMapping(value = "{spCode}/spCode",produces= {"application/json","application/xml"})
	public ServiceProvider getServiceProviderByPspCode(@PathVariable String spCode)
	{
		return spService.getSpByCode(spCode);
	}
}
