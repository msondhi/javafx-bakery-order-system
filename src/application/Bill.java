package application;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Bill {
	private LongProperty billId = new SimpleLongProperty();
    private StringProperty paymentMethod = new SimpleStringProperty();
    private IntegerProperty CashierId = new SimpleIntegerProperty();
 
   public Bill(Long billId, String paymentMethod,Integer CashierId) {
        this.billId = new SimpleLongProperty(billId);
        this.paymentMethod = new SimpleStringProperty(paymentMethod);
        this.CashierId = new SimpleIntegerProperty(CashierId);
    }
	
  
	
	public Long getbillId() {
		return billId.get();
	}
	
	public void setbillId(Integer newquantity) {
		billId.set(newquantity);
	}
	
	public LongProperty billIdProperty() {
	    return billId;
	}
	

	
	public String getpaymentMethod() {
		return paymentMethod.get();
	}
	public void setProductName(String newProductName) {
		paymentMethod.set(newProductName);
	}
	public StringProperty productNameProperty() {
	    return paymentMethod;
	}

	public Integer getPrice() {
		return CashierId.get();
	}
	public void setPrice(Integer newPrice) {
		CashierId.set(newPrice);
	}
	public IntegerProperty priceProperty() {
	    return CashierId;
	}
	
	
}


