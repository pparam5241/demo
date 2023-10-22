package com.param.lecture.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.param.lecture.entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	Employee findById(int id);

	@Transactional
	@Modifying
	@Query(value = "update EMPLOYEE_DETAILS set emp_name = :name where emp_id = :id", nativeQuery = true)
	void updateEmployeeName(String name, int id);

	@Query(value = "from Employee where isDeleted = 0", countQuery = "select count(*) from Employee where isDeleted = 0")
	Page<Employee> findAllEmployee(Pageable pageable);
}