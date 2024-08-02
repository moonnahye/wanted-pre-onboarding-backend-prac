package com.nnhh.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nnhh.practice.model.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {

}
