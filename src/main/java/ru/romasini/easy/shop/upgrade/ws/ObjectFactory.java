//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.11.12 at 09:32:43 PM MSK 
//


package ru.romasini.easy.shop.upgrade.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ru.romasini.spring.ws.main package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetProductsRequest_QNAME = new QName("http://www.romasini.ru/spring/ws/main", "getProductsRequest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.romasini.spring.ws.main
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetProductsResponse }
     * 
     */
    public GetProductsResponse createGetProductsResponse() {
        return new GetProductsResponse();
    }

    /**
     * Create an instance of {@link ProductWs }
     * 
     */
    public ProductWs createProduct() {
        return new ProductWs();
    }

    /**
     * Create an instance of {@link CategoryWs }
     * 
     */
    public CategoryWs createCategory() {
        return new CategoryWs();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.romasini.ru/spring/ws/main", name = "getProductsRequest")
    public JAXBElement<Object> createGetProductsRequest(Object value) {
        return new JAXBElement<Object>(_GetProductsRequest_QNAME, Object.class, null, value);
    }

}
