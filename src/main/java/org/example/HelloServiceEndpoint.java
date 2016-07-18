package org.example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.example.helloService.ServiceRequestDocument;
import org.example.helloService.ServiceRequestDocument.ServiceRequest;
import org.example.helloService.ServiceResponseDocument;
import org.example.helloService.ServiceResponseDocument.ServiceResponse;

import java.util.Calendar;

@Endpoint
public class HelloServiceEndpoint{
    private static final String namespaceUri = "http://www.example.org/HelloService";
    private HelloService helloService;
    @Autowired
    public void HelloService (HelloService helloService) {
        this.helloService = helloService;
    }
    @PayloadRoot(localPart = "ServiceRequest", namespace = namespaceUri)
    public ServiceResponseDocument getService(ServiceRequestDocument request) throws Exception {
        ServiceRequestDocument reqDoc = request;
        ServiceRequest req = reqDoc.getServiceRequest();
        ServiceResponseDocument respDoc = ServiceResponseDocument.Factory.newInstance();
        ServiceResponse resp = respDoc.addNewServiceResponse();

        String userName = req.getName();
        String helloMessage = testNewService.getHello(userName);
        Calendar currentTime = testNewService.getCurrentTime();

        resp.setHello(helloMessage);
        resp.setCurrentTime(currentTime);
        return respDoc;
    }
}