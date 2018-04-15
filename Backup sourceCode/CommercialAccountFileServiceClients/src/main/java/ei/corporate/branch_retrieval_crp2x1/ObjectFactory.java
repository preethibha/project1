//
// Generated By:JAX-WS RI IBM 2.1.6 in JDK 6 (JAXB RI IBM JAXB 2.1.10 in JDK 6)
//


package ei.corporate.branch_retrieval_crp2x1;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import ei.core.simplefault.SimpleFault;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ei.corporate.branch_retrieval_crp2x1 package. 
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

    private final static QName _SimpleFault_QNAME = new QName("http://ei/corporate/branch_retrieval_crp2X1", "SimpleFault");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ei.corporate.branch_retrieval_crp2x1
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetLocalLanguageBranch }
     * 
     */
    public GetLocalLanguageBranch createGetLocalLanguageBranch() {
        return new GetLocalLanguageBranch();
    }

    /**
     * Create an instance of {@link GetLocalLanguageBranchResponse }
     * 
     */
    public GetLocalLanguageBranchResponse createGetLocalLanguageBranchResponse() {
        return new GetLocalLanguageBranchResponse();
    }

    /**
     * Create an instance of {@link GetBranch }
     * 
     */
    public GetBranch createGetBranch() {
        return new GetBranch();
    }

    /**
     * Create an instance of {@link GetProducingBranchList }
     * 
     */
    public GetProducingBranchList createGetProducingBranchList() {
        return new GetProducingBranchList();
    }

    /**
     * Create an instance of {@link GetBranchListResponse }
     * 
     */
    public GetBranchListResponse createGetBranchListResponse() {
        return new GetBranchListResponse();
    }

    /**
     * Create an instance of {@link GetBranchResponse }
     * 
     */
    public GetBranchResponse createGetBranchResponse() {
        return new GetBranchResponse();
    }

    /**
     * Create an instance of {@link GetBranchList }
     * 
     */
    public GetBranchList createGetBranchList() {
        return new GetBranchList();
    }

    /**
     * Create an instance of {@link GetProducingBranchListResponse }
     * 
     */
    public GetProducingBranchListResponse createGetProducingBranchListResponse() {
        return new GetProducingBranchListResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SimpleFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ei/corporate/branch_retrieval_crp2X1", name = "SimpleFault")
    public JAXBElement<SimpleFault> createSimpleFault(SimpleFault value) {
        return new JAXBElement<SimpleFault>(_SimpleFault_QNAME, SimpleFault.class, null, value);
    }

}
