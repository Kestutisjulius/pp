package model;

import lombok.*;

import javax.persistence.*;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "Product")
@Data @ToString
@AllArgsConstructor
@NoArgsConstructor


public class Product extends Goods{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double price;
    private Integer quantity;
    private Integer discount;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "supplier_id", nullable = false)
    private Supplier supplier;




    @Override
    protected double getDiscount(double discount) {
        return this.discount;
    }
}
