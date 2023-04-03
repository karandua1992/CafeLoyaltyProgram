package ie.tcd.cafeapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ie.tcd.cafeapp.collection.CreateCustomerPojo;
import ie.tcd.cafeapp.collection.Customer;
import ie.tcd.cafeapp.collection.LoginDetails;
import ie.tcd.cafeapp.repository.CustomerRepository;

@Service
public class CreateCustomerServiceImpl implements CreateCustomerService 
{
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public String createCustomer(CreateCustomerPojo customer) 
	{
		Customer newCustomer = new Customer();
		LoginDetails credentials = new LoginDetails();
		
		
		
		if(customer == null)
		{
			return "Invalid Details. Mandatory paramteres are empty";
		}
		
		if(checkUsernameExists(customer))
		{
			return "Invalid Details. Username already exists";
		}
		
		if(customer.getFirstName() != null && !customer.getFirstName().isEmpty())
		{
			newCustomer.setFirstName(customer.getFirstName());
		}
		else
		{
			return "Invalid Details. First name cannot be empty";
		}
		
		if(customer.getLastName() != null && !customer.getLastName().isEmpty())
		{
			newCustomer.setLastName(customer.getLastName());
		}
		
		
		if(customer.getLoginCredentials() != null && customer.getLoginCredentials().getUsername() != null && !customer.getLoginCredentials().getUsername().isEmpty())
		{
			credentials.setUsername(customer.getLoginCredentials().getUsername());
		}
		else
		{
			return "Invalid Details. Username cannot be empty";
		}
		
		if(customer.getLoginCredentials() != null && customer.getLoginCredentials().getPassword() != null && !customer.getLoginCredentials().getPassword().isEmpty())
		{
			credentials.setPassword(customer.getLoginCredentials().getPassword());
		}
		else
		{
			return "Invalid Details. Password cannot be empty";
		}
		
		
		newCustomer.setLoginCredentials(credentials);
		
		
		return customerRepository.save(newCustomer).getMembershipId();
	}

	private boolean checkUsernameExists(CreateCustomerPojo customer) 
	{
		List<Customer> allCustomers = customerRepository.findAll();
		
		if(allCustomers != null)
		{
			for(Customer custr : allCustomers)
			{
				if(custr.getLoginCredentials() != null && custr.getLoginCredentials().getUsername() != null 
						&& custr.getLoginCredentials().getUsername().equals(customer.getLoginCredentials().getUsername()))
				{
					return false;
				}
			}
			return true;
		}
		else
		{
			return true;
		}
	}

}
