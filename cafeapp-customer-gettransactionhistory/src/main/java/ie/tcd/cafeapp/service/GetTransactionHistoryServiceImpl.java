package ie.tcd.cafeapp.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ie.tcd.cafeapp.collection.Customer;
import ie.tcd.cafeapp.collection.ResponsePojo;
import ie.tcd.cafeapp.repository.GetTransactionRepository;

@Service
public class GetTransactionHistoryServiceImpl implements GetTransactionHistoryService 
{

	@Autowired
	private GetTransactionRepository getTransactionHistoryRepository;
	
	
	@Override
	public ResponsePojo getTransactionHistory(Map<String, String> headers) 
	{
		ResponsePojo response = new ResponsePojo();

		if(headers.get("session-id") == null || headers.get("session-id").isEmpty())
		{
			response.setResponseMessage("Invalid Details. Session-id cannot be empty. To get seesion-id, please login into the app");
			return response;
		}

		List<Customer> opCustomer = getTransactionHistoryRepository.findBySessionDetails(headers.get("session-id"));
		
		if(opCustomer != null && !opCustomer.isEmpty())
		{
			Customer customer = opCustomer.get(0);

			if(!headers.get("session-id").equals(customer.getSessionDetails().getSessionId()))
			{
				response.setResponseMessage("Invalid session-id. To get seesion-id, please login into the app");
				return response;
			}
			
			response.setResponseMessage("Transaction History fetched successfully");
			response.setMembershipId(customer.getMembershipId());
			
			response.setTransactionHistory(customer.getTransactionHistory());
			
			response.setUsername(customer.getLoginCredentials().getUsername());
			
			return response;

		}
		else
		{
			response.setResponseMessage("No session found for this user. To get seesion-id, please login into the app");
			return response;
		}
		
	}

}
