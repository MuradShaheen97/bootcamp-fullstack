<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="https://cdn.tailwindcss.com"></script>
        <script src="https://kit.fontawesome.com/25732d4a9b.js" crossorigin="anonymous"></script>
        <title>Add Book</title>
    </head>

    <body class="bg-slate-900 text-slate-100 font-sans min-h-screen flex flex-col justify-between">

        <!-- Header -->
        <header class="text-center pt-10 pb-6">
            <span class="text-xs uppercase tracking-[0.15em] text-purple-300 font-medium">
                Curated Library Space
            </span>
        </header>

        <!-- Main Content Area -->
        <main class="flex-grow max-w-2xl w-full mx-auto px-6">

            <!-- Back Link -->
            <div class="mb-8">
                <a href="#" class="text-xs text-slate-400 hover:text-purple-300 transition-colors">
                    <i class="fa-solid fa-arrow-left mr-1"></i> Back to the vault
                </a>
            </div>

            <!-- Section Title -->
            <div class="border-b border-slate-800 pb-4 mb-6">
                <h1 class="text-2xl font-semibold tracking-tight text-white">Add new edition</h1>
                <p class="text-xs text-slate-400 mt-1">Insert a new record into the collection repository.</p>
            </div>

            <!-- Spring Form Layout (Assumes 'book' model attribute) -->
            <form:form action="/addingBook" method="POST" modelAttribute="book" class="space-y-5">

                <!-- Title Input -->
                <div>
                    <div class="flex justify-between items-center mb-2">
                        <form:label path="title"
                            class="block text-xs font-medium text-slate-400 uppercase tracking-wider">Book Title
                        </form:label>
                        <form:errors path="title" class="text-xs text-pink-400 font-medium animate-pulse" />
                    </div>
                    <form:input path="title"
                        class="w-full bg-slate-950 border border-slate-800 rounded-lg px-4 py-2.5 text-sm text-slate-100 focus:outline-none focus:border-purple-500 transition-colors"
                        placeholder="e.g., The Obsidian Horizon" />
                </div>

                <!-- Two Column Row (Language & Pages) -->
                <div class="grid grid-cols-1 sm:grid-cols-2 gap-4">
                    <!-- Language Input -->
                    <div>
                        <div class="flex justify-between items-center mb-2">
                            <form:label path="language"
                                class="block text-xs font-medium text-slate-400 uppercase tracking-wider">Language
                            </form:label>
                            <form:errors path="language" class="text-xs text-pink-400 font-medium animate-pulse" />
                        </div>
                        <form:input path="language"
                            class="w-full bg-slate-950 border border-slate-800 rounded-lg px-4 py-2.5 text-sm text-slate-100 focus:outline-none focus:border-purple-500 transition-colors"
                            placeholder="e.g., English" />
                    </div>

                    <!-- Pages Input -->
                    <div>
                        <div class="flex justify-between items-center mb-2">
                            <form:label path="pages"
                                class="block text-xs font-medium text-slate-400 uppercase tracking-wider">Number of
                                Pages</form:label>
                            <form:errors path="pages" class="text-xs text-pink-400 font-medium animate-pulse" />
                        </div>
                        <form:input type="number" path="pages"
                            class="w-full bg-slate-950 border border-slate-800 rounded-lg px-4 py-2.5 text-sm text-slate-100 font-mono focus:outline-none focus:border-purple-500 transition-colors"
                            placeholder="300" />
                    </div>
                </div>

                <!-- Description Input -->
                <div>
                    <div class="flex justify-between items-center mb-2">
                        <form:label path="description"
                            class="block text-xs font-medium text-slate-400 uppercase tracking-wider">Synopsis /
                            Description</form:label>
                        <form:errors path="description" class="text-xs text-pink-400 font-medium animate-pulse" />
                    </div>
                    <form:textarea path="description" rows="5"
                        class="w-full bg-slate-950 border border-slate-800 rounded-lg px-4 py-2.5 text-sm text-slate-100 focus:outline-none focus:border-purple-500 transition-colors resize-none"
                        placeholder="Briefly describe the theme or plot summary..." />
                </div>

                <!-- Action Buttons -->
                <div class="pt-2 flex items-center justify-end gap-3">
                    <a href="/" class="text-xs text-slate-400 hover:text-slate-200 px-4 py-2 transition-colors">
                        Cancel
                    </a>
                    <button type="submit"
                        class="bg-purple-600 hover:bg-purple-500 text-white font-medium text-xs px-4 py-2.5 rounded-lg transition-colors duration-150">
                        Save Record
                    </button>
                </div>

            </form:form>

        </main>

        <!-- Footer -->
        <footer class="text-center py-10 text-xs text-slate-600">
            <p>&copy; 2026 Orchid Media</p>
        </footer>

    </body>

    </html>