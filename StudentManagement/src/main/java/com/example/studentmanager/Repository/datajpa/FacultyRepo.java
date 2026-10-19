package com.example.studentmanager.Repository.datajpa;

import com.example.studentmanager.Model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyRepo extends JpaRepository<Faculty,String> {

}
