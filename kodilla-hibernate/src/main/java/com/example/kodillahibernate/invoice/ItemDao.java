package com.example.kodillahibernate.invoice;


import org.springframework.data.repository.CrudRepository;

public interface ItemDao extends CrudRepository<Item, Integer> {
}