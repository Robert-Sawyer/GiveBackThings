package com.github.robertsawyer.GiveBackThings.domain.repositories;

import com.github.robertsawyer.GiveBackThings.domain.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {

}
