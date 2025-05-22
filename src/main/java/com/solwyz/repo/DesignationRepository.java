package com.solwyz.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.solwyz.entity.Designation;

@Repository
public interface DesignationRepository extends JpaRepository<Designation, Long>{

}
