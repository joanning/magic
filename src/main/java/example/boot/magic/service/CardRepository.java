package example.boot.magic.service;


import org.springframework.data.repository.CrudRepository;

import example.boot.magic.entity.Card;

public interface CardRepository extends CrudRepository<Card, Integer> {

}


