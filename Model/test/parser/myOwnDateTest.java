package parser;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Evgenii on 03.04.2017.
 */
public class myOwnDateTest {
    public String data1 = "23/03/17 08:29";
    public String data2 = "23/04/17 08:29";
    @Test
    public void splitStringDate()
    {
        int sum=0;
        myOwnDate date = new myOwnDate(data1);
        for (int i=0;i<5;i++)
        {
            sum=sum+date.format.get(i);
        }
        assertEquals(sum,80);
    }
    @Test
    public void testDateTime()
    {
        myOwnDate date1c = new myOwnDate(data1);
        myOwnDate data2c = new myOwnDate(data2);
        date1c.compareDates(data2c);
        assertEquals(-1,date1c.result);
    }
    @Test
    public void testDateTime2()
    {
        myOwnDate date1 = new myOwnDate("23/03/17 08:29");
        myOwnDate date2 = new myOwnDate("15/03/17 08:29");;
        date1.compareDates(date2);
        assertEquals(1, date1.result);
    }
    @Test
    public void testDateTime3()
    {
        myOwnDate date1 = new myOwnDate("23/03/17 08:29");
        myOwnDate date2 = new myOwnDate("00/00/00 00:00");;
        date1.compareDates(date2);
        assertEquals(1, date1.result);
    }
    @Test
    public void setDateTest()
    {
        myOwnDate[] date1 = new myOwnDate[2];
       // myOwnDate date2 = new myOwnDate("00/00/00 00:00");
        date1[0]= new myOwnDate("23/03/17 08:29");
        date1[1] = new myOwnDate("00/00/00 00:00");
        //date1[1].setDate("00/00/00 00:00");
        date1[0].compareDates(date1[1]);
        System.out.println(date1[0].dateString);
        System.out.println(date1[1].dateString);
        assertEquals(1, date1[0].result);
    }

    @Test
    public void sortDates()
    {
        myOwnDate[] date1 = new myOwnDate[4];
        // myOwnDate date2 = new myOwnDate("00/00/00 00:00");
        date1[0]= new myOwnDate("23/03/17 08:29");
        date1[1] = new myOwnDate("00/00/00 00:00");
        date1[2]= new myOwnDate("23/05/17 05:00");
        date1[3]= new myOwnDate("15/03/16 14:32");
        date1[0].sortDate(date1);
        for (int i=0; i <4;i++)
        {
            System.out.println(date1[i].dateString);
        }
    }


}
