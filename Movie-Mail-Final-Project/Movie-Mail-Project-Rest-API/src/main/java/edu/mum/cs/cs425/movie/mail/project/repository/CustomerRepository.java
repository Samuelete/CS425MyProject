package edu.mum.cs.cs425.movie.mail.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import edu.mum.cs.cs425.movie.mail.project.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
