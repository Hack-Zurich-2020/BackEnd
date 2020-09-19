package hackzurich.proj.model.entity;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
@Getter
public class UserEntity {
    @Id
    private String id;

    private String healthParams;
    private int balance;
}
