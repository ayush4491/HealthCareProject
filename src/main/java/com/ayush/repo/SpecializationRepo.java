package com.ayush.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ayush.entity.Specialization;

public interface SpecializationRepo extends JpaRepository<Specialization, Long> {

}
