from django.db import models
import re
from datetime import date

# Create your models here.

class UserMajager(models.Manager):
    def register_validator(self, post_data):
        errors ={}

        if len (post_data["first_name"]) <2:
            errors["first_name"] = "first name must be at least 2 characters"

        if len (post_data["last_name"]) <2:  
            errors["last_name"] = "last name must be at least 2 characters"
        
        Email_REGEX = re.compile(r"^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$")
        if not Email_REGEX.match(post_data["email"]):
            errors["email"] = "invalid email address"

        if User.objects.filter(email=post_data["email"]).exists():
            errors["email_unique"] = "Email already exsists"

        if len (post_data["password"])<8:
            errors["password"] = "password must be at least 8 characters"

        if post_data["password"] != post_data["confirm_password"]:
            errors["confirm_password"] = "password not match "
        
        return errors
    def login_validator (self, post_data):
        errors = {}

        if not post_data["email"]:
            errors ["email"] = "Email is required"
        if not post_data["password"]:
            errors ["password"] = "password is required"

        return errors
    
class ProjectManager(models.Manager):
    def project_validator(self,post_data):
        errors = {}

        if len(post_data["name"])<3:
            errors ["name"] = "Project name must be at least 3 characters"

        if len(post_data["description"])<1:
            errors ["description"] = "description can not be blank"

        if not post_data["start_date"]:
            errors["start_date"] = "start date is required"

        if not post_data["end_date"]:
            errors["end_date"] = "End date is required"

        if post_data["start_date "] and post_data["end_date"]:
            if post_data["end_date"]<= post_data["end_date"]:
                errors["date"] = "End date must be after start date"

        return errors
    

class User (models.Model):
    first_name = models.CharField(max_length=255)
    last_name = models.CharField(max_length=255)
    email = models.EmailField(unique=True)
    password = models.CharField(max_length=255)

    objects = UserMajager()

    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)

class project(models.Model):
    name = models.CharField(max_length=255)
    description = models.TextField()
    start_date = models.DateField()
    end_date =models.DateField()

    owner = models.ForeignKey(
        User,
        related_name="owned_projects",
        on_delete=models.CASCADE
    )

    members = models.ManyToManyField(
        User,
        related_name="joined_projects",
        blank=True
    )
    objects = ProjectManager()
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)



