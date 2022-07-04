// import logo from './logo.svg';
import React from "react";
import './App.css';
import axios from "axios";

class StopForm extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            stopNo: '',
            searchText: '',
            stop: null,
            submitted: false,
            stopList: null,
            isLoading: false
        };

        this.handleChange = this.handleChange.bind(this);
        // this.handleStopButtonClick = this.handleStopButtonClick.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    componentDidMount() {
        this.setState({isLoading: true})
        axios.get("http://localhost:8080/OCTracker/Gtfs/").then(res => {
            console.log(res);
            this.setState({stopList: res.data.gtfsStop});
        }).catch((error)=> {
            this.setState({stopList: null});
            console.log(error);
        });
        this.setState({isLoading: false})
    }

    handleChange(event) {
        this.setState({stopNo: event.target.value, searchText: event.target.value, submitted:false, stop: this.state.stop});
    }

    handleSubmit(stopNoButton) {
        this.setState({stopNo: stopNoButton, submitted:false, stop: this.state.stop});
        axios.get("http://localhost:8080/OCTracker/GetRouteSummaryForStopResult/".concat(stopNoButton)).then(res => {
          console.log(res);
          this.setState({stop: res.data, submitted: true});
        }).catch((error)=> {
          this.setState({stop: null, submitted: false});
          console.log(error);
        });
    }

    render() {
        const submitted = this.state.submitted;
        let routeDiv = null;
        if(submitted === true){
          routeDiv = <RouteDiv stop={this.state.stop}/>
        }
        else{
          routeDiv = null;
        }

        if(this.state.isLoading){
            return(<div><h1>loading</h1></div>);
        }
        else {

            const list = this.state.stopList === null ? null : this.state.stopList.filter(stopFromList => this.state.searchText === '' ||
                (stopFromList.stop_code !== null && stopFromList.stop_code.includes(this.state.searchText)) ||
                (stopFromList.stop_name !== null && stopFromList.stop_name.toLowerCase().includes(this.state.searchText.toString().toLowerCase()))).map((stopFromList, index) =>
                <button key={index} value={stopFromList.stop_code} /*onClick={()=>this.handleSubmit()}*/
                        onClick={()=>this.handleSubmit(stopFromList.stop_code)}>{stopFromList.stop_code} - {stopFromList.stop_name}</button>);

            return (
                <div>
                    <div>
                        {/*<form onSubmit={this.handleSubmit}>*/}
                        <form onSubmit={e => { e.preventDefault(); }}>
                            <label>
                                Search for stop:
                                <input type="text" value={this.state.searchText} onChange={this.handleChange}/>
                            </label>
                            <ul>{list}</ul>
                        </form>
                    </div>
                    <div>{routeDiv}</div>
                </div>
            );
        }
    }
}

class RouteDiv extends React.Component{
    constructor(props) {
        super(props);
        this.state = {
            stop: props.stop,
            stopNo: props.stop.stopNo,
            stopDescription: props.stop.stopDescription,
            stopSelectedBool: false,
            tripsDiv: null,
            tripsForStop: null,
            route: null,
        };
        this.handleButton = this.handleButton.bind(this);
        this.componentDidUpdate = this.componentDidUpdate.bind(this);
    }

    componentDidUpdate() {
            if (!this.state.stopSelectedBool) {
                this.setState({tripsDiv: null});
                this.setState({
                    stopSelectedBool: true,
                    tripsDiv: <TripsForRouteDiv stopNo={this.state.stopNo} routeNo={this.state.route.routeNo} stop={this.state.tripsForStop} stopSelectedBool={false}/>
                });
            }
    }

    handleButton(route) {
        // event.preventDefault();
        if(this.state.route === null || this.state.route.routeNo !== route.routeNo || (this.state.route.routeNo === route.routeNo && this.state.route.routeHeading !== route.routeHeading)) {
            axios.get("http://localhost:8080/OCTracker/GetNextTripsForStopResult/".concat(this.state.stopNo).concat("/")
                .concat(route.routeNo)).then(res => {
                console.log(res);
                this.setState({route: route, tripsForStop: res.data, stopSelectedBool: true});
                this.setState({tripsDiv: null});
                this.setState({tripsDiv: <TripsForRouteDiv stopNo={this.state.stopNo} routeNo={this.state.route.routeNo}
                                                           routeDirection={this.state.route.routeHeading} stop={res.data} stopSelectedBool={false}/>});
            }).catch((error) => {
                this.setState({tripsForStop: null, tripsDiv: null});
                console.log(error);
            });
        }
        else{
            this.setState({stopSelectedBool: true});
        }
    }

     render() {
         if (this.state.stopDescription != null) {
             return (<div><div><h2>{this.state.stopNo}</h2>
                     <h2>{this.state.stopDescription}</h2>
                     {this.state.stop.routes.route.map(route => (
                         <RouteButton key={route.routeNo + route.routeHeading}
                             route = {route}
                             onButtonClick = {this.handleButton}>
                         </RouteButton>
                         //TODO: all routes button!!!! (using the other api request)
                     ))}
                 </div>
                 <div>{this.state.tripsDiv}</div>
             </div>
             );
         } else {
             return (<div><h1>Invalid stop number</h1></div>);
         }
     }
}

class RouteButton extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            route: props.route,
            routeNo: props.route.routeNo,
            routeHeading: props.route.routeHeading,
            //onButtonClick: null
        };
    }

    handleButton = () => {
        this.props.onButtonClick(this.state.route);
    }

    render() {
        return (
            <button onClick={this.handleButton}>
                {this.state.routeNo} {this.state.routeHeading}
            </button>
        );
    }
}

class TripsForRouteDiv extends React.Component{

    constructor(props) {
        super(props);
        this.state = {
            stop: props.stop,
            stopNo: props.stopNo,
            routeNo: props.routeNo,
            routeDirection: props.routeDirection,
            stopSelectedBool: false
        };

        this.componentDidUpdate = this.componentDidUpdate.bind(this);
    }

    componentDidUpdate(){
        if(!this.state.stopSelectedBool && !this.props.stopSelectedBool) {
            this.setState({
                stop: this.props.stop,
                stopNo: this.props.stopNo,
                routeNo: this.props.routeNo,
                routeDirection: this.props.routeDirection,
                stopSelectedBool: true
            });
        }
    }

    render() {
        return (
            <div><h2>Route {this.state.routeNo} {this.state.routeDirection}</h2>
                {/*<h2>{this.state.stop.stopLabel}</h2>*/}
                {this.state.stop.route.routeDirection.map(routeDirection => (
                    routeDirection.trips.trip.map( trip =>
                        //makes sure same route in both directions at a station doesn't show up e.g. 98 hawthrone and 98 hurdman at south keys station
                        routeDirection.routeLabel===this.state.routeDirection ?
                            <TripButton key={trip.tripStartTime} routeNo={this.state.routeNo} trip={trip} /> : null
                    )))}
            </div>
        );
    }
}

class TripButton extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            routeNo: props.routeNo,
            trip: props.trip,
            //onButtonClick: null
        };
    }

    //TODO: doesn't do anything yet, not sure what to do with these buttons
    handleButton = () => {
        this.props.onButtonClick(this.props.route);
    }

    render() {
        let currentTime = new Date();
        let arrivalTime = new Date(currentTime.getTime() + this.state.trip.adjustedScheduleTime*60000);

        return (
            <button onClick={this.handleButton} key={this.state.trip.tripStartTime}>
                {this.state.routeNo} {this.state.trip.tripDestination} in {this.state.trip.adjustedScheduleTime} minutes @
                {arrivalTime.toLocaleTimeString([], {hour: '2-digit', minute:'2-digit'})}
                {" | "}
                GPS: {this.state.trip.adjustmentAge === "-1"? "no": "yes" /*adjustmentAge is -1 -> no gps*/}
            </button>
        );
    }
}

function App() {
  return (
    <div className="App">
        <h1 style={{ color: 'red' }}>OCTracker</h1>
      <StopForm />
    </div>
  );
}

export default App;
