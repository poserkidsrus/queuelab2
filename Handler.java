
//@Keil Barracliffe
//@Jeffrey Ackah

import java.util.Scanner;
public class Handler
{
    
    private Company companySet;
    private char z;
    private Scanner scanner;
    private Department dept;
    private Executive exec;
    //new object of class
    public Handler()
    {
        
        this.scanner = new Scanner(System.in);

    }
    //creates company object for this class to use
    public void setCompany()
    {
        Company companySet = new Company();
        System.out.println("What is the name of your company?");
        String namer = scanner.nextLine();
        companySet.setName(namer);
        this.companySet = companySet;
    }
    //returns company
    public Company getCompany()
    {
        return companySet;
    }
    //creates department object to pass into the company object
    public void add()
    {
        Department deptSet = new Department();
        getCompany().add(deptSet);
    }

    //creates executive object to pass into the company object
    public void hire()
    {
        Executive execSet = new Executive();
        getCompany().hire(execSet);
    }
    
    //shows menu while program is running
    public void programMenu()
    {
        while (true)
        {
            System.out.println();
            System.out.println("\t Menu \t");
            System.out.println("A - Add department");
            System.out.println("B - Hire executive");
            System.out.println("C - Move Employee");
            System.out.println("D - Remove Employee");
            System.out.println("E - Print Salary for Employee");
            System.out.println("F - Print Salaries for Department");
            System.out.println("X - End Program");

            this.z = this.scanner.next().charAt(0);
            this.menuInput(z);
        }
        
    }
    
    //method to select class methods based on input character
    public char menuInput(char z)
    {
        if(Character.toLowerCase(z) == 'a')
        {
            add();
        }
         else if (Character.toLowerCase(z) == 'b')
         {
             hire();
        }
        else if(Character.toLowerCase(z) == 'c')
        {
            getCompany().change();
        }
        else if(Character.toLowerCase(z) == 'd')
        {    
            getCompany().quit();
        }
        else if(Character.toLowerCase(z) == 'e')
        {
            getCompany().singleSalary();
        }
        else if(Character.toLowerCase(z) == 'f')
        {
            getCompany().payroll();
        }
        else if (Character.toLowerCase(z) == 'x')
        {
            this.exit();
        }
        else
        {
            System.out.println("Invalid Selection");
        }
        return this.z;
    }
    //method to end program
    public void exit()
    {
        System.out.print("\nChanges Complete\n");
        System.exit(0);
    }
}
