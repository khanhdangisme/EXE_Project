package vn.work.exe.exe_project.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "WeighingLogs")
public class WeighingLogs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LogID")
    private Long logId;

    @Column(name = "Weight", nullable = false, precision = 10, scale = 3)
    private BigDecimal weight; // Khối lượng thực tế (kg)

    @Column(name = "TotalCalories", precision = 10, scale = 2)
    private BigDecimal totalCalories; // Kết quả tính toán từ API

    @Column(name = "RipenessLevel", length = 50, columnDefinition = "nvarchar(50)")
    private String ripenessLevel; // Kết quả từ Camera AI (Chín, Xanh...)

    @Column(name = "FreshnessLevel", length = 50, columnDefinition = "nvarchar(50)")
    private String freshnessLevel; // Kết quả từ Camera AI (Tươi, Héo...)

    @Column(name = "LogStatus")
    private Integer logStatus = 0; // 0: OK, 1: Anomaly (Vật lạ/Lỗi)

    @Column(name = "CreatedAt", updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    // Liên kết với thiết bị cân
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ScaleID", referencedColumnName = "ScaleID")
    private ScaleDevices scaleDevice;

    // Liên kết với sản phẩm
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ProductID", referencedColumnName = "ProductID")
    private Products product;
}
