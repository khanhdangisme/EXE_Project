package vn.work.exe.exe_project.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.work.exe.exe_project.dto.request.ProductRequest;
import vn.work.exe.exe_project.entities.Products;
import vn.work.exe.exe_project.entities.Suppliers;
import vn.work.exe.exe_project.repositories.ProductsRepository;
import vn.work.exe.exe_project.repositories.SuppliersRepository;
import vn.work.exe.exe_project.services.ProductsService;

@Service
public class ProductsServiceImpl implements ProductsService {

    @Autowired
    private ProductsRepository productRepository;

    @Autowired
    private SuppliersRepository supplierRepository;

    @Override
    public Products createProduct(ProductRequest request) {
        // 1. Kiểm tra Nhà cung cấp có tồn tại không (tránh lỗi khóa ngoại SQL)
        Suppliers supplier = supplierRepository.findById(request.supplierId())
                .orElseThrow(() -> new RuntimeException("Nhà cung cấp không tồn tại! Hãy tạo nhà cung cấp trước."));

        // 2. Map dữ liệu từ Record DTO sang Entity để lưu trữ
        Products product = new Products();
        product.setProductId(request.productId());
        product.setProductName(request.productName());
        product.setSuppliers(supplier); // Thiết lập mối quan hệ FK

        // Xử lý giá trị mặc định nếu client không truyền lên
        product.setCaloriesPer100g(request.caloriesPer100g() != null ? request.caloriesPer100g() : 0);
        product.setStandardWeight(request.standardWeight());
        product.setAllowedError(request.allowedError());
        product.setDescription(request.description());
        product.setVietGapStatus(request.vietGAPStatus() != null ? request.vietGAPStatus() : false);

        // 3. Lưu xuống Database
        return productRepository.save(product);
    }
}