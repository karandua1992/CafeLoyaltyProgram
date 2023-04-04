package ie.tcd.cafeapp.collection;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class ResponsePojo {
	
	private String responseMessage;
	private String membershipId;
	private Integer remainingRewardPoints;
	private VoucherDetails generatedVoucher;
	private String username;

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

	public VoucherDetails getGeneratedVoucher() {
		return generatedVoucher;
	}

	public void setGeneratedVoucher(VoucherDetails generatedVoucher) {
		this.generatedVoucher = generatedVoucher;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getRemainingRewardPoints() {
		return remainingRewardPoints;
	}

	public void setRemainingRewardPoints(Integer remainingRewardPoints) {
		this.remainingRewardPoints = remainingRewardPoints;
	}

	@Override
	public String toString() {
		return "ResponsePojo [responseMessage=" + responseMessage + ", membershipId=" + membershipId
				+ ", remainingRewardPoints=" + remainingRewardPoints + ", generatedVoucher=" + generatedVoucher
				+ ", username=" + username + "]";
	}

}
