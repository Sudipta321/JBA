<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
		<title><tiles:getAsString name="title"/></title>
		
		<tiles:insertAttribute name="css" />
		
		<tiles:insertAttribute name="js" />
		<!-- <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script> -->
		<!-- <script src="/java-blog-aggregator/assects/js/bootstrap.min.js"></script> -->
		
		<!-- jQuery CDN lib -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
	</head>
	<body>
	<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>
	    <tilesx:useAttribute name="current"/>
	    <div class="container">
	    <!-- Static navbar -->
      <nav class="navbar navbar-default">
        <div class="container-fluid">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="<spring:url value="/"/>">JBA</a>
          </div>
          <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
              <li class="${current =='hello'?'active':'' }"><a href='<spring:url value="/"/>'>Home</a></li>
              <security:authorize access="hasRole('ROLE_ADMIN')">
              <li class="${current =='users'?'active':'' }"><a href='<spring:url value="/users"></spring:url>'>Users</a></li>
              </security:authorize>
              <li class="${current =='about'?'active':'' }"><a href='<spring:url value="/about"></spring:url>'>About</a></li>
              <li class="${current =='contact'?'active':''}"><a href='<spring:url value="/contact"></spring:url>'>Contact</a></li>
              <li class="${current =='register'?'active':''}"><a href='<spring:url value="/register"></spring:url>'>Register</a></li>
              <security:authorize access="isAuthenticated()">
              <li class="${current =='users'?'active':'' }"><a href='<spring:url value="/account"></spring:url>'>My account</a></li>
              </security:authorize>
            </ul>
         <ul class="nav navbar-nav navbar-right">
<!--               <li>
                <a href="#">
                <form class="form-inline">
		        <input type="text" class="form-control input-sm" placeholder="Search....">
		        <button type="submit" class="btn btn-default btn-sm">Submit</button>
		        </form>
		        </a>
		      </li>
 -->              <li><a href="#">Static top</a></li>
              <security:authorize access="! isAuthenticated()">
              <li class="${current =='sign_in'?'active':''}"><a href='<spring:url value="/login"></spring:url>'>Sign In</a></li>
              </security:authorize>
              <security:authorize access="isAuthenticated()">
              <li><a href='<spring:url value="/logout"></spring:url>'>Sign Out</a></li>
              </security:authorize>
            </ul> 
            
          </div><!--/.nav-collapse -->
        </div><!--/.container-fluid -->
      </nav>
		<tiles:insertAttribute name="body"/>
		<br><br>
		<center>
		<tiles:insertAttribute name="footer"/>
		</center>
		</div>
	</body>
</html>