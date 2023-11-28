<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>人事情報編集</title>
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
                <a class="nav-link" href="list">社員リスト</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="new">新規作成</a>
            </li>
            <li class="nav-item">
                <form method="POST" action="logout">
                    <input type="submit" value="ログアウト" class="btn btn-link nav-link">
                </form>
            </li>
        </ul>
    </div>
</nav>

    <div class="container">
    <h4 class="text-center mt-3 mb-3"><strong>編集画面</strong></h4>
    <div class="row justify-content-center">
        <div class="col-md-6">
            <% 
            ArrayList<HashMap<String, String>> employees = (ArrayList<HashMap<String, String>>) request.getAttribute("employees"); 
            for (HashMap<String, String> columns : employees) {
            %>
            <form class="mt-4" action="update" method="post">
                <input type="hidden" name="id" value='<%= columns.get("id") %>'>
                <div class="mb-3">
                    <label for="department_id" class="form-label"><strong>所属課：</strong></label>
                    <select class="form-select" id="department_id" name="department_id">
                        <option value="1">人事部</option>
                        <option value="2">経理部</option>
                        <option value="3">総務部</option>
                    </select>
                </div>
                <div class="mb-3">
                    <label for="employee" class="form-label"><strong>名前</strong></label>
                    <input type="text" class="form-control" id="employee" name="employee" value='<%= columns.get("employee") %>'>
                </div>
                <div class="mb-3">
                    <label for="position_id" class="form-label"><strong>役職：</strong></label>
                    <select class="form-select" id="position_id" name="position_id">
                        <option value="1">課長</option>
                        <option value="2">係長</option>
                        <option value="3">主任</option>
                        <option value="4">役職なし</option>
                    </select>
                </div>
                <div class="mb-3">
                    <label for="username" class="form-label"><strong>Username</strong></label>
                    <input type="text" class="form-control" id="username" name="username" value='<%= columns.get("username") %>'>
                </div>
                <div class="mb-3">
                    <label for="userpassword" class="form-label"><strong>Password</strong></label>
                    <input type="text" class="form-control" id="userpassword" name="userpassword">
                </div>
                <button type="submit" class="btn btn-primary">保存する</button>
                <a href='show?id=<%= columns.get("id") %>' class="btn btn-secondary">キャンセル</a>
            </form>
            <% } %>
        </div>
    </div>
</div>


</body>
</html>
