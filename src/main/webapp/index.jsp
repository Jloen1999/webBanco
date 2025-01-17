<%@ page import="es.unex.cum.tw.models.Usuario" %>
<%@ page import="java.util.Optional" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Repaso</title>

    <!-- Metadatos -->
    <meta name="author" content="Jose Luis Obiang Ela Nanguang">
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="UTF-8">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

    <!-- Bootstrap Icons -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

</head>
<body class="bg-dark">
<header class="bg-secondary"><h1 class="text-center">Servicios Web</h1></header>

<nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Banco</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="#">Inicio</a>
                </li>
                <li class="nav-item">
                    <%
                    Usuario usuario = (Usuario) session.getAttribute("user");
                        if(usuario != null) {%>
                            <i class="bi bi-person"><%=usuario.getNombre_usuario()%></i>
                        <%}else{%>
                    <a class="text-decoration-none" data-bs-toggle="offcanvas" href="#offcanvasRight" role="button"
                       aria-controls="offcanvasExample">
                            Iniciar Sesión
                    </a>
                    <%}%>

                    <div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasRight"
                         aria-labelledby="offcanvasRightLabel">

                        <div class="offcanvas-header">
                            <h5 class="offcanvas-title" id="offcanvasRightLabel">Inicio de sesión</h5>
                            <!-- Mostrar el título de inicio de sesión -->
                            <button type="button" class="btn-close d-lg-none" data-bs-dismiss="offcanvas"
                                    aria-label="Close"></button>
                        </div>

                        <div class="offcanvas-body small
                            <% if(request.getAttribute("visibleLogin") != null)
                                response.getWriter().print("show");
                            %>">
                            <form class="row g-3"

                                  id="formulario" action="${pageContext.request.contextPath}/login"
                                  method="post">

                                <!-- Mostrar el campo de nombre de usuario y contraseña tanto en inicio de sesión como en registro -->
                                <div class="col-md-12" id="campo-username">
                                    <label for="username" class="form-label">Usuario</label>
                                    <input type="text" class="form-control" id="username" name="username" required
                                           aria-describedby="usernameHelp">
                                    <div class="valid-feedback">
                                        Genial!
                                    </div>
                                    <div id="usernameHelp" class="form-text">Debe tener al menos 3 caracteres</div>
                                </div>

                                <div class="col-md-12">
                                    <label for="password" class="form-label">Contraseña</label>
                                    <input type="password" class="form-control" id="password" name="password" required
                                           aria-describedby="passwordHelp">
                                    <div class="valid-feedback">
                                        Genial!
                                    </div>
                                    <div id="passwordHelp" class="form-text">Debe tener al menos 6 caracteres</div>
                                </div>

                                <div class="col-12">
                                    <div class="form-check">
                                        <input class="form-check-input" type="checkbox" value="" id="invalidCheck">
                                        <label class="form-check-label" for="invalidCheck">
                                            Acepta los términos y condiciones
                                        </label>
                                        <div class="invalid-feedback">
                                            Debes aceptar antes de enviar.
                                        </div>
                                    </div>
                                </div>

                                <div class="col-6">
                                    <button class="btn btn-primary" type="submit" value="login" name="accion"
                                            id="login">Iniciar
                                        sesión
                                    </button>
                                </div>

                            </form>
                        </div>
                    </div>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Cerrar sesión</a>
                </li>
            </ul>

            <form class="d-flex" role="search">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Buscar</button>
            </form>
        </div>
    </div>
</nav>
<% if (request.getAttribute("mensaje") != null) { %>
<% if (((String) request.getAttribute("mensaje")).toLowerCase().contains("no") || ((String) request.getAttribute("mensaje")).toLowerCase().contains("error")) { %>
<div class="alert alert-danger alert-dismissible fade show" role="alert">
    <strong>Error:</strong> <%= request.getAttribute("mensaje") %>
    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
</div>
<% } else {%>
<div class="alert alert-success alert-dismissible fade show" role="alert">
    <strong>Éxito:</strong> <%= request.getAttribute("mensaje") %>
    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
</div>
<% } %>
<% } %>
<main>

</main>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</body>
</html>
