package com.sujit.dao;

import com.sujit.dto.EmployeeDepartmentDto;
import com.sujit.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * JPARepository interface just to query an INNER JOIN with JPQL.
 *
 * In this repository, we are creating a inner join between the
 * employee and department tables to obtain employee names in each
 * department, ordered by employee name.
 */
public interface EmployeeJoinRepository extends JpaRepository<Employee, Long> {
    @Query("SELECT new com.sujit.dto.EmployeeDepartmentDto(d.name, e.name) FROM Department d INNER JOIN Employee e ON d.id = e.dept_id ORDER BY d.name")
    List<EmployeeDepartmentDto> fetchEmpDeptCrossJoin();
}
