package fr.iutvalence.info.dut.m3105.gildedroseinn.refactoring;

import java.util.ArrayList;
import java.util.List;

public class GildedRose
{

	private static List<Item> items = null;

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{

		System.out.println("OMGHAI!");

		items = new ArrayList<Item>();
		items.add(new Item("+5 Dexterity Vest", 10, 20));
		items.add(new Item("Aged Brie", 2, 0));
		items.add(new Item("Elixir of the Mongoose", 5, 7));
		items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
		items.add(new Item("Conjured Mana Cake", 3, 6));

		update();
	}
	
	// actualise la qualité et le sellIn des items
	public static void update()
	{
		for (int i = 0; i < items.size(); i++)
		{
			updateQuality(i);

			updateSellIn(i);
			
			
			
		}
	}
	
	// actualise la qualité des items
	private static void updateQuality(int i) {
		if (items.get(i).getQuality() < 50 && items.get(i).getQuality() > 0)
		{
			switch(items.get(i).getName())
			{
				case "Backstage passes to a TAFKAL80ETC concert":
					if (items.get(i).getSellIn() > 0)
					{
						items.get(i).setQuality(items.get(i).getQuality() + 1);
						if (items.get(i).getSellIn() < 11)
						{
							items.get(i).setQuality(items.get(i).getQuality() + 1);
						}
		
						if (items.get(i).getSellIn() < 6)
						{
							if (items.get(i).getQuality() < 50)
							{
								items.get(i).setQuality(items.get(i).getQuality() + 1);
							}
						}
					}
					break;
				case "Aged Brie":
					items.get(i).setQuality(items.get(i).getQuality() + 1);
					break;
				case "Sulfuras, Hand of Ragnaros":
					break;
				default:
					items.get(i).setQuality(items.get(i).getQuality() - 1);				
			}
		}
		if (items.get(i).getName().equals("Backstage passes to a TAFKAL80ETC concert") && items.get(i).getSellIn() < 0)
			items.get(i).setQuality(items.get(i).getQuality() - items.get(i).getQuality());
	}

	// actualise le sellIn des items
	private static void updateSellIn(int i) {
		if (!"Sulfuras, Hand of Ragnaros".equals(items.get(i).getName()))
		{
			items.get(i).setSellIn(items.get(i).getSellIn() - 1);
		}


	}
	
	

}