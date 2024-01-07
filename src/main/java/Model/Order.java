package Model;

public class Order {
private int idcustomer;
private int quantity;
private double sumtotol;
private String date;

public int getIdcustomer() {
	return idcustomer;
}
public void setIdcustomer(int idcustomer) {
	this.idcustomer = idcustomer;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public double getSumtotol() {
	return sumtotol;
}
public void setSumtotol(double sumtotol) {
	this.sumtotol = sumtotol;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public Order(int idcustomer, int quantity, double sumtotol, String date) {
	super();
	this.idcustomer = idcustomer;
	this.quantity = quantity;
	this.sumtotol = sumtotol;
	this.date = date;
}

}
