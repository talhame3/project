package com.hexaware.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.spring.model.FileDB;

@Repository
public interface FileDBRepository extends JpaRepository<FileDB, String> {

}
