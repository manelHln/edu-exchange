package org.project.backapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @AllArgsConstructor
@Setter @NoArgsConstructor
public class TeacherDto extends StudentDto {
    private String speciality;
}
