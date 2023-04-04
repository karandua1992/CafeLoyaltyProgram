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
public class VoucherDetails {
	
	private String voucherCode;
	private String validTill;
	private Double voucherAmount;
	
	public String getVoucherCode() {
		return voucherCode;
	}
	public void setVoucherCode(String voucherCode) {
		this.voucherCode = voucherCode;
	}
	public String getValidTill() {
		return validTill;
	}
	public void setValidTill(String validTill) {
		this.validTill = validTill;
	}
	public Double getVoucherAmount() {
		return voucherAmount;
	}
	public void setVoucherAmount(Double voucherAmount) {
		this.voucherAmount = voucherAmount;
	}
	@Override
	public String toString() {
		return "VoucherDetails [voucherCode=" + voucherCode + ", validTill=" + validTill + ", voucherAmount="
				+ voucherAmount + "]";
	}
}
