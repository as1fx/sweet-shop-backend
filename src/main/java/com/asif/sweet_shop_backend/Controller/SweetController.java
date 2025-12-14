package com.asif.sweet_shop_backend.Controller;

import com.asif.sweet_shop_backend.Entity.Sweet;
import com.asif.sweet_shop_backend.Service.SweetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sweets")
public class SweetController {

    private final SweetService sweetService;

    public SweetController(SweetService sweetService) {
        this.sweetService = sweetService;
    }

    @PostMapping
    public ResponseEntity<?> addSweet(@RequestBody Sweet sweet) {
        sweetService.addSweet(sweet);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public List<Sweet> getAllSweets() {
        return sweetService.getAllSweets();
    }

    @GetMapping("/search")
    public List<Sweet> searchSweet() {
        return sweetService.getAllSweets();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateSweets(@PathVariable Long id, @RequestBody Sweet sweet) {
        sweetService.updateSweet(id, sweet);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSweets(@PathVariable Long id) {
        sweetService.deleteSweet(id);
        return ResponseEntity.noContent().build();
    }

}
