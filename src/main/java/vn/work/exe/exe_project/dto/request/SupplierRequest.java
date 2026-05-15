package vn.work.exe.exe_project.dto.request;

import java.time.LocalDate;

public record SupplierRequest(
        String supplierId,
        String supplierName,
        String country,
        String vietGapCode,
        LocalDate issueDate,
        LocalDate expiryDate,
        String issuingBody,
        String certImageURL,
        String verificationMethod
) {}