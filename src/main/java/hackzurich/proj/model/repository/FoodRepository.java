package hackzurich.proj.model.repository;

import hackzurich.proj.model.entity.FoodEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodRepository extends CrudRepository<FoodEntity, Long> {
    public List<FoodEntity> findAllByCategoryIdsContains(String categoryIds);
}
