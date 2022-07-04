Instructions:
- Run OCTracker in your IDE to start the Spring server on http://localhost:8080/OCTracker
- In the project directory, you can run: `npm start` to start the app
- Open http://localhost:3000 to view the app in your browser.

When app is running, just type in the search bar and it will filter stops automatically
Then, select the stop you want, then the route, then it will show the bus times

Initial screen:
![](https://user-images.githubusercontent.com/25333593/177207095-5ae05792-023d-4627-8060-e1ebcf50bc6c.png)

Search filter:
![](https://user-images.githubusercontent.com/25333593/177207101-4631f3f9-640a-429a-ad45-16f6c49af14a.png)

Selected stop:
![](https://user-images.githubusercontent.com/25333593/177207112-64a4e4ee-9761-4522-9553-8283bf71089c.png)

Selected route, showing bus times:
![](https://user-images.githubusercontent.com/25333593/177207117-170c990a-9061-461a-b1a5-3fab415c19be.png)


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