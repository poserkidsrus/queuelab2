
//@Keil Barracliffe
//@Jeffrey Ackah

import java.util.Scanner;
public class Handler
{
    // instance variables - replace the example below with your own
    private Company companySet;
    private char z;
    private Scanner scanner;
    private Department dept;
    private Executive exec;
    /**
     * Constructor for objects of class Handler
     */
    public Handler()
    {
        // initialise instance variables
        this.scanner = new Scanner(System.in);
        
        
    }

    public void setCompany()
    {
        Company companySet = new Company();
        System.out.println("What is the name of your company?");
        String namer = scanner.nextLine();
        companySet.setName(namer);
        this.companySet = companySet;
    }

    public Company getCompany()
    {
        return companySet;
    }

    public void add()
    {
        Department deptSet = new Department();
        getCompany().add(deptSet);
    }

    public void hire()
    {
        Executive execSet = new Executive();
        getCompany().hire(execSet);
    }
    

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
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
    public char menuInput(char z)
    {
        if(Character.toLowerCase(z) == 'a')
        {
            this.add();
        }
         else if (Character.toLowerCase(z) == 'b')
         {
             this.hire();
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
    
    public void exit()
    {
        System.out.print("\nChanges Complete\n");
        System.exit(0);
    }
}
