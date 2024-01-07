package Model;

import java.io.Serializable;

public class LineItem implements Serializable {
	private Product product;
	private int quantity;

	public LineItem() {
	}

	public void setProduct(Product p) {
		product = p;
	}

	public Product getProduct() {
		return product;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getQuantity() {
		return quantity;
	}

	public double getTotal() {
		double total = product.getPricepro() * quantity;
		return total;
	}

}
