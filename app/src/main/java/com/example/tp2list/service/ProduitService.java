package com.example.tp2list.service;

import com.example.tp2list.dao.IDao;
import com.example.tp2list.entities.Pizza;

import java.util.ArrayList;
import java.util.List;

public class ProduitService implements IDao<Pizza> {
    private List<Pizza> pizzas;
    private static ProduitService instance;

    // Singleton pattern
    private ProduitService() {
        this.pizzas = new ArrayList<>();
    }

    public static ProduitService getInstance() {
        if(instance == null)
            instance = new ProduitService();
        return instance;
    }

    @Override
    public boolean create(Pizza o) {
        return pizzas.add(o);
    }

    @Override
    public boolean update(Pizza o) {
        for(int i = 0; i < pizzas.size(); i++){
            if(pizzas.get(i).getId() == o.getId()){
                pizzas.set(i, o);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(Pizza o) {
        return pizzas.remove(o);
    }

    @Override
    public List<Pizza> findAll() {
        return pizzas;
    }

    @Override
    public Pizza findById(int id) {
        for(Pizza p : pizzas){
            if(p.getId() == id)
                return p;
        }
        return null;
    }
}