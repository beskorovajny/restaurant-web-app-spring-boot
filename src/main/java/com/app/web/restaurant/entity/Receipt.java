package com.app.web.restaurant.entity;

import com.app.web.restaurant.entity.enums.Status;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Objects;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
@Entity
public class Receipt {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDateTime dateCreated;
    private Double totalPrice;
    @ManyToOne
    private Contacts contacts;
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private User customer;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Transient
    private Map<Dish, Integer> dishes;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Receipt receipt = (Receipt) o;
        return id != null && Objects.equals(id, receipt.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
