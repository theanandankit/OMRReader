from django.conf import settings
from django.db import models
from django.contrib.auth.models import User
from django.db.models.signals import post_save
from django.dispatch import receiver
from rest_framework.authtoken.models import Token


@receiver(post_save, sender=settings.AUTH_USER_MODEL)
def create_auth_token(sender, instance=None, created=False, **kwargs):
    if created:
        Token.objects.create(user=instance)

class student_info(models.Model):
    user_info = models.ForeignKey(User,to_field='id',on_delete=models.CASCADE,related_name='userInfo')
    about = models.CharField(max_length=100,default="NA")
    contactNo = models.CharField(max_length=10,default=0)
    address = models.CharField(max_length=100,default="NA")
    batch = models.CharField(max_length=10,default="NA")
    rollno = models.CharField(max_length=20,default="20XXIMX-XXX")
    totalCorrect = models.IntegerField(default=0)
    totalInCorrect = models.IntegerField(default=0)

class quiz_info(models.Model):
    date = models.DateField(auto_now_add=True)
    answer = models.CharField(max_length=120,default="NA")
    answerType = models.CharField(max_length=30,default="NA")
    negative = models.BooleanField(default=True)
    description = models.CharField(max_length=500,default="NA")
    topic = models.CharField(max_length=50,default="NA")
    initiatedBy = models.CharField(max_length=50,default="NA")

class OMRResponse(models.Model):
    date = models.DateField(auto_now_add=True)
    marks = models.IntegerField(default=0)
    answer = models.CharField(max_length=120,default="NA")
    student = models.ForeignKey(student_info,to_field='id',on_delete=models.CASCADE,related_name='student')
    quiz = models.ForeignKey(quiz_info,to_field='id',on_delete=models.CASCADE,related_name='quiz')