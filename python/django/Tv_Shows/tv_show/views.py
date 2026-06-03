from django.shortcuts import render, redirect
from .models import *


# LIST ALL
def get_all_shows_view(request):
    shows = get_all_shows()
    return render(request, 'tv_show/all_shows.html', {'shows': shows})


# CREATE
def create_new_show(request):
    if request.method == 'POST':
        create_show(
            request.POST.get('title'),
            request.POST.get('network'),
            request.POST.get('release_date'),
            request.POST.get('description')
        )
        return redirect('tv_show:all_shows')

    return render(request, 'tv_show/create_new_show.html')


# SHOW ONE
def show_tv_show(request, show_id):
    show = get_show_by_id(show_id)
    return render(request, 'tv_show/show_tv_information.html', {'show': show})


# EDIT
def edit_show(request, show_id):
    show = get_show_by_id(show_id)
    return render(request, 'tv_show/edit_show.html', {'show': show})


# UPDATE
def update_show_view(request, show_id):
    if request.method == 'POST':
        update_show(
            show_id,
            request.POST.get('title'),
            request.POST.get('network'),
            request.POST.get('release_date'),
            request.POST.get('description')
        )
        return redirect('tv_show:show_tv_information', show_id=show_id)

    return redirect('tv_show:edit_show', show_id=show_id)


# DELETE
def delete_show_view(request, show_id):
    if request.method == 'POST':
        delete_show(show_id)

    return redirect('tv_show:all_shows')