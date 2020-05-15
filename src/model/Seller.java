package model;
public class Seller extends Person{
	private final static int CLIENTS_PER_SELLER = 5;
	private int totalSales;
	private Client[] clients;

	/**
		*Name:Seller
		*Seller class constructor. sets all the atributes
		*first tree are set by the super class constructor, super class: Person.
		*@param name !=""
		*@param lastName !=""
		*@param id > 0
		*@param totalSales >= 0 
	*/
	public Seller(String name, String lastname, String id, 
					int totalSales) {

		super(name,lastname,id);
		this.totalSales = totalSales;
		clients = new Client[CLIENTS_PER_SELLER];
	}

	/**
		*Name:getTotalSales
		*returns the total sales of a seller.
		*@return totalSales.
	*/	
	public int getTotalSales() {
		return totalSales;
	}

	/**
		*Name:setTotalSales
		*recives and sets the total number of sales the seller has made
		*@param totalSales must be in between one and MAX_VALUE. totalEarnings > 0 && totalEarnings <= MAX_VALUE.
	*/
	public void addSell() {
		this.totalSales += 1;
	}	

	/**
		*Name:getClients
		*returns all the seller clients
		*@return clients.
	*/	
	public Client[] getClients() {
		return clients;
	}

	/**
		*Name:addClient
		*adds a client to the seller list of clients 
		*@param clients != null
	*/	
	public void addClient(Client client){
		boolean added = false;
		for (int i  = 0 ; i < clients.length && !added ; i++ ) {
			if (clients[i] == null) {
				clients[i] = client;
				added = true;
			}
		}
	}

	/**
		*Name:getNumberOfClients
		*returns the current number of clients that the seller is in charge of.
		*@return numberClients.
	*/	
	public int getNumberOfClients(){
		int numberClients = 0;
		for (int i  = 0 ; i < clients.length; i++ ) {
			if (clients[i] != null) {
				numberClients += 1;
			}
		}
		return numberClients;
	}

}