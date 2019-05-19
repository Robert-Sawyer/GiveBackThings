package com.github.robertsawyer.GiveBackThings.services;

import com.github.robertsawyer.GiveBackThings.domain.model.TrustedInstitution;
import com.github.robertsawyer.GiveBackThings.domain.repositories.TrustedInstitutionsRepository;
import com.github.robertsawyer.GiveBackThings.dtos.AddInstitutionDTO;
import com.github.robertsawyer.GiveBackThings.dtos.DeleteInstitutionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public List<AddInstitutionDTO> getLocalization() {
        List<AddInstitutionDTO> institutionDTOS = trustedInstitutionsRepository.findAllLocalizations();
        return institutionDTOS;
    }

    public List<AddInstitutionDTO> getAllPurposes() {
        List<AddInstitutionDTO> purpose = trustedInstitutionsRepository.findAllPurposes();
        return purpose;
    }

    @Transactional
    public void createNewInstitution(AddInstitutionDTO newInstitution) {
        TrustedInstitution institution = Converters.convertToTrustedInstitution(newInstitution);
        trustedInstitutionsRepository.save(institution);
    }
}
