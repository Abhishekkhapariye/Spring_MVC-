<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Form -</title>
       <%--  <s:url var="url_css" value="/static/css/style.css"/>
        <link href="${url_css}" rel="stylesheet" type="text/css"/>
    </head>
    <s:url var="url_bg" value="/static/images/bg.jpg"/>
    <body background="${url_bg}"> --%>
        <table border="1" width="50%" align="center">
           <center> 
                <td height="250px" valign="top">
                    <%-- Page Content Area--%>
                    <h1>Edit Form</h1>
                    <c:if test="${err!=null}">
                        <p class="error">${err}</p>
                    </c:if>                  
                    <s:url var="save"  value="/save"/>
                    <f:form action="${save}" modelAttribute="emp1">
                        <table border="5">
                        
                         <tr>
                                <td>ID</td>
                                <td><f:input path="id" /> </td>
                            </tr>
                        
                            <tr>
                                <td>FirstName</td>
                                <td><f:input path="firstName" /> </td>
                            </tr>
                            <tr>
                                <td>LastName</td>
                                <td><f:input path="lastName" /> </td>
                            </tr>
                            <tr>
                                <td>Email</td>
                                <td><f:input path="email" /> </td>
                            </tr>
                           
                            <tr>                                
                                <td colspan="2" align="right">
                                    <button>Save</button>                                
                                </td>
                            </tr>
                            
                        </table>
                         </center>
                    </f:form>
                     
                </td>
            </tr>
            <tr>
                <td height="20px">
                    <%-- Footer --%>
                   
                </td>
            </tr>
        </table>
      
    </body>
</html>
