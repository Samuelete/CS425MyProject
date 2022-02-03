package edu.mum.cs.cs425.movie.mail.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mum.cs.cs425.movie.mail.project.model.DVD;

@Repository
public interface DvdRepository extends JpaRepository<DVD, Long> {
	public List<DVD> findAllByTitle(String tittle);
}
