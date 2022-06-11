<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags"%>


<jsp:include page="../fragments/userheader.jsp" />
<div class="container">

  <nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">



      <jsp:include page="../fragments/usermenu.jsp" />

    </div>
  </nav>





  <div>
    <h3>Mise a jour d'element <c:out value="${element.nom}" /></h3>
  </div>

  <div>

    <f:form method="GET" action="${pageContext.request.contextPath}/cadreadmin/updateElement" modelAttribute="element">
      <f:hidden path="idMatiere" />
      <div class="row">

      </div>
      <div class="row">
        <div class="col">
          <label>nom</label>
          <f:input class="form-control" path="nom" type="text" value="${element.nom}" />
          <f:errors path="nom" class="text-danger" />
        </div>
        <div class="col">
          <label for="code">code</label>
          <f:input class="form-control" path="code" id="code" type="text" value="${element.code}" />
          <f:errors path="code" class="text-danger" />
        </div>
        <div class="col">
          <label for="code">currentCoefficient</label>
          <f:input class="form-control" path="currentCoefficient" id="code" type="text" value="${element.currentCoefficient}" />
          <f:errors path="currentCoefficient" class="text-danger" />
        </div>
        <div class="col">
          <label>idNiveau</label>
          <f:select path="idModule" multiple="false" size="1"
                    class="form-control">
            <f:options items="${modules}" itemValue="idModule" itemLabel="titre" />
          </f:select>
        </div>
      </div>
      <button type="submit" class="btn btn-primary">Mettre a jour</button>
    </f:form>

  </div>






  <jsp:include page="../fragments/userfooter.jsp" />

