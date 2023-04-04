package ie.tcd.cafeapp.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ie.tcd.cafeapp.service.FetchDetailsService;


@RestController
@RequestMapping("/cafeapp")
public class FetchDetailsController 
{
	@Autowired
	private  FetchDetailsService fetchDetailsService;
	
	@PostMapping("/fetchdetails")
	public ResponseEntity<?> fetchDetails(@RequestHeader Map<String, String> headers)
	{
		return ResponseEntity.ok(fetchDetailsService.getCustomerDetails(headers));
	}

}
