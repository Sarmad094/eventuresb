package com.example.eventuresb.Controller;

import com.example.eventuresb.Model.Organization;
import com.example.eventuresb.Service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/organizations")
public class OrganizationController {

    private final OrganizationService organizationService;

    @Autowired
    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    // Opprette en ny organisasjon
    @PostMapping
    public Organization createOrganization(@RequestBody Organization organization) {
        return organizationService.saveOrganization(organization);
    }

    // Hente en organisasjon basert på ID
    @GetMapping("/{id}")
    public Organization getOrganizationById(@PathVariable Long id) {
        return organizationService.getOrganizationById(id);
    }

    // Slette en organisasjon
    @DeleteMapping("/{id}")
    public void deleteOrganization(@PathVariable Long id) {
        organizationService.deleteOrganization(id);
    }

    // Hente alle organisasjoner
    @GetMapping
    public List<Organization> getAllOrganizations() {
        return organizationService.getAllOrganizations();
    }
}
