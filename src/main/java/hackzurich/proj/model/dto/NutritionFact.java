package hackzurich.proj.model.dto;

public enum NutritionFact {
    FAT(0),
    GLUCOSE(1),
    CALORIE(2),
    LDL(3),
    FIBRE(4),
    WATER(5);

    NutritionFact(int id) {
        this.id = id;
    }

    private int id;
}
