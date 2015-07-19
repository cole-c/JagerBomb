package hackathon;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import entities.Bill;
import entities.Customer;
import entities.Location;
import entities.Producer;
import entities.Route;
import entities.Train;

public class DataReader {

	static Integer count = 0;
	static HashMap<Integer, Event> eventHash = new HashMap<Integer, Event>();
	
	public static HashMap<Integer, Event> readEvents(){
		Scanner s = null;
		try{
			s = new Scanner(new File("data/smallData.csv"));
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
		
		while(s.hasNextLine()){
			s.nextLine();
			count++;
			s.useDelimiter(",");
			Event event = new Event();
			if(!s.hasNextInt())
				break;
			Integer eventId = s.nextInt();
			Integer eventTime = s.nextInt();
			String producerType = s.next();
			Integer producerId = s.nextInt();
			Integer producerVersion = s.nextInt();
			//these need to stay to parse through them but are repeated in the JSON
			String outputType = s.next();
			Integer outputId = s.nextInt();
			Integer outputVersion = s.nextInt();
			
			event.setEventId(eventId);
			event.setEventTime(eventTime);
			event.setProducer(new Producer(producerType, producerId, producerVersion));
			//Parse the most poorly formatted abomination of a string to ever exist
			s.useDelimiter("\n");
			String outputData = s.next();
			outputData = outputData.substring(2, outputData.lastIndexOf("}"));
			outputData = outputData.replace("\"\"\"", "\"");
			outputData = outputData.replace("\"\"", "\"");
			outputData = outputData.replace("\"bill", "bill");
			outputData = outputData.replace("\"customer", "customer");
			outputData = outputData.replace("\"route", "route");
			outputData = outputData.replace("\"name", "name");
			outputData = outputData.replace("\"city", "city");
			outputData = outputData.replace("\"origin", "origin");
			outputData = outputData.replace("\"state", "state");
			outputData = outputData.replace("\"destination", "destination");
			outputData = outputData.replace("\"location", "location");
			outputData = outputData.replace("\"current", "current");
			outputData = outputData.replace("}\"", "}");
			outputData = outputData.replace(",\"", ",");
			outputData = outputData + "}";
			System.out.println(outputData);
			
			try {
				JSONObject json = new JSONObject(outputData);
				String type = json.getString("type");
				Integer id = json.getInt("id");
				Integer version = json.getInt("version");

				if(type.equals("TRAIN")) {
					//make a metric fuckton of JSON objects
					JSONObject billSON = json.getJSONObject("bill");
					JSONObject custSON = billSON.getJSONObject("customer");
					JSONObject routeSON = billSON.getJSONObject("route");
					JSONObject origSON = routeSON.getJSONObject("origin");
					JSONObject destSON = routeSON.getJSONObject("destination");
					JSONArray locSON = routeSON.getJSONArray("locations");
					JSONObject hereSON = json.getJSONObject("currentLocation");
					
					//location where the train currently is
					Location here = new Location(hereSON.getInt("id"), hereSON.getInt("version"), hereSON.getString("city"), hereSON.getString("state"));
					
					//make locations which will go inside route
					Location origin = new Location(origSON.getInt("id"), origSON.getInt("version"), origSON.getString("city"), origSON.getString("state"));
					Location destination = new Location(destSON.getInt("id"), destSON.getInt("version"), destSON.getString("city"), destSON.getString("state"));
					ArrayList<Location> course = new ArrayList<Location>();
					for(int i=0;i<locSON.length();i++)
					{
						JSONObject waypoint = locSON.getJSONObject(i);
						course.add(new Location(waypoint.getInt("id"), waypoint.getInt("version"), waypoint.getString("city"), waypoint.getString("state")));
					}
					
					//make the route
					Route route = new Route(routeSON.getInt("id"), routeSON.getInt("version"), origin, destination, course);
					
					//make the customer
					Customer customer = new Customer(custSON.getInt("id"), custSON.getInt("version"), custSON.getString("name"), custSON.getInt("payments"));
					
					//I'm just a Bill
					Bill bill = new Bill(billSON.getInt("id"), billSON.getInt("version"), customer, route, billSON.getInt("charge"));
					
					//I like trains! https://www.youtube.com/watch?v=hHkKJfcBXcw
					Train train = new Train(json.getInt("id"), json.getInt("version"), bill, json.getInt("step"), json.getBoolean("isActive"), here);
					train.setId(id);
					train.setVersion(version);
					event.setCreation(train);
				}
				else if(type.equals("CUSTOMER"))
				{
					Customer customer = new Customer(json.getInt("id"), json.getInt("version"), json.getString("name"), json.getInt("payments"));
					customer.setId(id);
					customer.setVersion(version);
					event.setCreation(customer);
				}
				else if(type.equals("BILL"))
				{
					JSONObject custSON = json.getJSONObject("customer");
					JSONObject routeSON = json.getJSONObject("route");
					JSONObject origSON = routeSON.getJSONObject("origin");
					JSONObject destSON = routeSON.getJSONObject("destination");
					JSONArray locSON = routeSON.getJSONArray("locations");
					
					//make locations which will go inside route
					Location origin = new Location(origSON.getInt("id"), origSON.getInt("version"), origSON.getString("city"), origSON.getString("state"));
					Location destination = new Location(destSON.getInt("id"), destSON.getInt("version"), destSON.getString("city"), destSON.getString("state"));
					ArrayList<Location> course = new ArrayList<Location>();
					for(int i=0;i<locSON.length();i++)
					{
						JSONObject waypoint = locSON.getJSONObject(i);
						course.add(new Location(waypoint.getInt("id"), waypoint.getInt("version"), waypoint.getString("city"), waypoint.getString("state")));
					}
					
					//make the route
					Route route = new Route(routeSON.getInt("id"), routeSON.getInt("version"), origin, destination, course);
					
					//make the customer
					Customer customer = new Customer(custSON.getInt("id"), custSON.getInt("version"), custSON.getString("name"), custSON.getInt("payments"));
					
					Bill bill = new Bill(json.getInt("id"), json.getInt("version"), customer, route, json.getInt("charge"));
					bill.setId(id);
					bill.setVersion(version);
					event.setCreation(bill);
				}
				else if(type.equals("ROUTE"))
				{
					JSONObject origSON = json.getJSONObject("origin");
					JSONObject destSON = json.getJSONObject("destination");
					JSONArray locSON = json.getJSONArray("locations");
					
					//make locations which will go inside route
					Location origin = new Location(origSON.getInt("id"), origSON.getInt("version"), origSON.getString("city"), origSON.getString("state"));
					Location destination = new Location(destSON.getInt("id"), destSON.getInt("version"), destSON.getString("city"), destSON.getString("state"));
					ArrayList<Location> course = new ArrayList<Location>();
					for(int i=0;i<locSON.length();i++)
					{
						JSONObject waypoint = locSON.getJSONObject(i);
						course.add(new Location(waypoint.getInt("id"), waypoint.getInt("version"), waypoint.getString("city"), waypoint.getString("state")));
					}
					
					//make the route
					Route route = new Route(json.getInt("id"), json.getInt("version"), origin, destination, course);
					route.setId(id);
					route.setVersion(version);
					event.setCreation(route);
				}
				else if(type.equals("LOCATION")) {
					Location location = new Location(json.getInt("id"), json.getInt("version"), json.getString("city"), json.getString("state"));
					location.setId(id);
					location.setVersion(version);
					event.setCreation(location);
				}
				else {
					System.out.println("You have brought dishonor to this family...");
				}
				
			} catch (JSONException e) {
				//shouldn't ever happen with properly formatted data
				e.printStackTrace();
			}
			
			eventHash.put(eventId, event);
		}
		count = count - 1;
	
		s.close();
		return eventHash;
	}

}
