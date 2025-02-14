package com.tong.onetomanyexercise.dao;

import com.tong.onetomanyexercise.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, String> {}
