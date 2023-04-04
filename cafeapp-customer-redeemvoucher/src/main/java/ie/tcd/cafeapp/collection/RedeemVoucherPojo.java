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
public class RedeemVoucherPojo {
	
	private Double transactionAmount;
	private String voucherCode;
	public Double getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(Double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public String getVoucherCode() {
		return voucherCode;
	}
	public void setVoucherCode(String voucherCode) {
		this.voucherCode = voucherCode;
	}
	@Override
	public String toString() {
		return "RedeemVoucherPojo [transactionAmount=" + transactionAmount + ", voucherCode=" + voucherCode + "]";
	}
}
