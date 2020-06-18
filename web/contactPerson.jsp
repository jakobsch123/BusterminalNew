<%@ page import="at.ac.fhcampuswien.bean.LoginBean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%

    /*Disable the back button after a logout*/
    response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");
    response.setHeader("Pragma","no-cache");
    response.setHeader ("Expires", "0");

    session = request.getSession();
    LoginBean loginBean = (LoginBean) session.getAttribute("userSession");
    String svnr="";
    String birthDate="";
    String userPosition="";
    if (loginBean == null) {
        response.sendRedirect("index.jsp");
        session.setAttribute("loginMsg", "You need to login first!");
    }
    else{
        svnr = loginBean.getSvnr();
        birthDate = loginBean.getBirthDate();
        userPosition = loginBean.getUserPosition();
    }

%>
<html>
<head>
    <title>Contact Person</title>
</head>
<body>

    <p>Your SVNr:  <%=svnr%></p>
    <p>Your Birth Date:  <%=birthDate%></p>
    <p>Your Position:  <%=userPosition%></p>
    <a href="logout.jsp">Logout</a>
</body>
</html>
