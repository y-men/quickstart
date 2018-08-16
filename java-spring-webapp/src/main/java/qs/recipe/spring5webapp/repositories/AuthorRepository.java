package qs.recipe.spring5webapp.repositories;

import qs.recipe.spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository <Author, Long> {
}
