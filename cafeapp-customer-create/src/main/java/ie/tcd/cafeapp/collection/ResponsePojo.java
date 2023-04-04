package ie.tcd.cafeapp.collection;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class ResponsePojo {
	private String responseMessage;
	
	public String getResponseMessage() {
		return responseMessage;
	}
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	@Override
	public String toString() {
		return "ResponsePojo [responseMessage=" + responseMessage + "]";
	}
}
