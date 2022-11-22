package com.example.detailCartService.model;

public class Product {
	private int idPD;
	private String namePD;
	private String typePD;
	private int ramPD;
	private int romPD;
	private String colorPD;
	private double pricePD;
	private String prodecerPD;
	private String discriptionPD;

	public int getIdPD() {
		return idPD;
	}

	public void setIdPD(int idPD) {
		this.idPD = idPD;
	}

	public String getNamePD() {
		return namePD;
	}

	public void setNamePD(String namePD) {
		this.namePD = namePD;
	}

	public String getTypePD() {
		return typePD;
	}

	public void setTypePD(String typePD) {
		this.typePD = typePD;
	}

	public int getRamPD() {
		return ramPD;
	}

	public void setRamPD(int ramPD) {
		this.ramPD = ramPD;
	}

	public int getRomPD() {
		return romPD;
	}

	public void setRomPD(int romPD) {
		this.romPD = romPD;
	}

	public String getColorPD() {
		return colorPD;
	}

	public void setColorPD(String colorPD) {
		this.colorPD = colorPD;
	}

	public double getPricePD() {
		return pricePD;
	}

	public void setPricePD(double pricePD) {
		this.pricePD = pricePD;
	}

	public String getProdecerPD() {
		return prodecerPD;
	}

	public void setProdecerPD(String prodecerPD) {
		this.prodecerPD = prodecerPD;
	}

	public String getDiscriptionPD() {
		return discriptionPD;
	}

	public void setDiscriptionPD(String discriptionPD) {
		this.discriptionPD = discriptionPD;
	}

	public Product() {
		super();
	}

	public Product(int idPD, String namePD, String typePD, int ramPD, int romPD, String colorPD, double pricePD,
			String prodecerPD, String discriptionPD) {
		super();
		this.idPD = idPD;
		this.namePD = namePD;
		this.typePD = typePD;
		this.ramPD = ramPD;
		this.romPD = romPD;
		this.colorPD = colorPD;
		this.pricePD = pricePD;
		this.prodecerPD = prodecerPD;
		this.discriptionPD = discriptionPD;
	}

	@Override
	public String toString() {
		return "Product [idPD=" + idPD + ", namePD=" + namePD + ", typePD=" + typePD + ", ramPD=" + ramPD + ", romPD="
				+ romPD + ", colorPD=" + colorPD + ", pricePD=" + pricePD + ", prodecerPD=" + prodecerPD
				+ ", discriptionPD=" + discriptionPD + "]";
	}
}
