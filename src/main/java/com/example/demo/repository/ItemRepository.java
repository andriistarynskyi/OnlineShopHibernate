package com.example.demo.repository;

import com.example.demo.entity.Item;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class ItemRepository implements IItemRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(Item item) {
        if (item.getId() == 0) {
            em.persist(item);
        } else {
            em.merge(item);
        }
    }

    @Override
    public Item findById(int id) {
        return em.find(Item.class, id);
    }

    @Override
    public boolean update(Item itemToUpdate) {
        if (itemToUpdate != null) {
            return true;
        }
        return false;
    }
}