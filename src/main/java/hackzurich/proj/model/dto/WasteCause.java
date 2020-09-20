package hackzurich.proj.model.dto;

public enum WasteCause {
    BAD_FOOD(0),
    COLD_FOOD(1),
    TOO_RELISH(2),
    LARGE_AMOUNT(3);

    WasteCause(int id) {
        this.id = id;
    }

    private int id;
}
