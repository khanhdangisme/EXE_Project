package vn.work.exe.exe_project.services;

import vn.work.exe.exe_project.dto.request.ProductRequest;
import vn.work.exe.exe_project.entities.Products;

public interface ProductsService {
    Products createProduct(ProductRequest request);
}
