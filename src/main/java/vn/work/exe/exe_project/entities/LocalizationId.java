package vn.work.exe.exe_project.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocalizationId implements Serializable {
    private String stringKey;
    private String languageCode;
}
