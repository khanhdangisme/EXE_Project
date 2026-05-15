package vn.work.exe.exe_project.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ScaleDevices")
public class ScaleDevices {

    @Id
    @Column(name = "ScaleID", length = 50)
    private String scaleId; // Đây là địa chỉ MAC hoặc ID bạn set trong code ESP32

    @Column(name = "DeviceName", nullable = false, length = 100, columnDefinition = "nvarchar(100)")
    private String deviceName;

    @Column(name = "Location", length = 100, columnDefinition = "nvarchar(100)")
    private String location;

    @Column(name = "ScreenBrightness")
    private Integer screenBrightness = 100; // Giá trị từ 0-100

    @Column(name = "VoiceEnabled")
    private Boolean voiceEnabled = true; // Bật/Tắt giọng đọc

    @Column(name = "Status")
    private Boolean status = true; // Hoạt động hoặc bảo trì
}