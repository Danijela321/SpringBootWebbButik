package com.webbutik.services;

import java.util.List;

import com.webbutik.domain.Brand;



public interface BrandService {


//	public void addBilar(Bilar bilar);
	public List<Brand>getAllBilar ();
	public List<Brand>searchByMark(String mark);
	public List<Brand>searchByModel(String model);
	public List<Brand>searchByidBil(String idBil);
	
}
