package ie.tcd.cafeapp.collection;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Builder
@Getter
@Setter
@ToString
public class AddTransactionPojo {
	
	private Float transactionAmount;
	
	public Float getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(Float transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	@Override
	public String toString() {
		return "AddTransactionPojo [transactionAmount=" + transactionAmount + "]";
	}
	
	
}
