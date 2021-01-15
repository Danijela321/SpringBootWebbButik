package com.webbutik.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webbutik.dataacces.CarFoundException;
import com.webbutik.dataacces.CarNotFoundException;
import com.webbutik.dataacces.ModelOfCarDataAccess;
import com.webbutik.domain.ModelOfCar;

/**
 * 
 * @author danijela
 * Implementation av ModelOfCar 
 *
 */
@Transactional
@Service("modelOfCarService")
public class MOdelOfCarImplementation implements ModelOfCarService {
	
	/**
	 * Egenskap 
	 * constructor arg
	 */
	@Autowired
	private ModelOfCarDataAccess dao;

	/**
	 * Skapar en ny model av bil i tabell modelOfCar
	 * @throws CarExist Om model finns i tabell modelOfCar kastar metoden exception
	 */
	@Override
	public void addMOdelOfCar(ModelOfCar moc) throws CarExist {
		try {
			dao.insert(moc);
		} catch (CarFoundException e) {
			throw new CarExist();
		}

	}
/**
 * Raderar en model av bil i tabell modelOfCar pga id
 * @throws CarNotFound Throws exception om car inte finns i tabel
 */
	@Override
	public void removeModelOvCar(String modelName) throws CarNotFound {
		try {
			dao.remove(modelName);
		} catch (CarNotFoundException e) {
			throw new CarNotFound();
		}

	}

	/**
	 * Hamta en model av bil pga models namn
	 * @throws CarNotFound Throws exception om car inte finns i tabel
	 */
	@Override
	public ModelOfCar getModelOfCar(String modelName) throws CarNotFound {		
		try {
			return dao.findByModel(modelName);
		} catch (CarNotFoundException e) {
			throw new CarNotFound();
		}
	}

}
