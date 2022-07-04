Instructions:
- Run OCTracker in your IDE to start the Spring server on http://localhost:8080/OCTracker
- In the project directory, you can run: `npm start` to start the app
- Open http://localhost:3000 to view the app in your browser.



////////

issues:

- same stop and route number but different directions (e.g. 40 st laurent and 40 greenboro at south keys station)
	-works sometimes, doesn't work sometimes?
- change trips when different route button clicked
	-fixed but need to clean code
- change how arrival times are calculated?
- speed up list filter



ideas for additions:

- add refresh button to routes
- all routes button
- search stops by name
- use GTFS data somehow? find scheduled times? (so when gps is on you know when bus should be there)
- select multiple routes at stop
- save favourite stops (use cookies? idk)
- improve UI
- show map with bus location on it