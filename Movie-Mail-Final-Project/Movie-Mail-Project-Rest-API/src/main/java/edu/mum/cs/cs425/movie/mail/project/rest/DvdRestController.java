package edu.mum.cs.cs425.movie.mail.project.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import edu.mum.cs.cs425.movie.mail.project.model.DVD;
import edu.mum.cs.cs425.movie.mail.project.service.DvdService;

@RestController
@CrossOrigin(origins = {"http://127.0.0.1:5501","http://localhost:8080"}, allowedHeaders = "*")
@RequestMapping(value = "/api/dvd", produces = MediaType.APPLICATION_JSON_VALUE)
public class DvdRestController {

	@Autowired
	private DvdService dvdService;
	
	@GetMapping(value = "/list")
	public List<DVD> dvdCatalog() {
		return dvdService.getAllDvds();
	}
	
	@GetMapping(value = "/search/{name}" )
	public List<DVD> searchDvds(@PathVariable String name) {
		return dvdService.searchDvds(name);
	}
	
	@GetMapping(value = "/mostPopular")
	public List<DVD> getDvdsMostPopulars() {
		return dvdService.getDvdsMostPopular();
	}
	@GetMapping(value = "/leastPopular")
	public List<DVD> getDvdsLeastPopulars() {
		return dvdService.getDvdsLeastPopular();
	}
	
	@GetMapping(value = "/mostRequested")
	public List<DVD> getDvdsMostRequested() {
		return dvdService.getDvdsMostRequested();
	}
}


