package com.Eshop.eshop.Controller;

import com.Eshop.eshop.Dto.ProductCartDTO;
import com.Eshop.eshop.Exception.RecordNotFoundException;
import com.Eshop.eshop.Service.IProductCartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProductCartController {
    private final IProductCartService productCartService;

    public ProductCartController(IProductCartService productCartService) {
        this.productCartService = productCartService;
    }

    @GetMapping("/productCart")
    public ResponseEntity<List<ProductCartDTO>> getAllProductCarts() {
        List<ProductCartDTO> productCarts = productCartService.getAllProductCarts();
        return ResponseEntity.ok(productCarts);
    }

    @PostMapping("/productCart")
    public ResponseEntity<ProductCartDTO> addProductCart(@RequestBody ProductCartDTO productCartDTO) {
        ProductCartDTO createdProductCart = (ProductCartDTO) productCartService.addItems((List<ProductCartDTO>) productCartDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProductCart);
    }

    @GetMapping("/productCart/{id}")
    public ResponseEntity<ProductCartDTO> getProductCartById(@PathVariable Long id) {
        ProductCartDTO productCart = productCartService.getProductCartById(id);
        return ResponseEntity.ok(productCart);
    }

    @PutMapping("/productCart/{id}")
    public ResponseEntity<ProductCartDTO> updateProductCartById(@PathVariable Long id, @RequestBody ProductCartDTO productCartDTO) {
        ProductCartDTO updatedProductCart = productCartService.updateItem(id, productCartDTO);
        return ResponseEntity.ok(updatedProductCart);
    }

    @DeleteMapping("/productCart/{id}")
    public ResponseEntity<Void> deleteProductCartById(@PathVariable Long id) {
        productCartService.deleteItem(id);
        return ResponseEntity.noContent().build();
    }
}