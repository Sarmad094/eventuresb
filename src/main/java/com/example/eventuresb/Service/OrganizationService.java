package com.example.eventuresb.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.eventuresb.Model.Organization;
import com.example.eventuresb.Repository.OrganizationRepository;

@Service
public class OrganizationService {

    @Autowired
    private OrganizationRepository organizationRepository;

    // For å opprette en ny organisasjon
    public Organization saveOrganization(Organization organization) {
        return organizationRepository.save(organization);
    }

    // For å hente en organisasjon basert på ID
    public Organization getOrganizationById(Long id) {
        return organizationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Organization not found with id: " + id));
    }

    // For å slette en organisasjon
    public void deleteOrganization(Long id) {
        organizationRepository.deleteById(id);
    }

    // For å hente alle organisasjoner
    public List<Organization> getAllOrganizations() {
        return organizationRepository.findAll();
    }
}