package com.example.ontapck.impl;

import com.example.ontapck.dao.OrderDao;
import com.example.ontapck.entity.Orders;
import com.example.ontapck.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;

    @Override
    public List<Orders> getAllOrders() {
        return orderDao.findAll();
    }

    @Override
    public Page<Orders> getAllOrderPagination(int page, int size) {
        return orderDao.findAll(PageRequest.of(page, size));
    }

    @Override
    public List<Orders> search(String value) {
        return orderDao.search(value);
    }

    @Override
    public Orders findByID(int id) {
        return orderDao.findByID(id);
    }

    @Override
    public boolean addOrder(Orders order) {
        try {
            orderDao.save(order);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateOrder(Orders order) {
        Orders order1 = orderDao.findByID(order.getID());
        if (order1 == null) {
            return false;
        }
        order1.setID(order.getID());
        order1.setProID(order.getProID());
        order1.setProName(order.getProName());
        order1.setQuantity(order.getQuantity());
        order1.setPrice(order.getPrice());
        try {
            orderDao.save(order1);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteOrder(int id) {
        try {
            orderDao.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
