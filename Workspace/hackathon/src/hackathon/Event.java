package hackathon;

import entities.Entity;

public class Event {
	public Integer eventId;
	public Integer eventTime;
	public Entity producer;
	public Entity creation;

	public Event(Integer eventId, Integer eventTime, Entity producer, Entity creation){
		this.eventId = eventId;
		this.eventTime = eventTime;
		this.producer = producer;
		this.creation = creation;
	}
	
	public Event() {
		
	}

	public Entity getProducer() {
		return producer;
	}

	public void setProducer(Entity producer) {
		this.producer = producer;
	}

	public Entity getCreation() {
		return creation;
	}

	public void setCreation(Entity creation) {
		this.creation = creation;
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
}
