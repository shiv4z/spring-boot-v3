package in.shiv.repsitory;

import org.springframework.data.jpa.repository.JpaRepository;

import in.shiv.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
