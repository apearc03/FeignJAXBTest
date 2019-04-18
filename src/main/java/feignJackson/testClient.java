package feignJackson;

import feign.Param;
import feign.RequestLine;
import generated.APIReply;

public interface testClient {

    @RequestLine("GET /{fastTrackCode}?key={apikey}")
    APIReply get(@Param("fastTrackCode") String fastTrackCode, @Param("apikey") String apiKey);

}
