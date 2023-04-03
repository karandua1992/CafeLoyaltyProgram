package ie.tcd.cafeapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ie.tcd.cafeapp.collection.CreateCustomerPojo;
import ie.tcd.cafeapp.service.CreateCustomerService;

@RestController
@RequestMapping("/cafeapp")
public class CreateCustomerController 
{
	@Autowired
	private CreateCustomerService createCustomerService;
	
	@PostMapping("/create")
	public ResponseEntity<?> cutomerLogin(@RequestBody CreateCustomerPojo customer)
	{
		return ResponseEntity.ok(createCustomerService.createCustomer(customer));
	}

}
