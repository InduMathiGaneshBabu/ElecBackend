package com.electronics.Dao;
import java.util.List;

import com.electronics.model.Supplier;

public interface SupplierDao 
{
public boolean addsupplier(Supplier supplier);
public boolean deletesupplier(Supplier supplier);
public boolean updatesupplier(Supplier supplier);
public Supplier getsupplier(int supplierid);
public List<Supplier> listsupplier();
}
