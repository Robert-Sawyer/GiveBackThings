package com.github.robertsawyer.GiveBackThings.services;

import com.github.robertsawyer.GiveBackThings.domain.model.Institution;
import com.github.robertsawyer.GiveBackThings.domain.model.Location;
import com.github.robertsawyer.GiveBackThings.domain.model.Purpose;
import com.github.robertsawyer.GiveBackThings.domain.repositories.InstitutionRepository;
import com.github.robertsawyer.GiveBackThings.domain.repositories.LocationRepository;
import com.github.robertsawyer.GiveBackThings.domain.repositories.PurposeRepository;
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

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private PurposeRepository purposeRepository;

    public InstitutionService(InstitutionRepository institutionRepository, LocationRepository locationRepository, PurposeRepository purposeRepository) {
        this.institutionRepository = institutionRepository;
        this.locationRepository = locationRepository;
        this.purposeRepository = purposeRepository;
    }

    public List<Institution> getAllInstitutions() {
        List<Institution> institutions = institutionRepository.findAllInstitutions();
        return institutions;
    }

    public void deleteInstitution(DeleteInstitutionDTO deleteInstitutionDTO) {
        institutionRepository.delete(deleteInstitutionDTO.getInstitutionId());

    }

    public List<Location> getLocalization() {
        List<Location> locations = locationRepository.findAll();
        return locations;
    }

    public List<Purpose> getPurposes() {
        List<Purpose> purposes = purposeRepository.findAll();
        return purposes;
    }

    @Transactional
    public void createNewInstitution(AddInstitutionDTO newInstitution) {
        Location location = locationRepository.findById(newInstitution.getLocationId());
        Purpose purpose = purposeRepository.findById(newInstitution.getPurposeId());
        Institution institution = Converters.convertToTrustedInstitution(newInstitution, purpose, location);
        institutionRepository.save(institution);
    }
}
