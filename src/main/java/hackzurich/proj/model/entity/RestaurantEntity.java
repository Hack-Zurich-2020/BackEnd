package hackzurich.proj.model.entity;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "restaurants")
@Getter
public class RestaurantEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String categoryIds;

    @OneToMany(targetEntity = FoodEntity.class, mappedBy = "restaurantEntity", fetch = FetchType.LAZY)
    private List<FoodEntity> foodEntities;

    private String name;
    private double longitude;
    private double latitude;
}
