package hackzurich.proj.model.repository;

import hackzurich.proj.model.entity.OrderEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<OrderEntity, String> {
}
