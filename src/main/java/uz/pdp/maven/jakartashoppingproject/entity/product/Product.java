package uz.pdp.maven.jakartashoppingproject.entity.product;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.*;
import uz.pdp.maven.jakartashoppingproject.entity.BaseEntity;
import uz.pdp.maven.jakartashoppingproject.entity.magazine.Magazine;
import uz.pdp.maven.jakartashoppingproject.entity.picture.Picture;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Product extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String name;

    @Enumerated (EnumType.STRING)
    private Category category;

    private String description;

    @Column (nullable = false)

    @Min(value = 0, message = "price must be more than zero")
    private Double price;

    @Column(name = "stock_quantity", nullable = false)
    private Integer stockQuantity;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Magazine magazineId;

    @ManyToMany (mappedBy = "id", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Picture> pictureId;

    @Builder(builderMethodName = "childBuilder")
    public Product(String name, Category category, String description, Double price, Integer stockQuantity, Magazine magazineId, List<Picture> pictureId) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.magazineId = magazineId;
        this.pictureId = pictureId;
    }

    public enum Category {
        FRUITS,
        VEGETABLES,
        BOOK,
        MOUSES,
        COMPUTERS,
        KEYBOARDS,
        FOODS,
        AIRPODS,
        CLOTHES,
        SPORTS,
        OTHERS
    }
}
