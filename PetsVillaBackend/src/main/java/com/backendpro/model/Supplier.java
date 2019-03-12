package com.backendpro.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Entity
@Component
public class Supplier implements Serializable {
	
	@Id
	//@SequenceGenerator(name="supseq", initialValue=1)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int supplierId;
	
	@NotEmpty(message="Kindly fill in the name of the supplier")
	private String supplierName;
	
	@NotEmpty(message="Kindly fill in the Supplier Address")
	private String supplierAddress;
	
	@OneToMany(mappedBy = "supplier",cascade = CascadeType.REMOVE,fetch = FetchType.EAGER)
	private List<Product> products=new ArrayList<Product>();

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getSupplierAddress() {
		return supplierAddress;
	}

	public void setSupplierAddress(String supplierAddress) {
		this.supplierAddress = supplierAddress;
	}

	@Override
	public String toString() {
		return "Supplier [supplierId=" + supplierId + ", supplierName=" + supplierName + ", supplierAddress="
				+ supplierAddress + "]";
	}

	

}
