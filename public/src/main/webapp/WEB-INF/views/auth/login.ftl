<!DOCTYPE html>
<html>
<head>
    <meta content="text/html" charset="utf-8">
    <title>Registation</title>
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="resources/css/bootstrap-table.css" rel="stylesheet">
</head>
<body>
<header class="header" style="background: #02e800; height: 34px">

</header>
<div class="col-lg-12 text-center" style="background: #02da00"><h2>Welcome to LKY</h2></div>
<div class="container">
    <div class="row">
        <div class="col-lg-6">
            <div class="col-lg-3">

            </div>
            <div class="col-lg-6">
                <form role="form" action="/j_spring_security_check" method="post">
                    <h2 class="form-group modal-header">Вход</h2>
                    <fieldset>
                        <div class="form-group">
                            <label for="login">Логин:</label>
                            <input class="form-control" name="j_username" placeholder="Login" type="text" autofocus >
                        </div>
                        <div class="form-group">
                            <label for="pwd">Пароль:</label>
                            <input class="form-control" name="j_password" placeholder="Password"  type="password" value="">
                        </div>
                        <div class="checkbox">
                            <label>
                                <input name="_spring_security_remember_me" type="checkbox" value="Remember Me" >Remember Me
                            </label>
                        </div>
                        <input type="submit" class="btn btn-lg btn-success btn-block" value="Login"/>
                    </fieldset>
                </form>
</br>

                        <a href="/reg" class="btn btn-lg btn-success btn-block"> Registration</a>

            </div>
            <div class="col-lg-3">

            </div>
        </div>

    </div>
</div>
</body>
</html>