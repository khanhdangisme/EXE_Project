package vn.work.exe.exe_project.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Value("${file.resource-path}")
    private String resourcePath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Ánh xạ mọi yêu cầu bắt đầu bằng /uploads/ vào folder thực tế trên máy
        registry.addResourceHandler("/uploads/**")
                .addResourceLocations(resourcePath);
    }
}