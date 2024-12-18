package com.unfold.unfoldfit.mapper;

import com.unfold.unfoldfit.model.dto.ProductDto;
import com.unfold.unfoldfit.model.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel="spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {

    @Mapping(source="productId",target="productId")
    @Mapping(source="productName",target="productName")
    @Mapping(source="productDescription",target="productDescription")
    @Mapping(source="price",target="price")
    @Mapping(source="stockQuantity",target="stockQuantity")
    @Mapping(source="imageUrl",target="imageUrl")
    ProductDto convertToProductDto(Product product);

    @Mapping(source="productId",target="productId")
    @Mapping(source="productName",target="productName")
    @Mapping(source="productDescription",target="productDescription")
    @Mapping(source="price",target="price")
    @Mapping(source="stockQuantity",target="stockQuantity")
    @Mapping(source="imageUrl",target="imageUrl")
    Product convertToProduct(ProductDto productDto);

    List<Product> convertToProduct(List<ProductDto> productDtoList);
}
