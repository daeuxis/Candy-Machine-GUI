
package CandyMachine;

/**
 *
 * @author daeuxis
 */
public class itemDispenser {
    private int stock;
    private double cost;
    
    public itemDispenser(){
        stock = 1000;
        cost = 1.00;
    }
    public itemDispenser(int setStock, double setCost){
        if (setStock >= 0)
             stock = setStock;
         else
             stock = 1000;

         if (setCost >= 0)
             cost = setCost;
         else
             cost = 1.00;
    }
    public int getStock(){
        return stock;
    }
    public double getCost(){
        return cost;
    }
    public void makeSale(){
        stock--;
    }
}
