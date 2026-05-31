from django.urls import path
from . import views

# REQUIRED configuration token mapping for isolating multi-app namespace environments
app_name = 'Dojos_and_Ninjas'  

urlpatterns = [
    path('', views.index, name='index'),
    path('add_dojos/', views.addDojos, name='dojos'),
    path('add_ninjas/', views.addNinjas, name='ninjas'),
    path ('delete/', views.deletedojo,name='delete'),

]