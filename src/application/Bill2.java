package application;

import java.io.Serializable;
import java.util.Date;

public class Bill2 implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long billNumber;
	private String paymentMethod;
	private int cashierId;
	private Object[] foodItems;
	private double hst;
	private double total;
	public Object[] getFoodItems() {
		return foodItems;
	}
	public void setFoodItems(Object[] foodItems) {
		this.foodItems = foodItems;
	}
	private Date billDate;

	public long getBillNumber() {
		return billNumber;
	}
	public void setBillNumber(long billNumber) {
		this.billNumber = billNumber;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	@Override
	public String toString() {
		return "Bill2 [billNumber=" + billNumber + ", paymentMethod=" + paymentMethod + ", cashierId=" + cashierId
				+ ", foodItems=" + foodItems + ", hst=" + hst + ", total=" + total + ", billDate=" + billDate + "]";
	}
	public int getCashierId() {
		return cashierId;
	}
	public void setCashierId(int cashierId) {
		this.cashierId = cashierId;
	}
	public double getHst() {
		return hst;
	}
	public void setHst(double hst) {
		this.hst = hst;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public Date getBillDate() {
		return billDate;
	}
	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}
}
