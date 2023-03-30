package com.jayit.repository;

import org.springframework.data.repository.CrudRepository;

import com.jayit.entity.BookEntity;

public interface BookRepository extends CrudRepository<BookEntity, Integer> {

}
