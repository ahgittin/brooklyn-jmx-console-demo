package io.brooklyn.ext.jmxconsole.demo

import brooklyn.config.render.RendererHints
import brooklyn.entity.Entity
import brooklyn.entity.basic.AbstractApplication
import brooklyn.entity.basic.Attributes
import brooklyn.entity.basic.Entities
import brooklyn.entity.webapp.tomcat.TomcatServer
import brooklyn.event.AttributeSensor
import brooklyn.launcher.BrooklynLauncher
import brooklyn.location.Location
import brooklyn.location.basic.LocationRegistry
import brooklyn.util.CommandLineUtil

/**
 * This code assumes you have started the JMX web console on 8200 (by running JmxWarRunner),
 * and that you have run maven to install the hello-world-webapp.war and the jmx-console.war.
 */
public class SampleJmxApp extends AbstractApplication {

    public static class JmxWebConsoleAction extends RendererHints.NamedActionWithUrl {
        public static String JMX_WEBAPP_TARGET_ENDPOINT_PROPERTY = "jmxconsole.webapp.target.url";
        public JmxWebConsoleAction(String actionName, final String jmxWebConsoleUrl) {
            super(actionName, { it -> jmxWebConsoleUrl + 
                "?"+JMX_WEBAPP_TARGET_ENDPOINT_PROPERTY+"="+it });
        }
    }

    static {
        RendererHints.register(Attributes.JMX_SERVICE_URL, new JmxWebConsoleAction("Web Console", "http://localhost:8200/"));
    }

    // above this line needed for any server which wants to show the JMX URL endpoint (with the appropriate URL for the JMX web console)
    
    // below this line sample app starting tomcat and exposing a JMX console against it
    
    TomcatServer ts = new TomcatServer(this, war: "hello-world-webapp.war");
    
    public static void main(String[] argv) {
        ArrayList args = new ArrayList(Arrays.asList(argv));
        int port = CommandLineUtil.getCommandLineOptionInt(args, "--port", 8081);
        List<Location> locations = new LocationRegistry().getLocationsById(args ?: ["localhost"]);

        SampleJmxApp app = new SampleJmxApp();
            
        BrooklynLauncher.manage(app, port)
        app.start(locations)
        Entities.dumpInfo(app)
    }

        
}
