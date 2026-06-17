from django.urls import path
from . import views

# REQUIRED configuration token mapping for isolating multi-app namespace environments
app_name = 'app1'  

urlpatterns = [
    path('signup/', views.signup, name='signup'),
    path('check_users/', views.check_users, name='check_users'),
    path('login/', views.login, name='login'),
    path('find_users/', views.find_users, name='find_users'),
    

]