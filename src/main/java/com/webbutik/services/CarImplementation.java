package com.webbutik.services;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webbutik.domain.Car;

import com.webbutik.dataacces.CarDataAccess;
import com.webbutik.dataacces.CarFoundException;
import com.webbutik.dataacces.CarNotFoundException;

/**
 * 
 * @author danijela 
 * Implementation av CarService
 *
 */

@Transactional
@Service("carService")
public class CarImplementation implements CarService {

	/**
	 * Egenskap constructor arg
	 */
	@Autowired
	private CarDataAccess dao;

	/**
	 * Metoden skickar en ny bil till CarDataAccess/CarDataAccessProductionVersion
	 * for att skapar en ny bil i tabel
	 * @throws CarExist Kastar exception om bil finns i tabell car
	 */
	@Override
	public void addCar(Car car) throws CarExist {
		
			try {
				
				dao.insert(car);
			} catch (CarFoundException e) {
				throw new CarExist();
			}
	
	}

	/**
	 * Metoden skickar en id av bil som finns i databas till
	 * CarDataAccess/CarDataAccessProductionVersion for att radera en sepcifick bil
	 * pga id Om car finns inte i databasen kastar programmet Exception
	 * 
	 * @throws CarNotFound Throws exception om car finns inte i i tabel
	 */
	@Override
	public void removeCarByID(int id) throws CarNotFound {

		try {
			dao.remove(id);
		} catch (CarNotFoundException e) {
			throw new CarNotFound();
		}
	}

	/**
	 * Metoden skickar registration numer av en bill till
	 * CarDataAccess/CarDataAccessProductionVersion for att radera denna bil Om car
	 * finns inte i databasen kastar programmet Exception
	 * 
	 * @throws CarNotFound Throws exception om car finns inte i i tabel
	 */
	@Override
	public void removeCarByRegNr(String regNr) throws CarNotFound {
		try {
			dao.removeByRegNr(regNr);
		} catch (CarNotFoundException e) {
			throw new CarNotFound();
		}
	}

	/**
	 * Metoden skickar en bil och nya pris till
	 * CarDataAccess/CarDataAccessProductionVersion for att uppdatera bils pris Om
	 * car finns inte i databasen kastar programmet Exception
	 * 
	 * @throws CarNotFound Throws exception om car finns inte i i tabel
	 */
	@Override
	public void updatePrice(Car car, int price) throws CarNotFound {
		try {
			dao.updatePrice(car, price);
		} catch (CarNotFoundException e) {
			throw new CarNotFound();
		}
	}

	/**
	 * Metoden skickar en bil och antal av kilometer till
	 * CarDataAccess/CarDataAccessProductionVersion for att uppdatera antal av
	 * kilometer som en bil har kort Om car finns inte i databasen kastar programmet
	 * Exception
	 * 
	 * @throws CarNotFound Throws exception om car finns inte i i tabel
	 */
	@Override
	public void updateKilometer(Car car, int kilometer) throws CarNotFound {
		try {
			dao.updateKilometer(car, kilometer);
		} catch (CarNotFoundException e) {
			throw new CarNotFound();
		}
	}

	/**
	 * Metoden skickar en bil och status ar bilen ny eller ej
	 * CarDataAccess/CarDataAccessProductionVersion for att uppdatera status. Om car
	 * finns inte i databasen kastar programmet Exception
	 * 
	 * @throws CarNotFound Throws exception om car finns inte i i tabel
	 */
	@Override
	public void updateIsNew(Car car, boolean isNew) throws CarNotFound {
		try {
			dao.updateIsNew(car, isNew);
		} catch (CarNotFoundException e) {
			throw new CarNotFound();
		}
	}

	/**
	 * Metoden skikcar en bil osh status kan man hyra ut en bil eller ej
	 * CarDataAccess/CarDataAccessProductionVersion for att uppdatera status Om car
	 * finns inte i databasen kastar programmet Exception
	 * 
	 * @throws CarNotFound Throws exception om car finns inte i i tabel
	 */
	@Override
	public void updateIsRentable(Car car, boolean isRentable) throws CarNotFound {
		try {
			dao.updateIsRentable(car, isRentable);
		} catch (CarNotFoundException e) {
			throw new CarNotFound();
		}
	}

	/**
	 * Metoden skickar id av bil som finns i databas till
	 * CarDataAccess/CarDataAccessProductionVersion for att hamta denna bil *Om car
	 * finns inte i databasen kastar programmet Exception
	 * 
	 * @throws CarNotFound Throws exception om car finns inte i i tabel
	 */
	@Override
	public Car getCarById(int id) throws CarNotFound {
		try {
			return dao.findById(id);
		} catch (CarNotFoundException e) {
			throw new CarNotFound();
		}
	}

	/**
	 * Metoden skickar registration nummer av bil som finns i databas till
	 * CarDataAccess/CarDataAccessProductionVersion for att hamta denna bil Om car
	 * finns inte i databasen kastar programmet Exception
	 * 
	 * @throws CarNotFound Throws exception om car finns inte i i tabel
	 */
	@Override
	public Car getCarByRegNr(String regNr) throws CarNotFound {
		try {
			return dao.findByRegNr(regNr);
		} catch (CarNotFoundException e) {
			throw new CarNotFound();
		}
	}

	/**
	 * Hamtar alla bilar som finns i i tabel
	 * @throws CarNotFound Om bil finns inte i tabell kastar metoden exception
	 */
	@Override
	public List<Car> getAllCars() throws CarNotFound {
		try {
			return dao.findAll();
		} catch (CarNotFoundException e) {
			throw new CarNotFound();
		}
	}

	/**
	 * Hamtar alla bilar av samma brand
	 * @throws CarNotFound Om bil finns inte i tabell kastar metoden exception
	 */
	@Override
	public List<Car> getAllByBrand(String brand) throws CarNotFound {
		//return dao.findByBrand(brand);
		
		try {
			return dao.findByBrand(brand);
		} catch (CarNotFoundException e) {
			throw new CarNotFound();
		}
	}

	/**
	 * Hamtar alla bilar av samma brand och model
	 * @throws CarNotFound Om bil finns inte i tabell kastar metoden exception
	 */
	@Override
	public List<Car> getAllByBrandAndModel(String brand, String model) throws CarNotFound {
		try {
			return dao.findByBrandAndModel(brand, model);
		} catch (CarNotFoundException e) {
			throw new CarNotFound();
		}
	}

	/**
	 * Hamtar alla bilar som ar billigare an atravard pris
	 * @throws CarNotFound  Om bil finns inte i tabell kastar metoden exception
	 */
	@Override
	public List<Car> getAllBelowPrice(int price) throws CarNotFound {
		try {
			return dao.findBelowPrice(price);
		} catch (CarNotFoundException e) {
			throw new CarNotFound();
		}
	}

	/**
	 * Hamtar alla bilar som har kilometer under atravard kilometer
	 * @throws CarNotFound Om bil finns inte i tabell kastar metoden exception
	 */
	@Override
	public List<Car> getAllBelowKilometer(int price) throws CarNotFound {
		try {
			return dao.findBelowKilometer(price);
		} catch (CarNotFoundException e) {
			throw new CarNotFound();
		}
	}

	/**
	 * Hamtar alla automatika eller ej automatika bilar.
	 * @throws CarNotFound Om bil finns inte i tabell kastar metoden exception
	 */
	@Override
	public List<Car> getAllAutomatic(boolean isAutomatic) throws CarNotFound {
		try {
			return dao.findByAutomatic(isAutomatic);
		} catch (CarNotFoundException e) {
			throw new CarNotFound();
		}
	}

	/**
	 * Hamta alla bilar som man kan hyra ut.
	 * @throws CarNotFound Om bil finns inte i tabell kastar metoden exception
	 */
	@Override
	public List<Car> getAllRentable(boolean isRentable) throws CarNotFound {
		try {
			return dao.findByRentable(isRentable);
		} catch (CarNotFoundException e) {
			throw new CarNotFound();
		}
	}

	/**
	 * Hamtar alla bilar som har navigation
	 * @throws CarNotFound Om bil finns inte i tabell kastar metoden exception
	 */
	@Override
	public List<Car> getAllWithNavigation(boolean hasNavigation) throws CarNotFound {
		try {
			return dao.findByNavigation(hasNavigation);
		} catch (CarNotFoundException e) {
			throw new CarNotFound();
		}
	}

	/**
	 * Hamtar alla nya bilar
	 * @throws CarNotFound Om bil finns inte i tabell kastar metoden exception
	 */
	@Override
	public List<Car> getAllNewCars(boolean isNew) throws CarNotFound {
		try {
			return dao.findByNew(isNew);
		} catch (CarNotFoundException e) {
			throw new CarNotFound();
		}
	}

	/**
	 * Hamtar alla bilar pga fuel
	 * @throws CarNotFound Om bil finns inte i tabell kastar metoden exception
	 */
	@Override
	public List<Car> getAllCarByFuel(String fuel) throws CarNotFound {
		// TODO Auto-generated method stub
		try {
			return dao.getAllCarByFuel(fuel);
		} catch (CarNotFoundException e) {
			throw new CarNotFound();
		}
	}

	/**
	 * Hamtar alla bilar som ar samma brand och anvander samma fuel
	 * @throws CarNotFound Om bil finns inte i tabell kastar metoden exception
	 */
	@Override
	public List<Car> getAllCarByBrandAndFuel(String brand, String fuel) throws CarNotFound {
		// TODO Auto-generated method stub
		try {
			return dao.getAllCarByBrandAndFuel(brand, fuel);
		} catch (CarNotFoundException e) {
			throw new CarNotFound();
		}
	}

	/**
	 * Hamtar alla bilar som ar samma brand och model samt anvander de samma fuel
	 * @throws CarNotFound Om bil finns inte i tabell kastar metoden exception
	 */
	@Override
	public List<Car> getAllCarByBrandAndModelAndFuel(String brand, String model, String fuel) throws CarNotFound {
		// TODO Auto-generated method stub
		try {
			return dao.getAllCarByBrandAndModelAndFuel(brand, model, fuel);
		} catch (CarNotFoundException e) {
			throw new CarNotFound();
		}
	}

	/**
	 * Hamtar alla bilar som är gjord samma ar
	 * @throws CarNotFound Om bil finns inte i tabell kastar metoden exception
	 */
	@Override
	public List<Car> getAllCarByYear(int year) throws CarNotFound {
		// TODO Auto-generated method stub
		try {
			return dao.getAllCarByYear(year);
		} catch (CarNotFoundException e) {
			throw new CarNotFound();
		}
	}

}
