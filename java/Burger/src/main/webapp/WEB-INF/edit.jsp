<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <script src="https://cdn.tailwindcss.com"></script>
    <title>Edit Burger</title>
</head>
<body class="bg-stone-50 min-h-screen flex items-center justify-center p-6">

    <div class="bg-white border border-stone-200 rounded-2xl p-6 shadow-md max-w-2xl w-full">
        <h2 class="text-xl font-bold text-stone-800 mb-6">Edit Burger Entry</h2>

        <form:form method="POST" action="/burgers/update/${burger.id}" modelAttribute="burger" class="space-y-4">
            
            <div class="flex flex-col gap-1">
                <form:label path="name" class="text-xs font-bold text-stone-600">Burger Name</form:label>
                <form:input path="name" class="w-full bg-stone-50 border border-stone-300 rounded-xl px-4 py-2 text-sm" />
                <form:errors path="name" cssClass="text-xs text-red-500 font-semibold" />
            </div>

            <div class="flex flex-col gap-1">
                <form:label path="resturantName" class="text-xs font-bold text-stone-600">Restaurant Name</form:label>
                <form:input path="resturantName" class="w-full bg-stone-50 border border-stone-300 rounded-xl px-4 py-2 text-sm" />
                <form:errors path="resturantName" cssClass="text-xs text-red-500 font-semibold" />
            </div>

            <div class="flex flex-col gap-1">
                <form:label path="rate" class="text-xs font-bold text-stone-600">Rating (1-5)</form:label>
                <form:input path="rate" type="number" min="1" max="5" step="0.1" class="w-full bg-stone-50 border border-stone-300 rounded-xl px-4 py-2 text-sm" />
                <form:errors path="rate" cssClass="text-xs text-red-500 font-semibold" />
            </div>

            <div class="flex flex-col gap-1">
                <form:label path="notes" class="text-xs font-bold text-stone-600">Tasting Notes</form:label>
                <form:textarea path="notes" rows="4" class="w-full bg-stone-50 border border-stone-300 rounded-xl px-4 py-2 text-sm resize-none" />
                <form:errors path="notes" cssClass="text-xs text-red-500 font-semibold" />
            </div>

            <div class="flex gap-4 pt-2">
                <a href="/" class="w-1/2 text-center bg-stone-200 hover:bg-stone-300 text-stone-700 font-bold py-2.5 rounded-xl text-sm transition-all">Cancel</a>
                <button type="submit" class="w-1/2 bg-amber-500 hover:bg-amber-600 text-white font-bold py-2.5 rounded-xl text-sm transition-all shadow-md">Update Entry</button>
            </div>
        </form:form>
    </div>

</body>
</html>