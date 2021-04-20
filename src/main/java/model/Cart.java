package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "CART")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Cart {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private Long cartId;

    @OneToMany
    @JoinColumn (name = "id")
    private Set<Product> products;

   //@ManyToOne
   //@JoinColumn (name = "user_id")
   //private User user;
}
