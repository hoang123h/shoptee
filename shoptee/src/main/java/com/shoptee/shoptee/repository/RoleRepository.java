package com.shoptee.shoptee.repository;

import com.shoptee.shoptee.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    @Query("SELECT r from Role r WHERE r.name = ?1")
    public Role findByName(String name);
}
