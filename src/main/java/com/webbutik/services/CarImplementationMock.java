package com.webbutik.services;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.webbutik.domain.Car;
import com.webbutik.domain.Brand;

/**
 * 
 * @author danijela
 * Testing, develop version
 *
 */
public class CarImplementationMock implements CarService  {
	private Map<String, Car> testBil=new HashMap<String,Car>();
	
	public CarImplementationMock() throws Exception  {
		//Exception pga Date
		//Bil(String idBil, String idModel, boolean ny, String farg, int pris, int kilometer,
		//boolean navigation, boolean automatik, boolean mojlighetAttHyra, Date datumPaLager
	//	Bil bil1= new Bil("RDS123","Renault","Clio",true,"vit",210000,0,false,false,false,DateFormat.getDateInstance().parse("31 Mar, 2015"));
	//	Bil bil2= new Bil("DGH321","Volvo","v40",false,"orange",250000,75000,true,false,false,DateFormat.getDateInstance().parse("31 Mar, 2015"));
		Car bil1 = new Car("RDS123","Renault","C4",2020, "gas", true,"vit",210000,0,false,false,false,new SimpleDateFormat("dd/MM/yyyy").parse("31/12/2019"));
		Car bil2 = new Car("XXX123","Volo","Cv40",2012, "diesel", true,"red",310000,0,true,false,false,new SimpleDateFormat("dd/MM/yyyy").parse("31/12/2020"));
	
		
		
		testBil.put("REG1", bil1);
		testBil.put("REG2", bil2);
	}

	@Override
	public void addCar(Car bil) {
		testBil.put(bil.getRegNr(), bil);
	}
	
	@Override
	public List<Car> getAllCars() {
		return new ArrayList<Car>(testBil.values());		
	}

	@Override
	public void removeCarByID(int id) {
	}

	@Override
	public void removeCarByRegNr(String regNr) {	
	}

	@Override
	public void updatePrice(Car bil, int price) {
	}

	@Override
	public void updateKilometer(Car bil, int kilometer) {
		
	}
	


	@Override
	public void updateIsNew(Car car, boolean isNew) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateIsRentable(Car car, boolean isRentable) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Car getCarById(int id) {
		return null;
	}

	@Override
	public Car getCarByRegNr(String regNr) {
		return null;
	}

	@Override
	public List<Car> getAllByBrand(String brand) {
		return null;
	}

	@Override
	public List<Car> getAllByBrandAndModel(String mark, String model) {
		return null;
	}

	@Override
	public List<Car> getAllBelowPrice(int price) {
		return null;
	}

	@Override
	public List<Car> getAllBelowKilometer(int kilometer) {
		return null;
	}

	@Override
	public List<Car> getAllAutomatic(boolean isAutomatic) {
		return null;
	}

	@Override
	public List<Car> getAllRentable(boolean isRentable) {
		return null;
	}

	@Override
	public List<Car> getAllWithNavigation(boolean hasNavigation) {
		return null;
	}

	@Override
	public List<Car> getAllNewCars(boolean isNew) {
		return null;
	}

	@Override
	public List<Car> getAllCarByFuel(String fuel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Car> getAllCarByBrandAndFuel(String brand, String fuel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Car> getAllCarByBrandAndModelAndFuel(String brand, String model, String fuel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Car> getAllCarByYear(int year) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
