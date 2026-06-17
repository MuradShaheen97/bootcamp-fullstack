from django.shortcuts import render, redirect, get_object_or_404
from django.http import HttpResponse, JsonResponse
from django.contrib import messages
from django.urls import reverse
from .models import *  # Explicit model imports are recommended in production paths

def signup(request):
    return render(request,'htmls/signup.html')

def check_users(request):
    firstname=request.POST['firstname']
    lastname=request.POST['lastname']  
    email=request.POST['email']
    password=request.POST['password']

    if check_user(email) :
        return redirect('app1:signup')
    else:
        creat_user(firstname,lastname,email,password)
        return redirect('app1:login')
    

def login(request):
    return render(request,'htmls/login.html')


def find_users(request):
    email=request.POST['email']
    password=request.POST['password']

    if check_user(email):
        user=check_password(email,password)
        if user:
            contex={
                'user':user
            }
            return redirect('app1:homepage')
        else:
             return redirect('app1:login')
    else : 
        return redirect('app1:login')