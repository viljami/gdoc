package it.fi.viljami.confluence.gdoc;

import org.junit.Test;
import org.junit.runner.RunWith;
import com.atlassian.plugins.osgi.test.AtlassianPluginsTestRunner;
import fi.viljami.confluence.gdoc.GdocMacro;
import com.atlassian.sal.api.ApplicationProperties;

import static org.junit.Assert.assertEquals;

@RunWith(AtlassianPluginsTestRunner.class)
public class GdocMacroWiredTest
{
    private final ApplicationProperties applicationProperties;
    private final GdocMacro gdocMacro;

    public GdocMacroWiredTest(ApplicationProperties applicationProperties,GdocMacro gdocMacro)
    {
        this.applicationProperties = applicationProperties;
        this.gdocMacro = gdocMacro;
    }

    @Test
    public void testMyName()
    {
        //assertEquals("names do not match!", "myComponent:" + applicationProperties.getDisplayName(),myPluginComponent.getName());
    }
}