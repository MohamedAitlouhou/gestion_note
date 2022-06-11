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
        <h3>Gestion des modules</h3>
    </div>

    <div>



    </div><p style="text-align:right">

    <table class="table">
        <thead>
        <tr>
            <th scope="col">idModule</th>
            <th scope="col">code</th>
            <th scope="col">titre</th>
            <th scope="col">idNiveau</th>
            <th>Actions</th>
        </tr>
        </thead>

        <c:forEach items="${modulesList}" var="p">
            <tr>
                <td><c:out value="${p.idModule}" /></td>
                <td><c:out value="${p.code}" /></td>
                <td><c:out value="${p.titre}" /></td>
                <td><c:out value="${p.idNiveau}" /></td>

                <td>
                    <ul>
                        <li><a
                                href="${pageContext.request.contextPath}/cadreadmin/deleteModule/${p.idModule}">Delete</a></li>

                        <li><a
                                href="${pageContext.request.contextPath}/cadreadmin/updateModuleForm/${p.idModule}">Update</a></li>


                    </ul>
                </td>

            </tr>

        </c:forEach>

    </table>

    <a href="${pageContext.request.contextPath}/cadreadmin/createModuleForm">Creer un nouveau module</a>




    <jsp:include page="../fragments/userfooter.jsp" />

