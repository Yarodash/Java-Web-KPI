<%
    String error_message = request.getParameter("error_message");
    if (error_message != null) {
%>
<div class="error">
    <div class="center">
        <h1 class="error"><%=error_message%></h1>
    </div>
</div>
<% } %>