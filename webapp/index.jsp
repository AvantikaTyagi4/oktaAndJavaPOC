<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
    <link
      rel="stylesheet"
      href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
      integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
      crossorigin="anonymous"
    />
    <title>OKTA Java POC</title>
  </head>
  <body>
    <div class="container">
      <h1>Login Form</h1>
      <div class="card">
        <div class="card-body">
          <form action="loginServlet" method="post">
            <div class="form-group row">
              <label for="username" class="col-sm-2 col-form-label">
                Username</label
              >
              <div class="col-sm-7">
                <input
                  type="text"
                  class="form-control"
                  name="username"
                  placeholder="Enter username"
                />
              </div>
            </div>
            <div class="form-group row">
              <label for="password" class="col-sm-2 col-form-label">
                Password</label
              >
              <div class="col-sm-7">
                <input
                  type="password"
                  class="form-control"
                  name="password"
                  placeholder="Enter password"
                />
              </div>
            </div>

            <input class="btn btn-primary" type="submit" value="Login" />

            <input
              class="btn btn-primary"
              type="button"
              value="Login with OKTA"
              onclick="window.location='oktaRedirect'"
            />
          </form>
        </div>
      </div>
    </div>
  </body>
</html>
