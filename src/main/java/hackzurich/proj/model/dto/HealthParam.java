package hackzurich.proj.model.dto;

public enum HealthParam {
    BLOOD_PRESSURE(0),
    DIABETES(1),
    BMI(2),
    AGE(3),
    LACTOSE_ALLERGY(4),
    HIGH_LDL(5);

    HealthParam(int id) {
        this.id = id;
    }

    private int id;
}
