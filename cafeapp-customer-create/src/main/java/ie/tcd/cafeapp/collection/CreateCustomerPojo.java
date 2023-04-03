package ie.tcd.cafeapp.collection;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class CreateCustomerPojo {
	private String firstName;
	private String lastName;
	private LoginDetails loginCredentials;
	
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
	
	public LoginDetails getLoginCredentials() {
		return loginCredentials;
	}

	public void setLoginCredentials(LoginDetails loginCredentials) {
		this.loginCredentials = loginCredentials;
	}

	@Override
	public String toString() {
		return "CreateCustomerPojo [firstName=" + firstName + ", lastName="
				+ lastName + ", loginCredentials=" + loginCredentials + "]";
	}

	

}
