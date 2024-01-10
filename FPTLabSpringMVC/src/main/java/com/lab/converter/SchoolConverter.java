package com.lab.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.lab.dto.SchoolDTO;
import com.lab.entity.SchoolEntity;



@Component
public class SchoolConverter {
	 ModelMapper modelMapper = new ModelMapper();
	 public SchoolDTO toDto(SchoolEntity entity) {
	    	if (entity != null) {
	    		SchoolDTO dto = modelMapper.map(entity, SchoolDTO.class);
	    	        return dto;
			}else {
				return null;
			}
	     
	    }
	    
	    public SchoolEntity toEntity(SchoolDTO toDto) {
	    	if (toDto != null) {
	    		SchoolEntity entity = modelMapper.map(toDto, SchoolEntity.class);
	        return entity;
	    	}else {
	    		return null;
	    	}
	    }
}
