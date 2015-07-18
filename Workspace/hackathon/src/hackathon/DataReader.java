package hackathon;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

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
		String events = "";
	
		String[] tokensEvents;
		s.nextLine();
		while(s.hasNextLine()){
			count++;
			events = s.nextLine();
			tokensEvents = events.split(",");
			Integer eventId = Integer.parseInt(tokensEvents[0]);
			Integer eventTime = Integer.parseInt(tokensEvents[1]);
			String producerType = tokensEvents[2];
			Integer producerId = Integer.parseInt(tokensEvents[3]);
			Integer producerVersion = Integer.parseInt(tokensEvents[4]);
			String outputType = tokensEvents[5];
			Integer outputId = Integer.parseInt(tokensEvents[6]);
			Integer outputVersion = Integer.parseInt(tokensEvents[7]);
			String outputData = tokensEvents[8];
			processJSON(outputData); //temporarily void until outputData is defined
			Event event = new Event(eventId, eventTime, producerType, producerId, producerVersion, outputType, outputId, outputVersion, outputData);
			eventHash.put(eventId, event);
		}
		count = count - 1;
	
		s.close();
		return eventHash;
	}

	private static void processJSON(String outputData) {
		String[] tokensJSON;
		tokensJSON = outputData.split(",");
		if(tokensJSON[0].contains("TRAIN")){
			tokensJSON[1].replace("id:", "");
			tokensJSON[2].replace("version:", "");
			tokensJSON[4].replace("id:", "");
			tokensJSON[5].replace("version:", "");
			tokensJSON[7].replace("id:", "");
			tokensJSON[8].replace("version:", "");
			tokensJSON[9].replace("name:", "");
			tokensJSON[9].replaceAll("\"", "");
			tokensJSON[10].replace("charges:", "");
			tokensJSON[10].replace("}", "");
			Customer customer = Customer(Integer.parseInt(tokensJSON[7]), Integer.parseInt(tokensJSON[8]), tokensJSON[9], Integer.parseInt(tokensJSON[10]));
			Bill bill = Bill(Integer.parseInt(tokensJSON[4]), Integer.parseInt(tokensJSON[5]), customer, route, Integer.parseInt(tokensJSON[10]));
			Train train = Train(Integer.parseInt(tokensJSON[1]), Integer.parseInt(tokensJSON[2]), bill, Integer.parseInt(tokensJSON[]), tokensJSON[], currentLoc);
		}
	}
}
