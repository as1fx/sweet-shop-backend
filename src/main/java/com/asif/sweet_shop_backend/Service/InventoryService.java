package com.asif.sweet_shop_backend.Service;

import com.asif.sweet_shop_backend.Entity.Sweet;
import com.asif.sweet_shop_backend.Repo.SweetRepository;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {

    private final SweetRepository sweetRepository;

    public InventoryService(SweetRepository sweetRepository) {
        this.sweetRepository = sweetRepository;
    }

    public void purchaseSweet(Long id) {
        Sweet sweet = new Sweet();
        sweet.setQuantity(sweet.getQuantity() - 1);
        sweetRepository.save(sweet);
    }

    public void restockSweet(Long id) {
        Sweet sweet = sweetRepository.findById(id).orElseThrow();
        sweet.setQuantity(sweet.getQuantity() + 10);
        sweetRepository.save(sweet);
    }
}
