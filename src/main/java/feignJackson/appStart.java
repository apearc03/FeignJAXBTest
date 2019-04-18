package feignJackson;

import feign.Feign;
import feign.jaxb.JAXBContextFactory;
import feign.jaxb.JAXBDecoder;
import feign.jaxb.JAXBEncoder;

public class appStart {


    public static void main(String[] args) {
        JAXBContextFactory jaxbFactory = new JAXBContextFactory.Builder()
                .withMarshallerJAXBEncoding("UTF-8")
                .build();

        testClient t = Feign.builder()
                .encoder(new JAXBEncoder(jaxbFactory))
                .decoder(new JAXBDecoder(jaxbFactory))
                .target(testClient.class, "https://api.holidayextras.co.uk//v1/product/MANFT1?key=1");
        System.out.println(t.get().getProduct().getContent().get(1).getValue());
    }

}
