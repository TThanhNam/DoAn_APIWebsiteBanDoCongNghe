package com.example.detailCartService.VO;

public class Product {
	private int productID;
	private String name;
	private String type;
	private int ram;
	private int rom;
	private String color;
	private double price;
	private String producer;
	private String discription;
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getRam() {
		return ram;
	}
	public void setRam(int ram) {
		this.ram = ram;
	}
	public int getRom() {
		return rom;
	}
	public void setRom(int rom) {
		this.rom = rom;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getProducer() {
		return producer;
	}
	public void setProducer(String producer) {
		this.producer = producer;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	public Product(int productID, String name, String type, int ram, int rom, String color, double price,
			String producer, String discription) {
		super();
		this.productID = productID;
		this.name = name;
		this.type = type;
		this.ram = ram;
		this.rom = rom;
		this.color = color;
		this.price = price;
		this.producer = producer;
		this.discription = discription;
	}
	public Product() {
		super();
	}
	@Override
	public String toString() {
		return "Product [productID=" + productID + ", name=" + name + ", type=" + type + ", ram=" + ram + ", rom=" + rom
				+ ", color=" + color + ", price=" + price + ", producer=" + producer + ", discription=" + discription
				+ "]";
	}
	
}
