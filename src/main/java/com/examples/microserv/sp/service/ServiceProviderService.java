package com.examples.microserv.sp.service;


import java.util.List;

import com.examples.microserv.sp.model.ServiceProvider;

public interface ServiceProviderService {

	public List<ServiceProvider> getAllSps();

	public ServiceProvider createOrSaveSp(ServiceProvider Sp);

	public ServiceProvider getSpById(Long id);
 
	public ServiceProvider updateSp(ServiceProvider Sp, Long id);

	public Boolean deleteEmployee(Long id);

	public ServiceProvider getSpByCode(String SpCode);


}
