<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
<head>
  <%--<spring:url value="/js/populate.js" var="springJs"/>--%>
  <%--<script src="${springJs}"></script>--%>

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
              <a class="nav-link text-white" href="#"><i class="fas fa-home"></i> Home</a>
            </li>
          </ul>
        </div>

        <div class="w-50">
          <ul class="nav" style="float: right">
            <li class="nav-item active">
              <a class="nav-link text-white" href="#"><i class="fas fa-user-circle"></i><span class="menu-text"> Profile</span></a>
            </li>
            <li class="nav-item active">
              <a class="nav-link text-white" href="#"><i class="fas fa-bell"></i> Notification</a>
            </li>
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle text-white" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <i class="fas fa-cog"></i> Settings</a>
              <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                <a class="dropdown-item" href="#">Action</a>
                <a class="dropdown-item" href="#">Another action</a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="#">Something else here</a>
              </div>
            </li>
          </ul>
        </div>
      </nav>
    </div>
  </div>

  <div class="content row min-height reset-padding">
    <div class="content-left col-sm-3">
      <section>
        <div  class="box-design">
          this is sample info
        </div>
      </section>
    </div>
    <div class="content-mid col-sm-6 reset-padding">
      <section>
        <div class="status text">
          <i class="far fa-user-circle img"></i>
          <textarea placeholder="What's in your mind ..."></textarea>
          <input type="submit" value="post"/>
        </div>
      </section>
      <div class="overlay"></div>
      <section>
        <div  class="box-design fix-mid-pan-box">
          this is sample info
        </div>
      </section>
      <!--<% String postUrl = request.getContextPath() + "/User/Registration/Add/";%>-->
      <%--<form:form method="POST" action="<%=postUrl%>" modelAttribute="smUser">--%>
        <%--<table>--%>
          <%--<tr>--%>
            <%--<td><form:label path="id">ID</form:label></td>--%>
            <%--<td><form:input path="id"/></td>--%>
          <%--</tr>--%>
          <%--<tr>--%>
            <%--<td><form:label path="userName">Name</form:label></td>--%>
            <%--<td><form:input path="userName"/></td>--%>
          <%--</tr>--%>
          <%--<tr>--%>
            <%--<td><input type="submit" value="Submit"/></td>--%>
          <%--</tr>--%>
        <%--</table>--%>
      <%--</form:form>--%>
    </div>
    <div class="content-right col-sm-3">
      <section>
		  <div  class="box-design fix-right-pan-box">
			this is sample info
		  </div>
		</section>
    </div>
  </div>
</div>

<script src="https://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>

</html>