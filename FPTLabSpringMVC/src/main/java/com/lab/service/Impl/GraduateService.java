package com.lab.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lab.converter.GraduateConveter;
import com.lab.dto.GraduateDTO;
import com.lab.repository.GraduateRepository;
import com.lab.service.IGraduateService;
@Service
public class GraduateService implements IGraduateService{

	@Autowired
	GraduateConveter graduateConveter;
	@Autowired
	GraduateRepository graduateRepository;
	
	
	@Override
	public GraduateDTO insert(GraduateDTO graduateDTO) {
		// TODO Auto-generated method stub
		return graduateConveter.toDto(graduateRepository.save(graduateConveter.toEntity(graduateDTO)));
	}

}
