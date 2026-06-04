from django.urls import path
from . import views

app_name = 'tv_show'

urlpatterns = [
    path('', views.all_shows, name='home'),

    path('shows/', views.all_shows, name='all_shows'),

    path('shows/new/', views.new_show, name='new_show'),

    path('shows/create/', views.create_show, name='create_show'),

    path('shows/<int:show_id>/', views.show_tv_information, name='show_tv_information'),

    path('shows/<int:show_id>/edit/', views.edit_show, name='edit_show'),

    path('shows/<int:show_id>/update/', views.update_show, name='update_show'),

    path('shows/<int:show_id>/destroy/', views.delete_show, name='delete_show'),
    
]