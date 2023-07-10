package com.exam.skillassess.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.skillassess.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
