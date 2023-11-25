<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>人事情報リスト</title>
     <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css"
    integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <h2 class="navbar-brand ml-ligth">人事情報の管理</h2>
        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <form method="POST" action="logout">
                    <input type="submit" value="ログアウト" class="btn btn-link nav-link">
                </form>
            </li>
        </ul>
    </div>
</nav>

    <div class="container">
    <h4 class="text-center mt-3 mb-3"><strong>マイページ</strong></h4>
    <div class="row justify-content-center">
        <div class="col-md-8">
            <div class="employee-list text-center">
                <% 
                ArrayList<HashMap<String, String>> employees = (ArrayList<HashMap<String, String>>) request.getAttribute("employees"); 
                for (HashMap<String, String> columns : employees) {
                %>
                <div class="employee card mb-3">
                    <div class="card-body">
                        <p class="card-text"><strong>ID:</strong> <%= columns.get("id") %></p>
                        <p class="card-text"><strong>所属課:</strong> <%= columns.get("department_name") %></p>
                        <p class="card-text"><strong>名前:</strong> <%= columns.get("employee") %></p>
                        <p class="card-text"><strong>役職:</strong> <%= columns.get("position_name") %></p>
                    </div>
                </div>
                <% } %>
            </div>
        </div>
    </div>
    </div>
   
</body>
</html>
