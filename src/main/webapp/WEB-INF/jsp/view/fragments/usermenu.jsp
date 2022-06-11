<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>

<div class="collapse navbar-collapse" id="navbarNav">
	<ul class="navbar-nav">
		<li class="nav-item"><a class="nav-link active"
			aria-current="page"
			href="${pageContext.request.contextPath}/user/showUserHome">Home</a></li>

		<li class="nav-item">

		<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
										 href="${pageContext.request.contextPath}/admin/showAdminHome" id="navbarScrollingDropdown" role="button"
										 data-bs-toggle="dropdown" aria-expanded="false">Gestion de la structure pedagogique</a>
			<ul class="dropdown-menu" aria-labelledby="navbarScrollingDropdown">
				<li class="dropdown-item"><a class="nav-link"
											 href="${pageContext.request.contextPath}/cadreadmin/modules">
					Gestion des modules</a></li>
				<li class="dropdown-item"><a class="nav-link"
											 href="${pageContext.request.contextPath}/cadreadmin/elements">
					Gestion des elements</a></li>
				<li class="dropdown-item"><a class="nav-link"
											 href="${pageContext.request.contextPath}/cadreadmin/niveaux">
					Gestion des classes</a></li>

				<li class="dropdown-item"><a class="nav-link"
											 href="${pageContext.request.contextPath}/cadreadmin/filieres">
					Gestion des filieres</a></li>

				<li class="dropdown-item"><a class="nav-link"
											 href="${pageContext.request.contextPath}/cadreadmin/affecterCoordFiliereForm">
					Affecter coordonateur a la filiere</a></li>

				<li class="dropdown-item"><a class="nav-link"
											 href="${pageContext.request.contextPath}/cadreadmin/importSpForm">
					Importer la structure pedagogique</a></li>
			</ul></li>


		<f:form action="${pageContext.request.contextPath}/logout" method="POST">

			<button type="submit" class="btn btn-link">logout</button>

		</f:form>
	</ul>
</div>