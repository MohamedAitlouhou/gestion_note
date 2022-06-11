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
        <h3>Creation d'un nouveau element</h3>
    </div>

    <div>

        <f:form method="GET" action="${pageContext.request.contextPath}/cadreadmin/createElement" modelAttribute="element">
            <f:input path="idMatiere" type="hidden" value="" />
            <div class="row">
                <div class="col">
                    <label for="titre">nom</label>
                    <f:input class="form-control" path="nom" id="titre" type="text" value="" />
                    <f:errors path="nom" class="text-danger" />
                </div>
                <div class="col">
                    <label for="code">code</label>
                    <f:input class="form-control" path="code" id="code" type="text" value="" />
                    <f:errors path="code" class="text-danger" />
                </div>
                <div class="col">
                    <label for="currentCoefficient">currentCoefficient</label>
                    <f:input class="form-control" path="currentCoefficient" id="currentCoefficient" type="text" value="" />
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
            <button type="submit" class="btn btn-primary">Creer</button>
            <button type="reset" class="btn btn-secondary">Reset</button>
        </f:form>

    </div>






    <jsp:include page="../fragments/userfooter.jsp" />

