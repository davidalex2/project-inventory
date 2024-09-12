package com.algoriant.product.repository;

import com.algoriant.product.model.Product;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Transactional
@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

    @Modifying
    @Query(value = "INSERT INTO product (product_id, product_name, category, description, price) VALUES(:productId, :productName, :category, :description, :price)", nativeQuery = true)
    void insertProduct(@Param("productId")BigInteger productId, @Param("productName") String productName, @Param("category") String category, @Param("description") String description, @Param("price") BigDecimal price);

    @Query(value = "SELECT * FROM product", nativeQuery = true)
    List<Product> getAllProducts();

    @Query(value = "SELECT * FROM product WHERE product_id = :productId", nativeQuery = true)
    Product getProductById(@Param("productId") BigInteger productId);
    @Modifying
    @Query(value = "DELETE FROM product WHERE product_id = :productId",nativeQuery = true)
    void deleteProductById(@Param("productId") BigInteger productId);

    @Modifying
    @Query(value = "UPDATE product SET product_name = :productName, description = :description, price = :price, category = :category, updated_at = now() WHERE product_id = :productId",nativeQuery = true)
    public void updateProduct(@Param("productId") BigInteger productId,@Param("productName") String productName,
                       @Param("description") String description, @Param("price") BigDecimal price,
                       @Param("category") String category);



}
