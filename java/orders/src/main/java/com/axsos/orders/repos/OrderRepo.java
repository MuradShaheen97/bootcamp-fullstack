package com.axsos.orders.repos;

import org.springframework.data.repository.CrudRepository;
import com.axsos.orders.models.Orders;

public interface OrderRepo extends CrudRepository<Orders, Long> {

}
