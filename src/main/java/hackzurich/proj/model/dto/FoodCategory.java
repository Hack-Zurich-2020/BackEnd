package hackzurich.proj.model.dto;

public enum  FoodCategory {
    LACTOSE_FREE (1),
    GLUTEN_FREE (2),
    VEGETARIAN (3),
    VEGAN (4);

    FoodCategory (int id){
        this.id = id;
    }
    private int id;
}
