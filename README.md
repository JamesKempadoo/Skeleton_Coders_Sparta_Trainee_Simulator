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

***

## Getting Started and Program Overview

Run the project using IntelliJ Community Edition.
Make sure to install the dependencies and software included.


### <span style="color: blue;">**Installation**</span>

Clone the repository below.
> git clone https://github.com/JamesKempadoo/Skeleton_Coders_Sparta_Trainee_Simulator

### <span style="color: blue;">**Program Structure**</span>

**App** - starts the application

**SimulationLoader** - starter class for the whole project

<span style="color: red;">**Model**</span>

**Trainee** - Class that is responsible for housing the trainee constructor and the getterTraineeID

**TrainingCentre** - This class is responsible for constructing training centres, and attaching trainees to the centre

<span style="color: red;">**View**</span>

**DisplayManager** - Responsible for Printing the initial query and the results of the simulation

<span style="color: red;">**Controller**</span>

→ **Trainee** - The trainee package contains two classes for creating and managing the trainees
   * **TraineeAllocationManager** ---- to be filled -----
   * **TraineeGenerator** - Generating the Trainees each month 

→ **Training Centres** - The training_centre package contains two classes responsible for managing the Training Centres
   * **TrainingCentreGenerator** - Responsible for generating the training centres every two months
   * **TrainingCentreManager** --- Along with TraineeAllocationManager awaiting further decision ---

<span style="color: red;">**Utilities**</span>

→ **Log** - Contains a package for the logging singleton we have used for our code throughout


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