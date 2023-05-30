package com.example.kodillahibernate.manytomany.dao;



import com.example.kodillahibernate.manytomany.Company;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import jakarta.transaction.Transactional;

import java.util.List;

@Transactional
@Repository
public interface CompanyDao extends CrudRepository<Company, Integer> {
    @Query
    List<Company> retrieveCompanyWhereNameStartsWith(@Param("COMPANYNAME") String companyName);
    @Query(nativeQuery = true)
    List<Company> retrieveCompanyWhereNameStartsWithNative(@Param("COMPANYNAME") String companyName);
    @Query
    List<Company> retrieveCompanyWhereNameContains(@Param("COMPANYNAME") String companyName);
}