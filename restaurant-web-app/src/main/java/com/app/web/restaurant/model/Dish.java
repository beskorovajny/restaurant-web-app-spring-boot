package com.app.web.restaurant.model;

import com.app.web.restaurant.model.enums.Category;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    private Double price;
    private Double totalPrice;
    private Integer weight;
    private Integer cooking;
    private LocalDateTime dateCreated;
    @Enumerated(EnumType.STRING)
    private Category category;
    @ManyToMany(mappedBy = "orderedDishes")
    @ToString.Exclude
    private Set<Receipt> receipt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Dish dish = (Dish) o;
        return id != null && Objects.equals(id, dish.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
