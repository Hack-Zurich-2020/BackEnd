package hackzurich.proj.model.entity;

import hackzurich.proj.model.dto.NutritionFact;
import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.util.Map;

@Entity
@Table(name = "foods")
@Data
public class FoodEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String categoryIds;
    private String nutritionFacts;
    private String ingredients;

    private int amount;
    private int price;
    private int type;
    private double score;
    private int ordersCount;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", referencedColumnName = "id", insertable = false, updatable = false)
    private RestaurantEntity restaurantEntity;



}
