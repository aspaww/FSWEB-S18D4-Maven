package com.workintech.s18d1.dao;

import com.workintech.s18d1.entity.BreadType;
import com.workintech.s18d1.entity.Burger;
import com.workintech.s18d1.exceptions.BurgerException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class BurgerDaoImpl implements BurgerDao {

    private final EntityManager entityManager;

    public BurgerDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Burger save(Burger burger) {
        entityManager.persist(burger);
        return burger;
    }

    @Override
    public Burger findById(Long id) {
        Burger burger = entityManager.find(Burger.class, id);
        if (burger == null) {
            throw new BurgerException("Burger not found", HttpStatus.NOT_FOUND);
        }
        return burger;
    }

    @Override
    public List<Burger> findAll() {
        TypedQuery<Burger> query = entityManager.createQuery("SELECT b FROM Burger b", Burger.class);
        return query.getResultList();
    }

    @Override
    public List<Burger> findByPrice(double price) {
        TypedQuery<Burger> query = entityManager
                .createQuery("SELECT b FROM Burger b WHERE b.price >= :price", Burger.class);
        query.setParameter("price", price);
        return query.getResultList();
    }

    @Override
    public List<Burger> findByBreadType(BreadType breadType) {
        TypedQuery<Burger> query = entityManager
                .createQuery("SELECT b FROM Burger b WHERE b.breadType = :breadType", Burger.class);
        query.setParameter("breadType", breadType);
        return query.getResultList();
    }

    @Override
    public List<Burger> findByContent(String content) {
        TypedQuery<Burger> query = entityManager
                .createQuery("SELECT b FROM Burger b WHERE b.contents LIKE :content", Burger.class);
        query.setParameter("content", "%" + content + "%");
        return query.getResultList();
    }

    @Override
    public Burger update(Burger burger) {
        return entityManager.merge(burger);
    }

    @Override
    public Burger remove(Long id) {
        Burger toRemove = entityManager.find(Burger.class, id);
        if (toRemove != null) {
            entityManager.remove(toRemove);
        }
        return toRemove;
    }
}
