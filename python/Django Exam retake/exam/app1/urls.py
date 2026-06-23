from django.urls import path
from . import views

app_name = 'app1'

urlpatterns = [
    path('', views.index, name='index'),

    path('register', views.register, name='register'),
    path('login', views.login, name='login'),
    path('logout', views.logout, name='logout'),

    path('dashboard', views.dashboard, name='dashboard'),

    path('create_project_page', views.create_project_page, name='create_project_page'),
    path('project/create', views.create_project, name='create_project'),

    path('project/<int:project_id>', views.project_details, name='project_details'),

    path('project/<int:project_id>/edit', views.edit_project_page, name='edit_project_page'),
    path('project/<int:project_id>/update', views.update_project, name='update_project'),

    path('project/<int:project_id>/delete', views.delete_project, name='delete_project'),

    path('project/<int:project_id>/join', views.join_project, name='join_project'),
    path('project/<int:project_id>/leave', views.leave_project, name='leave_project'),
]