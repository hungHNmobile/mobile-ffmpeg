/*
 * Copyright (c) 2018 Taner Sener
 *
 * This file is part of MobileFFmpeg.
 *
 * MobileFFmpeg is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * MobileFFmpeg is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with MobileFFmpeg.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.arthenica.mobileffmpeg;

/**
 * <p>Base class for FFmpeg operations.
 *
 * @author Taner Sener
 */
public class FFmpeg {

    static {
        Abi abi = Abi.from(AbiDetect.getAbi());

        if (abi == Abi.ABI_ARMV7A_NEON) {
            System.loadLibrary("mobileffmpeg-armv7a-neon");
        } else {
            System.loadLibrary("mobileffmpeg");
        }
    }

    public native static String getFFmpegVersion();

    public native static String getVersion();

    public native static int execute(final String ... arguments);

}
