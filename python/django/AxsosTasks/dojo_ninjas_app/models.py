from django.db import models


# Dojo model represents the main table: dojos
class Dojo(models.Model):
    # Name of the dojo
    name = models.CharField(max_length=255)

    # City where the dojo is located
    city = models.CharField(max_length=255)

    # State is only 2 characters, like PS, CA, NY
    state = models.CharField(max_length=2)

    # Description field added later in the assignment
    # default="old dojo" means old rows will get this value automatically
    desc = models.TextField(default="old dojo")

    def __str__(self):
        return self.name


# Ninja model represents the ninjas table
class Ninja(models.Model):
    # Ninja first name
    first_name = models.CharField(max_length=255)

    # Ninja last name
    last_name = models.CharField(max_length=255)

    # ForeignKey means each ninja belongs to one dojo
    # related_name="ninjas" lets us write: dojo.ninjas.all()
    # on_delete=models.CASCADE means if dojo is deleted, its ninjas are deleted too
    dojo = models.ForeignKey(Dojo, related_name="ninjas", on_delete=models.CASCADE)

    def __str__(self):
        return f"{self.first_name} {self.last_name}"