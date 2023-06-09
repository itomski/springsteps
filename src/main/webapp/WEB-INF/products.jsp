<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
            <li class="nav-item"><!-- http://localhost:8080/team -->
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
            <div class="col">
                <h1>${headline}</h1>

                <div class="my-3">
                    <a href="/products/new" class="btn btn-warning">Neues Produkt</a>
                </div>

                <ul class="nav nav-pills my-3">
                    <c:forEach items="${categories}" var="category">
                    <li class="nav-item">
                        <a class="nav-link" href="/products/category/${category.id}">${category.name}</a>
                    </li>
                    </c:forEach>
                </ul>

                <!-- table.table>thead>tr>th*4 -->
                <table class="table">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Beschreibung</th>
                            <th>Verfügbar ab</th>
                            <th>Kategorie</th>
                            <th>Preis</th>
                            <th>&nbsp;</th><!-- Geschütztes Leerzeichen -->
                        </tr>
                    </thead>

                    <!-- tbody>tr>td*4 -->
                    <tbody>
                        <c:forEach items="${productList}" var="product">
                            <tr>
                                <td>${product.id}</td>
                                <td>${product.name}</td>
                                <td>${product.description}</td>
                                <td>${product.availableAt}</td>
                                <td>${product.category.name}</td>
                                <td><fmt:formatNumber value="${product.price}" type="currency" currencySymbol="€" /></td>
                                <%--
                                <td><a href="/products/edit/${product.id}" class="btn btn-success">Edit</a></td> <!-- a = Link. Ruft die URL(href) IMMER über GET auf -->
                                --%>
                                <td>
                                    <form action="/products/edit" method="post"><!-- Form kann GET oder POST benutzen -->
                                        <input type="hidden" name="id" value="${product.id}"><!-- beim POST werden diese Informationen NICHT an die URL gehängt -->
                                        <button type="submit" class="btn btn-success">Edit</button>
                                    </form>
                                </td> <!-- button hat ohne Form-Tag keine Funktionalität -->
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </main>

    <script src="/webjars/bootstrap/5.2.3/js/bootstrap.bundle.min.js"></script>
</body>
</html>