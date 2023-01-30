<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="de">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>

    <link rel="stylesheet" href="/webjars/bootstrap/5.2.3/css/bootstrap.min.css">
</head>
<body>

    <nav class="container my-3">
        <!-- ul.nav>li.nav-item*5>a.nav-link -->
        <ul class="nav nav-tabs">
            <li class="nav-item">
                <a href="/" class="nav-link ${(ac eq 'home') ? 'active' : ''}">Home</a>
            </li>
            <li class="nav-item">
                <a href="/team" class="nav-link ${(ac eq 'team') ? 'active' : ''}">Team</a>
            </li>
            <li class="nav-item">
                <a href="/service" class="nav-link ${(ac eq 'service') ? 'active' : ''}">Service</a>
            </li>
            <li class="nav-item">
                <a href="/products" class="nav-link ${(ac eq 'products') ? 'active' : ''}">Produkte</a>
            </li>
            <li class="nav-item">
                <a href="/kontakt" class="nav-link ${(ac eq 'contact') ? 'active' : ''}">Kontakt</a>
            </li>
        </ul>
    </nav>

    <main class="container">
        <div class="row">
            <div class="col-sm-8 col-md-6 mb-5">
                <h1>${headline}</h1>

                <div class="my-3">
                    <a href="/products" class="btn btn-warning">Zurück</a>
                </div>

                <c:if test="${saved}">
                    <div class="alert alert-success" role="alert">
                        Produkt wurde gespeichert! Danke.
                    </div>
                </c:if>
                <c:if test="${failed}">
                    <div class="alert alert-danger" role="alert">
                        <h3>Produkt konnte nicht gespeichert werden! Sorry.</h3>
                        <hr>
                        <%--
                        <ul>
                            <c:forEach items="${errors}" var="e">
                                <li>${e}</li>
                            </c:forEach>
                        </ul>
                        --%>
                    </div>
                </c:if>
                <%--
                <form action="/products" method="post">
                    <!-- div.mb-3*3>label.form-label+input.form-control -->
                    <input type="hidden" name="id" value="${product.id}">

                    <div class="mb-3">
                        <label for="name" class="form-label">Name</label>
                        <input type="text" class="form-control ${errors.containsKey('name') ? 'is-invalid': ''}" name="name" id="name" value="${product.name}">
                        <div class="invalid-feedback">${errors.get('name')}</div>
                    </div>
                    <div class="mb-3">
                        <label for="description" class="form-label"></label>
                        <textarea name="description" id="description" rows="10" class="form-control ${errors.containsKey('description') ? 'is-invalid': ''}">${product.description}</textarea>
                        <div class="invalid-feedback">${errors.get('description')}</div>
                    </div>
                    <div class="mb-3">
                        <label for="price" class="form-label">Preis</label>
                        <input type="text" class="form-control ${errors.containsKey('price') ? 'is-invalid': ''}" name="price" id="price" value="${(product.price) ? product.price : 0.0}">
                        <div class="invalid-feedback">${errors.get('price')}</div>
                    </div>
                    <!-- btn.btn.btn-success -->
                    <button class="btn btn-success">Speichern</button>
                </form>
                --%>

                <form:form action="/products" modelAttribute="product">
                    <div class="mb-3">
                        <label for="name" class="form-label">Name</label>
                        <form:input class="form-control" path="name" />
                    </div>
                    <div class="mb-3">
                        <label for="description" class="form-label"></label>
                        <form:textarea rows="10" class="form-control" path="description"></form:textarea>
                    </div>
                    <div class="mb-3">
                        <label for="price" class="form-label">Preis</label>
                        <form:input class="form-control" path="price" />
                    </div>
                    <button class="btn btn-success">Speichern</button>
                </form:form>

            </div>
        </div>
    </main>

    <script src="/webjars/bootstrap/5.2.3/js/bootstrap.bundle.min.js"></script>
</body>
</html>