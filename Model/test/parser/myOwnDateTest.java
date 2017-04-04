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
        myOwnDate date1 = new myOwnDate(data1);;
        date1.compare(data2);
        assertEquals(-1,date1.result);
    }
    @Test
    public void testDateTime2()
    {
        myOwnDate date1 = new myOwnDate("23/03/17 08:29");;
        date1.compare("15/03/17 08:29");
        assertEquals(1, date1.result);
    }



}
