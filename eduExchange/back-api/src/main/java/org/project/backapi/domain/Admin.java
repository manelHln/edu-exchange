package org.project.backapi.domain;

import jakarta.persistence.*;
@Entity(name = "admin")
@PrimaryKeyJoinColumn(name = "user_id")
public class Admin extends User {
}