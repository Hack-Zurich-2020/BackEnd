package hackzurich.proj.model.dto;

public enum NutritionFact {
    FAT(0),
    SUGAR(1),
    CALORIE(2),
    HDL(3),
    LDL(4),
    FIBRE(5),
    WATER(6),
    SALT(7),
    PRESERVATIVES(8);

    NutritionFact(int id) {
        this.id = id;
    }

    private int id;
}
