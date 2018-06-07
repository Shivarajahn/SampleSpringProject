/**
 * 
 */
package com.sample.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.model.service.CarrierService;
import com.sample.model.Carriers;
import com.sample.model.Response;
import com.sample.utils.Status;


/**
 * @author Indushree
 *
 */
@RestController
@RequestMapping("/sample")
public class MainController {
	
	@Autowired
	private CarrierService  carrierService;
	
	@Autowired
	MessageSource messageSource;

	private   Locale locale = LocaleContextHolder.getLocale();

	
	@Bean
	private Response getResponse() {
		return new Response();
	}

	private String getMessage(String message) {
		// TODO Auto-generated method stub
		return messageSource.getMessage(message, null, locale );
	}
	
	@GetMapping("/carriers")
	public  ResponseEntity<?> getCarriers(){
		List<Carriers>  carrierList = carrierService.getAllCarriers();
		if(carrierList.isEmpty())
		{
			Response response = getResponse();
			response.setCode(getMessage("contractTypeRef.error.code"));
			response.setMessage(Status.Failed.toString());
			response.setDescription(getMessage("contractTypeRef.error.desc"));
			return new ResponseEntity<>(response, HttpStatus.OK);
			
		}
		return new ResponseEntity<>(carrierList, HttpStatus.OK);
	}
	
	@GetMapping("/carriersById")
	public  ResponseEntity<?> getCarriersById(@RequestParam String id){
		List<Carriers> carrierList = carrierService.getCarrierByid(id);
		if(carrierList.isEmpty())
		{
			Response response = getResponse();
			response.setCode(getMessage("contractTypeRef.error.code"));
			response.setMessage(Status.Failed.toString());
			response.setDescription(getMessage("contractTypeRef.error.desc"));
			return new ResponseEntity<>(response, HttpStatus.OK);
			
		}
		return new ResponseEntity<>(carrierList, HttpStatus.OK);
	}
	
	@GetMapping("/carriersByName/{status}")
	public  ResponseEntity<?> getCarriersByName(@PathVariable String status){
		List<Carriers>  carrierList = carrierService.getCarriersByName(status);
		if(carrierList.isEmpty())
		{
			Response response = getResponse();
			response.setCode(getMessage("contractTypeRef.error.code"));
			response.setMessage(Status.Failed.toString());
			response.setDescription(getMessage("contractTypeRef.error.desc"));
			return new ResponseEntity<>(response, HttpStatus.OK);
			
		}
		return new ResponseEntity<>(carrierList, HttpStatus.OK);
	}




	
	 
 

}
