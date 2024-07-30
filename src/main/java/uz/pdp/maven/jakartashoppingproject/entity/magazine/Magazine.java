package uz.pdp.maven.jakartashoppingproject.entity.magazine;

import jakarta.persistence.*;
import lombok.*;
import uz.pdp.maven.jakartashoppingproject.entity.BaseEntity;
import uz.pdp.maven.jakartashoppingproject.entity.address.Address;
import uz.pdp.maven.jakartashoppingproject.entity.user.User;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Magazine extends BaseEntity {

    @Column(nullable = false)
    private String name;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private User userId;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Address addressId;


    @Builder(builderMethodName = "childBuilder")

    public Magazine(String Id, Boolean isActive, LocalDateTime createdAt, LocalDateTime updatedAt, String name, String description, User userId, Address addressId) {
        super(Id, isActive, createdAt, updatedAt);
        this.name = name;
        this.description = description;
        this.userId = userId;
        this.addressId = addressId;
    }
}
