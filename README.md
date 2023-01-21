# Saudi-Arabian-Cities-Navigation
This application aims to demonstrate the behaviour of 5 search algorithms applied on a set of 153 cities in Saudi Arabia. Implemented search algorithms are:
* Breadth First Search (BFS)
* Uniform Cost Search (UCS)
* Iterative Deepening Search (IDS)
* Greedy Search (GS)
* A*

Also, the application shows an actual map painting on it the path of the search so far, in an iteration-by-iteration fashion and providing the option to speedup/slowdown the execution.
## Data
The necessary raw data for the program to run was collected from:
1. **General Authority for Survey and Geospatial Information**: It was used to find neighboring cities in Saudi Arabia. Neighboring cities are a pair of cities having a direct path that doesn’t pass through the borders of any other city.
2. [**Distance calculator**](https://www.distancecalculator.net/): It was used to find the distance between every pair of neighboring cities. 
3. **Google maps**: It was used to find the coordinates of each city to display on the map (GUI) also to calculate the heuristic for both GS and A*.

Stored in ```CitiesDistances.json```.
## Libraries
* **Gson** for reading the JSON file, any other JSON reader library can be used.
* **JXMapViewer** for displaying the map and mapping coordinates to screen pixels.
## Example
The following run shows the search for trip from "القريات" to "بقيق" on the lowest exection speed option:
![Example](https://user-images.githubusercontent.com/122672831/213884960-a1d0b4c3-70e0-40e0-9158-6f92a5659d48.gif)
