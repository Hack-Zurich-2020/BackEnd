package hackzurich.proj.service;

import hackzurich.proj.model.dto.ApproximateAmount;
import hackzurich.proj.model.dto.response.WasteStatisticsResponse;
import hackzurich.proj.model.entity.OrderEntity;
import hackzurich.proj.model.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.hibernate.engine.internal.Collections;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class OrderService {
    private OrderRepository orderRepository;

    public WasteStatisticsResponse fetchWasteStatistics() {
        Map<Integer, Double> wasteMap = new HashMap<>();
        Map<Integer, Double> wasteCost = new HashMap<>();
        Iterable<OrderEntity> orders = orderRepository.findAll();
        orders.forEach(orderEntity -> {
            Integer key = orderEntity.getWasteCause();
            wasteMap.put(key, wasteMap.getOrDefault(key, 0.0) + 1);
            wasteCost.put(key, wasteCost.getOrDefault(key, 0.0) + orderEntity.getPrice() *
                    orderEntity.getWasteAmount() / ApproximateAmount.values().length);
        });
        long ordersSize = orders.spliterator().getExactSizeIfKnown();
        wasteMap.forEach((k, v) -> wasteMap.put(k, 100 * v / ordersSize));
        return new WasteStatisticsResponse(wasteMap, wasteCost);
    }
}
