from django.urls import path
from . import views

app_name = 'tv_show'

# This is the home page
urlpatterns = [
    path('', views.get_all_shows_view, name='home'),

    # This URL is for showing all shows
    path('shows/', views.get_all_shows_view, name='all_shows'),

    # This URL is for creating a new show
    path('shows/new/', views.create_new_show, name='new_show'),

    # This URL is for creating a new show (alternate URL)
    path('shows/create/', views.create_new_show, name='create_show'),

    # This URL is for showing the details of a specific show
    path('shows/<int:show_id>/', views.show_tv_show, name='show_tv_information'),

    # This URL is for editing a specific show
    path('shows/<int:show_id>/edit/', views.edit_show, name='edit_show'),

    # This URL is for updating the details of a specific show
    path('shows/<int:show_id>/update/', views.update_show_view, name='update_show'),

    # This URL is for deleting a specific show
    path('shows/<int:show_id>/destroy/', views.delete_show_view, name='delete_show'),
]