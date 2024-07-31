<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign In</title>
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
        }

        .container {
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            background-color: white;
            padding: 2rem;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        h2 {
            margin-bottom: 1rem;
        }

        .form-group {
            display: flex;
            flex-direction: column;
            margin-bottom: 1rem;
            width: 100%;
        }

        label {
            margin-bottom: 0.5rem;
        }

        input {
            padding: 0.5rem;
            font-size: 1rem;
            border: 1px solid #ccc;
            border-radius: 4px;
            width: 100%;
        }

        .btn {
            padding: 0.75rem;
            font-size: 1rem;
            color: white;
            background-color: #007bff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            width: 100%;
        }

        .btn:hover {
            background-color: #0056b3;
        }

        .message {
            margin-top: 1rem;
            color: red;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Sign In</h2>
        <form action="<%= request.getContextPath() %>/user/signIn" method="post">
            <div class="form-group">
                <label for="username">Username</label>
                <input type="text" id="username" name="username" required>
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input type="password" id="password" name="password" required>
            </div>
            <button type="submit" class="btn">Sign In</button>
            <% if (request.getParameter("message") != null) { %>
                <div class="message"><%= request.getParameter("message") %></div>
            <% } %>
        </form>
    </div>
    <img style="display: block;-webkit-user-select: none;margin: auto;background-color: hsl(0, 0%, 90%);transition: background-color 300ms;" src="https://postfiles.pstatic.net/MjAyMjAxMzBfMTM4/MDAxNjQzNTM1MTgzMDE5.Bg1waDAWei7-yyLtf58IVB-jBUFs9L0m-4zRFnZqx5Ig.qzNDbmtJG0viwApnwyd5ETClYZ5c1moIqK8489Rj7Oog.JPEG.cizy9711/20220129%EF%BC%BF154110.jpg?type=w2000">
</body>
</html>
