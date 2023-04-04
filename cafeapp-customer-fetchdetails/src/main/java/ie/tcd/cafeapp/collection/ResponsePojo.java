package ie.tcd.cafeapp.collection;

import java.util.List;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class ResponsePojo {
	
	private String responseMessage;
	private String membershipId;
	private String firstName;
	private String lastName;
	private Integer rewardPoints;
	
	private List<TransactionHistory> transactionHistory;
	
	private List<VoucherDetails> voucher;

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

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

	public List<TransactionHistory> getTransactionHistory() {
		return transactionHistory;
	}

	public void setTransactionHistory(List<TransactionHistory> transactionHistory) {
		this.transactionHistory = transactionHistory;
	}

	public List<VoucherDetails> getVoucher() {
		return voucher;
	}

	public void setVoucher(List<VoucherDetails> voucher) {
		this.voucher = voucher;
	}

	@Override
	public String toString() {
		return "ResponsePojo [responseMessage=" + responseMessage + ", membershipId=" + membershipId + ", firstName="
				+ firstName + ", lastName=" + lastName + ", rewardPoints=" + rewardPoints + ", transactionHistory="
				+ transactionHistory + ", voucher=" + voucher + "]";
	}

}
