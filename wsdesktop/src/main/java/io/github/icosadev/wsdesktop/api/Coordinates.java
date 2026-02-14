/*
 * Copyright (c) 2026 LJC
 *
 * SPDX-License-Identifier: GPL-3.0-or-later
 */

package io.github.icosadev.wsdesktop.api;

public class Coordinates {
    public double latitude;
    public double longitude;

    public Coordinates(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Coordinates() {
        this(0, 0);
    }

    @Override
    public String toString() {
        return "Coordinates [latitude=" + latitude + ", longitude=" + longitude + "]";
    }
}
