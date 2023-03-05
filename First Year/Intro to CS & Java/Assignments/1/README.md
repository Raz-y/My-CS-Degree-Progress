# Assignment 1
**Score: 96** **
--
This is the last assignment of this course summarizing all that was learned in this course.

## Question 1 - Car Company Class
**The Company Department represents a car rental company.**
The representation is made through a system of rentals, sorted by the dates the cars are picked up. The rental system is sorted in such a way that the rentals appear in order of the pick-up date (pickDate)

Steps:
- Defining the properties of the class.
- Creating constructors
- Defining methods:
   - addRent - a boolean method that adds rent and returns true if rent was added successfully.
   - removeRent - a boolean method that removes a rent with the same given date
   - getSumOfPrices - a method returning the total earning of a given period
   - getSumOfDays - a method returning the sum of rental days 
   - averageRent - a method returning the average of renting days
   - lastCarRent - a method returning the last rented car
   - longestRent - a method returning the longers rent
   - mostCommonRate - a method returning the most common car rate ranted
   - toString - a method returning a string representation of the company

**see web API**

## Question 2 - Magic Square 
**A magic square is a square matrix of numbers where the sum of each row, column, and diagonal is the same value**
Static Methods:
- sumRow - receives a square matrix and row num and returns the sum of the row.
- sumCol - receives a square matrix and col num and returns the sum of the col.
- sumPrimaryDiag - receives a square matrix and returns the primary diagonal  sum.
- sumSecondaryDiag - receives a square matrix and returns the secondary diagonal  sum
- isMagicSquare - receives a  matrix and returns true if it's a magic square (using the previous  methods).
- 
**see web API**

**
--
Question 2:
Error in sumSecondaryDiag method solution for the following mat: -4

| 11 | 24 | 7 | 20 | 3 |
| - | - | - | - | - |
| 4 | 13 | 25 | 8 | 16 |
| 17 | 5 | 12 | 21 | 9 |
| 10 | 18 | 1 | 14 | 22 |
| 23 | 6 | 19 | 2 | 15 |

The sum of the Secondary Diagonal should be: 64
while student result is: 65
Error in sumSecondaryDiag!
