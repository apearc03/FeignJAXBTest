package feignJackson;

import feign.RequestLine;
import generated.APIReply;

public interface testClient {

    @RequestLine("GET")
    APIReply get();

}
