import java.sql.*;
import java.util.*;
	
public class PayrollMenu {
	//jdbc url
	private final static String url = "jdbc:postgresql:payroll";
	//jdbc user
	private static String user = "";
	//jdbc pass
	private static String pass = "";
	static Connection conn;
	
	// connect promotes for input and takes in a user and pass
	public static void connect(String u,String p) { 
		//set up connection
		try {
			Connection conn = DriverManager.getConnection(url, u, p);
			if (conn != null) {
				System.out.println("Successfully logged in");
			}
			else {
				System.out.println("Login failed");
			}
		}
		
		catch(SQLException e) {
			System.err.print("Invalid username or password \n");
		}
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		//get user input
		System.out.println("Hello, are you an 1.employee, 2.administrator, 3.manager. (input 1, 2, 3)");
		int userType = scan.nextInt();
		
		//if employee call employee interface
		if (userType == 1) {
			//employee
			System.out.println("Please enter your username:");
			user = scan.next();
			scan.nextLine();
			//employee
			System.out.println("Please enter your password:");
			pass = scan.next();
			scan.nextLine();
			
			connect(user, pass);
			EmployeeMenu();
		}
		
		//if admin call admin interface
		else if (userType == 2) {
			//admin
			System.out.println("Please enter your username:");
			user = scan.next();
			//admin
			System.out.println("Please enter your password:");
			pass = scan.next();
			
			connect(user, pass);
			AdminMenu();
		}
		
		//else call manager interface
		else {
			//manager
			System.out.println("Please enter your username:");
			user = scan.next();
			//manager
			System.out.println("Please enter your password:");
			pass = scan.next();
			
			connect(user, pass);			
			ManagerMenu();
		}
	}
	//menus call static methods based on access
	public static void EmployeeMenu() {
		int anotherAction = 1;
		Scanner scan = new Scanner(System.in);
		
		while(anotherAction == 1) {
			//dashboard intro
			System.out.println("Welcome to the employee dashboard. What would you like to do?");
			System.out.println("1. View Salary Report \n"
							 + "2. View Insurance Report\n"
							 + "3. View  Benifits Report\n"
							 + "4. View Tax Report \n"
							 + "5. Update Employee information \n"
							 + "6. Generate w2 Form \n"
							 + "7. Generate Paycheck");
			
			int employeeActionSelect = scan.nextInt();
			switch(employeeActionSelect) {
				case 1:
					salaryReport();
					System.out.println("\n action complete");
					break;
				case 2:
					insuranceReport();
					System.out.println("\n action complete");
					break;
				case 3:
					benefitsReport();
					System.out.println("\n action complete");
					break;
				case 4:
					taxReport();
					System.out.println("\n action complete");
					break;
				case 5:
					updateEmployee();
					System.out.println("\n action complete");
					break;
				case 6:
					generateW2();
					System.out.println("\n action complete");
					break;
				case 7:
					generatePaycheck();
					System.out.println("\n action complete");
					break;
			}
			
			System.out.println("Would you like to perform another action? (1.yes/2.no)");
			anotherAction = scan.nextInt();
		}
	}
	public static void AdminMenu() {
		int anotherAction = 1;
		Scanner scan = new Scanner(System.in);
		while(anotherAction == 1) {
			System.out.println("Welcome to the Admin dashboard. What would you like to do?");
			System.out.println("1. View Salary Report \n"
							 + "2. View Insurance Report\n"
							 + "3. View  Benifits Report\n"
							 + "4. View Tax Report \n"
							 + "5. Delete, Update or Add Employee \n"
							 + "6. Delete, Update or Add Dependant \n"
							 + "7. Delete, Update or Add Insurance \n"
							 + "8. Delete, Update or Add Benefits \n"
							 + "9. Delete, Update or Add Payment \n"
							 + "10. Delete, Update or Add Tax Information \n"
							 + "11. Generate Paycheck for an Employee \n"
							 + "12. Create a New User \n"
							 + "13. Grant User New Permissions \n"
							 + "14. Generate Company Costs \n"
							 + "15. Generate Employee W2 form \n"
							 + "16. Remove User");
			int adminActionSelect = scan.nextInt();
			int addOrUpdate = 0;
			switch(adminActionSelect) {
			//salary report
			case 1:
				salaryReport();
				System.out.println("\n action complete");
				break;
			//insurance report
			case 2:
				insuranceReport();
				System.out.println("\n action complete");
				break;
			//benifit report
			case 3:
				benefitsReport();
				System.out.println("\n action complete");
				break;
			//tax report
			case 4:
				taxReport();
				System.out.println("\n action complete");
				break;
			//insert, update, delete from employee table
			case 5:
				System.out.println("\n 1.Add Employee, 2. Update Employee, 3. Delete Employee");
				addOrUpdate = scan.nextInt();
				if (addOrUpdate == 1) {
					insertEmployee();
				}
				else if (addOrUpdate == 2){
					managmentUpdateEmployee();
				}
				else {
					deleteEmployee();
				}
				System.out.println("\n action complete");
				break;
			//insert, update, delete from dependant table
			case 6:
				System.out.println("\n 1.Add Dependant, 2. Update Dependant, 3. Delete Dependant");
				addOrUpdate = scan.nextInt();
				if (addOrUpdate == 1) {
					insertDependant();
				}
				else if (addOrUpdate == 2){
					updateDependant();
				}
				else {
					deleteDependant();
				}
				System.out.println("\n action complete");
				break;
			//insert, update, delete from Insurance table
			case 7:
				System.out.println("\n 1.Add Insurance, 2. Update Insurance, 3. Delete Insurance");
				addOrUpdate = scan.nextInt();
				if (addOrUpdate == 1) {
					insertInsurance();
				}
				else if (addOrUpdate == 2){
					updateInsurance();
				}
				else {
					deleteInsurance();
				}
				System.out.println("\n action complete");
				break;
			//insert, update, delete from benefits table
			case 8:
				System.out.println("\n 1.Add Benefits, 2. Update Benefits, 3. Delete Benefits");
				addOrUpdate = scan.nextInt();
				if (addOrUpdate == 1) {
					insertBenefits();
				}
				else if (addOrUpdate == 2){
					updateBenefits();
				}
				else {
					deleteBenefits();
				}
				System.out.println("\n action complete");
				break;
			//insert, update, delete from payment table
			case 9:
				System.out.println("\n 1.Add Payment, 2. Update Payment, 3. Delete Payment");
				addOrUpdate = scan.nextInt();
				if (addOrUpdate == 1) {
					insertPayment();
				}
				else if (addOrUpdate == 2){
					updatePayment();
				}
				else {
					deletePayment();
				}
				System.out.println("\n action complete");
				break;
			case 10:
				System.out.println("Would you like to augment 1.Federal Tax, or 2.State Tax");
				int taxChoice = scan.nextInt();
				scan.nextLine();
				if(taxChoice==1) {
					System.out.println("\n 1.Add Federal Tax, 2. Update Federal Tax, 3. Delete Federal Tax");
					addOrUpdate = scan.nextInt();
					if (addOrUpdate == 1) {
						insertFederalTaxRate();
					}
					else if (addOrUpdate == 2){
						updateFederalTaxRate();
					}
					else {
						deleteFederalTaxRate();
					}
					System.out.println("\n action complete");
					
				}
				else {
					System.out.println("\n 1.Add State Tax, 2. Update State Tax, 3. Delete State Tax");
					addOrUpdate = scan.nextInt();
					if (addOrUpdate == 1) {
						insertStateTaxRate();
					}
					else if (addOrUpdate == 2){
						updateStateTaxRate();
					}
					else {
						deleteStateTaxRate();
					}
					System.out.println("\n action complete");
				}
				
				break;
			case 11:
				generatePaycheck();
				System.out.println("\n action complete");
				break;
			case 12:
				createUser();
				System.out.println("\n action complete");
				break;
			case 13:
				grantPermission();
				System.out.println("\n action complete");
				break;
			case 14:
				generateCost();
				System.out.println("\n action complete");
				break;
			case 15:
				generateW2();
				System.out.println("\n action complete");
				break;
			case 16:
				removeUser();
				System.out.println("\n action complete");
				break;
			}
			System.out.println("Would you like to perform another action? (1.yes/2.no)");
			anotherAction = scan.nextInt();
		}
	}
	public static void ManagerMenu() {
		int anotherAction = 1;
		Scanner scan = new Scanner(System.in);

		while(anotherAction == 1) {
			System.out.println("Welcome to the manager dashboard. What would you like to do?");
			System.out.println("1. View Salary Report \n"
							 + "2. View Insurance Report\n"
							 + "3. View  Benifits Report\n"
							 + "4. View Tax Report \n"
							 + "5. Update or Add Employee \n"
							 + "6. Update or Add Dependant \n"
							 + "7. Add Insurance \n"
							 + "8. Update or Add Benefits \n"
							 + "9. Update or Add Payment \n"
							 + "10. Generate a Paycheck for and Employee \n"
							 + "11. Generate Company Costs");
			int managerActionSelect = scan.nextInt();
			int addOrUpdate = 0;
			switch(managerActionSelect) {
			case 1:
				salaryReport();
				System.out.println("\naction complete");
				break;
			case 2:
				insuranceReport();
				System.out.println("\naction complete");
				break;
			case 3:
				benefitsReport();
				System.out.println("\naction complete");
				break;
			case 4:
				taxReport();
				System.out.println("\naction complete");
				break;
			case 5:
				System.out.println("\n1.Add Employee, 2. Update Employee");
				addOrUpdate = scan.nextInt();
				if (addOrUpdate == 1) {
					insertEmployee();
				}
				else {
					updateEmployee();
				}
				System.out.println("\naction complete");
				break;
			case 6:
				System.out.println("\n1.Add Dependant, 2. Update Dependant");
				addOrUpdate = scan.nextInt();
				if (addOrUpdate == 1) {
					insertDependant();
				}
				else {
					updateDependant();
				}
				System.out.println("\naction complete");
				break;
			case 7:
				System.out.println("\nUpdate Insurance");
					insertInsurance();
				System.out.println("\n action complete");
				break;
			case 8:
				System.out.println("\n1.Add Benefits, 2. Update Benefits");
				addOrUpdate = scan.nextInt();
				if (addOrUpdate == 1) {
					insertBenefits();
				}
				else {
					updateBenefits();
				}
				System.out.println("\naction complete");
				break;
			case 9:
				System.out.println("\n1.Add Payments, 2. Update Payments");
				addOrUpdate = scan.nextInt();
				if (addOrUpdate == 1) {
					insertPayment();
				}
				else {
					updatePayment();
				}
				System.out.println("\naction complete");
				break;
			case 10:
				generatePaycheck();
				System.out.println("\naction complete");
			case 11:
				generateCost();
				System.out.println("\naction complete");
			}
			
			System.out.println("Would you like to perform another action? (1.yes/2.no)");
			anotherAction = scan.nextInt();
			
		}
		
	}
	
	//reports 
	public static void salaryReport() {			//done
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			if (conn != null) {
			   Statement statement = conn.createStatement();
	           String salaryQuery= String.format("SELECT id_num, salary_type, salary, bonus FROM employee"); //use a format to make user input becomes a sql statement
	           ResultSet result = statement.executeQuery(salaryQuery);
	           while (result.next()){
	               int ID = result.getInt(1);
	               String salType = result.getString(2);
	               String yearlySal = result.getString(3);
	               double biweeklySal = Double.parseDouble(result.getString(3))/26;
	               //"\t Yearly: "+ yearlySal,  , "
	               String bonus = result.getString(4);
	            
	               System.out.printf("USER: " + ID +"\t Yearly: $"+ yearlySal + "\t Bi-weekly: $"+ biweeklySal +"\t salary type: " + salType +  "\t Bonus: $"+ bonus +"\n");
	           }
			}
			else {
				System.out.println("Login failed");
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	public static void taxReport() {			//done
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			if (conn != null) {
			   Statement statement = conn.createStatement();
			   String taxQuery= String.format("select employee.id_num, federaltaxes.tax_bracket, "
			   							+ "statetaxes.state_tax_rate, federaltaxes.federal_tax_rate from employee, federaltaxes, statetaxes");
	           ResultSet result = statement.executeQuery(taxQuery);
	           while (result.next()){
	               int ID = result.getInt(1);
	               String taxBracket = result.getString(2);
	               String stateTax = result.getString(3);
	               String fedTax = result.getString(4);
	            
	               System.out.printf("USER: " + ID +"\t Tax Bracket: "+ taxBracket + "\t State Tax Rate: "+ stateTax +" \t Federal Tax Rate: " + fedTax +"\n ");
	           }
			}
			else {
				System.out.println("Login failed");
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static void benefitsReport() {		//done
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			if (conn != null) {
			   Statement statement = conn.createStatement();
			   String benefitsQuery= String.format("select id_num, health_plan, contribution_401k, attorney_plan,"
			   									+ " life_insurance, dental, vision from benefits"); //use a format to make user input becomes a sql statement
	           ResultSet result = statement.executeQuery(benefitsQuery);
	           while (result.next()){
	               int ID = result.getInt(1);
	               String health_plan = result.getString(2);
	               String contribution_401k = result.getString(3);
	               String attorney_plan = result.getString(4);
	               String life_insurance = result.getString(5);
	               String dental = result.getString(6);
	               String vision = result.getString(7);
	            
	               System.out.printf("USER: " + ID +"\t Health plan: "+ health_plan + "\t 401k Contribution: "+ contribution_401k 
	            		   						   +" \t Attorney plan: " + attorney_plan +" \n \t Life insurance plan: " + life_insurance 
	            		   						   + " \t Dental plan: " + dental + " \t Vision plan: " + vision +"\n ");
	           }
			}
			else {
				System.out.println("Login failed");
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static void insuranceReport() {		//done
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			if (conn != null) {
			   Statement statement = conn.createStatement();
			   String insuranceQuery= String.format("select id_num, insurance_plan, individual_employee_cost, family_employee_cost from insurance"); 
	           ResultSet result = statement.executeQuery(insuranceQuery);
	           while (result.next()){
	               int ID = result.getInt(1);
	               String insurance_plan = result.getString(2);
	               String individual_employee_cost = result.getString(3);
	               String family_employee_cost = result.getString(4);
	               //String individual_employer_cost = result.getString(5);   
	               
	               System.out.printf("USER: " + ID +"\t Insurance plan: "+ insurance_plan + "\t Individual cost: $"+ individual_employee_cost 
	            		   						   +" \t Famliy cost: $" + family_employee_cost +"\n ");
	           }
			}
			else {
				System.out.println("Login failed");
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	//update, insert, delete employee
	public static void updateEmployee() {		  //done
		PreparedStatement prepstmt = null;
	        try {
	        	String updEmployee ="empty";
	    		String change = "empty";
	            Connection connection = DriverManager.getConnection(url,user,pass);
	            Scanner scan = new Scanner(System.in);
	            //Get employee id to identify which Dependant to update
	            System.out.println("Enter your Employee ID:");
	            int id = scan.nextInt();
	            
	            System.out.println("What would you like to update?");
	            System.out.println("1. First Name \n"
	                             + "2. Last Name \n"
	                             + "3. Current Residence \n");
	            int num = scan.nextInt();
	            
	            switch(num){
	            case 1:
	                updEmployee = "update Employee set first_name = ? where id_num = ?";
	                prepstmt = connection.prepareStatement(updEmployee);
	                System.out.println("Enter new First Name:");
	                change = scan.next();
	                prepstmt.setString(1, change);
	                break;
	            case 2:
	                updEmployee = "update Employee set last_name = ? where id_num = ?";
	                prepstmt = connection.prepareStatement(updEmployee);
	                System.out.println("Enter new Last Name:");
	                change = scan.next();
	                prepstmt.setString(1, change);
	                break;
	            case 3:
	                updEmployee = "update Employee set current_residence = ? where id_num = ?";
	                prepstmt = connection.prepareStatement(updEmployee);
	                System.out.println("Enter new Residence:");
	                change = scan.next();
	                prepstmt.setString(1, change);
	                break;
	            }
	                
	           prepstmt.setInt(2, id);
	           prepstmt.executeUpdate();
	           prepstmt.close();
	            
            
            } catch(SQLException ie){
                System.err.println("Invalid.");
	        }        
	    
		
		
	}
	public static void insertEmployee() {		  //done
	        try {
	            Connection conn = DriverManager.getConnection(url, user ,pass);
	            Scanner scan = new Scanner(System.in);
	            System.out.println("Please enter the first name of the employee:");
	            String first = scan.next();
	            scan.nextLine();
	            System.out.println("Please enter the last name of the employee:");
	            String last = scan.next();
	            scan.nextLine();
	            System.out.println("Please enter the salary type of the employee:");
	            String salType = scan.next();
	            scan.nextLine();
	            System.out.println("Please enter the salary of the employee:");
	            double salary = scan.nextDouble();
	            scan.nextLine();
	            System.out.println("Please enter the base bonus of the employee:");
	            double bonus = scan.nextDouble();
	            scan.nextLine();
	            System.out.println("Please enter the address of the employee:");
	            String curRes = scan.nextLine();
	            scan.nextLine();
	            System.out.println("Please enter the tax bracket of the employee:");
	            String taxBracket = scan.next();
	            scan.nextLine();
	            System.out.println("Please enter the 401k Reduction of the employee:");
	            double reduction401k = scan.nextDouble();
	            scan.nextLine();
	            System.out.println("Please enter the SSN of the employee:");
	            int eSsn = scan.nextInt();
	            scan.nextLine();
	            String insertEmployeeStmt = "insert into employee (first_name, last_name, salary_type, salary, bonus, "
	            												+ "tax_bracket, current_residence, reduction_401k, e_ssn) "
										   + "values(?,?,?,?,?,?,?,?,?)";
	            PreparedStatement statement = conn.prepareStatement(insertEmployeeStmt);
	            statement.setString(1, first);
	            statement.setString(2, last);
	            statement.setString(3, salType);
	            statement.setDouble(4, salary);
	            statement.setDouble(5, bonus);
	            statement.setString(6, curRes);
	            statement.setString(7, taxBracket);
	            statement.setDouble(8, reduction401k);
	            statement.setInt(9, eSsn);
	             
	            int rowsInserted = statement.executeUpdate();
	            if (rowsInserted > 0) {
	                System.out.println("A new employee was inserted successfully!");
	            }
            } catch(SQLException ie){
                System.err.println("Invalid.");
	        }
	}
	public static void deleteEmployee() {		  //done
		try {
            Connection conn = DriverManager.getConnection(url, user ,pass);
            Scanner scan = new Scanner(System.in);
            System.out.println("Please input the ID of the Employee you would like to delete:");
            int e_ID=scan.nextInt();
            scan.nextLine();
            String deleteEmployeeStmt = "delete from employee where id_num = ?";
            
            PreparedStatement statement = conn.prepareStatement(deleteEmployeeStmt);
            statement.setInt(1, e_ID);
            
             
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("A user was deleted successfully!");
            }
        } catch(SQLException ie){
            System.err.println("Invalid.");
        }
	}
	public static void managmentUpdateEmployee() {//done
		String updEmployee ="empty";
		String change = "empty";
		PreparedStatement prepstmt = null;
	        try {
	            Connection connection = DriverManager.getConnection(url, user, pass);
	            Scanner scan = new Scanner(System.in);
	            //Get employee id to identify which Dependant to update
	            System.out.println("Enter your Employee ID:");
	            int id = scan.nextInt();
	            
	            System.out.println("What would you like to update?");
	            System.out.println("1. First Name \n"
	                             + "2. Last Name \n"
	                             + "3. Salary Type \n"
	                             + "4. Yearly Salary \n"
	                             + "5. Bonus \n"
	                             + "6. Current Residence \n"
	                             + "7. Tax Bracket \n"
	                             + "8. 401k Reduction \n"
	                             + "9. Social Security Number \n");
	            int num = scan.nextInt();
	            
	            switch(num){
	            case 1:
	                updEmployee = "update Employee set first_name = ? where id_num = ?";
	                prepstmt = connection.prepareStatement(updEmployee);
	                System.out.println("Enter new First Name:");
	                change = scan.next();
	                prepstmt.setString(1, change);
	                break;
	            case 2:
	                updEmployee = "update Employee set last_name = ? where id_num = ?";
	                prepstmt = connection.prepareStatement(updEmployee);
	                System.out.println("Enter new Last Name:");
	                change = scan.next();
	                prepstmt.setString(1, change);
	                break;
	            case 3:
	                updEmployee = "update Employee set salary_type = ? where id_num = ?";
	                prepstmt = connection.prepareStatement(updEmployee);
	                System.out.println("Enter new Salary Type:");
	                change = scan.next();
	                 prepstmt.setString(1, change);
	                break;
	            case 4:
	                updEmployee = "update Employee set salary = ? where id_num = ?";
	                prepstmt = connection.prepareStatement(updEmployee);
	                System.out.println("Enter new Residence:");
	                change = scan.next();
	                 prepstmt.setString(1, change);
	                break;
	            case 5:
	                updEmployee = "update Employee set bonus = ? where id_num = ?";
	                prepstmt = connection.prepareStatement(updEmployee);
	                System.out.println("Enter new Bonus:");
	                change = scan.next();
	                 prepstmt.setString(1, change);
	                break;
	            case 6:
	                updEmployee = "update Employee set current_residence = ? where id_num = ?";
	                prepstmt = connection.prepareStatement(updEmployee);
	                System.out.println("Enter new Residence:");
	                change = scan.next();
	                 prepstmt.setString(1, change);
	                break;
	            case 7:
	                updEmployee = "update Employee set tax_bracket = ? where id_num = ?";
	                prepstmt = connection.prepareStatement(updEmployee);
	                System.out.println("Enter new Tax Bracket:");
	                change = scan.next();
	                 prepstmt.setString(1, change);
	                break;
	            case 8:
	                updEmployee = "update Employee set reduction_401k = ? where id_num = ?";
	                prepstmt = connection.prepareStatement(updEmployee);
	                System.out.println("Enter new 401k Reduction:");
	                change = scan.next();
	                 prepstmt.setString(1, change);
	                break;
	            case 9:
	                updEmployee = "update Employee set e_ssn = ? where id_num = ?";
	                prepstmt = connection.prepareStatement(updEmployee);
	                System.out.println("Enter new SSN:");
	                change = scan.next();
	                 prepstmt.setString(1, change);
	                break;
	            }
	                
	           prepstmt.setInt(2, id);
	           prepstmt.executeUpdate();
	           prepstmt.close();
	            
            
            } catch(SQLException ie){
                System.err.println("Invalid.");
	        }        
	    
		
		
	}
	
	//update, insert, delete fed tax	
	public static void updateFederalTaxRate() {	  //done
		Scanner scan = new Scanner(System.in);
        try {
        	PreparedStatement prepstmt = null;
        	String updFedTax = "empty";
        	String change ="empty";
        	float changeRate = 0;
            Connection connection = DriverManager.getConnection(url, user, pass);
            
            System.out.println("Enter the ID of the Employee whos Federal Tax Rate you would like to change:");
            int eID = scan.nextInt();
            
            System.out.println("What would you like to update?");
            System.out.println("1. Tax Bracket \n"
                             + "2. Federal Tax Rate \n");
            int num = scan.nextInt();
            
            switch(num){
            case 1:
            	updFedTax = "update federaltaxes set tax_bracket = ? where id_num = ?";
                prepstmt = connection.prepareStatement(updFedTax);
                System.out.println("Enter new Federal Tax Bracket:");
                scan.nextLine();
                change = scan.nextLine();
                prepstmt.setString(1, change);
                break;
            case 2:
            	updFedTax = "update federaltaxes set federal_tax_rate = ? where id_num = ?";
                prepstmt = connection.prepareStatement(updFedTax);
                System.out.println("Enter new Federal Tax Rate:");
                changeRate = scan.nextFloat();
                scan.nextLine();

                prepstmt.setFloat(1, changeRate);
                break;
            }
            prepstmt.setInt(2, eID);
            prepstmt.executeUpdate();
            prepstmt.close();
            
            } catch(SQLException ie){
                System.err.println("Invalid.");
        }
		
	}
	public static void insertFederalTaxRate() {	  //done
		try {
            Connection conn = DriverManager.getConnection(url, user ,pass);
            Scanner scan = new Scanner(System.in);
            System.out.println("Please enter the ID of the employee whose federal tax rate you'd like to add:");
            int eId = scan.nextInt();
            System.out.println("Please enter the tax bracket of the employee:");
            String fedbracket = scan.next();
            scan.nextLine();
            System.out.println("Please enter the federal tax rate of the employee:");
            float fedrate = scan.nextFloat();
            scan.nextLine();
            
            String insertFedTaxRateStmt = "insert into federaltaxes (id_num, tax_bracket, federal_tax_rate) "
									   + "values(?,?,?)";
									   
            PreparedStatement statement = conn.prepareStatement(insertFedTaxRateStmt);
            statement.setInt(1, eId);
            statement.setString(2, fedbracket);
            statement.setFloat(3, fedrate);
             
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new employee federal tax was inserted successfully!");
            }
        } catch(SQLException ie){
            System.err.println("Invalid.");
        }		
	}
	public static void deleteFederalTaxRate() {	  //done
		try {
            Connection conn = DriverManager.getConnection(url, user ,pass);
            Scanner scan = new Scanner(System.in);
            System.out.println("Please input the ID of the Employee whose federal tax rate you would like to delete:");
            int eID=scan.nextInt();
            scan.nextLine();
            String deleteFedTaxStmt = "delete from FederalTaxes where id_num = ?";
            
            PreparedStatement statement = conn.prepareStatement(deleteFedTaxStmt);
            statement.setInt(1, eID);
            
             
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Employee Federal Tax Rate was deleted successfully!");
            }
        } catch(SQLException ie){
            System.err.println("Invalid.");
        }	
	}
	
	//update, insert, delete state tax
	public static void updateStateTaxRate() {	  //done
		Scanner scan = new Scanner(System.in);
        try {
        	PreparedStatement prepstmt = null;
        	String updStateTax = "empty";
        	String updFedTax ="empty";
        	String state ="empty";
        	float changeRate = 0;
            Connection connection = DriverManager.getConnection(url, user, pass);
            
            //Get SSN to identify which Dependant to update
            System.out.println("Enter the ID of the Employee whos State Tax you would like to change:");
            int eID = scan.nextInt();
            
            System.out.println("What would you like to update?");
            System.out.println("1. State \n"
                             + "2. State Tax Rate \n");
            int num = scan.nextInt();
            
            switch(num){
            case 1:
            	updStateTax = "update statetaxes set state = ? where id_num = ?";
                prepstmt = connection.prepareStatement(updStateTax);
                System.out.println("Enter new State:");
                scan.nextLine();
                state = scan.nextLine();
                prepstmt.setString(1, state);
                break;
            case 2:
            	updFedTax = "update statetaxes set state_tax_rate = ? where id_num = ?";
                prepstmt = connection.prepareStatement(updFedTax);
                System.out.println("Enter new State Tax Rate:");
                changeRate = scan.nextFloat();
                scan.nextLine();

                prepstmt.setFloat(1, changeRate);
                break;
            }
            prepstmt.setInt(2, eID);
            prepstmt.executeUpdate();
            prepstmt.close();
            
            } catch(SQLException ie){
                ie.printStackTrace();
                System.err.println("Invalid.");
        }
	}
	public static void insertStateTaxRate() {	  //done
		try {
            Connection conn = DriverManager.getConnection(url, user ,pass);
            Scanner scan = new Scanner(System.in);
            System.out.println("Please enter the ID of the employee whose state tax rate you'd like to add:");
            int eId = scan.nextInt();
            System.out.println("Please enter the state of the employee:");
            String state = scan.next();
            scan.nextLine();
            System.out.println("Please enter the state tax rate of the employee:");
            float staterate = scan.nextFloat();
            scan.nextLine();
            
            String insertStateTaxRateStmt = "insert into statetaxes (id_num, state, state_tax_rate) "
									   + "values(?,?,?)";
            PreparedStatement statement = conn.prepareStatement(insertStateTaxRateStmt);
            statement.setInt(1, eId);
            statement.setString(2, state);
            statement.setFloat(3, staterate);
             
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new employee state tax was inserted successfully!");
            }
        } catch(SQLException ie){
            ie.printStackTrace();
            System.err.println("Invalid.");
        }			
	
	}
	public static void deleteStateTaxRate() {	  //done
		try {
            Connection conn = DriverManager.getConnection(url, user ,pass);
            Scanner scan = new Scanner(System.in);
            System.out.println("Please input the ID of the Employee whose state tax rate you would like to delete:");
            int eID=scan.nextInt();
            scan.nextLine();
            String deleteStateTaxStmt = "delete from StateTaxes where id_num = ?";
            
            PreparedStatement statement = conn.prepareStatement(deleteStateTaxStmt);
            statement.setInt(1, eID);
            
             
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Employee State Tax Rate was deleted successfully!");
            }
        } catch(SQLException ie){
            System.err.println("Invalid.");
        }
	}
	
	//update, insert, delete insurance
	public static void updateInsurance() {		  //done
		Scanner scan = new Scanner(System.in);
        try {
        	PreparedStatement prepstmt = null;
        	String updInsurance = "empty";
        	String change ="empty";
        	double changeCosts = 0;
            Connection connection = DriverManager.getConnection(url, user, pass);
            
            System.out.println("Enter the ID of the Employee whos Insurance you would like to change:");
            int eID = scan.nextInt();
            
            System.out.println("What would you like to update?");
            System.out.println("1. Insurance plan \n"
                             + "2. Individual employee plan cost \n"
                             + "3. Family employee plan cost \n"
                             + "4. Individual employer plan cost \n"
                             + "5. Family employer plan cost \n");
            int num = scan.nextInt();
            
            switch(num){
            case 1:
            	updInsurance = "update insurance set insurance_plan = ? where id_num = ?";
                prepstmt = connection.prepareStatement(updInsurance);
                System.out.println("Enter new Insurance plan:");
                scan.nextLine();
                prepstmt.setString(1, change);
                break;
            case 2:
            	updInsurance = "update insurance set individual_employee_cost = ? where id_num = ?";
                prepstmt = connection.prepareStatement(updInsurance);
                System.out.println("Enter new Individual Employee cost:");
                changeCosts = scan.nextDouble();
                prepstmt.setDouble(1, changeCosts);
                break;
            case 3:
            	updInsurance = "update insurance set family_employee_cost = ? where id_num = ?";
                prepstmt = connection.prepareStatement(updInsurance);
                System.out.println("Enter new Family Employee Cost:");
                changeCosts = scan.nextDouble();
                prepstmt.setDouble(1, changeCosts);
                break;
            case 4:
            	updInsurance = "update insurance set individual_employer_cost = ? where id_num = ?";
                prepstmt = connection.prepareStatement(updInsurance);
                System.out.println("Enter new Individual Employer Cost:");
                changeCosts = scan.nextDouble();
                prepstmt.setDouble(1, changeCosts);
                break;
            case 5:
            	updInsurance = "update insurance set family_employer_cost = ? where id_num = ?";
                prepstmt = connection.prepareStatement(updInsurance);
                System.out.println("Enter new Family Employer Cost:");
                changeCosts = scan.nextDouble();
                prepstmt.setDouble(1, changeCosts);
                break;
            }
            prepstmt.setInt(2, eID);
            prepstmt.executeUpdate();
            prepstmt.close();
            
            } catch(SQLException ie){
                System.err.println("Invalid.");
        }
	}
	public static void insertInsurance() {		  //done
		try {
            Connection conn = DriverManager.getConnection(url, user ,pass);
            Scanner scan = new Scanner(System.in);
            System.out.println("Please enter the ID of the employee whose Insurance you'd like to add:");
            int eId = scan.nextInt();
            System.out.println("Please enter the insurance plan of the employee:");
            String insurancePlan = scan.next();
            scan.nextLine();
            System.out.println("Please enter the individual employee cost of the employee:");
            float indCost = scan.nextFloat();
            scan.nextLine();
            System.out.println("Please enter the family employee cost of the employee:");
            float famCost = scan.nextFloat();
            scan.nextLine();
            System.out.println("Please enter the individual employer cost of the employee:");
            float indEmpCost = scan.nextFloat();
            scan.nextLine();
			System.out.println("Please enter the family employer cost of the employee:");
            float famEmpCost = scan.nextFloat();
            scan.nextLine();
            String insertInsuranceStmt = "insert into insurance (id_num, insurance_plan, individual_employee_cost, family_employee_cost, individual_employer_cost, family_employer_cost) "
									   + "values(?,?,?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(insertInsuranceStmt);
            statement.setInt(1, eId);
            statement.setString(2, insurancePlan);
            statement.setFloat(3, indCost);
            statement.setFloat(4, famCost);
            statement.setFloat(5, indEmpCost);
			statement.setFloat(6, famEmpCost);
             
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new Insurance for an Employee was inserted successfully!");
            }
        } catch(SQLException ie){
        	ie.printStackTrace();
            System.err.println("Invalid.");
        }	
	}
	public static void deleteInsurance() {		  //done
		try {
            Connection conn = DriverManager.getConnection(url, user ,pass);
            Scanner scan = new Scanner(System.in);
            System.out.println("Please input the ID of the employee whos insurance you would like to delete:");
            int eID=scan.nextInt();
            scan.nextLine();
            String deleteInsuranceStmt = "delete from insurance where id_num = ?";
            
            PreparedStatement statement = conn.prepareStatement(deleteInsuranceStmt);
            statement.setInt(1, eID);
            
             
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Insurance was deleted successfully!");
            }
        } catch(SQLException ie){
            System.err.println("Invalid.");
        }
	}
	
	//update, insert, delete dependants	
	public static void updateDependant() {		//done
		Scanner scan = new Scanner(System.in);
	        try {
	        	PreparedStatement prepstmt = null;
	        	String updDependant = "empty";
	        	String change ="empty";
	            Connection connection = DriverManager.getConnection(url, user, pass);
	            
	            //Get SSN to identify which Dependant to update
	            System.out.println("Enter the SSN of the Dependant you would like to change:");
	            int ssn = scan.nextInt();
	            
	            System.out.println("What would you like to update?");
	            System.out.println("1. First Name \n"
	                             + "2. Last Name \n"
	                             + "3. SSN \n"
	                             + "4. Relationship \n");
	            int num = scan.nextInt();
	            
	            switch(num){
	            case 1:
	                updDependant = "update dependants set d_first_name = ? where d_ssn = ?";
	                prepstmt = connection.prepareStatement(updDependant);
	                System.out.println("Enter new First Name:");
	                change = scan.next();
	                scan.nextLine();
	                prepstmt.setString(1, change);
	                break;
	            case 2:
	                updDependant = "update dependants set d_last_name = ? where d_ssn = ?";
	                prepstmt = connection.prepareStatement(updDependant);
	                System.out.println("Enter new Last Name:");
	                change = scan.next();
	                scan.nextLine();

	                prepstmt.setString(1, change);
	                break;
	            case 3:
	                updDependant = "update dependants set d_ssn = ? where d_ssn = ?";
	                prepstmt = connection.prepareStatement(updDependant);
	                System.out.println("Enter new SSN:");
	                change = scan.next();
	                scan.nextLine();

	                prepstmt.setString(1, change);
	                break;
	            case 4:
	                updDependant = "update dependants set relationship = ? where d_ssn = ?";
	                prepstmt = connection.prepareStatement(updDependant);
	                System.out.println("Enter new Relationship:");
	                change = scan.next();
	                scan.nextLine();

	                prepstmt.setString(1, change);
	                break;
	            }
	            prepstmt.setInt(2, ssn);
	            prepstmt.executeUpdate();
	            prepstmt.close();
	            
	            } catch(SQLException ie){
	                System.err.println("Invalid.");
	        }
	                
	    }
	public static void insertDependant() {		//done
		try {
            Connection conn = DriverManager.getConnection(url, user ,pass);
            Scanner scan = new Scanner(System.in);
            System.out.println("Please enter the ID of the employee related to the dependant:");
            int eId = scan.nextInt();
            System.out.println("Please enter the first name of the dependant:");
            String first = scan.next();
            scan.nextLine();
            System.out.println("Please enter the last name of the dependant:");
            String last = scan.next();
            scan.nextLine();
            System.out.println("Please enter your relation to the dependant:");
            String relation = scan.next();
            scan.nextLine();
            System.out.println("Please enter the SSN of the dependant:");
            int dSsn = scan.nextInt();
            scan.nextLine();
            String insertDependantStmt = "insert into dependants (e_id_num, d_first_name, d_last_name, d_ssn, relationship) "
									   + "values(?,?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(insertDependantStmt);
            statement.setInt(1, eId);
            statement.setString(2, first);
            statement.setString(3, last);
            statement.setInt(4, dSsn);
            statement.setString(5, relation);
             
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new dependant was inserted successfully!");
            }
        } catch(SQLException ie){
            System.err.println("Invalid.");
        }
	}
	public static void deleteDependant() {		//done
		try {
            Connection conn = DriverManager.getConnection(url, user ,pass);
            Scanner scan = new Scanner(System.in);
            System.out.println("Please input the SSN of the Dependant you would like to delete:");
            int dSsn=scan.nextInt();
            scan.nextLine();
            String deleteDependantStmt = "delete from dependants where d_ssn = ?";
            
            PreparedStatement statement = conn.prepareStatement(deleteDependantStmt);
            statement.setInt(1, dSsn);
            
             
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("A dependant was deleted successfully!");
            }
        } catch(SQLException ie){
            System.err.println("Invalid.");
        }
	}
	
	//update, insert, delete benefits	
	public static void updateBenefits() {		//done
		Scanner scan = new Scanner(System.in);
        try {
        	PreparedStatement prepstmt = null;
        	String updBenefits = "empty";
			
        	String change = "empty";
        	double changeContrib = 0;
			
            Connection connection = DriverManager.getConnection(url, user, pass);
            
            System.out.println("Enter the ID of the Employee whos Benefits you would like to change:");
            int eID = scan.nextInt();
            
            System.out.println("What would you like to update? (if mroe than one word use 'camelCase')");
            System.out.println("1. Health Plan \n"
                             + "2. 401K Contribution \n"
							 + "3. Attorney Plan \n"
                             + "4. Life Insurance\n"
							 + "5. Dental \n"
                             + "6. Vision \n");
            int num = scan.nextInt();
            
            switch(num){
            case 1:
            	updBenefits = "update benefits set health_plan = ? where id_num = ?";
                prepstmt = connection.prepareStatement(updBenefits);
                System.out.println("Enter new Health Plan:");
                change = scan.next();
                prepstmt.setString(1, change);
                break;
            case 2:
            	updBenefits = "update benefits set contribution_401k = ? where id_num = ?";
                prepstmt = connection.prepareStatement(updBenefits);
                System.out.println("Enter new 401K Contribution:");
                changeContrib = scan.nextDouble();
                prepstmt.setDouble(1, changeContrib);
                break;
			case 3:
            	updBenefits = "update benefits set attorney_plan = ? where id_num = ?";
                prepstmt = connection.prepareStatement(updBenefits);
                System.out.println("Enter new Attorney Plan:");
                change = scan.next();
                prepstmt.setString(1, change);
                break;
			case 4:
            	updBenefits = "update benefits set life_insurance = ? where id_num = ?";
                prepstmt = connection.prepareStatement(updBenefits);
                System.out.println("Enter new Life Insurance Plan:");
                change = scan.next();
                prepstmt.setString(1, change);
                break;
			case 5:
            	updBenefits = "update benefits set dental = ? where id_num = ?";
                prepstmt = connection.prepareStatement(updBenefits);
                System.out.println("Enter new Dental Plan:");
                change = scan.next();
                prepstmt.setString(1, change);
                break;
			case 6:
            	updBenefits = "update benefits set vision = ? where id_num = ?";
                prepstmt = connection.prepareStatement(updBenefits);
                System.out.println("Enter new Vision Plan:");
                change = scan.next();
                prepstmt.setString(1, change);
                break;
            }
            prepstmt.setInt(2, eID);
            prepstmt.executeUpdate();
            prepstmt.close();
            
            } catch(SQLException ie){
                System.err.println("Invalid.");
        }		
	}
	public static void insertBenefits() {		//done
		try {
            Connection conn = DriverManager.getConnection(url, user ,pass);
            Scanner scan = new Scanner(System.in);
            System.out.println("Please enter the ID of the employee whose Benefits you'd like to add:");
            int eId = scan.nextInt();
            System.out.println("Please enter the health plan of the employee:");
            String healthPlan = scan.nextLine();
            System.out.println("Please enter the 401k contribution of the employee:");
            double contrib401 = scan.nextDouble();
			System.out.println("Please enter the attorney plan of the employee:");
            String attorneyPlan = scan.nextLine();
			System.out.println("Please enter the life insurance benefit of the employee:");
            String lifeInsurance = scan.nextLine();
			System.out.println("Please enter the dental benefits of the employee:");
            String dentalPlan = scan.nextLine();
			System.out.println("Please enter the vision benefits of the employee:");
            String visionPlan = scan.nextLine();
            
            String insertBenefitsStmt = "insert into benefits (id_num, health_plan, contribution_401k, attorney_plan, life_insurance, dental, vision) "
									   + "values(?,?,?,?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(insertBenefitsStmt);
            statement.setInt(1, eId);
            statement.setString(2, healthPlan);
            statement.setDouble(3, contrib401);
			statement.setString(4, attorneyPlan);
			statement.setString(5, lifeInsurance);
			statement.setString(6, dentalPlan);
			statement.setString(7, visionPlan);
             
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new employee benifit was inserted successfully!");
            }
        } catch(SQLException ie){
            ie.printStackTrace();
            System.err.println("Invalid.");
        }
	}
	public static void deleteBenefits() {		//done
		try {
            Connection conn = DriverManager.getConnection(url, user ,pass);
            Scanner scan = new Scanner(System.in);
            System.out.println("Please input the ID of the Employee whose benefits you would like to delete:");
            int eID=scan.nextInt();
            scan.nextLine();
            String deleteInsuranceStmt = "delete from Benefits where id_num = ?";
            
            PreparedStatement statement = conn.prepareStatement(deleteInsuranceStmt);
            statement.setInt(1, eID);
            
             
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Employee Benefits were deleted successfully!");
            }
        } catch(SQLException ie){
            System.err.println("Invalid.");
        }
	}
	
	//update, insert, delete payments
	public static void updatePayment() {		//done
		Scanner scan = new Scanner(System.in);
        try {
        	PreparedStatement prepstmt = null;
        	String updPayment = "empty";
        	float changeSSRate = 0;
        	float changeMed = 0;
            Connection connection = DriverManager.getConnection(url, user, pass);
            
            System.out.println("Enter the ID of the Employee whos Payment you would like to change:");
            int eID = scan.nextInt();
            
            System.out.println("What would you like to update?");
            System.out.println("1. Social Security Rates \n"
                             + "2. Medicare Rates \n");
            int num = scan.nextInt();
            
            switch(num){
            case 1:
            	updPayment = "update payments set social_security_rates = ? where id_num = ?";
                prepstmt = connection.prepareStatement(updPayment);
                System.out.println("Enter new Social Security Rates:");
                changeSSRate = scan.nextFloat();
				scan.nextLine();
                prepstmt.setFloat(1, changeSSRate);
                break;
            case 2:
            	updPayment = "update payments set medicare_rate = ? where id_num = ?";
                prepstmt = connection.prepareStatement(updPayment);
                System.out.println("Enter new Medicare Rate:");
                changeMed = scan.nextFloat();
                scan.nextLine();
                prepstmt.setFloat(1, changeMed);
                break;
            }
            prepstmt.setInt(2, eID);
            prepstmt.executeUpdate();
            prepstmt.close();
            
            } catch(SQLException ie){
                System.err.println("Invalid.");
        }	
	}
	public static void insertPayment() {		//done
		try {
            Connection conn = DriverManager.getConnection(url, user ,pass);
            Scanner scan = new Scanner(System.in);
            System.out.println("Please enter the ID of the employee whose Payments you'd like to add:");
            int eId = scan.nextInt();
            System.out.println("Please enter the social security rate of the employee:");
            float SSrate = scan.nextFloat();
            scan.nextLine();
            System.out.println("Please enter the medicare rate of the employee:");
            float medrate = scan.nextFloat();
            scan.nextLine();
            
            String insertPaymentStmt = "insert into payments (id_num, social_security_rates, medicare_rate) "
									   + "values(?,?,?)";
            PreparedStatement statement = conn.prepareStatement(insertPaymentStmt);
            statement.setInt(1, eId);
            statement.setFloat(2, SSrate);
            statement.setFloat(3, medrate);
             
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new employee payments was inserted successfully!");
            }
        } catch(SQLException ie){
            ie.printStackTrace();
            System.err.println("Invalid.");
        }
	}
	public static void deletePayment() {		//done
		try {
            Connection conn = DriverManager.getConnection(url, user ,pass);
            Scanner scan = new Scanner(System.in);
            System.out.println("Please input the ID of the Employee whose benefits you would like to delete:");
            int eID=scan.nextInt();
            scan.nextLine();
            String deleteInsuranceStmt = "delete from Payments where id_num = ?";
            
            PreparedStatement statement = conn.prepareStatement(deleteInsuranceStmt);
            statement.setInt(1, eID);
            
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Employee Payments were deleted successfully!");
            }
        } catch(SQLException ie){
            System.err.println("Invalid.");
        }
	}
	
	//admin creation methods
	public static void createUser() { 			//done
		try {
			Scanner scan = new Scanner(System.in);
			Connection conn = DriverManager.getConnection(url, user, pass);
			
			System.out.println("Please input the username for new user (no spaces):");
			String newUserName = scan.next();
			System.out.println("Please input the user password for new user (no spaces):");
			String newPassword = scan.next();
			
			Statement statement = conn.createStatement();
			String createUserQuery = "create user "+ newUserName +" with password '"+newPassword+"'";
			statement.executeUpdate(createUserQuery);
			
			System.out.println("User successfully created. Would you like to grant this user a role? (press 1 for yes)");
			int grantPerms = scan.nextInt();
			if (grantPerms == 1) {
				grantPermission();
			}
			else {
				System.out.println("Understood. This user will not have permission to perform any actions in this database.");
			}
		}
		catch(SQLException e) {
			System.err.print("Invalid username or password \n");
		}
	}
	public static void removeUser() { 			//done
		try {
			ResultSet result;
			Scanner scan = new Scanner(System.in);
			Connection conn = DriverManager.getConnection(url, user, pass);
			
			System.out.println("Please input the username for user you wish to delete:");
			String userName = scan.next();
			
			Statement statement = conn.createStatement();
			String createUserQuery = "drop role "+ userName;
			statement.executeUpdate(createUserQuery);
			
			System.out.println("User successfully dropped.");

		}
		catch(SQLException e) {
			System.err.print("User does not exist \n");
		}
	}
	public static void grantPermission() {		//done
		try {
			ResultSet result;
			Scanner scan = new Scanner(System.in);
			Connection conn = DriverManager.getConnection(url, user, pass);
			
			System.out.println("Please input the username of the user you would like to grant a role to:");
			String userName = scan.next();
			System.out.println("Please input the role you would like to grant this user:");
			String role = scan.next();
			
			Statement statement = conn.createStatement();
			String createUserQuery = "grant "+ role  +" to "+userName;
			statement.executeUpdate(createUserQuery);
			
			System.out.println("User successfully granted role: "+role);
			
		}
		catch(SQLException e) {
			e.printStackTrace();
			System.err.print("Invalid username  \n");
		}
	}
	
	//generate 
	public static void generateW2(){			//done
		try {
			double salary = 0;
			double reduction_401k =0;
			int SSN =0;
			double bonus = 0;
			String sType = null;
			
			double state_tax =0;
			double fed_tax = 0;
			
			double SSRate =0;
			double MedRate =0;
			Connection conn = DriverManager.getConnection(url, user, pass);
			
			Scanner scan = new Scanner(System.in);
			
			System.out.println("Please input the ID of the Employee whose W2 you would like to generate:");
			int eID=scan.nextInt();
			scan.nextLine();
			
			Statement statement = conn.createStatement();
			String W2Query= String.format("select salary, reduction_401k, e_ssn, bonus, salary_type from employee where id_num = '" + eID + "'"); 
			
	        ResultSet result = statement.executeQuery(W2Query);
			
	        while (result.next()){
	            salary = result.getDouble(1);
	            reduction_401k = result.getDouble(2);
	            SSN = result.getInt(3);
				bonus = result.getDouble(4);
				sType = result.getString(5);
	           }
			
			Statement statement2 = conn.createStatement();
			String W2Query2= String.format("select federal_tax_rate from federaltaxes where id_num = '" + eID + "'");
			ResultSet result2 = statement2.executeQuery(W2Query2);

	        while (result2.next()){
	            fed_tax = result2.getDouble(1);
	           }
			
			Statement statement3 = conn.createStatement();
			String W2Query3= String.format("select state_tax_rate from statetaxes where id_num = '" + eID + "'");
			
			
			
	        ResultSet result3 = statement3.executeQuery(W2Query3);
			
	        while (result3.next()){
	            state_tax = result3.getDouble(1);
	           }
			
			Statement statement4 = conn.createStatement();
			String W2Query4= String.format("select social_security_rates, medicare_rate from payments where id_num = '" + eID + "'");
			
			

	        ResultSet result4 = statement4.executeQuery(W2Query4);
			
	        while (result4.next()){
	            SSRate = result4.getDouble(1);
				MedRate = result4.getDouble(2);
	           }
			
			if(sType == "hourly"){salary = salary*40*52;}
			   System.out.printf("USER: " + eID +"\t Salary: "+  salary + "\t 401k Reduction: "+ reduction_401k
	            		   			   +" \t Social Security Number: " + SSN +" \n \t Bonus: " + bonus
	            		   			   + " \t Federal Tax Reduction: " + fed_tax + " \t State Tax Reduction: " + state_tax 
									   + "\n \t Social Security Reduction: " + SSRate + " \t Medicare Reduction: " + MedRate);
									   
			
        } catch(SQLException ie){
            System.err.println("Invalid.");
        }		
	}
	public static void generateCost(){			//done
		try {
			String costQuery= "empty";
			String W2 = "w2";
			String hourly = "hourly";
			ResultSet result;
			double sumSalaryYearly = 0;
            double sumBonusYearly = 0;
            double sumSalaryHourly = 0;
            double sumBonusHourly = 0;
            double SSCompanyContribution1 =0;
            double SSCompanyContribution2 = 0;
            double sumIndEmpCost = 0;
		    double sumFamEmpCost = 0;
		    double sum401k =0;
            
            double totalExpenses = 0;
			double totalSSN = 0;
			double totalSalary = 0;
			double totalBonus = 0;
			double totalEmployerInsurance = 0;
            

			Connection conn = DriverManager.getConnection(url, user, pass);
			Scanner scan = new Scanner(System.in);
			
			
			Statement statement = conn.createStatement();
			costQuery= String.format("select sum(salary), sum(bonus) from employee where salary_type = '" + W2 + "'  "); 
	        result = statement.executeQuery(costQuery);
			
	        while (result.next()){
	            sumSalaryYearly = result.getDouble(1);
	            sumBonusYearly = result.getDouble(2);
	           }
			
			Statement statement1 = conn.createStatement();
			costQuery= String.format("select sum(salary), sum(bonus) from employee where salary_type = '" + hourly + "' "); 
			
	        result = statement1.executeQuery(costQuery);
			
	        while (result.next()){
	            sumSalaryHourly = result.getDouble(1);
	            sumBonusHourly = result.getDouble(2);
	           }
			
			sumSalaryHourly = sumSalaryHourly*52*40;
			
			Statement statement2 = conn.createStatement();
			String costQuery2= String.format("select sum(salary) from employee where salary_type = '" + W2 + "' ");
			ResultSet result2 = statement2.executeQuery(costQuery2);
	
	        while (result2.next()){
	        	SSCompanyContribution1 = result2.getDouble(1);
	           }
			SSCompanyContribution1 = SSCompanyContribution1*.075;
			
			Statement statement3 = conn.createStatement();
			String costQuery3= String.format("select sum(salary) from employee where salary_type = '" + hourly + "' ");
			
			
	        ResultSet result3 = statement3.executeQuery(costQuery3);
			
	        while (result3.next()){
	            SSCompanyContribution2 = result3.getDouble(1);
	           }
			
			SSCompanyContribution2 = 52*40*SSCompanyContribution2*.15;
			
			
			Statement statement4 = conn.createStatement();
			String costQuery4= String.format("select sum(individual_employer_cost), sum(family_employer_cost) from insurance");
		
	        ResultSet result4 = statement4.executeQuery(costQuery4);
			
	        while (result4.next()){
	            sumIndEmpCost = result4.getDouble(1);
			    sumFamEmpCost = result4.getDouble(2);
	           }
			
			Statement statement5 = conn.createStatement();
			String costQuery5= String.format("select avg(contribution_401k) from benefits");
		
	        ResultSet result5 = statement5.executeQuery(costQuery5);
			
	        while (result5.next()){
	            sum401k = result5.getDouble(1);
	           }
			sum401k = sum401k * (sumSalaryHourly + sumSalaryYearly);
			
			
			totalExpenses = sumIndEmpCost + sumFamEmpCost + sum401k + SSCompanyContribution1 + SSCompanyContribution1 + sumSalaryHourly
									+ sumSalaryYearly + sumBonusHourly + sumBonusYearly;
			totalSSN = SSCompanyContribution1 + SSCompanyContribution2;
			totalSalary = sumSalaryHourly + sumSalaryYearly;
			totalBonus = sumBonusHourly + sumBonusYearly;
			totalEmployerInsurance = sumIndEmpCost + sumFamEmpCost;
			
		   System.out.printf("Total Company Expenses: " + totalExpenses +"\n Employer SSN Contribution: "+  totalSSN + "\t Salary Expenses: "+ totalSalary
            		   			   +" \t Bonus Expenses: " + totalBonus  + " \n\t Employer Insurance Contribution: " + totalEmployerInsurance
								   + " \t 401K Matching Expenses: " + sum401k );
								   
		
    } catch(SQLException ie){
        System.err.println("Invalid.");
    }		
}
	public static void generatePaycheck() {		//done
			try {
				double salary = 0;
				double reduction_401k =0;
				int SSN =0;
				double bonus = 0;
				String sType = null;
				
				double state_tax =0;
				double fed_tax = 0;
				
				double SSRate =0;
				double MedRate =0;
				double indEmpCost=0;
				double famEmpCost = 0;
			
			Connection conn = DriverManager.getConnection(url, user, pass);
			
			Scanner scan = new Scanner(System.in);
			
			System.out.println("Please input the ID of the Employee whose Paycheck you would like to generate:");
			int eID=scan.nextInt();
			scan.nextLine();
			
			Statement statement = conn.createStatement();
			String W2Query= String.format("select salary, reduction_401k, e_ssn, bonus, salary_type from employee where id_num = '" + eID + "'"); 
			
	        ResultSet result = statement.executeQuery(W2Query);
			
	        while (result.next()){
	            salary = result.getDouble(1);
	            reduction_401k = result.getDouble(2);
	            SSN = result.getInt(3);
				sType = result.getString(5);
	           }
			
			Statement statement2 = conn.createStatement();
			String W2Query2= String.format("select federal_tax_rate from federaltaxes where id_num = '" + eID + "'");
			ResultSet result2 = statement2.executeQuery(W2Query2);

	        while (result2.next()){
	            fed_tax = result2.getDouble(1);
	           }
			
			Statement statement3 = conn.createStatement();
			String W2Query3= String.format("select state_tax_rate from statetaxes where id_num = '" + eID + "'");
			
			
			
	        ResultSet result3 = statement3.executeQuery(W2Query3);
			
	        while (result3.next()){
	            state_tax = result3.getDouble(1);
	           }
			
			Statement statement4 = conn.createStatement();
			String W2Query4= String.format("select social_security_rates, medicare_rate from payments where id_num = '" + eID + "'");
			
			

	        ResultSet result4 = statement4.executeQuery(W2Query4);

	        while (result4.next()){
	            SSRate = result4.getDouble(1);
				MedRate = result4.getDouble(2);
	           }
			
			Statement statement5 = conn.createStatement();
			String W2Query5= String.format("select individual_employee_cost, family_employee_cost from insurance where id_num = '" + eID + "'");

	        ResultSet result5 = statement5.executeQuery(W2Query5);

	        while (result5.next()){
	        	indEmpCost = result5.getDouble(1);
				famEmpCost = result5.getDouble(2);
	           }
			double insurancePremium = indEmpCost + famEmpCost;
			if(sType == "hourly") salary = salary*40*2;
			else if(sType == "yearly") salary = salary/26;
			   System.out.printf("USER: " + eID +"\t Biweekly Paycheck: "+  salary + "\t 401k Reduction: "+ reduction_401k
	            		   			   +" \t Social Security Number: " + SSN  + " \t Federal Tax Reduction: " + fed_tax 
									   + " \t State Tax Reduction: " + state_tax + "\n \t Social Security Reduction: "
									   + SSRate + " \t Medicare Reduction: " + MedRate + "\t Insurance Premium: " + insurancePremium);
        } catch(SQLException ie){
            System.err.println("Invalid.");
		
        }
	}
}