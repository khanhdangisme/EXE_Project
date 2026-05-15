package vn.work.exe.exe_project.services.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import vn.work.exe.exe_project.services.FileService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {

    @Value("${file.upload-dir}")
    private String uploadDir;

    @Override
    public String saveFile(MultipartFile file, String subFolder) {
        try {
            // 1. Tạo folder theo ngày hiện tại: ví dụ weighing_logs/2026-05-16/
            String dateFolder = LocalDate.now().toString();
            Path rootPath = Paths.get(uploadDir, subFolder, dateFolder);

            if (!Files.exists(rootPath)) {
                Files.createDirectories(rootPath);
            }

            // 2. Tạo tên file duy nhất để không bị ghi đè (Dùng UUID + tên gốc)
            String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
            Path filePath = rootPath.resolve(fileName);

            // 3. Chép dữ liệu vào file trên ổ cứng
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            // 4. Trả về đường dẫn tương đối để lưu vào Database
            // Ví dụ: weighing_logs/2026-05-16/abc-xyz-image.jpg
            return subFolder + "/" + dateFolder + "/" + fileName;

        } catch (IOException e) {
            throw new RuntimeException("Could not store file. Error: " + e.getMessage());
        }
    }
}
