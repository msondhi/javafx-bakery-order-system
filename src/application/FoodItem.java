package application;

import javafx.beans.property.SimpleStringProperty;

public  class FoodItem {
    private final SimpleStringProperty productName;
    private final SimpleStringProperty price;
    private SimpleStringProperty quantity;
     ;
 
   public FoodItem(String pName, String price,String quantity) {
        this.productName = new SimpleStringProperty(pName);
        this.price = new SimpleStringProperty(price);
        this.quantity = new SimpleStringProperty(quantity);
    }
	public SimpleStringProperty getQuantity() {
		return quantity;
	}
	public SimpleStringProperty getProductName() {
		return productName;
	}
	public SimpleStringProperty getPrice() {
		return price;
	} 
	 public void setLastName(String pName) {
	        productName.set(pName);
	    }
	public void setQuantity(SimpleStringProperty quantity) {
		this.quantity = quantity;
	}
	
	 
}