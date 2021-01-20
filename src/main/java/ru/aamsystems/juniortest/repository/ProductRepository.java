package ru.aamsystems.juniortest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import ru.aamsystems.juniortest.model.entity.Product;

import java.util.List;

@Component
public interface ProductRepository extends JpaRepository<Product,Long> {

    @Query("SELECT p FROM Product p where p.name LIKE %:name%")
    List<Product> findByName(@Param("name")String name);
}
