# API Review SLOGO

Belanie Nagiel and Julia Long

Review of Team 03

### Part 1

1. What about your API/design is intended to be flexible?

The tree creation part of our design is intended to be flexible through its limited conditions in building. Errors will be thrown as the tree begins to evaluate, which allows odd structures of commands to be executed even though they may not seem correct when first parsed. The parsing will only throw errors for inputs that don't match any node type. Also, it is very easy to add new node types and new command functionality to the tree and new ways of traversing through the tree if necessary.

2. How is your API/design encapsulating your implementation decisions?

Our tree structure is encapsulated because it cannot be reached by any other part of the program.

3. What exceptions (error cases) might occur in your part and how will you handle them (or not, by throwing)?

Exceptions in my part include words in languages that are not recognizable and user inputs that do not match any of the accepted regex patterns. I will handle these exceptions by throwing an error indicating either that the command is in an unrecognizable language or that the command is invalid so that the window in the view that holds pass commands can indicate that the command could not go through. 

4. Why do you think your API/design is good (also define what your measure of good is)?

I think our API design is good because the tree structure is very flexible. It will allow us to loop through the tree and also read it in different orders. Also, it will be easy to add new types of nodes. 


### Part 2

1. How do you think Design Patterns are currently represented in the design or could be used to help improve the design?

We are using a control model view design pattern or at least a modified version of it. 

2. What feature/design problem are you most excited to work on?

I am most excited to work on the parsing, because I think that recognizing languages and recognizes more complicated structures like lists will be an interesting challenge.

3. What feature/design problem are you most worried about working on?

I am most worried about working on the way the model alerts the view that something has changed. I would like to use events, but I am still not completely sure how those work.

4. Come up with at least five use cases for your part (it is absolutely fine if they are useful for both teams).

* Recognizing different languages
* Recognizing complicated command entries
* Recognizing nested commands
* Alerting the view that the turtle must be moved
* Recognizing the validity of a command
