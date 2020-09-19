package hackzurich.proj.model.dto;

public enum  ApproximateAmount {
    NONE(0),
    LOW(1),
    MEDIUM(2),
    HIGH(3),
    VERY_HIGH(4);

    ApproximateAmount (int id){
        this.id = id;
    }

    private int id;
}
