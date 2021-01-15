package com.webbutik.dataacces;

import org.springframework.dao.DataIntegrityViolationException;

import com.webbutik.domain.ModelOfCar;

/**
 * @author danijela interface satter metoder for implementation
 */
public interface ModelOfCarDataAccess {
	/**
	 * Skriver en ny model av bil i tabel modelOfCar
	 * 
	 * @param moc en model av bil
	 * @throws CarFoundException Om model finns i tabell modelOfCar kastar metoden
	 *                           exception
	 */
	public void insert(ModelOfCar moc) throws CarFoundException;

	/**
	 * Radera en model av bil fran modelOfCar tabel
	 * 
	 * @param modelName namn av model av bil
	 * @throws CarNotFoundException  Throws exception om model of car                                         finns inte i tabell
	 * @throws DataIntegrityViolationException händer om man vill ta bort en model från modelOfCar tabell
	 * och den modelen fortfarande finns i tabell car
	 */
	public void remove(String modelName) throws CarNotFoundException;

	/**
	 * Hittar en model av car,dvs hittar extra information av en model av bil
	 * 
	 * @param modelName namn av model av bil
	 * @return en model av bil
	 * @throws CarNotFoundException Throws exception om model of car finns inte i
	 *                              tabell
	 */
	public ModelOfCar findByModel(String modelName) throws CarNotFoundException;;

}
