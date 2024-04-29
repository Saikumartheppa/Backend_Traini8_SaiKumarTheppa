package com.saikumar.Backend_Traini8.Contoller;

import com.saikumar.Backend_Traini8.Model.TrainingCenter;
import com.saikumar.Backend_Traini8.Service.TrainingCenterService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/training-centers")
@Slf4j
public class TrainingCenterController {
    private final TrainingCenterService trainingCenterService;

//    Creating a New Training - Center
    @PostMapping("/training-center")
    public ResponseEntity<TrainingCenter> createTrainingCenter(@Valid @RequestBody TrainingCenter trainingCenter) throws Exception {

        log.info("Received Training Center Req: {}", trainingCenter);
        final TrainingCenter tc = trainingCenterService.createTrainingCenter(trainingCenter);
        log.info("Created Training Center: {}", trainingCenter);
        return ResponseEntity.ok(tc);
    }

//    Fetching all training-centers saved Till now
    @GetMapping("/training-centers")
    public ResponseEntity<List<TrainingCenter>> getAllTrainingCenters(){
        List<TrainingCenter> trainingCenterList = trainingCenterService.getAllTrainingCenters();
        return ResponseEntity.ok(trainingCenterList);
    }

//    Fetching all training-centers by the provided Name
    @GetMapping("/TrainingCenterName")
    public ResponseEntity<List<TrainingCenter>> fetchAllTrainingCentersByName(@RequestParam @NotBlank @Size(max = 40) String centerName){
        List<TrainingCenter> trainingCenters =  trainingCenterService.fetchAllTrainingCentersByName(centerName);
        return ResponseEntity.ok(trainingCenters);
    }


//    Fetching all training-centers by the given  state
    @GetMapping("/state")
    public ResponseEntity<List<TrainingCenter>> fetchAllTrainingCentersByState(@RequestParam @NotBlank String state){
        List<TrainingCenter> trainingCenterList =  trainingCenterService.getAllTrainingCentersByState(state);
        return ResponseEntity.ok(trainingCenterList);
    }

//    Retrieving all training-centers by the given state and city
    @GetMapping("/state/city")
    public ResponseEntity<List<TrainingCenter>> fetchAllTrainingCentersByStateAndCity(@RequestParam @NotBlank String state , @RequestParam @NotBlank String city){
        List<TrainingCenter> trainingCenterList =  trainingCenterService.getAllTrainingCentersByStateAndCity(state, city);
        return ResponseEntity.ok(trainingCenterList);
    }

    //    Retrieving all training-centers by the provide student capacity range
    @GetMapping("/studentCapacity/studentCapacityRange")
    public ResponseEntity<List<TrainingCenter>> fetchAllTrainingCentersByStudentCapacity(@RequestParam @Min(value = 30)Integer minimumCapacity, @RequestParam Integer maximumCapacity){
        List<TrainingCenter> trainingCenterList =  trainingCenterService.getAllTrainingCentersByStudentCapacity(minimumCapacity, maximumCapacity);
        return ResponseEntity.ok(trainingCenterList);
    }

    //   Retrieving all training-centers by the given state and city and student capacity range
    @GetMapping("/state/city/studentCapacity/studentCapacityRange")
    public ResponseEntity<List<TrainingCenter>> fetchAllTrainingCentersByStateAndCityAndStudentCapacity(@RequestParam @NotBlank String state , @RequestParam @NotBlank String city , @RequestParam @Min(value = 30)Integer minimumCapacity, @RequestParam Integer maximumCapacity){
        List<TrainingCenter> trainingCenterList =  trainingCenterService.getAllTrainingCentersByStateAndCityAndStudentCapacity(state, city , minimumCapacity, maximumCapacity);
        return ResponseEntity.ok(trainingCenterList);
    }

    // Fetching all the training-centers by keyword of  courses offered
    @GetMapping("/coursesOffered")
    public ResponseEntity<List<TrainingCenter>> fetchAllTrainingCentersByCoursesOffered(@RequestParam @Pattern(regexp = "^\\b[A-Z]+\\b$") String courseName){
        List<TrainingCenter> trainingCenterList =  trainingCenterService.fetchAllTrainingCentersByCoursesOffered(courseName);
        return ResponseEntity.ok(trainingCenterList);
    }


    //   Retrieving all training-centers by the given state and city and student capacity range and courses offered
    @GetMapping("/state/city/studentCapacity/studentCapacityRange/coursesOffered")
    public ResponseEntity<List<TrainingCenter>> fetchAllTrainingCentersByStateAndCityAndStudentCapacityAndCoursesOffered(@RequestParam @NotBlank String state , @RequestParam @NotBlank String city , @RequestParam @Min(value = 30)Integer minimumCapacity, @RequestParam Integer maximumCapacity, @RequestParam @Pattern(regexp = "^\\b[A-Z]+\\b$") String courseName){
        List<TrainingCenter> trainingCenterList =  trainingCenterService.fetchAllTrainingCentersByStateAndCityAndStudentCapacityAndCoursesOffered(state, city , minimumCapacity, maximumCapacity, courseName);
        return ResponseEntity.ok(trainingCenterList);
    }
}
