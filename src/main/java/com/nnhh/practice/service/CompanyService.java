package com.nnhh.practice.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nnhh.practice.model.Company;
import com.nnhh.practice.repository.CompanyRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CompanyService {

	private final CompanyRepository companyRepository;

	@Transactional(readOnly = true)
	public Company getCompanyById(int comId) {
		return companyRepository.findById(comId).orElse(null);
	}

}
