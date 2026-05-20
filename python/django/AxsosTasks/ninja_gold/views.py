from django.shortcuts import render, redirect
import random
from datetime import datetime

def index(request):
    if 'gold' not in request.session:
        request.session['gold'] = 0

    if 'activities' not in request.session:
        request.session['activities'] = []

    return render(request, 'index.html')


def process_money(request):
    if request.method == 'POST':
        building = request.POST['building']

        if building == 'farm':
            gold = random.randint(10, 20)
        elif building == 'cave':
            gold = random.randint(10, 20)
        elif building == 'house':
            gold = random.randint(10, 20)
        elif building == 'quest':
            gold = random.randint(-50, 50)

        request.session['gold'] += gold

        time = datetime.now().strftime("%B %d %Y %I:%M %p")

        if gold >= 0:
            message = f"You entered a {building} and earned {gold} gold. ({time})"
            color = "green"
        else:
            message = f"You failed a quest and lost {abs(gold)} gold. Ouch. ({time})"
            color = "red"

        activities = request.session['activities']
        activities.append({
            'message': message,
            'color': color
        })

        request.session['activities'] = activities

    return redirect('/ninja_gold/')


def reset(request):
    request.session.clear()
    return redirect('/ninja_gold/')