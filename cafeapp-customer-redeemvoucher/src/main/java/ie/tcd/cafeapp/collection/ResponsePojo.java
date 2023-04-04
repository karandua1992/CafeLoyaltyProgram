package ie.tcd.cafeapp.collection;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class ResponsePojo {
	private String responseMessage;
	private Double finalBalanceAmount;
	public String getResponseMessage() {
		return responseMessage;
	}
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	public Double getFinalBalanceAmount() {
		return finalBalanceAmount;
	}
	public void setFinalBalanceAmount(Double finalBalanceAmount) {
		this.finalBalanceAmount = finalBalanceAmount;
	}
	@Override
	public String toString() {
		return "ResponsePojo [responseMessage=" + responseMessage + ", finalBalanceAmount=" + finalBalanceAmount + "]";
	}
	
}
