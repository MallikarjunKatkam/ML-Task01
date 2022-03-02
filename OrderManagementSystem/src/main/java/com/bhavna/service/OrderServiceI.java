package com.bhavna.service;

import java.util.List;
import java.util.Optional;

import com.bhavna.model.Orders;

public interface OrderServiceI {

	List<Orders> geAllOrders();

	String addOrder(Orders order);

	Optional<Orders> getOrderById(Integer id);

	void deleteOrder(Integer id);

	Orders updateOrder(Integer order_id, Orders order);

	Orders patchOrder(Integer id, Integer item_id, Integer quantity);
}
