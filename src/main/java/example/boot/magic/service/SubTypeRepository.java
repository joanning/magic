package example.boot.magic.service;

import org.springframework.data.repository.CrudRepository;

import example.boot.magic.entity.SubType;

public interface SubTypeRepository extends CrudRepository<SubType, Integer> {

}
