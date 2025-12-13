package com.asif.sweet_shop_backend.Repo;

import com.asif.sweet_shop_backend.Entity.Sweet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SweetRepository extends JpaRepository<Sweet, Long> {
}
