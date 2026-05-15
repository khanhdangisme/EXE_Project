package vn.work.exe.exe_project.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Suppliers")
public class Suppliers {

    @Id
    @Column(name = "SupplierID", length = 50)
    private String supplierId;

    @Column(name = "SupplierName", nullable = false, length = 150, columnDefinition = "nvarchar(150)")
    private String supplierName;

    @Column(name = "Country", length = 100, columnDefinition = "nvarchar(100)")
    private String country = "Vietnam";

    @Column(name = "VietGAPCode", length = 50)
    private String vietGapCode;

    @Column(name = "IssueDate")
    private LocalDate issueDate;

    @Column(name = "ExpiryDate")
    private LocalDate expiryDate;

    @Column(name = "IssuingBody", length = 150, columnDefinition = "nvarchar(150)")
    private String issuingBody;

    @Column(name = "CertImageURL", length = 500)
    private String certImageURL;

    @Lob // Đánh dấu đây là đối tượng lớn (Large Object)
    @Column(name = "CertImageBlob")
    private byte[] certImageBlob;

    @Column(name = "VerificationMethod", length = 50, columnDefinition = "nvarchar(50)")
    private String verificationMethod; // 'AI_SCAN' hoặc 'MANUAL'
}
