package com.unfold.unfoldfit.mapper;

import com.unfold.unfoldfit.model.dto.ProductSizeDto;
import com.unfold.unfoldfit.model.entity.ProductSize;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel="spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductSizeMapper {

    @Mapping(source="sizeId",target="sizeId")
    @Mapping(source="sizeName",target="sizeName")
    ProductSizeDto convertToProductSizeDto(ProductSize productSize);

    @Mapping(source="sizeId",target="sizeId")
    @Mapping(source="sizeName",target="sizeName")
    ProductSize convertToProductSize(ProductSizeDto productSizeDto);

    List<ProductSizeDto> convertToProductSizeDto(List<ProductSize> productSizes);
}
