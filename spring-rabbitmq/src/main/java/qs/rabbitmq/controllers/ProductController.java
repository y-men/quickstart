package qs.rabbitmq.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import qs.rabbitmq.services.ProductService;


@Controller
@Slf4j
public class ProductController {

   // @Autowired // Not recommended ...
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @RequestMapping("/product/indexProduct/{id}")
    public String indexProduct(@PathVariable String id) {
        log.debug(" >>>>>> indexProduct : sending message");
        productService.sendProductMessage(id);
        return "redirect:/product/show/" + id;

    }
}
