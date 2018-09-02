package qs.rabbitmq.repositories;

import org.springframework.data.repository.CrudRepository;
import qs.rabbitmq.domain.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
