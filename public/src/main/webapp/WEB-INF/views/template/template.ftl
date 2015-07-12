<#assign c=JspTaglibs["http://java.sun.com/jsp/jstl/core"]>
<#macro mainTemplate title="LKY" fullVersion=true>
<!DOCTYPE html>
<html lang="en">
<head>
    <#include "additionals/head.ftl" />
    <@head title=title />
    <style type="text/css">
           .container {
           width: 100%;
           float: left;
           overflow: hidden;
           }
           .middle {
               width: 100%;
               padding: 0 0 100px;
               position: relative;
           }
           .middle:after {
               display: table;
               clear: both;
               content: '';
           }
    </style>
</head>
<body>
<div id="wrapper">
    <#include "additionals/header.ftl" />
    <div <#if fullVersion>id="page-wrapper"</#if>>
        <div class="middle">
                <@m_body />
        </div>
    </div>
</div>
<!-- /#wrapper -->
    <#--<#include "additionals/footer.ftl" />-->
</body>
</html>
</#macro>