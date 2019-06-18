package com.github.robertsawyer.GiveBackThings.domain.repositories;

import com.github.robertsawyer.GiveBackThings.domain.model.Institution;
import com.github.robertsawyer.GiveBackThings.dtos.AddInstitutionDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InstitutionRepository extends JpaRepository<Institution, Long> {

    @Query(value = "SELECT * FROM institutions",
    nativeQuery = true)
    List<Institution> findAllInstitutions();

    @Query(value = "SELECT name FROM locations",
    nativeQuery = true)
    List<AddInstitutionDTO> findAllLocations();

    @Query(value = "SELECT name FROM purposes",
    nativeQuery = true)
    List<AddInstitutionDTO> findAllPurposes();

    @Query(value = "SELECT * FROM institutions WHERE location_id = ? AND purpose_id = ?",
    nativeQuery = true)
    List<Institution> findProperInstitution(Long locationId, Long purposeId);
}
