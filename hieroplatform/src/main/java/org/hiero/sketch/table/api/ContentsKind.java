/*
 * Copyright (c) 2017 VMware Inc. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0 2
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package org.hiero.sketch.table.api;

import java.io.Serializable;

/**
 * Describes the kind of data that is in the column,
 */
public enum ContentsKind implements Serializable {
    String,
    Date,  /* java.Util.Date values */
    Int,
    Json,
    Double,
    Duration; /* java.time.Duration values */

    /**
     * True if this kind of information requires a Java Object for storage.
     */
    @SuppressWarnings("BooleanMethodIsAlwaysInverted")
    public boolean isObject() {
        switch (this) {
            case String:
            case Date:
            case Json:
            case Duration:
                return true;
            case Int:
            case Double:
            default:
                return false;
        }
    }
}
