package com.unfold.unfoldfit.service.impl;

import com.unfold.unfoldfit.mapper.CartMapper;
import com.unfold.unfoldfit.model.dto.CartDto;
import com.unfold.unfoldfit.model.entity.Cart;
import com.unfold.unfoldfit.model.entity.Product;
import com.unfold.unfoldfit.repository.CartRepository;
import com.unfold.unfoldfit.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl {

    private final CartRepository cartRepository;
    private final ProductRepository productRepository;
    private final CartMapper cartMapper;

    public CartServiceImpl(CartRepository cartRepository, ProductRepository productRepository
    ,CartMapper cartMapper) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
        this.cartMapper = cartMapper;
    }

    public void addProductsOrModifyQuantityOfProductToCart(CartDto cartDto){

        Optional<Product> product = productRepository.findById(cartDto.getProductId());

        if(product.isPresent() &&
                (product.get().getStockQuantity() < cartDto.getQuantity())){

            Cart cartDetails = cartRepository.findByProductId(cartDto.getProductId());

            if(cartDetails != null){
                Integer addingQuantityToExisting = cartDto.getQuantity() + cartDetails.getQuantity();
                cartDetails.setQuantity(addingQuantityToExisting);
                cartRepository.save(cartDetails);
            }else{
                Cart cart = cartMapper.convertToCart(cartDto);
                cartRepository.save(cart);
            }

        }else{
             throw new RuntimeException("Product doesn't exists");
        }

    }
    public List<CartDto> getAllCartItemsByUserId(Integer userId){

        List<Cart> carts = cartRepository.findByUserId(userId);
        return cartMapper.convertToCartDto(carts);

    }
    public void delete(Integer cartId){

        cartRepository.deleteById(cartId);

    }
}
