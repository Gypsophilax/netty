/*
 * Copyright (C) 2008  Trustin Heuiseung Lee
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, 5th Floor, Boston, MA 02110-1301 USA
 */
package net.gleamynode.netty.buffer;

import static org.junit.Assert.*;

import java.util.Random;


public class SlicedChannelBufferTest extends AbstractChannelBufferTest {

    private final Random random = new Random();
    private ChannelBuffer buffer;

    @Override
    protected ChannelBuffer newBuffer(int length) {
        buffer = ChannelBuffers.wrappedBuffer(
                new byte[length * 2], random.nextInt(length - 1) + 1, length);
        assertEquals(length, buffer.writerIndex());
        return buffer;
    }

    @Override
    protected ChannelBuffer[] components() {
        return new ChannelBuffer[] { buffer };
    }
}
