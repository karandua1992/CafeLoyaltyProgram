package ie.tcd.cafeapp.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ie.tcd.cafeapp.collection.AddTransactionPojo;
import ie.tcd.cafeapp.collection.Customer;
import ie.tcd.cafeapp.collection.ResponsePojo;
import ie.tcd.cafeapp.collection.TransactionHistory;
import ie.tcd.cafeapp.repository.UpdateTransactionRepository;

@Service
public class UpdateTransactionServiceImpl implements UpdateTransactionService 
{
	
	@Autowired
	private UpdateTransactionRepository updateTransactionRepository;
	
	@Override
	public ResponsePojo updateTransaction(AddTransactionPojo transactionDetails, Map<String, String> headers) 
	{
		ResponsePojo response = new ResponsePojo();

		if(headers.get("session-id") == null || headers.get("session-id").isEmpty())
		{
			response.setResponseMessage("Invalid Details. Session-id cannot be empty. To get seesion-id, please login into the app");
			return response;
		}

		Float txnAmount = transactionDetails.getTransactionAmount();
		if(txnAmount == null || txnAmount.isNaN() || txnAmount == 0.0)
		{
			response.setResponseMessage("Invalid Details. Transaction amount cannot be null or empty or zero.");
			return response;
		}
		
		List<Customer> opCustomer = updateTransactionRepository.findBySessionDetails(headers.get("session-id"));
		
		if(opCustomer != null && !opCustomer.isEmpty())
		{
			Customer customer = opCustomer.get(0);
			
			if(!headers.get("session-id").equals(customer.getSessionDetails().getSessionId()))
			{
				response.setResponseMessage("Invalid session-id. To get seesion-id, please login into the app");
				return response;
			}
			
			Integer currentRewardsPoints = customer.getRewardPoints();
			
			Integer newRewardsPoints = txnAmount.intValue()/10;
			
			Integer updatedRewardPoints = currentRewardsPoints + newRewardsPoints;
			
			customer.setRewardPoints(updatedRewardPoints);
			
			TransactionHistory currentTxn = new TransactionHistory();
			currentTxn.setDate(LocalDateTime.now().toString());
			currentTxn.setTransactionAmount(txnAmount);
			
			List<TransactionHistory> txnHist = customer.getTransactionHistory();
			if(txnHist == null)
			{
				System.out.println("Inside here");
				txnHist = new ArrayList<TransactionHistory>();
			}
			
			txnHist.add(currentTxn);
			
			customer.setTransactionHistory(txnHist);
			updateTransactionRepository.save(customer);

			response.setResponseMessage("Transaction updated successfully.");
			
			response.setEarnedRewardPoints(newRewardsPoints);
			response.setRewardPointBalance(updatedRewardPoints);
			return response;
		}
		else
		{
			response.setResponseMessage("User not found");
			return response;
		}

	}

}
