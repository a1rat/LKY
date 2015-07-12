<#-- @ftlvariable name="user" type="java.util.List<ru.dz.labs.api.domain.Users>" -->
<#include "../template/template.ftl">
<@mainTemplate title="LKY"/>
<#macro m_body>
<div class="container">


<h2>Профиль</h2>
<table class="table">
    <thead>
    <tr>
        <th>Аватар:</th>
        <th></th>
    </tr>
    <tr>
        <th>Имя: ${user.name?cap_first}</th>
        <th></th>
    </tr>
    <tr>
        <th>Email:</th>
        <th></th>
    </tr>
    <tr>
        <th>Рабочие часы:</th>
        <th></th>
    </tr>
    </thead>
</table>
<table data-url="/task/list/user" data-toggle="table" data-height="250" data-sort-name="name" data-sort-order="desc">
    <thead>
    <tr>
        <th data-field="name" data-sortable="true" data-formatter = "taskFormatter">Активные задачи</th>
        <th data-field="status" data-sortable="true">Статус</th>
        <th data-field="priority" data-sortable="true">Приоритет</th>
        <th data-field="estimated_time" data-sortable="true">Дедлайн!!!</th>
    </tr>
    </thead>
</table>
    <script>
        function taskFormatter(value, row){
            var ref = row.id;
            return '<a href = "/task?id=' + ref +'">' + value;
//            return '<a href = "/user-task">' + value    //test
        }
    </script>
</div>
</#macro>