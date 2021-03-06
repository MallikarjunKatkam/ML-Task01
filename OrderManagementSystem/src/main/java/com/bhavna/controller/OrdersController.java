package com.bhavna.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bhavna.model.Orders;
import com.bhavna.service.OrderServiceI;
@RestController
@RequestMapping("/orders")
public class OrdersController {

	@Autowired
	OrderServiceI serv;
	
	@GetMapping("/getOrders")
	public List<Orders> getAllOrders(){
		return serv.geAllOrders();
	}
	
	@PostMapping("/addOrder")
	public String addOrder(@RequestBody Orders order) {
		 serv.addOrder(order);
		return "Your Order was Added Successfully";
	}
	
	
	@GetMapping("/getOrder/{id}")
	public Optional<Orders> getOrderById(@PathVariable("id") Integer id) {
		return serv.getOrderById(id);
	}
	
	@DeleteMapping("/deleteOrder/{id}")
	public String deleteOrderById(@PathVariable("id") Integer id) {
		serv.deleteOrder(id);
		return "Your Order was Deleted Successfully";
	}
	
	@PutMapping("/updateOrder/{order_id}")
	public Orders updateByCategory(@PathVariable("order_id") Integer order_id,@RequestBody Orders order) {
		return	serv.updateOrder(order_id, order);

	}
	
	@PatchMapping("/patchOrder/{id}")
	public Orders patchOrder(@PathVariable("id") Integer id, @RequestParam(name = "item", required=false) Integer item_id,  @RequestParam(name = "quantity", required=false) Integer quantity) {
		return serv.patchOrder(id, item_id, quantity);
	}
}