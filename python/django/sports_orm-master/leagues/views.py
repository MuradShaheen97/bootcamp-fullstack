from django.shortcuts import render
from django.db.models import Count
from .models import League, Team, Player


def index(request):
    context = {
        # Sports ORM II
        "q1": Team.objects.filter(league__name="Atlantic Soccer Conference"),
        "q2": Player.objects.filter(curr_team__location="Boston", curr_team__team_name="Penguins"),
        "q3": Player.objects.filter(curr_team__league__name="International Collegiate Baseball Conference"),
        "q4": Player.objects.filter(
            curr_team__league__name="American Conference of Amateur Football",
            last_name="Lopez"
        ),
        "q5": Player.objects.filter(curr_team__league__sport="Football"),
        "q6": Team.objects.filter(curr_players__first_name="Sophia"),
        "q7": League.objects.filter(teams__curr_players__first_name="Sophia"),
        "q8": Player.objects.filter(last_name="Flores").exclude(
            curr_team__location="Washington",
            curr_team__team_name="Roughriders"
        ),
        "q9": Team.objects.filter(
            all_players__first_name="Samuel",
            all_players__last_name="Evans"
        ),
        "q10": Player.objects.filter(
            all_teams__location="Manitoba",
            all_teams__team_name="Tiger-Cats"
        ),
        "q11": Player.objects.filter(
            all_teams__location="Wichita",
            all_teams__team_name="Vikings"
        ).exclude(
            curr_team__location="Wichita",
            curr_team__team_name="Vikings"
        ),
        "q12": Team.objects.filter(
            all_players__first_name="Jacob",
            all_players__last_name="Gray"
        ).exclude(
            location="Oregon",
            team_name="Colts"
        ),
        "q13": Player.objects.filter(
            first_name="Joshua",
            all_teams__league__name="Atlantic Federation of Amateur Baseball Players"
        ),
        "q14": Team.objects.annotate(num_players=Count("all_players")).filter(num_players__gte=12),
        "q15": Player.objects.annotate(num_teams=Count("all_teams")).order_by("-num_teams"),
    }

    return render(request, "leagues/index.html", context)