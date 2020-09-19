package hackzurich.proj.model.dto;

public enum RestaurantCategory {
    TAKEOUT_ONLY (0),
    HAS_DELIVERY (1),
    ASIAN (2),
    KEBAB (3),
    FAST_FOOD (4),
    VEGAN (5),
    HALAL (6),
    KOSHER (7);

    RestaurantCategory (int id){
        this.id = id;
    }

    private int id;
}
