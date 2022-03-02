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
	OrdersRepo repo;

	@Autowired
	ProductsRepo itemRepo;

	Category category = new Category();

	public List<Orders> geAllOrders() {
		return repo.findAll();
	}

	public String addOrder(Orders order) {
		Integer price = itemRepo.getById(order.getProduct().getProductId()).getPrice();
//		if(itemRepo.existsById(order.getOrderId())) {
//			throw new NoSuchElementException();
//		}
//		else {			
			if ((order.getQuantity() <= 0)) {
				throw new MyException();
			} else {
				order.setPrice(order.getQuantity() * price);
				repo.save(order);
				return "added successfully";
			}
//		}
	}

	public Optional<Orders> getOrderById(Integer id) {
//		return repo.findById(id).get();
		return repo.findById(id);
	}

	public void deleteOrder(Integer id) {
		if (repo.existsById(id)) {
			repo.deleteById(id);
		} else {
			throw new NoSuchElementException();
		}
	}

	public Orders updateOrder(Integer order_id, Orders orders) {
		if (repo.existsById(order_id)) {
			Integer price = itemRepo.getById(orders.getProduct().getProductId()).getPrice();
			if ((orders.getQuantity() <= 0)) {
				throw new MyException();
			} else {
				orders.setPrice(orders.getQuantity() * price);
				return repo.save(orders);
			}

		} else {
			throw new NoSuchElementException();
		}
	}

	public Orders patchOrder(Integer id, Integer item_id, Integer quantity) {
		Orders order = repo.findById(id).get();
		if (quantity != null)
			order.setQuantity(quantity);
		if (item_id != null)
			order.setProduct(itemRepo.findById(item_id).get());
		Integer price = itemRepo.getById(order.getProduct().getProductId()).getPrice();
		order.setPrice(order.getQuantity() * price);
		System.out.println(order);
		return repo.save(order);
	}

}
