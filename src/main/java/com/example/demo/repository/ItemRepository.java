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
        em.persist(item);
    }
}
