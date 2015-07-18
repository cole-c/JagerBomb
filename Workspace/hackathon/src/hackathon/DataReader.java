package hackathon;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class DataReader {

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
		while(s.hasNextLine()){
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
			Event event = new Event(eventId, eventTime, producerType, producerId, producerVersion, outputType, outputId, outputVersion, outputData);
			eventHash.put(eventId, event);
		}
	
		s.close();
		return eventHash;
	}
}
