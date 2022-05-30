package com.example.demo2.dto;

public class UserRequest {

	private String productName;
	private int count;
	private int releaseYear;

	@Override
	public String toString() {
		return "UserRequest [productName=" + productName + ", count=" + count + ", releaseYear=" + releaseYear + "]";
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

}
