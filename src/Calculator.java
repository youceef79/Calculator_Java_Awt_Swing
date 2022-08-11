import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.rmi.server.Operation;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.BorderUIResource.EmptyBorderUIResource;

import org.w3c.dom.events.Event;
import org.w3c.dom.events.EventListener;

import javax.swing.border.LineBorder;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Rectangle;
import java.awt.Point;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import java.awt.Cursor;
import java.awt.ComponentOrientation;
import javax.swing.DebugGraphics;
import javax.swing.UIManager;

@SuppressWarnings("serial")
public class Calculator extends JFrame implements ActionListener{
     
	JButton b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,beq,bmin,bplu,bmul,bdiv,bini,bdot,bdel;
	float res;
	String op;
	float op1 ,op2;
	JLabel result;
	String num1 , num2;
	String errorInf;
	int offY= this.getLocation().y , offX= this.getLocation().x;
	private JButton reduce;
	

	public Calculator() {
		setBackground(Color.WHITE);
		getContentPane().setLocation(new Point(0, 0));
		setUndecorated(true);
		setResizable(false);
		
	
    	this.setSize(366, 374);
  		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  		this.setTitle("CALCULATRICE");
  		 //this.setUndecorated(true);
    	this.setLocationRelativeTo(null);
    	
    	
    	  
  		JPanel panelPr = (JPanel)this.getContentPane();
		panelPr.setLayout(null);
		panelPr.setBackground(new Color(255, 255, 255));
		
		JButton close = new JButton("");
		close.setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
		close.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		close.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0)));
		close.setBackground(new Color(43, 39, 35));
		close.setForeground(new Color(0,0,0));
		close.setToolTipText("close");
		close.setFocusable(false);
		close.setIcon(new ImageIcon("C:\\Users\\rhoub\\Desktop\\delete_26px.png"));
		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		
		close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				close.setContentAreaFilled(true);
				close.setBackground(new Color(255,0,0));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
					close.setContentAreaFilled(true);
					close.setBackground(new Color(43,39,35));	
			}
			
		});
		
		reduce = new JButton("-");
		reduce.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		reduce.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0)));
		reduce.setBackground(new Color(43, 39, 35));
		reduce.setForeground(new Color(0,0,0));
		reduce.setFont(new Font("SansSerif", Font.PLAIN, 40));
		reduce.setForeground(Color.WHITE);
		reduce.setToolTipText("resize");
		reduce.setFocusable(false);
		reduce.setBounds(248, 0, 57, 35);
		reduce.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setState(JFrame.ICONIFIED);
			}
		});
		getContentPane().add(reduce);
		close.setBounds(310, 0, 57, 35);
		getContentPane().add(close);
		result = new JLabel("125487");
		result.setLocation(new Point(20, 20));
		result.setFont(new Font("Arial", Font.BOLD, 30));
		result.setBounds(18, 46, 331, 44);
		panelPr.add(result);
		result.setHorizontalAlignment(SwingConstants.RIGHT);
		result.setBackground(Color.BLACK);
		
		JPanel panel = new JPanel();
		panel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		panel.setLocation(new Point(20, 20));
		panelPr.add(panel);
		panel.setBackground(new Color(43,39,35));
		panel.setBounds(0, 94, 364, 280);
		panel.setLayout(null);
		
		b7 = new JButton("7");
		b7.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.scrollbar, SystemColor.scrollbar, SystemColor.scrollbar, SystemColor.scrollbar));
		b7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		b7.setLocation(new Point(20, 20));
		b7.setBounds(8, 11, 73, 42); 
		b7.setFocusable(false);
		b7.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 30));
		b7.setBackground(Color.WHITE);
		panel.add(b7);
		
		b8 = new JButton("8");
		b8.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.scrollbar, SystemColor.scrollbar, SystemColor.scrollbar, SystemColor.scrollbar));
		b8.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		b8.setLocation(new Point(20, 20));
		b8.setBounds(92, 11, 82, 42); b8.setFocusable(false);
		b8.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 30));
		b8.setBackground(Color.WHITE);
		panel.add(b8);
		
		b9 = new JButton("9");
		b9.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.scrollbar, SystemColor.scrollbar, SystemColor.scrollbar, SystemColor.scrollbar));
		b9.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		b9.setLocation(new Point(20, 20));
		b9.setBounds(185, 11, 82, 42); b9.setFocusable(false);
		b9.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 30));
		b9.setBackground(Color.WHITE);
		panel.add(b9);
		
		bdiv = new JButton("/");
		bdiv.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.scrollbar, SystemColor.scrollbar, SystemColor.scrollbar, SystemColor.scrollbar));
		bdiv.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bdiv.setLocation(new Point(20, 20));
		bdiv.setBounds(277, 11, 82, 42); bdiv.setFocusable(false);
		bdiv.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 30));
		bdiv.setBackground(Color.WHITE);
		panel.add(bdiv);
		
		b4 = new JButton("4");
		b4.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.scrollbar, SystemColor.scrollbar, SystemColor.scrollbar, SystemColor.scrollbar));
		b4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		b4.setLocation(new Point(20, 20));
		b4.setBounds(8, 64, 73, 42); b4.setFocusable(false);
		b4.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 30));
		b4.setBackground(Color.WHITE);
		panel.add(b4);
		
		b5 = new JButton("5");
		b5.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.scrollbar, SystemColor.scrollbar, SystemColor.scrollbar, SystemColor.scrollbar));
		b5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		b5.setLocation(new Point(20, 20));
		b5.setBounds(92, 64, 82, 42); b5.setFocusable(false);
		b5.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 30));
		b5.setBackground(Color.WHITE);
		panel.add(b5);
		
		b6 = new JButton("6");
		b6.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.scrollbar, SystemColor.scrollbar, SystemColor.scrollbar, SystemColor.scrollbar));
		b6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		b6.setLocation(new Point(20, 20));
		b6.setBounds(185, 64, 82, 42); b6.setFocusable(false);
		b6.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 30));
		b6.setBackground(Color.WHITE);
		panel.add(b6);
		
		bmul = new JButton("*");
		bmul.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.scrollbar, SystemColor.scrollbar, SystemColor.scrollbar, SystemColor.scrollbar));
		bmul.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bmul.setLocation(new Point(20, 20));
		bmul.setBounds(277, 64, 82, 42); bmul.setFocusable(false);
		bmul.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 30));
		bmul.setBackground(Color.WHITE);
		panel.add(bmul);
		
		b3 = new JButton("3");
		b3.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.scrollbar, SystemColor.scrollbar, SystemColor.scrollbar, SystemColor.scrollbar));
		b3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		b3.setLocation(new Point(20, 20));
		b3.setBounds(185, 117, 82, 42); b3.setFocusable(false);
		b3.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 30));
		b3.setBackground(Color.WHITE);
		
		b2 = new JButton("2");
		b2.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.scrollbar, SystemColor.scrollbar, SystemColor.scrollbar, SystemColor.scrollbar));
		b2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		b2.setLocation(new Point(20, 20));
		b2.setBounds(92, 117, 82, 42); b2.setFocusable(false);
		b2.setForeground(Color.BLACK);
		
		b1 = new JButton("1");
		b1.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.scrollbar, SystemColor.scrollbar, SystemColor.scrollbar, SystemColor.scrollbar));
		b1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		b1.setLocation(new Point(20, 20));
		b1.setBounds(8, 117, 73, 42); b1.setFocusable(false);
		b1.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 30));
		b1.setBackground(Color.WHITE);
		panel.add(b1);
		b2.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 30));
		b2.setBackground(Color.WHITE);
		panel.add(b2);
		panel.add(b3);
		
		bplu = new JButton("+");
		bplu.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.scrollbar, SystemColor.scrollbar, SystemColor.scrollbar, SystemColor.scrollbar));
		bplu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bplu.setLocation(new Point(20, 20));
		bplu.setBounds(277, 117, 82, 42);  bplu.setFocusable(false);
		bplu.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 30));
		bplu.setBackground(Color.WHITE);
		panel.add(bplu);
		
		bdot = new JButton(",");
		bdot.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.scrollbar, SystemColor.scrollbar, SystemColor.scrollbar, SystemColor.scrollbar));
		bdot.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bdot.setLocation(new Point(20, 20));
		bdot.setBounds(8, 171, 73, 42); bdot.setFocusable(false);
		bdot.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 30));
		bdot.setBackground(Color.WHITE);
		panel.add(bdot);
		
		b0 = new JButton("0");
		b0.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.scrollbar, SystemColor.scrollbar, SystemColor.scrollbar, SystemColor.scrollbar));
		b0.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		b0.setLocation(new Point(20, 20));
		b0.setBounds(92, 171, 82, 42); b0.setFocusable(false);
		panel.add(b0);
		b0.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 30));
		b0.setBackground(Color.WHITE);
		
		bmin = new JButton("-");
		bmin.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.scrollbar, SystemColor.scrollbar, SystemColor.scrollbar, SystemColor.scrollbar));
		bmin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bmin.setLocation(new Point(20, 20));
		bmin.setBounds(185, 171, 82, 42); bmin.setFocusable(false);
		bmin.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 30));
		bmin.setBackground(Color.WHITE);
		panel.add(bmin);
		
		bini = new JButton("c");
		bini.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.scrollbar, SystemColor.scrollbar, SystemColor.scrollbar, SystemColor.scrollbar));
		bini.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bini.setLocation(new Point(20, 20));
		bini.setBounds(277, 171, 82, 42); bini.setFocusable(false);
		bini.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 30));
		bini.setBackground(Color.WHITE);
		panel.add(bini);
		
		beq = new JButton("=");
		beq.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.scrollbar, SystemColor.scrollbar, SystemColor.scrollbar, SystemColor.scrollbar));
		beq.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		beq.setLocation(new Point(20, 20));
		beq.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 30));
		beq.setBackground(Color.WHITE); beq.setFocusable(false);
		beq.setBounds(93, 224, 266, 42);
		panel.add(beq);
		
		bdel = new JButton("del");
		bdel.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.scrollbar, SystemColor.scrollbar, SystemColor.scrollbar, SystemColor.scrollbar));
		bdel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bdel.setLocation(new Point(20, 20));
		bdel.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 30));
		bdel.setBackground(Color.WHITE); bdel.setFocusable(false);
		bdel.setBounds(8, 224, 73, 42);
		panel.add(bdel);
	
    	  b0.addActionListener(this); b1.addActionListener(this); b2.addActionListener(this); b3.addActionListener(this);
    	  b4.addActionListener(this); b5.addActionListener(this); b6.addActionListener(this); b7.addActionListener(this);
    	  b8.addActionListener(this); b9.addActionListener(this); bplu.addActionListener(this); beq.addActionListener(this);
    	  bini.addActionListener(this); bmul.addActionListener(this); bdiv.addActionListener(this); bmin.addActionListener(this);
    	  bdot.addActionListener(this); bdel.addActionListener(this);
    	  result.setText("0");
    	  
    	  JLabel border = new JLabel("");
    	  border.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    	  border.setBackground(new Color(255, 255, 255));
    	  border.setLocation(new Point(20, 20));
    	  border.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
    	  border.setBounds(0, 0, 367, 374);
    	  getContentPane().add(border);
    	  
    	 this.addMouseListener(new MouseAdapter() {
      		@Override
      		public void mousePressed(MouseEvent e) {
      			offX = e.getX();
      			offY = e.getY();
      		}
      		
  		});
    	 this.addMouseMotionListener(new MouseMotionAdapter() {
    		 
    		 @Override
       		public void mouseDragged(MouseEvent e) {
       			int x = Calculator.this.getLocation().x + e.getX() - offX;
       			int y =  Calculator.this.getLocation().y + e.getY() - offY;
       		    Calculator.this.setLocation(x , y);
       		}
    		 
		});
      	
          errorInf = "cannot divide by 0";
          num1 = num2 = "0"; op1 = 0; op2 = 0; res = 0; op =null;
         }
	 
	@Override
 public void actionPerformed(ActionEvent e) {
		int point;	
		String pointStr;
	if ( e.getSource() == b0 ) { 
		
	if (num1.equals(errorInf)) { num1 = "0"; result.setText(num1); }  
       
	
	if( num1.equals("0") & num2.equals("0")  & op != null) 
		{ 
		  num2 = "0"; 
		  result.setText(num1+op+num2);
		  
		} else if( num1.equals("0") & op != null & !num2.equals("0")  ){
			num2 += "0";
			result.setText(num1+op+num2);
		}
		
	 
	if ( !num1.equals("0") ) {
			
		 if( op == null) {
				num1 += "0";
				result.setText(num1);
				op1 = Float.parseFloat(num1);
				
		} else {
			
	   if (!num2.equals("0")) {
			num2 += "0"; 	
			result.setText(num1+op+num2);
			op2 = Float.parseFloat(num2);
	         
	       } else { num2 = "0"; result.setText(num1+op+num2); op2 = (int)Float.parseFloat(num2);} 
			
          }
       }
		
	}
			
		
		
		if ( e.getSource() == b1 ) {
			
			if ( (num1.equals("0") & op == null) || num1.equals(errorInf)) num1 = ""; 
			
			if( op == null) {
				num1 += "1";
				result.setText(num1);
				op1 = Float.parseFloat(num1);
				
		   } else {
	   if (num2.equals("0")) num2 = ""; 
			num2 += "1"; 	
			result.setText(num1+op+num2);
			op2 = Float.parseFloat(num2);
			
			}


		} 
		
	if ( e.getSource() == b2 ) {
		
		if ( (num1.equals("0") & op == null) || num1.equals(errorInf)) num1 = ""; 
		if( op == null) {
				num1 += "2";
				result.setText(num1);
				op1 = Float.parseFloat(num1);
				
		} else {
			if (num2.equals("0")) num2 = "";	
			num2 += "2"; 	
			result.setText(num1+op+num2);
			op2 = Float.parseFloat(num2);
			
			}
	} 
		
	if ( e.getSource() == b3 ) {
		
		if ( (num1.equals("0") & op == null) || num1.equals(errorInf)) num1 = "";  
		if( op == null) {
			num1 += "3";
			result.setText(num1);
			op1 = Float.parseFloat(num1);
			
	} else {
		if (num2.equals("0")) num2 = "";
		num2 += "3"; 	
		result.setText(num1+op+num2);
		op2 = Float.parseFloat(num2);
		
		}

	} 
		if ( e.getSource() == b4 ) {
			
			if ( (num1.equals("0") & op == null) || num1.equals(errorInf)) num1 = ""; 
			if( op == null) {
				num1 += "4";
				result.setText(num1);
				op1 = Float.parseFloat(num1);
				
		} else {
			if (num2.equals("0")) num2 = "";
			num2 += "4"; 	
			result.setText(num1+op+num2);
			op2 = Float.parseFloat(num2);
			
			}

		} 
		if ( e.getSource() == b5 ) {
			if ( (num1.equals("0") & op == null) || num1.equals(errorInf)) num1 = ""; 
			if( op == null) {
				num1 += "5";
				result.setText(num1);
				op1 = Float.parseFloat(num1);
				
		} else {
			if (num2.equals("0")) num2 = "";
			num2 += "5"; 	
			result.setText(num1+op+num2);
			op2 = Float.parseFloat(num2);
			
			}
	  
		}
		
		if ( e.getSource() == b6 ) {
			
			if ( (num1.equals("0") & op == null) || num1.equals(errorInf)) num1 = ""; 
			if( op == null) {
				num1 += "6";
				result.setText(num1);
				op1 = Float.parseFloat(num1);
				
		} else {
			if (num2.equals("0")) num2 = "";
			num2 += "6"; 	
			result.setText(num1+op+num2);
			op2 = Float.parseFloat(num2);
			
			}

	}
		
		if ( e.getSource() == b7 ) {
			
			if ( (num1.equals("0") & op == null) || num1.equals(errorInf)) num1 = ""; 
			if( op == null) {
				num1 += "7";
				result.setText(num1);
				op1 = Float.parseFloat(num1);
				
		} else {
			if (num2.equals("0")) num2 = "";
			num2 += "7"; 	
			result.setText(num1+op+num2);
			op2 = Float.parseFloat(num2);
			
			}

			
		} 
		if ( e.getSource() == b8 ) {
			
			if ( (num1.equals("0") & op == null) || num1.equals(errorInf)) num1 = ""; 
			if( op == null) {
				num1 += "8";
				result.setText(num1);
				op1 = Float.parseFloat(num1);
				
		} else {
			if (num2.equals("0")) num2 = "";
			num2 += "8"; 	
			result.setText(num1+op+num2);
			op2 = Float.parseFloat(num2);
			
			}

		} 
		
		if ( e.getSource() == b9 ) {
			
			if ( (num1.equals("0") & op == null) || num1.equals(errorInf)) num1 = ""; 
			if( op == null) {
				num1 += "9";
				result.setText(num1);
				op1 = Float.parseFloat(num1);
				
		  } else {
			  
			  if (num2.equals("0")) num2 = "";
			num2 += "9"; 	
			result.setText(num1+op+num2);
			op2 = Float.parseFloat(num2);
			
			}

			
		} 
		
    if ( e.getSource() == bdel ) {
			
			String label = result.getText();
			String  remain = "0";
			
		   if (label.length() == 1 || num1.equals(errorInf) || (label.length() == 2 & label.indexOf("-") == 0) ||
				   label.contains("Inf")) { 
				 result.setText("0"); 
				 num1 = "0"; num2 = "0"; 
				 label = "0"; op = null;
			 }
			 
		    if ( !label.equals("0") ) {
		        remain = label.substring(0, label.length()-1);
		        
               if ( label.indexOf("E") == label.length()-2 ) {
  		        remain = label.substring(0, label.length()-2);
              } 
               
               if ( label.indexOf("E") == label.length()-3 ) {
            	  if(label.length() >= 3) 
            	  remain = label.substring(0, label.length()-3);      
              } 
               
            }
		    
              
              num1 = remain; num2 = "0";	
              
              
           if (op != null ) {
            	            	            	 
			   if ( remain.contains(op) ) {
				   
				   int opIndex = remain.lastIndexOf(op);
				
				  num1 = remain.substring(0, opIndex);
				  num2 = remain.substring(opIndex+1, remain.length());
				  
				if (num2.equals(""))  num2 = "0";
				if (num1.equals("")) {  num1 = num2; num2 = "0";  }
				
			    }
			    
			    if (label.indexOf(op) == label.length()-1) op = null;
             } 
			  op1 = Float.parseFloat(num1);
			  op2 = Float.parseFloat(num2);
		     
			  result.setText(remain);
		   
		}
			
		
        if ( e.getSource() == bdot ) {
			
        	 if (num1.equals(errorInf)) num1 = "0"; 
         
        if( op == null) {
        
        	 if( !result.getText().contains(".")) {
        		
        		num1 += "."; result.setText(num1);
        		
        	}
        	
         } else if( !num2.contains(".") ) {  num2 += "."; result.setText(num1+op+num2); }
        		
   } 
	
	  if ( e.getSource() == bplu ) {
			
			if (num1.equals(errorInf)) num1 = "0";
			
			String opS = "init";
			
			if (op != null) {
			    opS = op;	
			}
			
			op = "+";
			
         if ( result.getText().contains(opS) && !result.getText().endsWith(opS) ) {
	            
			  switch (opS) {
			  case "+":
					res = op1 + op2;
					op1 = res;
					num1= res+"";
					if (num1.endsWith(".0")) {
						  point = num1.indexOf(".");
						  pointStr = num1.substring(point);
					       num1 = num1.replace(pointStr, "");
						}
					num2 = "";
					break;
			   case "*":
					res = op1 * op2;
					op1 = res;
					num1= res+"";
					if (num1.endsWith(".0")) {
						  point = num1.indexOf(".");
						  pointStr = num1.substring(point);
					       num1 = num1.replace(pointStr, "");
						}
					num2 = "";
					break;
				case "/":
					if (op2 != 0)
					res = op1 / op2;
					op1 = res;
					num1= res+"";
					num2 = "";
					break;
				case "-":
					res = op1 - op2;
					op1 = res;
					num1= res+"";
					if (num1.endsWith(".0")) {
						  point = num1.indexOf(".");
						  pointStr = num1.substring(point);
					       num1 = num1.replace(pointStr, "");
						}
					num2 = "";
					break;
				default:
					break;
				}
				
         }
         result.setText(num1+op); 
	} 
		
		if ( e.getSource() == beq ) {
			
			if ( op == "+") {
			res = op1 + op2;
			op1 = res;
			num1 = res+"";
			
			if (num1.endsWith(".0")) {
				  point = num1.indexOf(".");
				  pointStr = num1.substring(point);
			       num1 = num1.replace(pointStr, "");
				}
		}
			if ( op == "*") {
				res = op1 * op2;
				op1 = res;
				num1 = res+"";
				
				if (num1.endsWith(".0")) {
					  point = num1.indexOf(".");
					  pointStr = num1.substring(point);
				       num1 = num1.replace(pointStr, "");
					}
		}
	if ( op == "/") {
		  if (op2 != 0) {
		      res = op1 / op2;
				op1 = res;
				num1 = res+"";
				
				if (num1.endsWith(".0")) {
					  point = num1.indexOf(".");
					  pointStr = num1.substring(point);
				       num1 = num1.replace(pointStr, "");
					} 
				
	           } else {  num1 = errorInf; } 
		 }
     	if ( op == "-") {
				res = op1 - op2;
				op1 = res;
				num1 = res+"";
			
				if (num1.endsWith(".0")) {
				  point = num1.indexOf(".");
				  pointStr = num1.substring(point);
			       num1 = num1.replace(pointStr, "");
				} 
	 	}
     	
			result.setText(num1);
			op2 = 0;
			num2 = "";
            op = null;
		} 
		if ( e.getSource() == bini ) {
            res = 0; op1 = 0; op2 = 0;
            op = null; num1 = num2 = "0";
            result.setText("0");
            
		} 

      if ( e.getSource() == bmul ) {
    	  if (num1.equals(errorInf)) num1 = "0";
    	  String opS="init";
			if (op != null) {
			    opS = op;	
			}
			op = "*";
		if ( result.getText().contains(opS) && !result.getText().endsWith(opS) ) {
	            
			  switch (opS) {
			  case "*":
					res = op1 * op2;
					op1 = res;
					num1= res+"";
					
					if (num1.endsWith(".0")) {
						  point = num1.indexOf(".");
						  pointStr = num1.substring(point);
					       num1 = num1.replace(pointStr, "");
						} 
					num2 = "";
					break;
				case "+":
					res = op1 + op2;
					op1 = res;
					num1= res+"";
					if (num1.endsWith(".0")) {
						  point = num1.indexOf(".");
						  pointStr = num1.substring(point);
					       num1 = num1.replace(pointStr, "");
						}
					num2 = "";
					break;
				case "/":
					if (op2 != 0)
					res = op1 / op2;
					op1 = res;
					num1= res+"";
					num2 = "";
					break;
				case "-":
					res = op1 - op2;
					op1 = res;
					num1= res+"";
					if (num1.endsWith(".0")) {
						  point = num1.indexOf(".");
						  pointStr = num1.substring(point);
					       num1 = num1.replace(pointStr, "");
						}
					num2 = "";
					break;
				default:
					break;
				}
				
			}
			result.setText(num1+op); 		
	}
      
     if ( e.getSource() == bdiv ) {
    	 if (num1.equals(errorInf)) num1 = "0";
    	 String opS="init";
    	   if (op != null) {
			    opS = op;	
			}
    	   op = "/";
			
	    if ( result.getText().contains(opS) && !result.getText().endsWith(opS) ) {
	            
			  switch (opS) {
			  case "/":
				  if (op2 != 0)
					res = op1 / op2;
					op1 = res;
					num1= res+"";
					num2 = "";
					break;

			  case "*":
					res = op1 * op2;
					op1 = res;
					num1= res+"";
					if (num1.endsWith(".0")) {
						  point = num1.indexOf(".");
						  pointStr = num1.substring(point);
					       num1 = num1.replace(pointStr, "");
						}
					num2 = "";
					break;
				case "+":
					res = op1 + op2;
					op1 = res;
					num1= res+"";
					if (num1.endsWith(".0")) {
						  point = num1.indexOf(".");
						  pointStr = num1.substring(point);
					       num1 = num1.replace(pointStr, "");
						}					
					num2 = "";
					break;
				case "-":
					res = op1 - op2;
					op1 = res;
					num1= res+"";
					if (num1.endsWith(".0")) {
						  point = num1.indexOf(".");
						  pointStr = num1.substring(point);
					       num1 = num1.replace(pointStr, "");
						}
					num2 = "";
					break;
				default:
					break;
				}
				
	    } 
	    result.setText(num1+op); 
			
		}
    
      
     if ( e.getSource() == bmin ) {
    	 if ( (num1.equals("0") & op == null) || num1.equals(errorInf)) num1 = "";
    	 String opS="init";
			if (op != null) {
			    opS = op;	
			}
			op = "-";
		 if ( result.getText().contains(opS) && !result.getText().endsWith(opS) ) {
	            
			  switch (opS) {
			  case "-":
					res = op1 - op2;
					op1 = res;
					num1= res+"";
					if (num1.endsWith(".0")) {
						  point = num1.indexOf(".");
						  pointStr = num1.substring(point);
					       num1 = num1.replace(pointStr, "");
						}
					num2 = "";
					break;
				case "*":
					res = op1 * op2;
					op1 = res;
					num1= res+"";
					if (num1.endsWith(".0")) {
						  point = num1.indexOf(".");
						  pointStr = num1.substring(point);
					       num1 = num1.replace(pointStr, "");
						}
					num2 = "";
					break;
				case "/":
					if (op2 != 0)
					res = op1 / op2;
					op1 = res;
					num1= res+"";
					num2 = "";
					break;
				case "+":
					res = op1 + op2;
					op1 = res;
					num1= res+"";
					if (num1.endsWith(".0")) {
						  point = num1.indexOf(".");
						  pointStr = num1.substring(point);
					       num1 = num1.replace(pointStr, "");
						}
					num2 = "";
					break;
				default:
					break;
				}
				
		 }
		   result.setText(num1+op); 
			
		}
     
 }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
         JFrame cal = new Calculator();
         cal.setVisible(true);
	}
}
