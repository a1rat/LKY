<#-- @ftlvariable name="task" type="ru.dz.labs.api.domain.Task" -->

<#if task?has_content>
    ${task.id}<br>
    ${task.description?string}<br>
${task.status.name?string}
</#if>