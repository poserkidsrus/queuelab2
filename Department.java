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
    private ArrayList<Date> seniority;

    public Department()
    {
        // initialise instance variables
        employees = new LinkedList<>();
        seniority = new ArrayList<>();
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

    public void startingDateList()
    {
        for(Executive exec : getEmployees())
        {
                seniority.add(exec.getStartingDate());
        }
    }

    public ArrayList<Date> getStartingDateList()
    {
        startingDateList();
        return seniority;
    }

}
