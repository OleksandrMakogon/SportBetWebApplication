<!doctype html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

    <style>
        .badge{
            background-color:#007bff;;
        }
    </style>

    <title>SportBetting Register new player</title>

</head>

<body>

<div class="container">
    <h2> <span class="badge badge-secondary">Register new player</span></h2>
    <form method="post" action="register">
        <div class="form-group">
            <label for="player_login">Login</label>
            <input name = "player_login" type="text" class="form-control" id="player_login" placeholder="Enter player_login">
        </div>

        <div class="form-group">
            <label for="player_name">Name</label>
            <input name = "player_name" type="text" class="form-control" id="player_name" placeholder="Enter Name">
        </div>

        <div class="form-group">
            <label for="account">Account</label>
            <input name = "account" type="text" class="form-control" id="account" placeholder="Enter Account">
        </div>

        <div class="form-group">
            <label for="balance">Balance</label>
            <input name = "balance" type="text" class="form-control" id="balance" placeholder="Enter Balance">
        </div>

        <div class="form-group">
            <label>Currency</label>
            <select name = "currency" path="currency" class="form-control">
			 	<option value="NONE" label="---Select---"/>
                <option value="EUR" label="EUR"/>
                <option value="GBP" label="GBP"/>
                <option value="USD" label="USD"/>
			</select>
        </div>

        <div class="form-group">
            <label for="password">Password</label>
            <input name = "password" type="password" class="form-control" id="password" placeholder="Password">
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>
</html>
