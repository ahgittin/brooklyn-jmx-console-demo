
Brooklyn JMX Console Integration
================================

This project contains Brooklyn GUI support for a JMX console, allowing a 
JMX endpoint sensor on an entity to be linked in the Brooklyn console
to a web-app which allows drill-down into JMX data points.

The code snippet is very small, and it is embedded in the class
SampleJmxApp in this demo.  That class starts a Tomcat server
and sets up an active link from the JMX endpoint exposed by Tomcat.


### Pre-Requisites

You must have the projects github.com:brooklyncentral/brooklyn and github.com:ahgittin/jmx-console-webapp checked out and built
(with `mvn clean install`) and available in your local m2 repository.

For more information on the underlying JMX console see
the [github.com:ahgittin/jmx-console-webapp](http://github.com/ahgittin/jmx-console-webapp) project.


### Compile

To compile this project simply `mvn clean install` in the brooklyn-jmx-console-demo project, then run the JmxWarRunner (to start the JMX web console) and SampleJmxApp (to start the app in Brooklyn) classes.
(You can also start SampleJmxApp in the other standard ways offfered by
[Brooklyn](http://brooklyncentral.github.com).)

### Usage

To use in your own project, simply set up your POM as per this project and follow the instructions in the SampleJmxApp class.

### Screenshots

Here is a sequence of screenshots showing the application: 

**The Tomcat entity in Brooklyn, rolled out by SampleApp; note the "Web Console" link next to the JMX endpoint sensor:**

[![Screenshot](http://github.com/ahgittin/brooklyn-jmx-console-demo/raw/master/docs/small/brooklyn.png "Screenshot")](http://github.com/ahgittin/brooklyn-jmx-console-demo/raw/master/docs/brooklyn.png)

**The JMX console, Catalina objects:**

[![Screenshot](http://github.com/ahgittin/brooklyn-jmx-console-demo/raw/master/docs/small/jmx-catalina.png "Screenshot")](http://github.com/ahgittin/brooklyn-jmx-console-demo/raw/master/docs/jmx-catalina.png)

**The JMX console, stats for Catalina (this includes some of the same stats read by Brooklyn and shown in the Brooklyn Sensors tab above):**

[![Screenshot](http://github.com/ahgittin/brooklyn-jmx-console-demo/raw/master/docs/small/jmx-catalina-stats.png "Screenshot")](http://github.com/ahgittin/brooklyn-jmx-console-demo/raw/master/docs/jmx-catalina-stats.png)

**Our "hello-world" webapp running in Tomcat (for good measure):**

[![Screenshot](http://github.com/ahgittin/brooklyn-jmx-console-demo/raw/master/docs/small/hello-webapp.png "Screenshot")](http://github.com/ahgittin/brooklyn-jmx-console-demo/raw/master/docs/hello-webapp.png)
