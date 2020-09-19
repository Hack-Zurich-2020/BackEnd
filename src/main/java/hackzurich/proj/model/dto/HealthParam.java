package hackzurich.proj.model.dto;

public enum HealthParam {
    PREGNANT(0),
    BLOOD_PRESSURE(1),
    DIABETES(2),
    BMI(3),
    AGE(4),
    LACTOSE_ALLERGY(5),
    BEEF_ALLERGY(6),
    HIGH_LDL(7);

    HealthParam(int id) {
        this.id = id;
    }

    private int id;
}
