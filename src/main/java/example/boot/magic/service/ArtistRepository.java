package example.boot.magic.service;

import org.springframework.data.repository.CrudRepository;

import example.boot.magic.entity.Artist;

public interface ArtistRepository extends CrudRepository<Artist, Integer> {

}
