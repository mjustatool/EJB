<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body class="bg-gray-100 h-screen flex items-center justify-center">
<div class="flex w-4/5">

        <!-- Form Container -->
        <div class="bg-white p-8 rounded-lg shadow-md flex-shrink-0">

            <h2 class="text-2xl font-semibold mb-6 text-center">Filiere Register</h2>

            <form action="FiliereController" method="post">

                <div class="mb-4">
                    <label for="firstName" class="block text-sm font-medium text-gray-700">NAME</label>
                    <input type="text" id="name" name="name" value ="${emptyFil.name }"
                        class="mt-1 p-2 w-full border border-gray-300 rounded-md focus:outline-none focus:ring focus:border-indigo-300">
                </div>

                <div class="mb-4">
                    <label for="lastName" class="block text-sm font-medium text-gray-700">CODE</label>
                    <input type="text" id="code" name="code" value ="${emptyFil.code }"
                        class="mt-1 p-2 w-full border border-gray-300 rounded-md focus:outline-none focus:ring focus:border-indigo-300">
                </div>

                

                <!-- Submit Button -->
                <input type="hidden" name="action" value="${buttonMode}">
                <input type="hidden" name="updatefiliereid" value="${emptyFil.id}">
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
                        <th class="border border-gray-300 p-2">NAME</th>
                        <th class="border border-gray-300 p-2">CODE</th>
                        <th class="border border-gray-300 p-2">Actions</th>
                    </tr>
                </thead>
                
                <tbody>
                    <c:forEach items="${filieres}" var ="filiere">
                    
                    <tr>
                        <td class="border border-gray-300 p-2">${filiere.id}</td>
                        <td class="border border-gray-300 p-2">${filiere.name}</td>
                        <td class="border border-gray-300 p-2">${filiere.code}</td>
                        <td class="border border-gray-300 p-2 flex items-center justify-center">
                        	<form action="FiliereController" method="post">
                        		<input type="hidden" name="action" value="update">
                        		
                            	<input type="hidden" name="filiereidupt" value="${ filiere.id }">
                            	
                            	<button class="text-blue-500 mr-2" type="submit" >Edit</button>
                            	
                            </form>
                            <form action="FiliereController" method="post">
                            	<input type="hidden" name="action" value="delete">
                            	<input type="hidden" name="filiereid" value="${ filiere.id }">
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