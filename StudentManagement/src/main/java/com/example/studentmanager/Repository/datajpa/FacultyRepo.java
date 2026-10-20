package com.example.studentmanager.Repository.datajpa;

import com.example.studentmanager.Model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//finding by primary key automatically available for repository
@Repository
public interface FacultyRepo extends JpaRepository<Faculty,String> {

}
