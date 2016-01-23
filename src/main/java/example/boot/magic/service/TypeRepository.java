package example.boot.magic.service;

import org.springframework.data.repository.CrudRepository;

import example.boot.magic.entity.Type;

public interface TypeRepository extends CrudRepository<Type, Integer> {

}
