package business;

public enum TypeReservation {

	RESERVATION_TAXI("ReservationTaxis"), 
	RESERVATION_HOTEL("ReservationHotels"), 
	RESERVATION_AVION("ReservationAvions");

	private String type;

	TypeReservation(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public static TypeReservation of(String type) {
		for (int i = 0; i < TypeReservation.values().length; i++) {
			if(type.equals((TypeReservation.values())[i].getType())) {
				return (TypeReservation.values())[i];
			}
		}
		return null;
	}

}
