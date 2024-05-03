This Application is based on Android;  to get total number of  Residents living
in the Finland Municipalities.  And also fetch the Weather information of the Municipality.

This App is developed using the Android studio; with Android and Java

MainActivity class contains the Input text area; where the user input the Finland Municipality
name and search button.

MainActivity class contains MunicipalityDataRetriever;  which will fetch the Municipality
data;  number of residents; Municipality name and other information; using the API call
and processing the response of the API;

It uses the public API  https://pxdata.stat.fi:443/PxWeb/api/v1/en/StatFin/synt/statfin_synt_pxt_12dy.px
to fetch the Municipality name and residents living in the Municipality.

MainActivity class contains WeatherDataRetriever;  which will fetch the Weather
information of the Municipality and will also display the picture/image; to show Weather like;
Sunny, Cloudy, Rain, Snow etc; based on the Weather in that Municipality;  using the API call
and processing the response of the API;

It uses the public API https://api.openweathermap.org/data/2.5/weather?lat=%s&lon=%s&appid=%s;
to fetch Weather information

MainActivity class contains QuizActivity;  which will ask the user various questions about Finland.
user can answer the questions using True/False radio buttons; At the end of the Quiz; the app
will also display the score at the end of the quiz;