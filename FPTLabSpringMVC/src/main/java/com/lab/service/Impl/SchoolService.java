package com.lab.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.lab.converter.SchoolConverter;
import com.lab.dto.SchoolDTO;
import com.lab.entity.SchoolEntity;
import com.lab.repository.SchoolRepository;
import com.lab.service.ISchoolService;

@Service
public class SchoolService implements ISchoolService {

	@Autowired
	SchoolRepository schoolRepository;
	@Autowired
	SchoolConverter schoolConverter;
	
	@Override
	public SchoolDTO insert(SchoolDTO schoolDTO) {
		// TODO Auto-generated method stub
		return schoolConverter.toDto(schoolRepository.save(schoolConverter.toEntity(schoolDTO)));
	}

	@Override
	public List<SchoolDTO> findAll(Pageable pageable) {
		List<SchoolDTO> schoolDTOs = new ArrayList<>();
		List<SchoolEntity> schoolEntities = schoolRepository.findAll(pageable).getContent();
		for (SchoolEntity schoolEntity : schoolEntities) {
			schoolDTOs.add(schoolConverter.toDto(schoolEntity));
		}
		return schoolDTOs;
	}

	@Override
	public Integer getTotalItem() {
		// TODO Auto-generated method stub
		return (int) schoolRepository.count();
	}

	@Override
	public SchoolDTO findByID(Integer schoolId) {
		// TODO Auto-generated method stub
		return schoolConverter.toDto(schoolRepository.findOne(schoolId));
	}

}
