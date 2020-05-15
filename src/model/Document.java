package model;
import java.util.*;
public  abstract class Document{
	private final static int IMAGE_ROWS = 4;
	private final static int IMAGE_COLUMNS = 4;
	private double price;
	private int year;
	private int[][] image;

	/**
		*Name:Document
		*Document class constructor. sets all the atributes.
		*@param price > 0
		*@param year > 2000
	*/
	public Document(double price, int year) {
		this.price = price;
		this.year = year;
		image = new int[IMAGE_ROWS][IMAGE_COLUMNS];
		Random ran = new Random();
		for (int i = 0; i < image.length; i++ ) {
			for (int j = 0; j < image.length; j++ ) {
				image[i][j] = ran.nextInt(10);
			}
		}
	}


	/**
		*Name:getPrice
		*returns the price of the document.
		*@return price.
	*/	
	public double getPrice(){
		return price;
	}

	/**
		*Name:getYear
		*returns the publication year of the document.
		*@return year.
	*/
	public int getYear(){
		return year;
	}

	/**
		*Name:getImage
		*returns the image of the document.
		*@return image.
	*/
	public int[][] getImage(){
		return image;
	}

	/**
		*Name:documentsInfo
		*returns the information about the document.
		*@return price + year + decodedImage.
	*/
	public String documentsInfo(){
		return "-Price: "+price+
				" -Year: "+year+
				" -Number: "+ decodedImage();
	}

	/**
		*Name:DecodedImage
		*returns the  decoded image of the document, the number of the document.
	*/
	public abstract String decodedImage();

	/**
		*Name:getType
		*returns the type of the document
	*/
	public abstract String getType();

}