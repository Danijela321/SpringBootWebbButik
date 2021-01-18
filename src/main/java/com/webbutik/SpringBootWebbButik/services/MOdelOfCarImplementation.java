//package com.webbutik.SpringBootWebbButik.services;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.DataIntegrityViolationException;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.webbutik.SpringBootWebbButik.domain.ModelOfCar;
//import com.webbutik.SpringBootWebbButik.repository.ModelRepository;
//import com.webbutik.exception.CarExist;
//import com.webbutik.exception.CarFoundException;
//import com.webbutik.exception.CarNotFound;
//import com.webbutik.exception.CarNotFoundException;
//
//
///**
// * 
// * @author danijela
// * Implementation av ModelOfCar 
// *
// */
//@Transactional
//@Service("modelOfCarService")
//public class MOdelOfCarImplementation {
//	//POST METODER
//	/**
//	 * Egenskap 
//	 * constructor arg
//	 */
//	@Autowired
//	private ModelRepository dao;
//
//	/**
//	 * Skapar en ny model av bil i tabell modelOfCar
//	 * @throws CarExist Om model finns i tabell modelOfCar kastar metoden exception
//	 */
//	//@Override
//	public void addMOdelOfCar(ModelOfCar moc) throws CarExist {
//		try {
//			return	dao.insert(moc);
//		} catch (CarFoundException e) {
//			throw new CarExist();
//		}
//
//	}
///**
// * Raderar en model av bil i tabell modelOfCar pga id
// * @throws CarNotFound Throws exception om car inte finns i tabel
// */
////	@Override
//	public void removeModelOvCar(String modelName) throws CarNotFound {
//		try {
//			return	dao.remove(modelName);
//		} catch (CarNotFoundException e) {
//			throw new CarNotFound();
//		}
//
//	}
//	
//	
//	//GET METODER
//
//	/**
//	 * Hamta en model av bil pga models namn
//	 * @throws CarNotFound Throws exception om car inte finns i tabel
//	 */
////	@Override
//	public ModelOfCar getModelOfCar(String modelName) throws CarNotFound {		
//		try {
//			return dao.findByModel(modelName);
//		} catch (CarNotFoundException e) {
//			throw new CarNotFound();
//		}
//		//Rätt logic
//	//	return dao.findByModel(modelName).orElse(new CarNotFound());
//	}
//
//}
