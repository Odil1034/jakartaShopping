package uz.pdp.maven.jakartashoppingproject.entity.order;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import uz.pdp.maven.jakartashoppingproject.entity.BaseEntity;
import uz.pdp.maven.jakartashoppingproject.entity.address.Address;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Order extends BaseEntity {

    @JoinColumn(name = "delivery_address", nullable = false)
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Address deliveryAddress;

    @CreationTimestamp
    private LocalDateTime deliveryDate;

    @Column(name = "is_paid", columnDefinition = "boolean default false")
    private Boolean isPaid;

    @Column(name = "is_delivered", columnDefinition = "boolean default false")
    private Boolean isDelivered;

    @Column(nullable = false)
    private Integer quantity;

    @Builder(builderMethodName = "childBuilder")
    public Order(String Id, Boolean isActive, LocalDateTime createdAt, LocalDateTime updatedAt, Address deliveryAddress, LocalDateTime deliveryDate, Boolean isPaid, Boolean isDelivered, Integer quantity) {
        super(Id, isActive, createdAt, updatedAt);
        this.deliveryAddress = deliveryAddress;
        this.deliveryDate = deliveryDate;
        this.isPaid = isPaid;
        this.isDelivered = isDelivered;
        this.quantity = quantity;
    }
}
