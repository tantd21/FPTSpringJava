package com.lab.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.lab.dto.GraduateDTO;
import com.lab.entity.GraduateEntity;


@Component
public class GraduateConveter {
	 ModelMapper modelMapper = new ModelMapper();
	 public GraduateDTO toDto(GraduateEntity entity) {
	    	if (entity != null) {
	    		GraduateDTO dto = modelMapper.map(entity, GraduateDTO.class);
	    	        return dto;
			}else {
				return null;
			}
	     
	    }
	    
	    public GraduateEntity toEntity(GraduateDTO toDto) {
	    	if (toDto != null) {
	    		GraduateEntity entity = modelMapper.map(toDto, GraduateEntity.class);
	        return entity;
	    	}else {
	    		return null;
	    	}
	    }
}
