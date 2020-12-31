package com.nexttechnologies.nexttechnologiesserver.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.nexttechnologies.nexttechnologiesserver.models.AppUser;
import com.nexttechnologies.nexttechnologiesserver.models.AppUserDetail;

@Mapper(componentModel = "spring")
public interface AppMapper {

	@Mappings({
		@Mapping(source = "", target = "")
	})
	AppUserDetail appUserToAppUserDetail(AppUser source);
}
