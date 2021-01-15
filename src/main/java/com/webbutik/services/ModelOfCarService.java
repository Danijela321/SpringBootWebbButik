package com.webbutik.services;

import com.webbutik.domain.ModelOfCar;

/**
 * 
 * @author danijela interface satter metoder for implementation
 */
public interface ModelOfCarService {
	/**
	 * Skapar en ny model av bil i tabell modelOfCar
	 * 
	 * @param moc Model av bil
	 * @throws CarExist Om model finns i tabell modelOfCar kastar metoden exception
	 */
	public void addMOdelOfCar(ModelOfCar moc) throws CarExist;

	/**
	 * Raderar en model av bil i tabell modelOfCar pga id
	 * 
	 * @param modelName t.ex Clio, Focus...
	 * @throws CarNotFound Throws exception om modelOfCar finns inte i tabel
	 * 
	 */
	public void removeModelOvCar(String modelName) throws CarNotFound;

	/**
	 * 
	 * Hamta en model av bil pga models namn
	 * 
	 * @param model Namn av bils model
	 * @return en model av bil
	 * @throws CarNotFound Throws exception om modelOfCar finns inte i tabel
	 */
	public ModelOfCar getModelOfCar(String model) throws CarNotFound;
}
