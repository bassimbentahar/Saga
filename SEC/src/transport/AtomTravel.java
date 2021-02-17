package transport;

import java.util.Calendar;

import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import business.Travel;


@XmlRootElement(name="entry")
@XmlAccessorType(XmlAccessType.NONE)
public class AtomTravel extends AtomConstruct{
	
	@XmlElement(name="content")
	private Travel content;
	
	public  AtomTravel() {}
	public AtomTravel(String baseURL,Travel t ,boolean fullEntry){
		String TravelId = new Integer(t.getId()).toString();
		String selfURL = baseURL + "Travels/"+ TravelId;
		setId(selfURL);
		setTitle("Travel "+ TravelId);
		setUpdated(Calendar.getInstance().getTime().toString());
		
		if(fullEntry) {
			this.content = t;
			addLink(new AtomLink("edit",selfURL,"Atom+Xml"));
			addLink(new AtomLink("delete",selfURL+"/delete","Atom+Xml"));
		}
		else addLink(new AtomLink("alternate",selfURL,MediaType.APPLICATION_ATOM_XML));
	}
	
	public Travel getContents(){
		return content;
	}	

}
