package com.axsos.examapp.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.axsos.examapp.models.Item;
import com.axsos.examapp.models.User;
import com.axsos.examapp.repositories.ItemRepository;

/*
 * احفظ هذه الفكرة:
 * Controller لا يتعامل مباشرة مع Repository.
 * Controller -> Service -> Repository -> Database
 */
@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    // READ ALL
    public List<Item> allItems() {
        return itemRepository.findAll();
    }

    // READ USER ITEMS
    public List<Item> itemsByOwner(User owner) {
        return itemRepository.findByOwner(owner);
    }

    // CREATE + UPDATE
    public Item saveItem(Item item) {
        return itemRepository.save(item);
    }

    // READ ONE
    public Item findItem(Long id) {
        return itemRepository.findById(id).orElse(null);
    }

    // DELETE
    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }
}
