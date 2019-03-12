package com.backendpro.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table
public class Product implements Serializable{
	
	@Id
	//@SequenceGenerator(name="proseq", initialValue=1)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int productId;
	
	@NotNull(message="Kindly fill in the avaiable stock")
	private Integer productQuantity;
	
	@NotEmpty(message="Kindly fill in the Pet Name")
	private String productName;
	
	@NotNull(message="Kindly fill in the Pet Price")
	private Integer productPrice;
	
	@NotEmpty(message="Kindly fill in the Pet Description")
	private String productDescription;

	private int categoryId;
	
	@Transient
	MultipartFile pImage;
	
	private String imgName;
	
	@JoinColumn(name = "categoryId",insertable = false,updatable = false,nullable = false)
	@ManyToOne
	Category category;
	
	private int supplierId;
	
	@JoinColumn(name = "supplierId",insertable = false, updatable = false,nullable = false)
	@ManyToOne
	Supplier supplier;

	/*public int getProductId() {
		return productId;
	}


	public void setProductId(int productId) {
		this.productId = productId;
	}


	public int getProductQuantity() {
		return productQuantity;
	}


	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public int getProductPrice() {
		return productPrice;
	}


	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}


	public String getProductDescription() {
		return productDescription;
	}


	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}


	public int getCategoryId() {
		return categoryId;
	}


	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}

	
	public int getSupplierId() {
		return supplierId;
	}


	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}


	public Supplier getSupplier() {
		return supplier;
	}


	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}


	public MultipartFile getpImage() {
		return pImage;
	}


	public void setpImage(MultipartFile pImage) {
		this.pImage = pImage;
	}


	public String getImgName() {
		return imgName;
	}


	public void setImgName(String imgName) {
		this.imgName = imgName;
	}
*/
	
	

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public Integer getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(Integer productQuantity) {
		this.productQuantity = productQuantity;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Integer productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public MultipartFile getpImage() {
		return pImage;
	}

	public void setpImage(MultipartFile pImage) {
		this.pImage = pImage;
	}

	public String getImgName() {
		return imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	
	
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productQuantity=" + productQuantity + ", productName="
				+ productName + ", productPrice=" + productPrice + ", productDescription=" + productDescription
				+ ", categoryId=" + categoryId + ", SupplierID= "+supplierId+"]";
	}

	

}
