package transport;

import java.util.Calendar;

import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import business.ReservationAvion;


@XmlRootElement(name="entry")
@XmlAccessorType(XmlAccessType.NONE)
public class AtomReservationAvion extends AtomConstruct{
	
	@XmlElement(name="content")
	private ReservationAvion content;
	
	public  AtomReservationAvion() {}
	public AtomReservationAvion(String baseURL,ReservationAvion r ,boolean fullEntry){
		String resAvionId = r.getId();
		String selfURL = baseURL + "ReservationAvions/"+ resAvionId;
		setId(selfURL);
		setTitle("ReservationAvion "+ resAvionId);
		setUpdated(Calendar.getInstance().getTime().toString());
		
		if(fullEntry) {
			this.content = r;
			addLink(new AtomLink("edit",selfURL,"Atom+Xml"));
			addLink(new AtomLink("delete",selfURL+"/delete","Atom+Xml"));
		}
		else addLink(new AtomLink("alternate",selfURL,MediaType.APPLICATION_ATOM_XML));
	}
	
	public ReservationAvion getContents(){
		return content;
	}	

}
