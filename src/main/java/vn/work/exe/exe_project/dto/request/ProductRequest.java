package vn.work.exe.exe_project.dto.request;

import java.math.BigDecimal;

public record ProductRequest(
        String productId,
        String productName,
        String supplierId,
        Integer caloriesPer100g,
        BigDecimal standardWeight,
        BigDecimal allowedError,
        String description,
        Boolean vietGAPStatus
) {}