package com.axsos.orders.services;

import com.axsos.orders.repos.OrderRepo;

public class OrderService {

	private final OrderRepo orderRepo;

	public OrderService(OrderRepo orderRepo) {
		this.orderRepo=orderRepo;
		// TODO Auto-generated constructor stub
	}

}
