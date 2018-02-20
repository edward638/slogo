# Introduction

In this project, we are trying to create the simple computer programming language SLOGO, which takes in user input, interprets commands, and 
performs some action that appears on the screen. We hope to make several areas in our program flexible. Some of these areas include being able
to make our program flexible enough in the back end to take in and interpret additional commands. In addition, we want to minimize the amount 
of dependencies our working parts have between each other in order to avoid issues with adding new features. In discussing the program at a high
level, we plan to divide it into three simple modules: Model, View, and Controller. In this program, we hope to have the View display information 
to the user and be able to take in user interactions. These interactions are meant to go to the Controller, which can interpret the interaction. 
The Controller can then either tell the View to change its display or delegate the Model to perform some action if backend specific information 
is necessary to perform the interaction. The Controller can then change its state and/or tell the View about this state change so that they View can make queries. We feel that 
splitting the design of the program simplifies the program into three separate, smaller problems and can help our program to achieve better 
flexibility as a whole.

# Design Overview

## Internal Front-end
* The front end will work together with its components to draw specific data to the screen after it gets this data from the Model (a process that will be described in detail in a bit).

## External Front-end
* When a button is pressed within the GUI, the front-end will notify the back-end Controller that some input has been submitted. Based on the type of input provided, the Controller will notify the Parser or Model what method to perform. In addition, it is possible for the Controller to call a method back to the front-end GUI, such as when the clear button is pressed for the command box.

## Internal Back-end
* The internal back-end is composed of the TreeMaker classes as well as the classes which represent different types of basic syntax types (Variable, Constant, Command, List, and Comment). The TreeMaker classes are composed of a TreeMaker and and TreeEvaluator. The former reads in the list of syntax types which are created by the parser then reads through them and creates a tree meant that can later be evaluated by the TreeEvaluator. Any tree starts with the method type in the first node which dictates how many and which kind of children nodes it will in turn have, depending on the other types in the list passed to the TreeMaker. The TreeEvaluator then reads through this tree to evaluate the given Command, calling the appropriate methods to update the model and then returning the value expected of the command. The syntax types are basic classes which store values associated with how a type would be represented and which actions would need to be done. For example, the Constant class would store a single double constant and allow itself to be accessed by nodes in the future, not allowing children nodes to come from it. This is similar to Variable, which would then store a name for the Variable as well. A Command would be a head node and have a certain amount of children depending on how many parameters are passed when it is called. These classes also check for errors, as if a type does not match what is actually passed, then the method will not be able to run. 


## External Back-end
The External back end will be made up of the Parser class and the Model class. The Parser class will serve as the intermediary between the controller and the Tree creation as it will make sure that the commands are in a language readable to the Tree and will also create a list of node objects that the Tree creator can use to make the tree and check for specific errors. The Model class will be passed through the program and will be updated as the tree interprets commands. The model class will hold all of the turtle information and will alert the view when something has changed so that the view can match the new turtle information.

Here is a picture of how our components are related:

![Components Overview] (./doc/design_components_slogo.png)

# User Interface

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

## Front-end Internal API's - Andy
* VariableBox
    * VariableBox()
    * addVariable(variableString) [Internal API, Visualizer -> VariableBox]
    * addUserCommand(variableString) [Internal API, Visualizer -> VariableBox]
* CommandBox
    * CommandBox()
    * clear() [Internal API, Visualizer -> CommandBox]
* ConsoleBox
    * ConsoleBox()
    * addCommand(commandString) [Internal API, Visualizer -> ConsoleBox]
* Drawer
    * Drawer()
    * Public setBackgroundColor(color) [Internal API, Visualizer -> Drawer]
    * Public setPenColor(color) [Internal API, Visualizer -> Drawer]
    * Public setImage(img) [Internal API, Visualizer -> Drawer]
    * Public penUp() [Internal API, Visualizer -> Drawer]
    * Public penDown() [Internal API, Visualizer -> Drawer]
    * Public draw()  [Internal API, Visualizer -> Drawer]
    * Public moveToPoint(x,y) [Internal API, Visualizer -> Drawer]

## Front-end External API's - Eddie

* Visualizer
    * Visualizer()
    * Public updateGUI() [External API, Model -> View]
    * Public showCommandHelp [External API, Controller -> View]
    * Public clearCommandBox [External API, Controller -> View]
* VariableBox

No external API

* CommandBox

No external API

* ConsoleBox

No external API

* Drawer

No external API



* Controller
    * ViewController
        * Public showCommandHelp [External API, View -> Controller]
        * Public clearCommandBox [External API, View -> Controller]
    * ModelController
        * Methods:
            * Public passCommand() [External API, View -> Controller]
            * Public clearConsoleBox()  [External API, View -> Controller]
            * Public clearVariableBox()  [External API, View -> Controller]


## Back-end Internal API's - Charlie

### TreeMaker
* public TreeMaker (List syntaxes)
* public getTree

### TreeEvaluator
* public TreeEvaluator (TreeMaker tm)
* public getReturn()

### Nodes types
* All nodes have these methods:
	* addNode(Node l)
	* getParent()
	* getNext()

* These will be the nodes which have their own functions:
1. Assign
2. Return
3. Compare
4. BinOp
5. Command

### Data types
* Variable
	* public Variable (String name, double value)
	* public set (Object o)
	* public get()
* Constant
	* public Constant (double value)
	* public get()
* List
	* public List (Command[] commands)
	* public addVariable(Variable v) 
	* public addCommand(Command c)
	* public hasNext()
	* public next()
* Comment
* No public methods
* Command
	* public Command (Object o, Object o)
	* public evaluate()
	* public addAST (TreeAST)

### Turtle
* public Turtle(double xHome, double yHome);
* public forward(double pixels);
* public forward(double pixels);
* public back(double pixels);
* public left(double degrees);
* public right(double degrees);
* public setHeading(double degrees);
* public towards(double x, double y);
* public setXY(double x, double y);
* public penDown();
* public penUp();
* public showTurtle();
* public hideTurtle();
* public home();
* public clearScreen();
* public getLines();


## Back-end External API's - Belanie

### Parser
* public Parser(Model m);
* public createParsedList(String command); [External API, Controller -> Model]

### Model
* Public Model() 
* Public List getLines(); [External API, Model -> View]
* Public List setLines(); [External API, Tree-> Model]
* Public double getTurtleX(); [External API, Model -> View]
* Public double setTurtleX(); [External API, Tree-> Model]
* Public double getTurtleY(); [External API, Model -> View]
* Public double setTurtleY(); [External API, Tree-> Model]
* Public double getTurtleDegrees(); [External API, Model -> View]
* Public double setTurtleDegrees(); [External API, Tree-> Model]
* public List getVariables(); [External API, Model -> View]
* public List setVariables(); [External API, Tree-> Model]
* public List getCommandHistory(); [External API, Model -> View]
* Public List setCommandHistory(); [External API, Tree-> Model]
* public clearVariables(); [External API, Model -> View]
* public clearCommandHistory(); [External API, Model -> View]
* Public notifyViewObservers(); [External API, Model -> View]


# API Example Code
It is especially important in helping others understand how to use your APIs to provide example code. It should be clear from this code which 
objects are responsible for completing each part of the task, but you do not have to implement the called functions.

* Show an actual "sequence of code" that implements the following use case using only methods described in your APIs: 
    * Given example: The user types 'fd 50' in the command window, and sees the turtle move in the display window leaving a trail, and the command is added to 
    the environment's history.
    * Note, clearly show the flow of calls to public methods needed to complete this example, indicating which class contains each method called. 
    * It is not necessary to understand exactly how parsing works in order to complete this example, just what the result of parsing the command
    will be.

1. User inputs ‘fd 50’ into the Command Box in the GUI and presses the Run button.
    * Controller.passCommand(‘fd 50’) // passes the string to the Parser
    * Parser.createParsedCommand(‘fd 50’); // passes the string to the parser to be made into objects
    * Tree.makeTree(List parsedObjects); //gives the objects to the tree in order to create the hierarchy
    * Tree.getNext(Object parsedObject) would then take from this list the next object and update the tree accordingly
    * TreeEvaluator.evaluate(Tree tree) would then go through the made tree and update the model, returning the necessary values
    * Model.setTurtleX(50); //changes the model in order to update the view
    * Model.notifyViewObservers() // lets View know that Model database has been updated
    * View.updateGUI() // calls all methods necessary to update GUI
    * Drawer.draw() // called by main View class (Visualizer)

2. Second example: The user hits the clear button within the command box and sees the text in the command box disappear
    * Controller.clearCommandBox()
    * View.CommandBox.clear()
   
3. Third example: The user inputs ‘CLEARSCREEN’
    * User inputs ‘CLEARSCREEN’ into the Command Box in the GUI and presses the Run button.
    * Controller.passCommand(‘CLEARSCREEN’) // passes the string to the Parser
    * Parser.createParsedCommand(‘CLEARSCREEN’); //turns the command into a list of node objects
    * Tree.makeTree(‘CLEARSCREEN’) creates a simple tree which has nodes that contain functions needed to change the model
    * TreeEvaluator(Tree ClearScreen) would then read through this tree calling the methods that were added
    * Model.setLines() //remove all of the lines
    * Model.setTurtleX() // set to 0
    * Model.setTurtleY() // set to 0
    * Model.notifyViewObservers() // lets View know that Model database has been updated
    * View.updateGUI() // calls all methods necessary to update GUI
    * Drawer.draw() // called by main View class (Visualizer)

4. Fourth example: The user inputs ‘MAKE :X 5’
    * User inputs ‘MAKE :X 5’ into the Command Box in the GUI and presses the Run button.
    * Controller.passCommand(‘MAKE :X 5’) // passes the string to the Parser
    * Parser.createParsedCommand(‘MAKE :X 5’)
    * Tree.makeTree(List MAKE :X 5’) would create nodes of a new variable and assign the new variable a value
    * TreeEvaluator(Tree MakeX5) would go through the nodes and see a new variable was created then call the model of the node’s Variable object
    * Model.setVariables() //Stores :X as variable within the database with value 5
    * Model.notifyViewObservers() // lets View know that Model database has been updated
    * View.updateGUI() // calls all methods necessary to update GUI
    * Variable.addVariable() // called by main View class (Visualizer)

5. Fifth example: The user inputs ‘PENUP’
    * Controller.passCommand(‘PENUP’)
    * Parser.createParsedCommand(‘PENUP’)
    * Tree.makeTree(List PENUP) sees the penup command and makes a single node with a return based on the appropriate function
    * TreeEvaluator(Tree Penup) would then read through the tree and call the PENUP() function and return the appropriate value
    * Model.setLines() //make a transparent line so that the turtle moves without leaving a path
    * Model.setTurtleX() // set new X
    * Model.setTurtleY() // set new Y
    * Model.notifyViewObservers();

	
6. Example: The user presses the clear variables button and sees all variables freed.
    * Controller.clearVariableBox() //controller will recognize that this is a command that can pass straight to the model
    * Model.clearVariables()//model will clear its variable list
    * Model.notifyViewObservers();

7. Example: The tree has a return of 5, 6 for a setXY command
    * Model.setLines() //make a lline so that the turtle moves forward by 5, 6
    * Model.setTurtleX() // set new X to 5
    * Model.setTurtleY() // set new Y to 6
    * Model.notifyViewObservers(); //let the view know it has to change

8. TreeMaker example: SETXY 2 add 5 subtract 7 2
    * The tree makes a new node of SETXY command at the top of the tree
    * It reads in a constant and adds an assign node to assign a variable X to this constant
    * It then adds another assign which stores variable Y to the command add 5 subtract 7 2
    * The tree sees another command add and creates an add node
    * The add node has an binop node of 5 as one child and subtract 7 2 as the other
    * The subtract node is created with a binop node with children 7 2
    * The tree then goes all the way up seeing all children nodes are full, then creates a return node on SETXY
    * The return node return the function Turtle.setxy(X, Y)

9. TreeEvaluator is passed the Tree from above
    * The evaluator sees a new head node and goes to the left-most node
    * It sees an assign and sets variable X equal to 2
    * It then goes up and to the next assign node
    * It creates variable Y and sees it is being set to a command, which in turn it must evaluate
    * The tree then evaluates the ADD node and sees that being added is another command
    * The tree then evaluates that command and brings the return value back up to the ADD node’s assign
    * The ADD node is evaluated and bringing up the SETXY second assign node, and assigns Y to the return value
    * The evaluate then goes to the return node where it calls the method it finds  

# Design Considerations 

## Potential issues
* One issue that we may have is that the Model component of our design may end up taking on too many tasks/getting too many variables to keep track of. Another issue that we may have to be aware of is that drawing is done through a list of available lines with attributes all at one time rather than dynamically, as time progresses. Based off of these current implementation guidelines, this doesn’t seem to be an issue as of now, but it could potentially be an issue since drawing is done in a taboo way as of now.

## Design decisions
* One design decision we considered was where we wanted to put the Parser class after a command was passed through to the Controller. At first we thought about locating the Parser within the Model, but we decided that we wanted the Model to be strictly responsible for containing data pertinent to the View. In addition, we also did not want to put the Parser in the Controller, as we did not want the Controller to pass the command and parse it; this seemed to be giving the Controller work outside of its responsibility and it may be the case that the Model has back-end information that may be useful to parse a command. To resolve this issue, we decided that we would create an intermediate class between the Controller and the Model that would parse the command and supply the Model with any relevant data.
* Another design decision we originally made was to have the Model call specific functions within the View in order to perform a specific command. For instance, the model would parse the move forward command and then immediately tell the View to move the turtle forward on the screen. An issue we found with this decision was that this design seemed to have several dependencies: the view depended on methods in the controller, the controller depended on methods in the model, and then the model depended on methods within the view. This appeared to be a red flag, since if one wanted to make functional changes to the View, such as erase a method, the model would be directly impacted, which is not what we want. In order to fix this issue, we decided to keep the model less aware about the View it affects; we decided to have the model perform its normal functions, but rather than telling the View what to do with the functions, all it does is notify its observers (in this case, the View, but it doesn’t have to be) that its own state has changed. The View can then do the work of querying state information to display to the screen. We felt that doing it this way limited dependencies and keeps information encapsulated between model and view.
* One of the design decisions we made was to store the commands in tree form. This is because the commands are not always on just constants or variables, which have easy-to-access values to be used in the command. Sometimes a command with have to perform an operation on another command. This command would then have to be evaluated first and returned before the previous command can continue. As this can be nested further, the complexity of keeping track of how to return becomes very difficult to follow. A tree puts the one or two values a command needs to use as nodes and then splits these up as events to follow before it is evaluated. When there are two arguments, the first or second one could be a command, and the children of a node would then represent these respective options. We felt a tree was the best way to represent this complexity. We considered using a stack but decided that comparisons and while loops would be difficult to implement, as commands would have to be looped over which cannot be done in a stack as once it is popped it cannot be accessed again, and if statement are just generally tricky to implement on a stack, as decisions to skip a item is not possible. 

## Ambiguities, assumptions and dependencies
* One large dependency within our program is that the Parser must collect information from the View to actually parse a command and pass information to the Model. To accomplish this task, we will have the View have a Command Box, which will be responsible for calling a Controller method passCommand(). This passCommand() method will contain the command called in the form of a string, and this will be passed to the Parser. 
* When deciding how to transfer the data from the Model to the View, we assumed that it would be acceptable to have the View collect all data and update all parts of the GUI, regardless of whether a specific portion had any changes (ex. updating variable box after a non variable related command). While this would not be the most efficient method to update the GUI, it would be much simpler on the front-end. We assumed that the performance losses would be negligible and outweighed by the benefits of this implementation.

# Team Responsibilities

### Edward
* His primary responsibility is within the View component of this program. He will work on the CommandBox, ConsoleBox, and VariableBox classes (designed to be contained within the Visualizer). He will also work on the Controller.

### Andy 
* His primary responsibility is within the View component of this program. He will work on the Visualizer class in particular. In addition, he will contribute to some aspects of the Controller.

### Belanie
* She will be responsible for creating the Parser class that will convert the string of commands into a list of node objects for the tree and will also convert the string of commands into the proper language for the tree to interpret. She will also be responsible for the Model class that will store information for updating the View.

### Charlie 
* He will be responsible for creating the tree that will then evaluate any given expression from the command line, then communicating with the Model (Turtle) and updating its values. He also will create the syntax type classes which will be used during parsing and Tree making.


### High-Level Plan
* We will work on these components (Model, View, Controller) separately, but Edward and Andy will work together closely to create the View/Controller in a way that makes sense to both of them. Belanie and Charlie will work together on the Model, but will split responsibilities with regards to making the Parser and Tree structure.

