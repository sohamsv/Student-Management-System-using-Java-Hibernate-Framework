import java.sql.*;
import javax.swing.*;
import org.hibernate.*;
import org.hibernate.cfg.*;
import java.io.*;
import java.util.*;
import java.util.logging.Logger;
import org.apache.log4j.*;



@SuppressWarnings("unchecked")
class DbHandler extends JPanel {
public static void disableWarning() {
	System.err.close();
	System.setErr(System.out);
}
public static void addStudent(int rno, String name, int s1 ,int s2, int s3) {
System.err.close();
	System.setErr(System.out);
Configuration cfg = new Configuration();
cfg.configure("hibernate.cfg.xml");

SessionFactory sfact = cfg.buildSessionFactory();
Session session = null;
Transaction t = null;
try {
	
	session = sfact.openSession();
	System.out.println("connected "+ session.isConnected());
	System.out.println("status "+session.isOpen());
	t = session.beginTransaction();

	Student s = new Student(rno, name, s1, s2 ,s3);
	session.save(s);
	t.commit();
	JFrame f = new JFrame();
  	JOptionPane.showMessageDialog(f," Record Added");
	

} catch(Exception e) {
	System.out.println("issue " + e);
	e.printStackTrace();
	if(t!=null)
	t.rollback();
} finally {
	if (session != null) {
		session.close();
		System.out.println("disconnected ");
	}
}
}
public static String viewStudent() {
System.err.close();
	System.setErr(System.out);
Configuration cfg = new Configuration();
cfg.configure("hibernate.cfg.xml");

SessionFactory sfact = cfg.buildSessionFactory();
Session session = null;
String data = "";
try {
	
	session = sfact.openSession();
	System.out.println("connected");
	List<Student> studentlist = new ArrayList<>();
	studentlist = session.createQuery("from Student").list();
	for(Student s: studentlist)
		data = data + ("r: "+s.getrno() + " " + "n: "+s.getname() + " " + "s1: "+s.gets1() + " " + "s2: "+s.gets2() + " " + "s3: "+s.gets3()+"\n");

} catch(Exception e) {
	System.out.println("issue " + e);
	
} finally {
	if (session != null) {
		session.close();
		System.out.println("disconnected ");
	}
}

return data;
}
public static void updateStudent(int rno, String name, int s1 ,int s2, int s3) {
System.err.close();
	System.setErr(System.out);
Configuration cfg = new Configuration();
cfg.configure("hibernate.cfg.xml");

SessionFactory sfact = cfg.buildSessionFactory();
Session session = null;
Transaction t = null;
try {
	session = sfact.openSession();
	System.out.println("connected ");

	t = session.beginTransaction();
	Console c = System.console();
	Student s = (Student)session.get(Student.class, rno);
	if (s == null) {
		System.out.println(rno + " not found ");
	} else {
		
		s.setname(name);
		s.sets1(s1);
		s.sets2(s2);
		s.sets3(s3);
		session.save(s);
		t.commit();
		JFrame k = new JFrame();
		JOptionPane.showMessageDialog(k," Record Updated");
	}
}catch(Exception e) {
	System.out.println("issue " + e);
	t.rollback();
} finally {
	if (session != null) {
		session.close();
		System.out.println("disconnected ");
	}
}	//end of finally
}

public static void deleteStudent(int rno) {
System.err.close();
	System.setErr(System.out);
Configuration cfg = new Configuration();
cfg.configure("hibernate.cfg.xml");

SessionFactory sfact = cfg.buildSessionFactory();
Session session = null;
Transaction t = null;
try {
	session = sfact.openSession();
	System.out.println("connected");
	
	t = session.beginTransaction();
	Console c = System.console();
	Student s = (Student)session.get(Student.class,rno);
	if ( s == null) {
		JFrame d = new JFrame();
		JOptionPane.showMessageDialog(d,"rno:"+rno + " " + "not found");
	} else {
		session.delete(s);
		t.commit();
		JFrame m = new JFrame();
		JOptionPane.showMessageDialog(m," Record Deleted");
	}
		
	
} catch(Exception e) {
	System.out.println("issue " + e);
	t.rollback();
} finally {
	if (session != null) {
		session.close();
		System.out.println("disconnected ");
	}
}	//end of finally
}
}



