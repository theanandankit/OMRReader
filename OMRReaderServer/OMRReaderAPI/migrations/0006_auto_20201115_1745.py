# Generated by Django 3.1 on 2020-11-15 17:45

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('OMRReaderAPI', '0005_auto_20201115_1649'),
    ]

    operations = [
        migrations.AddField(
            model_name='student_info',
            name='totalCorrect',
            field=models.IntegerField(default=0),
        ),
        migrations.AddField(
            model_name='student_info',
            name='totalInCorrect',
            field=models.IntegerField(default=0),
        ),
    ]
