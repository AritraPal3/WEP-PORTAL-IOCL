<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>INDIAN OIL</title>
    <style>
        body {
            background-color: rgb(183, 220, 227);
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }
        .container {
            max-width: 800px;
            margin: 0 auto;
            padding: 20px;
        }
        .Header {
            text-align: center;
            text-decoration: underline;
            margin-top: 20px;
            margin-bottom: 30px;
        }
        .Body {
            text-align: center;
        }
        .Body a {
            display: block;
            margin: 10px 0;
            padding: 10px 20px;
            background-color: #ffffff;
            border: 1px solid black;
            text-decoration: none;
            color: black;
            font-weight: bold;
        }
        .Footer {
            text-align: center;
            margin-top: 30px;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="Header">
        	<img src="https://iocl.com/images/static/indianoil_logo.jpg" style="width:250px; height:220px; align:center;">
            <h1>EASTERN REGION OFFICE</h1>
        </div>
        <div class="Body">
            <a href="/WebPortal/FullData">SHOW EASTERN REGION DATA</a>
            <a href='/WebPortal/Route'>OPEN THE FILTER PAGE 1</a>
            <a href='/WebPortal/Filter1'>OPEN THE FILTER PAGE 2</a>
        </div>
        <div class="Footer">
            &copy; 2023 Eastern Region Office 
        </div>
    </div>
</body>
</html>
