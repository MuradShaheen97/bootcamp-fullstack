package com.axsos.CarFactory.repositres;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axsos.CarFactory.models.Cars;

@Repository
public interface CarRepo extends CrudRepository<Cars, Long> {

}
