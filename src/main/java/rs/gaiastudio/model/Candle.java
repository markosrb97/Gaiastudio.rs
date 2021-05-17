package rs.gaiastudio.model;


import javax.persistence.*;


@Entity
@Table(name = "candles")
public class Candle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "price")
	private int price;
	
	@Lob
	@Column(name = "description"/*, columnDefinition = "CLOB"*/)
	private String description;
	
	@Lob
	@Column(name="image1")
	private byte[] imageFile1;
	
	@Lob
	@Column(name="image2")
	private byte[] imageFile2;
	
	
	
	
	public Candle(String type, int price, String description, byte[] imageFile1, byte[] imageFile2) {
		super();
		this.type = type;
		this.price = price;
		this.description = description;
		this.imageFile1 = imageFile1;
		this.imageFile2 = imageFile2;
	}

	public Candle(String type, int price, String description) {
		this.type = type;
		this.price = price;
		this.description = description;
	}
	
	public Candle(String type, int price) {
		this.type = type;
		this.price = price;
	}
	
	public Candle() {
		
	}
	
	public int getPrice() {
		return price;
	}
	
	public String getType() {
		return type;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public byte[] getImageFile1() {
		return imageFile1;
	}

	public void setImageFile1(byte[] imageFile1) {
		this.imageFile1 = imageFile1;
	}
	
	public byte[] getImageFile2() {
		return imageFile2;
	}

	public void setImageFile2(byte[] imageFile2) {
		this.imageFile2 = imageFile2;
	}

	public long getId() {
		return this.id;
	}
	
	@Override
	public String toString() {
		return "TIP SVECE:" + type + "\n";
	}
}