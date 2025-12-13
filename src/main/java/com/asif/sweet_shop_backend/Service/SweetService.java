package com.asif.sweet_shop_backend.Service;

import com.asif.sweet_shop_backend.Entity.Sweet;
import com.asif.sweet_shop_backend.Repo.SweetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SweetService {

    private final SweetRepository sweetRepository;

    public SweetService(SweetRepository sweetRepository) {
        this.sweetRepository = sweetRepository;
    }

    public Sweet addSweet(Sweet sweet){
        return sweetRepository.save(sweet);
    }

    public List<Sweet> getAllSweets(){
        return sweetRepository.findAll();
    }

    public Sweet updateSweet(Long id, Sweet sweet){
        sweet.setId(id);

        return sweetRepository.save(sweet);
    }

    public void deleteSweet(Long id){
        sweetRepository.deleteById(id);
    }
}
