import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;
import java.util.Comparator;

/**
 * Write a description of class Company here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Company
{
    // instance variables - replace the example below with your own
    private Queue<Department> directory;
    private Scanner scanner;
    private Queue<Executive> hiringPool;
    private ArrayList<Executive> unemployed;
    private char z;
    private String name;
    /**
     * Constructor for objects of class Company
     */
    public Company()
    {
        // initialise instance variables
        directory = new LinkedList<>();
        scanner = new Scanner(System.in);
        hiringPool = new LinkedList<>();
        unemployed = new ArrayList<>();

    }

    public Queue<Department> getDirectory()
    {
        return directory;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void add(Department newDepartment)
    {
        newDepartment = new Department();
        System.out.println("What is the name of this Department?");
        String namer = scanner.nextLine();
        newDepartment.setName(namer);
        directory.add(newDepartment);
        System.out.println("Current departments: ");
        for(Department dept : directory)
        {
            System.out.print(dept.getName());
            System.out.print(" ");
        }
        System.out.println();
    }

    public void hire(Executive newExec)
    {
        newExec = new Executive();
        System.out.println("What is the name of this Executive?");
        String namer = scanner.nextLine();
        newExec.setName(namer);
        System.out.println("What is this executive's hiring date? Format yyyy-MM-dd: ");
        String hiringDate = scanner.nextLine();
        try
        {
            newExec.setStartingDate(hiringDate);
        }
        catch (java.text.ParseException pe)
        {
            pe.printStackTrace();
        }
        System.out.println("Is this executive joining a department immediately? yes/no");
        String check = scanner.nextLine();
        if(check.equalsIgnoreCase("yes"))
        {
            newExec.setEmploymentStatus(true);
            hiringPool.add(newExec);
            join(hiringPool.poll());
        }
        else if(check.equalsIgnoreCase("no"))
        {
            newExec.setEmploymentStatus(false);
            unemployed.add(hiringPool.poll());
        }

    }

    public Department getDept(String name)
    {
        Department deptCheck = new Department();
        for(Department dept : getDirectory())
        {
            dept.getName();
            if(dept.getName().equalsIgnoreCase(name))
            {
                deptCheck = dept;
            }
        }
        return deptCheck;
    }

    public void join(Executive movingExec)
    {
        System.out.println("What department is this employee joining?");
        String deptName = scanner.nextLine();
        Department hiringDept = new Department();
        ArrayList<Executive> temp = new ArrayList<>();
        for(Department dept : getDirectory())
        {
            dept.getName();
            if(dept.getName().equalsIgnoreCase(deptName))
            {
                hiringDept = dept;
            }
        }
        hiringDept.getEmployees().add(movingExec);
        System.out.println("Executive " +movingExec.getName()+ " has joined the " +hiringDept.getName()+ " department.");
    }

    public void quit()
    {
        System.out.println("Who are we removing from their department?");
        String execName = scanner.nextLine();
        System.out.println("What department is this employee leaving?");
        String deptName = scanner.nextLine();
        Department firingDept = new Department();
        Executive movingExec = new Executive();
        Queue<Executive> tempE = new LinkedList<>();
        Queue<Department> tempD = new LinkedList<>();
        for(Department dept : getDirectory())
        {
            dept.getName();
            if(dept.getName().equalsIgnoreCase(deptName))
            {
                firingDept = dept;
            }
        }
        for(int i = 0; i < firingDept.getEmployees().size(); i++)
        {
            firingDept.getEmployees().peek().getName();
            if(firingDept.getEmployees().peek().getName().equalsIgnoreCase(execName))
            {
                movingExec = firingDept.getEmployees().poll();
            }
            else
            {
                tempE.add(firingDept.getEmployees().poll());
            }
        }
        for(int i = 0; i < tempE.size(); i++)
        {
            firingDept.getEmployees().add(tempE.poll());
        }

        movingExec.setEmploymentStatus(false);
        unemployed.add(movingExec);
        System.out.println("Executive " +movingExec.getName()+ " has quit from " +firingDept.getName()+ " .");
    }

    public void change()
    {
        System.out.println("Who are we removing from their department?");
        String execName = scanner.nextLine();
        System.out.println("What department is this employee leaving?");
        String oldDept = scanner.nextLine();
        System.out.println("What department is this employee joining?");
        String newDept = scanner.nextLine();
        Department leavingDept = new Department();
        Executive movingExec = new Executive();
        Department addingDept = new Department();
        Queue<Executive> temp = new LinkedList<>();
        for(Department dept : getDirectory())
        {
            dept.getName();
            if(dept.getName().equalsIgnoreCase(oldDept))
            {
                leavingDept = dept;
                while(!leavingDept.getEmployees().isEmpty())
                {
                    Executive tempE = leavingDept.getEmployees().peek();
                    tempE.getName();
                    if(tempE.getName().equalsIgnoreCase(execName))
                    {
                        tempE = leavingDept.getEmployees().poll();
                    }
                    else
                    {
                        temp.add(leavingDept.getEmployees().poll());
                    }
                }
                while(!temp.isEmpty())
                {
                    leavingDept.getEmployees().add(temp.poll());
                }
            }
        }
        
        for(Department dept : getDirectory())
        {
            dept.getName();
            if(dept.getName().equalsIgnoreCase(newDept))
            {
                addingDept = dept;
            }
        }
        addingDept.getEmployees().add(movingExec);
        System.out.println("Executive " +movingExec.getName()+ " has moved from " +leavingDept.getName()+ " to " +addingDept.getName()+ " .");
    }

    public void payroll()
    {
        System.out.println("For which department are you requesting payroll?");
        String paybyDept = scanner.nextLine();
        ArrayList<Executive> temp = new ArrayList<>();
        Department deptCheck = new Department();
        for(Department dept : getDirectory())
        {
            dept.getName();
            if(dept.getName().equalsIgnoreCase(paybyDept))
            {
                deptCheck = dept;
                deptCheck.getEmployees();
                int i;
                int j;
                for(Executive exec : deptCheck.getEmployees())
                {
                    temp.add(exec);
                }
                temp.sort(Comparator.comparing(Executive::getStartingDate));
                for(i = 0; i < temp.size(); i++)
                {
                    j = temp.size() - i;
                    temp.get(i).setSalary(j, 40000);
                }

                System.out.println("Salaries for " +dept.getName()+ " department.");
                System.out.println();
                for(Executive exec : temp)
                {
                    System.out.println("Employee name: " +exec.getName());
                    System.out.println("Current salary: " +'$'+ "" +exec.getSalary());
                    exec.setSalary(0,0);
                }
            }
            else
            {
                break;
            }
        }
    }

    public void singleSalary()
    {
        System.out.println("Who are we checking salary for?");
        String execName = scanner.nextLine();
        System.out.println("What department does this employee work in?");
        String currentDept = scanner.nextLine();
        ArrayList<Executive> temp = new ArrayList<>();
        Department deptCheck = new Department();
        Executive execTemp = new Executive();
        for(Department dept : getDirectory())
        {
            dept.getName();
            if(dept.getName().equalsIgnoreCase(currentDept))
            {
                deptCheck = dept;
                deptCheck.getEmployees();
                int i;
                int j;
                for(Executive exec : deptCheck.getEmployees())
                {
                    temp.add(exec);
                }
                temp.sort(Comparator.comparing(Executive::getStartingDate));
                for(i = 0; i < temp.size(); i++)
                {
                    j = temp.size() - i;
                    temp.get(i).setSalary(j, 40000);
                }

                for(Executive exec : temp)
                {
                    exec.getName();
                    if(exec.getName().equalsIgnoreCase(execName))
                    {
                        execTemp = exec;
                        System.out.println(execTemp.getName());
                        System.out.println(execTemp.getSalary());
                        execTemp.setSalary(0,0);
                    }
                }
            }
            else
            {
                break;
            }
        }
    }
}
