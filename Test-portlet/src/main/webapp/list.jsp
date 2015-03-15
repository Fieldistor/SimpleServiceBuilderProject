<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="com.liferay.portal.kernel.util.ListUtil" %>
<%@ page import="Test.model.Foo"%>
<%@ page import="Test.user.MainAction"%>

<%@ page import="com.liferay.portal.model.User" %>
<%@ page import="com.liferay.portal.service.UserLocalServiceUtil" %>

<portlet:defineObjects />

<liferay-ui:search-container
      emptyResultsMessage="there-is-no-foo"
      delta="5">

    <liferay-ui:search-container-results>
    <%
    List<Foo> tempResults = MainAction.getFoo(renderRequest);

    results = ListUtil.subList(tempResults, searchContainer.getStart(), searchContainer.getEnd());
    total = tempResults.size();

    pageContext.setAttribute("results", results);
    pageContext.setAttribute("total", total);
    %>
    </liferay-ui:search-container-results>

    <liferay-ui:search-container-row
        className="Test.model.Foo"
        keyProperty="fooId"
        modelVar="Foo">

          <liferay-ui:search-container-column-text
          name="Foo ID" property="fooId">
          >

          </liferay-ui:search-container-column-text>

          <liferay-ui:search-container-column-text
          name="Data"
          property="userName"
          >
           </liferay-ui:search-container-column-text>

         <liferay-ui:search-container-column-text
         name="User Name"
         >
         <%
             User user = UserLocalServiceUtil.getUser(Foo.getUserId());
         %>
        <%=user.getFullName()%>

          </liferay-ui:search-container-column-text>

    </liferay-ui:search-container-row>
    <liferay-ui:search-iterator />

  </liferay-ui:search-container>