<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layouts/taglib.jsp"%>

<form class="form-signin"
	action="<spring:url value="/java-blog-aggregator/j_spring_security_check"></spring:url>" method="POST">
	<h2 class="form-signin-heading">Please sign in</h2>
	<label for="inputUserID" class="sr-only">Name</label>
	 <input
		type="text" name="j_username"  id="inputUserID"  class="form-control"
		placeholder="Name" required autofocus>
	 <label for="inputPassword" class="sr-only">Password</label> 
		<input
		 type="password" name="j_password" id="inputPassword" class="form-control"
		 placeholder="Password" required>
	<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
</form>