package com.Eshop.eshop.Service.Impl;

import com.Eshop.eshop.Dto.ProductCartDTO;
import com.Eshop.eshop.Exception.RecordNotFoundException;
import com.Eshop.eshop.Service.IProductCartService;
import com.Eshop.eshop.domain.ProductCart;
import com.Eshop.eshop.repositories.ProductCartRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class ProductCartImpl implements IProductCartService {
    ModelMapper modelMapper;
    ProductCartRepository productCartRepository;

    public ProductCartImpl(ModelMapper modelMapper, ProductCartRepository productCartRepository) {
        this.modelMapper = modelMapper;
        this.productCartRepository = productCartRepository;
    }

    @Override
    public List<ProductCartDTO> getAllProductCarts() {
      return productCartRepository.findAll().stream().map(c->toDto(c)).collect(Collectors.toList());
    }

    @Override
    public List<ProductCartDTO> addItems(List<ProductCartDTO> productCartDTOs) {
        List<ProductCart> productCarts = productCartDTOs.stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
        List<ProductCart> savedProductCarts = productCartRepository.saveAll(productCarts);
        return savedProductCarts.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductCartDTO updateItem(Long id, ProductCartDTO productCartDTO) {
        ProductCart existingProductCart = productCartRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("ProductCart not found with id: " + id));
        // Update fields of existing product cart
        existingProductCart.setQuantity(productCartDTO.getQuantity());
        // Add more fields to update as needed

        ProductCart updatedProductCart = productCartRepository.save(existingProductCart);
        return toDto(updatedProductCart);
    }

    @Override
    public void deleteItem(Long id) {
        Optional<ProductCart> productCartOptional = productCartRepository.findById(id);
        if (productCartOptional.isPresent()) {
            productCartRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException("ProductCart not found with id: " + id);
        }
    }

    @Override
    public ProductCartDTO getProductCartById(Long id) {
        ProductCart productCart = productCartRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("ProductCart not found with id: " + id));
        return toDto(productCart);
    }

    public ProductCart toDomain(ProductCartDTO productCartDTO){
        return modelMapper.map(productCartDTO,ProductCart.class);
    }
    public  ProductCartDTO toDto(ProductCart productCart){

        return modelMapper.map(productCart,ProductCartDTO.class);
    }
}
