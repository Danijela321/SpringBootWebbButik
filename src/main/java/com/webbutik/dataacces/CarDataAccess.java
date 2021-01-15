package com.webbutik.dataacces;

import java.util.List;

import com.webbutik.domain.Car;
import com.webbutik.services.CarExist;

/**
 * 
 * @author danijela
 * interface 
 * satter metoder for implementation
 */
public interface CarDataAccess {
	/**
	 * Insert en ny bil i tabell car
	 * @param car En ny bil
	 * @throws CarFoundException Om bilen finns i tabell kastar metod exception
	 */
	//funkar
	public void insert(Car car) throws  CarFoundException;
	/**
	 * Raderar en bil fån tabell car pga id om denna bil finns i tabell annars kastar en exception
	 * @param id Id av bil i tabell
	 * @throws CarNotFoundException Throws exception om  bil finns inte i tabell
	 */
	//funkar
	public void remove(int id) throws CarNotFoundException;
	/**
	 * Raderar en bil fran tabell car pga registration nummer om denna bil finns i tabell annars kastar en exception
	 * @param regNr Registration nummer
	 * @throws CarNotFoundException Throws exception om  bil finns inte i tabell
	 */
	
	//funkar
	public void removeByRegNr(String regNr) throws CarNotFoundException;
	/**
	 * Uppdaterar pris av bilen om billen finns i tabell annars kastar en exception
	 * @param car En bil
	 * @param price Nya pris 
	 * @throws CarNotFoundException Throws exception om  bil finns inte i tabell
	 */
	//funkar
	public void updatePrice(Car car, int price) throws CarNotFoundException;
	/**
	 * Uppdaterar kilometer av bilen om billen finns i tabell annars kastar en exception
	 * @param car En bil
	 * @param kilometer Kilometer som en bil korde
	 * @throws CarNotFoundException Throws exception om  bil finns inte i tabell
	 */
	//funkar
	public void updateKilometer(Car car, int kilometer) throws CarNotFoundException;
	
	/**
	 * Uppdaterar status (ny/gamla) av bilen om billen finns i tabell annars kastar en exception
	 * @param car En bil
	 * @param isNew ny=true, gamla=false
	 * @throws CarNotFoundException Throws exception om  bil finns inte i tabell
	 */
	//funkar
	public void updateIsNew(Car car, boolean isNew) throws CarNotFoundException;
	/**
	 * Uppdaterar status (rentable/ej rentable) av bilen om billen finns i tabell annars kastar en exception
	 * @param car En bil
	 * @param isRentable rentable=true, ej rentable=false
	 * @throws CarNotFoundException Throws exception om  bil finns inte i tabell
	 */
	//funkar
	public void updateIsRentable(Car car, boolean isRentable) throws CarNotFoundException;
	/**
	 * Hittar en bil pga id om billen finns i tabell annars kastar en exception
	 * @param id id av bilen i car tabell
	 * @return En bil som är hittade pga id
	 * @throws CarNotFoundException Throws exception om  bil finns inte i tabell
	 */
	
	//funkar
	public Car findById(int id) throws CarNotFoundException;
	/**
	 * Hittar en bil pga registration nummer om billen finns i tabell annars kastar en exception
	 * @param regNr Registration nummer
	 * @return En bil som ar hämtad pga registration nummer
	 * @throws CarNotFoundException Throws exception om  bil finns inte i tabell
	 */
	
	//funkar
	public Car findByRegNr(String regNr)throws CarNotFoundException;
	/**
	 * Hittar alla bilar som finns i tabell car
	 * @return Alla billar som finns i tabell car
	 * @throws CarNotFoundException Om bil finns inte i tabell, metoden kastar exception
	 */
	
	//funkar
	public List<Car> findAll() throws CarNotFoundException;
/**
 * Hittar alla bilar som ar samma brand i tabell car
	 * @param brand  t.ex Volvo, Renault, Ford...
	 * @return Alla bilar i tabell car som är samma brand 
 * @throws CarNotFoundException Om bil finns inte i tabell, metoden kastar exception
 */
	//funkar
	public List<Car> findByBrand(String brand) throws CarNotFoundException;
	/**
	 * Hittar alla bilar som ar samma brand och samma model i tabell car
	 * @param brand t.ex Volvo, Renault, Ford...
	 * @param model t.ex Clio, Focus...
	 * @return Alla bilar som ar samma brand och samma model i tabell car
	 * @throws CarNotFoundException Om bil finns inte i tabell, metoden kastar exception
	 */
	//funkar
	public List<Car> findByBrandAndModel(String brand, String model) throws CarNotFoundException ;
	/**
	 * Hittar alla bilar som ar biligare an onskade pris
	 * @param price max onskade pris
	 * @return Alla bilar som ar biligare an onskade pris
	 * @throws CarNotFoundException Om bil finns inte i tabell, metoden kastar exception
	 */
	//funkar
	public List<Car> findBelowPrice(int price) throws CarNotFoundException;
	/**
	 * Hittar alla bilar som har kilometer mindre an onskade kilometer
	 * @param kilometer max onskade kilometer
	 * @return Alla bilar som har kilometer mindre an onskade kilometer
	 * @throws CarNotFoundException Om bil finns inte i tabell, metoden kastar exception
	 */
	
	//funkar
	public List<Car> findBelowKilometer(int kilometer) throws CarNotFoundException;
	/**
	 * Hittar alla bilar som ar automatik/ej automatik
	 * @param automatic automatik=true, ej automatik= false
	 * @return Alla bilar som ar automatik/ej automatik
	 * @throws CarNotFoundException Om bil finns inte i tabell, metoden kastar exception
	 */
	//funkar
	public List<Car> findByAutomatic(boolean automatic) throws CarNotFoundException;
	// automatik= true, no automatik= false
	/**
	 * Hittar alla bilar som ar rentable/ej rentable
	 * @param isRentable rentable=true, ej rentable=false
	 * @return Alla bilar som ar rentable/ej rentable
	 * @throws CarNotFoundException Om bil finns inte i tabell, metoden kastar exception
	 */
	
	//funkar
	public List<Car> findByRentable(boolean isRentable) throws CarNotFoundException;
	/**
	 * Hittar alla bilar som har navigation
	 * @param harNavigation har navigation=true, har inte navigation= false
	 * @return alla bilar fran car tabell som har navigation
	 * @throws CarNotFoundException Om bil finns inte i tabell, metoden kastar exception
	 */
	
	//funkar
	public List<Car> findByNavigation(boolean harNavigation) throws CarNotFoundException;
	// nya= true; gamla=false
	/**
	 * Hittar alla bilar som är nya eller begagnad
	 * @param isNew nya=true, gamla=false
	 * @return Aalla bilar som är nya eller begagnad
	 * @throws CarNotFoundException Om bil finns inte i tabell, metoden kastar exception
	 */
	//funkar
	public List<Car> findByNew(boolean isNew) throws CarNotFoundException;
	/**
	 * Hittar alla bilar som anvander samma fuel
	 * @param fuel (gas, bensin...)
	 * @return Alla bilar i tabell car som anvander samma fuel
	 * @throws CarNotFoundException Om bil finns inte i tabell, metoden kastar exception
	 */
	//funkar
	public List<Car> getAllCarByFuel(String fuel) throws CarNotFoundException;
	/**
	 * Hittar alla bilar som ar samma brand och anvander samma fuel
	 * @param brand t.ex Volvo, Renault, Ford...
	 * @param fuel (gas, bensin...)
	 * @return Alla bilar som ar samma brand och anvander samma fuel
	 * @throws CarNotFoundException Om bil finns inte i tabell, metoden kastar exception
	 */
	
	//funkar
	public List<Car> getAllCarByBrandAndFuel( String brand, String fuel) throws CarNotFoundException;
	/**
	 * Hittar alla bilar som ar samma brand och model samt anvander samma fuel
	 * @param brand t.ex Volvo, Renault, Ford...
	 * @param model t.ex Clio, Focus...
	 * @param fuel (gas, bensin...)
	 * @return Alla bilar som ar samma brand och model samt anvander samma fuel
	 * @throws CarNotFoundException Om bil finns inte i tabell, metoden kastar exception
	 */
		//funkar
	public List<Car> getAllCarByBrandAndModelAndFuel( String brand, String model,String fuel) throws CarNotFoundException;
	/**
	 * Hittar alla bilar som är gjord samma ar
	 * @param year Ar av produktion
	 * @return Alla bilar som är gjord samma ar
	 * @throws CarNotFoundException Om bil finns inte i tabell, metoden kastar exception
	 */	
	//funkar
	public List<Car> getAllCarByYear(int year) throws CarNotFoundException;

}
