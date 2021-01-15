package com.webbutik.services;

import com.webbutik.domain.Car;

/**
 * 
 * @author danijela
 * Testing
 */
public class AccountImplementationMock implements AccountService {

	@Override
	public void giveAccount(Car buyedCar) {
		System.out.println("Testing giveAccount " + buyedCar);
		
		
	}

}
