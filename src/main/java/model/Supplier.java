package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Supplier {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "supplier_id")
    private Long id;

    @Enumerated(EnumType.ORDINAL)
    private SupplierName name;

    @OneToMany
    @JoinColumn(name = "products_id", nullable = false)
    private Set<Product> products;
}
