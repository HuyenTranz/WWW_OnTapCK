package com.example.ontapck.controller;

import com.example.ontapck.entity.Orders;
import com.example.ontapck.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model) {
        List<Orders> orders = orderService.getAllOrders();
        model.addAttribute("orders", orders);
        return "home";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search(Model model, @RequestParam String keyword) {
        List<Orders> orders = orderService.search(keyword);
        model.addAttribute("orders", orders);
        model.addAttribute("keyword", keyword);
        return "home";
    }

    @RequestMapping(value = "/addOrder", method = RequestMethod.GET)
    public String showFormAdd(Model model) {
        Orders order = new Orders();
        model.addAttribute("order", order);
        return "addOrder";
    }

    @RequestMapping(value = "/addNewOrder", method = RequestMethod.GET)
    public String addOrder(Orders order) {
        orderService.addOrder(order);
        return "redirect:/";
    }


    @RequestMapping(value = "/details/{id}", method = RequestMethod.GET)
    public String showFormDetail(Model model , @PathVariable("id") int id) {
        Orders order = orderService.findByID(id);
        model.addAttribute("order", order);
        double total = order.getPrice() * order.getQuantity();
        model.addAttribute("total", total);
        return "details";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteOrder(Model model, @PathVariable("id") int id) {
        orderService.deleteOrder(id);
        return "redirect:/";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editOrder(@ModelAttribute Orders order, Model model) {
        orderService.updateOrder(order);
        return "redirect:/";
    }

    @RequestMapping(value = "/homePage", method = RequestMethod.GET)
    public String homePage(Model model,
                           @RequestParam(defaultValue = "0") int page,
                           @RequestParam(defaultValue = "10") int size) {
        Page<Orders> orderPage = orderService.getAllOrderPagination(page, size);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPage", orderPage.getTotalPages());
        model.addAttribute("orderList", orderPage.getContent());
        return "homePage";
    }
}
