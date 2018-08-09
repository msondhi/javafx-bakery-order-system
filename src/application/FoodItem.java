package application;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public  class FoodItem {
    private StringProperty productName = new SimpleStringProperty();
    private DoubleProperty price = new SimpleDoubleProperty();
    private IntegerProperty quantity = new SimpleIntegerProperty();
 
   public FoodItem(String pName, String price,String quantity) {
        this.productName = new SimpleStringProperty(pName);
        this.price = new SimpleDoubleProperty(Double.parseDouble(price));
        this.quantity = new SimpleIntegerProperty(Integer.parseInt(quantity));
    }
	
   public Integer getQuantity() {
		return quantity.get();
	}
	public void setQuantity(Integer newquantity) {
		quantity.set(newquantity);
	}
	public IntegerProperty quantityProperty() {
	    return quantity;
	}
	
	public String getProductName() {
		return productName.get();
	}
	public void setProductName(String newProductName) {
		productName.set(newProductName);
	}
	public StringProperty productNameProperty() {
	    return productName;
	}

	public Double getPrice() {
		return price.get();
	}
	public void setPrice(Double newPrice) {
		price.set(newPrice);
	}
	public DoubleProperty priceProperty() {
	    return price;
	}
}