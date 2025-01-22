package com.unfold.unfoldfit.mapper;

import com.unfold.unfoldfit.model.dto.ProductColorDto;
import com.unfold.unfoldfit.model.entity.ProductColor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel="spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductColorMapper {

    @Mapping(source="colorId",target="colorId")
    @Mapping(source="colorName",target="colorName")
    @Mapping(source="hexCode",target="hexCode")
    ProductColorDto convertToProductColorDto(ProductColor productColor);

    @Mapping(source="colorId",target="colorId")
    @Mapping(source="colorName",target="colorName")
    @Mapping(source="hexCode",target="hexCode")
    ProductColor convertToProductColor(ProductColorDto productColorDto);

    List<ProductColorDto> convertToProductColorDto(List<ProductColor> productColors);
}
