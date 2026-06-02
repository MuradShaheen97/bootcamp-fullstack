from django.shortcuts import render
from .models import League, Team, Player

def index(request):
    context = {
        "baseball_leagues": League.objects.filter(sport="Baseball"),
        "women_leagues": League.objects.filter(name__contains="Women"),
        "hockey_leagues": League.objects.filter(sport__contains="Hockey"),
        "not_football_leagues": League.objects.exclude(sport="Football"),
        "conference_leagues": League.objects.filter(name__contains="Conference"),
        "atlantic_leagues": League.objects.filter(name__contains="Atlantic"),
        "dallas_teams": Team.objects.filter(location="Dallas"),
        "raptors_teams": Team.objects.filter(team_name="Raptors"),
        "city_teams": Team.objects.filter(location__contains="City"),
        "t_teams": Team.objects.filter(team_name__startswith="T"),
        "teams_by_location": Team.objects.order_by("location"),
        "teams_by_name_reverse": Team.objects.order_by("-team_name"),
        "cooper_players": Player.objects.filter(last_name="Cooper"),
        "joshua_players": Player.objects.filter(first_name="Joshua"),
        "cooper_not_joshua": Player.objects.filter(last_name="Cooper").exclude(first_name="Joshua"),
        "alexander_or_wyatt": Player.objects.filter(first_name="Alexander") | Player.objects.filter(first_name="Wyatt"),
    }

    return render(request, "leagues/index.html", context)