package com.webbutik.services;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.webbutik.domain.Car;

/**
 * 
 * @author danijela
 * Implementation av AccountService interface
 *
 */
@Transactional
@Component
public class AccountImplementation implements AccountService {

	/**
	 * Ger en bil som ar köpt eller hyrad
	 */
	@Override
	public void giveAccount(Car buyedCar) {
		System.out.println("Implatation giveAccount " + buyedCar);
	}
}
