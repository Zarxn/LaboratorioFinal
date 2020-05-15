package ui;
import model.*;
import java.util.*;
public class Menu{
	
	private final static int VEHICLE_REGIST = 1;
	private final static int CLIENT_REGIST = 2;
	private final static int SELL_A_VEHICLE = 3;
	private final static int OPEN_VEHICLE_CATALOG = 4;
	private final static int CLIENTS_WISH_LIST = 5;
	private final static int CLIENTS_OWNED_VEHICLES = 6;
	private final static int PARKING_LOT = 7;
	private final static int EXIT = 0;
	private Scanner in;
	private Dealer dealer;
	/**
		
		*This method is a constructor ,this method creates the instance of the Scanner, in. and the principal class (Ship) instance, the pirate.
	*/
	public Menu() {
		in = new Scanner(System.in);
		dealer = new Dealer("Autos ", "6468461", 0, 0);
	}

/*
	
*/
	/**
		
		This method shows a welcome message for the beginning of the program.
	*/
	public void showWellcome(){
		System.out.println();
		System.out.println("****Wellcome!****");
	}

	/**
		
		This method shows the principal menu interface.
	*/
	public void showPrincipalMenu(){
		System.out.println();
		System.out.println("Welcome to the program!, please select an option you want!");
		System.out.println();
		System.out.println("(1).Register a vehicle");
		System.out.println("(2).Register a new client");
		System.out.println("(3).Sell a vehicle");
		System.out.println("(4).Vehicle catalog");
		System.out.println("(5).Clients wish list");
		System.out.println("(6).Clients owned vehicles.");
		System.out.println("(7).Parking lot");
		System.out.println("0.Exit.");
	}

	/**
		*Name:readInt
		*it read an integer number and returns that number.
		*@return option
	*/
	public int readInt() {
		int option = in.nextInt();
		in.nextLine();
		return option;
	}


	public double readDouble() {
		double option = in.nextDouble();
		in.nextLine();
		return option;
	}

	
	public boolean readBoolean() {
		String option ="";
		boolean value = false;
		boolean checked = false;
		option = in.nextLine();
		do{
			if (option.equalsIgnoreCase("true") || option.equalsIgnoreCase("false") ) {
				value = Boolean.parseBoolean(option.toLowerCase());
				checked = true;
			}else{
				System.out.println();
				System.out.println("Invalid option. the number must be: ¨true¨ or ¨false¨");
				option = in.nextLine();
			}

		}while(!checked);
		return value;
	}

	/**
		
		This method shows a message to press enter, reads any input. 
	*/
	public void pressEnterToContinue() {
		System.out.println();
		System.out.println("Please press enter to continue. ");
		String any = in.nextLine();
	}

	/**
		.
		*checks if an number given is in between other two numbers, if its not, shows an error message,
		*and then gives a trut value dependig if the number given meets the conditions.
		*@param option != null.
		*@param min != null.
		*@param max != null.
		*@return checked.
	*/
	public double checkOption(double option,double min, double max) {
		boolean checked = false;
		do{
			if(option >= min && option <= max){
			checked = true; 	
			}else{
				System.out.println();
				System.out.println("Invalid option. the number must be in between: "+ (int)min +" and "+ (int)max);
				option = readDouble();
			}
		}while(!checked);

		return option;
	}

	/**
		.
		This method displays a list of the current clients names with the id of each one
		then it reads an option that represents a client and returns that selected client
		*@return Client.
	*/
	public Client selectClient(){
		System.out.println();
		System.out.println("Please, select the client");
		System.out.println();
		for (int i = 0; i < dealer.getClients().size(); i++ ) {
			System.out.println((i+1)+"."+dealer.getClients().get(i).getName()+" (Id): "+dealer.getClients().get(i).getId());
		}
		int option = readInt();
		option = (int) checkOption(option,1,dealer.getClients().size());
		return dealer.getClients().get(option-1);
	}



	/**
		This method is basically the body of the program, with contains the different options the user can choose
	*/
	public void runOption(int option) {
		switch (option) {
			case VEHICLE_REGIST:
				runOptionregisterVehicle();
				break;

			case CLIENT_REGIST:
				runOptionregisterClient();
				break;

			case SELL_A_VEHICLE:
				runOptionSellVehicle();
				break;

			case OPEN_VEHICLE_CATALOG:
				runOptionVehicleCatalog();
				break;

			case CLIENTS_WISH_LIST:
				runOptionClientWishList();
				break;

			case CLIENTS_OWNED_VEHICLES:
				runOptionClientOwnedVehicles();
				break;

			case PARKING_LOT:
				runOptionParkingLot();
				break;
			case EXIT:
				System.out.println();
				System.out.println("*Thanks for using the program*");
				System.out.println();
				break;
			default:
				System.out.println();
				System.out.println("invalid option, please try again.");
		}
	}


	/**
		
		This method asks for a type of vehicle to add, then , depending on user selection, it uses a different method
	*/
	public void runOptionregisterVehicle(){
		int option = 0;
		do{
			System.out.println();
			System.out.println("which type of vehicle do you wish to add?:");
			System.out.println("1.motorcycle 2.Gasoline car 3.Electric car 4.Hybrid car 0.Exit");
			option = readInt();
			switch (option) {
				case 1:
					dealer.getVehicles().add(getNewMotorcycle());
					break;
				case 2:
					dealer.getVehicles().add(getNewGasCar());
					break;
				case 3:
					dealer.getVehicles().add(getNewElecCar());
					break;
				case 4:
					dealer.getVehicles().add(getNewHybridCar());
					break;
				default:
					System.out.println();
					System.out.println("Invalid option.");
			}
			
			if(option != 0){
				System.out.println();
				System.out.println("vehicle succesfully added");
			}

		}while(option != 0);
	}

	/**
		
		This method check if a given car fills the conditions to  be add in to the parking lot
		*@param car != null.
		*@return goesToParkinglot.
	*/
	public boolean carGoesToParkinglot(Car car){
		int model = car.getModel();
		boolean used = car.getUsed();
		boolean possibletoadd = false;
		
		if (used && (model < 2015)) {
			possibletoadd = true;
		}
		return possibletoadd;
	}

	/**
		description:
		displays a list of all the documents generated for a vehicle.
		*@param vehicle != null.
	*/
	public void vehicleDocumentsList(Vehicle vehicle){
		if (vehicle.getUsed()) {
			if (vehicle.getDocuments().size() == 0) {
				System.out.println();
				System.out.println("The vehicle doesnt have any old or current documents");
				pressEnterToContinue();

			}else{
				System.out.println();
				System.out.println("The vehicle list of documents:");
				for (int i = 0; i < vehicle.getDocuments().size() ; i++ ) {
					System.out.println(vehicle.getDocuments().get(i).documentsInfo());
				}
				pressEnterToContinue();
			}
			
		}

	}

	/**
		*description:
		reads all the information needed to create a motorcycle, and creates a motorcycle, and then returns this motorcycle.
		*@return newMotorcycle.
	*/
	public Motorcycle getNewMotorcycle() {
		System.out.println();
		System.out.println("Enter the motorcycle base price:");
		double basePrice = readDouble();

		System.out.println();
		System.out.println("Enter the motorcycle brand:");
		String brand = in.nextLine();

		System.out.println();
		System.out.println("Enter the motorcycle model:");
		int model = readInt();

		System.out.println();
		System.out.println("Enter the motorcycle displacement:");
		double displacement = readDouble();

		System.out.println();
		System.out.println("Enter the motorcycle mileage:");
		int mileage = readInt();

		System.out.println();
		System.out.println("Enter the motorcycle use state:");
		System.out.println("type: if its new please enter true, if not please enter false");
		
		boolean used = readBoolean();

		String plate = "";
		if (used) {
			System.out.println();
			System.out.println("Enter the motorcycle plate:");
			plate = in.nextLine();	
		}

		System.out.println();
		System.out.println("Enter the motorcycle gas type:");
		System.out.println("1.Premium---- 2.-----Regular 3-----.Diesel");
		int gasIntType = readInt();
		gasIntType = (int) checkOption(gasIntType,1,3);
		String gasType = "";
		switch (gasIntType) {
			case 1:
				gasType = "Premium";
				break;
			case 2:
				gasType = "Regular";
				break;
			case 3:
				gasType = "Diesel";
		}

		System.out.println();
		System.out.println("Enter the motorcycle tank capacity:");
		double tankCapacity = readDouble();

		System.out.println();
		System.out.println("Enter the motorcycle type:");
		System.out.println("(1). STANDART");
		System.out.println("(2). SPORT");
		System.out.println("(3) SCOOTER");
		System.out.println("(4) CROSS");
		int motorcycleIntType = readInt();
		motorcycleIntType = (int) checkOption(motorcycleIntType,1,4);
		String motorcycleType = "";
		switch (motorcycleIntType) {
			case 1:
				motorcycleType = "Standart";
				break;
			case 2:
				motorcycleType = "Sport";
				break;
			case 3:
				motorcycleType = "Scooter";
				break;
			case 4:
				motorcycleType = "Cross";
				break;
		}

		Motorcycle newMotorcycle = new Motorcycle(basePrice, brand, model, displacement, mileage, used, 
										plate, gasType, tankCapacity,
										motorcycleType);
		vehicleDocumentsList(newMotorcycle);
		return newMotorcycle;
	}

	/**
	description:
		*reads all the information needed to create a gas car, then creates it, and return the created gas car.
		*@return newGasCar.
	*/
	public GasCar getNewGasCar() {
		System.out.println();
		System.out.println("Enter the car base price:");
		double basePrice = readDouble();

		System.out.println();
		System.out.println("Enter the car brand:");
		String brand = in.nextLine();

		System.out.println();
		System.out.println("Enter the car model:");
		int model = readInt();

		System.out.println();
		System.out.println("Enter the car displacement:");
		double displacement = readDouble();

		System.out.println();
		System.out.println("Enter the car mileage:");
		int mileage = readInt();

		System.out.println();
		System.out.println("Enter the car use state:");
		System.out.println("if the car is used enter true, if not enter false");
		
		boolean used = readBoolean();

		String plate = "";
		if (used) {
			System.out.println();
			System.out.println("Enter the car plate:");
			plate = in.nextLine();	
		}
		
		System.out.println();
		System.out.println("Enter the number of doors");
		int noDoors = readInt();

		System.out.println();
		System.out.println("Enter the car polarized state:");
		System.out.println("if the car is polarized, enter true, if not, enter false");
		
		boolean polarized = readBoolean();

		System.out.println();
		System.out.println("Please Enter the car tank capacity:");
		double tankCapacity = readDouble();

		System.out.println();
		System.out.println("Please enter the car gas type");
		System.out.println("(1). PREMIUM");
		System.out.println("(2).  REGULAR");
		System.out.println("(3). DIESEL");
		

		 
		int gasIntType = readInt();
		gasIntType =  (int) checkOption(gasIntType,1,3);
		String gasType = "";
		switch (gasIntType) {
			case 1:
				gasType = "Premium";
				break;
			case 2:
				gasType = "Regular";
				break;
			case 3:
				gasType = "Diesel";
		}

		System.out.println();
		System.out.println("Enter the car type");
		System.out.println("(1). SEDAN");
		System.out.println("(2. VAN");
		
		int carIntType = readInt();
		carIntType = (int) checkOption(carIntType,1,3);
		String carType = "";
		switch (carIntType) {
			case 1:
				carType = "Sedan";
				break;
			case 2:
				carType = "Van";
				break;
		}
		GasCar newGasCar = new GasCar(basePrice, brand, model, displacement, mileage, used, plate, 
										carType, noDoors, polarized, 
										tankCapacity, gasType);
		if (carGoesToParkinglot(newGasCar)) {
			System.out.println();
			System.out.println(dealer.addCarToParkingLot(newGasCar));
		}

		vehicleDocumentsList(newGasCar);
		return newGasCar;
	}

	/**
		description:
		First, it reads all the information needed to create an electric car, and creates this car, and then returns the created electric car.
		*@return newElecCar.
	*/
	public ElectricCar getNewElecCar() {
		System.out.println();
		System.out.println("Please enter the car base price:");
		double basePrice = readDouble();

		System.out.println();
		System.out.println("Please enter the car brand:");
		String brand = in.nextLine();

		System.out.println();
		System.out.println("Please enter the car model:");
		int model = readInt();

		System.out.println();
		System.out.println("Please enter the car displacement:");
		double displacement = readDouble();

		System.out.println();
		System.out.println("Please enter the car mileage:");
		int mileage = readInt();

		System.out.println();
		System.out.println("Enter the car use:");
		System.out.println("if the car is used, please enter true, if not, please enter false");
		
		
		boolean used = readBoolean();

		String plate = "";
		if (used) {
			System.out.println();
			System.out.println("Please enter the car plate");
			plate = in.nextLine();	
		}

		System.out.println();
		System.out.println("Enter the car type");
		System.out.println("1.Sedan 2.Van");
		int carIntType = readInt();
		carIntType = (int) checkOption(carIntType,1,3);
		String carType = "";
		switch (carIntType) {
			case 1:
				carType = "Sedan";
				break;
			case 2:
				carType = "Van";
				break;
		}

		System.out.println();
		System.out.println("Enter the car number of doors");
		int noDoors = readInt();

		System.out.println();
		System.out.println("Please enter the car polarized state");
		System.out.println("if the car is polarized, enter true if not enter false");
		
		boolean polarized = readBoolean();

		System.out.println();
		System.out.println("Enter the car fast charging state:");
		System.out.println("if the car has fast charging please enter true, if not please enter false");
		boolean fastCharger = readBoolean();

		System.out.println();
		System.out.println("Enter the car battery life:");
		double batteryLife = readDouble();

		ElectricCar newElecCar = new ElectricCar(basePrice, brand, model, displacement, mileage, used, plate,
										carType,noDoors, polarized,
										fastCharger, batteryLife);

		if (carGoesToParkinglot(newElecCar)) {
			System.out.println();
			System.out.println(dealer.addCarToParkingLot(newElecCar));
		}

		vehicleDocumentsList(newElecCar);
		return newElecCar;
	}

	/**
		description:
		*reads all the information needed to create a hybrid car, and creates this car, and then returns the created hybrid car.
		*@return newElecCar.
	*/
	public HybridCar getNewHybridCar() {
		System.out.println();
		System.out.println("Enter the car base price:");
		double basePrice = readDouble();

		System.out.println();
		System.out.println("Enter the car brand:");
		String brand = in.nextLine();

		System.out.println();
		System.out.println("Enter the car model:");
		int model = readInt();

		System.out.println();
		System.out.println("Enter the car displacement:");
		double displacement = readDouble();

		System.out.println();
		System.out.println("Enter the car mileage:");
		int mileage = readInt();

		System.out.println();
		System.out.println("Enter the car use:");
		System.out.println("type: - true - if used");
		System.out.println("type: - false - if new");
		boolean used = readBoolean();

		String plate = "";
		if (used) {
			System.out.println();
			System.out.println("Enter the car plate:");
			plate = in.nextLine();	
		}

		System.out.println();
		System.out.println("Enter the car type");
		System.out.println("1.Sedan 2.Van");
		int carIntType = readInt();
		carIntType = (int) checkOption(carIntType,1,3);
		String carType = "";
		switch (carIntType) {
			case 1:
				carType = "Sedan";
				break;
			case 2:
				carType = "Van";
				break;
		}

		System.out.println();
		System.out.println("Enter the car number of doors");
		int noDoors = readInt();

		System.out.println();
		System.out.println("Enter the car polarized state:");
		System.out.println("type: - true - if polarized");
		System.out.println("type: - false - if not polarized");
		boolean polarized = readBoolean();

		System.out.println();
		System.out.println("Enter the car tank capacity:");
		double tankCapacity = readDouble();

		System.out.println();
		System.out.println("Enter the car gas type");
		System.out.println("1.Premium 2.Regular 3.Diesel");
		int gasIntType = readInt();
		gasIntType = (int) checkOption(gasIntType,1,3);
		String gasType = "";
		switch (gasIntType) {
			case 1:
				gasType = "Premium";
				break;
			case 2:
				gasType = "Regular";
				break;
			case 3:
				gasType = "Diesel";
		}

		System.out.println("Enter the car fast charging state:");
		System.out.println("type: - true - if it has fast charging");
		System.out.println("type: - false - if it doesnt have fast charging");
		boolean fastCharger = readBoolean();

		System.out.println();
		System.out.println("Enter the car battery life:");
		double batteryLife = readDouble();

		HybridCar newHybridCar = new HybridCar(basePrice, brand, model, displacement, mileage, used, plate,
										carType,noDoors, polarized, 
										tankCapacity, gasType, fastCharger, batteryLife);

		if (carGoesToParkinglot(newHybridCar)) {
			System.out.println();
			System.out.println(dealer.addCarToParkingLot(newHybridCar));
		}

		vehicleDocumentsList(newHybridCar);

		return newHybridCar;
	}

/*
	
	/**
		description:
		*ask if the user wants to create a new client, and then runs the selected option
	*/
	public void runOptionregisterClient(){
		int option = 0;
		do{
			System.out.println();
			System.out.println("Register options:");
			System.out.println("1.Register Client 0. Exit");
			option = readInt();
			switch (option) {
				case 1:
					registerClient();
					break;
				case 0:
					System.out.println();
					System.out.println("Operation completed.");
					break;
				default:
					System.out.println();
					System.out.println("Invalid option.");
			}
		}while(option != 0);
	}

	/**
		
		*displays all the sellers and show wich are available, ask to select a seller to be in charge of the client and then call a method to create a client
		*@return newElecCar.
	*/
	public void registerClient(){
		int unavalibleSellers = 0;
		System.out.println();
		System.out.println("Select a seller to be in charge of the client: ");
		for (int i = 0; i < dealer.getSellers().length; i++) {
			if (dealer.getSellers()[i].getNumberOfClients() != 5) {
				System.out.println((i+1)+"."+dealer.getSellers()[i].getName()+". in charge of: "+dealer.getSellers()[i].getNumberOfClients()+" clients");	
			}else{
				System.out.println("Unavailable"+"."+dealer.getSellers()[i].getName()+". in charge of: "+dealer.getSellers()[i].getNumberOfClients()+" clients");
				unavalibleSellers += 1;
			}
		}

		if (unavalibleSellers == 10) {
			System.out.println();
			System.out.println("Sorry, there is not any available seller at the moment.");
		}else{
			int option = readInt();
			option = (int) checkOption(option,1,dealer.getSellers().length);
			if (dealer.getSellers()[option-1].getNumberOfClients() == 5) {
				System.out.println();
				System.out.println("Seller Unavailable. Pelase select an other one.");

			}else{
				Client client = newClient(dealer.getSellers()[option-1]);
				dealer.getSellers()[option-1].addClient(client);
				dealer.getClients().add(client);
				System.out.println();
				System.out.println("Client succesfully added.");
			}
			
		}
		
	}

	/**
		description
		*ask for all the needed information to create a new client
		*@return client.
	*/
	public Client newClient(Seller seller){
		System.out.println();
		System.out.println("Enter the clients name:");
		String name = in.nextLine();
		System.out.println("Enter the clients lastname: ");
		String lastname = in.nextLine();
		System.out.println("Enter de clients id:");
		String id = in.nextLine();
		System.out.println("Enter the clients phone number: ");
		String phoneNumber = in.nextLine();
		System.out.println("Enter the clients emal: ");
		String email = in.nextLine();
		Client client = new Client(name, lastname, id, seller, phoneNumber, email);
		return client;
	}
/*
	
*/
	/**
		description:
		*displays all the vehicles owned by the dealer, lets the user select one of them,
		*and then lets the user add a discount to the sell of this vehicle,
		*lets the user select a client, and then sells the selected vehicle to the selected client, with the selected discunt 
	*/
	public void runOptionSellVehicle(){
		System.out.println();
		System.out.println("Select a vehicle to sell");
		System.out.println("- type the given index number to select a vehicle.");
		int c = 0;
		for (int i = 0; i < dealer.getVehicles().size(); i++ ) {
			if (!dealer.getVehicles().get(i).getSelled()) {
				System.out.println("**** index: "+(i+1)+" *****");		
				System.out.println("-Brand: "+dealer.getVehicles().get(i).getBrand());	
				System.out.println("-Model: "+dealer.getVehicles().get(i).getModel());	
				System.out.println("-Total sale price: "+dealer.getVehicles().get(i).getTotalSalePrice());	
				c += 1;		
			}			
		}

		if (c == 0) {
			System.out.println();
			System.out.println("No available vehicles to sell");
			pressEnterToContinue();
		}else{
			int option = readInt();
			option = (int)checkOption(option, 1, dealer.getVehicles().size());
			if (dealer.getVehicles().get(option-1).getSelled()) {
			System.out.println();
			System.out.println("No available vehicles with the selected index, please select one of the shown.");
			}else{
				System.out.println();
				System.out.println("Enter the discount you whish to make to this sell.");
				System.out.println("-Enter the percentage of discount(0 for no discount, 100 sell for free)");
				double discount = readDouble();
				if (!dealer.getVehicles().get(option-1).getUsed()) {
					System.out.println();
					System.out.println("Enter the vehicles new plate.");
					String plate = in.nextLine();
					dealer.getVehicles().get(option-1).setPlate(plate);
				}
				Client buyer = selectClient();
				dealer.sellVehicle(buyer,dealer.getVehicles().get(option-1),discount);
				selledInfo(buyer,dealer.getVehicles().get(option-1));
			}	
		} 

		
	}

	/**
	
		*Displays the confirmation of a sell, showing the buyer and the vehicle that has been bought
		*@param client != null.
		*@param vehicle != null. must have a valid plate. must be already selled.
	*/
	public void selledInfo(Client client, Vehicle vehicle){
		System.out.println();
		System.out.println("The client "+client.getName()+" ID: "+client.getId());
		System.out.println("has bought the vehicle "+vehicle.getBrand()+" plate:"+vehicle.getPlate());
	}

/*
	************************************************** vehicle catalog *********************************************************
*/
	/** description:
		it shows the user different options, depending on what type of vehicle he wants to look
		
	*/
	public void runOptionVehicleCatalog(){
		int option = 0;
		do{
			System.out.println();
			System.out.println("Now, please select a catefory");
			System.out.println("1.All Vehicles");
			System.out.println("2. Only motorcycles");
			System.out.println("3. Only gas cars");
			System.out.println("4. Only electric cars");
			System.out.println("5. Only hybrid");	
			System.out.println("0.Exit");
			option = readInt();
			switch (option) {
				case 1:
					System.out.println();
					showVehicles();
					pressEnterToContinue();
					break;
				case 2:
					System.out.println();
					showMotorcycles();
					pressEnterToContinue();
					break;
				case 3:
					System.out.println();
					showgasCars();
					pressEnterToContinue();
					break;
				case 4:
					System.out.println();
					showElectricCars();
					pressEnterToContinue();
					break;
				case 5:
					System.out.println();
					showHybridCars();
					pressEnterToContinue();
					break;
				case 0:
					System.out.println();
					System.out.println("succesfull");
					break;
				default:
					System.out.println();
					System.out.println("invalid option");
			}

		}while(option != 0);
		
	}

	/**
		Description:
		This method shows  a message to select if show used/new vehicles or both.
		*then reads the option, and returns it.
		*@return option
	*/
	public int showUsedVehicles(){
		System.out.println();
		System.out.println("show:");
		System.out.println("1.Only used 2.Only new 3.Both");
		int option = readInt();
		option = (int) checkOption(option,1,3);
		return option;
	}

	/**
		
		This method displays all the vehicles of the dealer.
	*/
	public void showVehicles(){
		for (Vehicle vehicle : dealer.getVehicles() ) {
			System.out.println();
			System.out.println(vehicle.vehicleInfo());
		}
	}

	/**
		
		This method displays motorcycles that are on the dealers list, that have a specific caracteristic used/new or both.
	*/
	public void showMotorcycles(){
		switch (showUsedVehicles()) {
			case 1:
				for (Vehicle vehicle : dealer.getVehicles() ) {
					if(vehicle.getUsed() && vehicle instanceof Motorcycle){
						System.out.println();
						System.out.println(vehicle.vehicleInfo());
					}
					
				}
				break;
			case 2:
				for (Vehicle vehicle : dealer.getVehicles() ) {
					if(!vehicle.getUsed() && vehicle instanceof Motorcycle){
						System.out.println();
						System.out.println(vehicle.vehicleInfo());
					}
					
				}
				break;
			case 3:
				for (Vehicle vehicle : dealer.getVehicles() ) {
					if(vehicle instanceof Motorcycle){
						System.out.println();
						System.out.println(vehicle.vehicleInfo());
					}
					
				}
				break;
		}
		
	}

	/**
	
		This method displays gas cars that are on the dealers list, that have a specific caracteristic used/new or both.
	*/
	public void showgasCars(){
		switch (showUsedVehicles()) {
			case 1:
				for (Vehicle vehicle : dealer.getVehicles() ) {
					if(vehicle.getUsed() && vehicle instanceof GasCar){
						System.out.println();
						System.out.println(vehicle.vehicleInfo());
					}
					
				}
				break;
			case 2:
				for (Vehicle vehicle : dealer.getVehicles() ) {
					if(!vehicle.getUsed() && vehicle instanceof GasCar){
						System.out.println();
						System.out.println(vehicle.vehicleInfo());
					}
					
				}
				break;
			case 3:
				for (Vehicle vehicle : dealer.getVehicles() ) {
					if(vehicle instanceof GasCar){
						System.out.println();
						System.out.println(vehicle.vehicleInfo());
					}
					
				}
				break;
		}
	}

	/**
		
		This method displays Electric cars that are on the dealers list, that have a specific caracteristic used/new or both.
	*/
	public void showElectricCars(){
		switch (showUsedVehicles()) {
			case 1:
				for (Vehicle vehicle : dealer.getVehicles() ) {
					if(vehicle.getUsed() && vehicle instanceof ElectricCar){
						System.out.println();
						System.out.println(vehicle.vehicleInfo());
					}
					
				}
				break;
			case 2:
				for (Vehicle vehicle : dealer.getVehicles() ) {
					if(!vehicle.getUsed() && vehicle instanceof ElectricCar){
						System.out.println();
						System.out.println(vehicle.vehicleInfo());
					}
					
				}
				break;
			case 3:
				for (Vehicle vehicle : dealer.getVehicles() ) {
					if(vehicle instanceof ElectricCar){
						System.out.println();
						System.out.println(vehicle.vehicleInfo());
					}
					
				}
				break;
		}
	}

	/**
		
		This method displays hybrid cars that are on the dealers list, that have a specific caracteristic used/new or both.
	*/
	public void showHybridCars(){
		switch (showUsedVehicles()) {
			case 1:
				for (Vehicle vehicle : dealer.getVehicles() ) {
					if(vehicle.getUsed() && vehicle instanceof HybridCar){
						System.out.println();
						System.out.println(vehicle.vehicleInfo());
					}
					
				}
				break;
			case 2:
				for (Vehicle vehicle : dealer.getVehicles() ) {
					if(!vehicle.getUsed() && vehicle instanceof HybridCar){
						System.out.println();
						System.out.println(vehicle.vehicleInfo());
					}
					
				}
				break;
			case 3:
				for (Vehicle vehicle : dealer.getVehicles() ) {
					if(vehicle instanceof HybridCar){
						System.out.println();
						System.out.println(vehicle.vehicleInfo());
					}
					
				}
				break;
		}
	}

/*
	
	/**
		
		This method let  users select a client and then shows an option to either, add a vehicle to the wish list, or to display all the vehicles in the wishlist
	*/
	public void runOptionClientWishList(){
		int option = 0;
		Client client = selectClient();
		do{ 
			System.out.println();
			System.out.println("Select an option:");
			System.out.println("1.Add vehicle to wish list 2.Report of wish list 0.Exit");
			option = readInt();
			switch(option){
				case 1:
					addVehicleToWishList(client);
					break;
				case 2:
					showReportOfClientWishList(client);
					break;
				case 0:
					System.out.println();
					System.out.println("Operation completed.");
					break;
				default:
					System.out.println();
					System.out.println("Invalid option.");

			}
		}while(option != 0);
		
	}

	/**
		
		This method displays all the vehicles, and lets the user select a vehicle to add to the given clients wish list, then andds the selected vehicle to the client wish list.
		*@param client != null.
	*/
	public void addVehicleToWishList(Client client){
		System.out.println();
		int c = 0;
		for (int i = 0; i < dealer.getVehicles().size(); i++ ) {
			if (!dealer.getVehicles().get(i).getSelled() && ! client.getInterestedVehicles().contains(dealer.getVehicles().get(i))) {
				System.out.println("**** index: "+(i+1)+" *****");		
				System.out.println("-Brand: "+dealer.getVehicles().get(i).getBrand());	
				System.out.println("-Model: "+dealer.getVehicles().get(i).getModel());	
				System.out.println("-Total sale price: "+dealer.getVehicles().get(i).getTotalSalePrice());	
				c += 1;		
			}			
		}

		if (c == 0) {
			System.out.println();
			System.out.println("There is not available vehicles to add to the wish list");
			System.out.println("Take in to account that the vehicles that are allready in your wish list will not be displayed");
			pressEnterToContinue();
		}else{
			int option = readInt();
			option = (int)checkOption(option, 1, dealer.getVehicles().size());
			if (dealer.getVehicles().get(option-1).getSelled()) {
			System.out.println();
			System.out.println(" There is not available vehicles with the selected index, please select one of the shown.");
			}else{
				client.getInterestedVehicles().add(dealer.getVehicles().get(option-1));
				System.out.println("Vehicle succesfully added to the wish list");
			}	
		} 

	}

	/**
		
		This method displays all the vehicles in the clients wish list.
		*@param client != null. the client wishLis must have at least one vehicle
	*/
	public void showReportOfClientWishList(Client client){
		for (Vehicle vehicle : client.getInterestedVehicles() ) {
			System.out.println();
			System.out.println(vehicle.vehicleInfo());
		}
		pressEnterToContinue();
	}
/*
	
	/**
		
		This method displays all the clients and lets the user select one of then to show all the owned vehicles of that client.
	*/
	public void runOptionClientOwnedVehicles(){
		int option = 0;
		do{
			System.out.println();
			System.out.println("1.Select a client 0.Exit");
			option = readInt();
			switch (option) {
				case 1:
					Client client = selectClient();
			
					if (client.getOwnedVehicles().get(0) != null) {
						for (Vehicle vehicle : client.getOwnedVehicles() ) {
							System.out.println();
							System.out.println(vehicle.vehicleInfo());
						}	
						pressEnterToContinue();
					}else{
						System.out.println();
						System.out.println("The selected client hasnt buy any vehicles.");
					}
					break;
				case 0:
					System.out.println();
					System.out.println("Operation completed.");
					break;
				default:
					System.out.println();
					System.out.println("Invalid option.");
			}
			
		}while(option != 0);
		
		
	}
/*
	
	/
	
		This method displays all the vehicles in the parking lot.
	*/
	public void runOptionParkingLot(){
		int cent = 0;
		for (Car[] arrayCars : dealer.getParkingLot() ) {
			for ( Car car : arrayCars ) {
				if (car != null) {
					System.out.println();
					car.vehicleInfo();	
				}else{
					cent += 1;
				}
			}
		}

		if (cent == dealer.getParkingLot().length * dealer.getParkingLot()[0].length) {
			System.out.println();
			System.out.println("The parking lot is currently empty");
			pressEnterToContinue();
		}
	}


	
	public void startProgram() {
		showWellcome();
		int option;
		do{
			showPrincipalMenu();
			option = readInt();
			runOption(option);
		}while(option != EXIT);
	}

}