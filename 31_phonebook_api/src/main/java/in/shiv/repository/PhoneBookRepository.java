package in.shiv.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.shiv.entity.Phone;

public interface PhoneBookRepository extends JpaRepository<Phone, Integer>{

}
