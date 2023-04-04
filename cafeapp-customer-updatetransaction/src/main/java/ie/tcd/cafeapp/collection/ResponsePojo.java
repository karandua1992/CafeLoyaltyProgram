package ie.tcd.cafeapp.collection;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class ResponsePojo {
	private String responseMessage;
	private Integer earnedRewardPoints;
	private Integer rewardPointBalance;
	
	
	public Integer getEarnedRewardPoints() {
		return earnedRewardPoints;
	}
	public void setEarnedRewardPoints(Integer earnedRewardPoints) {
		this.earnedRewardPoints = earnedRewardPoints;
	}
	public Integer getRewardPointBalance() {
		return rewardPointBalance;
	}
	public void setRewardPointBalance(Integer rewardPointBalance) {
		this.rewardPointBalance = rewardPointBalance;
	}
	public String getResponseMessage() {
		return responseMessage;
	}
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	@Override
	public String toString() {
		return "ResponsePojo [responseMessage=" + responseMessage + ", earnedRewardPoints=" + earnedRewardPoints
				+ ", rewardPointBalance=" + rewardPointBalance + "]";
	}
	
	
}
