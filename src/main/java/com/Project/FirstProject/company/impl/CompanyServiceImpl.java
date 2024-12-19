package com.Project.FirstProject.company.impl;

import com.Project.FirstProject.company.Company;
import com.Project.FirstProject.company.CompanyRepository;
import com.Project.FirstProject.company.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAll() {
        return companyRepository.findAll();
    }

    @Override
    public void createCompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public Company getCompanyById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    @Override
    public boolean updateCompanyById(Long id, Company company) {
        Optional<Company> companyOptional = companyRepository.findById(id);
        if(companyOptional.isPresent()){
            Company comp = companyOptional.get();
            comp.setName(company.getName());
            comp.setDescription(company.getDescription());
            companyRepository.save(comp);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteCompany(Long id) {
        try {
            companyRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
