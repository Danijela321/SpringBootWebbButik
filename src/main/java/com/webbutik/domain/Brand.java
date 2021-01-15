package com.webbutik.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 * 
 * @author danijela
 * Använder inte i denna fas
 *
 */
@Entity
public class Brand implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
//	@SuppressWarnings("unused")
	private int brandID;
	private String brandName; // volvo,BMW,.... kanske vi behöver den inte eftersom vi har idBilar dom id
	private String modelName; // clio, capture...
	private String regNr; // konkreta bil, det är registrationsnummer t.exe RDF-567

	public Brand() {
	}

	public int getId() {
		return id;
	}

	public String getBrandName() {
		return brandName;
	}

	public String getModelName() {
		return modelName;
	}

	public Brand(String brandName, String modelName) {
		// super();
		this.brandName = brandName;
		this.modelName = modelName;
	}

}
