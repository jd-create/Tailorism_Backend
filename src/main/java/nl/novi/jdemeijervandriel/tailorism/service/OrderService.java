package nl.novi.jdemeijervandriel.tailorism.service;

import nl.novi.jdemeijervandriel.tailorism.domain.Order;
import nl.novi.jdemeijervandriel.tailorism.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public List<Order> getAllOrders(){
        List<Order> orders = orderRepository.findAll();
        return orders;
    }
/*
    public long saveOrder (LaborRequest laborRequest){
        Order order = new OrderBuilder(laborRequest).buildOrder();
        Labor labor = new OrderBuilder (laborRequest)
                .buildLabor();

        Order savedOrder = OrderRepository.save(order);
        order.setsetTimeOfOrder(timeOfOrder);
        labor.setCusetStartTime(startTime);
        product.setDescription(description);
        product.set

        return customerRepository.save(customer).getId();
    }

 */
}
