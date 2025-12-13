package com.asif.sweet_shop_backend.Controller;

import com.asif.sweet_shop_backend.Service.InventoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/sweets")
public class InventoryController {

    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @PostMapping("/{id}/purchase")
    public ResponseEntity<?> purchaseSweet(@PathVariable Long id) {
        inventoryService.purchaseSweet(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/restock")
    public ResponseEntity<?> restockSweet(@PathVariable Long id) {
        inventoryService.restockSweet(id);
        return ResponseEntity.ok().build();
    }
}
