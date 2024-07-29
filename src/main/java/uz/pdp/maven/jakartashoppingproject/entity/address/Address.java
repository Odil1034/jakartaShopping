package uz.pdp.maven.jakartashoppingproject.entity.address;

import jakarta.persistence.Entity;
import lombok.*;
import uz.pdp.maven.jakartashoppingproject.entity.BaseEntity;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Address extends BaseEntity {

    private String city;
    private String district;
    private String houseNumber;
    private String street;

    @Builder(builderMethodName = "childBuilder")
    public Address(String Id, Boolean isActive, LocalDateTime createdAt, LocalDateTime updatedAt, String city, String district, String houseNumber, String street) {
        super(Id, isActive, createdAt, updatedAt);
        this.city = city;
        this.district = district;
        this.houseNumber = houseNumber;
        this.street = street;
    }
}
