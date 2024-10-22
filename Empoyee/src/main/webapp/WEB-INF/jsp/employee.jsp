<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
    pageEncoding="ISO-8859-1"%> 
<!DOCTYPE html> 
<html> 
<head> 
<meta charset="ISO-8859-1"> 
<title>Employee Registration Form</title> 
    <style> 
        body { 
            font-family: Arial, sans-serif; 
            background-color: #f3f3f3; 
            display: flex; 
            justify-content: center; 
            align-items: center; 
            height: 100vh; 
            margin: 0; 
        } 
        .container { 
            background-color: #fff; 
            padding: 20px; 
            border-radius: 10px; 
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); 
            width: 300px; 
        } 
        h2 { 
            color: #333; 
            margin-bottom: 20px; 
        } 
        label { 
            display: block; 
            margin-bottom: 5px; 
            color: #555; 
        } 
        input[type="text"], input[type="email"], input[type="password"], select { 
            width: 100%; 
            padding: 10px; 
            margin-bottom: 15px; 
            border: 1px solid #ddd; 
            border-radius: 5px; 
        } 
        button { 
            width: 100%; 
            padding: 10px; 
            background-color: #4caf50; 
            color: white; 
            border: none; 
            border-radius: 5px; 
            cursor: pointer; 
        } 
    </style> 
</head> 
<body> 
<div class="container"> 
        <h2>Employee Registration</h2> 
        <form id="registrationForm" action="/register" method="post"> 
            <label for="firstName">First Name:</label> 
            <input type="text" id="firstName" name="firstName" required> 
             
            <label for="lastName">Last Name:</label> 
            <input type="text" id="lastName" name="lastName" required> 
             
            <label for="email">Email:</label> 
            <input type="email" id="email" name="email" required> 
             
            <label for="password">Password:</label> 
            <input type="password" id="password" name="password" required> 
             
            <label for="role">Role:</label> 
            <input type="text" id="role" name="role" required> 
             
            <label for="designation">Designation:</label> 
            <input type="text" id="designation" name="designation" required> 
             
            <label for="salary">Salary:</label> 
            <input type="text" id="salary" name="salary" required> 
             
            <button type="submit">Register</button> 
           
            </form><br/>
		<div class="d-flex justify-content-center align-items-center vh-100">
			<a href="/loadData" class="btn btn-primary">All Data</a>
		</div>

	</div>
            
            
            <script type="text/javascript">
            document.getElementById("registrationForm").addEventListener("submit", function(event) {
                event.preventDefault(); 

                const formData = new FormData(event.target);
                
                const formDataJSON = {};
                formData.forEach((value, key) => {
                    formDataJSON[key] = value;
                });

                console.log(JSON.stringify(formDataJSON));

                 fetch('/register', {
                     method: 'POST',
                     headers: {
                         'Content-Type': 'application/json'
                     },
                     body: JSON.stringify(formDataJSON)
                 }).then(response => {
                     if (response.status === 200 || response.status === 201) {
                         return response.text(); 
                     } else {
                         throw new Error('Failed to save employee data');
                     }
                 }).then(data => {
                     console.log(data); 
                     alert(data); 
                 }).catch(error => {
                     console.error('Error:', error);
                     alert('An error occurred while saving the employee data');
                 });
             });
            
            </script>
</body> 
</html>

