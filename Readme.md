<h1 align = "center"> Training Center Management API</h1>

<p align="center">
<a href="Java url">
    <img alt="Java" src="https://img.shields.io/badge/Java->=8-darkblue.svg" />
</a>
<a href="Maven url" >
    <img alt="Maven" src="https://img.shields.io/badge/maven-3.0.5-brightgreen.svg" />
</a>
<a href="Spring Boot url" >
    <img alt="Spring Boot" src="https://img.shields.io/badge/Spring Boot-3.0.6-brightgreen.svg" />
</a>
</p>
This project implements a RESTful API for managing training centers. It allows users to create and view training centers

---
<br>

>## Dependencies
The following dependencies are required to run the project:

* Spring Web
* Spring Data JPA
* MySQL Driver
* Lombok
* Validation
* Swagger
---
<br>

>## Features

* **Validation** : Ensures data integrity by applying validation rules to attributes like name, description, and course offerings.
* **Error Handling** : Provides informative error messages to the user in case of validation failures or other exceptions.
* **Data-Filtering** : Retrieves the training center's based on the filter's provided.
* **Embedded Address Object** : Represents the training center's address using an embedded object for better data organization.
---
<br> 

>## Project Goals

* This project aims to demonstrate the creation of a well-structured and validated API using Spring technologies.
* It showcases validation techniques for request objects and exception handling mechanisms to provide informative responses.
* The embedded address object structure promotes data organization and avoids data redundancy.
---
<br>

>## API Endpoints

The project provides the following API endpoints:

* **TrainingCenterController**
```
      POST/training-centers/training-center                              :-  Register new Training Center.
      GET/training-centers                                               :-  Fetching all training-centers saved Till now.
      GET/trainingCenterName/{trainingCenterName}                        :-  Fetching all training-centers by the provided Name.
      GET/state                                                          :-  Fetching all training-centers by the given  state.
      GET/state/city                                                     :-  Retrieving all training-centers by the given state and city.
      GET/studentCapacity/studentCapacityRange                           :-  Retrieving all training-centers by the provide student capacity range.
      GET/state/city/studentCapacity/studentCapacityRange                :-  Retrieving all training-centers by the given state and city and student capacity range.
      GET/coursesOffered                                                 :-  Fetching all the training-centers by keyword of  courses offered.
      GET/state/city/studentCapacity/studentCapacityRange/coursesOffered :-  Retrieving all training-centers by the given state and city and student capacity range and courses offered.
      
```

---

<br>

>## Author

👤 **Saikumar theppa**

* GitHub: [Saikumar theppa](https://gist.github.com/Saikumartheppa)

---
<br>

>## Installation and Usage

* Clone this repository to your local machine(https://github.com/Saikumartheppa/Backend_Traini8_SaiKumarTheppa.git)
* Make sure you have Java, Maven, and MySQL installed.
* Set up the database configuration in the application.properties file.
* Run the application using Maven or your preferred IDE.
* Access the API endpoints using Swagger UI by navigating to the appropriate URL (e.g., `http://localhost:8080/swagger-ui.html`).
---
<br>

>## 🤝 Contributing

Contributions, issues and feature requests are welcome!<br />Feel free to check [issues page]("url").
    
---
<br>

>## Show your support

Give a ⭐️ if this project helped you!
    
---