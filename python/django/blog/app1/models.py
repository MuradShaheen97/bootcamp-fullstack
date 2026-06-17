
from django.db import models

class User(models.Model):
    firstname = models.CharField(max_length=100)
    lastname= models.CharField(max_length=100)
    email=models.CharField(max_length=100)
    password=models.CharField(max_length=100)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)

    def __str__(self):
        return self.firstname
    
def creat_user(firstname ,lastname,email,password):
    User.objects.create(firstname=firstname,lastname=lastname,email=email,password=password)
def check_user(user_email):
    user=User.objects.filter(email=user_email)
    if user: 
        return True
    else : 
        return False
    
def check_password(email,password):
    user=User.objects.get(email=email)
    if user.password == password:
        return user
    else :
        return False
