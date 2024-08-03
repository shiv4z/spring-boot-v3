package in.shiv.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.shiv.entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer>{

}
