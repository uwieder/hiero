/*
 * Copyright (c) 2017 VMware Inc. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
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
 */

package org.hillview.dataset.remoting;

import org.hillview.dataset.api.IMap;

import java.io.Serializable;
import java.util.List;

/**
 * Wrap an IMap object to be sent to a remote node for a flatMap operation.
 * @param <T> Input type of the map function
 * @param <S> Output type of the map function
 */
public class FlatMapOperation<T, S> extends RemoteOperation implements Serializable {
    public final IMap<T, List<S>> mapper;

    public FlatMapOperation(final IMap<T, List<S>> mapper) {
        this.mapper = mapper;
    }
}
