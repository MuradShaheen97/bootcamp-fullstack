from django.shortcuts import render, redirect
from django.contrib import messages
from .models import TVShow


def all_shows(request):
    shows = TVShow.objects.all()
    return render(request, 'tv_show/all_shows.html', {'shows': shows})


def new_show(request):
    return render(request, 'tv_show/create_new_show.html')


def create_show(request):
    if request.method == 'POST':
        errors = TVShow.objects.basic_validator(request.POST)

        if errors:
            for error in errors.values():
                messages.error(request, error)
            return redirect('tv_show:new_show')

        show = TVShow.objects.create(
            title=request.POST['title'],
            network=request.POST['network'],
            release_date=request.POST['release_date'],
            description=request.POST['description']
        )

        return redirect('tv_show:show_tv_information', show_id=show.id)

    return redirect('tv_show:new_show')


def show_tv_information(request, show_id):
    show = TVShow.objects.get(id=show_id)
    return render(request, 'tv_show/show_tv_information.html', {'show': show})


def edit_show(request, show_id):
    show = TVShow.objects.get(id=show_id)
    return render(request, 'tv_show/edit_show.html', {'show': show})


def update_show(request, show_id):
    if request.method == 'POST':
        errors = TVShow.objects.basic_validator(request.POST, show_id)

        if errors:
            for error in errors.values():
                messages.error(request, error)
            return redirect('tv_show:edit_show', show_id=show_id)

        show = TVShow.objects.get(id=show_id)
        show.title = request.POST['title']
        show.network = request.POST['network']
        show.release_date = request.POST['release_date']
        show.description = request.POST['description']
        show.save()

        return redirect('tv_show:show_tv_information', show_id=show.id)

    return redirect('tv_show:edit_show', show_id=show_id)


def delete_show(request, show_id):
    if request.method == 'POST':
        TVShow.objects.get(id=show_id).delete()

    return redirect('tv_show:all_shows')