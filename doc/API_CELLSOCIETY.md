###Analysis of Team 19's API###

##Simulation##

#External#

The project has a lot of external methods when it comes to the simulation, as the simultion classes all interact with the grid class. 
The constructors rely on another class to call them, except for the super constructor. A grid is made and then stored, which is used
for the update methods. The methods to get the names are also external, as the runner needs these names when making the grapher.

#Internal#

The getKeys and getRand methods are internal as it is just interactions between the super and sub classes, as these variables are stored 
in the super because all sims use this feature. The cells are also closed between themselves and their super classes, as it only
needs to access the variables of the state and next state dependant on only themselves.

##Configuration##

#External#

The configuration of cells is such that they are instantiated by the grid, and then the grid makes a cells and sets the cells neighbor
arrays once everything is added, adding a layer of communication between grids and cells. The sim also passes the cols and rows betwen
the grid and the runner, as the orientation of where a cell is needs to be known by many parties.

#Internal#

The cells then stores their neighbors, which in turn hold this value and no longer need to go to the grid to access their neighbors, and
are only searching for other cells. The grid in turn only communicates with itself once initialized for understand where on the screen
and which row and cols are needed at a given index when learning of how large the grid is. 

##Visualization##

#External#

The grid needs to know how large the screen is and how many rows and columns are in order to decide the cell width and length. These values
are passed from the first sim call to the grid, which then creates an array and passes them to the cells, who use these coordinates 
to add themselves to the screen.

#Internal#

The cells update their colors based solely on their current states, and when they update their current states it is done within the cell 
method, so the call to color change which is represented on the screen is actually the cells changing their own color. 