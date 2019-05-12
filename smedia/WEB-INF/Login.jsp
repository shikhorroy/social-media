<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
<head>
  <spring:url value="/css/main.css" var="springCss"/>
  <link href="${springCss}" rel="stylesheet"/>

  <spring:url value="/css/popup.css" var="popup"/>
  <link href="${popup}" rel="stylesheet"/>

  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">
</head>
<body>
<div class="container-fluid reset-padding min-height" style="background-color: #D5D5D5;">
  <div class="menubar row font-weight-bold">
    <div class="col">
      <nav class="navbar navbar-expand-lg navbar-light" style="background-color: #0077B5">
        <div class="w-50">
          <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
              <a class="nav-link text-white" href="#"></i> Social Media</a>
            </li>
          </ul>
        </div>

        <div class="w-50">
          <ul class="nav" style="float: right">
            <li class="nav-item active">
              <%String postsUrl = request.getContextPath() + "/Posts/";%>
              <a class="nav-link text-white" href="<%= postsUrl%>"><i class="fas fa-book"></i> Posts </a>
            </li>
          </ul>
        </div>
      </nav>
    </div>
  </div>

  <div class="content row min-height reset-padding">
    <div class="content-left col-sm-3">-
      <%--<section>--%>
        <%--<div  class="box-design bg-success">--%>
          <%--<b><i class="fas fa-user-plus"></i> User Registration</b>--%>
        <%--</div>--%>
      <%--</section>--%>
    </div>
    <div class="content-mid col-sm-6 form-group" style="margin-top: 20px !important;">
      <div class="container login-container align-middle">
        <div class="row">
          <div class="col-3"></div>
          <div class="col-md-6 login-form-1">
            <h3>Login</h3>
            <% String loginUrl = request.getContextPath() + "/Login/";%>
            <form:form method="POST" action="<%=loginUrl%>" modelAttribute="smUser">
              <div class="form-group">
                <form:input path="username" class="form-control" placeholder="username" type="text" required="required"/>
              </div>
              <div class="form-group">
                <form:input path="password" class="form-control" placeholder="Password" type="password"/>
              </div>-
              <div class="form-group">
                <input type="submit" class="btn btn-primary btn-block" value="Login" />
              </div>
              <%
                String regUrl = request.getContextPath() + "/User/Registration/";
              %>
              <p class="text-center">Have no account? <a href="<%= regUrl %>">Registration</a> </p>
            </form:form>
          </div>
        </div>
      </div>
    </div>
    <div class="content-right col-sm-3">
      <%--<section>--%>
        <%--<div  class="box-design fix-right-pan-box">--%>
          <%--Welcome To Social Media.--%>
        <%--</div>--%>
		<%--</section>--%>
    </div>
  </div>
</div>

<script src="https://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

<%--<spring:url value="/js/user/registration.js" var="springJs"/>--%>
<%--<script src="${springJs}"></script>--%>
</body>

</html>