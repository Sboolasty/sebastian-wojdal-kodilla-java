package com.example.kodillahibernate.manytomany;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;
@NamedQueries({
        @NamedQuery(
                name = "Company.retrieveCompanyWhereNameStartsWith",
                query = "from Company where name like CONCAT(:COMPANYNAME,'__%')"
        ),
        @NamedQuery(
                name = "Company.retrieveCompanyWhereNameContains",
                query = "from Company where name like CONCAT('%',:COMPANYNAME,'%')"
        )
})
@NamedNativeQuery(
        name = "Company.retrieveCompanyWhereNameStartsWithNative",
        query = "SELECT * from companies where company_name like CONCAT(:COMPANYNAME,'__%');",
        resultClass = Company.class
)
@Entity
@Table(name = "COMPANIES")
public class Company {

    private int id;
    private String name;
    private List<Employee> employees = new ArrayList<>();
    public Company() {
    }

    public Company(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "COMPANY_ID", unique = true)
    public int getId() {
        return id;
    }

    @NotNull
    @Column(name = "COMPANY_NAME")
    public String getName() {
        return name;
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setName(String name) {
        this.name = name;
    }
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "companies")
    public List<Employee> getEmployees() {
        return employees;
    }

    private void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}