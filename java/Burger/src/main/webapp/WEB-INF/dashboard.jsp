<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<%@ taglib prefix="fn" uri="jakarta.tags.functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://cdn.tailwindcss.com"></script>
<script src="https://kit.fontawesome.com/25732d4a9b.js"
	crossorigin="anonymous"></script>
<title>Burger Tracker</title>
<script>
	tailwind.config = {
		theme : {
			extend : {
				colors : {
					brandGreen : '#5B7E3C',
					brandYellow : '#FFD65A',
					brandOrange : '#FF9D23',
					brandRed : '#EA5252',
					brandCream : '#FFFDF6',
				}
			}
		}
	}
</script>
</head>

<body
	class="bg-brandCream text-stone-800 font-sans min-h-screen flex flex-col justify-between selection:bg-brandOrange selection:text-white">

	<header
		class="text-center pt-12 pb-8 border-b border-stone-200/60 bg-white/80 backdrop-blur-sm sticky top-0 z-50 shadow-sm">
		<div class="flex items-center justify-center gap-2 mb-1">
			<i class="fa-solid fa-burger text-brandOrange text-2xl"></i>
			<h1
				class="text-2xl font-black tracking-wider text-stone-900 uppercase">
				Burger <span class="text-brandGreen">Tracker</span>
			</h1>
		</div>
		<p class="text-xs text-stone-500 font-medium tracking-wide">Keep
			track of your culinary conquests</p>
	</header>

	<main class="flex-grow max-w-4xl w-full mx-auto px-4 py-8 space-y-12">

		<section
			class="bg-white border border-stone-200 rounded-2xl p-6 shadow-md">
			<div class="flex items-center gap-3 mb-6">
				<i class="fa-solid fa-list-ul text-brandGreen text-lg"></i>
				<h2 class="text-xl font-bold text-stone-800">Logged Burgers</h2>
			</div>

			<div class="overflow-x-auto rounded-xl border border-stone-200">
				<table class="w-full text-left border-collapse">
					<thead>
						<tr
							class="bg-stone-50 border-b border-stone-200 text-stone-600 text-xs uppercase tracking-wider">
							<th class="py-4 px-5 font-semibold">Burger Name</th>
							<th class="py-4 px-5 font-semibold">Restaurant</th>
							<th class="py-4 px-5 font-semibold text-center">Rating</th>
							<th class="py-4 px-5 font-semibold text-right">Actions</th>
						</tr>
					</thead>
					<tbody class="divide-y divide-stone-100 text-sm">
						<c:forEach items="${burgers}" var="burger">
							<tr class="hover:bg-stone-50/50 transition-colors">
								<td class="py-4 px-5 font-semibold text-stone-900">${burger.name}</td>
								<td class="py-4 px-5 text-stone-600">${burger.resturantName}</td>
								<td class="py-4 px-5 text-center"><span
									class="inline-flex items-center gap-1 bg-brandYellow/20 text-stone-800 px-2.5 py-1 rounded-full text-xs font-bold border border-brandYellow/50">
										${burger.rate} <i
										class="fa-solid fa-star text-brandOrange text-[10px]"></i>
								</span></td>
								<td class="py-4 px-5 text-right space-x-4"><a
									href="/burgers/edit/${burger.id}"
									class="inline-flex items-center gap-1 text-stone-500 hover:text-brandGreen font-semibold transition-colors text-xs">
										<i class="fa-solid fa-pen text-[10px]"></i> Edit
								</a> <a href="/burgers/delete/${burger.id}"
									class="inline-flex items-center gap-1 text-stone-500 hover:text-brandRed font-semibold transition-colors text-xs"
									onclick="return confirm('Are you sure you want to delete this burger?')">
										<i class="fa-solid fa-trash text-[10px]"></i> Delete
								</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</section>

		<section
			class="bg-white border border-stone-200 rounded-2xl p-6 shadow-md">
			<div class="flex items-center gap-3 mb-6">
				<i class="fa-solid fa-plus-circle text-brandOrange text-lg"></i>
				<h2 class="text-xl font-bold text-stone-800">Add a New Burger</h2>
			</div>

			<form:form method="POST" action="/addBurger" modelAttribute="burger"
				class="grid grid-cols-1 md:grid-cols-2 gap-6">

				<div class="flex flex-col gap-2">
					<form:label path="name"
						class="text-xs font-bold uppercase tracking-wider text-stone-600">Burger Name</form:label>
					<div class="relative">
						<form:input path="name" placeholder="e.g., The Truffle Beast"
							class="w-full bg-stone-50 border border-stone-300 rounded-xl px-4 py-3 text-stone-900 placeholder-stone-400 focus:outline-none focus:border-brandGreen focus:ring-2 focus:ring-brandGreen/20 transition-all text-sm" />
					</div>
					<form:errors path="name"
						cssClass="text-xs text-brandRed font-semibold mt-1" />
				</div>

				<div class="flex flex-col gap-2">
					<form:label path="resturantName"
						class="text-xs font-bold uppercase tracking-wider text-stone-600">Restaurant Name</form:label>
					<div class="relative">
						<form:input path="resturantName"
							placeholder="e.g., Burger Joint Co."
							class="w-full bg-stone-50 border border-stone-300 rounded-xl px-4 py-3 text-stone-900 placeholder-stone-400 focus:outline-none focus:border-brandGreen focus:ring-2 focus:ring-brandGreen/20 transition-all text-sm" />
					</div>
					<form:errors path="resturantName"
						cssClass="text-xs text-brandRed font-semibold mt-1" />
				</div>

				<div class="flex flex-col gap-2 md:col-span-2">
					<form:label path="rate"
						class="text-xs font-bold uppercase tracking-wider text-stone-600">Rating (1-5 Stars)</form:label>
					<div class="relative">
						<form:input path="rate" type="number" min="1" max="5" step="0.1"
							placeholder="5"
							class="w-full bg-stone-50 border border-stone-300 rounded-xl px-4 py-3 text-stone-900 placeholder-stone-400 focus:outline-none focus:border-brandGreen focus:ring-2 focus:ring-brandGreen/20 transition-all text-sm" />
					</div>
					<form:errors path="rate"
						cssClass="text-xs text-brandRed font-semibold mt-1" />
				</div>

				<div class="flex flex-col gap-2 md:col-span-2">
					<form:label path="notes"
						class="text-xs font-bold uppercase tracking-wider text-stone-600">Tasting Notes</form:label>
					<div class="relative">
						<form:textarea path="notes"
							placeholder="Describe the bun, patties, sauce, or general majesty..."
							rows="4"
							class="w-full bg-stone-50 border border-stone-300 rounded-xl px-4 py-3 text-stone-900 placeholder-stone-400 focus:outline-none focus:border-brandGreen focus:ring-2 focus:ring-brandGreen/20 transition-all text-sm resize-none" />
					</div>
					<form:errors path="notes"
						cssClass="text-xs text-brandRed font-semibold mt-1" />
				</div>

				<div class="md:col-span-2 pt-2">
					<button type="submit"
						class="w-full bg-brandOrange hover:bg-brandOrange/90 active:scale-[0.99] text-white font-bold py-3.5 px-6 rounded-xl transition-all shadow-md shadow-brandOrange/20 text-sm tracking-wide flex items-center justify-center gap-2">
						<i class="fa-solid fa-circle-plus"></i> Save Burger Entry
					</button>
				</div>
			</form:form>
		</section>

	</main>

	<footer
		class="text-center py-10 text-xs text-stone-500 border-t border-stone-200 bg-white shadow-inner">
		<p>&copy; 2026 Orchid Media &bull; Crafted with care</p>
	</footer>

</body>
</html>