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

package org.hiero.sketch;

import org.hiero.sketch.table.ColumnDescription;
import org.hiero.sketch.table.DoubleListColumn;
import org.hiero.sketch.table.api.ContentsKind;
import org.hiero.sketch.table.IntArrayColumn;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ColumnTest {
    @Test
    public void testIntColumn() {
        final IntArrayColumn col;
        final int size = 100;

        final ColumnDescription desc = new ColumnDescription("test", ContentsKind.Int, false);
        col = new IntArrayColumn(desc, size);
        for (int i=0; i < size; i++)
            col.set(i, i);

        assertEquals( col.sizeInRows(), size );
        assertEquals( col.getInt(0), 0 );
        for (int i=0; i < size; i++)
            assertEquals(i, col.getInt(i));
        assertEquals( col.asDouble(0, null), 0.0, 1e-3 );
    }

    @Test
    public void testDoubleListColumn() {
        final DoubleListColumn col;
        final int size = 10000000;

        final ColumnDescription desc = new ColumnDescription("test", ContentsKind.Double, false);
        col = new DoubleListColumn(desc);
        for (int i=0; i < size; i++)
            col.append(i);


        assertEquals( col.sizeInRows(), size );
        assertEquals( col.getDouble(0), 0.0, 10e-3 );
        for (int i=0; i < size; i++)
            assertEquals((double)i, col.getDouble(i), 1e-3);
        assertEquals( col.asDouble(0, null), 0.0, 1e-3 );
    }
}
