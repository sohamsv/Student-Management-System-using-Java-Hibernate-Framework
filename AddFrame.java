
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
@SuppressWarnings("unchecked")

class InvalidRollnoException extends Exception {
String msg;
InvalidRollnoException(String msg) {
this.msg= msg;
}
}

class EmptyNameException extends Exception {
String msg1;
EmptyNameException(String msg1) {
this.msg1= msg1;
}
}

class OnlyAlphabetException extends Exception {
String msg2;
OnlyAlphabetException(String msg2) {
this.msg2= msg2;
}
}

class InvalidNameException extends Exception {
String msg3;
InvalidNameException(String msg3) {
this.msg3= msg3;
}
}

class InvalidMarksException1 extends Exception {
String msg4;
InvalidMarksException1(String msg4) {
this.msg4= msg4;
}
}
class InvalidMarksException2 extends Exception {
String msg5;
InvalidMarksException2(String msg5) {
this.msg5= msg5;
}
}
class InvalidMarksException3 extends Exception {
String msg6;
InvalidMarksException3(String msg6) {
this.msg6= msg6;
}
}

class AddFrame extends JFrame {
Container c;
JLabel lblRno, lblName, lblSub1, lblSub2, lblSub3;
JTextField txtRno, txtName , txtSub1 ,txtSub2 , txtSub3;
JButton btnSave, btnBack;

AddFrame() {
c = getContentPane();	
c.setLayout(new FlowLayout());
lblRno = new JLabel("enter Rno");
txtRno = new JTextField(20);
lblName = new JLabel("enter name");
txtName = new JTextField(20);
lblSub1 = new JLabel("enter sub marks 1:");
txtSub1 = new JTextField(20);
lblSub2 = new JLabel("enter sub marks 2:");
txtSub2 = new JTextField(20);
lblSub3 = new JLabel("enter sub marks 3:");
txtSub3 = new JTextField(20);


btnSave = new JButton("Save");
btnBack = new JButton("Back");
c.add(lblRno);
c.add(txtRno);
c.add(lblName);
c.add(txtName);
c.add(lblSub1);
c.add(txtSub1);
c.add(lblSub2);
c.add(txtSub2);
c.add(lblSub3);
c.add(txtSub3);
c.add(btnSave);
c.add(btnBack);

ActionListener a1 = (ae) -> {
MainFrame af = new MainFrame();
dispose();
};
btnBack.addActionListener(a1);

ActionListener a2 = (ae) -> {
int rno = 0;
try{
rno = Integer.parseInt(txtRno.getText());
if (rno == 0)
	throw new InvalidRollnoException("Rollno cannot be zero");
}

catch(NumberFormatException e) {
	JFrame f = new JFrame();
	JOptionPane.showMessageDialog(f,"Please enter a roll number");
	return;
}
catch(InvalidRollnoException e) {
	JFrame u = new JFrame();
	JOptionPane.showMessageDialog(u,e.msg);
	return;
}
String name="";
try {

name = txtName.getText();
if(name.isEmpty())
	throw new EmptyNameException("Name Cannot be Empty");
else if(!name.matches("^[a-zA-Z]*$"))
	throw new OnlyAlphabetException("Name should contain only alphabets");
else if(name.length()<2)
	throw new InvalidNameException("Name cannot contain less than two alphabets");
}

catch(EmptyNameException e) {
	JFrame t = new JFrame();
	JOptionPane.showMessageDialog(t,e.msg1);
	return;
}
catch(OnlyAlphabetException e) {
	JFrame r = new JFrame();
	JOptionPane.showMessageDialog(r,e.msg2);
	return;
}
catch(InvalidNameException e) {
	JFrame h = new JFrame();
	JOptionPane.showMessageDialog(h,e.msg3);
	return;
}
int s1 = 0;
try{
s1 = Integer.parseInt(txtSub1.getText());
if (s1<0 || s1>100)
	throw new InvalidMarksException1("Marks cannot be less than zero & greater than 100");
}

catch(NumberFormatException e) {
	JFrame f = new JFrame();
	JOptionPane.showMessageDialog(f,"Please enter Marks for subject1");
	return;
}
catch(InvalidMarksException1 e) {
	JFrame g = new JFrame();
	JOptionPane.showMessageDialog(g,e.msg4);
	return;
}
int s2 = 0;
try{
s2 = Integer.parseInt(txtSub2.getText());
if (s2<0 || s2>100)
	throw new InvalidMarksException2("Marks cannot be less than zero & greater than 100");
}

catch(NumberFormatException e) {
	JFrame f = new JFrame();
	JOptionPane.showMessageDialog(f,"Please enter Marks for subject2");
	return;
}
catch(InvalidMarksException2 e) {
	JFrame x = new JFrame();
	JOptionPane.showMessageDialog(x,e.msg5);
	return;
}

int s3 = 0;
try{
s3 = Integer.parseInt(txtSub3.getText());
if (s3<0 || s3>100)
	throw new InvalidMarksException3("Marks cannot be less than zero & greater than 100");
}

catch(NumberFormatException e) {
	JFrame f = new JFrame();
	JOptionPane.showMessageDialog(f,"Please enter Marks for subject3");
	return;
}
catch(InvalidMarksException3 e) {
	JFrame x = new JFrame();
	JOptionPane.showMessageDialog(x,e.msg6);
	return;
}

DbHandler db = new DbHandler();
db.addStudent(rno, name,s1 ,s2 ,s3);
};
btnSave.addActionListener(a2);



setTitle("Add Student");
setSize(300, 300);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
Color c = new Color(200,200,255); 
getContentPane().setBackground(c);
setVisible(true);
}
}