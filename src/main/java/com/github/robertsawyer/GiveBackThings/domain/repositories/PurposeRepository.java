package com.github.robertsawyer.GiveBackThings.domain.repositories;

import com.github.robertsawyer.GiveBackThings.domain.model.Purpose;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PurposeRepository extends JpaRepository<Purpose, Long> {

    @Query(value = "SELECT * FROM purposes WHERE id = ?",
    nativeQuery = true)
    Purpose findById(Long purposeId);
}
