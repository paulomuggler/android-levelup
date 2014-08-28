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

package com.soomla.levelup.gates.store;

import com.soomla.SoomlaUtils;
import com.soomla.levelup.data.LUJSONConsts;
import com.soomla.levelup.gates.Gate;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * A specific type of <code>Gate</code> that has an associated
 * virtual item and a desired balance. The gate opens once
 * the item's balance reaches the desired balance.
 * <p/>
 * Created by refaelos on 07/05/14.
 */
public class BalanceGate extends Gate {


    /**
     * Constructor
     *
     * @param id               see parent
     * @param associatedItemId the ID of the item who's balance is examined
     * @param desiredBalance   the balance which will open this gate
     */
    public BalanceGate(String id, String associatedItemId, int desiredBalance) {
        super(id);
        this.mDesiredBalance = desiredBalance;
        this.mAssociatedItemId = associatedItemId;
    }

    /**
     * Constructor
     * Generates an instance of <code>BalanceGate</code> from the given <code>JSONObject</code>.
     *
     * @param jsonObject see parent
     * @throws JSONException
     */
    public BalanceGate(JSONObject jsonObject) throws JSONException {
        super(jsonObject);
        mAssociatedItemId = jsonObject.getString(LUJSONConsts.LU_ASSOCITEMID);
        mDesiredBalance = jsonObject.getInt(LUJSONConsts.LU_DESIRED_BALANCE);
    }

    /**
     * Converts the current <code>RecordGate</code> to a <code>JSONObject</code>.
     *
     * @return A <code>JSONObject</code> representation of the current <code>RecordGate</code>.
     */
    @Override
    public JSONObject toJSONObject() {
        JSONObject jsonObject = super.toJSONObject();
        try {
            jsonObject.put(LUJSONConsts.LU_ASSOCITEMID, mAssociatedItemId);
            jsonObject.put(LUJSONConsts.LU_DESIRED_BALANCE, mDesiredBalance);
        } catch (JSONException e) {
            SoomlaUtils.LogError(TAG, "An error occurred while generating JSON object.");
        }

        return jsonObject;
    }


    /**
     * private members *
     */

    private static String TAG = "SOOMLA BalanceGate";

    private String mAssociatedItemId;
    private int mDesiredBalance;
}