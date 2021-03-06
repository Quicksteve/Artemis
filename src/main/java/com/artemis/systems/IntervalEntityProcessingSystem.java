/**
 * This file is part of Artemis, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2014 SpongePowered <http://spongepowered.org/>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.artemis.systems;

import com.artemis.Aspect;
import com.artemis.Entity;
import com.artemis.utils.ImmutableBag;

/**
 * If you need to process entities at a certain interval then use this.
 * A typical usage would be to regenerate ammo or health at certain intervals, no need
 * to do that every game loop, but perhaps every 100 ms. or every second.
 *
 * @author Arni Arent
 */
public abstract class IntervalEntityProcessingSystem extends IntervalEntitySystem {
    public IntervalEntityProcessingSystem(Aspect aspect, float interval) {
        super(aspect, interval);
    }

    /**
     * Process a entity this system is interested in.
     *
     * @param e the entity to process.
     */
    protected abstract void process(Entity e);


    @Override
    protected void processEntities(ImmutableBag<Entity> entities) {
        for (int i = 0, s = entities.size(); s > i; i++) {
            process(entities.get(i));
        }
    }
}
