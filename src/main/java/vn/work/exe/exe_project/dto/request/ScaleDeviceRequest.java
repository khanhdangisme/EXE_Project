package vn.work.exe.exe_project.dto.request;

public record ScaleDeviceRequest(
        String scaleId,
        String deviceName,
        String location,
        Integer screenBrightness,
        Boolean voiceEnabled,
        Boolean status
) {}