/**
 * Copyright (c) 2026 LJC
 *
 * SPDX-License-Identifier: GPL-3.0-or-later
 */

package io.github.icosadev.weatherstation.api;

/**
 * Represents the latitude and longitude co-ordinates
 * of a location on Earth.
 * 
 * @author LJC
 * @since 1.0
 */
public class Coordinates {
    public double latitude;
    public double longitude;

    /**
     * Initializes a {@code Coordinates} object and sets the
     * {@link #latitude} and {@link #longitude} attributes.
     * 
     * @param latitude the latitude of the location
     * @param longitude the longitude of the location
     * 
     * @since 1.0
     */
    public Coordinates(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /**
     * Initializes a {@code Coordinates} object with {@link #latitude}
     * and {@link #longitude} set to 0.
     * 
     * @since 1.0
     */
    public Coordinates() {
        this(0, 0);
    }

    @Override
    public String toString() {
        return "Coordinates [latitude=" + latitude + ", longitude=" + longitude + "]";
    }
}
