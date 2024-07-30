package uz.pdp.maven.jakartashoppingproject.entity.customer;

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
public class Customer extends BaseEntity {

    @Column(name = "order_status")
    private String orderStatus;

    @Column(name = "payment_type")
    private String paymentType;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Address address;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private User user;

    @Builder(builderMethodName = "childBuilder")
    public Customer(String Id, Boolean isActive, LocalDateTime createdAt, LocalDateTime updatedAt, String orderStatus, String paymentType, Address address, User user) {
        super(Id, isActive, createdAt, updatedAt);
        this.orderStatus = orderStatus;
        this.paymentType = paymentType;
        this.address = address;
        this.user = user;
    }
}
