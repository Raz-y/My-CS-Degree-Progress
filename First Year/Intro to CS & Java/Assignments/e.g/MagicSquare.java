
/**
 * This class represents a Magic Square, an n*n matrix square<R>
 * which the numbers in each row, column, and diagonal add up to the same number
 *
 * @author (Raz Yehiel)
 * @version (09/01/2023)
 */


public class MagicSquare
{
    
    /**
     * Calculates the sum of numbers in a given row in a given matrix
     * @param mat int 2d array that represents a sqared matrix
     * @param row the row number to calculate 
     * @return the sum of numbers in the given row 
     */
    public static int sumRow(int mat[][], int row){
        int sum = 0;
        for(int i = 0; i < mat[row].length; i++){
            sum += mat[row][i];
        }
        return sum;
    }
    
    /**
     * Calculates the sum of numbers is a given column in a given matrix
     * @param mat int 2d array that represents a sqared matrix
     * @param col the col number to calculate 
     * @return the sum of numbers in the given column 
     */
    public static int sumCol(int mat[][], int col){
        int sum =0;
        for(int i = 0; i < mat.length; i++){
            sum += mat[i][col];
        }
        return sum;
    }
    
    /**
     * Calculates the sum of the primary diagonal in a given matrix
     * @param mat int 2d array that represents a sqared matrix
     * @return the sum of numbers in the primary diagonal
     */
    public static int sumPrimaryDiag(int mat[][]){
        int sum = 0;
        
        for(int i = 0; i < mat.length; i++){
            for(int j = i; j <= i; j ++){
                sum += mat[i][j];
            }
        }
        return sum;
    }
    
    /**
     * Calculates the sum of the secondary diagonal in a given matrix
     * @param mat int 2d array that represents a sqared matrix
     * @return the sum of numbers in the secondary diagonal
     */
    public static int sumSecondaryDiag(int mat[][]){
        int sum = 0;
        
        for(int i = mat.length -1; i >= 0; i--){
            for(int j = i; j >= i; j--){
                sum += mat[i][j];
            }
        }
        return sum;
    }
    
    /**
     * Check if a given matrix represents a magic sqaure,<R> a Magic Square is an n*n matrix square<R>
     * which the numbers in each row, column, and diagonal add up to the same number
     * @return true if the given matrix represents a magic sqaure, false if not.
     */
    public static boolean isMagicSquare(int mat[][]){
        
        if(mat.length != mat[0].length){//check for equal rows and cols (assuming 2d arrays are col and row equals)
            return false;
        }
        
        for(int i = 0; i < mat.length; i++){
           for(int j = 0; j < mat[i].length; j++){
               if(MagicSquare.sumRow(mat, i) != MagicSquare.sumCol(mat, j)){ //check for sum of all rows and cols 
                   return false;
               }
           }
        }
        if(MagicSquare.sumRow(mat, 0) != MagicSquare.sumPrimaryDiag(mat) ||  
            MagicSquare.sumRow(mat, 0) != MagicSquare.sumSecondaryDiag(mat)){ //check for sum of all rows and cols and diagonal
            return false;
        }
        
        return true;
    }
}//end of calss MagicSquare



