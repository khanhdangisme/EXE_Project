package vn.work.exe.exe_project.services;

import vn.work.exe.exe_project.dto.request.ScaleDeviceRequest;
import vn.work.exe.exe_project.entities.ScaleDevices;

public interface ScaleDevicesService {
    ScaleDevices createScaleDevice(ScaleDeviceRequest request);
}
