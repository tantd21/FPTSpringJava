package com.lab.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.lab.dto.BranchDTO;
import com.lab.entity.BranchEntity;

@Component
public class BranchConverter {
	 ModelMapper modelMapper = new ModelMapper();
	 public BranchDTO toDto(BranchEntity entity) {
	    	if (entity != null) {
	    		BranchDTO dto = modelMapper.map(entity, BranchDTO.class);
	    	        return dto;
			}else {
				return null;
			}
	     
	    }
	    
	    public BranchEntity toEntity(BranchDTO toDto) {
	    	if (toDto != null) {
	    		BranchEntity entity = modelMapper.map(toDto, BranchEntity.class);
	        return entity;
	    	}else {
	    		return null;
	    	}
	    }
}
