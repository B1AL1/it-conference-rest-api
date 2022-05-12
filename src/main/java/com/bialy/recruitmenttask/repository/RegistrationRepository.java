package com.bialy.recruitmenttask.repository;

import com.bialy.recruitmenttask.model.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Long> {

    @Query("select r from Registration r where lecture_id = ?1")
    List<Registration> findAllByLecture_id(long lecture_id);

    @Query("select r from Registration r where user_id = ?1")
    List<Registration> findAllByUser_id(long id);

    @Query("select r from Registration r where user_id = ?1 and lecture_id = ?2")
    Registration findAllByUser_idAndLecture_id(long user_id, long lecture_id);
}
