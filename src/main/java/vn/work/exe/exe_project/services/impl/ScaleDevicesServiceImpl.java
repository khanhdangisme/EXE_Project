package vn.work.exe.exe_project.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.work.exe.exe_project.dto.request.ScaleDeviceRequest;
import vn.work.exe.exe_project.entities.ScaleDevices;
import vn.work.exe.exe_project.repositories.ScaleDevicesRepository;
import vn.work.exe.exe_project.services.ScaleDevicesService;

@Service
public class ScaleDevicesServiceImpl implements ScaleDevicesService {

    @Autowired
    private ScaleDevicesRepository scaleDevicesRepository;

    @Override
    public ScaleDevices createScaleDevice(ScaleDeviceRequest request) {
        // Kiểm tra trùng khóa chính ScaleID
        if (scaleDevicesRepository.existsById(request.scaleId())) {
            throw new RuntimeException("Mã thiết bị cân (ScaleID) này đã tồn tại!");
        }

        ScaleDevices device = new ScaleDevices();
        device.setScaleId(request.scaleId());
        device.setDeviceName(request.deviceName());
        device.setLocation(request.location());

        // Nếu client không truyền thì lấy giá trị mặc định của Entity
        device.setScreenBrightness(request.screenBrightness() != null ? request.screenBrightness() : 100);
        device.setVoiceEnabled(request.voiceEnabled() != null ? request.voiceEnabled() : true);
        device.setStatus(request.status() != null ? request.status() : true);

        return scaleDevicesRepository.save(device);
    }
}