package com.saikumar.Backend_Traini8.Service;

import com.saikumar.Backend_Traini8.Model.TrainingCenter;
import com.saikumar.Backend_Traini8.Repository.TrainingCenterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TrainingCenterService {
    private final TrainingCenterRepository trainingCenterRepository;
    public TrainingCenter createTrainingCenter(TrainingCenter trainingCenter) {
        TrainingCenter SavedTrainingCenter = trainingCenterRepository.save(trainingCenter);
        return SavedTrainingCenter;
    }

    public List<TrainingCenter> getAllTrainingCenters() {
        List<TrainingCenter> savedTrainingCenters = trainingCenterRepository.findAll();
        return savedTrainingCenters;
    }

    public List<TrainingCenter> fetchAllTrainingCentersByName(String centerName) {
        return trainingCenterRepository.findByCenterName(centerName);
    }

    public List<TrainingCenter> getAllTrainingCentersByState(String state) {
        return trainingCenterRepository.findByState(state);
    }

    public List<TrainingCenter> getAllTrainingCentersByStateAndCity(String state, String city) {
        return trainingCenterRepository.findByStateAndCity(state , city);
    }
    public List<TrainingCenter> getAllTrainingCentersByStudentCapacity(Integer minimumCapacity, Integer maximumCapacity) {
        return trainingCenterRepository.findByStudentCapacityBetweenOrderByStudentCapacity(minimumCapacity, maximumCapacity);
    }

    public List<TrainingCenter> getAllTrainingCentersByStateAndCityAndStudentCapacity(String state, String city, Integer minimumCapacity, Integer maximumCapacity) {
        return trainingCenterRepository.findByStateAndCityAndStudentCapacityOrderByCity(state , city , minimumCapacity, maximumCapacity);
    }

    public List<TrainingCenter> fetchAllTrainingCentersByCoursesOffered(String courseName) {
        return trainingCenterRepository.findByCoursesOffered(courseName);
    }

    public List<TrainingCenter> fetchAllTrainingCentersByStateAndCityAndStudentCapacityAndCoursesOffered(String state,
     String city, Integer minimumCapacity, Integer maximumCapacity, String courseName) {
        return trainingCenterRepository.fetchAllTrainingCentersByStateAndCityAndStudentCapacityAndCoursesOffered(state, city ,
        minimumCapacity , maximumCapacity , courseName);
    }

}
