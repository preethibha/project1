//
// Generated By:JAX-WS RI IBM 2.2.1-11/30/2010 12:42 PM(foreman)- (JAXB RI IBM 2.2.3-03/09/2011 06:46 PM(foreman)-)
//


package chubb_corporate.get_access.region_and_language_settings;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the chubb_corporate.get_access.region_and_language_settings package. 
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

    private final static QName _RegionAndLanguageSettings_QNAME = new QName("http://chubb_corporate/get_access/region_and_language_settings", "RegionAndLanguageSettings");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: chubb_corporate.get_access.region_and_language_settings
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RegionAndLanguageSettings }
     * 
     */
    public RegionAndLanguageSettings createRegionAndLanguageSettings() {
        return new RegionAndLanguageSettings();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegionAndLanguageSettings }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://chubb_corporate/get_access/region_and_language_settings", name = "RegionAndLanguageSettings")
    public JAXBElement<RegionAndLanguageSettings> createRegionAndLanguageSettings(RegionAndLanguageSettings value) {
        return new JAXBElement<RegionAndLanguageSettings>(_RegionAndLanguageSettings_QNAME, RegionAndLanguageSettings.class, null, value);
    }

}
