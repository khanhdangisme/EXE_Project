package vn.work.exe.exe_project.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Localization")
@IdClass(LocalizationId.class)
public class Localization {
    @Id
    @Column(name = "StringKey", length = 100)
    private String stringKey;

    @Id
    @Column(name = "LanguageCode", length = 10)
    private String languageCode;

    @Column(name = "TranslatedText", columnDefinition = "nvarchar(250)")
    private String translatedText;
}
