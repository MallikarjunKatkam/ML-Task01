package com.bhavna.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhavna.exceptions.MyException;
import com.bhavna.model.Category;
import com.bhavna.model.Orders;
import com.bhavna.repository.OrdersRepo;
import com.bhavna.repository.ProductsRepo;

@Service
public class OrderServiceImpl implements OrderServiceI {
	@Autowired
	OrdersRepo ordersRepo;

	@Autowired
	ProductsRepo productsRepo;

	Category category = new Category();

	public List<Orders> geAllOrders() {
		return ordersRepo.findAll();
	}

	public String addOrder(Orders order) {
		Integer price = productsRepo.getById(order.getProduct().getProductId()).getPrice();
			if ((order.getQuantity() <= 0)) {
				throw new MyException();
			} else {
				order.setPrice(order.getQuantity() * price);
				ordersRepo.save(order);
				return "added successfully";
			}
	}

	public Optional<Orders> getOrderById(Integer id) {
		return ordersRepo.findById(id);
	}

	public void deleteOrder(Integer id) {
		if (ordersRepo.existsById(id)) {
			ordersRepo.deleteById(id);
		} else {
			throw new NoSuchElementException();
		}
	}

	public Orders updateOrder(Integer order_id, Orders orders) {
		if (ordersRepo.existsById(order_id)) {
			Integer price = productsRepo.getById(orders.getProduct().getProductId()).getPrice();
			if ((orders.getQuantity() <= 0)) {
				throw new MyException();
			} else {
				orders.setPrice(orders.getQuantity() * price);
				return ordersRepo.save(orders);
			}

		} else {
			throw new NoSuchElementException();
		}
	}

	public Orders patchOrder(Integer id, Integer item_id, Integer quantity) {
		Orders order = ordersRepo.findById(id).get();
		if (quantity != null)
			order.setQuantity(quantity);
		if (item_id != null)
			order.setProduct(productsRepo.findById(item_id).get());
		Integer price = productsRepo.getById(order.getProduct().getProductId()).getPrice();
		order.setPrice(order.getQuantity() * price);
		System.out.println(order);
		return ordersRepo.save(order);
	}

}
