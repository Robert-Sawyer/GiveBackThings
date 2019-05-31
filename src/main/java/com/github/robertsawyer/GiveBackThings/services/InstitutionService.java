package com.github.robertsawyer.GiveBackThings.services;

import com.github.robertsawyer.GiveBackThings.domain.model.Institution;
import com.github.robertsawyer.GiveBackThings.domain.repositories.InstitutionRepository;
import com.github.robertsawyer.GiveBackThings.dtos.AddInstitutionDTO;
import com.github.robertsawyer.GiveBackThings.dtos.DeleteInstitutionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InstitutionService {

    @Autowired
    private InstitutionRepository institutionRepository;

    public InstitutionService(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }

    public List<Institution> getAllInstitutions() {
        List<Institution> institutions = institutionRepository.findAllInstitutions();
        return institutions;
    }

    public void deleteInstitution(DeleteInstitutionDTO deleteInstitutionDTO) {
        institutionRepository.delete(deleteInstitutionDTO.getInstitutionId());

    }

    public List<AddInstitutionDTO> getLocalization() {
        List<AddInstitutionDTO> institutionDTOS = institutionRepository.findAllLocations();
        return institutionDTOS;
    }

    public List<AddInstitutionDTO> getAllPurposes() {
        List<AddInstitutionDTO> purpose = institutionRepository.findAllPurposes();
        return purpose;
    }

    @Transactional
    public void createNewInstitution(AddInstitutionDTO newInstitution) {
        Institution institution = Converters.convertToTrustedInstitution(newInstitution);
        institutionRepository.save(institution);
    }
}
