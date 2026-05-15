package vn.work.exe.exe_project.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.work.exe.exe_project.dto.request.SupplierRequest;
import vn.work.exe.exe_project.entities.Suppliers;
import vn.work.exe.exe_project.repositories.SuppliersRepository;
import vn.work.exe.exe_project.services.SuppliersService;

@Service
public class SuppliersServiceImpl implements SuppliersService {

    @Autowired
    private SuppliersRepository suppliersRepository;

    @Override
    public Suppliers createSupplier(SupplierRequest request) {
        // Kiểm tra xem ID vựa đã tồn tại chưa để tránh lỗi trùng khóa chính (Primary Key)
        if (suppliersRepository.existsById(request.supplierId())) {
            throw new RuntimeException("Mã nhà cung cấp này đã tồn tại trong hệ thống!");
        }

        // Map dữ liệu từ Record sang Entity
        Suppliers supplier = new Suppliers();
        supplier.setSupplierId(request.supplierId());
        supplier.setSupplierName(request.supplierName());
        supplier.setCountry(request.country() != null ? request.country() : "Vietnam");
        supplier.setVietGapCode(request.vietGapCode());
        supplier.setIssueDate(request.issueDate());
        supplier.setExpiryDate(request.expiryDate());
        supplier.setIssuingBody(request.issuingBody());
        supplier.setCertImageURL(request.certImageURL());
        supplier.setVerificationMethod(request.verificationMethod());

        // Lưu xuống database
        return suppliersRepository.save(supplier);
    }
}