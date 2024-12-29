package com.unfold.unfoldfit.controller;

import com.unfold.unfoldfit.model.dto.CartDto;
import com.unfold.unfoldfit.model.dto.CategoryDto;
import com.unfold.unfoldfit.service.impl.CartServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/rest/unfold")
public class CartController {

    private final CartServiceImpl cartServiceImpl;

    public CartController(CartServiceImpl cartServiceImpl) {
        this.cartServiceImpl = cartServiceImpl;
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<CartDto>> findCartItemsByUserId(@PathVariable Integer userId){
        return ResponseEntity.ok(cartServiceImpl.getAllCartItemsByUserId(userId));
    }

    @PostMapping("/cartProducts")
    ResponseEntity<Void> saveCategories(@RequestBody CartDto cartDto){
        cartServiceImpl.addProductsOrModifyQuantityOfProductToCart(cartDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping(value = "/cart/{deleteId}")
    ResponseEntity<Void> deleteByCartId(@PathVariable Integer cartId){
        cartServiceImpl.delete(cartId);
        return ResponseEntity.noContent().build();

    }
}
