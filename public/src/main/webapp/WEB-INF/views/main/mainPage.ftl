<#include "../template/template.ftl">
<@mainTemplate title="LKY"/>
<#macro m_body>

<br>
<br>
<table data-url="/task/list" data-toggle="table" data-height="299" data-sort-name="name" data-sort-order="desc">
    <thead>
    <tr>
        <th data-field="id" data-align="right" data-sortable="true" data-formatter = "taskFormatter">id</th>
        <th data-field="task_name" data-align="right" data-sortable="true" data-formatter = "taskFormatter">Задачи</th>
        <th data-field="monday" data-align="center" data-sortable="false">Понедельник</th>
        <th data-field="tuesday" data-align="center" data-sortable="false">Вторник</th>
        <th data-field="wednesday" data-align="center" data-sortable="false">Среда</th>
        <th data-field="thursday" data-align="center" data-sortable="false">Четверг</th>
        <th data-field="friday" data-align="center" data-sortable="false">Пятница</th>
        <th data-field="saturday" data-align="center" data-sortable="false">Суббота</th>
        <th data-field="sunday" data-align="center" data-sortable="false">Воскресение</th>
        <th data-field="sum" data-align="center" data-sortable="true">Итог</th>
        <#--<th data-field="price" data-sortable="true">Дата начала</th>-->
    </tr>
    </thead>
</table>
<script>
    function taskFormatter(value, row){
        var ref = row.id
        return '<a href = "/task?id=' + ref +'">' + value
//        return '<a href = "/user-task">' + value    //test
    }
</script>

</#macro>