<#-- @ftlvariable name="task" type="java.util.List<ru.dz.labs.api.domain.Task>" -->
<#include "../template/template.ftl">
<@mainTemplate title="${task.name?string}"/>
<#macro m_body>
<div class="container">
<h2>Задача: ${task.name?string}</h2>
<table class="table">
    <thead>
    <tr>
        <th>Менеджер: <a href="//${task.manager.id}" class="text-success">${task.manager.name?html}</a></th>
        <th></th>
        <th>Статус задания: ${task.status.name?html}</th>
        <th></th>
        <th>Планируемая дата начала:
    <#if task.plan_date??>
        ${task.plan_date?string("dd.MM.yyyy")}
    </#if></th>
    </tr>
    <tr>
        <th>Разработчик: <a href="//${task.user_task.id}" class="text-success">${task.user_task.name?html}</th>
        <th></th>
        <th>Приоритет задания: ${task.priority.name}</th>
        <th></th>
        <th>Планируемое время на выполнение:
        <#if task.estimated_time??>
        ${task.estimated_time?string("dd.MM.yyyy")}
        </#if>
        </th>
    </tr>
    <tr>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
        <th>Реально затраченное время:
        <#local sum = 0>
        <#if task.expended_time?has_content>
            <#list task.expended_time as ex>
                <#local sum = sum + ex.time>
            </#list>
        </#if>
        ${sum}
        </th>
        <th></th>
    </tr>
    <tr>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
        <th>Планируемое разработчиком:</th>
        <th></th>
    </tr>
    </thead>
</table>

<p><h4>Описание задачи:<h4> ${task.description?string}</p>

<br>
<h4>Коментарии: </h4>
<#if task.comments?has_content>
    <#list task.comments as comment>
    <div class="container" style="padding-right: 30px">
        <div class="row">
            <div class=" col-lg-12" style="background-color: #ecf3f7; margin: 10px; border-radius: 15px 15px 15px 15px">
                <div style=" margin-bottom: 4px"><r style="font-weight:bold">Пользователь:</r>
                    <a href="//${task.user_task.id}" class="text-success">${comment.user.name}</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <small>Время:
                <#if comment.datetime??>
                ${comment.datetime?string("dd.MM.yyyy HH:mm")}
                </#if>
                </small>
                </div>
                <div style="border-bottom: 2px solid #97f7af;"></div>
                <br/>
                <div style="font-style:italic">${comment.text?string}</div>
                <br>
            </div>
        </div>
    </div>
    <br>
    </#list>
</#if>
    <div class="container">
        <div class=""
    </div>
<div class="container">
    <form class="form-horizontal">
        <fieldset>
            <div class="control-group">
                <label class="control-label" for="input01">Добавить коментарий:</label>
                <div class="controls">
                    <textarea rows="7" cols="80"></textarea>
                </div>
            </div>
        </fieldset>
        <div class="form-actions">
            <button type="submit" class="btn btn-success">Сохранить</button>
        </div>
    </form>
</div>
</div>
</#macro>