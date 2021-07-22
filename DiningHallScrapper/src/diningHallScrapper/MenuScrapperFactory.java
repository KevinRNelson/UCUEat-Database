package diningHallScrapper;

public final class MenuScrapperFactory {
	
	static MenuScrapper createMenuScrapper(String menuScrapper) {
		switch (menuScrapper) {
			case "UcscDiningHall":
				return new UcscDiningHallMenuScrapper();
				
			default:
				return null;
		}
	}
}
