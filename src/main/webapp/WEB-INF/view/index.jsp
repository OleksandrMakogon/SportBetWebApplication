<!doctype html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html lang="en">
<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

  <style>
    .jumbotron{
      background-color:#2E2D88;
      color:white;
    }
    .tab-content{
      border-left: 1px solid #ddd;
      border-right: 1px #ddd;
      border-bottom: 1px #ddd;
      padding: 10px;
    }
    .nav-tabs{
      margin-bottom: 0;
    }
  </style>

  <title>SportBetting</title>

</head>

<body>

<div class="container">

  <c:if test="${not empty msg}">
    <div class="alert alert-${css} alert-dismissible" role="alert">
      <button type="button" class="close" data-dismiss="alert"
              aria-label="Close">
        <span aria-hidden="true">×</span>
      </button>
      <strong>${msg}</strong>
    </div>
  </c:if>

  <div class="jumbotron">
    <h1 class="display-4">Welcome to SportsBet!</h1>
    <p class="lead">Sport Betting is activity to predict sport events</p>
    <hr class="my-4">
    <p>Please, Login or Register to start!</p>
    <a class="btn btn-primary btn-lg" href="/login" role="button">Login</a>
    <a class="btn btn-primary btn-lg" href="/register" role="button">Register</a>
    <a class="btn btn-primary btn-lg" href="/createData" role="button">Create Data</a>
  </div>

</div>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>
</html>