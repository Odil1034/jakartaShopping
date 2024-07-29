package uz.pdp.maven.jakartashoppingproject.entity.customer;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
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
public class Customer extends BaseEntity {

    @Column (name = "order_status")
    private String orderStatus;

    @Column (name = "payment_type")
    private String paymentType;

    @OneToOne (mappedBy = "id")
    private Address addressId;

    @OneToOne (mappedBy = "id")
    private User userId;

    @Builder(builderMethodName = "childBuilder")
    public Customer(String Id, Boolean isActive, LocalDateTime createdAt, LocalDateTime updatedAt, String orderStatus, String paymentType, Address addressId, User userId) {
        super(Id, isActive, createdAt, updatedAt);
        this.orderStatus = orderStatus;
        this.paymentType = paymentType;
        this.addressId = addressId;
        this.userId = userId;
    }
}
