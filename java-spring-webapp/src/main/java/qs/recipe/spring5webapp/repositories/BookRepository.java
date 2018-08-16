package qs.recipe.spring5webapp.repositories;

import qs.recipe.spring5webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long> {
}
