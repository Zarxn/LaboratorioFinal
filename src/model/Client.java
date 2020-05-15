package model;
import java.util.*;
public class Client extends Person{
	private Seller sellerInCharge;
	private String phoneNumber;
	private String email; 
	private ArrayList<Vehicle> ownedVehicles;
	private ArrayList<Vehicle> interestedVehicles;

	/**
		*Name:Client
		*Client class constructor. sets all the atributes
		*first tree are set by the super class constructor, super class: Person.
		*@param name !=""
		*@param lastName !=""
		*@param id > 0
		*@param sellerInCharge != null
		*@param phoneNumer !=""
		*@param email != "" 
	*/
	public Client (String name, String lastname, String id,
					Seller sellerInCharge,String phoneNumber, String email){

		super(name,lastname,id);
		this.sellerInCharge = sellerInCharge;
		this.phoneNumber = phoneNumber;
		this.email = email;
		ownedVehicles = new ArrayList<Vehicle>();
		interestedVehicles = new ArrayList<Vehicle>();
	}

	/**
		*Name:getPhoneNumber
		*returns the phone number of the client
		*@return phoneNumber.
	*/	
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
		*Name:getEmail
		*returns the email of the client
		*@return email.
	*/	
	public String getEmail() {
		return email;
	}

	/**
		*Name:getOwnedVehicles
		*returns the clients owned vehicles arraylist
		*@return ownedVehicles.
	*/	
	public ArrayList<Vehicle> getOwnedVehicles() {
		return ownedVehicles;
	}
	
	/**
		*Name:getInterestedVehicles
		*returns the clients vehicles interests
		*@return interestedVehicles.
	*/	
	public ArrayList<Vehicle> getInterestedVehicles() {
		return interestedVehicles;
	}

	/**
		*Name:getSellerInCharge
		*returns the seller in charge of the client
		*@return sellerInCharge.
	*/
	public Seller getSellerInCharge(){
		return sellerInCharge;
	}

}