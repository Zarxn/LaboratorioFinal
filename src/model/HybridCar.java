package model;
import java.util.*;
public class HybridCar extends Car implements Electric, Gasoline{
	private boolean fastCharger;
	private double batteryLife;
	private double batteryConsumption;
	public double tankCapacity;
	public String gasType;
	public double gasConsumption;
	/**
		*Name:ElectricCar
		*ElectricCar class constructor. sets all the atributes
		*first seven are set by the indirect super class constructor, indirect super class: Vehicle
		*the next tree are set by the direct super class constructor, direct super class: Car
		*@param basePrice > 0
		*@param brand !=""
		*@param model > 1900
		*@param displacement > 0
		*@param mileage >= 0
		*@param used != null 
		*@param  plate !=""
		*@param carType = "Sedan" || = "Van" //ignoring cases
		*@param noDoors > 0
		*@param polarized != null
		*@param tankCapacity != null
		*@param gasType != null
		*@param fastCharger != null
		*@param betteryLife != null
	*/
	public HybridCar(double basePrice, String brand, int model, double displacement, int mileage, boolean used, String plate,
				String carType, int noDoors, boolean polarized,
				double tankCapacity, String gasType,boolean fastCharger, double batteryLife) {
		super(basePrice, brand, model, displacement, mileage, used, plate, carType, noDoors, polarized);
		this.tankCapacity = tankCapacity;
		this.gasType = gasType;
		this.gasConsumption = this.tankCapacity * (super.getDisplacement()/110);
		this.fastCharger = fastCharger;
		this.batteryLife = batteryLife;
		this.batteryConsumption = fastCharger 
								?(batteryLife+10)*(super.getDisplacement()/100)
								:(batteryLife+15)*(super.getDisplacement()/100);
	}

	/**
		*Name:calculateTotalSalePrice
		*calculates the vehicle total sale price.
		*@return totalPrice
	*/
	@Override
	public double calculateTotalSalePrice(){
		double totalprice = super.getBasePrice();
		totalprice += super.getBasePrice()*0.15;
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
		*Name:getFastCharger
		*returns a value statement that represents if the electric vehicle has fast charger or not
		*@return fastCharger
	*/
	@Override
	public boolean getFastCharger(){
		return fastCharger;
	}

	/**
		*Name:getBatteryLife
		*returns the electric vehicle battery life
		*@return batteryLife.
	*/
	@Override
	public double getBatteryLife(){
		return batteryLife;
	}

	/**
		*Name:getBatteryConsumption
		*returns the electric vehicle battery consuption
		*@return batteryConsumption
	*/
	@Override
	public double getBatteryConsumption(){
		return batteryConsumption;
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
				"\n-Gas consumption: "+gasConsumption+
				"\n-Fast charger: "+fastCharger+
				"\n-Battery life: "+batteryLife+
				"\n-Battery consumption: "+batteryConsumption;
	}
}