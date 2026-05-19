1- Activate your environment:

Windows (Git Bash):
source djangoPy3Env/Scripts/activate

---

2- Creating a Django Project
django-admin startproject your_project_name_here

---

3- creating app
For every app we want to add to our project, we will do the following:
python manage.py startapp your_app_name_here

---

cd your_project_name_here
python manage.py runserver

---

add app rout in your_project_name_here/settings.py
INSTALLED_APPS = [
'your_app_name_here', # added this line, do not forget the comma
'django.contrib.admin',
'django.contrib.auth',
'django.contrib.contenttypes',
'django.contrib.sessions',
'django.contrib.messages',
'django.contrib.staticfiles',
]

---

/your_project_name_here/urls.py
from django.urls import path, include

urlpatterns = [
path('', include('your_app_name_here.urls')),
]

---

Next, create a new urls.py file inside the your_app_name_herefolder, and add the following code:

your_project_name_here/your_app_name_here/urls.py

from django.urls import path
from . import views

urlpatterns = [
path('', views.index),
]

---

views.py

from django.shortcuts import render, HttpResponse, redirect
from django.http import JsonResponse

def index(request):
return HttpResponse("this is the equivalent of @app.route('/')!")

---
