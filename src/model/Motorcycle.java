package model;
import java.util.*;
public class Motorcycle extends Vehicle implements Gasoline{
	private final static String STANDARD = "Standard";
	private final static String SPORT = "Sport";
	private final static String SCOOTER = "Scooter";
	private final static String CROSS = "Cross";
	private double tankCapacity;
	private String gasType;
	private double gasConsumption;
	private String motorcycleType;

	/**
		*Name:Car
		*Car class constructor. sets all the atributes
		*first seven are set by the super class constructor, super class: Vehicle.
		*@param basePrice > 0
		*@param brand !=""
		*@param model > 1900
		*@param displacement > 0
		*@param mileage >= 0
		*@param used != null 
		*@param plate !=""
		*@param gasType = "premium" || ="regular" || ="diesel" //ignoring cases
		*@param tankCapacity > 0
		*@param motorcycleType = "Standart" || = "Sport" || = "Scooter" || = "Cross" //ignoring cases
	*/
	public Motorcycle(double basePrice, String brand, int model, double displacement, int mileage, boolean used, String plate,
				String gasType,double tankCapacity, String motorcycleType) {

		super(basePrice, brand, model, displacement, mileage, used, plate);
		this.gasType = gasType;
		this.tankCapacity = tankCapacity;
		this.gasConsumption = this.tankCapacity * (super.getDisplacement()/90);
		this.motorcycleType = motorcycleType;
	}

	/**
		*Name:calculateTotalSalePrice
		*calculates the vehicle total sale price.
		*@return totalPrice
	*/
	@Override
	public double calculateTotalSalePrice(){
		double totalprice = super.getBasePrice();
		totalprice += super.getBasePrice()*0.04;
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
					? 0.98  
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

	public String getMotorcycleType(){
		return motorcycleType;
	}

	/**
		*Name: vehicleInfo
		*returns the vehicle available information adding the super information and the current class information.
		*@return vehicle available information.
	*/
	@Override
	public String vehicleInfo(){
		return super.vehicleInfo()+
				"\n-Motorcycle type: "+motorcycleType+
				"\n-Tank capacity: "+tankCapacity+
				"\n-Gas type: "+gasType+
				"\n-Gas consumption: "+gasConsumption;
	}
}