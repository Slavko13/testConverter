<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/css/main.css">
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap-theme.min.css" integrity="sha384-6pzBo3FDv/PJ8r2KRkGHifhEocL+1X2rVCTTkUfGk7/0pbek5mMa1upzvWbrUbOZ" crossorigin="anonymous">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>
    <title></title>
    <script src="https://www.google.com/recaptcha/api.js" async defer></script>
</head>
<body>



<div class="container">

        <#if haveErrors?? >
            <div class="alert alert-danger" role="alert">
                ${error}
            </div>
        </#if>

<form method="post" action="/registration">
    <div class="form-group">
            <label for="login">Логин:</label>
            <input type="text" class="form-control" id="login" placeholder="Логин" name="login">
    </div>

    <div class="form-group">
        <label for="name">Ваше имя:</label>
        <input type="text" class="form-control" id="name" placeholder="Ваше имя" name="name">
    </div>
    <div class="form-group">
        <label for="password">Введите ваш пароль</label>
        <input type="text" class="form-control" id="password" placeholder="Пароль" name="password">
    </div>
    <div>
        <p><input type="radio" checked name="Roles" value="USER">Полный доступ к конвертатору</p>
        <p><input type="radio" name="Roles" value="VIEWER">Смотреть список валют</p>
    </div>


    <div>
    <div class="g-recaptcha" data-sitekey="6LfTAN4UAAAAAKEeHQEpvgLb-Q5j_6nt0W8BHeHx"></div>
    </div>
    <button type="submit" class="btn btn-default">Submit</button>

    <p>Если вы уже зарегестрированы: <a href="/login">войти</a></p>

</form>
</div>

<script src="https://www.google.com/recaptcha/api.js?onload=onloadCallback&render=explicit" async defer>
</script>
</body>
</html>