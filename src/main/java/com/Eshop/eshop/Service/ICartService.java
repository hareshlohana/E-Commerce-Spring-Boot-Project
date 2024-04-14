package com.Eshop.eshop.Service;

import com.Eshop.eshop.Dto.CartDTO;

import java.util.List;

public interface ICartService {
    List<CartDTO> getAllCarts();

    CartDTO getCartById(Long id);

//    CartDTO updateCartById(Long id, CartDTO cartDTO);

    void deleteCart(Long id);

    CartDTO addCart(CartDTO cartDTO);

}
