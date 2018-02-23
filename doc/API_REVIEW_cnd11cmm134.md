# SLogo API Review; cnd11, cmm134

### Part 1

1. What about your API/design is intended to be flexible?
	* When adding a new command, all that has to be done is that a new command class created that reflects the kind of children nodes and type of function called to the turtle will be. Otherwise, the tree maker and tree evaluator will function in the exact same way.
	* In addition to adding a new command, the turtle will hold these commands individually and can change already stored values that it holds and the view needs. The view will still update all values to change the turtle on screen by calling a getValues() method on turtle which will not change.
2. How is your API/design encapsulating your implementation decisions?
	* The majority of turtle methods will not allow anyone outside of the turtle class to change its values while only having public getter methods. The turtle then is linked closely with the tree evaluator who is closed because once a tree is made it should not be able to be altered. 
3. What exceptions (error cases) might occur in your part and how will you handle them (or not, by throwing)?
	* An error case would be a parent node adding a child that is not valid for that node, and this error would be thrown inside the node classes where there are certain types to be expected. Another error case is a command that is not valid or a command with invalid values. The former would be caught when parsing while the latter would be caught when evaluating. 
4. Why do you think your API/design is good (also define what your measure of good is)?
	* Our API is good because we know how each part will function and have a clear purpose for why each class is made, emphasizing the idea that each class should do one job well. 

### Part 2

1. How do you think Design Patterns are currently represented in the design or could be used to help improve the design?
	* Design Patters are currently represented in the design by having each command realized individually with the ability for any command being able to be executed without having a specific instruction set after command creation. 
2. What feature/design problem are you most excited to work on?
	* I am most excited to work with how to create a tree and adding nodes and methods which reflect functions to be used by other places in the code, hoping to make clean logic and easy to understand code. 
3. What feature/design problem are you most worried about working on?
	* I am most worried about dealing with lists and making custom methods, as we are still unsure how to make the data structures for lists and not sure where to store the custom methods. 
4. Come up with at least five use cases for your part (it is absolutely fine if they are useful for both teams).
	* FD 50
		* Tree is made, evaluated, and turtle updated
	* ADD 2 5
		* Add tree is made with a binop add and returns 7
	* SETXY 5 7
		* Assign nodes are made to store 5 and 7 then the turtle method for setXY is called on those variables
	* Add FD 50 FD 50
		* A new add node is made but with adding the commands FD 50, where each command node returns the value expected while also calling the method on the turtle
	* TO :x 50
		* The TO command would create an assign node that makes the variable based on the name and call a method to store the variable and its name

