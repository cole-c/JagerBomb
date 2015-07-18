package hackathon;

public class Event {
	public Integer eventId;
	public Integer eventTime;
	public String producerType;
	public Integer producerId;
	public Integer producerVersion;
	public String outputType;
	public Integer outputId;
	public Integer outputVersion;
	public String outputData;
	
	public Event(Integer eventId, Integer eventTime, String producerType, Integer producerId, Integer producerVersion, String outputType, Integer outputId, Integer outputVersion, String outputData){
		this.eventId = eventId;
		this.eventTime = eventTime;
		this.producerType = producerType;
		this.producerId = producerId;
		this.producerVersion = producerVersion;
		this.outputType = outputType;
		this.outputId = outputId;
		this.outputVersion = outputVersion;
		this.outputData = outputData;
	}

	public Integer getEventId() {
		return eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

	public Integer getEventTime() {
		return eventTime;
	}

	public void setEventTime(Integer eventTime) {
		this.eventTime = eventTime;
	}

	public String getProducerType() {
		return producerType;
	}

	public void setProducerType(String producerType) {
		this.producerType = producerType;
	}

	public Integer getProducerId() {
		return producerId;
	}

	public void setProducerId(Integer producerId) {
		this.producerId = producerId;
	}

	public Integer getProducerVersion() {
		return producerVersion;
	}

	public void setProducerVersion(Integer producerVersion) {
		this.producerVersion = producerVersion;
	}

	public String getOutputType() {
		return outputType;
	}

	public void setOutputType(String outputType) {
		this.outputType = outputType;
	}

	public Integer getOutputId() {
		return outputId;
	}

	public void setOutputId(Integer outputId) {
		this.outputId = outputId;
	}

	public Integer getOutputVersion() {
		return outputVersion;
	}

	public void setOutputVersion(Integer outputVersion) {
		this.outputVersion = outputVersion;
	}

	public String getOutputData() {
		return outputData;
	}

	public void setOutputData(String outputData) {
		this.outputData = outputData;
	}
	
}
