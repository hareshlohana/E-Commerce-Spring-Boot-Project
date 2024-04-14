package com.Eshop.eshop.Service.Impl;

import com.Eshop.eshop.Dto.CartDTO;
import com.Eshop.eshop.Exception.RecordNotFoundException;
import com.Eshop.eshop.Service.ICartService;
import com.Eshop.eshop.domain.Cart;
import com.Eshop.eshop.repositories.CartRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CartServiceImpl implements ICartService {
    private final ModelMapper modelMapper;
    private final CartRepository cartRepository;

    public CartServiceImpl(ModelMapper modelMapper, CartRepository cartRepository) {
        this.modelMapper = modelMapper;
        this.cartRepository = cartRepository;
    }

    @Override
    public List<CartDTO> getAllCarts() {
        return cartRepository.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CartDTO getCartById(Long id) {
        Cart cart = cartRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Cart not found with id: " + id));
        return toDto(cart);
    }

    @Override
    public CartDTO addCart(CartDTO cartDTO) {
        cartDTO.setDate(LocalDate.now());
        Cart savedCart = cartRepository.save(toDomain(cartDTO));
        return toDto(savedCart);
    }

//    @Override
//    public CartDTO updateCartById(Long id, CartDTO cartDTO) {
//        Cart existingCart = cartRepository.findById(id)
//                .orElseThrow(() -> new RecordNotFoundException("Cart not found with id: " + id));
//
//        // Update the fields of existing cart
//        existingCart.setDate(cartDTO.getQuantity());
//        // Update other fields as needed
//
//        Cart updatedCart = cartRepository.save(existingCart);
//        return toDto(updatedCart);
//    }

    @Override
    public void deleteCart(Long id) {
        Optional<Cart> cart = cartRepository.findById(id);
        if (cart.isPresent()) {
            cartRepository.delete(cart.get());
        } else {
            throw new RecordNotFoundException("Cart not found with id: " + id);
        }
    }

    private Cart toDomain(CartDTO cartDTO) {
        return modelMapper.map(cartDTO, Cart.class);
    }

    private CartDTO toDto(Cart cart) {
        return modelMapper.map(cart, CartDTO.class);
    }
}
