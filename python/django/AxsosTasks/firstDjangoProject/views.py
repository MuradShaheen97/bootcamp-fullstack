from django.shortcuts import HttpResponse,render,redirect
from django.http import JsonResponse

def index(request):
    return HttpResponse("placeholder to later display list ")



def new(request):
    return HttpResponse("placeholder to later display a new form to create a new blog ")

def create(request):
    return redirect("/firstDjangoProject/blogs")

def show(requste,num):
    return HttpResponse(f"placeholder to later display list {num} ")
def edit (request,num):
    return HttpResponse(f"placeholder to edit blogs {num}")

def destroy(request, num):
    return redirect("/firstDjangoProject/blogs")

def jso1 (request):
    return JsonResponse({"title":"my first blog ","content":"lorem, ipsum dolor sit amet elit"})