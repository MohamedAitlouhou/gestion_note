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
        <h3>Mise a jour du niveau <c:out value="${niveau.titre}" /></h3>
    </div>

    <div>

        <f:form method="GET" action="${pageContext.request.contextPath}/cadreadmin/updateNiveau" modelAttribute="niveau">
            <f:hidden path="idNiveau" />
            <div class="row">

            </div>
            <div class="row">
                <div class="col">
                    <label for="code">alias</label>
                    <f:input class="form-control" path="alias" id="code" type="text" value="${niveau.alias}" />
                    <f:errors path="alias" class="text-danger" />
                </div>
                <div class="col">
                    <label for="titre">titre</label>
                    <f:input class="form-control" path="titre" id="titre" type="text" value="${niveau.titre}" />
                    <f:errors path="titre" class="text-danger" />
                </div>
                <div class="col">
                    <label for="idFiliere">idFiliere</label>

                    <f:select path="idFiliere" multiple="false" size="1"
                              class="form-control">
                        <f:options items="${filieres}" itemValue="idFiliere" itemLabel="titreFiliere" />
                    </f:select>
                </div>
            </div>
            <button type="submit" class="btn btn-primary">Mettre a jour</button>
        </f:form>

    </div>






    <jsp:include page="../fragments/userfooter.jsp" />

