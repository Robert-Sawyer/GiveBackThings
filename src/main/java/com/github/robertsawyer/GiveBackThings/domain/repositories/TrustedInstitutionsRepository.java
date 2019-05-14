package com.github.robertsawyer.GiveBackThings.domain.repositories;

import com.github.robertsawyer.GiveBackThings.domain.model.TrustedInstitution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TrustedInstitutionsRepository extends JpaRepository<TrustedInstitution, Long> {

    @Query(value = "SELECT * FROM trusted_institutions",
    nativeQuery = true)
    List<TrustedInstitution> findAllTrustedInstitutions();
}
