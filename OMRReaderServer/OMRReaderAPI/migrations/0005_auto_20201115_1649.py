# Generated by Django 3.1 on 2020-11-15 16:49

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('OMRReaderAPI', '0004_omrresponse'),
    ]

    operations = [
        migrations.AddField(
            model_name='quiz_info',
            name='initiatedBy',
            field=models.CharField(default='NA', max_length=50),
        ),
        migrations.AddField(
            model_name='quiz_info',
            name='topic',
            field=models.CharField(default='NA', max_length=50),
        ),
    ]
