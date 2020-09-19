package hackzurich.proj.model.entity;

import hackzurich.proj.model.dto.NutritionFact;
import lombok.Getter;

import javax.persistence.*;
import java.util.Map;

@Entity
@Getter
@Table(name = "foods")
public class FoodEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String categoryIds;
    private String nutritionFacts;

    private int amount;
    private int price;

    @ManyToOne
    @JoinColumn(name = "id", insertable = false, updatable = false)
    private RestaurantEntity restaurantEntity;



}
