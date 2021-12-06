package com.daolayer.entity.persons;

import lombok.*;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Data
@Entity
public class Persons {
    @EmbeddedId
    private Person person;
    private String phoneNumber;
    private String cityOfLiving;
}
