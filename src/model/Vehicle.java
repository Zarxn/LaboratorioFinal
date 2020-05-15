package model;
import java.util.*;
public abstract class Vehicle {
	private boolean selled;
	private double totalSalePrice;
	private double basePrice;
	private String brand;
	private int model;
	private double displacement;
	private int mileage;
	private boolean used;
	private String plate;
	private ArrayList<Document> documents;

	/**
		*Name:Vehicle
		*Vehicle class constructor. sets all the atributes.
		*@param basePrice > 0
		*@param brand !=""
		*@param model > 1900
		*@param displacement > 0
		*@param mileage >= 0 
		*@param used != null 
		*@param plate !=""
	*/
	public Vehicle(double basePrice, String brand, int model, double displacement, int mileage, boolean used, String plate){
		this.basePrice = basePrice;
		this.brand = brand;
		this.model = model;
		this.displacement = displacement;
		this.mileage = mileage;
		this.used = used;
		this.plate = plate;
		if (used) {
			documents = oldDocuments(this.model);	
		}else{
			documents = new ArrayList<Document>();
		}		
		totalSalePrice = calculateTotalSalePrice();
		selled = false;
	}

	/**
		*Name:oldDocuments
		*generates a list of the vehicle documents of previous years, with random generated values(related to the 2020 prices) for the atributes.
		*@param model >= 0.
	*/
	public ArrayList<Document> oldDocuments(int model){
		Random ran = new Random();
		//average 2020 prices
		double soatPrice = 450000;
 		double tMReviewPrice = 200000;

		ArrayList<Document> documents = new ArrayList<Document>();

		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		double emittedGasLevel = 0, accidentTotalMount = 0;
		double priceDecrease = 0;

		for (int i = model ; i <= currentYear ; i++ ) {
			soatPrice = 450000;
 			tMReviewPrice = 200000;
			double ii = i;
			//if the year is 2020, teh prices dont vary, for the other years: ((model - currentYear)+((model - currentYear)/2))/100 ; to get the percentage of decrease or increase from the base price.
			priceDecrease = (i ==  2020)
				?priceDecrease = 0
				:((ii - currentYear)+((ii - currentYear)/2))/100;
			soatPrice += (soatPrice * priceDecrease);
			tMReviewPrice += (tMReviewPrice * priceDecrease);

			//between 50 and 200
			emittedGasLevel = ran.nextInt(150)+50;
			//one in tree chanche that the car has a mount for accident
			accidentTotalMount = ran.nextInt(2) == 0 
				? ran.nextInt(5000000)+100000
				: 0;
			//for the current year there is 50% chance that it will have each document.
			if (i == currentYear) {
				if (ran.nextInt(2) == 0) {
					documents.add(new Soat(soatPrice, i, accidentTotalMount));
				}
				if (ran.nextInt(2) == 0) {
					documents.add(new Review(tMReviewPrice, i, emittedGasLevel));
				}
			}else{
				documents.add(new Soat(soatPrice, i, accidentTotalMount));	
				documents.add(new Review(tMReviewPrice, i, emittedGasLevel));			
			}
			
		}

		return documents;
	}
	
	/**
		*Name:getSelled
		*returns a truth value that represents if the car is been selled or owned by the dealer.
		*@return selled.
	*/	
	public boolean getSelled(){
		return selled;
	}

	/**
		*Name:setSelled
		*sets the selled truth value that represents if the car is been selled or owned by the dealer.
		*@param selled.
	*/
	public void setSelled(boolean selled){
		this.selled = selled;
	}

	/**
		*Name:getTotalSalePrice
		*returns the total sales price of the vehicle.
		*@return totalSalePrice.
	*/	
	public double getTotalSalePrice() {
		return totalSalePrice;
	}

	/**
		*Name:calculateTotalSalePrice
		*calculates the vehicle total sale price.
	*/
	public abstract double calculateTotalSalePrice();

	/**
		*Name:getBasePrice
		*returns the base price of the vehicle.
		*@return basePrice.
	*/	
	public double getBasePrice() {
		return basePrice;
	}

	/**
		*Name:getBrand
		*returns the brand of the vehicle.
		*@return brand.
	*/	
	public String getBrand() {
		return brand;
	}

	/**
		*Name: getModel
		*returns the model of the vehicle.
		*@return model.
	*/	
	public int getModel() {
		return model;
	}

	/**
		*Name: getDisplacement
		*returns the displacement of the vehicle.
		*@return displacement.
	*/	
	public double getDisplacement() {
		return displacement;
	}

	/**
		*Name: getMileage
		*returns the mileage of the vehicle.
		*@return mileage.
	*/	
	public int getMileage() {
		return mileage;
	}	

	/**
		*Name: getUsed
		*returns a value that express if the vehicle is used or new.
		*@return used.
	*/	
	public boolean getUsed() {
		return used;
	}

	/**
		*Name: getPlate
		*returns the plate of the vehicle.
		*@return plate.
	*/	
	public String getPlate() {
		return plate;
	}

	/**
		*Name:setPlate
		*sets the plate of the vehicle.
		*@param plate.
	*/
	public void setPlate(String plate){
		this.plate = plate;
	}

	/**
		*Name: getDocuments
		*returns the documents of the vehicle.
		*@return documents.
	*/	
	public ArrayList<Document> getDocuments() {
		return documents;
	}

	/**
		*Name: vehicleInfo
		*returns the vehicle available information.
		*@return vehicle available information.
	*/
	public String vehicleInfo(){
		return "- Selled: "+selled+
				"\n-Brand: "+brand+
				"\n-Model: "+model+
				"\n-Total Sale Price: "+totalSalePrice+
				"\n-Base price: "+basePrice+
				"\n-Displacement: "+displacement+
				"\n-Mileage: "+mileage+
				"\n-Used:"+used+
				"\n-Plate: "+plate;
	}

}