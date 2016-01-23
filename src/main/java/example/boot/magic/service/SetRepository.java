package example.boot.magic.service;

import org.springframework.data.repository.CrudRepository;

import example.boot.magic.entity.Set;

public interface SetRepository extends CrudRepository<Set, Integer> {

}
