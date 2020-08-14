package org.example.repository;

import org.example.entity.PharmacyDetails;
import org.springframework.data.repository.CrudRepository;

public interface PharmacyRepository extends CrudRepository<PharmacyDetails,Integer> {

}
