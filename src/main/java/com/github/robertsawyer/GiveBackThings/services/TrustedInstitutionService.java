package com.github.robertsawyer.GiveBackThings.services;

import com.github.robertsawyer.GiveBackThings.domain.model.TrustedInstitution;
import com.github.robertsawyer.GiveBackThings.domain.repositories.TrustedInstitutionsRepository;
import com.github.robertsawyer.GiveBackThings.dtos.DeleteInstitutionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrustedInstitutionService {

    @Autowired
    private TrustedInstitutionsRepository trustedInstitutionsRepository;

    public TrustedInstitutionService(TrustedInstitutionsRepository trustedInstitutionsRepository) {
        this.trustedInstitutionsRepository = trustedInstitutionsRepository;
    }

    public List<TrustedInstitution> getAllTrustedIntitutions() {
        List<TrustedInstitution> institutions = trustedInstitutionsRepository.findAllTrustedInstitutions();
        return institutions;
    }

    public void deleteInstitution(DeleteInstitutionDTO deleteInstitutionDTO) {
        trustedInstitutionsRepository.delete(deleteInstitutionDTO.getInstitutionId());

    }
}
