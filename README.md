# N-Queens
Java program to play and solve the N-Queens problem

# How to use the program
- This program will take an input of n when first entered the program which n is the length and width of the board which cannot be lower than 4.
- This program will ask the user if they want to input the first queen themselves (y/n).
- If user input y then the program will ask the coordinates of the first queen input in row and column.
- and show the according answer to the coordinates of the first queen input.
- If there wasn't any possible solution given the first queen coordinates input the program will show "No solution" and print out the coordinates of the first queen inboard.
- Else if user input n then program will show 1 sample solution of the given board.
- Then if all of the above are finish the program will ask if you want to play again and then repeat the input first queen process.

# Algorithm use to solve this problem
- 1.) Start by putting the Queen at the leftmost column in the table.
- 2.) Check if there exists any Queen in the condition N (the size of table) then return true if exist.
- 3.) Do the following for rows in current column.
    - 3.a.) If Queen can be place in this row try and check if this row is possible answer in [row,column].
    - 3.b.) If we can put Queen in said [row,column] can make a possible answer return true.
    - 3.c.) If we put Queen at [row,column] and that doesn't make any possible answer remove said [row,column] out from set of answer and repeat a.) to try with another row.
    - If we have done all the row in said columns and that doesn't provided any possible answer keep backtracking to change the column and repeat for each row.

# REF.
- https://www.geeksforgeeks.org/n-queen-problem-backtracking-3/
