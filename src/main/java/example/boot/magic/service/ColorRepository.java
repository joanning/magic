package example.boot.magic.service;

import org.springframework.data.repository.CrudRepository;

import example.boot.magic.entity.Color;

public interface ColorRepository extends CrudRepository<Color, Integer> {

}
