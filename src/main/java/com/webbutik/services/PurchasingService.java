package com.webbutik.services;

/**
 * 
 * @author danijela interface satter metoder for implementation
 */
public interface PurchasingService {

	/**
	 * 
	 * @param regNum Registration nummer av bil som ar kopt
	 * @throws CarNotFound Om bil finns inte i tabell kastar metoden exception
	 */
	public void buyCar(String regNum) throws CarNotFound;

	/**
	 * 
	 * @param regNum Registration nummer av bil som ar kopt
	 * @throws CarNotFound Om bil finns inte i tabell kastar metoden exception
	 */
	public void hyraCar(String regNum) throws CarNotFound;

}
