SLOGO Architecture Design

When does parsing need to take place and what does it need to start properly?
Parsing takes place after the user has entered in a line of text representing a command and submitting it
What is the result of parsing and who receives it?
After the inputted command is parsed, a backend class would receive it and interpret this command.
When are errors detected and how are they reported?
Errors are detected after parsing is completed and the command is checked to see if it is valid from the backend class that is parsing it
What do commands know, when do they know it, and how do they get it?
The commands know: The command knows enough information from the input in order to formulate an output
When they know it: The command knows it after the parser interprets it.
How do they get it: The command gets this information from the parser
How is the GUI updated after a command has completed execution?
There is an intermediary component between the command execution and the GUI that processes the return value of the command and gives it to the GUI with a simplified visual execution.
