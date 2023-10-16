package org.java.api.DTO;

import java.math.BigDecimal;


public class PizzaDTO {

		private String name;
		private String description;
		private String fotoUrl;
		private BigDecimal price;

		public PizzaDTO() {}
		
		public PizzaDTO(String name, String description, String fotoUrl, int price) {

			setName(name);
			setDescription(description);
			setFotoUrl(fotoUrl);
			setPrice(BigDecimal.valueOf(price));

		}


		
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}

		
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}


		public String getFotoUrl() {

			return fotoUrl;
		}
		public void setFotoUrl(String fotoUrl) {
			
			this.fotoUrl = fotoUrl;
		}


		public BigDecimal getPrice() {
			return price;
		}
		public void setPrice(BigDecimal price) {
			this.price = price;
		}
		
		
	
}
