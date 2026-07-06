<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://cdn.tailwindcss.com"></script>
<script src="https://kit.fontawesome.com/25732d4a9b.js"
	crossorigin="anonymous"></script>
<title>Orchid Books - Catalog</title>
</head>

<body
	class="bg-slate-900 text-slate-100 font-sans min-h-screen flex flex-col justify-between">

	<!-- Header -->
	<header class="text-center pt-10 pb-6">
		<span
			class="text-xs uppercase tracking-[0.15em] text-purple-300 font-medium">
			Curated Library Space </span>
	</header>

	<!-- Main Content Area -->
	<main class="flex-grow max-w-3xl w-full mx-auto px-6">

		<!-- Title and Action Bar -->
		<div class="flex items-center justify-between mb-6">
			<div>
				<h1 class="text-2xl font-semibold tracking-tight text-white">The
					book vault</h1>
				<p class="text-xs text-slate-400 mt-1">Indie editions and
					localized titles.</p>
			</div>
			<a href="/addBook"
				class="inline-flex items-center gap-1.5 bg-purple-600 hover:bg-purple-500 text-white font-medium text-xs px-3.5 py-2 rounded-lg transition-colors duration-150">
				<i class="fa-solid fa-plus text-[10px]"></i> Add edition
			</a>
		</div>

		<!-- Table Container -->
		<div class="border border-slate-800 rounded-xl overflow-hidden">
			<table class="w-full text-left border-collapse">
				<thead>
					<tr
						class="text-xs font-medium uppercase tracking-wider text-slate-500 border-b border-slate-800">
						<th class="py-3 px-5 w-14 font-mono text-slate-600">Ref.</th>
						<th class="py-3 px-5">Title</th>
						<th class="py-3 px-5">Language</th>
						<th class="py-3 px-5 text-right">Length</th>
					</tr>
				</thead>
				<tbody class="divide-y divide-slate-800 text-sm">
					<!-- Row 1 -->
					<c:forEach var="book" items="${books}">
						<tr class="hover:bg-slate-800/40 transition-colors">
							<td class="py-4 px-5 font-mono text-slate-600">${book.id}</td>
							<td class="py-4 px-5"><a href="/books/${book.id}"
								class="font-medium text-slate-100 hover:text-purple-300 transition-colors">
									${book.title} </a></td>
							<td class="py-4 px-5"><span
								class="text-xs text-purple-300 bg-purple-500/10 px-2 py-0.5 rounded">${book.language}</span>
							</td>
							<td class="py-4 px-5 text-right font-mono text-xs text-slate-400">${book.pages}</td>
						</tr>
					</c:forEach>			
				</tbody>
			</table>

			<!-- Table Summary Footer -->
			<div
				class="px-5 py-3 border-t border-slate-800 flex justify-between items-center text-xs text-slate-500">
				<span>${fn:length(books)} records</span> 
			</div>
		</div>

	</main>

	<!-- Footer -->
	<footer class="text-center py-10 text-xs text-slate-600">
		<p>&copy; 2026 Orchid Media</p>
	</footer>

</body>

</html>