package ie.tcd.cafeapp.service;

import ie.tcd.cafeapp.collection.CredentialsPojo;

public interface LoginService {

	public String validateCredentials(CredentialsPojo credentials);

}
