package com.campustrace.service;

import com.campustrace.model.*;
import com.campustrace.repository.ItemRepository;
import java.time.LocalDate;
import java.util.*;

public class ItemService {
    private final ItemRepository repository;

    public ItemService(ItemRepository repository) {
        this.repository = repository;
    }

    public Item addItem(ItemType type, String name, String category,
                        String location, String description) {
        int id = nextId();
        Item item = new Item(id, type, name, category, location,
                LocalDate.now().toString(), description, ItemStatus.ACTIVE);
        repository.save(item);
        return item;
    }

    public List<Item> getAllItems() {
        return repository.findAll();
    }

    public List<Item> searchItems(String keyword) {
        List<Item> results = new ArrayList<>();
        String query = keyword.toLowerCase();
        for (Item item : repository.findAll()) {
            if (item.getName().toLowerCase().contains(query)
                    || item.getCategory().toLowerCase().contains(query)
                    || item.getLocation().toLowerCase().contains(query)
                    || item.getDescription().toLowerCase().contains(query)
                    || item.getType().toString().toLowerCase().contains(query)) {
                results.add(item);
            }
        }
        return results;
    }

    public boolean isFoundItem(int id) {
        Item item = repository.findById(id);
        return item != null && item.getType() == ItemType.FOUND;
    }

    public boolean isActiveItem(int id) {
        Item item = repository.findById(id);
        return item != null && item.getStatus() == ItemStatus.ACTIVE;
    }

    public void markReturned(int id) {
        Item item = repository.findById(id);
        if (item == null) throw new IllegalArgumentException("Item not found.");
        item.setStatus(ItemStatus.RETURNED);
        repository.persist();
    }

    private int nextId() {
        int max = 0;
        for (Item item : repository.findAll()) {
            if (item.getItemId() > max) max = item.getItemId();
        }
        return max + 1;
    }
}
