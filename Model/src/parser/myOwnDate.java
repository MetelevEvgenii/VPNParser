package parser;

import java.util.ArrayList;

/**
 * Created by Evgenii on 03.04.2017.
 */
public class myOwnDate {
    public String date;
    public ArrayList<Integer> format= new ArrayList<>();
    public int result=0;

    public myOwnDate(String date) {
        this.date=date;
        cutDateString(date);
    }

    public void cutDateString(String tmpDate)
    {
        if (!tmpDate.equals(""))
        {
            for (String result : tmpDate.split(" |/|:")) {//дата
               this.format.add(Integer.parseInt(result));
            }
        }
    }
    public void compareDates(myOwnDate date2)
    {
        int day=0;
        int mounth=1;
        int year =2;
        if (this.format.get(year)>date2.format.get(year))//сравниваем год
        {
            result = 1;
        }//date1>date2
        else if (this.format.get(year)<date2.format.get(year))
        {
            result =  -1;
        } //date1<date2
        else if (this.format.get(year)==date2.format.get(year))
        {
                if (this.format.get(mounth) > date2.format.get(mounth))//сравниваем месяц
                {
                    result = 1;
                }
                else if (this.format.get(mounth) < date2.format.get(mounth))
                {
                    result = -1;
                }
                else if (this.format.get(mounth) == date2.format.get(mounth))
                {
                    if (this.format.get(day) > date2.format.get(day))
                    {
                        result = 1;
                    }
                     else if (this.format.get(day) < date2.format.get(day))
                    {
                        result = -1;
                    }
                }
        }
    }
    public void compare(String datatmp)
    {   myOwnDate data2= new myOwnDate(datatmp);
        compareDates(data2);
    }

    public void setDate(String date) {
        this.date = date;
        this.cutDateString(this.date);
    }
}
