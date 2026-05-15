package vn.work.exe.exe_project.services;

import vn.work.exe.exe_project.dto.request.SupplierRequest;
import vn.work.exe.exe_project.entities.Suppliers;

public interface SuppliersService {
    Suppliers createSupplier(SupplierRequest request);
}
