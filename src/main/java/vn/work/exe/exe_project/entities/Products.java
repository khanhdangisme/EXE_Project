package vn.work.exe.exe_project.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Products")
public class Products {
    @Id
    @Column(name = "ProductID", length = 50)
    private String productId;

    @Column(name = "ProductName", nullable = false, length = 150, columnDefinition = "nvarchar(150)")
    private String productName;

    @Column(name = "CaloriesPer100g")
    private Integer caloriesPer100g = 0;

    @Column(name = "StandardWeight", precision = 10, scale = 2)
    private BigDecimal standardWeight;

    @Column(name = "AllowedError", precision = 5, scale = 2)
    private BigDecimal allowedError;

    // --- CÁC TRƯỜNG BỔ SUNG ---
    @Column(name = "ProductImageURL", length = 500)
    private String productImageURL; // Để hiển thị hình ảnh quả táo/chuối trên App

    @Column(name = "Description", columnDefinition = "nvarchar(max)")
    private String description;

    @Column(name = "VietGAPStatus")
    private Boolean vietGapStatus = false;
    // --------------------------

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SupplierID")
    private Suppliers suppliers;
}
