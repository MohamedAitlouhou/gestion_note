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
        <h3>Gestion des filieres</h3>
    </div>

    <div>



    </div><p style="text-align:right">

    <table class="table">
        <thead>
        <tr>
            <th scope="col">idFiliere</th>
            <th scope="col">codeFiliere</th>
            <th scope="col">titreFiliere</th>
            <th scope="col">anneeaccreditation</th>
            <th scope="col">anneefinaccreditation</th>
            <th>Actions</th>
        </tr>
        </thead>

        <c:forEach items="${filiereList}" var="p">
            <tr>
                <td><c:out value="${p.idFiliere}" /></td>
                <td><c:out value="${p.codeFiliere}" /></td>
                <td><c:out value="${p.titreFiliere}" /></td>
                <td><c:out value="${p.anneeaccreditation}" /></td>
                <td><c:out value="${p.anneeFinaccreditation}" /></td>

                <td>
                    <ul>
                        <li><a
                                href="${pageContext.request.contextPath}/cadreadmin/deleteFiliere/${p.idFiliere}">Delete</a></li>

                        <li><a
                                href="${pageContext.request.contextPath}/cadreadmin/updateFiliereForm/${p.idFiliere}">Update</a></li>


                    </ul>
                </td>

            </tr>

        </c:forEach>

    </table>

    <a href="${pageContext.request.contextPath}/cadreadmin/createFiliereForm">Creer une nouvelle filiere</a>




    <jsp:include page="../fragments/userfooter.jsp" />

