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

    <div class="container">
    <div class="row justify-content-center">
        <div class="col-md-8">
            <div class="employee-list text-center">
                <h2>係長未満個人ページ</h2>
                <% 
                ArrayList<HashMap<String, String>> employees = (ArrayList<HashMap<String, String>>) request.getAttribute("employees"); 
                for (HashMap<String, String> columns : employees) {
                %>
                <div class="employee card mb-3">
                    <div class="card-body">
                        <p class="card-text"><strong>ID:</strong> <%= columns.get("id") %></p>
                        <p class="card-text"><strong>Department:</strong> <%= columns.get("department_name") %></p>
                        <p class="card-text"><strong>Employee:</strong> <%= columns.get("employee") %></p>
                        <p class="card-text"><strong>Position:</strong> <%= columns.get("position_name") %></p>
                    </div>
                </div>
                <% } %>
            </div>
        </div>
    </div>
    </div>
   
</body>
</html>
