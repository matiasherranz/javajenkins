package org.santexgroup.bartender.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.santexgroup.bartender.model.BarleyWine;
import org.santexgroup.bartender.model.Beer;
import org.santexgroup.bartender.model.BeerType;
import org.santexgroup.bartender.model.IndianPaleAle;

/**
 * This is the test class for the BeerService. Let's make sure our service is first class.
 *
 * See what I did there? Hehe
 */
public class BeerServiceTest {

    private BeerService beerService;

    @Before
    public void setup(){
        beerService = new BeerService();
    }

    /**
     * Tests that if there is no stock for a beer type, no beer is returned
     */
    @Test
    public void testResponseWithNoStock(){
        Beer beer = beerService.getBeer(new IndianPaleAle(), true, false);
        Assert.assertNull("We expected a null, whatever that is", beer);
    }

    /**
     * Tests that if there is stock for a beer type, the beer is returned
     * and that the stock is updated accordingly
     */
    @Test
    public void testResponseWithStock(){
        BeerType beerType = new IndianPaleAle();
        beerService.stockBeer(beerType, 2);
        Beer beer = beerService.getBeer(beerType, true, false);
        Assert.assertNotNull("We expected a beer", beer);
        Assert.assertEquals("Wait, this is not an Indian Pale Ale! I want my money back!",
                IndianPaleAle.class, beer.getBeerType().getClass());
        Assert.assertEquals("There should only be one beer left",
                1, beerService.getBeerStock(beerType));
    }

    /**
     * This is duplicated on purpose
     */
    @Test
    public void testResponseWithStockUsingBeerMe(){
        BeerType beerType = new IndianPaleAle();
        beerService.stockBeer(beerType, 2);
        Beer beer = beerService.beerMe(beerType, true, false);
        Assert.assertNotNull("We expected a beer", beer);
        Assert.assertEquals("Wait, this is not an Indian Pale Ale! I want my money back!",
                IndianPaleAle.class, beer.getBeerType().getClass());
        Assert.assertEquals("There should only be one beer left",
                1, beerService.getBeerStock(beerType));
    }

    /**
     * Tests that if someone asks for a non-cold beer, the service replies appropriately
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSomethingStupid(){
        BeerType beerType = new BarleyWine();
        beerService.stockBeer(beerType, 2);
        beerService.getBeer(beerType, false, false);
    }

}
