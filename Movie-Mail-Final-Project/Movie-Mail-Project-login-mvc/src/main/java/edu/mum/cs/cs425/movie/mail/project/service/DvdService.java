package edu.mum.cs.cs425.movie.mail.project.service;

import java.util.List;

import edu.mum.cs.cs425.movie.mail.project.model.DVD;


public interface DvdService {
	public abstract DVD saveDvd(DVD dvd);
	List<DVD> getAllDvds();
	DVD getDvdById(Long dvdId);
	public void deleteById(int dvdID);
	public abstract List<DVD> searchDvds(String searchDvds);
}
