package in.shiv.binding;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@XmlRootElement
public class Order {
	
	private Integer orderId;
	private Double price;
	private Integer bookId;

}
