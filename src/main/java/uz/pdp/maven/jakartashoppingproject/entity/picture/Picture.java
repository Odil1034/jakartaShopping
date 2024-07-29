package uz.pdp.maven.jakartashoppingproject.entity.picture;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Min;
import lombok.*;
import uz.pdp.maven.jakartashoppingproject.entity.BaseEntity;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Picture extends BaseEntity {

    @Column(name = "generated_name", nullable = false)
    private String generatedName;

    @Column(name = "original_name", nullable = false)
    private String originalName;

    private String extension;

    private String mimeType;
    @Min(0L)
    private Double size;

    @Builder(builderMethodName = "childBuilder")
    public Picture(String Id, Boolean isActive, LocalDateTime createdAt, LocalDateTime updatedAt, String generatedName, String originalName, String extension, String mimeType, Double size) {
        super(Id, isActive, createdAt, updatedAt);
        this.generatedName = generatedName;
        this.originalName = originalName;
        this.extension = extension;
        this.mimeType = mimeType;
        this.size = size;
    }
}
