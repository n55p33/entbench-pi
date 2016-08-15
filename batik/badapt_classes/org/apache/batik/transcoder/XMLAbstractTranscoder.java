package org.apache.batik.transcoder;
public abstract class XMLAbstractTranscoder extends org.apache.batik.transcoder.AbstractTranscoder implements ent.runtime.ENT_Attributable {
    protected XMLAbstractTranscoder() { super();
                                        hints.put(KEY_XML_PARSER_VALIDATING,
                                                  java.lang.Boolean.
                                                    FALSE); }
    public void transcode(org.apache.batik.transcoder.TranscoderInput input,
                          org.apache.batik.transcoder.TranscoderOutput output)
          throws org.apache.batik.transcoder.TranscoderException { org.w3c.dom.Document document =
                                                                     null;
                                                                   java.lang.String uri =
                                                                     input.
                                                                     getURI(
                                                                       );
                                                                   if (input.
                                                                         getDocument(
                                                                           ) !=
                                                                         null) {
                                                                       document =
                                                                         input.
                                                                           getDocument(
                                                                             );
                                                                   }
                                                                   else {
                                                                       java.lang.String parserClassname =
                                                                         (java.lang.String)
                                                                           hints.
                                                                           get(
                                                                             KEY_XML_PARSER_CLASSNAME);
                                                                       java.lang.String namespaceURI =
                                                                         (java.lang.String)
                                                                           hints.
                                                                           get(
                                                                             KEY_DOCUMENT_ELEMENT_NAMESPACE_URI);
                                                                       java.lang.String documentElement =
                                                                         (java.lang.String)
                                                                           hints.
                                                                           get(
                                                                             KEY_DOCUMENT_ELEMENT);
                                                                       org.w3c.dom.DOMImplementation domImpl =
                                                                         (org.w3c.dom.DOMImplementation)
                                                                           hints.
                                                                           get(
                                                                             KEY_DOM_IMPLEMENTATION);
                                                                       if (parserClassname ==
                                                                             null) {
                                                                           parserClassname =
                                                                             org.apache.batik.util.XMLResourceDescriptor.
                                                                               getXMLParserClassName(
                                                                                 );
                                                                       }
                                                                       if (domImpl ==
                                                                             null) {
                                                                           handler.
                                                                             fatalError(
                                                                               new org.apache.batik.transcoder.TranscoderException(
                                                                                 "Unspecified transcoding hints: KEY_DOM_IMPLEMENTATION"));
                                                                           return;
                                                                       }
                                                                       if (namespaceURI ==
                                                                             null) {
                                                                           handler.
                                                                             fatalError(
                                                                               new org.apache.batik.transcoder.TranscoderException(
                                                                                 ("Unspecified transcoding hints: KEY_DOCUMENT_ELEMENT_NAMESPAC" +
                                                                                  "E_URI")));
                                                                           return;
                                                                       }
                                                                       if (documentElement ==
                                                                             null) {
                                                                           handler.
                                                                             fatalError(
                                                                               new org.apache.batik.transcoder.TranscoderException(
                                                                                 "Unspecified transcoding hints: KEY_DOCUMENT_ELEMENT"));
                                                                           return;
                                                                       }
                                                                       org.apache.batik.dom.util.DocumentFactory f =
                                                                         createDocumentFactory(
                                                                           domImpl,
                                                                           parserClassname);
                                                                       boolean b =
                                                                         ((java.lang.Boolean)
                                                                            hints.
                                                                            get(
                                                                              KEY_XML_PARSER_VALIDATING)).
                                                                         booleanValue(
                                                                           );
                                                                       f.
                                                                         setValidating(
                                                                           b);
                                                                       try {
                                                                           if (input.
                                                                                 getInputStream(
                                                                                   ) !=
                                                                                 null) {
                                                                               document =
                                                                                 f.
                                                                                   createDocument(
                                                                                     namespaceURI,
                                                                                     documentElement,
                                                                                     input.
                                                                                       getURI(
                                                                                         ),
                                                                                     input.
                                                                                       getInputStream(
                                                                                         ));
                                                                           }
                                                                           else
                                                                               if (input.
                                                                                     getReader(
                                                                                       ) !=
                                                                                     null) {
                                                                                   document =
                                                                                     f.
                                                                                       createDocument(
                                                                                         namespaceURI,
                                                                                         documentElement,
                                                                                         input.
                                                                                           getURI(
                                                                                             ),
                                                                                         input.
                                                                                           getReader(
                                                                                             ));
                                                                               }
                                                                               else
                                                                                   if (input.
                                                                                         getXMLReader(
                                                                                           ) !=
                                                                                         null) {
                                                                                       document =
                                                                                         f.
                                                                                           createDocument(
                                                                                             namespaceURI,
                                                                                             documentElement,
                                                                                             input.
                                                                                               getURI(
                                                                                                 ),
                                                                                             input.
                                                                                               getXMLReader(
                                                                                                 ));
                                                                                   }
                                                                                   else
                                                                                       if (uri !=
                                                                                             null) {
                                                                                           document =
                                                                                             f.
                                                                                               createDocument(
                                                                                                 namespaceURI,
                                                                                                 documentElement,
                                                                                                 uri);
                                                                                       }
                                                                       }
                                                                       catch (org.w3c.dom.DOMException ex) {
                                                                           handler.
                                                                             fatalError(
                                                                               new org.apache.batik.transcoder.TranscoderException(
                                                                                 ex));
                                                                       }
                                                                       catch (java.io.IOException ex) {
                                                                           handler.
                                                                             fatalError(
                                                                               new org.apache.batik.transcoder.TranscoderException(
                                                                                 ex));
                                                                       }
                                                                   }
                                                                   if (document !=
                                                                         null) {
                                                                       try {
                                                                           transcode(
                                                                             document,
                                                                             uri,
                                                                             output);
                                                                       }
                                                                       catch (org.apache.batik.transcoder.TranscoderException ex) {
                                                                           handler.
                                                                             fatalError(
                                                                               ex);
                                                                           return;
                                                                       }
                                                                   }
    }
    protected org.apache.batik.dom.util.DocumentFactory createDocumentFactory(org.w3c.dom.DOMImplementation domImpl,
                                                                              java.lang.String parserClassname) {
        return new org.apache.batik.dom.util.SAXDocumentFactory(
          domImpl,
          parserClassname);
    }
    protected abstract void transcode(org.w3c.dom.Document document,
                                      java.lang.String uri,
                                      org.apache.batik.transcoder.TranscoderOutput output)
          throws org.apache.batik.transcoder.TranscoderException;
    public static final org.apache.batik.transcoder.TranscodingHints.Key
      KEY_XML_PARSER_CLASSNAME =
      new org.apache.batik.transcoder.keys.StringKey(
      );
    public static final org.apache.batik.transcoder.TranscodingHints.Key
      KEY_XML_PARSER_VALIDATING =
      new org.apache.batik.transcoder.keys.BooleanKey(
      );
    public static final org.apache.batik.transcoder.TranscodingHints.Key
      KEY_DOCUMENT_ELEMENT =
      new org.apache.batik.transcoder.keys.StringKey(
      );
    public static final org.apache.batik.transcoder.TranscodingHints.Key
      KEY_DOCUMENT_ELEMENT_NAMESPACE_URI =
      new org.apache.batik.transcoder.keys.StringKey(
      );
    public static final org.apache.batik.transcoder.TranscodingHints.Key
      KEY_DOM_IMPLEMENTATION =
      new org.apache.batik.transcoder.keys.DOMImplementationKey(
      );
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "PNO0HQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "/7Ov/1512vH/ADF5eHIZKQAA");
}
