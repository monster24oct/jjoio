package com.cg.lpg.bean;

import java.time.LocalDate;

public class LPGStockBean {
	
		private int avQty;
		private LocalDate receivedDate;
		private String updatedBy;
		private String location;
		public LPGStockBean() {
			super();
			// TODO Auto-generated constructor stub
		}
		public LPGStockBean(int avQty, LocalDate receivedDate,
				String updatedBy, String location) {
			super();
			this.avQty = avQty;
			this.receivedDate = receivedDate;
			this.updatedBy = updatedBy;
			this.location = location;
		}
		public int getAvQty() {
			return avQty;
		}
		public void setAvQty(int avQty) {
			this.avQty = avQty;
		}
		public LocalDate getReceivedDate() {
			return receivedDate;
		}
		public void setReceivedDate(LocalDate receivedDate) {
			this.receivedDate = receivedDate;
		}
		public String getUpdatedBy() {
			return updatedBy;
		}
		public void setUpdatedBy(String updatedBy) {
			this.updatedBy = updatedBy;
		}
		public String getLocation() {
			return location;
		}
		public void setLocation(String location) {
			this.location = location;
		}
		@Override
		public String toString() {
			return "LPGStockBean [avQty=" + avQty + ", receivedDate="
					+ receivedDate + ", updatedBy=" + updatedBy + ", location="
					+ location + "]";
		}
		
		
}
