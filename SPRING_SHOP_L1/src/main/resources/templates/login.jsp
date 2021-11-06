<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org" lang="en">
<head>
    <title>Login Page</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1,shrink-to-fit=no">
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    <script
            src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div>
    <div id="loginbox" style="margin-top: 50px;" class="mainbox col-md-3col-md-offset-2 col-sm-6 col-sm-offset-2">
        <div class="panel panel-info">
            <div class="panel-heading">
                <div class="panel-title">Sign In</div>
            </div>
            <div style="padding-top: 30px" class="panel-body">
                <form th:action="@{/authenticateTheUser}" method="POST"
                      class="form-horizontal">
                    <div class="form-group">
                        <div class="col-xs-15">
                            <div>
                                <div th:if="${param.error} != null">
                                    <div class="alert alert-dangercol-xs-offset-1 col-xs-10">
                                        Invalid username or password
                                    </div>
                                </div>
                                <div th:if="${param.logout} != null">
                                    <div class="alert alert-successcol-xs-offset-1 col-xs-10">
                                        You have been logged out.
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div style="margin-bottom: 25px" class="input-group">
                        <span class="input-group-addon"><i class="glyphiconglyphicon-user"></i></span>
                        <input type="text" name="username"
                               placeholder="username" class="form-control">
                    </div>
                    <div style="margin-bottom: 25px" class="input-group">
                        <span class="input-group-addon"><i class="glyphiconglyphicon-lock"></i></span>
                        <input type="password" name="password"
                               placeholder="password" class="form-control">
                    </div>
                    <div style="margin-top: 10px" class="form-group">
                        <div class="col-sm-6 controls">
                            <button type="submit" class="btnbtn-success">Login</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>