package hackathon;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

import org.json.JSONException;
import org.json.JSONObject;

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
			if(!s.hasNextInt())
				break;
			Integer eventId = s.nextInt();
			Integer eventTime = s.nextInt();
			String producerType = s.next();
			Integer producerId = s.nextInt();
			Integer producerVersion = s.nextInt();
			String outputType = s.next();
			Integer outputId = s.nextInt();
			Integer outputVersion = s.nextInt();
			s.useDelimiter("\n");
			String outputData = s.next();
			outputData = outputData.substring(2, outputData.lastIndexOf("}"));
			//System.out.println(outputData);
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
			//System.out.println(outputData);
			
			try {
				JSONObject json = new JSONObject(outputData);
				//System.out.print(json.getString("type")+" ");
				//System.out.print(json.getInt("id")+" ");
				//System.out.println(json.getInt("version")+" ");
				String type = json.getString("type");
			} catch (JSONException e) {
				//shouldn't ever happen with properly formatted data
				e.printStackTrace();
			}
			
			//processJSON(outputData); //temporarily void until outputData is defined
			Event event = new Event(eventId, eventTime, producerType, producerId, producerVersion, outputType, outputId, outputVersion, outputData);
			eventHash.put(eventId, event);
		}
		count = count - 1;
	
		s.close();
		return eventHash;
	}


	private static void processJSON(String outputData) {
		String[] tokensJSON;
		
		/*
		 * Customer customer = Customer(Integer id, Integer version, String name, Integer payments)
		 * Location origin = Location(Integer id, Integer version, String city, String state)
		 * Location destination = Location(Integer id, Integer version, String city, String state)
		 * Route route = Route(Integer id, Integer version, Location origin, Location destination, ArrayList<Location> locations)
		 * Bill bill = Bill(Integer id, Integer version, Customer customer, Route route, Integer charge)
		 * Train train = Train(Integer id, Integer version, Bill bill, Integer step, boolean active, Location current)
		 */
		
	}
}
