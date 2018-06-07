package com.model.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.dao.CarrierDao;
import com.sample.model.Carriers;

@Service
public class CarrierServiceImpl implements CarrierService {
	
	@Autowired
	CarrierDao carrierDao;

	@Override
	public List<Carriers> getAllCarriers() {
		return carrierDao.findAll();
	}

	@Override
	public List<Carriers> getCarrierByid(String id) {
		Optional<Carriers> carriOptional =  carrierDao.findById(id);
		return toList(carriOptional);
		
	}
	
	private  List<Carriers> toList(Optional<Carriers> option) {
	    if (option.isPresent())
	        return Collections.singletonList(option.get());
	    else
	        return Collections.emptyList();
	}

	@Override
	public List<Carriers> getCarriersByName(String status) {
		return carrierDao.findByStatus(status);
	}

}
