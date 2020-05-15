package model;
public interface Electric {
	
	/**
		*Name:getFastCharger
		*returns a value statement that represents if the electric vehicle has fast charger
	*/
	public abstract boolean getFastCharger();
	
	/**
		*Name:getBatteryLife
		*returns the electric vehicle battery life
	*/
	public abstract double getBatteryLife();
	
	/**
		*Name:getBatteryConsumption
		*returns the electric vehicle battery consuption
	*/
	public abstract double getBatteryConsumption();

}