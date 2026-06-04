from django.db import models


# Manager class for validation
class CourseManager(models.Manager):

    # This function checks form data before saving
    def basic_validator(self, postData):
        errors = {}

        # Get values from form
        name = postData.get('name', '').strip()
        description = postData.get('description', '').strip()

        # Name must be more than 5 characters
        if len(name) <= 5:
            errors['name'] = "Course name must be more than 5 characters."

        # Description must be more than 15 characters
        if len(description) <= 15:
            errors['description'] = "Description must be more than 15 characters."

        return errors


# Course table in database
class Course(models.Model):
    name = models.CharField(max_length=255)
    description = models.TextField()
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)

    # Connect manager
    objects = CourseManager()

    def __str__(self):
        return self.name