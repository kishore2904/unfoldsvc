package com.unfold.unfoldfit.mapper;

import com.unfold.unfoldfit.model.dto.CartDto;
import com.unfold.unfoldfit.model.entity.Cart;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CartMapper {

    @Mapping(source = "variantId", target = "variantId")
    @Mapping(source = "userId", target = "userId")
    @Mapping(source = "cartId", target = "cartId")
    @Mapping(source = "quantity", target = "quantity")
    @Mapping(source = "productId", target = "productId")
    @Mapping(source = "createdAt", target = "createdAt")
    Cart convertToCart(CartDto cartDto);

    @Mapping(source = "variantId", target = "variantId")
    @Mapping(source = "userId", target = "userId")
    @Mapping(source = "cartId", target = "cartId")
    @Mapping(source = "quantity", target = "quantity")
    @Mapping(source = "productId", target = "productId")
    @Mapping(source = "createdAt", target = "createdAt")
    CartDto convertToCartDto(Cart cart);

    List<CartDto> convertToCartDto(List<Cart> carts);
}
