from django.db import models

class User(models.Model):
    first_name = models.CharField(max_length=45)
    last_name = models.CharField(max_length=45)
    email = models.EmailField()
    age = models.IntegerField()
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)


def creat_user(first_name,last_name,email,age):
    User.objects.create(
        first_name=first_name,
        last_name=last_name,
        email=email,
        age=age
    )