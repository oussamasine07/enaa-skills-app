package org.enaaskillsapp.authservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "coaches")
public class Coach extends User {

    private String specialty;
}
