package hackzurich.proj.model.entity;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Map;

@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    private String id;

    private String healthParams;
}
