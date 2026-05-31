from django.db import models

class Dojo(models.Model):
    name = models.CharField(max_length=100)
    city = models.CharField(max_length=255)
    state = models.CharField(max_length=255)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)

    def __str__(self):
        return self.name
    
def addTo_dojo( name , city , state):
    Dojo.objects.create(
            name=name,
            city=city,
            state=state,
        )
    
class Ninja(models.Model):
    firstname = models.CharField(max_length=100)
    lastname = models.CharField(max_length=255)
    dojo = models.ForeignKey(Dojo, on_delete=models.CASCADE, related_name='ninjas')
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)

    def __str__(self):
        return self.firstname
    
def addTo_Ninja( firstname , lastname , dojo):
        Ninja.objects.create(
            firstname=firstname,
            lastname=lastname,
            dojo=dojo,
        )
    
def gitdojos():
    return Dojo.objects.all()

def gitninjas():
    return Ninja.objects.all()