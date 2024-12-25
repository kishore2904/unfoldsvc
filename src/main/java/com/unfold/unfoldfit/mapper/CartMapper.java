package com.unfold.unfoldfit.mapper;

import com.unfold.unfoldfit.model.dto.CartDto;
import com.unfold.unfoldfit.model.dto.ProductDto;
import com.unfold.unfoldfit.model.entity.Cart;
import com.unfold.unfoldfit.model.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CartMapper {

    @Mapping(source = "cartItemId", target = "cartItemId")
    @Mapping(source = "userId", target = "userId")
    @Mapping(source = "cartId", target = "cartId")
    @Mapping(source = "quantity", target = "quantity")
    @Mapping(source = "productId", target = "productId")
    Cart convertToCart(CartDto cartDto);

    default CartDto convertToCartDto(Cart cart){
            CartDto cartDto = new CartDto();
            cartDto.setCartItemId(cart.getCartItemId());
            cartDto.setCartId(cart.getCartId());
            cartDto.setQuantity(cart.getQuantity());
            cartDto.setUserId(cart.getUserId());
            cartDto.setProductDtoList(convertToProductDtos(cart.getProducts()));
        return cartDto;
    }

    default List<ProductDto> convertToProductDtos(List<Product> productList){

        List<ProductDto> productDtos = new ArrayList<>();
        for(Product product: productList){
            ProductDto productDto = new ProductDto();
            productDto.setCategoryId(product.getCategoryId());
            productDto.setProductDescription(product.getProductDescription());
            productDto.setProductName(product.getProductName());
            productDto.setProductId(product.getProductId());
            productDto.setImageUrl(product.getImageUrl());
            productDto.setPrice(product.getPrice());
            productDto.setStockQuantity(product.getStockQuantity());
            productDtos.add(productDto);

        }
        return  productDtos;
    }
}
