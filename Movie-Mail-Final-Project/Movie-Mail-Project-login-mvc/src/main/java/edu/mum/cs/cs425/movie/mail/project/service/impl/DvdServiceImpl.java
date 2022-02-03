package edu.mum.cs.cs425.movie.mail.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs.cs425.movie.mail.project.model.DVD;
import edu.mum.cs.cs425.movie.mail.project.repository.DvdRepository;
import edu.mum.cs.cs425.movie.mail.project.service.DvdService;

@Service
public class DvdServiceImpl implements DvdService {

	@Autowired
	private DvdRepository dvdRepository;
	
	@Override
	public DVD saveDvd(DVD dvd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DVD> getAllDvds() {
		return dvdRepository.findAll();
	}

	@Override
	public DVD getDvdById(Long dvdId) {
		return dvdRepository.getById(dvdId);
	}

	@Override
	public void deleteById(int dvdID) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<DVD> searchDvds(String searchDvds) {
		return dvdRepository.findAllByTitle(searchDvds);
	}

}
