package vn.work.exe.exe_project.services;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    String saveFile(MultipartFile file, String subFolder);
}