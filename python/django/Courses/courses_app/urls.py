from django.urls import path
from . import views

app_name = 'courses_app'

urlpatterns = [
    # Home page: form + table
    path('', views.index, name='index'),

    # Add course route
    path('courses/create/', views.create_course, name='create_course'),

    # Delete confirmation page
    path('courses/<int:course_id>/delete/', views.delete_page, name='delete_page'),

    # Final delete action
    path('courses/<int:course_id>/destroy/', views.destroy_course, name='destroy_course'),
]