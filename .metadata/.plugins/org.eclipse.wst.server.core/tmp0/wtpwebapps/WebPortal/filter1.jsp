<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Fill Up the Fields to Filter</title>
    <style>
        body {
            text-align: center;
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
            background-color: rgb(224, 237, 236);
        }
        .form-container {
            border: 1px solid black;
            width: 50%;
            margin: auto;
            padding: 20px;
            background-color: white;
        }
        .Header {
            text-align: center;
            text-decoration: underline;
            margin-top: 2%;
        }
        .Body {
            padding: 20px;
            display: flex;
            justify-content: center;
        }
        form {
            width: 100%;
            max-width: 400px;
            margin: auto;
        }
        label {
            display: inline-block;
            width: 140px;
            text-align: left;
            font-weight: bold;
            margin-bottom: 5px;
        }

        button {
            background-color: #4caf50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-weight: bold;
        }
        button:hover {
            background-color: #45a049;
        }
        .Footer {
            text-align: center;
            margin-top: 30px;
        }
    </style>
</head>
<body>
    <div class="Header">
        <h1>Fill Up the Fields to Filter</h1>
    </div>
    <div class="Body">
        <div class="form-container">
            <form action="Route1" method="get">
                <!--<div>
                    <label>S_No</label> <input type="number" name="sno" value="-1">
                </div>
                <br>
                <div>
                    <label>Reference No.</label> <input type="text" name="refno" value="">
                </div>
                <br>
                <div>
                    <label>Initiator Name</label> <input type="text" name="initname" value="">
                </div>
                <br>
                <div>
                    <label>Initiator Department</label> <input type="text" name="initdep" value="">
                </div>
                <br>
                <div>
                    <label>Initiator Location</label> <input type="text" name="initloc" value="">
                </div>
                <br>
                <div>
                    <label>Pending Department</label> <input type="text" name="pendep" value="Eastern Region Office">
                </div>
                <br>
                <div>
                    <label>Pending User</label> <input type="text" name="penduser" value="">
                </div>
                <br>
                <div>
                    <label>Pending Location</label> <input type="text" name="pendloc" value="">
                </div>
                <br>
                <div>
                    <label>Subject</label> <input type="text" name="sub" value="">
                </div>
                <br>-->
                <div>
                    <label>No of Days</label> <input type="number" name="numday" value="60">
                </div>
                <br>
                <button>Submit</button>
            </form>
        </div>
    </div>
    <div class="Footer">
        &copy; 2023 Fill Up the Fields
    </div>
</body>
</html>
