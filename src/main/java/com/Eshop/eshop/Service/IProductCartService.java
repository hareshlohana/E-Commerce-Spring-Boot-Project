package com.Eshop.eshop.Service;

import com.Eshop.eshop.Dto.ProductCartDTO;

import java.util.List;

public interface IProductCartService {
   List<ProductCartDTO> getAllProductCarts();
   List<ProductCartDTO> addItems(List<ProductCartDTO> productCartDTOs);
   ProductCartDTO updateItem(Long id, ProductCartDTO productCartDTO);
   void deleteItem(Long id);
   ProductCartDTO getProductCartById(Long id);
}
