package parser;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by Evgenii on 25.03.2017.
 */
public class testParser {
    @Test
    public void checkAdressURL()
    {
        Parser parser = new Parser();
        assertEquals("vpn.unn.ru",parser.getURL());
    }
    
}
