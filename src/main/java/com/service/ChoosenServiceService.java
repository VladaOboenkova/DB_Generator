package com.service;

import com.entity.AddService;
import com.entity.ChoosenService;
import com.entity.Order;
import com.entity.TourAddService;
import com.repository.TourAddServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.repository.ChoosenServiceRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChoosenServiceService {

    @Autowired
    private final ChoosenServiceRepository choosenServiceRepository;

    @Autowired
    private final TourAddServiceService tourAddServiceService;

    @Autowired
    private final OrderService orderService;

    public ChoosenServiceService (ChoosenServiceRepository choosenServiceRepository,
                                  TourAddServiceService tourAddServiceService,
                                  OrderService orderService) {
        this.choosenServiceRepository = choosenServiceRepository;
        this.tourAddServiceService = tourAddServiceService;
        this.orderService = orderService;
    }

    public int count() {
        return (int) choosenServiceRepository.count();
    }

    public void createChoosenService(ChoosenService choosenService) {
        choosenServiceRepository.save(choosenService);
    }

    public ChoosenService findById(Long id) {
        return choosenServiceRepository.findById(id).orElse(null);
    }

    public List<ChoosenService> findAll() {
        return choosenServiceRepository.findAll();
    }

    public ChoosenService findExistingCS(Order id_order, AddService id_add_service){
        return choosenServiceRepository.findExistingCS(id_order, id_add_service);
    }

    public List<ChoosenService> allChoosenService(Order order){
        return choosenServiceRepository.allChoosenServices(order);
    }

    public List<Order> availableForChoosenService(){
        List<Order> allOrders = orderService.findAll();
        List<Order> availableOrders = new ArrayList<>();
        for (Order o : allOrders){
            List<ChoosenService> choosenServicesForOrder = allChoosenService(o);
            List<AddService> availableAddService = tourAddServiceService
                    .findAddServiceForTour(o.getId_tour());
            if (choosenServicesForOrder.size() < availableAddService.size()){
                availableOrders.add(o);
            }
        }
        return availableOrders;
    }
}
