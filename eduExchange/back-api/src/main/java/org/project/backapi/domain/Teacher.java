package org.project.backapi.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Entity(name = "teacher")
@PrimaryKeyJoinColumn(name = "user_id")
public class Teacher extends User {
    private String speciality;
}
