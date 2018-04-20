/* CVS $Id: $ */
package com.epimorphics.lda.vocabularies; 
import com.hp.hpl.jena.rdf.model.*;
 
/**
 * Vocabulary definitions from /home/eh/Work/Elda/elda/elda-lda/../vocabs/elda_api.ttl 
 * @author Auto-generated by schemagen on 20 Apr 2018 15:38 
 */
public class ELDA_API  extends API {
    /** <p>The RDF model that holds the vocabulary terms</p> */
    private static Model m_model = ModelFactory.createDefaultModel();
    
    /** <p>The namespace of the vocabulary as a string</p> */
    public static final String NS = "http://www.epimorphics.com/vocabularies/lda#";
    
    /** <p>The namespace of the vocabulary as a string</p>
     *  @see #NS */
    public static String getURI() {return NS;}
    
    /** <p>The namespace of the vocabulary as a resource</p> */
    public static final Resource NAMESPACE = m_model.createResource( NS );
    
    /** <p>Property of JSON-LD formatter that determines if all literals are rendered 
     *  with their types.</p>
     */
    public static final Property allLiteralsStructured = m_model.createProperty( "http://www.epimorphics.com/vocabularies/lda#allLiteralsStructured" );
    
    /** <p>:</p> */
    public static final Property allowReserved = m_model.createProperty( "http://www.epimorphics.com/vocabularies/lda#allowReserved" );
    
    /** <p></p> */
    public static final Property allowSyntaxProperties = m_model.createProperty( "http://www.epimorphics.com/vocabularies/lda#allowSyntaxProperties" );
    
    /** <p>if present and true, allows a basic-auth SPARQL endpoint to connect without 
     *  using https. This should only be used if the connection to the endpoint is 
     *  already secure.</p>
     */
    public static final Property authAllowInsecure = m_model.createProperty( "http://www.epimorphics.com/vocabularies/lda#authAllowInsecure" );
    
    /** <p>comma-separated list of file wildcarded paths for authentication files.</p> */
    public static final Property authFile = m_model.createProperty( "http://www.epimorphics.com/vocabularies/lda#authFile" );
    
    /** <p>key identifying which authentication item to use.</p> */
    public static final Property authKey = m_model.createProperty( "http://www.epimorphics.com/vocabularies/lda#authKey" );
    
    /** <p>If given a value, that is the cache expiry time in seconds for an endpoint 
     *  or family of endpoints.</p>
     */
    public static final Property cacheExpiryTime = m_model.createProperty( "http://www.epimorphics.com/vocabularies/lda#cacheExpiryTime" );
    
    /** <p>name of one of Elda's cache policies.</p> */
    public static final Property cachePolicyName = m_model.createProperty( "http://www.epimorphics.com/vocabularies/lda#cachePolicyName" );
    
    /** <p>If a JSON LD renderer has this property, its value determines whether the 
     *  renderer checks that the model has round-tripped through the generated JSON 
     *  LD.</p>
     */
    public static final Property checkJSONLDRoundTrip = m_model.createProperty( "http://www.epimorphics.com/vocabularies/lda#checkJSONLDRoundTrip" );
    
    /** <p>full Java class name of an Elda formatter plugin.</p> */
    public static final Property className = m_model.createProperty( "http://www.epimorphics.com/vocabularies/lda#className" );
    
    /** <p></p> */
    public static final Property construct = m_model.createProperty( "http://www.epimorphics.com/vocabularies/lda#construct" );
    
    /** <p></p> */
    public static final Property describeAllLabel = m_model.createProperty( "http://www.epimorphics.com/vocabularies/lda#describeAllLabel" );
    
    /** <p></p> */
    public static final Property describeThreshold = m_model.createProperty( "http://www.epimorphics.com/vocabularies/lda#describeThreshold" );
    
    /** <p></p> */
    public static final Property element = m_model.createProperty( "http://www.epimorphics.com/vocabularies/lda#element" );
    
    /** <p>If true, "true", or "yes", Elda will generate a total item count for any list-endpoint 
     *  query. If false, "false", or "no", it will not. Otherwise counting is enabled 
     *  using the _count query parameter.</p>
     */
    public static final Property enableCounting = m_model.createProperty( "http://www.epimorphics.com/vocabularies/lda#enableCounting" );
    
    /** <p>If given the value true, then Elda generates an ETag for its results.</p> */
    public static final Property enableETags = m_model.createProperty( "http://www.epimorphics.com/vocabularies/lda#enableETags" );
    
    /** <p></p> */
    public static final Property enhanceViewWith = m_model.createProperty( "http://www.epimorphics.com/vocabularies/lda#enhanceViewWith" );
    
    /** <p></p> */
    public static final Property feedAuthorProperties = m_model.createProperty( "http://www.epimorphics.com/vocabularies/lda#feedAuthorProperties" );
    
    /** <p></p> */
    public static final Property feedAuthors = m_model.createProperty( "http://www.epimorphics.com/vocabularies/lda#feedAuthors" );
    
    /** <p></p> */
    public static final Property feedDateProperties = m_model.createProperty( "http://www.epimorphics.com/vocabularies/lda#feedDateProperties" );
    
    /** <p></p> */
    public static final Property feedLabelProperties = m_model.createProperty( "http://www.epimorphics.com/vocabularies/lda#feedLabelProperties" );
    
    /** <p></p> */
    public static final Property feedNamespace = m_model.createProperty( "http://www.epimorphics.com/vocabularies/lda#feedNamespace" );
    
    /** <p></p> */
    public static final Property feedRights = m_model.createProperty( "http://www.epimorphics.com/vocabularies/lda#feedRights" );
    
    /** <p></p> */
    public static final Property feedRightsProperties = m_model.createProperty( "http://www.epimorphics.com/vocabularies/lda#feedRightsProperties" );
    
    /** <p></p> */
    public static final Property feedTitle = m_model.createProperty( "http://www.epimorphics.com/vocabularies/lda#feedTitle" );
    
    /** <p>Configuration property to set the name of the queried graph from an endpoint-specific 
     *  template.</p>
     */
    public static final Property graphTemplate = m_model.createProperty( "http://www.epimorphics.com/vocabularies/lda#graphTemplate" );
    
    /** <p></p> */
    public static final Property ifStarts = m_model.createProperty( "http://www.epimorphics.com/vocabularies/lda#ifStarts" );
    
    /** <p>Property of a JSONFormatter that says if xsd:date and xsd:dateTime values 
     *  should be encoded based on ISO 8601. Default value is false.</p>
     */
    public static final Property jsonUsesISOdate = m_model.createProperty( "http://www.epimorphics.com/vocabularies/lda#jsonUsesISOdate" );
    
    /** <p>the key of a maplet</p> */
    public static final Property key = m_model.createProperty( "http://www.epimorphics.com/vocabularies/lda#key" );
    
    /** <p>Configuration property to set a URL for a licence for the response page or 
     *  a way of extracting licence URLs from the SPARQL endpoint. There can be many 
     *  such licences.</p>
     */
    public static final Property license = m_model.createProperty( "http://www.epimorphics.com/vocabularies/lda#license" );
    
    /** <p></p> */
    public static final Property listURL = m_model.createProperty( "http://www.epimorphics.com/vocabularies/lda#listURL" );
    
    /** <p></p> */
    public static final Property loadedFrom = m_model.createProperty( "http://www.epimorphics.com/vocabularies/lda#loadedFrom" );
    
    /** <p>introduces a map declaration</p> */
    public static final Property map = m_model.createProperty( "http://www.epimorphics.com/vocabularies/lda#map" );
    
    /** <p>specifies the mapName of a Value for variable lookup.</p> */
    public static final Property mapName = m_model.createProperty( "http://www.epimorphics.com/vocabularies/lda#mapName" );
    
    /** <p>introduces one key-value pair of a map</p> */
    public static final Property maplet = m_model.createProperty( "http://www.epimorphics.com/vocabularies/lda#maplet" );
    
    /** <p></p> */
    public static final Property match = m_model.createProperty( "http://www.epimorphics.com/vocabularies/lda#match" );
    
    /** <p>Property mapping from page to metadata for JSON-LD rendering.</p> */
    public static final Property meta = m_model.createProperty( "http://www.epimorphics.com/vocabularies/lda#meta" );
    
    /** <p></p> */
    public static final Property metaURL = m_model.createProperty( "http://www.epimorphics.com/vocabularies/lda#metaURL" );
    
    /** <p></p> */
    public static final Property metadataOptions = m_model.createProperty( "http://www.epimorphics.com/vocabularies/lda#metadataOptions" );
    
    /** <p>Attatches a notice (eg deprecation) to a generated page.</p> */
    public static final Property notice = m_model.createProperty( "http://www.epimorphics.com/vocabularies/lda#notice" );
    
    /** <p>Property of an API spec or endpoint that says whether suspicious characters 
     *  should be dropped from a query parameter filter value.</p>
     */
    public static final Property purgeFilterValues = m_model.createProperty( "http://www.epimorphics.com/vocabularies/lda#purgeFilterValues" );
    
    /** <p></p> */
    public static final Property replaceStartBy = m_model.createProperty( "http://www.epimorphics.com/vocabularies/lda#replaceStartBy" );
    
    /** <p></p> */
    public static final Property rewriteResultURIs = m_model.createProperty( "http://www.epimorphics.com/vocabularies/lda#rewriteResultURIs" );
    
    /** <p></p> */
    public static final Property shortnameMode = m_model.createProperty( "http://www.epimorphics.com/vocabularies/lda#shortnameMode" );
    
    /** <p></p> */
    public static final Property sparqlQuery = m_model.createProperty( "http://www.epimorphics.com/vocabularies/lda#sparqlQuery" );
    
    /** <p></p> */
    public static final Property supportsNestedSelect = m_model.createProperty( "http://www.epimorphics.com/vocabularies/lda#supportsNestedSelect" );
    
    /** <p>Property from page to term bindings</p> */
    public static final Property termBinding = m_model.createProperty( "http://www.epimorphics.com/vocabularies/lda#termBinding" );
    
    /** <p></p> */
    public static final Property textContentProperty = m_model.createProperty( "http://www.epimorphics.com/vocabularies/lda#textContentProperty" );
    
    public static final Property textPlaceEarly = m_model.createProperty( "http://www.epimorphics.com/vocabularies/lda#textPlaceEarly" );
    
    /** <p></p> */
    public static final Property textQueryProperty = m_model.createProperty( "http://www.epimorphics.com/vocabularies/lda#textQueryProperty" );
    
    /** <p></p> */
    public static final Property textSearchOperand = m_model.createProperty( "http://www.epimorphics.com/vocabularies/lda#textSearchOperand" );
    
    /** <p></p> */
    public static final Property uriTemplatePrefix = m_model.createProperty( "http://www.epimorphics.com/vocabularies/lda#uriTemplatePrefix" );
    
    /** <p></p> */
    public static final Property velocityTemplate = m_model.createProperty( "http://www.epimorphics.com/vocabularies/lda#velocityTemplate" );
    
    /** <p></p> */
    public static final Property viewName = m_model.createProperty( "http://www.epimorphics.com/vocabularies/lda#viewName" );
    
    public static final Property vocabFallback = m_model.createProperty( "http://www.epimorphics.com/vocabularies/lda#vocabFallback" );
    
    /** <p></p> */
    public static final Property wantsContext = m_model.createProperty( "http://www.epimorphics.com/vocabularies/lda#wantsContext" );
    
    /** <p></p> */
    public static final Resource Combiner = m_model.createResource( "http://www.epimorphics.com/vocabularies/lda#Combiner" );
    
    /** <p></p> */
    public static final Resource FeedFormatter = m_model.createResource( "http://www.epimorphics.com/vocabularies/lda#FeedFormatter" );
    
    /** <p></p> */
    public static final Resource VelocityFormatter = m_model.createResource( "http://www.epimorphics.com/vocabularies/lda#VelocityFormatter" );
    
    /** <p></p> */
    public static final Resource preferLocalnames = m_model.createResource( "http://www.epimorphics.com/vocabularies/lda#preferLocalnames" );
    
    /** <p></p> */
    public static final Resource preferPrefixes = m_model.createResource( "http://www.epimorphics.com/vocabularies/lda#preferPrefixes" );
    
    /** <p></p> */
    public static final Resource roundTrip = m_model.createResource( "http://www.epimorphics.com/vocabularies/lda#roundTrip" );
    
}
