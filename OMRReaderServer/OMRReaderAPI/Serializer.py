from rest_framework import serializers
from django.contrib.auth.models import User
from OMRReaderAPI.models import *


class RegisterUser(serializers.ModelSerializer):
    class Meta:
        model = User
        fields = ('username', 'password', 'email', 'first_name', 'last_name')
        write_only_fields = ('password',)

    def create(self, validated_data):
        user = User.objects.create(
            username=validated_data['username'],
            email=validated_data['email'],
            first_name=validated_data['first_name'],
            last_name=validated_data['last_name'],
        )

        user.set_password(validated_data['password'])
        user.save()
        return user

class LoginSerializer(serializers.ModelSerializer):
    class Meta :
        model = User
        password = serializers.CharField(required=True)
        email = serializers.CharField(required=True)
        fields = ['email','password']

class userInfoWithoutPasswordSerializer(serializers.ModelSerializer):
    
    class Meta:
        model = User
        fields = ('username','email','first_name','last_name')

class studentInfoSerializer(serializers.ModelSerializer):

    user_info = userInfoWithoutPasswordSerializer()

    class Meta:
        model = student_info
        fields = ('user_info','about','contactNo','address','batch','rollno','totalCorrect','totalInCorrect')

class quizInfoSerializer(serializers.ModelSerializer):

    class Meta:
        model = quiz_info
        fields = '__all__'

class OMRResponseSerializer(serializers.ModelSerializer):

    student = studentInfoSerializer()
    quiz = quizInfoSerializer()

    class Meta:
        model = OMRResponse
        fields = '__all__'