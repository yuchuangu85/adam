/*
 * Copyright (C) 2019 Anton Malinskiy
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

package com.malinskiy.adam.model.cmd.forwarding

import com.malinskiy.adam.model.cmd.HostSerial
import com.malinskiy.adam.model.cmd.SynchronousRequest

class PortForwardRequest(
    private val local: LocalPortSpec,
    private val remote: RemotePortSpec,
    private val serial: String
) : SynchronousRequest<Unit>(target = HostSerial(serial)) {

    override fun serialize() =
        createBaseRequest("forward:${local.toSpec()};${remote.toSpec()}")

    override suspend fun process(count: ByteArray, offset: Int, limit: Int) = Unit

    override fun transform() = Unit
}