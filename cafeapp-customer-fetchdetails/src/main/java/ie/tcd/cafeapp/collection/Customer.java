package ie.tcd.cafeapp.collection;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@Document(collection = "customer")
@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString
public class Customer {
	@Id
	private String membershipId;
	private String firstName;
	private String lastName;
	private Integer rewardPoints;
	
	private LoginDetails loginCredentials;
	
	private List<TransactionHistory> transactionHistory;
	
	private List<VoucherDetails> voucher;

	private Session sessionDetails;
	
	public String getMembershipId() {
		return membershipId;
	}

	public void setMembershipId(String membershipId) {
		this.membershipId = membershipId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getRewardPoints() {
		return rewardPoints;
	}

	public void setRewardPoints(Integer rewardPoints) {
		this.rewardPoints = rewardPoints;
	}

	public LoginDetails getLoginCredentials() {
		return loginCredentials;
	}

	public void setLoginCredentials(LoginDetails loginCredentials) {
		this.loginCredentials = loginCredentials;
	}

	public List<TransactionHistory> getTransactionHistory() {
		return transactionHistory;
	}

	public void setTransactionHistory(List<TransactionHistory> transactionHistory) {
		this.transactionHistory = transactionHistory;
	}

	public Session getSessionDetails() {
		return sessionDetails;
	}

	public void setSessionDetails(Session sessionDetails) {
		this.sessionDetails = sessionDetails;
	}

	public List<VoucherDetails> getVoucher() {
		return voucher;
	}

	public void setVoucher(List<VoucherDetails> voucher) {
		this.voucher = voucher;
	}

	@Override
	public String toString() {
		return "Customer [membershipId=" + membershipId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", rewardPoints=" + rewardPoints + ", loginCredentials=" + loginCredentials + ", transactionHistory="
				+ transactionHistory + ", voucher=" + voucher + ", sessionDetails=" + sessionDetails + "]";
	}

}
