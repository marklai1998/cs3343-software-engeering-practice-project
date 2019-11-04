# CS3343 Software Engineering Practice Project
## Introduction
This repository is created for `City University HK` course `CS3343 - Software Engineering Practice` group project <br />
All credit goes to: Mark Lai

## Assignment Requirement
Create a simple Java program (Inventory Management System in this case) to implement code testing strategy using Junit and project management skills

## Getting Started
Run it directly from IDE:
1. Clone the repository

2. Open the project with Intellij

3. Run it

Note. there is no eclipse configuration yet

Compile it with command line:
1. Clone the repository

2. Change directory to the project src
```
$ cd ./src
```

3. Compile the java file
```
$ javac com/inventoryManagementSystem/Main.java -d "../compiled"
```
Note. you may add permeter `--release 8` if you are using older java run time

4. Copy the sample data set
```
$ cp ./com/inventoryManagementSystem/Data ../compiled/com/inventoryManagementSystem/
```

4. Netvigate to built folder
```
$ cd ../compiled
```

3. Start the project
```
$ java com.inventoryManagementSystem.Main
```
