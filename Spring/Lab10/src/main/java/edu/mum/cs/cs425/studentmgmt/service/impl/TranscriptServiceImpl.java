package edu.mum.cs.cs425.studentmgmt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.mum.cs.cs425.studentmgmt.model.Transcript;
import edu.mum.cs.cs425.studentmgmt.repository.TranscriptRepository;
import edu.mum.cs.cs425.studentmgmt.service.TranscriptService;

@Service
public class TranscriptServiceImpl implements TranscriptService {

	@Autowired
	TranscriptRepository transcriptRepository;
	
	public TranscriptServiceImpl(TranscriptRepository transcriptRepository) {
		super();
		this.transcriptRepository = transcriptRepository;
	}

	@Override
	public Transcript saveTranscript(Transcript transcript) {
		return transcriptRepository.save(transcript);
		
	}


	
}
