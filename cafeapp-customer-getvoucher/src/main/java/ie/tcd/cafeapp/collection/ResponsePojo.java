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
	private Integer rewardPoints;
	private List<VoucherDetails> voucher;
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

	public Integer getRewardPoints() {
		return rewardPoints;
	}

	public void setRewardPoints(Integer rewardPoints) {
		this.rewardPoints = rewardPoints;
	}

	public List<VoucherDetails> getVoucher() {
		return voucher;
	}

	public void setVoucher(List<VoucherDetails> voucher) {
		this.voucher = voucher;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "ResponsePojo [responseMessage=" + responseMessage + ", membershipId=" + membershipId + ", rewardPoints="
				+ rewardPoints + ", voucher=" + voucher + ", username=" + username + "]";
	}

}
