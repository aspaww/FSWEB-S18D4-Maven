package com.workintech.s18d1.dao;

import com.workintech.s18d1.entity.BreadType;
import com.workintech.s18d1.entity.Burger;

import java.util.List;

public interface BurgerDao {
    Burger save(Burger burger);

    // Tek bir Burger dönüyoruz:
    Burger findById(Long id);

    List<Burger> findAll();

    List<Burger> findByPrice(double price);

    List<Burger> findByBreadType(BreadType breadType);

    List<Burger> findByContent(String content);

    Burger update(Burger burger);

    // remove da Long alıp Burger dönecek
    Burger remove(Long id);
}
