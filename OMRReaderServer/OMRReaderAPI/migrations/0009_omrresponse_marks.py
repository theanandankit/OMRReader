# Generated by Django 3.1 on 2020-11-18 11:27

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('OMRReaderAPI', '0008_auto_20201116_1022'),
    ]

    operations = [
        migrations.AddField(
            model_name='omrresponse',
            name='marks',
            field=models.IntegerField(default=0),
        ),
    ]
