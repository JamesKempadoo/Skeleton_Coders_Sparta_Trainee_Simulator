# Sparta Trainee Simulator

**Developed by <ins>Skeleton Coders</ins>: Igran, Hamzah, 
Michalis, 
James, 
Abdulhadi, 
Chung, 
Calum, Riya, Francisico and 
Ioannis.**

### **Table of Contents**
* [**About Project**](#about-project)
  * [Built with](#built-with)
  * [Dependencies](#dependencies)
* [**Requirements**](#requirements)
  * [Stage 1](#stage-1)
  * [Stage 2](#stage-2)
  * [Stage 3](#stage-3)
* [**Getting Started**](#getting-started)
* [**Program Structure**](#program-structure)
* [**Results**](#results)
* [**Testing**](#testing)
  * [JUnit Testing](#junit-testing)
  * [Manual Testing](#manual-testing)
* [**Future Development**](#future-development)


## About Project

This project is developed as a team of 10, following agile methodologies, good programming practices in OOP, SOLID, design patterns, testing, and logging

The project's functionality being able to run a simulation of trainees, training centres and clients in the requested 
format to simulate Sparta Globals growth as a company.

### <span style="color: blue;">**Built With**</span>

* IntelliJ IDEA (Community Edition)

### <span style="color: blue;">**Dependencies**</span>

* junit-jupiter:5.9.0
* Maven Apache 4.0

## Requirements
### <span style="color: blue;">Stage 1</span>
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

### <span style="color: blue;">Stage 2</span>
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

### <span style="color: blue;">Stage 3</span>
* If a trainee has been in training for a year, they are moved to a bench state
* Clients will begin to be randomly created after 1 year of the simulation
* A client will have a requirement when they are created e.g a need for 27 Java trainees. The requirement can be any value greater than or equal to
  15
* A client will take a random number of trainees from the bench each month (1 - full requirement) until their requirement is met
* A client will only take one type of trainee (Java, C#, Data, DevOps or Business)
* If a client does not collect enough trainees from the bench within a year, they will leave unhappy
* If a client does collect enough trainees from the bench within a year, they will leave happy and return the next year with the same requirement


## Getting Started

Run the project using IntelliJ Community Edition.
Make sure to install the dependencies and software included.

Clone the repository below.
> git clone https://github.com/JamesKempadoo/Skeleton_Coders_Sparta_Trainee_Simulator

## Program Structure

**App** - Main method to load the SimulationLoader

**SimulationLoader** - Handling the user input, reading files and starting the whole project

<span style="color: red;">**【 Model 】**</span>

→ **Trainee** - Class that is responsible for constructing the trainee

→ **Training Centres** - The training_centre package contains three classes and an abstract class
* **TrainingCentre** - An abstract class extended by different training centres types
* **Bootcamp**
* **TrainingHub**
* **TechCentre**

→ **Client** - Class for constructing client and holding a array of trainee taken

→ **Simulation** - package includes two classes
* **SimulationSystem** - Modeling the operations of the simulations
* **SimulationOutput** - Handling the format of the simulation output
* **JSONFileWriter** - Exporting the simulation results as JSON file

<span style="color: red;">**【 View 】**</span>

**DisplayManager** - Displaying the query and messages

<span style="color: red;">**【 Controller 】**</span>

→ **Trainee** - The trainee package contains two classes for creating and managing the trainees
* **TraineeAllocationManager** Allocating trainees to training centres
* **TraineeGenerator** - Generating the Trainees each month
* **TraineeManager** - Incrementing the month count of trainees in the training centres

→ **Training Centres** - The training_centre package contains two classes responsible for managing the Training Centres
* **TrainingCentreGenerator** - Responsible for generating the training centres every two months
* **TrainingCentreManager** - Handling closing and populating training centres

→ **Client** - The client package contains two classes for creating and managing the client
* **ClientManager** - Populating the clients with suitable trainees
* **ClientGenerator** - Returning a new client


<span style="color: red;">**【 Utilities 】**</span>

**Trainee / TrainingCentre Helper** - Containing the type data

**Log** -  A package for the logging singleton we have used for our code throughout

**NonGaussianRandomBias** - Generate a random number for client requirements mimicking the reality


##  Results

The program successfully produces the simulation results fulfilling the requirements. 
Additional 
features such as using data in a text file for the simulation and giving users option to rerun the program, etc are 
implemented as well. 

Moreover, the simulation results are output to a JSON file which can then be used in other programs or platforms.

### Example of JSON output
```json
{
  "year": 13,
  "month": null,
  "open_centres": {
    "total": 12,
    "tech_centre": 3,
    "training_hub": 4,
    "bootcamp": 5
  },
  "full_centres": {
    "total": 12,
    "tech_centre": 3,
    "training_hub": 4,
    "bootcamp": 5
  },
  "closed_centres": {
    "total": 12,
    "tech_centre": 3,
    "training_hub": 4,
    "bootcamp": 5
  },
  "trainees_training": {
    "total": 351,
    "java": 61,
    "c#": 59,
    "data": 104,
    "devops": 58,
    "business": 69
  },
  "trainees_waiting": {
    "total": 351,
    "java": 61,
    "c#": 59,
    "data": 104,
    "devops": 58,
    "business": 69
  },
  "graduates": {
    "total": 351,
    "java": 61,
    "c#": 59,
    "data": 104,
    "devops": 58,
    "business": 69
  },
  "graduates_placed": {
    "total": 351,
    "java": 61,
    "c#": 59,
    "data": 104,
    "devops": 58,
    "business": 69
  },
  "happy_clients": {
    "total": 12,
    "java": 3,
    "c#": 1,
    "data": 2,
    "devops": 0,
    "business": 6
  },
  "unhappy_clients": {
    "total": 1,
    "java": 0,
    "c#": 1,
    "data": 0,
    "devops": 0,
    "business": 0
  }
}
```

## Testing

### <span style="color: blue;">**JUnit Testing**</span>

The methods in the classes were tested with unit testing to make sure each component functions correctly.

### <span style="color: blue;">**Manual Testing**</span>

The parts of the program which were not suitable for unit testing were tested manually.