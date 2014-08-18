/*
 * Copyright (C) 2012-2014 Soomla Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.soomla.levelup.challenges;


import com.soomla.levelup.gates.RecordGate;
import com.soomla.rewards.Reward;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * A specific type of <code>Mission</code> that has an associated
 * score and a desired record which opens a <code>RecordGate</code>.
 * The mission is completed once the record gate is opened.
 * <p/>
 * Created by refaelos on 13/05/14.
 */
public class RecordMission extends Mission {

    /**
     * Constructor
     *
     * @param id                see parent
     * @param name              see parent
     * @param associatedScoreId the ID of the item who's score is examined
     * @param desiredRecord     the record which will complete this mission
     */
    public RecordMission(String id, String name, String associatedScoreId, int desiredRecord) {
        super(id, name, RecordGate.class, new Object[]{associatedScoreId, desiredRecord});
    }

    /**
     * Constructor
     *
     * @param id                see parent
     * @param name              see parent
     * @param rewards           see parent
     * @param associatedScoreId the ID of the item who's score is examined
     * @param desiredRecord     the record which will complete this mission
     */
    public RecordMission(String id, String name, List<Reward> rewards, String associatedScoreId, int desiredRecord) {
        super(id, name, rewards, RecordGate.class, new Object[]{associatedScoreId, desiredRecord});
    }

    /**
     * @{inheritDoc}
     */
    public RecordMission(JSONObject jsonMission) throws JSONException {
        super(jsonMission);
    }

}
