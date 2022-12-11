
//@Keil Barracliffe
//@Jeffrey Ackah

import java.util.Date;  
import java.text.SimpleDateFormat;  
import java.text.ParseException; 
public class Executive
{
    // instance variables - replace the example below with your own
    private int salary;
    private Date startingDate;
    private String name;
    private boolean isEmployed;

    public Executive()
    {
        // initialise instance variables
        salary = 0;
    }

    public boolean setEmploymentStatus(boolean flag)
    {
        if(flag = true)
        {
            isEmployed = true;
        }
        else
        {
            isEmployed = false;
        }
        return isEmployed;
    }

    public void setSalary(int salarySet, int plusBase)
    {
        // put your code here
        int adjSal = (salarySet)*5000;
        plusBase += adjSal;
        salary += plusBase;
    }

    public int getSalary()
    {
        return salary;
    }

    public void setName(String nameEntry)
    {
        this.name = nameEntry;
    }

    public String getName()
    {
        return name;
    }

    public void setStartingDate(String date) throws ParseException
    {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        startingDate = format.parse(date);
    }

    public Date getStartingDate()
    {
        return startingDate;
    }
}
