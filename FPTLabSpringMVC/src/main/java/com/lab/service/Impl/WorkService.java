package com.lab.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lab.converter.WorkConverter;
import com.lab.dto.WorkDTO;
import com.lab.repository.WorkRepository;
import com.lab.service.IWorkService;
@Service
public class WorkService implements IWorkService{

	@Autowired
	WorkConverter workConverter;
	@Autowired
	WorkRepository workRepository;
	
	@Override
	public WorkDTO insert(WorkDTO workDTO) {
		// TODO Auto-generated method stub
		return workConverter.toDto(workRepository.save(workConverter.toEntity(workDTO)));
	}

}
