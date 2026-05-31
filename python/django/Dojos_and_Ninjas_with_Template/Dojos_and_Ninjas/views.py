from django.shortcuts import render, redirect, get_object_or_404
from django.http import HttpResponse, JsonResponse
from django.contrib import messages
from django.urls import reverse
from .models import *  # Explicit model imports are recommended in production paths

def index (request):
    contex={
        'dojos':gitdojos(),
        'ninjas':gitninjas()
    }
    return render(request,'Dojos_and_Ninjas/index.html',contex)

def addDojos (request):
    if request.method == 'POST':
        dojoname = request.POST.get('name')
        dojocity = request.POST.get('city')
        dojo_id = request.POST.get('dojo')
        dojo = Dojo.objects.get(id=dojo_id)
    addTo_dojo(dojoname,dojocity,dojo)
    return redirect('Dojos_and_Ninjas:index')


def addNinjas(request):
    if request.method == 'POST':
        firstname = request.POST.get('firstname')
        lastname = request.POST.get('lastname')
        dojo_id = request.POST.get('dojo')

        dojo = Dojo.objects.get(id=dojo_id)

        addTo_Ninja(firstname, lastname, dojo)

    return redirect('Dojos_and_Ninjas:index')

def deletedojo(request):
    dojoid=request.POST.get('dojoid')
    dojo=Dojo.objects.get(id=dojoid)
    dojo.delete()
    return redirect('Dojos_and_Ninjas:index')