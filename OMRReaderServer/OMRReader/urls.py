"""OMRReader URL Configuration

The `urlpatterns` list routes URLs to views. For more information please see:
    https://docs.djangoproject.com/en/1.11/topics/http/urls/
Examples:
Function views
    1. Add an import:  from my_app import views
    2. Add a URL to urlpatterns:  url(r'^$', views.home, name='home')
Class-based views
    1. Add an import:  from other_app.views import Home
    2. Add a URL to urlpatterns:  url(r'^$', Home.as_view(), name='home')
Including another URLconf
    1. Import the include() function: from django.conf.urls import url, include
    2. Add a URL to urlpatterns:  url(r'^blog/', include('blog.urls'))
"""
from django.conf.urls import url
from django.contrib import admin
from OMRReaderAPI.views import *

urlpatterns = [
    url(r'^admin/', admin.site.urls),
    url(r'^api/register/$', RegisterNewUser.as_view(),name='Register'),
    url(r'^api/login/$',login.as_view(),name='Login'),
    url(r'^api/student/$',StudentInfoView.as_view(),name='Get student info'),
    url(r'^api/Adminlogin/$',AdminLogin.as_view(),name='Admin Login'),
    url(r'^api/quizInfo/(?P<quizId>\d+)/$',quizInfoView.as_view(),name='Quiz Info'),
    url(r'^api/omrresponse/(?P<OMRId>\d+)/$',OMRResponseView.as_view(),name='OMR Response'),
    url(r'^api/allQuizInfo/$',quizAllView.as_view(),name='All Quiz Info'),
    url(r'^api/adminHomeInfo/$',AdminHomeScreenInfo.as_view(),name='Admin Home Info'),
    url(r'^api/createQuiz/$',CreateQuizView.as_view(),name='Quiz Info'),
    url(r'^api/listOfStudent/(?P<quizId>\d+)/$',ListOfStudentInQuizView.as_view(),name='List of student in quiz'),
     url(r'^api/listOfQuiz/(?P<id>\d+)/$',allQuizOfStudent.as_view(),name='List of quiz'),
]
