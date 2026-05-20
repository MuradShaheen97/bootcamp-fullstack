from django.shortcuts import render, redirect
import random

def index(request):

    if 'number' not in request.session:
        request.session['number'] = random.randint(1, 100)

    return render(request, 'num/index.html')


def guess(request):

    user_guess = int(request.POST['guess'])
    correct_number = request.session['number']

    if user_guess > correct_number:
        request.session['result'] = "Too High!"
        request.session['color'] = "red"

    elif user_guess < correct_number:
        request.session['result'] = "Too Low!"
        request.session['color'] = "red"

    else:
        request.session['result'] = f"{correct_number} was the number!"
        request.session['color'] = "green"

    return redirect('/great_number_game/')


def reset(request):
    request.session.clear()
    return redirect('/great_number_game/')