<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Employee Details</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>

<div class="container">
	<a href="/" class="btn btn-primary">+ Register</a>
	<table class="table table-striped" id="employeeTable">
		<thead>
			<tr>
				<th>Sr. No</th>
				<th>Name</th>
				<th>Email</th>
				<th>Designation</th>
				<th>Role</th>
				<th>Salary</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>

		</tbody>
	</table>
</div>

<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script>
    $(document).ready(function() {
        $.ajax({
            url: '/employees',
            type: 'GET',
            dataType: 'json',
            success: function(data) {
                console.log('Data fetched successfully:', data); 
                let tableBody = $('#employeeTable tbody');
                tableBody.empty(); 
                
                if (data.length === 0) {
                    let row = $('<tr>');
                    row.append($('<td>').attr('colspan', 6).text('No records exist').css('text-align', 'center'));
                    tableBody.append(row);
                } else {
                    $.each(data, function(index, employee) {
                        console.log('Processing employee:', employee); 
                        let row = $('<tr>');

                        row.append($('<td>').text(index + 1));
                        row.append($('<td>').text($.trim(employee.firstName) + ' ' + $.trim(employee.lastName)));
                        row.append($('<td>').text(employee.email));
                        row.append($('<td>').text(employee.designation));
                        row.append($('<td>').text(employee.role));
                        row.append($('<td>').text(employee.salary));

                        let button = $('<button>')
                            .attr('type', 'button')
                            .attr('data-employee-id', employee.employeeId)
                            .text('Delete')
                            .addClass('btn btn-primary')
                            .on('click', function() {
                                let employeeId = $(this).data('employee-id');
                                $.ajax({
                                    url: '/delete/' + employeeId,
                                    type: 'DELETE',
                                    success: function(result) {
                                        console.log('Employee deleted successfully');
                                        location.reload(); 
                                    },
                                    error: function(xhr, status, error) {
                                        console.error('Error deleting employee:', error);
                                    }
                                });
                            });
                        row.append($('<td>').append(button));
                        tableBody.append(row);
                    });
                }
            },
            error: function(error) {
                console.error('Error fetching employee data:', error);
            }
        });
    });

    </script>
    
    
    
</html>