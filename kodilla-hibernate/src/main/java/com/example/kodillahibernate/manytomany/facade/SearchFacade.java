package com.example.kodillahibernate.manytomany.facade;


import com.example.kodillahibernate.manytomany.Company;
import com.example.kodillahibernate.manytomany.Employee;
import com.example.kodillahibernate.manytomany.dao.CompanyDao;
import com.example.kodillahibernate.manytomany.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SearchFacade {
    private final CompanyDao companyDao;
    private final EmployeeDao employeeDao;

    @Autowired
    public SearchFacade(CompanyDao companyDao, EmployeeDao employeeDao) {
        this.companyDao = companyDao;
        this.employeeDao = employeeDao;
    }
    List<Employee> searchForEmployee(String name){
        return employeeDao.retrieveEmployeeWhereNameContains(name);
    }
    List<Company> searchForCompany(String name){
        return companyDao.retrieveCompanyWhereNameContains(name);
    }
}