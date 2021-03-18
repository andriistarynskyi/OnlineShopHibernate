package com.example.demo.repository;

import com.example.demo.entity.Item;

public interface IItemRepository {
    void save(Item item);

    boolean update(Item itemToUpdate);
}
