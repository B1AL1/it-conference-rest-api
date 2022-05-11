package com.bialy.recruitmenttask.repository;

import com.bialy.recruitmenttask.model.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LectureRepository extends JpaRepository<Lecture, Long> {

    @Query("select l from Lecture l " +
            "inner join Registration r ON l.id = r.lecture_id " +
            "inner join User u on u.id = r.user_id where login = ?1")
    List<Lecture> findAllLecturesByUserLogin(String login);

}
