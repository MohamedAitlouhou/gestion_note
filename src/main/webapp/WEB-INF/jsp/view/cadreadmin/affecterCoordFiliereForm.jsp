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
        <h3>Affectation d'un coordinateur a une filiere</h3>
    </div>

    <div>

        <f:form method="GET" action="${pageContext.request.contextPath}/cadreadmin/affecterCoordFiliere" modelAttribute="affectCoordModel">
            <div class="row">
                <div class="col">
                    <label>filiere</label>
                    <f:select path="idFiliere" multiple="false" size="1"
                              class="form-control">
                        <f:options items="${filieres}" itemValue="idFiliere" itemLabel="titreFiliere" />
                    </f:select>
                </div>
                <div class="col">
                    <label>coordonateur</label>
                    <f:select path="idCoordinateur" multiple="false" size="1"
                              class="form-control">
                        <f:options items="${coordinateurs}" itemValue="idUtilisateur" itemLabel="nom" />
                    </f:select>
                </div>
            </div>
            <button type="submit" class="btn btn-primary">Affecter</button>
        </f:form>

        <c:if test="${message != null}">
            ${message}
        </c:if>

    </div>






    <jsp:include page="../fragments/userfooter.jsp" />

