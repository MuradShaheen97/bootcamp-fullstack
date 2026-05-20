from django.shortcuts import HttpResponse

def index(request):
    return HttpResponse("Hello from Dojo Survey")





from django.shortcuts import render, redirect

def index(request):
    return render(request, "dojo/index.html")

def result(request):
    if request.method == "POST":
        context = {
            "name": request.POST["name"],
            "location": request.POST["location"],
            "language": request.POST["language"],
            "comment": request.POST["comment"],
        }
        return render(request, "result.html", context)

    return redirect("/")