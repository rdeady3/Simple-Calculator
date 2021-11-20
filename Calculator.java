//Russell Deady
//Creating a calcuator on a GUI using java swing and other packages 
//Started this project on 11/3/21 and last edit was 11/4/21

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.lang.Math;

public class Calculator implements ActionListener {

   //member data of class, made private
   private static JFrame frame;
   private static JPanel panel;
   private static JTextField output;
      
   //method buttons
   private static JButton clearButton;
   private static JButton equalsButton;
   private static JButton percentButton;
   private static JButton addButton;
   private static JButton subtractButton;
   private static JButton multiplyButton;
   private static JButton divideButton;
   private static JButton changeSignButton;
   private static JButton decimalButton;
   private static JButton exponentButton;
      
   //number buttons
   private static JButton zero;
   private static JButton one;
   private static JButton two;
   private static JButton three;
   private static JButton four;
   private static JButton five;
   private static JButton six;
   private static JButton seven;
   private static JButton eight;
   private static JButton nine;
   
   private static double num1 = 0;
   private static double num2 = 0;
   private static double result = 0;
   
   private static char sign = '\0';
      
   private static Font customFont = new Font("Verdana",Font.ITALIC,20);      
   
   public static void main(String[] args){
       
      //creating a new frame
      frame = new JFrame();
      frame.setSize(500,500);
      frame.setTitle("Russell's Calculator");
      frame.setLocationRelativeTo(null);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setResizable(false);
      frame.setLayout(null);
      
      panel = new JPanel();
      panel.setBounds(5, 100, 490, 370);
      panel.setLayout(new GridLayout(5, 5, 10, 10));
      
      //handling the output label
      output = new JTextField(); 
      output.setBounds(10, 5, 475, 100);
      output.setHorizontalAlignment(JTextField.CENTER);
      output.setFont(customFont);
      output.setEditable(false);
      
      //creating operator buttons
      equalsButton = new JButton("=");
      equalsButton.addActionListener(new Calculator());
      
      clearButton = new JButton("C");
      clearButton.addActionListener(new Calculator());
      
      decimalButton = new JButton(".");
      decimalButton.addActionListener(new Calculator());
      
      addButton = new JButton("+");
      addButton.addActionListener(new Calculator());
      
      subtractButton = new JButton("-");
      subtractButton.addActionListener(new Calculator());
  
      multiplyButton = new JButton("*");
      multiplyButton.addActionListener(new Calculator());
      
      divideButton = new JButton("/");
      divideButton.addActionListener(new Calculator());
      
      changeSignButton = new JButton("+/-");
      changeSignButton.addActionListener(new Calculator());
      
      percentButton = new JButton("%");
      percentButton.addActionListener(new Calculator());
      
      exponentButton = new JButton("^");
      exponentButton.addActionListener(new Calculator());
      
      //creating number buttons
      zero = new JButton("0");
      zero.addActionListener(new Calculator());
      
      one = new JButton("1");
      one.addActionListener(new Calculator());
      
      two = new JButton("2");
      two.addActionListener(new Calculator());
      
      three = new JButton("3");
      three.addActionListener(new Calculator());
      
      four = new JButton("4");
      four.addActionListener(new Calculator());
      
      five = new JButton("5");
      five.addActionListener(new Calculator());
      
      six = new JButton("6");
      six.addActionListener(new Calculator());
      
      seven = new JButton("7");
      seven.addActionListener(new Calculator());
      
      eight = new JButton("8");
      eight.addActionListener(new Calculator());
      
      nine = new JButton("9");
      nine.addActionListener(new Calculator());
      
      
      //adding buttons to the panel in standard order
      panel.add(clearButton);
      panel.add(changeSignButton);
      panel.add(percentButton);
      panel.add(divideButton);
      
      panel.add(seven);
      panel.add(eight);
      panel.add(nine);
      panel.add(multiplyButton);
      
      panel.add(four);
      panel.add(five);
      panel.add(six);
      panel.add(subtractButton);
      
      panel.add(one);
      panel.add(two);
      panel.add(three);
      panel.add(addButton);
      
      panel.add(zero);
      panel.add(decimalButton);
      panel.add(exponentButton);
      panel.add(equalsButton);
      
      panel.setBackground(Color.BLACK);
      frame.add(panel);
      frame.add(output);
      frame.setVisible(true);
   
      return;
   }
   
   public void actionPerformed(ActionEvent e) {
      
      String str = "";
      
      if (e.getSource() == equalsButton){
         
         if (sign == '+'){
            num2 = Double.parseDouble(output.getText());
            result = num1 + num2;
         }
         else if (sign == '-'){
            num2 = Double.parseDouble(output.getText());
            result = num1 - num2;
         }
         else if (sign == '*'){
            num2 = Double.parseDouble(output.getText());
            result = num1 * num2;
         }
         else if (sign == '/'){
            num2 = Double.parseDouble(output.getText());
            result = num1 / num2;
         }
         else if (sign == '^'){
            num2 = Double.parseDouble(output.getText());
            double temp2 = num1;
            result = num1;
            for (double i = 1; i < num2; i++){
               result = result * temp2;
            }
         }
         
         output.setText(str.valueOf(result));
         num1 = result;
      }
      if (e.getSource() == clearButton){
         output.setText("");
      }
      if (e.getSource() == decimalButton){
         str = output.getText();
         str = str + ".";
         output.setText(str);
      }  
      if (e.getSource() == percentButton){
         num1 = Double.parseDouble(output.getText());
         num1 = num1 / 100;
         output.setText(String.valueOf(num1));
      }
      if (e.getSource() == changeSignButton){
         double temp = Double.parseDouble(output.getText());
         if (temp < 0){
            temp = Math.abs(temp);
         }
         else {
            temp = temp * -1;
         }
         
         output.setText(String.valueOf(temp));
      }
      if (e.getSource() == addButton){
         num1 = Double.parseDouble(output.getText());
         sign = '+';
         output.setText("");
      }
      if (e.getSource() == subtractButton){
         num1 = Double.parseDouble(output.getText());   
         sign = '-';  
         output.setText("");            
      }
      if (e.getSource() == multiplyButton){
         str = output.getText();
         num1 = Double.parseDouble(str);
         sign = '*';
         output.setText("");
      }
      if (e.getSource() == divideButton){
         num1 = Double.parseDouble(output.getText());
         sign = '/';
         output.setText("");
      }
      if (e.getSource() == exponentButton){
         num1 = Double.parseDouble(output.getText());
         sign = '^';
         output.setText("");
      }
      if (e.getSource() == zero){
         output.setText(output.getText().concat(String.valueOf(0)));
      }
      if (e.getSource() == one){
         output.setText(output.getText().concat(String.valueOf(1)));
      }
      if (e.getSource() == two){
         output.setText(output.getText().concat(String.valueOf(2)));
      }
      if (e.getSource() == three){
         output.setText(output.getText().concat(String.valueOf(3)));
      }
      if (e.getSource() == four){
         output.setText(output.getText().concat(String.valueOf(4)));
      }
      if (e.getSource() == five){
         output.setText(output.getText().concat(String.valueOf(5)));
      }
      if (e.getSource() == six){
         output.setText(output.getText().concat(String.valueOf(6)));
      }
      if (e.getSource() == seven){
         output.setText(output.getText().concat(String.valueOf(7)));
      }
      if (e.getSource() == eight){
         output.setText(output.getText().concat(String.valueOf(8)));
      }
      if (e.getSource() == nine){
         output.setText(output.getText().concat(String.valueOf(9)));
      }      
          
   }


}