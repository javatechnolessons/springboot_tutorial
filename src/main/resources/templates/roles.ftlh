<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Page Title</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel='stylesheet' type='text/css' media='screen' href='css/javatechnolessons.css'>
    <script src='main.js'></script>
</head>
<body>
    <h1>Roles View</h1>
    <#if error??>
    <br>
    <div class="error">Error:${error}</div>
    <br>
    </#if>
    <fieldset>
        <legend>Create a role:</legend>
    <form action="/createRole" method="POST">
        
         <label for="name">Role name</label>
         <input type="text" id="name" name="name">&nbsp;<input class="button" type="submit" value="Submit">
      
       </form>
    </fieldset>
    <br>
    <table id="customers">
        <tr>
          <th>ID</th>
          <th>ROLE</th>
        </tr>
        <#list listRoles as role>
        <tr>
            <td>${role.id}</td>
            <td>${role.name}</td>
          </tr>
        </#list>
      </table>
</body>
</html>