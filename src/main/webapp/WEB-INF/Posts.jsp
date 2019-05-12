<%@ page import="com.socialmedia.socialmedia.models.SmUserDetail" %>
<%@ page import="org.joda.time.LocalDate" %>
<%@ page import="com.socialmedia.socialmedia.models.SmPost" %>
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
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css"
        integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">
</head>
<body>
<div class="container-fluid reset-padding min-height" style="background-color: #D5D5D5;">
  <div class="menubar row font-weight-bold">
    <div class="col">
      <nav class="navbar navbar-expand-lg navbar-light smedia-theme">
        <div class="w-50">
          <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
              <% String homeUrl = request.getContextPath() + "/Home/";%>
              <a class="nav-link text-white" href="<%= homeUrl %>">Social Media</a>
            </li>
          </ul>
        </div>

        <div class="w-50"></div>
      </nav>
    </div>
  </div>

  <div class="content row min-height reset-padding">
    <div class="content-left col-sm-3">
    </div>
    <div class="content-mid col-sm-6 reset-padding">
      <div class="overlay"></div>

      <c:forEach items="${publicPostList}" var="publicPost">
        <div class="box-design fix-mid-pan-box">
          <div class="row user-summary">
            <div class="col-md-1">
              <i class="fas fa-user-circle post-profile-pic" style="font-size: 60px;"></i>
            </div>
            <div class="col">
              <div class="row">
                <div class="col-md-11 font-weight-bold">
                  ${publicPost.user.username}
                </div>
                <%--<div class="col">--%>
                  <%--<%--%>
                    <%--SmPost smPost = (SmPost) pageContext.getAttribute("publicPost");--%>
                    <%--String postEditUrl = request.getContextPath() + "/Post/Edit/" + smPost.getId() + "/";--%>
                  <%--%>--%>
                  <%--<a href="<%=postEditUrl%>"><i class="fas fa-ellipsis-h"></i></a>--%>
                <%--</div>--%>
              </div>
              <div class="row">
                <div class="col-md-4">
                  Updated On: ${publicPost.modifiedOn}
                </div>
                <div class="col">
                  <i class="fas fa-map-marker-alt" style="font-size: 16px; color: darkgreen"></i> <c:choose><c:when test="${empty publicPost.location.name}">UNKNOWN LOCATION</c:when><c:otherwise>${publicPost.location.name}</c:otherwise></c:choose>
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col post-content">
              <section>
                <div class="">
                    ${publicPost.status}
                </div>
              </section>
            </div>
          </div>
        </div>
      </c:forEach>
    </div>
    <div class="content-right col-sm-3">
      <section>
        <%--<div class="box-design fix-right-pan-box">--%>
        <%--</div>--%>
      </section>
    </div>
  </div>
</div>

<script src="https://code.jquery.com/jquery-3.4.1.min.js"
        integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>

</html>
