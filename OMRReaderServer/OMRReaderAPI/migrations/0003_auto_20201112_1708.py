# Generated by Django 3.1 on 2020-11-12 17:08

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('OMRReaderAPI', '0002_auto_20201112_1707'),
    ]

    operations = [
        migrations.AlterField(
            model_name='student_info',
            name='contactNo',
            field=models.IntegerField(default=0),
        ),
    ]
