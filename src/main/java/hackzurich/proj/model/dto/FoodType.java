package hackzurich.proj.model.dto;

public enum FoodType {
    MAIN_COURSE(0),

    DESSERT(1),

    STARTER(2);

    FoodType(int id) {
        this.id = id;
    }

    private int id;

}
