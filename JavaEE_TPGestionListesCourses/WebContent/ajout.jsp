<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gestion Listes - Home</title>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<!-- Font Awesome -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
<!-- Bootstrap core CSS -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
<!-- Material Design Bootstrap -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.7.7/css/mdb.min.css" rel="stylesheet">
    <script
            src="https://code.jquery.com/jquery-3.4.0.js"
            integrity="sha256-DYZMCC8HTC+QDr5QNaIcfR7VSPtcISykd+6eSmBW5qo="
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <!-- JQuery -->
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <!-- Bootstrap tooltips -->
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.4/umd/popper.min.js"></script>
    <!-- Bootstrap core JavaScript -->
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <!-- MDB core JavaScript -->
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.7.7/js/mdb.min.js"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/buttons/1.5.6/js/dataTables.buttons.min.js"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/select/1.3.0/js/dataTables.select.min.js"></script>
    <script type="text/javascript" src="https://editor.datatables.net/extensions/Editor/js/dataTables.editor.min.js"></script>
    <script type="text/javascript" src="main.js"></script>
    <link rel="stylesheet" type="text/css" href="main.css">
</head>
<body>
<%@ include file="/WEB-INF/header.html" %>
<br>
<h1 align="center">Ajout Liste</h1>
<form action="" method="post">
    <div class="form-row">
        <!-- Grid column -->
        <div class="col">
            <!-- Material input -->
            <div class="md-form mt-0">
                <input type="text" class="form-control" placeholder="Nom">
            </div>
        </div>
        <!-- Grid column -->

        <!-- Grid column -->
        <div class="col">
            <!-- Material input -->
            <div class="form-group">
            <label for="formGroupExampleInput">Prix</label>
            <input type="text" class="form-control" id="formGroupExampleInput" placeholder="1.5">
        </div>
        </div>
        <div class="col">
        <div class="def-number-input number-input">
            <button onclick="this.parentNode.querySelector('input[type=number]').stepDown()" class="minus"></button>
            <input class="quantity" min="0" name="quantity" value="1" type="number">
            <button onclick="this.parentNode.querySelector('input[type=number]').stepUp()" class="plus"></button>
            <label class="center-pill">Quantité</label>
        </div>
        </div>
        <!-- Grid column -->
    </div>
    <table id="dt-basic-checkbox" class="table table-bordered">
        <!-- Table head -->
        <thead>
        <tr>
            <th>
            </th>
            <th>Nom</th>
            <th>Quantité</th>
            <th>Prix</th>
        </tr>
        </thead>
        <!-- Table head -->

        <!-- Table body -->
        <tbody>
        <tr>
            <th scope="row">
                <!-- Material unchecked -->
                <div class="form-check">
                    <input type="checkbox" class="form-check-input" id="tableMaterialCheck2">
                    <label class="form-check-label" for="tableMaterialCheck2"></label>
                </div>
            </th>
            <td>Coca</td>
            <td>1</td>
            <td>1,50</td>
        </tr>
        <tr>
            <th scope="row">
                <!-- Material unchecked -->
                <div class="form-check">
                    <input type="checkbox" class="form-check-input" id="tableMaterialCheck3">
                    <label class="form-check-label" for="tableMaterialCheck3"></label>
                </div>
            </th>
            <td>Ice Tea</td>
            <td>4</td>
            <td>1,60</td>
        </tr>
        <tr>
            <th scope="row">
                <!-- Material unchecked -->
                <div class="form-check">
                    <input type="checkbox" class="form-check-input" id="tableMaterialCheck4">
                    <label class="form-check-label" for="tableMaterialCheck4"></label>
                </div>
            </th>
            <td>Fanta</td>
            <td>2</td>
            <td>1,70</td>
        </tr>
        </tbody>
        <!-- Table body -->
    </table>
</form>

<%@ include file="/WEB-INF/footer.html" %>
</body>

</html>