
/**
 * This class represents a car rental company.
 *
 * @author (Raz Yehiel)
 * @version (06/01/2023)
 */
public class Company
{
    //Declarations
    
    private Rent[] _rents;
    private int _noOfRents;
    
    private final int MAX_RENTS = 1000;
    
    //Constructor definition
    /**
     * Creates a new empty Rent array with max of 1000 slots and sets the number of active rents in the array to 0
     */
    public Company(){
        _rents = new Rent[MAX_RENTS];
        _noOfRents = 0;
    }
    
    //Method definition
    /**
     * Adds a given rent to the Company array and re-organizes the order of the rents per pick date.<R>
     * In case of similar pickdate in the array the new rent will be added after the existing one
     * @param name the client's name
     * @param car the rented car
     * @param pickDate the pick date
     * @param returnDate the return date
     * @return true if rent was added, false if the array is full
     */
    public boolean addRent(String name, Car car, Date pick, Date ret) {
        
        if(_noOfRents == MAX_RENTS){//check if there's space in the array 
            return false;           
        }
        
        if (_noOfRents == 0){//check if array is empty
            _rents[_noOfRents] = new Rent(name, car, pick, ret);
            _noOfRents++;
            return true;
        }
        
        for (int i = 0; i < _noOfRents; i++) {
            if(_rents[i].getPickDate().equals(pick)) { //check for similar date
                for(int m = i; m < _noOfRents; m++){ //check for more similar dates
                    if(!_rents[m].getPickDate().equals(pick)){
                        for(int j = _noOfRents; j >= m; j--) {//re-organize array 
                        _rents[j+1] = _rents[j];
                        }
                    _rents[m] = new Rent(name, car, pick, ret);
                    _noOfRents++;
                    return true;
                    }
                }
            
        }
            else if(_rents[i].getPickDate().after(pick)) { //check for date order
                for(int j = _noOfRents; j >= i; j--) {//re-organize array 
                    _rents[j+1] = _rents[j];
                }
                _rents[i] = new Rent(name, car, pick, ret);
                _noOfRents++;
                return true;
            }
            
            else{}
        }
        _rents[_noOfRents++] = new Rent(name, car, pick, ret);
        return true;
    }
    
      /**
     * Removes first rent with corresponding return-date from the company array <R>
     * and re-organizes the order of the rents per pick date
     * @param returnDate the rent's date which needs to be removed
     * @return true if rent was removed, false if rent with the given return date wasn't found
     */
    public boolean removeRent(Date ret){
        
        for(int i = 0; i < _noOfRents; i++){
            if(_rents[i].getReturnDate().equals(ret)){//check if rent axists
                for(int j = i; j < _noOfRents - 1; j++){//re-organize array
                    _rents[j] = _rents[j+1];
                }
                _rents[_noOfRents - 1] = null;
                _noOfRents--;
                return true;
            }
        }
        return false;
    }
    
    /**
     * Calculates the total earnings of all active rents in the array
     * @return the total earnings of active rents
     */
    public int getSumOfPrices(){
        if(_noOfRents == 0){
            return 0;
        }
        int rentPrice, sumOfPrice = 0;
        for(int i = 0; i < _noOfRents; i++){
            rentPrice = _rents[i].getPrice();
            sumOfPrice += rentPrice;
        }
        return sumOfPrice;
    }
    
    /**
     * Calculates the total number of renting days in the array
     * @return the total rent days in the array 
     */
    public int getSumOfDays(){
        if(_noOfRents == 0){
            return 0;
        }
        int rentDays, sumOfDays = 0;
        for(int i = 0; i < _noOfRents; i++){
            rentDays = _rents[i].howManyDays();
            sumOfDays += rentDays;
        }
        return sumOfDays;
    }
    
    /**
     * Calculates the average rent days in the array<R>
     * @return rent days average, 0 if there are no rents
     */
    public double averageRent(){
        double totalCount = 0;
        if(_noOfRents == 0){
            return 0;
        }
        
        for(int i = 0; i < _noOfRents; i++){
            totalCount += _rents[i].howManyDays();
        }
        return (double)(totalCount / _noOfRents);
    }
    
    /**
     * Returns the car with the latest return date
     * @returns car with latest return date, null if there are no rents
     */
    public Car lastCarRent(){
        if(_noOfRents == 0){
            return null;
        }
        Rent lastRent = _rents[0];
        for(int i = 0; i < _noOfRents; i++){
            if(_rents[i].getReturnDate().after(lastRent.getReturnDate())){
                lastRent = _rents[i];
            }
        }
        Car lastCar = new Car(lastRent.getCar());
        return lastCar;
    }
    
    /**
     * Returns the longers duration rents, in case of multiple rents with same number of days returns the first
     * @return the longest rent, null if there are no rents 
     */
    public Rent longestRent(){
        if(_noOfRents == 0){
            return null;
        }
        
        Rent longestRent = _rents[0];
        for(int i = 0; i < _noOfRents; i++){
            if(_rents[i].howManyDays() > longestRent.howManyDays()){
                longestRent = new Rent(_rents[i]);
            }
        }
        return longestRent;
    }
    
    /**
     * Returns the most popular car type, in case of same number of type rents returns the better one. (B is better than A)
     * @return most poupular car type, N if there are no rents
     */
    public char mostCommonRate(){
        if(_noOfRents == 0){
            return 'N';
        }
        char popularType = 'A';
        int a = 0, b = 0, c = 0, d = 0;
        for(int i = 0; i < _noOfRents; i++){//check and aggragate car types
            if(_rents[i].getCar().getType() == 'A'){
                a++;
            }
            else if(_rents[i].getCar().getType() == 'B'){
                b++;
            }
            else if(_rents[i].getCar().getType() == 'C'){
                c++;
            }
            else{
                d++;
            }
        }
        
        if(a == b && b > c && b > d){//check for similar num of types 
            popularType = 'B';
        }
        else if((a == c || b == c) && c > d ){
            popularType = 'C';
        }
        else if(a == d || b == d || c == d){
            popularType = 'D';
        }
        else{}
        
        if (a > b && a > c && a > d){//check for most common type
            popularType = 'A';
        }
        else if (b > a && b > c && b > d){
            popularType = 'B';
        }
        else if (c > a && c > b && c > d){
            popularType = 'C';
        }
        else if(d > a && d > b && d > c){
            popularType = 'D';
        }
        else{}
        
        return popularType;
    }
    
    /**
     * Returns a string that represents the company array
     * @return String that represents active rents in the company in the following format: <R>
     * The company has X rents:<R>
     *  Name:Ruthi From:10/03/2022 To:14/03/2022 Type:A Days:4 Price:400<R>
     *  *<R>
     *  *<R>
     */
    public String toString(){
        if(_noOfRents == 0){
            return "The company has 0 rents.";
        }
        
        String s = "The company has " + _noOfRents + " rents:\n";
        for(int i = 0; i < _noOfRents; i++){
            s += _rents[i].toString() + "\n";
        }
        return s; 
    }
    
}//end of class company

