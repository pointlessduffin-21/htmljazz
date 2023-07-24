package com.abcjobs.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abcjobs.model.Experiences;
import com.abcjobs.repository.ExperiencesRepository;

@Service
@Transactional
public class ExperiencesService {
	@Autowired
	ExperiencesRepository repo;
	
	public List<Experiences> getExperiencesByUserDetailsId(String id) {
		return repo.getExperiencesByUserDetailsId(id);
	}
	
	public Experiences addExperiences(Experiences ex) {
		return repo.save(ex);
	}
	
	public Experiences updateExperiences(String udID, Experiences ex) {
//		Long exId = ;
//		Experiences experiences = repo.findById(exId).get();
//		
//		// update
//		experiences.setUserDetailsId(udID);
//		experiences.setCompanyName(ex.getCompanyName());
//		experiences.setPosition(ex.getPosition());
//		experiences.setStartDate(ex.getStartDate());
//		experiences.setEndDate(ex.getEndDate());
//		
//		// save
//		return repo.save(experiences);
		return null;
	}
}
