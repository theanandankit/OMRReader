from django.shortcuts import render
from rest_framework.views import APIView
from django.contrib.auth.models import User
from rest_framework.authtoken.models import Token
from rest_framework.response import Response
from OMRReaderAPI.Serializer import *
from rest_framework import generics
from rest_framework import status
from django.db.models import Max
from rest_framework import generics


# common APIs

class RegisterNewUser(APIView):
    def post(self, request):
        serializers = RegisterNewUser(data=request.data)
        val = {}

        self.object = User.objects.filter(email=request.data.get('email')).first()
        if self.object is None:
            if serializers.is_valid():
                users = serializers.save()
                val['Response'] = "Successfully registered a new user"
                val['Token'] = Token.objects.get(user=users).key
            else:
                val = serializers.errors
            return Response(val)
        else:
            return Response({'error': "Email already in use."})

class login(APIView):
    # permission_classes = (AllowAny,)
    def post(self, request):
        serializers = LoginSerializer(data=request.data)
        if (serializers.is_valid()):
            print(serializers.data.get('email'), serializers.data.get("password"))
            email = serializers.data.get("email")
            password = serializers.data.get("password")
            self.object = User.objects.filter(email=email).first()
            if self.object == None:
                return Response({'error': 'User with this email and password not found'})
            else:
                if self.object.check_password(password):
                   # authenticate(self.object)
                    # self.object.last_login = datetime.datetime.now()
                    # self.object.save(update_fields=['last_login'])
                    val = {}
                    val['Token'] = Token.objects.get(user=self.object).key
                    val['Id'] = self.object.id
                    # if User_info.objects.filter(user_id=self.object.id).exists():
                    #     val['status'] = "found"
                    return Response(val, status=status.HTTP_202_ACCEPTED)
                    # else:
                    #     val['status'] = "Not"
                    #     return Response(val, status=status.HTTP_202_ACCEPTED)
                else:
                    return Response({'error': 'Incorrect password'}, status=status.HTTP_404_NOT_FOUND)
        else:
            return Response(serializers.errors, status=status.HTTP_400_BAD_REQUEST)

# Student APIs

# Individual student info
class StudentInfoView(generics.ListAPIView):
    serializer_class = studentInfoSerializer

    def get_queryset(self):
        queryset = student_info.objects.all()
        studentID = self.request.query_params.get('id')
        print(studentID)
        return queryset.filter(id=studentID)

#Admin login api
class AdminLogin(APIView):

    def post(self,request):
        result = {}
        username = request.data.get('username')
        password = request.data.get('password')
    
        if username=='admin' and password=='password':   #static username and password credentials
            result['status'] = 'Success'
        else:
            result['status']='username or password incorrect'
        return Response(result,status= status.HTTP_202_ACCEPTED)

# Quiz APIs
class quizInfoView(APIView):

    def get(self,request,quizId):
        val = {}
        try:
            model = quiz_info.objects.get(id=quizId)
            omrres = OMRResponse.objects.order_by('-marks').all()
            omrresmax = omrres.filter(quiz=model)
            count = omrresmax.count()
            omrresmax = omrresmax[0]
            maxStudent = OMRResponseSerializer(omrresmax)
            serializer = quizInfoSerializer(model)
            val['maxStudent'] = maxStudent.data.get('student')
            val['quizinfo'] = serializer.data
            val['totalStudent'] = count
        except:
            return Response({"Response":"ID not found"},status=status.HTTP_204_NO_CONTENT)
        if serializer.is_valid:
            return Response(val)
        else:
            return Response(serializer.error_messages)

class ListOfStudentInQuizView(generics.ListAPIView):
    
    def get(self,request,quizId):
        try:
            model = quiz_info.objects.get(id=quizId)
            omrres = OMRResponse.objects.order_by('-marks').all()
            omrresmax = omrres.filter(quiz=model)
            maxStudent = OMRResponseSerializer(omrresmax,many=True)
        except:
            return Response({"Response":"ID not found"},status=status.HTTP_204_NO_CONTENT)
        if maxStudent.is_valid:
            return Response(maxStudent.data)
        else:
            return Response(maxStudent.error_messages)


class CreateQuizView(APIView):

    def post(self,request):
        serializers = quizInfoSerializer(data=request.data)
        val = {}

        if serializers.is_valid():
            val['status'] = "Success"
            serializers.save()
            return Response(val,status=status.HTTP_202_ACCEPTED)
        else:
            val['status'] = "Something went wrong"
            return Response(val,status=status.HTTP_404_NOT_FOUND)

class quizAllView(APIView):

    def get(self,request):
        model = quiz_info.objects.all()
        serializer = quizInfoSerializer(model,many=True)
        return Response(serializer.data)

class allQuizOfStudent(APIView):

    def get(self,request,id):

        student = student_info.objects.get(id=id)
        omrres = OMRResponse.objects.filter(student=student)
        serializer = OMRResponseSerializer(omrres,many=True)
        return Response(serializer.data)


#OMRResponse Apis
class OMRResponseView(APIView):
    
    def post(self,request):
        serializers = OMRResponseSerializer(data=request.data)
        val = {}

        if serializers.is_valid():
            val['status'] = "Success"
            serializers.save()
            return Response(val,status=status.HTTP_202_ACCEPTED)
        else:
            val['status'] = "Something went wrong"
            return Response(val,status=status.HTTP_404_NOT_FOUND)

    def get(self,request,OMRId):
        try:
            model = OMRResponse.objects.get(id=OMRId)
        except:
             return Response({"Response":"ID not found"},status=status.HTTP_204_NO_CONTENT)
        serializer = OMRResponseSerializer(model)
        if serializer.is_valid:
            return Response(serializer.data)
        else:
            return Response(serializer.error_messages)


class AdminHomeScreenInfo(APIView):

    def get(self,request):
        studentmodel = student_info.objects.all()
        quizmodel = quiz_info.objects.all()
        lastQuiz = quiz_info.objects.last()
        maxGainer = student_info.objects.order_by('-totalCorrect')[0]
        serializer = quizInfoSerializer(lastQuiz)
        result = {}
        result['totalStudent'] = studentmodel.count()
        result['totalQuiz'] = quizmodel.count()
        result['lastQuiz'] = serializer.data
        serializer = studentInfoSerializer(maxGainer)
        result['gainer'] = serializer.data
        return Response(result)




