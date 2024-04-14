package com.Eshop.eshop.Controller;

import com.Eshop.eshop.Dto.CartDTO;
import com.Eshop.eshop.Service.ICartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class CartController {
    private final ICartService cartService;

    public CartController(ICartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/carts")
    public ResponseEntity<List<CartDTO>> getAllCarts() {
        List<CartDTO> carts = cartService.getAllCarts();
        return ResponseEntity.ok(carts);
    }

    @GetMapping("/carts/{id}")
    public ResponseEntity<CartDTO> getCartById(@PathVariable Long id) {
        CartDTO cart = cartService.getCartById(id);
        return ResponseEntity.ok(cart);
    }

    @PostMapping("/carts")
    public ResponseEntity<CartDTO> addCart(@RequestBody CartDTO cartDTO) {
        CartDTO createdCart = cartService.addCart(cartDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCart);
    }

//    @PutMapping("/carts/{id}")
//    public ResponseEntity<CartDTO> updateCartById(@PathVariable Long id, @RequestBody CartDTO cartDTO) {
//        CartDTO updatedCart = cartService.updateCartById(id, cartDTO);
//        return ResponseEntity.ok(updatedCart);
//    }

    @DeleteMapping("/carts/{id}")
    public ResponseEntity<Void> deleteCart(@PathVariable Long id) {
        cartService.deleteCart(id);
        return ResponseEntity.noContent().build();
    }
}
