<html>
<head>
    <meta charset="utf-8">
    <title>Freemarker入门</title>
</head>
<body>
<h1>可以加入html代码</h1>

<#--我只是一个注释，我不会有任何输出  -->
${name}你好，${message}

<h1> assign指令</h1>
<p/>
<#--定义简单参数-->
<#--定义显示的值-->
<#assign linkman="周先生">
<#--要显示的点-->
联系人：${linkman}

<p/>
<#--定义对象:可以用""  可以用''-->
<#assign info={"mobile":"18876891992",'address':'深圳'}>
<#--要显示的点-->
电话:${info.mobile} 地址:${info.address}

<h1>include指令</h1>
<p/>
<#--嵌套另一个ftl文件代码-->
<#include "head.ftl"/>

<h1> if指令</h1>
<p/>
<#if success=true>
    你已通过实名认证
<#else>
    你未通过实名认证
</#if>

<h1> list指令</h1>
<#--和v-for循环很很像 被循环体goodsList  一条内容goods  -->
<#list goodsList as goods>
    商品名称： ${goods.name} 价格：${goods.price}<br>
</#list>

</body>
</html>