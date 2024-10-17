package com.agrobaires.agrobaires.repositories;

import com.agrobaires.agrobaires.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long>, JpaSpecificationExecutor<Person> {

    @Query("select p from Persona p where p.cuit = :cuit")
     Person findByCuit(@Param("cuit") String cuit);

    @Query("select p from Persona p where p.apellido = :apellido")
     List<Person> findByApellido(@Param("apellido") String surname);

    @Query("select p from Persona p where p.insertion_date between :startDate and :endDate")
     List<Person> findListByDates(@Param("startDate") Date stardDate, @Param("endDate") Date endDate);

    @Transactional
    @Modifying
    @Query("delete from Persona p where p.cuit = :cuit")
    int deletePersonByCuit(@Param("cuit") String cuit);
}
