<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>

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
        <#-- @TODO ВЫДЕЛИТЬ ПОЛЯ ДЛЯ ОБЯЗАТЕЛЬНО ЗАПОЛНЕНИЯ КАКИМ ТО СТИЛЕМ! обязательные поля отмечу комментами -->
        <#-- @TODO добавиь стили для ошибок (попробуй отправить пустую форму) -->
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">

                    <div class="panel-body">
                        <@form.form action="/reg" method="post" modelAttribute="reg-form">
                            <h2 class="form-group modal-header">Регистрация</h2>
                            <fieldset>
                                <div class="form-group">
                                    <label for="login">E-mail:</label>
                                    <@form.input path="email" cssClass="form-control" placeholder="E-mail" type="email" /> <#-- Обязательное поле -->
                                    <@form.errors path="email"/>
                                </div>

								<div class="form-group">
                                    <label for="username">Имя:</label>
                                    <@form.input path="name" class="form-control" placeholder="Name" type="text" /> <#-- Обязательное поле -->
                                    <@form.errors path="name" />
                                </div>

                                <div class="form-group">
                                    <label for="pwd">Выберите роль:</label>
                                    <@form.select path="role" class="form-control" size="3" multiple="true">
                                        <#list roleList as role>
                                        <@form.option value="${role.id}">${role.name}</@form.option>
                                    </#list>
                                    </@form.select>
                                </div>

                                <div class="form-group">
                                    <label for="pwd">Пароль:</label>
                                    <@form.input path="password" class="form-control" placeholder="Password" type="password" value="" /> <#-- Обязательное поле -->
                                    <@form.errors path="password" />
                                </div>

								<div class="form-group">
                                    <label for="pwd">Повторите пароль:</label>
                                    <@form.input path="confirmPassword" class="form-control" placeholder="Repeat Password" type="password" /> <#-- Обязательное поле -->
                                    <@form.errors path="confirmPassword" />
                                </div>

								<input type="submit" class="btn btn-lg btn-success btn-block" value="Registration"/>
							</fieldset>
                        </@form.form>

                    </div>
                </div>
            </div>
        </div>

