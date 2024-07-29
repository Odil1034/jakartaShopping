package uz.pdp.maven.jakartashoppingproject.entity.orderItem;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.*;
import uz.pdp.maven.jakartashoppingproject.entity.BaseEntity;
import uz.pdp.maven.jakartashoppingproject.entity.order.Order;
import uz.pdp.maven.jakartashoppingproject.entity.product.Product;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem extends BaseEntity {

    @OneToOne (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Column (name = "product_id", nullable = false)
    private Product productId;

    @ManyToOne (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Column (name = "orders_id", nullable = false)
    private Order ordersId;

    @Positive
    private Integer quantity;

    @Column (nullable = false)
    private Double price;

    @Builder (builderMethodName = "childBuilder")
    public OrderItem(String Id, Boolean isActive, LocalDateTime createdAt, LocalDateTime updatedAt, Product productId, Order ordersId) {
        super(Id, isActive, createdAt, updatedAt);
        this.productId = productId;
        this.ordersId = ordersId;
    }
}
