<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/css/main.css">
    <title></title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap-theme.min.css" integrity="sha384-6pzBo3FDv/PJ8r2KRkGHifhEocL+1X2rVCTTkUfGk7/0pbek5mMa1upzvWbrUbOZ" crossorigin="anonymous">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>

</head>
<body>
<div class="container">
<form method="post" action="/login/process">

    <#if error?? >
        <div class="bg-danger"> Ошибка в вводе логина или пароля</div>
    </#if>
    <div class="form-group">
        <label for="login">Логин:</label>
        <input type="text" class="form-control" id="login" placeholder="Логин" name="login">
    </div>
    <div class="form-group">
        <label for="password">Логин:</label>
        <input type="text" class="form-control" id="password" placeholder="Пароль" name="password">
    </div>
    <button type="submit" class="btn btn-default">Submit</button>
</form>
<p> Если ты у тебя нету логин, сделай  <a href="/registration">регистер</a></p>
    </div>
</body>

</html>