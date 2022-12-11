import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Date;
import java.util.Comparator;

//@Keil Barracliffe
//@Jeffrey Ackah
public class Department
{
    // instance variables - replace the example below with your own
    private String name;
    private Queue <Executive> employees;
    private ArrayList<Executive> payRoll;

    public Department()
    {
        // initialise instance variables
        employees = new LinkedList<>();
        payRoll = new ArrayList<>();
    }
    
    public Queue<Executive> getEmployees()
    {
        // put your code here
        return employees;
    }

    public Executive getExecFromList(String execName)
    {
        Executive execCheck = new Executive();
        for(Executive exec : employees)
        {
            exec.getName();
            if(exec.getName().equalsIgnoreCase(execName))
            {
                execCheck = exec;
            }
        }
        return execCheck;
    }

    public void setName(String nameEntry)
    {
        this.name = nameEntry;
    }

    public String getName()
    {
        return name;
    }

    public void setSalary()
    {
        ArrayList<Executive> temp = new ArrayList<>();
        int i;
        int j;
        for(Executive exec : this.getEmployees())
                {
                    temp.add(exec);
                }
        temp.sort(Comparator.comparing(Executive::getStartingDate));
        for(i = 0; i < temp.size(); i++)
        {
            j = temp.size() - i;
            temp.get(i).setSalary(j-1, 40000);
        }
        this.payRoll = temp;
    }

    public ArrayList<Executive> getPayroll()
    {
        setSalary();
        return payRoll;
    }
}
