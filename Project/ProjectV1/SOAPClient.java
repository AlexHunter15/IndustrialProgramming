import javax.xml.soap.*;

public class SOAPClient {

    public static void main(String[] args) {
        String soapEndpointUrl = "http://www.example.com/soap/service"; // Replace with your SOAP service endpoint URL

        try {
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();

            // Create SOAP message
            MessageFactory messageFactory = MessageFactory.newInstance();
            SOAPMessage soapMessage = messageFactory.createMessage();

            // Create SOAP envelope
            SOAPPart soapPart = soapMessage.getSOAPPart();
            SOAPEnvelope envelope = soapPart.getEnvelope();
            envelope.addNamespaceDeclaration("example", "http://www.example.com/namespace");

            // Construct SOAP body
            SOAPBody soapBody = envelope.getBody();
            SOAPElement soapBodyElem = soapBody.addChildElement("getFabricDetails", "example");
            soapBodyElem.addChildElement("parameter1", "example").addTextNode("value1");
            soapBodyElem.addChildElement("parameter2", "example").addTextNode("value2");

            soapMessage.saveChanges();

            // Send SOAP request and get response
            SOAPMessage soapResponse = soapConnection.call(soapMessage, soapEndpointUrl);

            // Process the SOAP response
            if (soapResponse != null) {
                SOAPPart responsePart = soapResponse.getSOAPPart();
                SOAPEnvelope responseEnvelope = responsePart.getEnvelope();
                SOAPBody responseBody = responseEnvelope.getBody();

                // Retrieve data from SOAP response
                // Process the response here according to your application's logic
            }

            soapConnection.close();
        } catch (Exception e) {
            System.err.println("Error occurred while sending SOAP request: " + e.getMessage());
        }
    }
}
