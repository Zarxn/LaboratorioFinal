package model;
public class Soat extends Document{
	private double accidentTotalMount;

	/**
		*Name:Document
		*Document class constructor. sets all the atributes.
		*first two are set by the super class constructor,super class: Document
		*@param price > 0
		*@param year > 2000
		*@param accidentTotalMount  >= 0
	*/
	public Soat(double price, int year,
				double accidentTotalMount) {
		super(price,year);
		this.accidentTotalMount = accidentTotalMount;
		
	}
	
	/**
		*Name:getAccidentTotalMount
		*returns the total accident mount of the vehicle.
		*@return accidentTotalMount.
	*/	
	public double getAccidentTotalMount(){
		return accidentTotalMount;
	}

	/**
		*Name:DecodedImage
		*returns the  decoded image of the document, the number of the document.
		*@return image.
	*/
	@Override
	public String decodedImage(){
		String image = "";
		for (int i = 0; i < super.getImage().length ; i++ ) {
			image += super.getImage()[i][0];
		}

		for (int i = 1; i < super.getImage().length ; i++ ) {
			image += super.getImage()[super.getImage().length-1][i];
		}

		return image;
	}

	/**
		*Name:documentsInfo
		*returns the information about the document
		*complements the super class method by adding more specific information.
		*@return price + year + decodedImage + type + emittedGasLevel + accidentTotalMount.
	*/
	@Override
	public String documentsInfo(){
		return super.documentsInfo()+
				" -Document type: "+ getType() +
				" -Accident mount: "+accidentTotalMount;
	}

	/**
		*Name:getType
		*returns the type of the document
		*@return "SOAT".
	*/
	@Override
	public String getType(){
		return "Soat";
	}

}