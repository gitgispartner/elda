/*
    See lda-top/LICENCE (or http://elda.googlecode.com/hg/LICENCE)
    for the licence for this software.
    
    (c) Copyright 2011 Epimorphics Limited
    $Id$
*/

package com.epimorphics.lda.exceptions;

import com.epimorphics.lda.rdfq.Term;
import com.hp.hpl.jena.rdf.model.RDFNode;

public class ExpansionFailedException extends EldaException {

	private static final long serialVersionUID = 1L;
	
	private static final String reason = "unrecognised short name or literal: ";

	public ExpansionFailedException( String res ) {
		super( reason + res, "", BAD_REQUEST );
	}

	public ExpansionFailedException( RDFNode res ) {
		super( reason + res.toString(), "", BAD_REQUEST );
	}

	public ExpansionFailedException( Term r ) {
		super( reason + r.toString(), "", BAD_REQUEST );
	}


}