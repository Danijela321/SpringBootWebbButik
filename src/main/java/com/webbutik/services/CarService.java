package com.webbutik.services;

import java.util.List;

import com.webbutik.dataacces.CarNotFoundException;
import com.webbutik.domain.Car;

/**
 * 
 * @author danijela interface satter metoder for implementation
 *
 */
public interface CarService {
	/**
	 * Skicka en ny car till CarDataAccess/CarDataAccessProduktionVersion for att
	 * insert denna nya bil i tabell car
	 * 
	 * @param bil En ny bil
	 * @throws CarExist CarExist Kastar exception om bil finns i tabell car
	 */
	public void addCar(Car bil) throws CarExist;

	/**
	 * Skicka id till CarDataAccess/CarDataAccessProduktionVersion for att radera
	 * bil fran tabell car
	 * 
	 * @param id id av bil i tabell car.
	 * @throws CarNotFound Throws exception om car finns inte i tabel
	 */
	public void removeCarByID(int id) throws CarNotFound;

	/**
	 * Skicka reg.num. till CarDataAccess/CarDataAccessProduktionVersion for att
	 * radera bil fran tabell car pga reg.nr.
	 * 
	 * @param regNr Registration nummer av bil.
	 * @throws CarNotFound Throws exception om car finns inte i tabel
	 */
	public void removeCarByRegNr(String regNr) throws CarNotFound;

	/**
	 * 
	 * Skicka bil och pris till CarDataAccess/CarDataAccessProduktionVersion for att
	 * uppdatera pris av bil
	 * 
	 * @param bil   En bil som byter pris
	 * @param price Nya pris
	 * @throws CarNotFound Throws exception om car finns inte i tabel
	 */
	public void updatePrice(Car bil, int price) throws CarNotFound;

	/**
	 * 
	 * Skicka bil och kilometer till CarDataAccess/CarDataAccessProduktionVersion
	 * for att uppdatera kilometer av bil
	 * 
	 * @param bil       En bil som byter kilometer
	 * @param kilometer Nya kolometer
	 * @throws CarNotFound Throws exception om car finns inte i tabel
	 */
	public void updateKilometer(Car bil, int kilometer) throws CarNotFound;

	/**
	 * 
	 * Skicka bil och andring av status (fran ny till gamla) till
	 * CarDataAccess/CarDataAccessProduktionVersion for att uppdatera status av bil
	 * 
	 * @param car   En bil som är inte ny längre
	 * @param isNew ny= true, gamla=false
	 * @throws CarNotFound Throws exception om car finns inte i tabel
	 */
	public void updateIsNew(Car car, boolean isNew) throws CarNotFound;

	/**
	 * 
	 * Skicka bil och andring av status (mojlig att hyra eller ej) till
	 * CarDataAccess/CarDataAccessProduktionVersion for att uppdatera status av bil
	 * 
	 * @param car        En bil som andra status
	 * @param isRentable ar= true, ej= false
	 * @throws CarNotFound Throws exception om car finns inte i tabel
	 */
	public void updateIsRentable(Car car, boolean isRentable) throws CarNotFound;

	/**
	 * Hämtar en bil pga id i databas
	 * 
	 * @param id id av bil i databas
	 * @return En bil
	 * @throws CarNotFound Throws exception om car finns inte i tabel
	 */
	public Car getCarById(int id) throws CarNotFound;

	/**
	 * Hamtar en bil pga registration nummer
	 * 
	 * @param regNr Registration nummer av en bl
	 * @return En bil
	 * @throws CarNotFound Throws exception om car finns inte i tabell
	 */
	public Car getCarByRegNr(String regNr) throws CarNotFound;

	/**
	 * 
	 * Hamtar alla bilar som finns i tabel
	 * 
	 * @return En list av bilar
	 * @throws CarNotFound Throws exception om car finns inte i tabell
	 */
	public List<Car> getAllCars() throws CarNotFound;

	/**
	 * Hamtar alla bilar av samma brand
	 * 
	 * @param brand t.ex Volvo, Renault, Ford...
	 * @return En list av bilar pga brand
	 * @throws CarNotFound Om bil finns inte, metoden kastar exception
	 */
	public List<Car> getAllByBrand(String brand) throws CarNotFound;

	/**
	 * 
	 * Hamtar alla bilar av samma brand och model
	 * 
	 * @param brand t.ex Volvo, Renault, Ford...
	 * @param model t.ex Clio, Focus...
	 * @return En list av bilar pga brand och model
	 * @throws CarNotFound Om bil finns inte, metoden kastar exception
	 */
	public List<Car> getAllByBrandAndModel(String brand, String model) throws CarNotFound;

	/**
	 * Hamtar alla bilar som är billigare an atravard pris
	 * 
	 * @param price Upper grans av prise
	 * @return Alla bilar som är biligare an valde pris
	 * @throws CarNotFound Om bil finns inte, metoden kastar exception
	 */
	public List<Car> getAllBelowPrice(int price) throws CarNotFound;;

	/**
	 * Hamtar alla bilar som har kilometer under atravard kilometer
	 * 
	 * @param kilometer Kilometer som en bil korde
	 * @return En list av bilar som har kilometer under atervard kilometer
	 * @throws CarNotFound Om bil finns inte, metoden kastar exception
	 */
	public List<Car> getAllBelowKilometer(int kilometer) throws CarNotFound;

	/**
	 * Hamtar alla automatika eller ej automatika bilar. Automatik= true, no
	 * automatik= false
	 * 
	 * @param isAutomatic Bil kan vara automatik eller ej
	 * @return En list av bilar som ar eller en lista av bilar som inte automatik
	 * @throws CarNotFound Om bil finns inte, metoden kastar exception
	 */
	public List<Car> getAllAutomatic(boolean isAutomatic) throws CarNotFound;

	// automatik= true, no automatik= false
	/**
	 * Hamta alla bilar som man kan hyra ut.
	 * 
	 * @param isRentable Rentable= true, ej rentable= false
	 * @return En list av bilar som man kan hyra ut.
	 * @throws CarNotFound Om bil finns inte, metoden kastar exception
	 */
	public List<Car> getAllRentable(boolean isRentable) throws CarNotFound;

	/**
	 * Hamtar alla bilar som har navigation
	 * 
	 * @param hasNavigation hasNavigation=true, har inte navigation=false
	 * @return En list av bilar som har navigation
	 * @throws CarNotFound Om bil finns inte, metoden kastar exception
	 */
	public List<Car> getAllWithNavigation(boolean hasNavigation) throws CarNotFound;

	// nya= true; gamla=false
	/**
	 * Hamtar alla nya bilar
	 * 
	 * @param isNew bil ar ny=true, är inte ny=false
	 * @return En lista av bilar som är nya
	 * @throws CarNotFound Om bil finns inte, metoden kastar exception
	 */
	public List<Car> getAllNewCars(boolean isNew) throws CarNotFound;

	/**
	 * Hamtar alla bilar pga fuel
	 * 
	 * @param fuel t.ex gas, bensin, diesel..
	 * @return En list av car som anvander samma fuel
	 * @throws CarNotFound Om bil finns inte, metoden kastar exception
	 */
	public List<Car> getAllCarByFuel(String fuel) throws CarNotFound;

	/**
	 * Hamtar alla bilar som ar samma brand och anvander samma fuel
	 * 
	 * @param brand t.ex Volvo, Renault, Ford...
	 * @param fuel  t.ex gas, bensin, diesel..
	 * @return En lista av samma brandbilar som använder samma fuel
	 * @throws CarNotFound Om bil finns inte, metoden kastar exception
	 */
	public List<Car> getAllCarByBrandAndFuel(String brand, String fuel) throws CarNotFound;

	/**
	 * Hamtar alla bilar som ar samma brand och model samt anvander de samma fuel
	 * 
	 * @param brand t.ex Volvo, Renault, Ford...
	 * @param model t.ex Clio, Focus...
	 * @param fuel  t.ex gas, bensin, diesel..
	 * @return En lista av bilar som är samma brand och model samt använder de samma
	 *         fuel
	 * @throws CarNotFound Om bil finns inte, metoden kastar exception
	 */
	public List<Car> getAllCarByBrandAndModelAndFuel(String brand, String model, String fuel) throws CarNotFound;

	/**
	 * Hamtar alla bilar som är gjord samma ar
	 * 
	 * @param year Ar när en bil ar gjord
	 * @return En lista av alla ilar som ar gjord samma ar
	 * @throws CarNotFound Om bil finns inte, metoden kastar exception
	 */
	public List<Car> getAllCarByYear(int year) throws CarNotFound;

}
