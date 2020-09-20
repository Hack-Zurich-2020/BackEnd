package hackzurich.proj.controller;

import hackzurich.proj.model.dto.response.WasteStatisticsResponse;
import hackzurich.proj.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class OrderController {
    private OrderService orderService;

    @GetMapping("/order/waste_percentage")
    public WasteStatisticsResponse getWastePercentage() {
        return orderService.fetchWasteStatistics();
    }
}
