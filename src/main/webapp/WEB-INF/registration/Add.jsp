<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
<head>
  <script src="https://code.jquery.com/jquery-2.2.4.js" type="text/javascript"></script>
  <%--<spring:url value="/js/populate.js" var="springJs"/>--%>
  <%--<script src="${springJs}"></script>--%>

  <spring:url value="/css/main.css" var="springCss"/>-
  <link href="${springCss}" rel="stylesheet"/>

  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<div class="container-fluid bg-primary">
  <div class="row font-weight-bold">
    <div class="col">
      <nav class="navbar navbar-expand-lg navbar-light" style="background-color: #0077B5">
        <div class="col-lg-6">
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
              <a class="nav-link text-white" href="#">Home <span class="sr-only">(current)</span></a>
            </li>
          </ul>-
          <form class="mx-2 my-auto d-inline w-100">
            <div class="input-group">
              <input type="text" class="form-control border border-right-0" placeholder="Search...">
              <span class="input-group-append">
                <button class="btn btn-outline-secondary border border-left-0" type="button">
                    <i class="fa fa-search"></i>
                </button>
              </span>
            </div>
          </form>
        </div>
        </div>
        <div class="col-md-5">
        <div class="">
          <ul class="nav pull-right">
            <li class="nav-item dropdown pull-right">
              <a class="nav-link dropdown-toggle text-white" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
                 aria-haspopup="true" aria-expanded="false">
                Dropdown
              </a>
              <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                <a class="dropdown-item" href="#">Action</a>
                <a class="dropdown-item" href="#">Another action</a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="#">Something else here</a>
              </div>
            </li>
          </ul>
        </div>
        </div>
      </nav>
    </div>
  </div>
  <div class="row">
    <div class="col-sm-2">
      1 of 3
    </div>
    <div class="col-sm-8">
      <% String postUrl = request.getContextPath() + "/User/Registration/Add/";%>
      <form:form method="POST" action="<%=postUrl%>" modelAttribute="smUser">
        <table>
          <tr>
            <td><form:label path="id">ID</form:label></td>
            <td><form:input path="id"/></td>
          </tr>
          <tr>
            <td><form:label path="userName">Name</form:label></td>
            <td><form:input path="userName"/></td>
          </tr>
          <tr>
            <td><input type="submit" value="Submit"/></td>
          </tr>
        </table>
      </form:form>
    </div>
    <div class="col-sm-2">
      3 of 3
    </div>
  </div>
</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>

</html>