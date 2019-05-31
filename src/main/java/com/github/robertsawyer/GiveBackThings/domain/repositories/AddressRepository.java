package com.github.robertsawyer.GiveBackThings.domain.repositories;

import com.github.robertsawyer.GiveBackThings.domain.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
