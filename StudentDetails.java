import java.lang.*;
import java.util.*;
import java.io.*;

// create table student(RID int, Name varchar(255), Salary int);
// Database table / schema
class Student
{
    public int RID;
    public String Name;
    public int Salary;

    private static int Generator;

    static
    {
        Generator = 0;
    }

    public Student(String str, int value)
    {
        this.RID = ++Generator;
        this.Name = str;
        this.Salary = value;
    }
    
    public void DisplayData()
    {
        System.out.println("  "+this.RID + "\t\t" + this.Name + "\t\t\t" + this.Salary);
    }
}

class DBMS
{
   public LinkedList <Student> lobj;

    public DBMS()
    {
        lobj = new LinkedList<>();
    }

    // Insert into student Harshal 1000;
    // select * from student
    public void StartDBMS()
    {
        Scanner scanobj = new Scanner(System.in);

        System.out.println(ANSI_BLUE+"\n  Customized virtual DBMS started succesfully....\n"+ANSI_RESET);
        String Query = "";

        while(true)
        {
            System.out.print(" CVDBMS console > ");
            Query = scanobj.nextLine();

            Query = Query.toLowerCase();

            String tokens[] = Query.split(" ");
            int QuerySize = tokens.length;

            try
            {
                    
                if(QuerySize == 1)
                {
                    if("help".equals(tokens[0]))
                    {
                        System.out.println(ANSI_PURPLE+"_____________________________________________________________________________________________\n"+ANSI_RESET);
                        System.out.println(ANSI_GREEN+"\t\t\tcustomized Virtual Database Management System"+ANSI_RESET);
                        System.out.println(ANSI_PURPLE+"_____________________________________________________________________________________________\n"+ANSI_RESET);
                        System.out.println("This application is used to demonstrates the customised DBMS");
                        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
                        System.out.println("Terminate DBMS \t\t: \texit");
                        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
                        System.out.println("Display all data \t: \tselect * from student");
                        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
                        System.out.println("Insert data \t\t: \tinsert into student name Salary");
                        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
                        System.out.println("Update name or Salary \t: \tupdate student set name/salary = abc/1000 where rid = 1");
                        System.out.println("Update name & salary \t: \tupdate student set name = abc salary = 1000 where rid = 2\n\t\t\t\tupdate student set salary = 1000 name = abc where rid = 1");
                        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
                        System.out.println("Delete data \t\t: \tdelete from student whrere rid/name = 1/abc");
                        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
                        System.out.println("Search data \t\t: \tselect * from student where rid/name = 1/abc");
                        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
                        System.out.println("Find maximum salary \t: \tselect max salary from student");
                        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
                        System.out.println("Find Minimum salary \t: \tselect min salary from student");
                        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
                        System.out.println("Find Sum of salary \t: \tselect sum salary from student");
                        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
                        System.out.println("Find average of salary \t: \tselect avg salary from student");
                        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
                        System.out.println("Total count of student \t: \tselect count from student");
                        System.out.println(ANSI_PURPLE+"_____________________________________________________________________________________________\n"+ANSI_RESET);
                        System.out.println(ANSI_GREEN+"\t\t\tThank You ..."+ANSI_RESET);
                        System.out.println(ANSI_PURPLE+"_____________________________________________________________________________________________\n"+ANSI_RESET);
                    }
                    else if("exit".equals(tokens[0]))
                    {
                        System.out.println(ANSI_BLUE+"\n  Thank you for using Customized Virtual DBMS\n"+ANSI_RESET);
                        break;
                    }else {Error();}
                }
               
                //select * from student
                //select count from student
                else if(QuerySize == 4)
                {
                    if("select".equals(tokens[0]))
                    {
                        if("from".equals(tokens[2]))
                        {
                            if("student".equals(tokens[3]))
                            {
                                if("*".equals(tokens[1]))
                                {
                                    DisplayAll();
                                }
                                else if("count".equals(tokens[1]))
                                {
                                    AggregateCount();
                                }else {Error();}
                            }else {Error();}
                        }else {Error();}
                    }else {Error();}
                }

                else if(QuerySize == 5)
                {
                    // Insert into student Piyush 1000;
                    if("insert".equals(tokens[0]))
                    {
                        if("into".equals(tokens[1]))
                        {
                            if("student".equals(tokens[2]))
                            {
                                InsertData(tokens[3],Integer.parseInt(tokens[4]));
                            }else {Error();}
                        }else {Error();}
                    }

                    //select max salary from student
                    //select min salary from student
                    //select sum salary from student
                    //select avg salary from student
                    else if("select".equals(tokens[0]))
                    {
                        if("salary".equals(tokens[2]))
                        {
                            if("from".equals(tokens[3]))
                            {
                                if("student".equals(tokens[4]))
                                {
                                    if("max".equals(tokens[1]))
                                    {
                                        AggregateMax();
                                    }
                                    else if("min".equals(tokens[1]))
                                    {
                                        AggregateMin();
                                    }
                                    else if("sum".equals(tokens[1]))
                                    {
                                        AggregateSum();
                                    }
                                    else if("avg".equals(tokens[1]))
                                    {
                                        AggregateAvg();
                                    }else {Error();}
                                }else {Error();}
                            }else {Error();}
                        }else {Error();}
                    }else {Error();}
                }

                //delete from student whrere rid = 1
                else if(QuerySize == 7)
                {
                    if("delete".equals(tokens[0]))
                    {
                        if("from".equals(tokens[1]))
                        {
                            if("student".equals(tokens[2]))
                            {
                                if("where".equals(tokens[3]))
                                {
                                    if("=".equals(tokens[5]))
                                    {
                                        if("rid".equals(tokens[4]))
                                        {
                                            DeleteSpecific(Integer.parseInt(tokens[6]));
                                        }
                                        else  if("name".equals(tokens[4]))
                                        {
                                            DeleteSpecific(tokens[6]);
                                        }else {Error();}
                                    }else {Error();}
                                }else {Error();}
                            }else {Error();}
                        }else {Error();}
                    }else {Error();}
                }

                //update student set name/salary = abc/2000 where rid = 1
                else if(QuerySize == 10)
                {
                    if("update".equals(tokens[0]))
                    {
                        if("student".equals(tokens[1]))
                        {
                            if("set".equals(tokens[2]))
                            {
                                if("=".equals(tokens[4]))
                                {
                                    if("where".equals(tokens[6]))
                                    {
                                        if("rid".equals(tokens[7]))
                                        {
                                            if("=".equals(tokens[8]))
                                            {
                                                if("name".equals(tokens[3]))
                                                {
                                                    UpdateSpecific(Integer.parseInt(tokens[9]), tokens[5]);
                                                }
                                                else
                                                if("salary".equals(tokens[3]))
                                                {
                                                    UpdateSpecific(Integer.parseInt(tokens[9]),Integer.parseInt(tokens[5]));
                                                }else {Error();}
                                            }else {Error();}
                                        }else {Error();}
                                    }else {Error();}
                                }else {Error();}
                            }else {Error();}
                        }else {Error();}
                    }else {Error();}
                }

                //  0       1     2    3  4  5    6    7   8    9    10 11 12
                //update student set name = abc salary = 1000 where rid = 2

                //  0       1     2    3    4   5    6  7  8   9    10 11 12
                //update student set salary = 1000 name = xyz where rid = 1
                else if(QuerySize == 13)
                {
                    if("update".equals(tokens[0]))
                    {
                        if("student".equals(tokens[1]))
                        {
                            if("set".equals(tokens[2]))
                            {
                                if("=".equals(tokens[4]))
                                {
                                    if("=".equals(tokens[7]))
                                    {
                                        if("where".equals(tokens[9]))
                                        {
                                            if("rid".equals(tokens[10]))
                                            {
                                                if("=".equals(tokens[11]))
                                                {
                                                    if("name".equals(tokens[3]))
                                                    {
                                                        if("salary".equals(tokens[6]))
                                                        {
                                                            UpdateSpecific(Integer.parseInt(tokens[12]), tokens[5], Integer.parseInt(tokens[8]));
                                                        }else {Error();}
                                                    }
                                                    else if("salary".equals(tokens[3]))
                                                    {
                                                        if("name".equals(tokens[6]))
                                                        {
                                                            UpdateSpecific(Integer.parseInt(tokens[12]), tokens[8], Integer.parseInt(tokens[5]));
                                                        }else {Error();}
                                                    }else {Error();}
                                                }else {Error();}
                                            }else {Error();}
                                        }else {Error();}
                                    }else {Error();}
                                }else {Error();}
                            }else {Error();}
                        }else {Error();}
                    }else {Error();}
                }

                //select * from student where rid = 1
                //select * from student where name = abc
                else if(QuerySize == 8)
                {
                    if("select".equals(tokens[0]))
                    {
                        if("*".equals(tokens[1]))
                        {
                            if("from".equals(tokens[2]))
                            {
                                if("student".equals(tokens[3]))
                                {
                                    if("where".equals(tokens[4]))
                                    {
                                        if("=".equals(tokens[6]))
                                        {
                                            if("rid".equals(tokens[5]))
                                            {
                                                DisplaySpecific(Integer.parseInt(tokens[7]));
                                            }
                                            else if("name".equals(tokens[5]))
                                            {
                                                DisplaySpecific(tokens[7]);
                                            }else {Error();}
                                        }else {Error();}
                                    }else {Error();}
                                }else {Error();}
                            }else {Error();}
                        }else {Error();}
                    }else {Error();}
                }
                else if(QuerySize == 0 || QuerySize == 2 || QuerySize == 3 || QuerySize == 6 || QuerySize == 9 || QuerySize == 11 || QuerySize == 12 || QuerySize > 13 )
                {
                    Error();
                }

            }
            catch(Exception e)
            {
                System.out.println("   Invalid query!!!  Please enter valid query (help)");
            }
        }
    }

    public void Error()
    {
        System.out.println(ANSI_RED+ "  Invalid query!!!  Please enter valid query (help)"+ ANSI_RESET);
    }
    // Insert into query
    public void InsertData(String str, int value)
    {
        Student sobj = new Student(str,value);
        lobj.add(sobj);
        System.out.println(ANSI_GREEN+ "  Student Inserted Successfully..."+ ANSI_RESET);

    }

    // Display all without condition
    public void DisplayAll()
    {
        if(lobj.size() == 0)
        {
            System.out.println(ANSI_RED+ "   Student table is empty !!!"+ ANSI_RESET);
        }
        else
        {
            System.out.println(ANSI_PURPLE+"___________________________________________________\n"+ANSI_RESET);
            System.out.println("  RID\t\tStudent Name\t\tSalary");
            System.out.println(ANSI_PURPLE+"___________________________________________________\n"+ANSI_RESET);
            for(Student sref : lobj)
            {
                sref.DisplayData();
            }
            System.out.println(ANSI_PURPLE+"___________________________________________________\n"+ANSI_RESET);
        }
    }

    // Display by RID
    public void DisplaySpecific(int rid)
    {
        int Count = 0;
         for(Student sref : lobj)
        {
            if(sref.RID == rid)
            {
                System.out.println(ANSI_PURPLE+"___________________________________________________\n"+ANSI_RESET);
                System.out.println("  RID\t\tStudent Name\t\tSalary");
                System.out.println(ANSI_PURPLE+"___________________________________________________\n"+ANSI_RESET);
                sref.DisplayData();
                System.out.println(ANSI_PURPLE+"___________________________________________________\n"+ANSI_RESET);
                Count++;
                break;
            } 
        }
        if(Count == 0)
        {
           System.out.println(ANSI_RED+"  Student details not found !!!"+ANSI_RESET);
        }
    }

    // Display by name
    public void DisplaySpecific(String str)
    {
        int Count = 0;
         for(Student sref : lobj)
        {
            if(str.equals(sref.Name))
            {
                System.out.println(ANSI_PURPLE+"___________________________________________________\n"+ANSI_RESET);
                System.out.println("  RID\t\tStudent Name\t\tSalary");
                System.out.println(ANSI_PURPLE+"___________________________________________________\n"+ANSI_RESET);
                sref.DisplayData();
                System.out.println(ANSI_PURPLE+"___________________________________________________\n"+ANSI_RESET);
                Count++;
            }
            
        }
        if(Count == 0)
        {
           System.out.println(ANSI_RED+"  Student details not found !!!"+ANSI_RESET);
        }
    }

    // Delete by RID
    public void DeleteSpecific(int rid)
    {
        int index = 0,Count = 0;

        for(Student sref : lobj)
        {
            if(sref.RID == rid)
            {
                lobj.remove(index);
                System.out.println(ANSI_RED+ "  Student Deleted Successfully..."+ ANSI_RESET);
                Count++;
                break;
            }
            index++;
        }
        if(Count == 0)
        {
           System.out.println(ANSI_RED+"  Student details not found !!!"+ANSI_RESET);
        }
    }

    // Delete by Name
    public void DeleteSpecific(String str)
    {
        int index = 0,Count = 0;

        for(Student sref : lobj)
        {
            if(str.equals(sref.Name))
            {
                lobj.remove(index);
                System.out.println(ANSI_RED+ "  Student Deleted Successfully..."+ ANSI_RESET);
                Count++;
                break;
            }
            index++;
        }
        if(Count == 0)
        {
           System.out.println(ANSI_RED+"  Student details not found !!!"+ANSI_RESET);
        }
    }

    // update  name
    public void UpdateSpecific(int rid,String name)
    {
        int Count = 0;
        for(Student sref : lobj)
        {
            if(sref.RID == rid)
            {
                sref.Name = name;
                System.out.println(ANSI_GREEN+ "  Student Updated Successfully..."+ ANSI_RESET);
                Count++;
                break;
            }
        }
        if(Count == 0)
        {
           System.out.println(ANSI_RED+"  Student details not found !!!"+ANSI_RESET);
        }
    }

     // update salary
     public void UpdateSpecific(int rid,int salary)
     {
        int Count = 0;
         for(Student sref : lobj)
         {
             if(sref.RID == rid)
             {
                 sref.Salary = salary;
                 System.out.println(ANSI_GREEN+ "  Student Updated Successfully..."+ ANSI_RESET);
                 Count++;
                 break;
             }
         }
         if(Count == 0)
        {
           System.out.println(ANSI_RED+"  Student details not found !!!"+ANSI_RESET);
        }
     }

      // update name,salary
      public void UpdateSpecific(int rid,String name,int salary)
      {
        int Count = 0;
        for(Student sref : lobj)
        {
            if(sref.RID == rid)
            {
                sref.Name = name;
                sref.Salary = salary;
                System.out.println(ANSI_GREEN+ "  Student Updated Successfully..."+ ANSI_RESET);
                Count++;
                break;
            }
        }
        if(Count == 0)
        {
           System.out.println(ANSI_RED+"  Student details not found !!!"+ANSI_RESET);
        }
      }

     //count max 
    public void AggregateMax()
    {
        int iMax = 0;
        Student temp = null;

        if(lobj.size() == 0)
        {
            System.out.println(ANSI_RED+ "   Student table is empty !!!"+ ANSI_RESET);
        }
        else
        {
            for(Student sref : lobj)
            {
                if(sref.Salary > iMax)
                {
                    iMax = sref.Salary;
                    temp = sref;
                }
            }
            System.out.println(ANSI_GREEN+"  Information of student having maximum salary : "+ANSI_RESET);
            System.out.println(ANSI_PURPLE+"___________________________________________________\n"+ANSI_RESET);
            System.out.println("  RID\t\tStudent Name\t\tSalary");
            System.out.println(ANSI_PURPLE+"___________________________________________________\n"+ANSI_RESET);
            temp.DisplayData();
            System.out.println(ANSI_PURPLE+"___________________________________________________\n"+ANSI_RESET);
        }
    }

    //count min
    public void AggregateMin()
    {
        if(lobj.size() == 0)
        {
            System.out.println(ANSI_RED+ "   Student table is empty !!!"+ ANSI_RESET);
        }
        else
        {

            int iMin = (lobj.getFirst()).Salary;
            Student temp = lobj.getFirst();

            for(Student sref : lobj)
            {
                if(sref.Salary < iMin)
                {
                    iMin = sref.Salary;
                    temp = sref;
                }
            }

            System.out.println(ANSI_GREEN+"Information of student having minimum salary : "+ANSI_RESET);
            System.out.println(ANSI_PURPLE+"___________________________________________________\n"+ANSI_RESET);
            System.out.println("  RID\t\tStudent Name\t\tSalary");
            System.out.println(ANSI_PURPLE+"___________________________________________________\n"+ANSI_RESET);
            temp.DisplayData();
            System.out.println(ANSI_PURPLE+"___________________________________________________\n"+ANSI_RESET);    
        }
    }

    //count min
    public void AggregateSum()
    {
        long iSum = 0;
        if(lobj.size() == 0)
        {
            System.out.println(ANSI_RED+ "   Student table is empty !!!"+ ANSI_RESET);
        }
        else
        {
            for(Student sref : lobj)
            {
                iSum = iSum + sref.Salary;
            }

            System.out.println("Summation of salaries is : "+ iSum);
        }
    }

    // count avg 
    public void AggregateAvg()
    {
        long iSum = 0;
        if(lobj.size() == 0)
        {
            System.out.println(ANSI_RED+ "   Student table is empty !!!"+ ANSI_RESET);
        }
        else
        {
            for(Student sref : lobj)
            {
                iSum = iSum + sref.Salary;
            }

            System.out.println("Average salary is : "+ iSum / (lobj.size()));
        }
    }

    public void AggregateCount()
    { if(lobj.size() == 0)
        {
            System.out.println(ANSI_RED+ "   Student table is empty !!!"+ ANSI_RESET);
        }
        else
        {
            System.out.println("Count is : "+lobj.size());
        }
    }


    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
  

}

class StudentDetails
{
    public static void main(String arg[])
    {
        DBMS dobj = new DBMS();

        dobj.StartDBMS();
    }
}