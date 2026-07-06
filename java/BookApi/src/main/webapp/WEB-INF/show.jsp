<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://cdn.tailwindcss.com"></script>
    <script src="https://kit.fontawesome.com/25732d4a9b.js" crossorigin="anonymous"></script>
    <title>Book Details</title>
</head>

<body class="bg-slate-900 text-slate-100 font-sans min-h-screen flex flex-col justify-between">

    <header class="text-center pt-10 pb-6">
        <span class="text-xs uppercase tracking-[0.15em] text-purple-300 font-medium">
            Curated Library Space
        </span>
    </header>

    <main class="flex-grow max-w-2xl w-full mx-auto px-6">

        <div class="mb-8 flex items-center justify-between">
            <a href="/" class="text-xs text-slate-400 hover:text-purple-300 transition-colors">
                <i class="fa-solid fa-arrow-left mr-1"></i> Back to the vault
            </a>
            
            <a href="/updateBook/${book.id}" class="inline-flex items-center gap-1.5 border border-slate-700 bg-slate-800/40 hover:bg-slate-800 text-slate-200 hover:text-purple-300 font-medium text-xs px-3 py-1.5 rounded-md transition-colors duration-150">
                <i class="fa-solid fa-pen text-[10px]"></i> Edit edition
            </a>
        </div>

        <div class="border-b border-slate-800 pb-4 mb-6">
            <div class="flex items-baseline justify-between gap-4">
                <h1 class="text-2xl font-semibold tracking-tight text-white">${book.title}</h1>
                <span class="text-xs text-purple-300 font-mono">Ref. ${book.id}</span>
            </div>
            <p class="text-xs text-slate-400 mt-1">
                Language: <span class="text-purple-300">${book.language}</span> &bull; Length: <span
                    class="text-slate-300">${book.pages}p</span>
            </p>
        </div>

        <div class="text-slate-300 text-sm leading-relaxed space-y-4">
            <p>
                ${book.description}
            </p>
        </div>

    </main>

    <footer class="text-center py-10 text-xs text-slate-600">
        <p>&copy; 2026 Orchid Media</p>
    </footer>

</body>

</html>