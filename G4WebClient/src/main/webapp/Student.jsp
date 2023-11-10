<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
 <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
</head>
<body class="bg-gray-100 h-screen flex items-center justify-center">

	 <div class="flex w-4/5">
		
        <!-- Form Container -->
        <div class="bg-white p-8 rounded-lg shadow-md flex-shrink-0">
			
            <h2 class="text-2xl font-semibold mb-6 text-center">Student Register</h2>

            <form action="StudentController" method="post">

                <div class="mb-4">
                    <label for="firstName" class="block text-sm font-medium text-gray-700">First Name</label>
                    <input type="text" id="firstName" name="firstName" value ="${emptyStud.firstName }"
                        class="mt-1 p-2 w-full border border-gray-300 rounded-md focus:outline-none focus:ring focus:border-indigo-300">
                </div>

                <div class="mb-4">
                    <label for="lastName" class="block text-sm font-medium text-gray-700">Last Name</label>
                    <input type="text" id="lastName" name="lastName" value ="${emptyStud.lastName }"
                        class="mt-1 p-2 w-full border border-gray-300 rounded-md focus:outline-none focus:ring focus:border-indigo-300">
                </div>

                <div class="mb-4">
                    <label for="email" class="block text-sm font-medium text-gray-700">Email</label>
                    <input type="email" id="email" name="email" value ="${emptyStud.email }"
                        class="mt-1 p-2 w-full border border-gray-300 rounded-md focus:outline-none focus:ring focus:border-indigo-300">
                </div>

                <div class="mb-4">
                    <label for="telephone" class="block text-sm font-medium text-gray-700">Telephone</label>
                    <input type="tel" id="telephone" name="telephone" value ="${emptyStud.telephone }"
                        class="mt-1 p-2 w-full border border-gray-300 rounded-md focus:outline-none focus:ring focus:border-indigo-300">
                </div>

                <div class="mb-4">
                    <label for="password" class="block text-sm font-medium text-gray-700">Password</label>
                    <input type="password" id="password" name="password" value ="${emptyStud.password }"
                        class="mt-1 p-2 w-full border border-gray-300 rounded-md focus:outline-none focus:ring focus:border-indigo-300">
                </div>
				<div class="mb-4 relative">
    <label for="filiere" class="block text-sm font-medium text-gray-700">Filiere</label>

    <div class="relative inline-block w-full text-gray-700">
        <div class="relative">
            <select id="filiere" name="filiere"
                    class="block appearance-none w-full bg-white border border-gray-300 text-gray-700 py-2 px-4 pr-8 rounded-md leading-tight focus:outline-none focus:border-indigo-300 focus:ring focus:ring-indigo-200 focus:ring-opacity-50">
                <c:forEach items="${filieres}" var="filiere">
                    <option value="${filiere.id}">${filiere.name}</option>
                </c:forEach>
            </select>
        </div>
    </div>

</div>

                <!-- Submit Button -->
                <input type="hidden" name="action" value="${buttonMode}">
                <input type="hidden" name="updatestudentid" value="${emptyStud.id}">
                <button type="submit"
                    class="w-full bg-indigo-500 text-white p-2 rounded-md hover:bg-indigo-600 focus:outline-none focus:ring focus:border-indigo-300">
                    Register
                </button>

            </form>

        </div>
		

        <!-- Data Grid Container -->
        <div class="bg-white p-8 rounded-lg shadow-md flex-grow ml-4">

            <h2 class="text-2xl font-semibold mb-4 text-center">Data Grid</h2>

            <!-- Data Grid Table -->
            <table class="w-full border-collapse border border-gray-300">
                <thead>
                    <tr>
                    	<th class="border border-gray-300 p-2">ID</th>
                        <th class="border border-gray-300 p-2">First Name</th>
                        <th class="border border-gray-300 p-2">Last Name</th>
                        <th class="border border-gray-300 p-2">Email</th>
                        <th class="border border-gray-300 p-2">Telephone</th>
                        <th class="border border-gray-300 p-2">Filiere</th>
                        <th class="border border-gray-300 p-2">Actions</th>
                    </tr>
                </thead>
                
                <tbody>
                    <c:forEach items="${students}" var ="student">
                    
                    <tr>
                        <td class="border border-gray-300 p-2">${student.id}</td>
                        <td class="border border-gray-300 p-2">${student.firstName}</td>
                        <td class="border border-gray-300 p-2">${student.lastName}</td>
                        <td class="border border-gray-300 p-2">${student.email}</td>
                        <td class="border border-gray-300 p-2">${student.telephone}</td>
                        <td class="border border-gray-300 p-2">${student.filiere.name}</td>
                        <td class="border border-gray-300 p-2 flex items-center justify-center">
                        	<form action="StudentController" method="post">
                        		<input type="hidden" name="action" value="update">
                        		
                            	<input type="hidden" name="studentidupt" value="${ student.id }">
                            	
                            	<button class="text-blue-500 mr-2" type="submit" >Edit</button>
                            	
                            </form>
                            <form action="StudentController" method="post">
                            	<input type="hidden" name="action" value="delete">
                            	<input type="hidden" name="studentid" value="${ student.id }">
                            	<button class="text-red-500" type="submit">Delete</button>
                            </form>
                        </td>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>

        </div>

    </div>







<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
<script src="https://cdn.tailwindcss.com?plugins=forms,typography,aspect-ratio,line-clamp"></script>
<script src="https://cdn.tailwindcss.com"></script>



</body>
</html>