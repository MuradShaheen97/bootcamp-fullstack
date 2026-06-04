from django.db import models
from django.utils import timezone


class TVShowManager(models.Manager):
    def basic_validator(self, postData, show_id=None):
        errors = {}

        title = postData.get('title', '').strip()
        network = postData.get('network', '').strip()
        release_date = postData.get('release_date', '')
        description = postData.get('description', '').strip()

        if len(title) < 2:
            errors['title'] = "Title must be at least 2 characters."

        if len(network) < 3:
            errors['network'] = "Network must be at least 3 characters."

        if not release_date:
            errors['release_date'] = "Release date is required."
        elif release_date >= str(timezone.now().date()):
            errors['release_date_past'] = "Release date must be in the past."

        if description and len(description) < 10:
            errors['description'] = "Description must be at least 10 characters."

        existing_show = TVShow.objects.filter(title__iexact=title)

        if show_id:
            existing_show = existing_show.exclude(id=show_id)

        if title and existing_show.exists():
            errors['unique_title'] = "A TV show with this title already exists."

        return errors


class TVShow(models.Model):
    title = models.CharField(max_length=255)
    network = models.CharField(max_length=255)
    release_date = models.DateField()
    description = models.TextField(blank=True)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)

    objects = TVShowManager()

    def __str__(self):
        return self.title