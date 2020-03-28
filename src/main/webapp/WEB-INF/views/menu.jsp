<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div style="border: 1px solid #ccc; padding: 5px; margin-bottom: 20px;">
    <a href="/welcome">Home</a> |

    <a href="/addNewUser">Add
        User</a> |   <a
        href="/getUsers">Show
        Users</a> |   <u><h2 style="color: red;">
            <a onclick="document.forms['logoutForm'].submit()">Logout</a>
            </h3></u>

    <form id="logoutForm" method="POST" action="/logout">
    </form>
</div>
