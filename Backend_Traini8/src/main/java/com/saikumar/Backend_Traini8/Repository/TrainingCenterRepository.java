package com.saikumar.Backend_Traini8.Repository;

import com.saikumar.Backend_Traini8.Model.TrainingCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainingCenterRepository extends JpaRepository<TrainingCenter,Long> {

    List<TrainingCenter> findByCenterName(String centerName);
    @Query(value = "select * \n" +
            "from training_center\n" +
            "where state = :state" , nativeQuery = true)
    List<TrainingCenter> findByState(String state);
    @Query(value = "select * \n" +
            "from training_center\n" +
            "where state = :state and city = :city" , nativeQuery = true)
    List<TrainingCenter> findByStateAndCity(String state, String city);
    List<TrainingCenter> findByStudentCapacityBetweenOrderByStudentCapacity(Integer minimumCapacity, Integer maximumCapacity);
    @Query(value = "select * \n" +
            "from training_center\n" +
            "where state = :state \n" +
            " and city = :city \n" +
            "and student_capacity >= :minimumCapacity and student_capacity <= :maximumCapacity", nativeQuery = true)
    List<TrainingCenter> findByStateAndCityAndStudentCapacityOrderByCity(String state, String city, int minimumCapacity, int maximumCapacity);

    @Query(value = "select * \n" +
            "from training_center tc \n " +
           "left join \n" +
            "training_center_courses_offered tc_co \n" +
           " on tc.id = tc_co.training_center_id \n" +
            "where courses_offered = :courseName" , nativeQuery = true)
    List<TrainingCenter> findByCoursesOffered(String courseName);
    @Query(value = "select *  \n" +
            "from training_center tc \n" +
            "join training_center_courses_offered tc_co \n" +
            "on tc.id = tc_co.training_center_id \n" +
            "where tc.state = :state \n" +
            "and tc.city = :city \n" +
            "and student_capacity between :minimumCapacity and :maximumCapacity \n" +
            "and tc_co.courses_offered = :courseName" , nativeQuery = true)
    List<TrainingCenter> fetchAllTrainingCentersByStateAndCityAndStudentCapacityAndCoursesOffered(String state,
                                                                                                  String city, Integer minimumCapacity,
                                                                                                  Integer maximumCapacity, String courseName);

}
