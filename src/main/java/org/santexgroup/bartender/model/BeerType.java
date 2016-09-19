package org.santexgroup.bartender.model;

import java.util.Objects;

/**
 * This is the BeerType class.
 *
 * Other beer types will extend from this class
 */
public abstract class BeerType {

    protected float alcoholByVolume;
    protected String name;

    public float getAlcoholByVolume() {
        return alcoholByVolume;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BeerType beerType = (BeerType) o;
        return Objects.equals(name, beerType.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
