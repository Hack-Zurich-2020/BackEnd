package hackzurich.proj.model.dto;

public enum  FoodCategory {
    HALAL(0),
    KOSHER (1),
    FAST_FOOD (2),
    ASIAN (3),
    KEBAB (4),
    MEDITERRANEAN (5),
    NON_ALCOHOL (6),
    VEGAN (7);

    FoodCategory (int id){
        this.id = id;
    }
    private int id;
}
