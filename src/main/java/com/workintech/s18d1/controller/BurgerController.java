package com.workintech.s18d1.controller;

import com.workintech.s18d1.dao.BurgerDao;
import com.workintech.s18d1.entity.BreadType;        // ← Bu satır kesin olmalı
import com.workintech.s18d1.entity.Burger;
import com.workintech.s18d1.exceptions.BurgerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/burger")
public class BurgerController {

    private final BurgerDao burgerDao;

    @Autowired
    public BurgerController(BurgerDao burgerDao) {
        this.burgerDao = burgerDao;
    }

    @GetMapping("/{id}")
    public Burger getBurgerById(@PathVariable Long id) {
        Burger burger = burgerDao.findById(id);
        if (burger == null) {
            throw new BurgerException("Burger not found", HttpStatus.NOT_FOUND);
        }
        return burger;
    }

    @GetMapping
    public List<Burger> getAllBurgers() {
        return burgerDao.findAll();
    }

    @PostMapping
    public Burger createBurger(@RequestBody Burger burger) {
        return burgerDao.save(burger);
    }

    @PutMapping
    public Burger updateBurger(@RequestBody Burger burger) {
        Burger existing = burgerDao.findById(burger.getId());
        if (existing == null) {
            throw new BurgerException("Burger not found", HttpStatus.NOT_FOUND);
        }
        return burgerDao.update(burger);
    }

    @DeleteMapping("/{id}")
    public void deleteBurger(@PathVariable Long id) {
        Burger removed = burgerDao.remove(id);
        if (removed == null) {
            throw new BurgerException("Burger not found", HttpStatus.NOT_FOUND);
        }
    }

    // İşte burada PathVariable olarak enum kullanıyoruz:
    @GetMapping("/breadType/{breadType}")
    public List<Burger> findByBreadType(@PathVariable BreadType breadType) {
        return burgerDao.findByBreadType(breadType);
    }

    @GetMapping("/price/{price}")
    public List<Burger> findByPrice(@PathVariable double price) {
        return burgerDao.findByPrice(price);
    }

    @GetMapping("/content/{content}")
    public List<Burger> findByContent(@PathVariable String content) {
        return burgerDao.findByContent(content);
    }
}
