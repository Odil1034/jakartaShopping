package uz.pdp.maven.jakartashoppingproject.entity.user;

import jakarta.persistence.*;
import lombok.*;
import uz.pdp.maven.jakartashoppingproject.entity.BaseEntity;
import uz.pdp.maven.jakartashoppingproject.entity.address.Address;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User extends BaseEntity {

    @Column (unique = true, nullable = false)
    private String username;

    @Column (nullable = false)
    private String password;

    @Column (nullable = false)
    private UserRole role;

    @Column (nullable = false)
    private String email;

    @Column (nullable = false)
    private String fullName;

    @Enumerated(EnumType.STRING)
    private UserStatus status;

    @OneToOne
    private Address addressId;

    public enum UserRole {
        ADMIN,
        USER,
        SELLER
    }

    public enum UserStatus {
        BLOCKED,
        IN_ACTIVE,
        ACTIVE
    }

    @Builder(builderMethodName = "childBuilder")
    public User(String Id, Boolean isActive, LocalDateTime createdAt, LocalDateTime updatedAt, String username, String password, UserRole role, String email, String fullName, UserStatus status, Address addressId) {
        super(Id, isActive, createdAt, updatedAt);
        this.username = username;
        this.password = password;
        this.role = role;
        this.email = email;
        this.fullName = fullName;
        this.status = status;
        this.addressId = addressId;
    }
}
