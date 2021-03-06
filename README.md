## An implementation of [Conway's Game of Life](http://en.wikipedia.org/wiki/Conway's_Game_of_Life) in Java.

The set of rules are summarized as follows:

1. An alive cell with fewer than two alive neighbors dies in the next generation.
2. An alive cell with more than three alive neighbors also dies in the next generation.
3. An alive cell with exactly two or three alive neighbors stays alive in the next generation.
4. A dead cell with exactly three alive neighbors becomes alive in the next generation.

This implementation uses a 25x75 grid. Off-grid neighbors are always assumed to be dead.

The program is intended to be run from the command line. It will prompt your for a local filename like so:

`Enter a filename: file0.dat`

In the example above, `file0.dat` is a file holding the initial state of the grid. The program will continue generating until all cells are dead or a stable state is reached. The formatting of the input file should match the included examples.

*Example `.dat` file results:*

life1.dat -> should reach alternating state at generation 2-3

life2.dat -> should reach alternating state at generation 39-40

life3.dat -> should reach empty world at generation 4

life4.dat -> should reach a steady state (that gets detected) at generation 19

life5.dat -> should reach a steady state (that gets detected) at generation 79

Regarding steady state outcomes: the last two grids that get printed should be the
same; the user should be able to verify a steady state visually, in addition to being
told by the program that a steady state has been reached.

*Sample output:*

```
Please select a file to import
life1.dat
Generation: 0

...........................................................................
...........................................................................
...........................................................................
...........................................................................
...........................................................................
...............X.X.........................................................
XXX.......................XX.......................XXXX....................
...............X.X........XX...............................................
...........................................................................
...........................................................................
...........................................................................
...........................................................................
...........................................................................
...........................................................................
...........................................................................
...........................................................................
...........................................................................
...........................................................................
...........................................................................
...........................................................................
...........................................................................
...........................................................................
...........................................................................
...........................................................................
...........................................................................
Generation: 1

...........................................................................
...........................................................................
...........................................................................
...........................................................................
...........................................................................
.X..................................................XX.....................
.X........................XX........................XX.....................
.X........................XX........................XX.....................
...........................................................................
...........................................................................
...........................................................................
...........................................................................
...........................................................................
...........................................................................
...........................................................................
...........................................................................
...........................................................................
...........................................................................
...........................................................................
...........................................................................
...........................................................................
...........................................................................
...........................................................................
...........................................................................
...........................................................................
Would you like to proceed? Press any key to continue or 'q' to quit
y

Generation: 2

...........................................................................
...........................................................................
...........................................................................
...........................................................................
...........................................................................
....................................................XX.....................
XXX.......................XX.......................X..X....................
..........................XX........................XX.....................
...........................................................................
...........................................................................
...........................................................................
...........................................................................
...........................................................................
...........................................................................
...........................................................................
...........................................................................
...........................................................................
...........................................................................
...........................................................................
...........................................................................
...........................................................................
...........................................................................
...........................................................................
...........................................................................
...........................................................................
Would you like to proceed? Press any key to continue or 'q' to quit

```
