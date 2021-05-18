package com.davydov.shop.endpoints;

import com.davydov.shop.service.ProductService;
import com.davydov.shop.soap.products.GetAllProductsRequest;
import com.davydov.shop.soap.products.GetAllProductsResponse;
import com.davydov.shop.soap.products.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class ProductEndpoint {
  private static final String NAMESPACE_URI = "http://davydov.com/shop/products";
  private ProductService productService;

  @Autowired
  public ProductEndpoint(ProductService productService) {
    this.productService = productService;
  }

  @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllProductsRequest")
  @ResponsePayload
  public GetAllProductsResponse getProducts(@RequestPayload GetAllProductsRequest request) {
    GetAllProductsResponse response = new GetAllProductsResponse();
    productService.findAll().forEach(p -> {
      Product product = new Product();
      product.setId(p.getId());
      product.setTitle(p.getTitle());
      product.setPrice(p.getPrice().doubleValue());
      product.setStatus(p.getStatus());
      response.getProducts().add(product);
    });

    return response;
  }

}
