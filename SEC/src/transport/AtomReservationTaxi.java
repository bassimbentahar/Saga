package transport;

import java.util.Calendar;

import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import business.ReservationTaxi;


@XmlRootElement(name="entry")
@XmlAccessorType(XmlAccessType.NONE)
public class AtomReservationTaxi extends AtomConstruct{
	
	@XmlElement(name="content")
	private ReservationTaxi content;
	
	public  AtomReservationTaxi() {}
	public AtomReservationTaxi(String baseURL,ReservationTaxi r ,boolean fullEntry){
		String resTaxi = r.getId();
		String selfURL = baseURL + "AtomReservationTaxis/"+ resTaxi;
		setId(selfURL);
		setTitle("ReservationTaxi "+ resTaxi);
		setUpdated(Calendar.getInstance().getTime().toString());
		
		if(fullEntry) {
			this.content = r;
			addLink(new AtomLink("edit",selfURL,"Atom+Xml"));
			addLink(new AtomLink("delete",selfURL+"/delete","Atom+Xml"));
		}
		else addLink(new AtomLink("alternate",selfURL,MediaType.APPLICATION_ATOM_XML));
	}
	
	public ReservationTaxi getContents(){
		return content;
	}	

}
