
package CandyMachine;

/**
 *
 * @author daeuxis
 */

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class CandyMachine {
    private cashReg cashReg = new cashReg();
    private itemDispenser candies = new itemDispenser(1000, 1.00);
    private itemDispenser chips = new itemDispenser(1000, 5.00);
    private itemDispenser gums = new itemDispenser(1000, 1.00);
    private itemDispenser cookies = new itemDispenser(1000, 7.00);
    DecimalFormat decifor = new DecimalFormat("0.00");
    
    JFrame ui = new JFrame();
    JTextField insertCoins = new JTextField("0.00");
    JButton insertbtn = new JButton("Insert");
    JButton candiesbtn = new JButton("Candy");
    JButton chipsbtn = new JButton("Chips");
    JButton gumsbtn = new JButton("Gums");
    JButton cookiesbtn = new JButton("Cookies");
    JButton exitbtn = new JButton("Exit");
    JPanel ui2 = new JPanel();
    JLabel label4CandyMachine = new JLabel("WELCOME TO CANDY MACHINE", SwingConstants.CENTER);
    JLabel label4Item = new JLabel("ITEM: ", SwingConstants.CENTER);
    JTextField Item = new JTextField();
    JLabel label4Stock = new JLabel("STOCK: ", SwingConstants.CENTER);
    JTextField Stock = new JTextField("0");
    JLabel label4Quantity = new JLabel("QUANTITY: ", SwingConstants.CENTER);
    JTextField Quantity = new JTextField("0");
    JLabel label4Total = new JLabel("TOTAL PRICE: $", SwingConstants.CENTER);
    JTextField Total = new JTextField("0.00");
    JLabel label4Change = new JLabel("CHANGE: ", SwingConstants.CENTER);
    JTextField Change = new JTextField("");
    JLabel label4ItemRelease = new JLabel("ITEM RELEASED: ", SwingConstants.CENTER);
    JTextField ItemRelease = new JTextField("");
    
    public CandyMachine(){
    ui.setTitle("Candy Machine Application");
    ui.setVisible(true);
    ui.setResizable(false);
    ui.setSize(780,630);
    ui.setLayout(null);
    ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    ui.getContentPane().setBackground(Color.decode("#d1a9f5"));
    ui2.setVisible(true);
    ui2.setLayout(null);
    ui2.setBackground(Color.decode("#c78bfc"));
    ui2.setBounds(20, 30, 305, 430);
    insertCoins.setBounds(350, 50, 280, 50);
    insertCoins.setVisible(false);
    insertbtn.setBounds(650, 50, 100, 50);
    insertbtn.setVisible(false);
    InsertedCoin coinIn = new InsertedCoin();
    insertbtn.addActionListener(coinIn);
    ButtonListener bl = new ButtonListener();
    candiesbtn.setBounds(460, 150, 150, 50);
    candiesbtn.addActionListener(bl);
    chipsbtn.setBounds(460, 220, 150, 50);
    chipsbtn.addActionListener(bl);
    gumsbtn.setBounds(460, 290, 150, 50);
    gumsbtn.addActionListener(bl);
    cookiesbtn.setBounds(460, 360, 150, 50);
    cookiesbtn.addActionListener(bl);
    exitbtn.setBounds(460, 430, 150, 50);
    exitbtn.addActionListener(bl);
    label4CandyMachine.setBounds(0,10,305,40);
    label4CandyMachine.setForeground(Color.white);
    label4Item.setBounds(10,50,100,40);
    label4Item.setForeground(Color.white);
    Item.setBounds(110, 55, 180, 30);
    Item.setEditable(false);
    label4Stock.setBounds(10, 100, 100, 40);
    label4Stock.setForeground(Color.white);
    Stock.setBounds(110, 105, 180, 30);
    Stock.setEditable(false);
    label4Quantity.setBounds(10, 150, 100, 40);
    label4Quantity.setForeground(Color.white);
    Quantity.setBounds(110, 155, 180, 30);
    Quantity.setEditable(false);
    label4Total.setBounds(10, 200, 100, 40);
    label4Total.setForeground(Color.white);
    Total.setBounds(110, 205, 180, 30);
    Total.setEditable(false);
    label4Change.setBounds(20, 470, 100,40);
    label4Change.setForeground(Color.white);
    Change.setBounds(120, 475, 205, 30);
    Change.setEditable(false);
    label4ItemRelease.setBounds(20, 520, 100, 40);
    label4ItemRelease.setForeground(Color.white);
    ItemRelease.setBounds(120, 525, 205, 30);
    ItemRelease.setEditable(false);
      
    ui.add(ui2);
    ui.add(insertCoins);
    ui.add(insertbtn);
    ui.add(candiesbtn);
    ui.add(chipsbtn);
    ui.add(gumsbtn);
    ui.add(cookiesbtn);
    ui.add(exitbtn);
    ui.add(label4Change);
    ui.add(Change);
    ui.add(label4ItemRelease);
    ui.add(ItemRelease);
    ui2.add(label4CandyMachine);
    ui2.add(label4Item);
    ui2.add(Item);
    ui2.add(label4Stock);
    ui2.add(Stock);
    ui2.add(label4Quantity);
    ui2.add(Quantity);
    ui2.add(label4Total);
    ui2.add(Total);
    
}
    
    public class InsertedCoin implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent abcd) {
           try{  
           double insertedCoins = Double.parseDouble(insertCoins.getText());
           double coinsRequired = Double.parseDouble(Total.getText());
           if (insertedCoins >= coinsRequired){  
           double change = insertedCoins - coinsRequired;
           Change.setText("" + String.valueOf(decifor.format(change)));
           String getItem = Item.getText();
           int getQuantity = Integer.parseInt(Quantity.getText());
           ItemRelease.setText("" + getItem + " x" + getQuantity);
           Item.setText("");
           Stock.setText("0");
           Quantity.setText("0");
           Total.setText("0.00");
           candiesbtn.setVisible(true);
           chipsbtn.setVisible(true);
           gumsbtn.setVisible(true);
           cookiesbtn.setVisible(true);
           insertCoins.setVisible(false);
           insertCoins.setText("0.00");
           insertbtn.setVisible(false);
           cashReg.acceptMoney(insertedCoins);
           if (abcd.getSource() == insertbtn){ 
           }
           }else{
               JOptionPane.showMessageDialog(ui, "Not Enough Amount", "Notification",JOptionPane.ERROR_MESSAGE);
           }
           }catch (NumberFormatException a){
              JOptionPane.showMessageDialog(ui, "Invalid Amount", "Notification",JOptionPane.ERROR_MESSAGE);
              insertCoins.setText("0.00");
            }
        }    
    } 
    
        public class ButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent efgh) {
            if (efgh.getActionCommand().equals("Candy")){
                sellSelection(candies, "Candy");
                chipsbtn.setVisible(false);
                gumsbtn.setVisible(false);
                cookiesbtn.setVisible(false);
                insertCoins.setVisible(true); 
                insertbtn.setVisible(true);
            }
            else if (efgh.getActionCommand().equals("Chips")){
                sellSelection(chips, "Chips");
                candiesbtn.setVisible(false);
                gumsbtn.setVisible(false);
                cookiesbtn.setVisible(false);
                insertCoins.setVisible(true); 
                insertbtn.setVisible(true);
            }
            else if (efgh.getActionCommand().equals("Gums")){
                sellSelection(gums, "Gums");
                candiesbtn.setVisible(false);
                chipsbtn.setVisible(false);
                cookiesbtn.setVisible(false);
                insertCoins.setVisible(true); 
                insertbtn.setVisible(true);
            }
            else if (efgh.getActionCommand().equals("Cookies")){
                sellSelection(cookies, "Cookies");
                candiesbtn.setVisible(false);
                chipsbtn.setVisible(false);
                gumsbtn.setVisible(false);
                insertCoins.setVisible(true); 
                insertbtn.setVisible(true);
            }
            else if (efgh.getActionCommand().equals("Exit"))
                System.exit(0);
        } 
    }

    public void sellSelection(itemDispenser product, String productName){
        double coinsInserted = 0.00;
        double cost;
        int stock;
        
        if (product.getStock() > 0 ){ 
            cost = product.getCost();
            stock = product.getStock();
            Item.setText(productName);
            Stock.setText("" + stock);
            int initialQuantity = Integer.parseInt(Quantity.getText());
            int finalQuantity = (initialQuantity+1);
            Quantity.setText("" + finalQuantity);
            double initial_price = Double.parseDouble(Total.getText());
            double final_price = (initial_price+cost);
            Total.setText("" + String.valueOf(decifor.format(final_price)));
            product.makeSale();       
            }else{
                JOptionPane.showMessageDialog(ui, "Not Enough Stock", "Notification",JOptionPane.ERROR_MESSAGE);
            }
        }

    public static void main(String[] args) {
        CandyMachine CandyMachineApp = new CandyMachine();
    }  
}