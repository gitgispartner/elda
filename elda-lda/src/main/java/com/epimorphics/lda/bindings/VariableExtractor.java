/*
    See lda-top/LICENCE (or https://raw.github.com/epimorphics/elda/master/LICENCE)
    for the licence for this software.
    
    (c) Copyright 2011 Epimorphics Limited
    $Id$
*/

package com.epimorphics.lda.bindings;


import static com.epimorphics.util.RDFUtils.getStringValue;
import static com.epimorphics.util.RDFUtils.getResourceValue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.epimorphics.lda.exceptions.EldaException;
import com.epimorphics.lda.rdfq.Value;
import com.epimorphics.lda.vocabularies.API;
import com.epimorphics.lda.vocabularies.ELDA_API;
import com.hp.hpl.jena.graph.Node;
import com.hp.hpl.jena.rdf.model.Literal;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.ResourceFactory;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.vocabulary.RDFS;

/**
    Extracts and binds variables from API specifications.
 
 	@author chris
*/
public class VariableExtractor {
	
	static Logger log = LoggerFactory.getLogger(VariableExtractor.class);
    
	public static Bindings findAndBindVariables( Resource root ) {
		return findAndBindVariables( new Bindings(), root ); 
	}	

	public static Bindings findAndBindVariables( Bindings bound, Resource root) {
    	findVariables( root, bound );
		return bound;
	}
	
	public static final Literal nullString = ResourceFactory.createPlainLiteral("");
	
    /**
	    Find variable declarations hanging off <code>root</code>. Definitions
	    that are not literals-containing-{ are stored directly into 
	    <code>bound</code>. Otherwise, the name and its literal value are
	    stored into <code>toDo</code> for later evaluation.
	*/
	public static void findVariables( Resource root, Bindings bound ) {
		// See issue #180
		for (Statement s: root.listProperties( API.variable ).toList()) {
			Resource v = s.getResource();
			String name = getStringValue( v, API.name, null );
			String type = getStringValue( v, API.type, null );
			String language = getStringValue( v, API.lang, "" );
			
			Statement value = v.getProperty( API.value );
			RDFNode valueNode = value == null ? nullString : value.getObject();
			
			if (type == null && value != null && value.getObject().isLiteral())
				type = emptyIfNull( value.getObject().asNode().getLiteralDatatypeURI() );
			if (type == null && value != null && value.getObject().isURIResource())
				type = RDFS.Resource.getURI();
			if (type == null) {
				log.debug("no type for variable '{}'; using default ''", name);
				type = "";
			}

			
			if (valueNode.isAnon()) {
				String valueString = getValueString( valueNode.asResource() );
				Resource mapResource = getResourceValue( v, ELDA_API.mapWith );
				String mapName = (mapResource == null ? null : mapResource.getURI());
				Value.Apply apply = new Value.Apply(mapName, valueString);
				Value var = new Value( valueString, language, type, apply);
				bound.put(name,  var);
			} else {
				String valueString = getValueString( v );
				Value var = new Value( valueString, language, type, Value.noApply);			
				bound.put( name, var ); 			
			}
		}
	}
	
	private static String emptyIfNull(String s) {
		return s == null ? "" : s;
	}

	private static String getValueString(Resource v) {
		Statement s = v.getProperty( API.value );
		if (s == null) return null;
		Node object = s.getObject().asNode();
		if (object.isURI()) return object.getURI();
		if (object.isLiteral()) return object.getLiteralLexicalForm();
		EldaException.Broken( "cannot convert " + object + " to RDFQ type." );
		return null;
	}
}
