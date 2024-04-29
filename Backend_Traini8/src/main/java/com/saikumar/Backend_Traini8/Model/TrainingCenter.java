package com.saikumar.Backend_Traini8.Model;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TrainingCenter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)      // Auto creation of id
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)    // hides the attribute while created & visible when fetches data
    private Long id;

    @NotBlank(message = "Center name is required , provide a valid center name")
    @Size(max = 40, message = "Center name should not exceed 40 characters")
    private String centerName;

    @NotBlank(message = "Center code is required , provide a valid center code")
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[0-9])[a-zA-Z0-9]{12}$", message = "Center code must be exactly 12 alphanumeric characters")
    @Column(unique = true)
    private String centerCode;

    @Embedded                // take the fields from the Address class and embed them directly into the User table
    @Valid                      // make sure that validations work which are provided on address attributes
    private Address address;

    @Min(value = 30, message = "Student capacity must be greater than or equal to 30")
    private int studentCapacity;

    @ElementCollection(fetch = FetchType.EAGER)       // Creates a another table store collections & Optional: Pre-fetch courses on entity load
    @Column(name = "courses_offered")                 // Optional: Specify column name
    @NotEmpty(message = "Courses offered list cannot be empty")
    private List<@Pattern(regexp = "^\\b[A-Z]+\\b$" , message = "coursesOffered should not be blank " +
            "& it only contain upper case alphabets") String> coursesOffered;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Column(updatable = false) // Prevent user input for Created On
    private LocalDateTime createdOn = LocalDateTime.now();

    @Pattern(regexp = "^[a-z]+[0-9]{1,4}@gmail\\.com$" , message = "Email should be contain only lower case alphabets followed by 1 - 4  Numeric characters and have to end with @gmail.com")
    private String contactEmail;

    @Pattern(regexp = "^[6-9]\\d{9}$", message = "phone number should contain exactly 10 digits & first digit should start with any one of these digits(6,7,8,9)")
    private String contactPhone;

}
