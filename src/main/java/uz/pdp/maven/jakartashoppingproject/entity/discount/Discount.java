package uz.pdp.maven.jakartashoppingproject.entity.discount;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import uz.pdp.maven.jakartashoppingproject.entity.BaseEntity;
import uz.pdp.maven.jakartashoppingproject.entity.product.Product;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Discount extends BaseEntity {

    private Double discountPercentage;

    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime startDate;

    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime endDate;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Product product;


    @Builder(builderMethodName = "childBuilder")
    public Discount(String Id, Boolean isActive, LocalDateTime createdAt, LocalDateTime updatedAt, Double discountPercentage, LocalDateTime startDate, LocalDateTime endDate, Product product) {
        super(Id, isActive, createdAt, updatedAt);
        this.discountPercentage = discountPercentage;
        this.startDate = startDate;
        this.endDate = endDate;
        this.product = product;
    }
}
