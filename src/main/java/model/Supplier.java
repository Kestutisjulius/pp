package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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

    //@Enumerated(EnumType.ORDINAL)
    private String name;

    @OneToMany(mappedBy = "id")
    private Set<Product> products;
}
