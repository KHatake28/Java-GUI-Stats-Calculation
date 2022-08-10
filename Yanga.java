package za.ac.wsu.s221274650;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

    public class Yanga extends JFrame implements ActionListener 
    {


        JLabel lblNumber = new JLabel("Enter Number: ");
        JTextField txtNumber = new JTextField(25);
        JButton btnAdd = new JButton("Add");

        JTextField txtList = new JTextField("List is empty. Add number to do some stats.",40);


        ArrayList<Double> numbersList = new ArrayList<>();


        JButton btnMean = new JButton("Mean");
        JButton btnVariance = new JButton("Variance");
        JButton btnStandardDeviation = new JButton("Standard Deviation");
        JButton btnReset = new JButton("Reset All");



        JPanel inputPanel = new JPanel();
        JPanel listPanel = new JPanel();
        JPanel calculationsPanel = new JPanel();
        JPanel resetPanel = new JPanel();

        double mean;
        double variance;


        Yanga()
        {
            super("Statistics Application");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLayout(new GridLayout(4,1,5,5));
            setVisible(true);


            inputPanel.add(lblNumber);
            inputPanel.add(txtNumber);
            inputPanel.add(btnAdd);
            inputPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
            add(inputPanel);


            txtList.setBorder(BorderFactory.createEtchedBorder());
            txtList.setEditable(false);
            txtList.setHorizontalAlignment(JTextField.CENTER);
            listPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
            listPanel.add(txtList);
            add(listPanel);

            calculationsPanel.add(btnMean);
            calculationsPanel.add(btnVariance);
            calculationsPanel.add(btnStandardDeviation);
            calculationsPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
            add(calculationsPanel);


            btnReset.setForeground(Color.red);
            resetPanel.add(btnReset);
            add(resetPanel);

            btnAdd.addActionListener(this);
            btnMean.addActionListener(this);
            btnVariance.addActionListener(this);
            btnStandardDeviation.addActionListener(this);
            btnReset.addActionListener(this);

            setLocationRelativeTo(null);
            setResizable(false);
            pack();
        }


        @Override
        public void actionPerformed(ActionEvent e) 
        {

            if(e.getSource() == btnAdd){

                if(txtNumber.getText().isEmpty()) 
                {

                    JOptionPane.showMessageDialog(null, "Enter Numbers Only.", "Message", JOptionPane.INFORMATION_MESSAGE);

                }
                else
                	if(!(txtNumber.getText().isEmpty()))
                	{

                    isNumber();
                    updateList();
                	}
                
            }
            else 
            if(e.getSource() == btnMean)
            {

                if(numbersList.isEmpty())
                {

                    JOptionPane.showMessageDialog(null, "List is empty.", "'Message",JOptionPane.INFORMATION_MESSAGE);

                }
                else
                {

                    double total = 0;

                    for(int i = 0; i < numbersList.size();i++)
                    {

                        total += numbersList.get(i);

                    }

                    mean = total/(numbersList.size());

                    String details = "The mean is: " + Double.toString(mean);
                    JOptionPane.showMessageDialog(null, details , "Message", JOptionPane.INFORMATION_MESSAGE);


                }

            }
            else 
            	if(e.getSource() == btnVariance)
            {

                if(numbersList.isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "List is empty.", "'Message",JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {

                    double total = 0;

                    for(int i = 0; i < numbersList.size();i++)
                    {

                        total += Math.pow((numbersList.get(i) - mean),2);

                    }

                    variance = total/(numbersList.size());

                    String details = "The variance is: " + Double.toString(variance);
                    JOptionPane.showMessageDialog(null, details , "Message", JOptionPane.INFORMATION_MESSAGE);




                }

            }
            else
            	if(e.getSource() == btnStandardDeviation)
            {

                if(numbersList.isEmpty())
                {

                    JOptionPane.showMessageDialog(null, "List is empty.", "'Message",JOptionPane.INFORMATION_MESSAGE);

                }
                else
                {

                    double standardDeviation = Math.sqrt(variance);

                    String details = "The Standard Deviation is: " + Double.toString(standardDeviation);
                    JOptionPane.showMessageDialog(null, details , "Message", JOptionPane.INFORMATION_MESSAGE);


                }

            }
            	else
            		if(e.getSource() == btnReset)
            {

                int response = JOptionPane.showConfirmDialog(null, "You are about to clear the list. Are you sure you really want to clear it?", "Clearing the List",JOptionPane.YES_NO_OPTION);

                if(response == 0){

                    numbersList.clear();
                    txtNumber.setText(" ");
                    txtList.setText("List is empty. Add number to do some stats.");


                }
            }


        }

        public void updateList()
        {

            numbersList.add(Double.parseDouble(txtNumber.getText()));

            String listItems = "";

            for(Double counter: numbersList )
            {
                listItems = listItems + Double.toString(counter) + " , ";
            }

            txtList.setText(listItems);

        }


        public boolean isNumber()
        {

            try
            {

                double doubleValue = Double.parseDouble(txtNumber.getText());
                return true;

            }
            catch(NumberFormatException nfe)
            {
                JOptionPane.showMessageDialog(null,"Enter Numbers Only.","Message",JOptionPane.INFORMATION_MESSAGE);
            }
            return false;
        }
        
        public static void main(String args[]) 
        {
            new Yanga();

    }
}
