package org.santexgroup.bartender.model;

/**
 * A proper beer. Do not shake!
 */
public class Beer {

    private BeerType beerType;
    private boolean isOnCup;

    public Beer(BeerType beerType, boolean isOnCup) {
        this.beerType = beerType;
        this.isOnCup = isOnCup;
    }

    public BeerType getBeerType() {
        return beerType;
    }

    public boolean isOnCup() {
        return isOnCup;
    }
}
