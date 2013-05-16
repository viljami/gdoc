package ut.fi.viljami.confluence.gdoc;

import org.junit.Test;
import fi.viljami.confluence.gdoc.MyPluginComponent;
import fi.viljami.confluence.gdoc.MyPluginComponentImpl;

import static org.junit.Assert.assertEquals;

public class MyComponentUnitTest
{
    @Test
    public void testMyName()
    {
        MyPluginComponent component = new MyPluginComponentImpl(null);
        assertEquals("names do not match!", "myComponent",component.getName());
    }
}