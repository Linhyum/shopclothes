package Model;

public class Product {
	private int id; 
	private String namepro; 
	private String imagepro;
	private double pricepro;
	private String title;
	private String description;
	private int cateid;
	private int quantity;

	public Product(int id,int quantity) {
		super();
		this.id = id;
		this.quantity = quantity;
	}
	public Product() {
		id = 0;
		namepro = "";
		imagepro = "";
		pricepro = 0;
		title = "";
		description = "";
		cateid = 0;
	}
	public Product(int id, String namepro, String imagepro, double pricepro, String title, String description,
			int cateid, int quantity) {
		super();
		this.id = id;
		this.namepro = namepro;
		this.imagepro = imagepro;
		this.pricepro = pricepro;
		this.title = title;
		this.description = description;
		this.cateid = cateid;
		this.quantity = quantity;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNamepro() {
		return namepro;
	}
	public void setNamepro(String namepro) {
		this.namepro = namepro;
	}
	public String getImagepro() {
		return imagepro;
	}
	public void setImagepro(String imagepro) {
		this.imagepro = imagepro;
	}
	public double getPricepro() {
		return pricepro;
	}
	public void setPricepro(double pricepro) {
		this.pricepro = pricepro;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getCateid() {
		return cateid;
	}
	public void setCateid(int cateid) {
		this.cateid = cateid;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", namepro=" + namepro + ", imagepro=" + imagepro + ", pricepro=" + pricepro
				+ ", title=" + title + ", description=" + description + ", cateid=" + cateid + ", quantity=" + quantity
				+ "]";
	}

	
	
}
