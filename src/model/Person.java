package model;
public class Person{
	private String name;
	private String lastname;
	private String id;

	/**
		*Name:Person
		*Person class constructor. sets all the atributes
		*@param name !=""
		*@param lastname !=""
		*@param id != ""
	*/
	public Person(String name, String lastname, String id){
		this.name = name;
		this.lastname = lastname;
		this.id = id;
	}	

	/**
		*Name:getName
		*returns the name of the dealer.
		*@return name.
	*/	
	public String getName() {
		return name;
	}

	/**
		*Name:getLastname
		*returns the lastname of the person.
		*@return lastname.
	*/	
	public String getLastname() {
		return lastname;
	}

	/**
		*Name:getId
		*returns the id numbero of a person.
		*@return id.
	*/	
	public String getId() {
		return id;
	}
}