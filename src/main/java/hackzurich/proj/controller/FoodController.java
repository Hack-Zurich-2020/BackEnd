package hackzurich.proj.controller;

import hackzurich.proj.model.dto.request.FoodInquiryRequest;
import hackzurich.proj.model.dto.request.FoodOrderRequest;
import hackzurich.proj.model.dto.response.FoodInquiryResponse;
import hackzurich.proj.model.dto.response.FoodOrderResponse;
import hackzurich.proj.service.FoodService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.*;

@RestController
@PropertySource("classpath:application.properties")
@AllArgsConstructor
@Slf4j
@CrossOrigin
public class FoodController {
    private FoodService foodService;

    @PostMapping("/food/inquire")
    public FoodInquiryResponse foodInquiry(@RequestBody FoodInquiryRequest request){
        log.info("Food Inquiry");
        return foodService.foodInquiry(request);
    }

    @PostMapping("/food/order")
    public FoodOrderResponse foodOrder(@RequestBody FoodOrderRequest request){
        return foodService.foodOrder(request);
    }

    @GetMapping("/food/finalize")
    public void finalizeOrder(@RequestParam(name = "orderId") String orderId){
        foodService.finalizeOrder(orderId);
    }
}
