package hackzurich.proj.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@RequiredArgsConstructor
@NoArgsConstructor
@Data
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NonNull
    private String userName;

    @NonNull
    private String healthParams;
    @NonNull
    private int balance;

    @OneToMany(targetEntity = OrderEntity.class, mappedBy = "userEntity", fetch = FetchType.LAZY)
    private List<OrderEntity> orderEntities;
}
