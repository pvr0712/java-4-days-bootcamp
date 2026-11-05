package swing;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Calculator {

	int boardWidth=360;
	int boardHeight=540;
	Color lightgrey=new Color(212,212,210);
	Color darkgrey=new Color(80,80,80);
	Color black=new Color(28,28,28);
	Color orange=new Color(255,149,0);
	
	String[] buttonValues= {
			"AC","+/-","%","+",
			"7","8","9","*",
			"4","5","6","-",
			"1","2","3","/",
			"0",".","nil","="
	};
	
	String[]rightsymbols= {
			"+","*","-","/","="
	};
	
	String[] topsymbols= {
			"AC","+/-","%"
	};
	
	JFrame frame=new JFrame("Calculator");
	JLabel displaylabel=new JLabel();
	JPanel displaypanel=new JPanel();
	JPanel buttonspanel=new JPanel();
	
	String A="0";
	String operator=null;
	String B=null;
	
	Calculator()
	{
		frame.setSize(boardWidth,boardHeight);
		frame.setLocationRelativeTo(null);
		
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		
		displaylabel.setBackground(black);
		displaylabel.setForeground(Color.WHITE);
		displaylabel.setFont(new Font("Arial",Font.PLAIN,80));
		displaylabel.setHorizontalAlignment(JLabel.RIGHT);
		displaylabel.setText("0");
		displaylabel.setOpaque(true);
		displaypanel.setLayout(new BorderLayout());
		displaypanel.add(displaylabel);
		
		frame.add(displaypanel,BorderLayout.NORTH);
		
		buttonspanel.setLayout(new GridLayout(5,4));
		buttonspanel.setBackground(black);
		frame.add(buttonspanel);
		
		for(int i=0;i<buttonValues.length;i++)
		{
			JButton button=new JButton();
			String buttonValue=buttonValues[i];
			button.setFont(new Font("Arial",Font.PLAIN,30));
			button.setText(buttonValue);
			button.setFocusable(false);
			
			
			button.setBorder(new LineBorder(black));
			
			if(Arrays.asList(topsymbols).contains(buttonValue))
			{
				button.setBackground(lightgrey);
				button.setForeground(black);
			}
			else if(Arrays.asList(rightsymbols).contains(buttonValue))
			{
				button.setBackground(orange);
				button.setForeground(Color.WHITE);
			}
			else
			{
				button.setBackground(darkgrey);
				button.setForeground(Color.WHITE);	
			}
			
			buttonspanel.add(button);
			
			button.addActionListener(new ActionListener()
					{
				     @Override
				     public void actionPerformed(ActionEvent e)
				     {
				    	 JButton clickedButton=(JButton)e.getSource();
				    	 String value=clickedButton.getText();
				    	 
				    	 if(Arrays.asList(rightsymbols).contains(value))
				    	 {
				    	   if(value.equals("="))
				    	   {
				    		   if(operator!=null && A!=null)
				    		   {
				    			   B=displaylabel.getText();
				    			   double numA=Double.parseDouble(A);
				    			   double numB=Double.parseDouble(B);
				    			   double result=0;
				    			   
				    			   if(operator.equals("+"))
				    			   {
				    				   result=numA+numB;
				    			   }
				    			   else if(operator.equals("-"))
				    			   {
				    				   result=numA-numB;
				    			   }
				    			   else if(operator.equals("*"))
				    			   {
				    				   result=numA*numB;
				    			   }
				    			   else if(operator.equals("/"))
				    			   { 
				    				   if(numB==0)
				    				   {
				    					   displaylabel.setText("Cannot divide by 0");
				    					   clearAll();
				    					   return;
				    				   }
				    				   result=numA/numB;
				    			   }
				    			   displaylabel.setText(removezero(result));
				    			   clearAll();
				    			   }
				    	   }
				    	   else
				    	   {
				    		   if(operator==null)
				    		   {
				    			  A=displaylabel.getText();
				    			  displaylabel.setText("0");
				    		   }
				    		   operator=value;
				    		   }
				         }
				    	 else if(Arrays.asList(topsymbols).contains(value))
				    	 {
				    		if(value.equals("+/-"))
				    		{
				    			double number=Double.parseDouble(displaylabel.getText());
				    		    number*=-1;
				    		    displaylabel.setText(removezero(number));
				    		}
				    		else if(value.equals("AC"))
				    		{
				    			clearAll();
				    			displaylabel.setText("0");
				    		}
				    		else if(value.equals("%"))
				    		{
				    			double number=Double.parseDouble(displaylabel.getText());
				    			number=number/100;
				    			displaylabel.setText(removezero(number));
				    		}
				    	 }
				    	 else if(value.equals("."))
				    		 {
				    			if(!displaylabel.getText().contains("."))
				    			{
				    				displaylabel.setText(displaylabel.getText()+".");
				    			}
				    		 }
				    	 else if(value.length()==1 && "0123456789".contains(value))
				    		 {
				    			if(displaylabel.getText().equals("0"))
				    			{
				    				displaylabel.setText(value);
				    			}
				    			else
				    			{
				    				displaylabel.setText(displaylabel.getText()+value);
				    			}
				    		 }
				    	 }
				     }
			        );
		}
		frame.setVisible(true);
		
	}
	
	void clearAll()
	{
		A="0";
		operator=null;
		B=null;
	}
	String removezero(double number){
		if(number%1==0)
			{
				return Integer.toString((int) number);
			}
		else
		{
		  return Double.toString(number);
		}
	}
	

}