# Introduction
This section describes the problem your team is trying to solve by writing this program, the primary design goals of the project (i.e., where is 
it most flexible), and the primary architecture of the design (i.e., what is closed and what is open). Discuss the program at a high-level 
(i.e., without referencing specific classes, data structures, or code).

In this project, we are trying to create the simple computer programming language SLOGO, which takes in user input, interprets commands, and 
performs some action that appears on the screen. We hope to make several areas in our program flexible. Some of these areas include being able
to make our program flexible enough in the back end to take in and interpret additional commands. In addition, we want to minimize the amount 
of dependencies our working parts have between each other in order to avoid issues with adding new features. In discussing the program at a high
level, we plan to divide it into three simple modules: Model, View, and Controller. In this program, we hope to have the View display information 
to the user and be able to take in user interactions. These interactions are meant to go to the Controller, which can interpret the interaction. 
The Controller can then either tell the View to change its display or delegate the Model to perform some action if backend specific information 
is necessary to perform the interaction. The Controller can then change its state and/or tell the View to change its information. We feel that 
splitting the design of the program simplifies the program into three separate, smaller problems and can help our program to achieve better 
flexibility as a whole.

# Design Overview
This section serves as a map of your design for other programmers to gain a general understanding of how and why the program was divided up, and 
how the individual parts work together to provide the desired functionality. Describe the four APIs you intend to create (their purpose with 
regards to the program's functionality, and how they collaborate with each other) focusing specifically on the behavior, not the internal state. 
Include a picture of how the components are related (these pictures can be hand drawn and scanned in, created with a standard drawing program, 
or screen shots from a UML design program). Discuss specific classes, methods, and data structures, but not individual lines of code.

## Interal Front-end
* (how the front end works within itself)

## External Front-end
* (how the front end communicates w back-end)

## Internal Back-end
* (how the back end works among itself) -Charlie

## External Back-end
The back end will provide data to the front end through the Parser class. This class will serve as the main intermediary between the front and 
back ends. The front end will call the getReturn() method in the Parser class which will provide the coordinates and/or lines needed to move 
the turtle. This data will be passed in the form of a list where the last item in the list is the most recent move. The Turtle class will also
be available to the front end, as it will allow the view to get the current coordinates and other values relevant to moving the turtle.

Here is a picture of how our compenents are related:

![Components Overview] (file pale)

# User Interface
This section describes how the user will interact with your program (keep it simple to start). Describe the overall appearance of program's user 
interface components and how users interact with these components (especially those specific to your program, i.e., means of input other than 
menus or toolbars). Include one or more pictures of the user interface (these pictures can be hand drawn and scanned in, created with a standard 
drawing program, or screen shots from a dummy program that serves as a exemplar). Describe any erroneous situations that are reported to the 
user (i.e., bad input data, empty data, etc.).


For our user interface, we plan to have four main components: the turtle graphics window, the command box, the console, and the variable display 
window. The turtle graphics window is responsible for displaying all graphics relevant to the SLogo turtle. The command box will be a combination
of a text box and run button. The user will be able to type in commands in the text box, and tell the program to execute these commands by 
pressing the run button. We may also incorporate additional buttons to allow for greater user control, such as a clear button which would clear 
the text box, or a previous button which would fill the text box with the previously executed command. The third component we plan on including 
is the console. The console’s responsibility is to provide a history of previous commands executed and inform the user if an invalid command has 
been inputted. In addition, the console will be accompanied with a clear button which will erase the history of commands from the display. The 
final component is the variable display window, which will be used to show the user all currently stored variables within the program. Similar 
to both the command box and the console, the variable box will have a clear button which clears all variable values. 

When an invalid command is submitted to the command box, the user will receive a notification within the console that there was an issue with 
the command. For example, if a user mistypes a command (ex. “RY 50”) the console will display the message “Not a valid command”. If a user 
fails to correctly assign a value to a variable (ex.  MAKE :X) or attempts to retrieve an unallocated variable (ex. SUM :Y 3), the console will 
display the message “No variable value provided” or “Variable :Y does not exist”. We plan on having a specific error message for each error.

Below is an example design of our planned user interface:

![Turtle UI Example] (./doc/slogo_mockup.PNG)


# API Details 
This section describes each API introduced in the Overview in detail. Describe how each API supports specific features given in the assignment 
specification, what resources it might use, how it is intended to be used, and how it could be extended to include additional requirements (from 
the assignment specification or discussed by your team). Finally, justify the decision to create each class introduced with respect to the 
design's key goals, principles, and abstractions. Your APIs should be written as Java interfaces, types that cannot contain instance variables 
or private methods, in appropriate packages. These should be Java code files that compile and contain extensive comments to explain the purpose 
of each interface and each method within the interface (note this code can be generated directly from a UML diagram). Include any Exceptions 
you plan to throw because of errors that might occur within your methods. Note, this does not require that all of these types will remain as 
interfaces in the final implementation, just that the goal is for you to focus on each type's behavior and purpose.

## Front-end Internal API's - Andy
* VariableBox
    * addVariable(variableString) [Internal API, Visualizer -> VariableBox]
    * addUserCommand(variableString) [Internal API, Visualizer -> VariableBox]
* CommandBox
    * clear() [Internal API, Visualizer -> CommandBox]
* ConsoleBox
    * addCommand(commandString) [Internal API, Visualizer -> ConsoleBox]
* Drawer
    * Public setBackgroundColor(color) [Internal API, Visualizer -> Drawer]
    * Public setPenColor(color) [Internal API, Visualizer -> Drawer]
    * Public setImage(img) [Internal API, Visualizer -> Drawer]
    * Public penUp() [Internal API, Visualizer -> Drawer]
    * Public penDown() [Internal API, Visualizer -> Drawer]
    * Public draw()  [Internal API, Visualizer -> Drawer]
    * Public moveToPoint(x,y) [Internal API, Visualizer -> Drawer]

## Front-end External API's - Eddie

* Visualizer
    * Public draw(attributes) [External API, Model -> View]
    * Public toOrigin() [External API, Model -> View]
    * Public penUp()  [External API, Model -> View]
    * Public penDown()  [External API, Model -> View]
    * Public displayError(msg) [External API, Model -> View]
    * Public setBackgroundColor(color) [External API, Model -> View]
    * Public setPenColor(color) [External API, Model -> View]
    * Public setImage(img) [External API, Model -> View]
    * Public displayCommandHistory() [External API, Model -> View]	//maybe private
    * Public displayVariables [External API, Model -> View]	//maybe private
    * Public displayUserCommands [External API, Model -> View]	//maybe private
    * Public showCommandHelp [External API, Controller -> View]
    * Public clearCommandBox [External API, Controller -> View]	//extra
* VariableBox
    
* CommandBox
* ConsoleBox
* Drawer



Controller
ViewController
Public showCommandHelp [External API, View -> Controller]
Public clearCommandBox [External API, View -> Controller]

ModelController
Methods:
Public passCommand() [External API, View -> Controller]
Public clearConsoleBox()  [External API, View -> Controller]
Public clearVariableBox()  [External API, View -> Controller]


## Back-end Internal API's - Charlie

### Nodes
* Assign
* Return
* Compare
* BinOp
* Command

### Data types
* Variable
* Constant
* List
* Comment
* Command

## Back-end External API's - Belanie

### Parser

### Turtle

# API Example Code
It is especially important in helping others understand how to use your APIs to provide example code. It should be clear from this code which 
objects are responsible for completing each part of the task, but you do not have to implement the called functions.

* Show an actual "sequence of code" that implements the following use case using only methods described in your APIs:  
    * The user types 'fd 50' in the command window, and sees the turtle move in the display window leaving a trail, and the command is added to 
    the environment's history.
    * Note, clearly show the flow of calls to public methods needed to complete this example, indicating which class contains each method called. 
    * It is not necessary to understand exactly how parsing works in order to complete this example, just what the result of parsing the command
    will be.

* Additionally, each member of the team should create two use cases of their own (and example code) for the part of the project for which they 
intend to take responsibility. These can still be done as a group, but should represent a variety of areas of the overall project.

# Design Considerations 
This section describes any issues which need to be addressed or resolved before attempting to devise a complete design solution. Include any 
design decisions that the group discussed at length (include pros and cons from all sides of the discussion) as well as any ambiguities, 
assumptions, or dependencies regarding the program that impact the overall design.

## Potential issues
* (add potential issues)

## Design decisions
* (add decisions the group discussed at length)

## Ambiguities, assumptions and dependencies
* (talk about ambiguities, assumptions and dependencies)

# Team Responsibilities
This section describes the program components each team member plans to take primary and secondary responsibility for and a high-level plan of 
how the team will complete the program.

### Edward
* His primary responsibility is also within the View component of this program. He will work on the CommandBox, ConsoleBox, and VariableBox 
  classes (designed to be contained within the Visualizer). He will also work on the Controller.

### Andy 
* His primary responsibility is within the View component of this program. He will work on the Visualizer class in particular. In addition, he 
  will contribute to some aspects of the Controller.

### Belanie
* (Belanie's responsibilites)

### Charlie 
* (Charlie's responsibilites)

### High-Level Plan
* (plan of how the team will complete the program)