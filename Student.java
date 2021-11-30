class Student {
private int rno;
public String name;
private int s1;
private int s2;
private int s3;

public Student(){}

public Student(int rno, String name, int s1, int s2 , int s3) {

this.rno = rno;
this.name = name;
this.s1 = s1;
this.s2 = s2;
this.s3 = s3;
}

public void setrno(int rno) {
	this.rno = rno;
}

public int getrno() {
	return rno;
}

public void setname(String name) {
	this.name = name;
}

public String getname() {
	return name;
}

public void sets1(int s1) {
	this.s1 = s1;
}

public int gets1() {
	return s1;
}
public void sets2(int s2) {
	this.s2 = s2;
}

public int gets2() {
	return s2;
}
public void sets3(int s3) {
	this.s3 = s3;
}

public int gets3() {
	return s3;
}
}