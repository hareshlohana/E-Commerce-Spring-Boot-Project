package com.Eshop.eshop.Service;

import com.Eshop.eshop.Dto.ProductDTO;

import java.util.List;
import java.util.Map;

public interface IProductService {
    List<ProductDTO> getAllProducts();

    ProductDTO addProduct(ProductDTO productDTO);

    ProductDTO getProductById(Long id);

    ProductDTO deleteProductById(Long id);

    ProductDTO updateProductById(Long id, Map<String, Object> fields);
}
