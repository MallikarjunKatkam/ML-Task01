package com.bhavna.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.bhavna.entity.EmpPojo;

@Repository
public interface EmpRepository extends CrudRepository<EmpPojo, Integer>{

	@Query(value = "SELECT * FROM EMPS WHERE status = 'Active'", nativeQuery = true)
	Collection<EmpPojo> getAllActiveEmployees();

}