package com.webbutik.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * 
 * @author danijela
 * Egenskap for en bil med hjalp av Entity skapar programet en table
 *
 */
@Entity
public class Car {
/**
 * Egenskaper av en bil
 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;





	@Column(unique = true, nullable = false)
	private String regNr; // regist.nummer
	private String brandName; // (Volvo, BMW, Reanult)
	private String modelName; // (Clio, Reanult 4)
	private int yearProduce;
	private String fuel; // bensin,gas,diesel
	private String color; // färg

	private int price; // pris
	private int kilometer; // kilometer
	private boolean isNew; // ny
	private boolean navigation; // navigation
	private boolean automatic; // automatisk

	private boolean isRentable; // går att hyra
	private Date timeStored; // tid på lager (från denna dag till nu)

	/**
	 * koppling med table modelofcar med hjalp av variable modelOfCar som ar en
	 * instance variable av klass ModelOfCar
	 */
	@ManyToOne
	@JoinColumn(name = "MODELOFCAR_FK")
	private ModelOfCar modelOfCar;

	/**
	 * en tom konstruktor. Den ar obligatoriskt annars programmet funkar inte korrekt.
	 */
	public Car() {
	}

	/**
	 * 
	 * @param modelName :  Den ar namn av model av bil(t.ex Clio, Renault 5, Focus..)
	 * @param modelOfCar : Instance variable av klass ModelOFCAr
	 */
	public Car(String modelName, ModelOfCar modelOfCar) {
		this.modelName = modelName;
		this.modelOfCar = modelOfCar;
	}

	/**
	 * 
	 * @param modelName : Den är namn av model av bil(t.ex Clio, Renault 5, Focus..)
	 */
//	public Car(String modelName) {
//		this.modelName = modelName;
//		this.modelOfCar = null;
//	}

	/**
	 * 
	 * @return id : från databas. Den är automatiskt genererad.
	 */
	public int getId() {
		return id;
	}

	/**
	 * 
	 * @param modelOfCar : Uppsättning av variable modelOfCar
	 */
	public void setModelOfCar(ModelOfCar modelOfCar) {
		this.modelOfCar = modelOfCar;
	}

	/**
	 * 
	 * @param modelOfCar2 : Koppling mellan tabeller car och modelOfCar
	 * 
	 */
	public void addCarToModel(ModelOfCar modelOfCar2) {
		this.modelOfCar = modelOfCar2;
	}

	/**
	 * 
	 * @param idBil :            Id av en bil
	 * @param idMark :           Varumarke (t.ex Volvo. Reanult, Ford...)
	 * @param idModel :          Den ar namn av model av bil(t.ex Clio, Renault 5,
	 *                          Focus..)
	 * @param yearProduce :      Ar nar ar en bil gjord
	 * @param fuel :             bransle (t.ex gas, bensin...)
	 * @param ny :               Bil kan vara ny eller begagnade
	 * @param farg :             Farg av bil
	 * @param pris :             Pris ( kop eller hyra)
	 * @param kilometer :        Den visar hur många kilometer bilen tackte
	 * @param navigation :       Den visar har en bil navigation eller ej
	 * @param automatik :        Den visar ar en bil automatik eller ej
	 * @param mojlighetAttHyra : Den vissar kan en bil vara bara till salu eller kan
	 *                           vara också för uthyrning
	 * @param datumPaLager :     Det visar från nar en bil finns i lager
	 */
	public Car(String idBil, String idMark, String idModel, int yearProduce, String fuel, boolean ny, String farg,
			int pris, int kilometer, boolean navigation, boolean automatik, boolean mojlighetAttHyra,
			Date datumPaLager) {
		 super();
		this.regNr = idBil;
		this.brandName = idMark;
		this.modelName = idModel;
		// this.idBilar = idBilar;
		this.yearProduce = yearProduce;
		this.fuel = fuel;
		this.price = pris;
		this.kilometer = kilometer;
		this.isNew = ny;
		this.timeStored = datumPaLager;
		this.navigation = navigation;
		this.automatic = automatik;
		this.color = farg;
		this.isRentable = mojlighetAttHyra;

	}

	/**
	 * 
	 * @return namn av model av bil
	 */
	public String getModelOfCarName() {
		return this.modelOfCar.getModelName();
	}

	/**
	 * 
	 * @return : bransle (t.ex gas, bensin...)
	 */
	public String getFuel() {
		return fuel;
	}

	/**
	 * 
	 * @return model av bil
	 */
	public ModelOfCar getModelOfCar() {
		return modelOfCar;
	}

	/**
	 * 
	 * @return Pris ( kop eller hyra)
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * 
	 * @param price : Uppsattning av prise
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * 
	 * @return : kilomneter
	 */
	public int getKilometer() {
		return kilometer;
	}

	/**
	 * 
	 * @param kilometer : Uppsattning av kilometer
	 */
	public void setKilometer(int kilometer) {
		this.kilometer = kilometer;
	}
	
	/**
	 * 
	 * @param regNr Uppsattning av Registration nummer
	 */
	public void setRegNr(String regNr) {
	this.regNr = regNr;
}

	/**
	 * 
	 * @return  Ar bien ny eller ej
	 */
	public boolean isNew() {
		return isNew;
	}

	/**
	 * 
	 * @param isNew: Uppsattning är bilen ny eller ej ( true, false)
	 */
	public void setNew(boolean isNew) {
		this.isNew = isNew;
	}

	/**
	 * 
	 * @return Har en bilen navigation eller ej
	 */
	public boolean isNavigation() {
		return navigation;
	}

	/**
	 * 
	 * @param navigation: Uppsattning har bilen navigation eller ej (true, false)
	 */
	public void setNavigation(boolean navigation) {
		this.navigation = navigation;
	}

	/**
	 * Anvanda bara i JUnit test
	 * @param id Id i databas
	 */
	public void setId(int id) {
	this.id = id;
}
	
	/**
	 * 
	 * @return  Ar en bil vara bara till salu eller kan vara ocksa för uthyrning
	 */
	public boolean isRentable() {
		return isRentable;
	}

	/**
	 * 
	 * @param isRentable: Uppsattning kan en bil vara hyrad eller bara sald (true,
	 *                    false)
	 */
	public void setRentable(boolean isRentable) {
		this.isRentable = isRentable;
	}

	/**
	 * 
	 * @return registrations nummer
	 */
	public String getRegNr() {
		return regNr;
	}

	/**
	 * 
	 * @return typ av car ( Volvo, Ford...)
	 */
	public String getBrandName() {
		return brandName;
	}

	/**
	 * 
	 * @return model av bil (Clio, Focus..)
	 */
	public String getModelName() {
		return modelName;
	}

	/**
	 * 
	 * @return vilket ar ar en bil gjord
	 */
	public int getYearProduce() {
		return yearProduce;
	}

	/**
	 * 
	 * @return farg
	 */
	public String getColor() {
		return color;
	}

	/**
	 * 
	 * @return Ar en bil automatik eller ej
	 */
	public boolean isAutomatic() {
		return automatic;
	}

	/**
	 * 
	 * @return Nar en bil kom til lager
	 */
	public Date getTimeStored() {
		return timeStored;
	}

	/**
	 * For att skriva ut bils egenskaper
	 */
	@Override
	public String toString() {
		return "Car [regNr=" + regNr + ", brandName=" + brandName + ", modelName=" + modelName + ", yearProduce="
				+ yearProduce + ", fuel=" + fuel + ", color=" + color + ", price=" + price + ", kilometer=" + kilometer
				+ ", isNew=" + isNew + ", navigation=" + navigation + ", automatic=" + automatic + ", isRentable="
				+ isRentable + ", timeStored=" + timeStored + ", modelOfCar=" + getModelOfCarName() + "]";
	}

}
