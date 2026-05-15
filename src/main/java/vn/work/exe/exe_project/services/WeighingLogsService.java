package vn.work.exe.exe_project.services;

public interface WeighingLogsService{
    void saveLog(String productId, String scaleId, Double weight, String imagePath);
}
