# JSF com primefaces

 1. New project mavem,  arquitetura simples
 2.  Properties ->  project facets (Dynamic web module, java, java scritp, JavaServer Faces, JPA)
 3. Config web.xml 
  <welcome-file-list>
  	<welcome-file>index.xhtml</welcome-file>
  </welcome-file-list>
  <servlet>
    <servlet-name>Faces Servlet</servlet-name>
    <servlet-class>javax.faces.webapp.FacesServlet</servlet-class>
    <load-on-startup>1</load-on-startup>
  </servlet>
  <servlet-mapping>
    <servlet-name>Faces Servlet</servlet-name>
    <url-pattern>*.xhtml</url-pattern>
  </servlet-mapping>
  
 4.  add dependencies
 - <!-- https://mvnrepository.com/artifact/com.sun.faces/jsf-impl -->
 - <!-- https://mvnrepository.com/artifact/com.sun.faces/jsf-api -->