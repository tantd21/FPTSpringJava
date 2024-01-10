package com.lab.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.lab.dto.StudentDTO;
import com.lab.entity.StudentEntity;
@Component
public class StudentConverter {
	 ModelMapper modelMapper = new ModelMapper();
	 public StudentDTO toDto(StudentEntity entity) {
	    	if (entity != null) {
	    		StudentDTO dto = modelMapper.map(entity, StudentDTO.class);
	    	        return dto;
			}else {
				return null;
			}
	     
	    }
	    
	    public StudentEntity toEntity(StudentDTO toDto) {
	    	if (toDto != null) {
	    		StudentEntity entity = modelMapper.map(toDto, StudentEntity.class);
	        return entity;
	    	}else {
	    		return null;
	    	}
	    }
}
