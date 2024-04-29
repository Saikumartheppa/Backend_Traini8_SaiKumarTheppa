package com.saikumar.Backend_Traini8.Model;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Address {

    @NotBlank(message = "Detailed address is required , it Should not null or blank")
    private String detailedAddress;

    @NotBlank(message = "City is required , it Should not null or blank")
    private String city;

    @NotBlank(message = "State is required , it Should not null or blank")
    private String state;

    @NotBlank(message = "Pin-code is required , it Should not null or blank")
    @Pattern(regexp = "^[0-9]{6}$", message = "Pin code should contain exactly 6 digits")
    private String pincode;

}