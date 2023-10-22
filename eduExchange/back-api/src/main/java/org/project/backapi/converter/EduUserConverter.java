package org.project.backapi.converter;

import org.modelmapper.ModelMapper;
import org.project.backapi.domain.EduUser;
import org.project.backapi.dto.EduUserDto;

import java.util.ArrayList;
import java.util.List;

public class EduUserConverter {
    public EduUserDto convert(EduUser eduUser) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(eduUser, EduUserDto.class);
    }

    public List<EduUserDto> convert(List<EduUser> eduUsers) {
        ModelMapper modelMapper = new ModelMapper();
        List<EduUserDto> converted = new ArrayList<>();
        for(EduUser eduUser: eduUsers) {
            converted.add(convert(eduUser));
        }
        return converted;
    }
}
