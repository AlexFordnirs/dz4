package com.yourcompany.inventoryservice.controller;

import com.yourcompany.inventoryservice.model.Product;
import com.yourcompany.inventoryservice.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;

    @PostMapping("/products")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product newProduct = inventoryService.saveProduct(product);
        return ResponseEntity.ok(newProduct);
    }

    @PutMapping("/products/{productId}/stock")
    public ResponseEntity<?> updateStock(@PathVariable Long productId, @RequestParam int quantity) {
        inventoryService.updateStock(productId, quantity);
        return ResponseEntity.ok().build();
    }
}
