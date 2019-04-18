package feignJackson;

import feign.Feign;
import feign.jaxb.JAXBContextFactory;
import feign.jaxb.JAXBDecoder;
import feign.jaxb.JAXBEncoder;
import feign.okhttp.OkHttpClient;

public class appStart {


    public static void main(String[] args) {
        JAXBContextFactory jaxbFactory = new JAXBContextFactory.Builder()
                .withMarshallerJAXBEncoding("UTF-8")
                .build();

        testClient t = Feign.builder()
                .client(new OkHttpClient())
                .encoder(new JAXBEncoder(jaxbFactory))
                .decoder(new JAXBDecoder(jaxbFactory))
                .target(testClient.class, "https://api.holidayextras.co.uk//v1/product");


        String Manchester = "MANFT1";
        String Edinburgh = "EDIFT1";
        String Leeds = "LBAFT1";
        String key = "key";
        System.out.println(t.get(Manchester, key).getProduct().getContent().get(3).getValue());
        System.out.println(t.get(Edinburgh, key).getProduct().getContent().get(3).getValue());
        System.out.println(t.get(Leeds, key).getProduct().getContent().get(3).getValue());
    }

}
