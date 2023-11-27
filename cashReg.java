
package CandyMachine;

/**
 *
 * @author daeuxis
 */
public class cashReg {
    private double CashOnHand;
    
    public cashReg(){
        CashOnHand = 500.00;
    }
    public cashReg(double CashIn){
        if (CashIn >= 0)
            CashOnHand = CashIn;
        else
            CashOnHand = 500;
    }
    public double getTotalSales(){
        return CashOnHand;
    }
    public void acceptMoney(double payment){
        CashOnHand = CashOnHand + payment;
    }
    public void returnChange(double change){
        
    }
}

