package model;
import java.util.*;
public abstract class Car extends Vehicle{
	private final static String SEDAN = "Sedan";
	private final static String VAN = "Van";
	private String carType;
	private int noDoors;
	private boolean polarized;	

	/**
		This method is the constructor of Car
		*first seven are set by the super class constructor, super class: Vehicle.
		*@param basePrice > 0
		*@param brand !=""
		*@param model > 1900
		*@param displacement > 0
		*@param mileage >= 0
		*@param used != null 
		*@param plate !=""
		*@param carType = "Sedan" || = "Van"
		*@param noDoors > 0
		*@param polarized != null
	*/
	public Car(double basePrice, String brand, int model, double displacement, int mileage, boolean used, String plate,
				String carType, int noDoors, boolean polarized) {

		super(basePrice, brand, model, displacement, mileage, used, plate);
		this.carType = carType;
		this.noDoors = noDoors;
		this.polarized = polarized;
	}

	/**
		*Name:getType
		*returns the type of the car.
		*@return type.
	*/	
	public String getcarType() {
		return carType;
	}

	/**
		*Name:getNoDoors
		*returns the number of doors of the car.
		*@return noDoors.
	*/	
	public int getNoDoors() {
		return noDoors;
	}

	/**
		*Name:getPolarized
		*returns a value that represents if the vehicle is polarized or not.
		*@return totalSalePrice.
	*/	
	public boolean getPolarized() {
		return polarized;
	}

	/**
		*Name:calculateTotalSalePrice
		*calculates the vehicle total sale price.
	*/
	@Override
	public abstract double calculateTotalSalePrice();

	/**
		*Name: vehicleInfo
		*returns the vehicle available information adding the super information and the current class information.
		*@return vehicle available information.
	*/
	@Override
	public String vehicleInfo(){
		return super.vehicleInfo()+
				"\n-Car type:"+carType+
				"\n-Number of doors: "+noDoors+
				"\n-Polarized: "+polarized;
	}

}