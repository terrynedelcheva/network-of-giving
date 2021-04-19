package com.vmware.talentboost.finaltask.networkofgiving.repository;

import com.vmware.talentboost.finaltask.networkofgiving.model.Charity;
import com.vmware.talentboost.finaltask.networkofgiving.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CharityRepository extends JpaRepository<Charity, Long> {
    //JpaRepository's methods: save(), findOne(), findById(), findAll(), count(), delete(), deleteById();
    /*@Query("SELECT c FROM Charity c WHERE c.title = :title")
    Charity findCharityByTitle(@Param("title") String title);*/
}
