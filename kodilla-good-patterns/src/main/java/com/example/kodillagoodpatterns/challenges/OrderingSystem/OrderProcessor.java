package com.example.kodillagoodpatterns.challenges.OrderingSystem;
import com.example.kodillagoodpatterns.challenges.*;

public class OrderProcessor {
    private InformationService informationService;
    private OrderingService orderingService;
    private OrdersRepository ordersRepository;

    public OrderProcessor(final InformationService informationService,
                          final OrderingService orderingService,
                          final OrdersRepository ordersRepository
    ) {
        this.informationService = informationService;
        this.orderingService = orderingService;
        this.ordersRepository = ordersRepository;
    }

    public OrderDto process(final Order order) {
        boolean isOrdered = orderingService.order(order.getUser(), order.getDateOfOrder());

        if (isOrdered) {
            informationService.inform(order.getUser());
            ordersRepository.createOrder(order.getUser(), order.getDateOfOrder());
            return new OrderDto(order.getUser(),true);
        }
        else {
            return new OrderDto(order.getUser(), false);
        }
    }
}