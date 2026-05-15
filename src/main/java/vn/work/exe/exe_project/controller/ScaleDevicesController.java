package vn.work.exe.exe_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.work.exe.exe_project.dto.request.ScaleDeviceRequest;
import vn.work.exe.exe_project.services.ScaleDevicesService;

@RestController
@RequestMapping("/api/scale-devices")
public class ScaleDevicesController {

    @Autowired
    private ScaleDevicesService scaleDevicesService;

    @PostMapping("/create")
    public ResponseEntity<?> createScaleDevice(@RequestBody ScaleDeviceRequest request) {
        try {
            return ResponseEntity.ok(scaleDevicesService.createScaleDevice(request));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}