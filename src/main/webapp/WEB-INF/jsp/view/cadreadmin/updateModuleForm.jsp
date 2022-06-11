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
        <h3>Mise a jour du module <c:out value="${module.titre}" /></h3>
    </div>

    <div>

    <f:form method="GET" action="${pageContext.request.contextPath}/cadreadmin/updateModule" modelAttribute="module">
        <f:hidden path="idModule" />
        <div class="row">

        </div>
        <div class="row">
            <div class="col">
                <label for="code">code</label>
                <f:input class="form-control" path="code" id="code" type="text" value="${module.code}" />
                <f:errors path="code" class="text-danger" />
            </div>
            <div class="col">
                <label for="titre">titre</label>
                <f:input class="form-control" path="titre" id="titre" type="text" value="${module.titre}" />
                <f:errors path="titre" class="text-danger" />
            </div>
            <div class="col">
                <label for="idNiveau">idNiveau</label>
                <f:select path="idNiveau" multiple="false" size="1"
                          class="form-control">
                    <f:options items="${niveaux}" itemValue="idNiveau" itemLabel="titre" />
                </f:select>
            </div>
        </div>
        <button type="submit" class="btn btn-primary">Mettre a jour</button>
    </f:form>

    </div>






    <jsp:include page="../fragments/userfooter.jsp" />

