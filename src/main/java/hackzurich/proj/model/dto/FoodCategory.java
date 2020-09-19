package hackzurich.proj.model.dto;

public enum  FoodCategory {
    HALAL(0),
    LACTOSE_FREE (1),
    GLUTEN_FREE (2),
    VEGETARIAN (3),
    ASIAN (4),
    MEDITERRANEAN (5),
    VEGAN (8),
    DESSERT (9),
    SOUP (10),
    NON_BEEF (11);

    FoodCategory (int id){
        this.id = id;
    }
    private int id;
}
