package ie.tcd.cafeapp.service;

import java.util.Map;

import ie.tcd.cafeapp.collection.ResponsePojo;

public interface FetchDetailsService {

	public ResponsePojo getCustomerDetails(Map<String, String> headers);

}
