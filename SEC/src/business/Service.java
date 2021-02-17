package business;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType( XmlAccessType.FIELD)
public class Service {
	private TypeReservation type;
	private String url;
	
	public Service() {}

	public Service(TypeReservation type, String url) {
		this.type = type;
		this.url = url;
	}
	public TypeReservation getType() {return type;}
	public String getUrl() {return url;}
	public String toString(){
		return type+"-"+url;
	}
}
