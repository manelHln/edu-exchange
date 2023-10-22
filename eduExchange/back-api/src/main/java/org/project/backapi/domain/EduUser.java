package org.project.backapi.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
@Entity(name = "edu")
@PrimaryKeyJoinColumn(name = "user_id")
public class EduUser extends User{
    //relations
    @OneToMany(mappedBy = "edu")
    private Set<Vote> votes;
}