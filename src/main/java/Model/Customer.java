package Model;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	private int iduser;
	private String name;
	private String email;
	private String address;
	private String phone;
	private double pricesum;
	private String date;
	List<Product> listPro = new ArrayList<>();
	List listCustommer = new ArrayList<>();

	public Customer(int iduser, String name, String email, String address, String phone, double pricesum, String date) {
		super();
		this.iduser = iduser;
		this.name = name;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.pricesum = pricesum;
		this.date = date;
	}

	public Customer() {

	}

	public int getIduser() {
		return iduser;
	}

	public void setIduser(int iduser) {
		this.iduser = iduser;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public double getPricesum() {
		return pricesum;
	}

	public void setPricesum(double pricesum) {
		this.pricesum = pricesum;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public List<Product> getListPro() {
		return listPro;
	}

	public void setListPro(List<Product> listPro) {
		this.listPro = listPro;
	}

	public List getListCustommer() {
		return listCustommer;
	}

	public void setListCustommer(List listCustommer) {
		this.listCustommer = listCustommer;
	}

	@Override
	public String toString() {
		return "Customer [iduser=" + iduser + ", name=" + name + ", email=" + email + ", address=" + address
				+ ", phone=" + phone + ", pricesum=" + pricesum + ", date=" + date + ", listPro=" + listPro
				+ ", listCustommer=" + listCustommer + "]";
	}
	

}
