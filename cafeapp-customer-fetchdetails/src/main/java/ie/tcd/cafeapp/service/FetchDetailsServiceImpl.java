package ie.tcd.cafeapp.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ie.tcd.cafeapp.collection.Customer;
import ie.tcd.cafeapp.collection.ResponsePojo;
import ie.tcd.cafeapp.repository.FetchDetailsRepository;

@Service
public class FetchDetailsServiceImpl implements FetchDetailsService {

	@Autowired
	private FetchDetailsRepository fetchDetailsRepository;

	public ResponsePojo getCustomerDetails(Map<String, String> headers) 
	{
		ResponsePojo response = new ResponsePojo();
		
		if(headers.get("session-id") == null || headers.get("session-id").isEmpty())
		{
			response.setResponseMessage("Invalid Details. Session-id cannot be empty. To get seesion-id, please login into the app");
			return response;
		}
		
		List<Customer> opCustomer = fetchDetailsRepository.findBySessionDetails(headers.get("session-id"));
		
		if(opCustomer != null && !opCustomer.isEmpty())
		{
			Customer customer = opCustomer.get(0);
			
			if(!headers.get("session-id").equals(customer.getSessionDetails().getSessionId()))
			{
				response.setResponseMessage("Invalid session-id. To get seesion-id, please login into the app");
				return response;
			}
			
			response.setFirstName(customer.getFirstName());
			response.setLastName(customer.getLastName());
			response.setMembershipId(customer.getMembershipId());
			response.setResponseMessage("Customer Details fetched successfully");
			response.setRewardPoints(customer.getRewardPoints());
			response.setTransactionHistory(customer.getTransactionHistory());
			response.setVoucher(customer.getVoucher());
			
			return response;
			
		}
		else
		{
			response.setResponseMessage("User not found");
			return response;
		}
	}

}
