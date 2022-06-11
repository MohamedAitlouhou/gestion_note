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
        <h3>Gestion des classes</h3>
    </div>

    <div>



    </div><p style="text-align:right">

    <table class="table">
        <thead>
        <tr>
            <th scope="col">idNiveau</th>
            <th scope="col">alias</th>
            <th scope="col">titre</th>
            <th scope="col">idFiliere</th>
            <th>Actions</th>
        </tr>
        </thead>

        <c:forEach items="${niveauxList}" var="p">
            <tr>
                <td><c:out value="${p.idNiveau}" /></td>
                <td><c:out value="${p.alias}" /></td>
                <td><c:out value="${p.titre}" /></td>
                <td><c:out value="${p.idFiliere}" /></td>

                <td>
                    <ul>
                        <li><a
                                href="${pageContext.request.contextPath}/cadreadmin/deleteNiveau/${p.idNiveau}">Delete</a></li>

                        <li><a
                                href="${pageContext.request.contextPath}/cadreadmin/updateNiveauForm/${p.idNiveau}">Update</a></li>


                    </ul>
                </td>

            </tr>

        </c:forEach>

    </table>

    <a href="${pageContext.request.contextPath}/cadreadmin/createNiveauForm">Creer un nouveau niveau</a>




    <jsp:include page="../fragments/userfooter.jsp" />

