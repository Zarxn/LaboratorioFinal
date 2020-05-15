package model;
public class Review extends Document{
	private double emittedGasLevel;

	/**
		*Name:Document
		*Document class constructor. sets all the atributes.
		*first two are set by the super class constructor,super class: Document
		*@param price > 0
		*@param year > 2000
		*@param emittedgasLevel  >= 0
	*/
	public Review(double price, int year,
					double emittedGasLevel) {
		super(price,year);
		this.emittedGasLevel = emittedGasLevel;
	}


	/**
		*Name:getEmittedgasLevel
		*returns the total emitted gas level of the vehicle.
		*@return accidentTotalMount.
	*/
	public double getEmittedGasLevel(){
		return emittedGasLevel;
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
			image += super.getImage()[0][i];
		}

		for (int i = 1; i < super.getImage().length ; i++ ) {
			for (int j = super.getImage().length-2; j >= 0 ; j-- ) {
				image += super.getImage()[i][j];
			}
		}

		for (int i = 1; i < super.getImage().length ; i++ ) {
			image += super.getImage()[super.getImage().length-3][i];
		}

		return image;
	}

	/**
		*Name:documentsInfo
		*returns the information about the document
		*complements the super class method by adding more specific information.
		*@return price + year + decodedImage + type + emittedGasLevel.
	*/
	@Override
	public String documentsInfo(){
		return super.documentsInfo()+
				" -Document type: "+ getType() +
				" -Emitted gas level: "+emittedGasLevel;
	}

	/**
		*Name:getType
		*returns the type of the document
		*@return "TMReview".
	*/
	@Override
	public String getType(){
		return "TMReview";
	}
}