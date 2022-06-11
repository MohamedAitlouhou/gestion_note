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
        <h3>Creation d'une nouvelle filiere</h3>
    </div>

    <div>

        <f:form method="POST" action="${pageContext.request.contextPath}/cadreadmin/import" enctype="multipart/form-data">
            <div class="row">
                <div class="col">
                    <label>modules</label>
                    <input type="file" name="modules" />
                </div>
                <div class="col">
                    <label>elements</label>
                    <input type="file" name="elements" />
                </div>
                <div class="col">
                    <label>niveau</label>
                    <input type="file" name="niveaux" />
                </div>
                <div class="col">
                    <label>filiere</label>
                    <input type="file" name="filieres" />
                </div>
            </div>
            <button type="submit" class="btn btn-primary">Importer</button>
        </f:form>

    </div>






    <jsp:include page="../fragments/userfooter.jsp" />

