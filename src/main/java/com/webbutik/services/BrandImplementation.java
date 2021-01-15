package com.webbutik.services;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.webbutik.domain.Brand;
@Transactional
@Component
public class BrandImplementation implements BrandService{


	@Override
	public List<Brand> getAllBilar() {
		

		
		return null;
	}

	@Override
	public List<Brand> searchByMark(String mark) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Brand> searchByModel(String model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Brand> searchByidBil(String idBil) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public void addBilar(Bilar bilar) {
//		// TODO Auto-generated method stub
//		
//	}

}
