package com.webbutik.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.webbutik.domain.Car;

/**
 * 
 * @author danijela
 * Implementation av PurchasingService interface
 
 */
@Transactional
@Component
public class PurcasingServiceImplementation implements PurchasingService {
	
	/**
	 * Egenskap
	 * forst constructor arg
	 */
	@Autowired
	private AccountService account;
	
	/**
	 * second constructor args
	 * Egenskap
	 */
	@Autowired
	private CarService car;
	
	/**
	 * Metod for koping en bil
	 * Skickar en bil som ar hamtad pga registration nummer till accountService/accountImplementation
	 * @throws CarNotFound Om bil finns inte i tabell kastar metoden exception
	 */
	@Override
	@Transactional(rollbackFor=CarNotFound.class)
	public void buyCar(String regNum) throws CarNotFound {
		Car carBuyed = car.getCarByRegNr(regNum);
		account.giveAccount(carBuyed);		
		
	}

	/**
	 * Metod for att hyra en bil
	 * * Skickar en bil som ar hamtad pga registration nummer till accountService/accountImplementation
	 * @throws CarNotFound Om bil finns inte i tabell kastar metoden exception
	 */
	@Override
	@Transactional(rollbackFor=CarNotFound.class)
	public void hyraCar(String regNum) throws CarNotFound {
		Car carHyrad = car.getCarByRegNr(regNum);
		account.giveAccount(carHyrad);
	}

}
