package com.model.service;

import java.util.List;

import com.sample.model.Carriers;

public interface CarrierService {
	
	List<Carriers> getAllCarriers();

	List<Carriers> getCarrierByid(String id);

	List<Carriers> getCarriersByName(String status);
	 
}
