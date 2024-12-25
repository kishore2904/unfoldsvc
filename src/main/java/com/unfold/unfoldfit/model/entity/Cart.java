package com.unfold.unfoldfit.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Cart_Items")
public class Cart {

    @Id
    @Column(name = "cart_item_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cartItemId;

    @Column(name="user_id",nullable = false,unique = true)
    private Integer userId;

    @Column(name="cart_id",nullable = false)
    private Integer cartId;

    @Column(name="quantity",nullable = false)
    private Integer quantity;

    @Column(name="product_id",nullable = false)
    private Integer productId;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name="product_id", referencedColumnName = "product_id",
            insertable = false,updatable = false)
    private List<Product> products;

    public Integer getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(Integer cartItemId) {
        this.cartItemId = cartItemId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
