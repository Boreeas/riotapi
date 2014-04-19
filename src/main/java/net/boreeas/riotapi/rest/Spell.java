/*
 * Copyright 2014 Malte Schütze
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.boreeas.riotapi.rest;

import lombok.Getter;

import java.util.List;

/**
 * Created on 4/14/2014.
 */
@Getter
public class Spell {
    private List<Image> altImages;
    private List<Integer> cooldown;
    private String cooldownBurn;
    private List<Integer> cost;
    private String costBurn;
    private String costType;
    private String description;
    private List<List<Integer>> effect;
    private List<String> effectBurn;
    private Image image;
    private String key;
    private LevelTip leveltip;
    private int maxrank;
    private String name;
    private Object range;
    private String rangeBurn;
    private String resource;
    private String sanitizedDescription;
    private String sanitizedTooltip;
    private String tooltip;
    private List<SpellVars> vars;

    public boolean isSelfTargeted() {
        return range instanceof String;
    }

    /**
     * If the spell is not self-targeted, return a list of ranges.
     * Otherwise, throw an @see IllegalStateException
     * @return The ranges of the spell
     */
    public List<Integer> getRanges() {
        if (isSelfTargeted()) {
            throw new IllegalStateException();
        }
        return (List<Integer>) range;
    }
}
