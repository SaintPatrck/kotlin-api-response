# kotlin-api-response
Simple Kotlin class that encapsulates API Responses.

 [ ![Download](https://api.bintray.com/packages/rizzin/api-response/api-response-ktx/images/download.svg) ](https://bintray.com/rizzin/api-response/api-response-ktx/_latestVersion)

## Usage
When consuming an API response object:
```kotlin

/**
* Sample Request Object
*/
data class RequestDto(val searchText:String)

/**
* Sample Response Object
*/
data class ResponseDto(val name:String, val id: Long)


override fun onResponse(response: ApiResponse<ResponseDto>) {

    when (response) {
    
        is Success -> println("ResponseDto[ name = ${response.data.name}, id = ${response.data.id}]")
        
        is Fail -> println("API Request Failed with message: ${response.message}")
        
        is ConnectionError -> println("Connection Error. Check your internet connection and try again.")
    
    }

}

```

When constructing the wrapper:

```kotlin

fun sendRequest(request: RequestDto): ApiResponse<ResponseDto> {

    val clientResponse = myApiClient.sendRequest(requestDto)
    
    return if (clientResponse.isConnectionError()) {
        ApiResponse.ConnectionError()
    } else if (clientResponse.isSuccess()) {
        ApiResponse.Success(clientResponse)
    } else {
        ApiResponse.Fail(clientResponse.errorMessage, clientResponse)
    }

}

```
