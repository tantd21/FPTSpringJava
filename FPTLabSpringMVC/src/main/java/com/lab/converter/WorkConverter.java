package com.lab.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.lab.dto.WorkDTO;
import com.lab.entity.WorkEntity;


@Component
public class WorkConverter {
	 ModelMapper modelMapper = new ModelMapper();
	 public WorkDTO toDto(WorkEntity entity) {
	    	if (entity != null) {
	    		WorkDTO dto = modelMapper.map(entity, WorkDTO.class);
	    	        return dto;
			}else {
				return null;
			}
	     
	    }
	    
	    public WorkEntity toEntity(WorkDTO toDto) {
	    	if (toDto != null) {
	    		WorkEntity entity = modelMapper.map(toDto, WorkEntity.class);
	        return entity;
	    	}else {
	    		return null;
	    	}
	    }
}
