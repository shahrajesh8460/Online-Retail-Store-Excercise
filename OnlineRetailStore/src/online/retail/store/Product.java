package online.retail.store;

public class Product {
	private int productId;
	private String productName;
	private String description;
	private char category;
	private double price;
	private int quantity;
	
	public Product(){
		
	}
	
	
	public Product(int productId,String productName, String description, char category, double price ){
		
		this.productId=productId;
		this.productName=productName;
		this.description=description;
		this.category=category;
		this.price=price;
	
	}
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public char getCategory() {
		return category;
	}
	public void setCategory(char category) {
		this.category = category;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


}
