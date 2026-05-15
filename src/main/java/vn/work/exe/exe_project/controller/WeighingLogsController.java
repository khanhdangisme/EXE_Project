package vn.work.exe.exe_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import vn.work.exe.exe_project.services.FileService;
import vn.work.exe.exe_project.services.WeighingLogsService; // Dùng Interface

@RestController
@RequestMapping("/api/weighing")
public class WeighingLogsController {

    @Autowired
    private FileService fileService;

    @Autowired
    private WeighingLogsService weighingLogsService; // Tiêm Interface vào đây

    @PostMapping("/upload")
    public ResponseEntity<?> handleWeighing(
            @RequestParam(value ="image", required = false) MultipartFile image, //sau này có Cam sẽ bỏ required = false
            @RequestParam("weight") Double weight,
            @RequestParam("scaleId") String scaleId,
            @RequestParam("productId") String productId) {

        // Bước 1: Lưu file vật lý vào folder D:/SpringBoot/EXE/EXE_DataUploads
        String imagePath = fileService.saveFile(image, "weighing_logs");

        // Bước 2: Lưu thông tin vào Database SQL Server qua Service
        weighingLogsService.saveLog(productId, scaleId, weight, imagePath);

        return ResponseEntity.ok("Cân thành công! Ảnh lưu tại: " + imagePath);
    }
}