package com.unfold.unfoldfit.repository;

import com.unfold.unfoldfit.model.entity.ProductVariant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductVariantRepository extends JpaRepository<ProductVariant,Long> {
}
