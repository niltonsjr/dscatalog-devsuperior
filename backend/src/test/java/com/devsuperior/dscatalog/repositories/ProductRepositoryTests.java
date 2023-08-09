package com.devsuperior.dscatalog.repositories;

import com.devsuperior.dscatalog.Factory;
import com.devsuperior.dscatalog.entities.Product;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.EmptyResultDataAccessException;

@DataJpaTest
public class ProductRepositoryTests {

  @Autowired
  private ProductRepository repository;

  private Long existingId;
  private Long nonExistingId;
  private Long countTotalProducts;

  @BeforeEach
  void setUp() throws Exception {
    existingId = 1L;
    nonExistingId = 1000L;
    countTotalProducts = 25L;
  }

  @Test
  public void deleteShouldDeleteObjectWhenIdExists() {
    repository.deleteById(existingId);

    Optional<Product> result = repository.findById(existingId);
    Assertions.assertFalse(result.isPresent());
  }

  @Test
  public void deleteShouldThrowEmptyResoultNotFoundExceptionWhenIdDoesNotExists() {
    Assertions.assertThrows(
      EmptyResultDataAccessException.class,
      () -> {
        repository.deleteById(nonExistingId);
      }
    );
  }

  @Test
  public void saveShouldPersistWhithAutoincrementWhenIdIsNull() {
    Product product = Factory.createProduct();
    product.setId(null);

    product = repository.save(product);

    Assertions.assertNotNull(product.getId());
    Assertions.assertEquals(countTotalProducts + 1, product.getId());
  }

  @Test
  public void findByIdShouldReturnNotEmptyOptionalWhenIdExists() {
    Optional<Product> result = repository.findById(existingId);
    Assertions.assertTrue(result.isPresent());
  }

  @Test
  public void findByDiShouldReturnEmptyOptionalWhenIdDoesNotExists() {
    Optional<Product> result = repository.findById(nonExistingId);
    Assertions.assertFalse(result.isPresent());
  }
}
