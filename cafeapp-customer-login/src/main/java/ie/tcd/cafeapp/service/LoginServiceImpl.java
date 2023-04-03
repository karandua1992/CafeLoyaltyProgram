package ie.tcd.cafeapp.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ie.tcd.cafeapp.collection.CredentialsPojo;
import ie.tcd.cafeapp.collection.Customer;
import ie.tcd.cafeapp.collection.Session;
import ie.tcd.cafeapp.repository.CustomerRepository;


@Service
public class LoginServiceImpl implements LoginService 
{
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public String validateCredentials(CredentialsPojo credentials) 
	{
		Optional<Customer> opCustomer = customerRepository.findById(credentials.getMembershipId());
		
		if(opCustomer.isPresent())
		{
			Customer customer = opCustomer.get();
			if(credentials.getPassword() == null || credentials.getPassword().isEmpty())
			{
				return "Invalid Credentials. Password cannot be empty";
			}
			else
			{
				if(credentials.getPassword().equals(customer.getLoginCredentials().getPassword()))
				{
					UUID uuid = UUID.randomUUID();
					Session session = new Session();
					session.setSessionId(uuid.toString());
					customer.setSessionDetails(session);
					customerRepository.save(customer);
					
					return uuid.toString();
				}
				else
				{
					return "Invalid Credentials. Password does not match";
				}
			}
		}
		else
		{
			return "User not found";
		}
	}
}
