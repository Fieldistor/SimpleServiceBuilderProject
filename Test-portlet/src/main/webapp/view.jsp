<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>

<%@ page import="com.liferay.portal.service.permission.PortalPermissionUtil" %>
<%@ page import="com.liferay.portal.service.permission.PortletPermissionUtil" %>
<%@ page import="com.liferay.portal.security.permission.ActionKeys" %>
<%
String resource_name="Test.model.Foo";
%>
<portlet:defineObjects />
<liferay-theme:defineObjects />

<portlet:actionURL var="addURL" name="addFoo">
   <portlet:param name="mvcPath" value="/view.jsp"/>
</portlet:actionURL>

<portlet:actionURL var="deleteURL" name="deleteFoo">
   <portlet:param name="mvcPath" value="/view.jsp"/>
</portlet:actionURL>

<c:if test="<%= permissionChecker.hasPermission(themeDisplay.getScopeGroupId(), resource_name, themeDisplay.getScopeGroupId(), ActionKeys.ADD_ENTRY)%>">
    <form action="<%= addURL.toString() %>" name="fooForm"  method="POST">
       Input Foo Data:<br/>
       <input  type="text" name="<portlet:namespace/>name"/>
       <input type="submit" value="Add Foo" />
    </form>
 </c:if>

<form action="<%= deleteURL.toString() %>" name="fooForm"  method="POST">
   Input Foo Id:<br/>
   <input  type="text" name="<portlet:namespace/>id"/>
   <input type="submit" value="Delete Foo" />
</form>

<portlet:renderURL var="showList">
<portlet:param name="mvcPath" value="/list.jsp"/>
</portlet:renderURL>

<a href="<%= showList %>">List</a>
