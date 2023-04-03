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
public class TransactionHistory {
	private String date;
	private Float transactionAmount;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Float getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(Float transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	@Override
	public String toString() {
		return "TransactionHistory [date=" + date + ", transactionAmount=" + transactionAmount + "]";
	}
}
