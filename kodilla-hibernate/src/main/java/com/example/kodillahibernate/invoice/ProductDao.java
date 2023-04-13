package com.example.kodillahibernate.invoice;


import org.springframework.data.repository.CrudRepository;

public interface ProductDao extends CrudRepository<Product, Integer> {
}