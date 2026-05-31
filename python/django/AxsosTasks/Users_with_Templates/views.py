from django.shortcuts import render, redirect
from .models import *

def index(request):
    context = {
        "users": User.objects.all()
    }
    return render(request, "user/index.html", context)

def create_user(request):

    first_name=request.POST["first_name"]
    
    last_name=request.POST["last_name"]

    email=request.POST["email"]
    
    age=request.POST["age"]

    creat_user(first_name,last_name,email,age)

    return redirect("/Users_with_Templates/")
