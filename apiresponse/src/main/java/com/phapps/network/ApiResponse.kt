/*
 *  Copyright (c) 2018 Patrick Honkonen All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, is permitted provided that adherence to the following
 *  conditions is maintained. If you do not agree with these terms,
 *  please do not use, install, modify or redistribute this software.
 *
 *  1. Redistributions of source code must retain the above copyright notice, this
 *  list of conditions and the following disclaimer.
 *
 *  2. Redistributions in binary form must reproduce the above copyright notice,
 *  this list of conditions and the following disclaimer in the documentation
 *  and/or other materials provided with the distribution.
 *
 *  THIS SOFTWARE IS PROVIDED BY PATRICK HONKONEN "AS IS" AND ANY EXPRESS OR
 *  IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF
 *  MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO
 *  EVENT SHALL PATRICK HONKONEN OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
 *  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING,
 *  BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 *  DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 *  LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE
 *  OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 *  ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.phapps.network

/**
 * Simple sealed class that encapsulates API responses to assist communicating response results.
 *
 * @param DataType Type of object expected from the service.
 */
sealed class ApiResponse<out DataType>(val data: DataType?, val message: String?) {

    /**
     * A successful response has been received from the API
     */
    class Success<DataType>(data: DataType) : ApiResponse<DataType>(data, null)

    /**
     * An error occurred on the server. Will be accompanied by a user friendly message.
     */
    class Fail<DataType>(message: String, data: DataType? = null) : ApiResponse<DataType>(
        data,
        message
    )

    /**
     * A communication error has occurred. This is most likely due to communication issues.
     */
    class ConnectionError<DataType> : ApiResponse<DataType>(null, null)
}
