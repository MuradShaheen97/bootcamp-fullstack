package com.axsos.examapp.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axsos.examapp.models.Item;
import com.axsos.examapp.models.User;

/*
 * إذا غيّرت Item إلى Game:
 * غيّر اسم الملف إلى GameRepository
 * و CrudRepository<Item, Long> إلى CrudRepository<Game, Long>
 */
@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {

    List<Item> findAll();

    List<Item> findByOwner(User owner);
}
