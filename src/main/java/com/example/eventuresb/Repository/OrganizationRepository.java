package com.example.eventuresb.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.eventuresb.Model.Organization;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {
    // Basis CRUD-operasjoner arves fra JpaRepository
}