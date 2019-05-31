package com.github.robertsawyer.GiveBackThings.domain.repositories;

import com.github.robertsawyer.GiveBackThings.domain.model.Gift;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GiftRepository extends JpaRepository<Gift, Long> {

}
