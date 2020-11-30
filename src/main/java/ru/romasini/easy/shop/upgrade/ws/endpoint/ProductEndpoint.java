package ru.romasini.easy.shop.upgrade.ws.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ru.romasini.easy.shop.upgrade.services.ProductService;
import ru.romasini.easy.shop.upgrade.ws.GetProductsResponse;
import ru.romasini.easy.shop.upgrade.ws.ProductWs;

import java.util.stream.Collectors;

@Endpoint
public class ProductEndpoint {
    private static final String NAMESPACE_URI = "http://www.romasini.ru/spring/ws/main";

    private ProductService productService;

    @Autowired
    public ProductEndpoint(ProductService productService){
        this.productService = productService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getProductsRequest")
    @ResponsePayload
    public GetProductsResponse getProducts(){
        GetProductsResponse response = new GetProductsResponse();
        response.setProducts(productService.findAll().stream().map((p)-> new ProductWs(p)).collect(Collectors.toList()));
        return response;
    }

}
