package ie.tcd.cafeapp.service;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ie.tcd.cafeapp.collection.Customer;
import ie.tcd.cafeapp.collection.RedeemVoucherPojo;
import ie.tcd.cafeapp.collection.ResponsePojo;
import ie.tcd.cafeapp.collection.VoucherDetails;
import ie.tcd.cafeapp.repository.RedeemVoucherRepository;

@Service
public class RedeemVoucherServiceImpl implements RedeemVoucherService {

	@Autowired
	private RedeemVoucherRepository redeemVocuherRepository;
	
	@Override
	public ResponsePojo redeemVoucher(RedeemVoucherPojo transactionDetails, Map<String, String> headers) 
	{
	
		ResponsePojo response = new ResponsePojo();

		if(headers.get("session-id") == null || headers.get("session-id").isEmpty())
		{
			response.setResponseMessage("Invalid Details. Session-id cannot be empty. To get seesion-id, please login into the app");
			response.setFinalBalanceAmount(transactionDetails.getTransactionAmount());
			return response;
		}
		
		if(transactionDetails.getTransactionAmount() == null)
		{
			response.setResponseMessage("Invalid Details. Transaction amount cannot be empty.");
			response.setFinalBalanceAmount(transactionDetails.getTransactionAmount());
			return response;
		}
		else if(transactionDetails.getTransactionAmount() == 0)
		{
			response.setResponseMessage("Invalid Details. Transaction amount cannot be 0.");
			response.setFinalBalanceAmount(transactionDetails.getTransactionAmount());
			return response;
		}
		
		if(transactionDetails.getVoucherCode() == null || transactionDetails.getVoucherCode().isEmpty())
		{
			response.setResponseMessage("Invalid Details. Vocuher code cannot be empty.");
			response.setFinalBalanceAmount(transactionDetails.getTransactionAmount());
			return response;
		}

		List<Customer> opCustomer = redeemVocuherRepository.findBySessionDetails(headers.get("session-id"));
		
		if(opCustomer != null && !opCustomer.isEmpty())
		{
			Customer customer = opCustomer.get(0);
			
			if(!headers.get("session-id").equals(customer.getSessionDetails().getSessionId()))
			{
				response.setResponseMessage("Invalid session-id. To get seesion-id, please login into the app");
				response.setFinalBalanceAmount(transactionDetails.getTransactionAmount());
				return response;
			}
			
			if(customer.getVoucher() == null || customer.getVoucher().isEmpty())
			{
				response.setResponseMessage("Customer does not have a voucher.");
				response.setFinalBalanceAmount(transactionDetails.getTransactionAmount());
				return response;
			}
			
			boolean voucherFound = false;
			String voucherCode = "";
			String validTill = "";
			Double voucherAmount = 0.0;
			for(VoucherDetails voucher : customer.getVoucher())
			{
				if(voucher.getVoucherCode() != null && voucher.getVoucherCode().equals(transactionDetails.getVoucherCode()))
				{
					voucherFound = true;
					voucherCode = voucher.getVoucherCode();
					validTill = voucher.getValidTill();
					voucherAmount = voucher.getVoucherAmount();
					break;
				}
			}
			
			if(voucherFound)
			{
				if(voucherAmount >= transactionDetails.getTransactionAmount())
				{
					response.setResponseMessage("Voucher amount is greater than or equal to billing amount. Please try a differet voucher.");
					response.setFinalBalanceAmount(transactionDetails.getTransactionAmount());
					return response;
				}
				
				LocalDateTime voucherExpiryDate = LocalDateTime.parse(validTill);

				if(LocalDateTime.now().isAfter(voucherExpiryDate))
				{
					response.setResponseMessage("This voucher has expired. Please try a differet voucher.");
					response.setFinalBalanceAmount(transactionDetails.getTransactionAmount());
					return response;
				}
				
				Double remainingBalance = transactionDetails.getTransactionAmount() - voucherAmount;
				
				Iterator<VoucherDetails> itr = customer.getVoucher().iterator();
				
				while(itr.hasNext())
				{
					if(voucherCode.equals(itr.next().getVoucherCode()))
					{
						itr.remove();
					}
				}
				
				redeemVocuherRepository.save(customer);
				response.setFinalBalanceAmount(remainingBalance);
				response.setResponseMessage("Voucher has been successfully applied.");
				return response;
			}
			else
			{
				response.setResponseMessage("This is not a valid voucher. Please check vocuher details and try again.");
				response.setFinalBalanceAmount(transactionDetails.getTransactionAmount());
				return response;
			}
			
		}
		else
		{
			response.setResponseMessage("No session found for this user. To get seesion-id, please login into the app");
			return response;
		}

	
	}

}
