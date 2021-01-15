package com.webbutik.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 
 * @author danijela
 * Egenskap for model av en bil med hjalp av Entity skapar programet en table
 *
 */
@Entity
public class ModelOfCar {
	private static final long serialVersionUID = 1L;
	/**
	 *  Egenskaper av en model av bil
	 */
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private int id;


	private String modelName;
//	private int brandID;       //märke
//	private String carID;
	@Column (name="power_Hp_per_l")
	private int power;         //100 Hp/l, titel av column Hp/l
	@Column (name="length_i_mm")
	private int length; //4050 titel mm
	@Column (name="width_i_mm")
	private int width; //1798 titel mm
	@Column (name="height_i_mm")
	private int height; // 1440 mm


	@Column (name="weelBase_i_mm")
	private int weelBase; //2583 mm
	private int seat; //5
	private int doors; // 5
	
	/**
	 *  en tom konstruktor. Den ar obligatoriskt annars programmet funkar inte korrekt.
	 */
	public ModelOfCar(){}
	
/**
 * 
  @param modelName : Den ar namn av model av bil(t.ex Clio, Renault 5, Focus..)
	 * @param power : Den visar motoreffekt
	 * @param length : Visar langd på bilen
	 * @param width : Visar bils bredd
	 * @param height : Visar bilhojd
	 * @param weelBase : Visar hjulbas
	 * @param seat : Visar hur manga sittplats finns i en bil
	 * @param doors : Visar hur manga dorrar har en bil
 */
	public ModelOfCar(String modelName, int power, int length, int width, int height, int weelBase, int seat, int doors) {
		super();
		this.modelName = modelName;
		this.power = power;
		this.length = length;
		this.width = width;
		this.height = height;
		this.weelBase = weelBase;
		this.seat = seat;
		this.doors = doors;
	}
/**
 * Skriva ut egenskaper
 */
@Override
	public String toString() {
		return "ModelOfCar [id=" + id + ", modelName=" + modelName + ", power=" + power + ", length=" + length
				+ ", width=" + width + ", height=" + height + ", weelBase=" + weelBase + ", seat=" + seat + ", doors="
				+ doors + "]";
	}

/**
 * 
 * @param modelName Den ar namn av model av bil(t.ex Clio, Renault 5, Focus..)
 */
public ModelOfCar(String modelName) {
	this.modelName=modelName;
}
	
	/**
	 * 
	 * @return namn av bils model
	 */
	public String getModelName() {
		return modelName;
	}

	/**
	 * 
	 * @return Antal platser
	 */
	public int getSeat() {
		return seat;
	}

	/**
	 * 
	 * @return Antal dorrar
	 */
	public int getDoors() {
		return doors;
	}

/**
 * 
 * @return id av model i databasen
 */
	public int getId() {
		return id;
	}

	/**
	 * 
	 * @return Kraft av models motor
	 */
	public int getPower() {
		return power;
	}

	/**
	 * 
	 * @return Langd av model
	 */
	public int getLength() {
		return length;
	}

	/**
	 * 
	 * @return Bredd av model
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * 
	 * @return Hojd av model
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * 
	 * @return Hjulbas
	 */
	public int getWeelBase() {
		return weelBase;
	}


}
