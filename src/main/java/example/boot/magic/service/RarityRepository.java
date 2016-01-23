package example.boot.magic.service;

import org.springframework.data.repository.CrudRepository;

import example.boot.magic.entity.Rarity;

public interface RarityRepository extends CrudRepository<Rarity, Integer> {

}
