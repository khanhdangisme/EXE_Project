package vn.work.exe.exe_project.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.work.exe.exe_project.entities.Products;
import vn.work.exe.exe_project.entities.ScaleDevices;
import vn.work.exe.exe_project.entities.WeighingLogs;
import vn.work.exe.exe_project.repositories.ProductsRepository;
import vn.work.exe.exe_project.repositories.ScaleDevicesRepository;
import vn.work.exe.exe_project.repositories.WeighingLogsRepository;
import vn.work.exe.exe_project.services.WeighingLogsService;

import java.math.BigDecimal;

@Service
public class WeighingLogsServiceImpl implements WeighingLogsService {
    @Autowired
    private WeighingLogsRepository weighingLogsRepository;

    @Autowired
    private ProductsRepository productRepository;

    @Autowired
    private ScaleDevicesRepository scaleDeviceRepository;

    @Override
    public void saveLog(String productId, String scaleId, Double weight, String imagePath) {
        // 1. Tìm thông tin sản phẩm và thiết bị (để lấy khóa ngoại)
        Products product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy sản phẩm"));
        ScaleDevices device = scaleDeviceRepository.findById(scaleId)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy thiết bị"));

        // 2. Tạo đối tượng Log mới
        WeighingLogs log = new WeighingLogs();
        log.setProduct(product);
        log.setScaleDevice(device);
        log.setWeight(BigDecimal.valueOf(weight));

        // 3. Tính Calories (Weight * CaloriesPer100g / 100)
        double totalCal = weight * (product.getCaloriesPer100g() / 100.0);
        log.setTotalCalories(BigDecimal.valueOf(totalCal));

        // 4. Lưu đường dẫn ảnh thực tế (Ảnh từ ESP32 gửi về)
        log.setFreshnessLevel("Checking..."); // Chỗ này sau này AI sẽ điền
        log.setLogStatus(0);

        // 5. Lưu xuống Database
        weighingLogsRepository.save(log);
    }
}
