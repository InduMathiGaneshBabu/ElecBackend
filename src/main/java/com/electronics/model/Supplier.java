package com.electronics.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Supplier 
{
	@Id
	@GeneratedValue
int supplierid;
 String suppliername;
 String supplieraddr;
public int getSupplierid() {
	return supplierid;
}
public void setSupplierid(int supplierid) {
	this.supplierid = supplierid;
}
public String getSuppliername() {
	return suppliername;
}
public void setSuppliername(String suppliername) {
	this.suppliername = suppliername;
}
public String getSupplieraddr() {
	return supplieraddr;
}
public void setSupplieraddr(String supplieraddr) {
	this.supplieraddr = supplieraddr;
}

}
