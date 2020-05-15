package model;
import java.util.*;
public class GasCar extends Car implements Gasoline{
	private double tankCapacity;
	private String gasType;
	private double gasConsumption;
	/**
		*Name:GasCar
		*GasCar class constructor. sets all the atributes
		*first seven are set by the indirect super class constructor, indirect super class: Vehicle
		*the next tree are set by the direct super class constructor, direct super class: Car
		*@param basePrice > 0
		*@param brand !=""
		*@param model > 1900
		*@param displacement > 0
		*@param mileage >= 0
		*@param used != null 
		*@param plate !=""
		*@param carType = "Sedan" || = "Van" //ignoring cases
		*@param noDoors > 0
		*@param polarized != null
		*@param tankCapacity = > 0
		*@param gasType = "premium" || ="regular" || ="diesel" //ignoring cases
	*/
	public GasCar(double basePrice, String brand, int model, double displacement, int mileage, boolean used, String plate,
				String carType, int noDoors, boolean polarized,
				double tankCapacity, String gasType) {

		super(basePrice, brand, model, displacement, mileage, used, plate, carType, noDoors, polarized);
		this.tankCapacity = tankCapacity;
		this.gasType = gasType;
		this.gasConsumption = this.tankCapacity * (super.getDisplacement()/110);
	}

	/**
		*Name:calculateTotalSalePrice
		*calculates the vehicle total sale price.
		*@return totalPrice
	*/
	@Override
	public double calculateTotalSalePrice(){
		double totalprice = super.getBasePrice();
		int cent = 0;
		for (Document documents : super.getDocuments()) {
			if (documents.getYear() == 2020) {
				cent += 1;
			}
		}
		if (cent != 2) {
			totalprice += 500000;
		}
		
		totalprice *= super.getUsed() 
					? 0.90  
					: 1 ;

		return totalprice;	
	}
             
	/**
		*Name:getTankCapacity
		*returns the gas vehicle capacity of the tank.
		*@return tankCapacity.
	*/	        
	@Override
	public double getTankCapacity(){
		return tankCapacity;
	}

	/**
		*Name: getGasType
		*returns the gas vehicle gasoline type
		*@return gasType
	*/
	@Override
	public String getGasType(){
		return gasType;
	}

	/**
		*name: getGasConsumption 
		*returns the gas vehicle gasoline consumption
		*@return gasConsumption
	*/	
	@Override
	public double getGasConsumption(){
		return gasConsumption;
	}

	/**
		*Name: vehicleInfo
		*returns the vehicle available information adding the super information and the current class information.
		*@return vehicle available information.
	*/
	@Override
	public String vehicleInfo(){
		return super.vehicleInfo()+
				"\n-Tank capacity: "+tankCapacity+
				"\n-Gas type: "+gasType+
				"\n-Gas consumption: "+gasConsumption;
	}

}