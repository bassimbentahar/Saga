package business;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Travel {
	private String id;
	private ReservationTaxi reservationTaxi;
	private ReservationAvion reservationAvion;
	private ReservationHotel reservationHotel;
	

	public Travel(String id, ReservationTaxi reservationTaxi, ReservationAvion reservationAvion,
			ReservationHotel reservationHotel) {
		super();
		this.id = id;
		this.reservationTaxi = reservationTaxi;
		this.reservationAvion = reservationAvion;
		this.reservationHotel = reservationHotel;
	}
	public  Travel() {}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ReservationTaxi getReservationTaxi() {
		return reservationTaxi;
	}

	public void setReservationTaxi(ReservationTaxi reservationTaxi) {
		this.reservationTaxi = reservationTaxi;
	}

	public ReservationAvion getReservationAvion() {
		return reservationAvion;
	}

	public void setReservationAvion(ReservationAvion reservationAvion) {
		this.reservationAvion = reservationAvion;
	}

	public ReservationHotel getReservationHotel() {
		return reservationHotel;
	}

	public void setReservationHotel(ReservationHotel reservationHotel) {
		this.reservationHotel = reservationHotel;
	}
	
	
}
