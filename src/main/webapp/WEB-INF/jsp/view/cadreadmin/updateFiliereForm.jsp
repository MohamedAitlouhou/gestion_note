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
        <h3>Mise a jour du filiere <c:out value="${filiere.titreFiliere}" /></h3>
    </div>

    <div>

        <f:form method="GET" action="${pageContext.request.contextPath}/cadreadmin/updateFiliere" modelAttribute="filiere">
            <f:hidden path="idFiliere" />
            <div class="row">

            </div>
            <div class="row">
                <div class="col">
                    <label for="titre">titreFiliere</label>
                    <f:input class="form-control" path="titreFiliere" id="titre" type="text" value="${niveau.titreFiliere}" />
                    <f:errors path="titreFiliere" class="text-danger" />
                </div>
                <div class="col">
                    <label for="code">codeFiliere</label>
                    <f:input class="form-control" path="codeFiliere" id="code" type="text" value="${niveau.codeFiliere}" />
                    <f:errors path="codeFiliere" class="text-danger" />
                </div>
                <div class="col">
                    <label for="titre">anneeaccreditation</label>
                    <f:input class="form-control" path="anneeaccreditation" id="titre" type="text" value="${niveau.anneeaccreditation}" />
                    <f:errors path="anneeaccreditation" class="text-danger" />
                </div>
                <div class="col">
                    <label for="titre">anneeFinaccreditation</label>
                    <f:input class="form-control" path="anneeFinaccreditation" id="titre" type="text" value="${niveau.anneeFinaccreditation}" />
                    <f:errors path="anneeFinaccreditation" class="text-danger" />
                </div>
            </div>
            <button type="submit" class="btn btn-primary">Mettre a jour</button>
        </f:form>

    </div>






    <jsp:include page="../fragments/userfooter.jsp" />

