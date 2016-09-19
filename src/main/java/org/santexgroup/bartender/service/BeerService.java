package org.santexgroup.bartender.service;

import org.santexgroup.bartender.model.BarleyWine;
import org.santexgroup.bartender.model.Beer;
import org.santexgroup.bartender.model.BeerType;
import org.santexgroup.bartender.model.IndianPaleAle;

import java.util.*;

/**
 * This is the BeerService. As you may correctly guess, it will provide beer upon request
 */
public class BeerService {

    private Set<BeerType> availableBeerTypes;
    private Map<BeerType, Integer> stock;

    public BeerService() {
        availableBeerTypes = new HashSet<BeerType>();
        Collections.addAll(availableBeerTypes, new IndianPaleAle(), new BarleyWine());
        availableBeerTypes.add(new BarleyWine());
        stock = new HashMap<BeerType, Integer>();
        for (BeerType beerType : availableBeerTypes) {
            stock.put(beerType, 0);
        }
    }

    /**
     * Adds more beer to the stock
     * @param beerType the beerType to add
     * @param amount the amount of beers
     */
    public void stockBeer(BeerType beerType, int amount){
        stock.put(beerType, stock.get(beerType) + amount);
    }

    /**
     * Returns the amount of beers for a particular type
     * @param beerType the beerType to ask for
     * @return the amount of beers
     */
    public int getBeerStock(BeerType beerType){
        return stock.get(beerType);
    }

    /**
     * Serves a beer. No shirt, no shoes, no service
     * @param beerType the beerType you want
     * @param cold is this really a question?
     * @param toGo whether you want to drink it at the bar or take it for a walk
     * @return you know what you will get
     */
    public Beer getBeer(BeerType beerType, boolean cold, boolean toGo){
        if (!cold){
            throw new IllegalArgumentException("WHO ON THIS FORSAKEN WORLD WOULD ASK FOR A NON-COLD BEER??");
        }
        Integer amountOnStock = stock.get(beerType);
        if (amountOnStock <= 0){
            //TODO: This is not a good response. One may ask...what happened beer I asked for?
            return null;
        }else{
            stock.put(beerType, stock.get(beerType) -1);
            return new Beer(beerType, toGo);
        }
    }

    /**
     * Serves a beer. No shirt, no shoes, no service.
     *
     * @param beerType the beerType you want
     * @param cold is this really a question?
     * @param toGo whether you want to drink it at the bar or take it for a walk
     * @return you know what you will get
     */
    public Beer beerMe(BeerType beerType, boolean cold, boolean toGo){
        if (!cold){
            throw new IllegalArgumentException("WHO ON THIS FORSAKEN WORLD WOULD ASK FOR A NON-COLD BEER??");
        } else {
            Integer amountOnStock = stock.get(beerType);
            if (amountOnStock <= 0){
                //TODO: This is not a good response. One may ask...what happened beer I asked for?
                return null;
            }else{
                //A bit redundant don't you think?
                if (amountOnStock > 0){
                    stock.put(beerType, stock.get(beerType) -1);
                    return new Beer(beerType, toGo);
                }
            }
        }
        return null;
    }

}
