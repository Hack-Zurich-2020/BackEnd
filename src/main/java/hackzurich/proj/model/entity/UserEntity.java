package hackzurich.proj.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
@AllArgsConstructor
@Data
public class UserEntity {
    @Id
    private String id;

    private String healthParams;
    private int balance;
}
