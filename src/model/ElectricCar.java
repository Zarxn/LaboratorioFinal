package model;
import java.util.*;
public class ElectricCar extends Car implements Electric{
	private boolean fastCharger;
	private double batteryLife;
	private double batteryConsumption;

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
		*@param fastCharger != null
		*@param batteryLife > 0
	*/
	public ElectricCar(double basePrice, String brand, int model, double displacement, int mileage, boolean used, String plate,
				String carType, int noDoors, boolean polarized,
				boolean fastCharger, double batteryLife) {

		super(basePrice, brand, model, displacement, mileage, used, plate, carType, noDoors, polarized);
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
		totalprice += super.getBasePrice()*0.20;
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
				"\n-Fast charger: "+fastCharger+
				"\n-Battery life: "+batteryLife+
				"\n-Battery consumption: "+batteryConsumption;
	}
}