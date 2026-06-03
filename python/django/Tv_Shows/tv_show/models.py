from django.db import models


class TVShow(models.Model):
    title = models.CharField(max_length=255)
    network = models.CharField(max_length=255)
    release_date = models.DateField()
    description = models.TextField()
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)

    def __str__(self):
        return self.title


# =========================
# CREATE
# =========================
def create_show(title, network, release_date, description):
    return TVShow.objects.create(
        title=title,
        network=network,
        release_date=release_date,
        description=description
    )


# =========================
# READ ONE
# =========================
def get_show_by_id(show_id):
    return TVShow.objects.get(id=show_id)


# =========================
# READ ALL
# =========================
def get_all_shows():
    return TVShow.objects.all()


# =========================
# UPDATE
# =========================
def update_show(show_id, title, network, release_date, description):
    show = get_show_by_id(show_id)
    show.title = title
    show.network = network
    show.release_date = release_date
    show.description = description
    show.save()
    return show


# =========================
# DELETE
# =========================
def delete_show(show_id):
    show = get_show_by_id(show_id)
    show.delete()