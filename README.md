# Skeleton Coders - Sparta Trainee Simulator

**Developed by Igran, Hamzah, Michalis, James, Abdulhadi, Chung, Calum, Riya, Francisico and Ioannis**

### **Table Of Contents**
* [**About Project**](#about-project)
  * [Built with](#built-with)
  * [Dependencies](#dependencies)
* [**Requirements**](#requirements)
* [**Getting Started and Program Overview**](#getting-started-and-program-overview)
  * [Installation](#installation)
  * [Program Structure](#program-structure)
* [**Results and Analysis**](#results-and-analysis)
  * [Results](#results)
  * [Analysis](#analysis)
* [**Testing**](#testing)
  * [JUnit Testing](#junit-testing)
  * [Manual Testing](#manual-testing)
* [**Future Development**](#future-development)


## About Project

This project is developed as a team of 10, following agile methodologies, good programming practices in OOP, SOLID, design patterns, testing, and logging

The project's functionality being able to run a simulation of trainees and training centres in the requested format to simulate Sparta Globals growth as a company.

### <span style="color: blue;">**Built With**</span>

* IntelliJ IDEA (Community Edition)

### <span style="color: blue;">**Dependencies**</span>

* junit-jupiter:5.9.0
* Maven Apache 4.0

***
## Requirements

### Stage 1
* The program starts by asking how long the simulation will run for
* Every month, a random number of trainees are generated wanting to be trained (50 - 100)
* Every 2 months, Sparta global opens a training centre. They open instantly and can take trainees every month
* A centre can train a max of 100 trainees and takes a random number of trainees every month. (0 - 50 trainees up to their capacity)
* If a centre is full, trainees can be moved to any other centre which is not full
* If all centres are full, the trainees go onto a waiting list. This list must be served first before new trainees are taken
* At the end of the simulation, output should show:
  * number of open centre
  * number of full centres
  * number of trainees currently training
  * number of trainees on the waiting list

### Stage 2
* Sparta will now check centres each month. If a centre has less than 25 trainees, it will close.  The trainees will be randomly moved to another
  suitable centre
* The simulation should now offer the choice of data at the end of the simulation or a running output updated each month
* Trainees will now have a course type (Java, C#, Data, DevOps or Business). A trainee will be randomly assigned a course when they are created. This
  will never change
* Sparta now has 3 different types of centre. When a new centre can be opened, one of the following will be randomly chosen
  * Training Hub: can train a maximum of 100 trainees but 3 can be opened each month
  * Bootcamp: can train a maximum of 500 trainees but can remain open for 3 months if there are less than 25 trainees in attendance. If a Bootcamp
    has 3 consecutive months of low attendance, it will close. For the lifetime of the simulation, only 2 Bootcamps can ever exist
  * Tech Centre: Can train 200 trainees but only teaches one course per centre. This is chosen randomly when a Tech Centre is open
* The simulation should report on the following:
  * number of open centres (breakdown for each type)
  * number of closed centres (breakdown for each type)
  * number of full centres (breakdown for each type)
  * number of trainees currently training (breakdown for each type)
  * number of trainees on the waiting list (breakdown for each type)

### Stage 3
* If a trainee has been in training for a year, they are moved to a bench state
* Clients will begin to be randomly created after 1 year of the simulation
* A client will have a requirement when they are created e.g a need for 27 Java trainees. The requirement can be any value greater than or equal to
  15
* A client will take a random number of trainees from the bench each month (1 - full requirement) until their requirement is met
* A client will only take one type of trainee (Java, C#, Data, DevOps or Business)
* If a client does not collect enough trainees from the bench within a year, they will leave unhappy
* If a client does collect enough trainees from the bench within a year, they will leave happy and return the next year with the same requirement

***

## Getting Started and Program Overview

Run the project using IntelliJ Community Edition.
Make sure to install the dependencies and software included.


### <span style="color: blue;">**Installation**</span>

Clone the repository below.
> git clone https://github.com/JamesKempadoo/Skeleton_Coders_Sparta_Trainee_Simulator

### <span style="color: blue;">**Program Structure**</span>

**App** - Starts the application

**SimulationLoader** - Handling the user input, reading files and starting the whole project

<span style="color: red;">__**Model**__</span>

→ **Trainee** - Class that is responsible for housing constructing the trainee

→ **Training Centres** - The training_centre package contains three classes and an abstract class
* **TrainingCentre** - An abstract class implemented by different types of training centres
* **Bootcamp**
* **TrainingHub**
* **TechCentre**

→ **Client** - This class is responsible for constructing client and hold a array of trainee taking

→ **SimulationSystem** - Handle the running of the whole simulation

<span style="color: red;">__**View**__</span>

**DisplayManager** - Responsible for printing the query and messages

<span style="color: red;">__**Controller**__</span>

→ **Trainee** - The trainee package contains two classes for creating and managing the trainees
* **TraineeAllocationManager** Allocating trainees to training centres
* **TraineeGenerator** - Generating the Trainees each month

→ **Training Centres** - The training_centre package contains two classes responsible for managing the Training Centres
* **TrainingCentreGenerator** - Responsible for generating the training centres every two months
* **TrainingCentreManager** - Handling closing and populating training centres

→ **Client** - The client package contains two classes for creating and managing the client
* **ClientManager** - Controlling if the client is leaving or staying and populating the client with trainees
* **ClientGenerator** - Generating the Client after a year


<span style="color: red;">**Utilities**</span>

→ **Trainee / TrainingCentre Helper** - Containing the type data
→ **Log** - Containing a package for the logging singleton we have used for our code throughout


***
##  Results and Analysis

### <span style="color: blue;">**Results**</span>

--- TBD ---

### <span style="color: blue;">**Analysis**</span>

--- TBD ---

***

## Testing

### <span style="color: blue;">**JUnit Testing**</span>

--- TBD ---

### <span style="color: blue;">**Manual Testing**</span>

--- TBD ---

***


## Future Development

--- TBD ---