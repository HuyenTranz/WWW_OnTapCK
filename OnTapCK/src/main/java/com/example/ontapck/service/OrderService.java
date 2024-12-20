package com.example.ontapck.service;

import com.example.ontapck.entity.Orders;
import org.springframework.data.domain.Page;

import java.util.List;

public interface OrderService {
    public List<Orders> getAllOrders();

    Page<Orders> getAllOrderPagination(int page, int size);

    public List<Orders> search(String value);

    public Orders findByID(int id);

    public boolean addOrder(Orders order);

    public boolean updateOrder(Orders order);

    public boolean deleteOrder(int id);
}
