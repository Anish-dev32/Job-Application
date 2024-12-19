package com.Project.FirstProject.company;

import java.util.List;

public interface CompanyService {

    List<Company> getAll();

    void createCompany(Company company);

    Company getCompanyById(Long id);

    boolean updateCompanyById(Long id, Company company);

    boolean deleteCompany(Long id);
}
