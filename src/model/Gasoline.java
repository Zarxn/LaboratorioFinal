package model;
public interface Gasoline {
	public final static String PREMIUM = "Premium";
	public final static String REGULAR = "Regular";
	public final static String DIESEL = "Diesel";
	
	/**
		*Name:getTankCapacity
		*returns the gas vehicle capacity of the tank
	*/	
	public abstract double getTankCapacity();
	
	/**
		*Name: getGasType
		*returns the gas vehicle gasoline type
	*/	
	public abstract String getGasType();
	
	/**
		*name: getGasConsumption 
		*returns the gas vehicle gasoline consumption
	*/	
	public abstract double getGasConsumption();


}