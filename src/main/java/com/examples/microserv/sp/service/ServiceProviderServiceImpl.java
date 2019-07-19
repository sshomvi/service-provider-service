package com.examples.microserv.sp.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examples.microserv.sp.model.ServiceProvider;
import com.examples.microserv.sp.repository.ServiceProviderRepository;

@Service
public class ServiceProviderServiceImpl implements ServiceProviderService {

	@Autowired
    private ServiceProviderRepository spRepository;
 
	private static Logger log = LoggerFactory.getLogger(ServiceProviderServiceImpl.class);

    @Override
	public List<ServiceProvider> getAllSps() {

		List<ServiceProvider> Sps = new ArrayList<>();

		try {
			Sps = spRepository.findAll();
		} catch (Exception e) {
			log.error("", e);
		}

		return Sps;
	}
 
    @Override
	public ServiceProvider createOrSaveSp(ServiceProvider Sp) {

		try {
			return spRepository.save(Sp);
		} catch (Exception e) {
			log.error("", e);
		}

		return Sp;
	}
 
    @Override
	public ServiceProvider getSpById(Long id) {

		ServiceProvider foundSp = new ServiceProvider();

		try {
			foundSp = spRepository.findById(id).get();
		} catch (Exception e) {
			log.error("", e);
		}

		return foundSp;
	}
    
    @Override
    public ServiceProvider updateSp(ServiceProvider sp, Long id) {
        	
    	return spRepository.findById(id).map(spFound -> {  	      	
			spFound.setActive(sp.getActive()); 
			spFound.setSpCode(sp.getSpCode());
			spFound.setSpDescription(sp.getSpDescription());
			spFound.setSpShortname(sp.getSpShortname());
			return spRepository.save(spFound);           
        }).orElseGet(() -> {
        	sp.setId(id);
        	return spRepository.save(sp);
        });
    	
    }

    @Override
	public Boolean deleteEmployee(Long id) {

		Boolean isSuccessful = false;

		try {
			spRepository.deleteById(id);
			isSuccessful = true;
		} catch (Exception e) {
			log.error("", e);
		}

		return isSuccessful;

	}
    
    @Override
	public ServiceProvider getSpByCode(String SpCode) {
		ServiceProvider foundSp = new ServiceProvider();

		try {
			foundSp = spRepository.findBySpCode(SpCode);
		} catch (Exception e) {
			log.error("", e);
		}

		return foundSp;
	}
	
}
