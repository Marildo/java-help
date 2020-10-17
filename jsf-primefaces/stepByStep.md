# JSF com primefaces

 1. New project mavem,  arquitetura simples
 2.  Properties ->  project facets (Dynamic web module, java, java scritp, JavaServer Faces, JPA)
 3. Config web.xml 
  ˋˋˋ
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
  ˋˋˋ
  
 4.  add dependencies em pom.xml
 
 5. Project Properties --> Deployment Assembly, add Java Build Path Entries