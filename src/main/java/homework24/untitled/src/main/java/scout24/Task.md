REST API Best TV Shows in Genre

Use Http GET Method to retrieve information about resent tv shows.
Query
https://jsonmock.hackerrank.com/api/tvseries to find all the shows in a genre.
The Query resukt is paginated. To access additional pages, appent 
'?page={num}' to the URL where num is the page number

The response is a Json object with the 5 fields:
page: the current page of the results (Number)
per_page: the maximum number of results returned per page (Number)
total: the total number of results(Number)
total_pages: the total number of pages with results (Number)
data: an array of tv series records

Example of a data array object:

"name": "Game of Thrones",
"runtime_of_series":"(2011-2019",
"certificate": "A",
"runtime_of_episodes": "57 min",
"gerne": "Action, Adventure, Drama",
"imdb_rating": 9.3,
"overview": "Nine noble families fight for control over the lands of Westeros,
while an ancident enemy returns after being dormant fpr millennia.",
"no_of_votes": 1773458,
"id": 1


in data, each tv series has the following schema:

name: (String)
runtime_of_series: years with a new season (String)
certificate: rating (String)
runtime_of_episodes: average length per episode in minutes (String),
genre: genre (String)
imdb_rating: average views rating (Number)
overview: short description (String)
no_of_votes: how many votes were cast at imdb (Number)
id: unique id (Number)



Give a genre, find the series with the highest imdb_rating. If there is tie, return 
the alphabetically lower name

### Functionally Description 

Complete the function  bestInGenre in the editor below:
bestInGenre has the following parameter(s):
sting genre: the genre in search

### Return:
sting: the highest-rated show in the genre, with the lowest 
name alphabetically if there is a tie

Example:
Sample Input For Custom Testing
Action
Sample Output
Game of Thrones
Explanation
The 4 highest-rated shows in the 'Action' genre are shown.
'Game of Thrones', 9.3
'Avatar: The Last Airbender', 9.2
'Hagane no renkinjutsushi, 9.1
'Shingeki no kyojin', 8.9


public static String bestInGenre(String genre) {
// Write your code here
String baseUrl = "https://jsonmock.hackerrank.com/api/tvseries";
int currentPage = 1;
double highestRating = Double.MIN_VALUE;
String lowestName = "';
return "null";