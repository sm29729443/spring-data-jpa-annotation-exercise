package com.tong.onetomanyexercise.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "person")
@Data
public class PersonEntity {
    @Id
    String id;

    String name;
}
