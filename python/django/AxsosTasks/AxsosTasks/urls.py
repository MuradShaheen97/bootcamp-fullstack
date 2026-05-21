"""
URL configuration for AxsosTasks project.

The `urlpatterns` list routes URLs to views. For more information please see:
    https://docs.djangoproject.com/en/6.0/topics/http/urls/
Examples:
Function views
    1. Add an import:  from my_app import views
    2. Add a URL to urlpatterns:  path('', views.home, name='home')
Class-based views
    1. Add an import:  from other_app.views import Home
    2. Add a URL to urlpatterns:  path('', Home.as_view(), name='home')
Including another URLconf
    1. Import the include() function: from django.urls import include, path
    2. Add a URL to urlpatterns:  path('blog/', include('blog.urls'))
"""
from django.contrib import admin
from django.urls import path, include

urlpatterns = [
    path('admin/', admin.site.urls),
    path('dojo_servey/', include('dojo_servey.urls')),
    path('firstDjangoProject/', include('firstDjangoProject.urls')),
    path('time_project/', include('time_project.urls')),
    path('multiple_apps/', include('multiple_apps.urls')),
    path('users/', include('users.urls')),
    path('surveys/', include('surveys.urls')),
    path('ninja_gold/', include('ninja_gold.urls')),
    path('counter/', include('counter.urls')),
    path('great_number_game/', include('great_number_game.urls')),
    path('users_shell/', include('users_shell.urls')),
    
]

