<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: WRH
  Date: 2019/9/20
  Time: 9:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<s:iterator value="#list">
    <s:property></s:property>
</s:iterator><br>
<s:iterator value="#list" var="l">
    <s:property value="#l"></s:property>
</s:iterator><br>
<s:iterator begin="1" end="5" step="1">
    <s:property></s:property>
</s:iterator><br>
<s:if test="#list.size()==4">4</s:if>
<s:elseif test="#list.size()==3">3</s:elseif>
<s:else>no3no4</s:else>
<s:form action="要提交的action" namespace="action的命名空间" method="GET" theme="simple">
    <s:textfield name="name属性" label="输入框前显示的信息，例如用户名"></s:textfield>
    <s:submit value="提交"></s:submit>
    <s:password name="password" label="密码"></s:password>
    <s:radio list="{'男','女'}" name="gender" label="性别"></s:radio>
    <s:radio list="#{1:'男',2:'女'}" name="gender" label="性别"></s:radio>
    <s:checkboxlist list="#{1:'学习',2:'上课'}" name="habit" label="爱好"></s:checkboxlist>
    <s:select list="#{1:'小学生',2:'初中生'}" headerKey="" headerValue="--请选择--" name="edu" label="学历"></s:select>
    <s:file label="" name=""></s:file>
    <s:textarea label="" name=""></s:textarea>
    <s:actionerror></s:actionerror>
</s:form>
</body>
</html>
