package com.backendpro.dao;

import java.util.List;

import com.backendpro.model.Supplier;

public interface SupplierDao {
	boolean addSupplier(Supplier supplier);
	boolean updateSupplier(Supplier supplier);
	List<Supplier> getAllSuppliers();
	boolean deleteSupplier(int supplierId);
	Supplier getSupplierById(int supplierId);

}
