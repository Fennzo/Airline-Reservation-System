
public class flightDetails {

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	String local, destination, time, date;
	
	public flightDetails( String local, String destination, String time, String date) {
		this.local = local;
		this.destination = destination;
		this.time = time;
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "Local: " + local  +
				"\ndestination: " + destination +
				"\nTime: " + time +
				"\nDate: " + date ;
	}
}
