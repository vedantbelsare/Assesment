package Assessment;

import java.util.Scanner;

import org.omg.CORBA.CustomMarshal;
class Customer{
	private int id;
	private String name;
	private String Email;
	private int mobileno;

	public Customer(int id, String name, String email, int mobileno) {
	this.id = id;
	this.name = name;
	Email = email;
	this.mobileno = mobileno;
	}
	public int getId() {
	return id;
	}
	public void setId(int id) {
	this.id = id;
	}
	public String getName() {
	return name;
	}
	public void setName(String name) {
	this.name = name;
	}
	public String getEmail() {
	return Email;
	}
	public void setEmail(String email) {
	Email = email;
	}
	public int getMobileno() {
	return mobileno;
	}
	public void setMobileno(int mobileno) {
	this.mobileno = mobileno;
	}
	
	@Override
	public String toString() {
	return "Customer [id=" + id + ", name=" + name + ", Email=" + Email + ", mobileno=" + mobileno + "]";
	}
	public void addCustomerDetails(int id,String name,String email,int mobileno)
	{
	Customer c=new Customer(id, name, email, mobileno);
	}
	public void printCustomerDetails(){
	System.out.println("Customer[id ="+id+", name = "+name+", email ="+Email+", mobile no ="+mobileno+" ]");
	}
	public void editCustomer(int id,String name,String email,int mobileno)
	{
	this.Email=email;
	this.id=id;
	this.mobileno=mobileno;
	this.name=name;
	}
	
}

public class Assessment1 {
	public static void main(String args[]){
	
	Scanner scan=new Scanner(System.in);
	String UserId=scan.next();
	String pass=scan.next();
	if(UserId.equals("ABCCust") && pass.equals("abc@123"))
	{
	System.out.println("you arelogged in successfully\n\n");
	Customer[] customers=new Customer[10];
	customers[0]=new Customer(1, "abc", "abc", 123);
	customers[1]=new Customer(2, "def", "def", 567);
	customers[2]=new Customer(3, "ghi", "ghi", 890);
	customers[3]=null;
	customers[4]=null;
	customers[5]=null;
	customers[6]=null;
	customers[7]=null;
	customers[8]=null;
	customers[9]=null;
	
	boolean ch=true;
	while(ch){
	
	System.out.println("1.Add customer details");
	System.out.println("2.Print customer details");
	System.out.println("3.Edit Existing Details");
	System.out.println("4.Delete Existing customer details");
	System.out.println("5.exit");
	System.out.println("enter your choice:");
	int c=scan.nextInt();
	
	if(c==1)
	{
	System.out.print("enter the user id:");
	int id=scan.nextInt();
	System.out.print("enter the name:");
	String name=scan.next();
	System.out.print("enter the email:");
	String email=scan.next();
	System.out.print("enter the mobile no:");
	int mobileno=scan.nextInt();
	for(int i=0;i<10;i++)
	{
	boolean flag=true;
	System.out.println("A"+i);
	if(customers[i]==null)
	{
	System.out.println("A2");
	customers[i]=new Customer(id,name,email,mobileno);
	System.out.println("successfully inserted");
	flag=false;
	}
	if(flag==false)
	{
	break;
	}
	}
	}
	else if(c==2)
	{
	System.out.print("enter the customer id:");
	int id=scan.nextInt();
	for(int i=0;i<10;i++)
	{
	if(customers[i]!=null){
	if(customers[i].getId()==id){
	
	customers[i].printCustomerDetails();
	}
	}
	}
	}
	else if(c==3)
	{
	System.out.print("enter the customer id:");
	int id=scan.nextInt();
	System.out.print("enter the new name:");
	String name=scan.next();
	System.out.print("enter the new email:");
	String email=scan.next();
	System.out.print("enter the new mobile no:");
	int mobileno=scan.nextInt();
	for(int i=0;i<10;i++)
	{
	if(customers[i]!=null){
	if(customers[i].getId()==id){
	customers[i].editCustomer(id, name, email, mobileno);
	}
	}
	}
	}
	
	else if(c==4)
	{
	System.out.print("enter the customer id:");
	int id=scan.nextInt();
	for(int i=0;i<10;i++)
	{
	if(customers[i]!=null){
	if(customers[i].getId()==id){
	
	customers[i]=null;
	}
	}
	}
	}
	else if(c==5)
	{
	System.out.println("thank you");
	ch=false;
	}
	}
	

}
	else
	{
	System.out.println("the credentials are wrong");
	}
}
}
