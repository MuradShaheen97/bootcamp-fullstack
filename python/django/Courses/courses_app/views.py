from django.shortcuts import render, redirect
from django.contrib import messages
from .models import Course


# Home page: show form and all courses
def index(request):
    courses = Course.objects.all()
    return render(request, 'courses_app/index.html', {'courses': courses})


# Create new course
def create_course(request):
    if request.method == 'POST':

        # Validate form before saving
        errors = Course.objects.basic_validator(request.POST)

        # If errors exist, show them and return home
        if errors:
            for error in errors.values():
                messages.error(request, error)
            return redirect('courses_app:index')

        # If no errors, save course
        Course.objects.create(
            name=request.POST['name'],
            description=request.POST['description']
        )

    return redirect('courses_app:index')


# Show delete confirmation page
def delete_page(request, course_id):
    course = Course.objects.get(id=course_id)
    return render(request, 'courses_app/delete.html', {'course': course})


# Delete course after pressing Yes
def destroy_course(request, course_id):
    if request.method == 'POST':
        Course.objects.get(id=course_id).delete()

    return redirect('courses_app:index')