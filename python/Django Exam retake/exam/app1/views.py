# from django.shortcuts import render, redirect, get_object_or_404
# from django.http import HttpResponse, JsonResponse
# from django.contrib import messages
# from django.urls import reverse
# from .models import *  # Explicit model imports are recommended in production paths

from django.shortcuts import render, redirect
from django.contrib import messages
import bcrypt

from .models import User, project


def index(request):
    return render(request, "app1/index.html")

def register(request):
    if request.method == "POST":
        errors = User.objects.register_validator(request.POST)

        if errors :
            for value in errors.values():
                messages.error(request, value)
                return redirect("/")
            
        hashed_pw = bcrypt.hashpw(
                request.POST["password"].encode(),
                bcrypt.gensalt()

        ).decode()

        user = User.objects.create(
                first_name=request.POST["first_name"],
                last_name=request.POST["last_name"],
                email=request.POST["email"],
                password=hashed_pw
        )

        request.session["user_id"] = user.id
        request.session["user_name"] = user.first_name
        return redirect("/dashboard")
    return redirect("/")

def login(request):
    if request.method == "POST":
        errors = User.objects.login_validator(request.POST)

        if errors :
            for value in errors.values():
                messages.error(request, value)
            return redirect("/")
        
        users =  User.objects.filter(email=request.POST["email"])

        if users:
            user = users[0]

            if bcrypt.checkpw(
            request.POST["password"].encode(),
            user.password.encode()

            ):
                request.session["user_id"] = user.id
                request.session["user_name"]= user.first_name
                return redirect("/dashboard")
        
        messages.error(request, "invaled email or password")
        return redirect("/")
    return redirect("/")


def logout(request):
    request.session.flush()
    return redirect("/")

def dashboard(request):
    if "user_id" not in request.session:
        return redirect("/")
    context = {
        "user": User.objects.get(id=request.session["user_id"]),
        "projects": project.objects.all()
    }

    return render(request, "app1/dashboard.html", context)

def create_project_page(request):
    if "user_id" not in request.session:
        return redirect("/")
    return render(request, "app1/create_project.html")

def create_project(request):
    if "user_id" not in request.session:
        return redirect("/")
    
    if request.method == "POST":
        errors = project.objects.project_validator(request.POST)

        if errors:
            for value in errors.values():
                messages.error(request, value)
            return redirect("/createproject")
        
        owner = User.objects.get(id=request.session["user_id"])

        project = project.objects.create(
            name=request.POST["name"],
            description=request.POST["description"],
            start_date=request.POST["start_date"],
            end_date=request.POST["end_date"],
            owner=owner
        )
        project.members.add(owner)
        return redirect("dashboard")
    return redirect("dashboard")

def project_details(request, project_id):
    if "user_id" not in request.session:
        return redirect("/")
    context = {
        "user": User.objects.get(id=request.session["user_id"]),
        "project" : project.objects.get(id=project_id)
    }

    return render(request, "app1/project_details.html", context)

def edit_project_page(request, project_id):
    if "user_id" not in request.session:
        return redirect("/")
    
    project = project.objects.get (id=project_id)
    
    if project .owner.id != request.session["user_id"]:
        return redirect("/dashboard")
    
    context = {
        "project":project
    }

    return render(request, "app1/edit_project.html", context)


def update_project(request,  project_id):
    if "user_id" not in request.session:
        return redirect("/")
    
    this_project = project.objects.get(id=project_id)

    if project.owner.id != request.session["user_id"]:
        return redirect("/dashboard")
    
    errors = project.objects.project_validator(request.POST)

    if errors:
        for value in errors.values():
            messages.error(request, value)
            return redirect(f"/project/{project_id}/edit")
        
    this_project.name = request.POST["name"]
    project.description = request.POST["description"]
    project.start_date = request.POST["start_date"]
    project.end_date = request.POST["end_date"]
    project.save()

    return redirect(f"/project/{project_id}")

def delete_project(request, project_id):
    if "user_id" not in request.session:
        return redirect("/")
    
    project = project.objects.get(id=project_id)

    if project.owner.id == request.session["user_id"]:
        project.delete()
    return redirect("/dashboard")

def join_project (request, project_id):
    if "user_id" not in  request.session:
        return redirect("/")
    
    user = User.objects.get(id=request.session["user_id"])
    project = project.objects.get(id=project_id)
    project.members.add(user)
    return redirect("/dashboard")

def leave_project(request, project_id):
    if "user_id" not in request.session:
        return redirect("/")
    
    user = User.objects.get(id=request.session["user_id"])
    project = project.objects.get(id=project_id)
    if project.owner.id != user.id:
        project.members.remove(user)
    return redirect("/dashboard")
    
    








