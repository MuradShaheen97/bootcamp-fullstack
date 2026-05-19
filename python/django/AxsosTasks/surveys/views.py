from django.shortcuts import render, HttpResponse, redirect
from django.http import JsonResponse 

# Create your views here.

def index(request):
    return HttpResponse("placeholder to display all the surveys created.")

def new(request):
    return HttpResponse("placeholder to users to add new surveys")