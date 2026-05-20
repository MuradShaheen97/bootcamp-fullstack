from django.shortcuts import render, redirect

def index(request):

    if 'count' not in request.session:
        request.session['count'] = 0

    request.session['count'] += 1

    return render(request, 'counter/index.html')


def destroy(request):
    request.session.clear()
    return redirect('/counter/')