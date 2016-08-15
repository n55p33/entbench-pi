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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "eDx25YsdEY337yoEXTOOrYTnaSvonh4jgrFZWnzMKjd17Hidg6EyslIMpdRs" +
       "CNAbr7ZpFtDK2fVA1cBrdSwvQ+ZVIpfn22OcdU5i801GmkSdgv3XqmIOuZpH" +
       "iFGb75KiQEUxONKWmsHt/63/gf2xEiGr4TltGfHUTSAIT00hbPI+GJlmcyrB" +
       "0We7CitVWIaZ6nGLZQocexabr3FxflgaBPDn45zgJWxecO9o7DjsmPLMf8OU" +
       "eXByyesyPOTNKLqlN2+WxeeO1ldPP7rpNzzlFW5/J0LySudk2X0Mcb1XajpN" +
       "S1y3ieahRONfrzIyawzIY5C1Cj+4Gq+Y885BZPvnwVGEf7vp3gAODh2cWswX" +
       "N8nPGakAEnz9hWZ7MTQWDhcbLB/wVioFPzVdz0+u4mahB7H5fyl2Xs6Z/6Yk" +
       "xdNHN3Q+eOUzz5h3SKIs7NiBXCYkSJV5nVXI7fPLcrN5VbYvuTrp+ZpFNmBO" +
       "NgV29sssFypE4EXTitKW5zjv+lON398kxQvHH3jrwIxjzUEyIU7GA0jTPD8P" +
       "rx1Veqg4rA+QOsmI5SWDARdJkOOkOqdI23M0nkqQSRhbAmIWF9jSs67Qi1eD" +
       "UJsXJ5/iC9VaWR2h+ho1p6R4GQIFktPj+ffFrltymuab4PQUbDy1WPekuPar" +
       "9T/e31ixDvaHRx03+yojN1ioidx/yDhFUgM2R/JmWgzcp/HrqgA2NdxDpi8u" +
       "uqkqQCd/dwC6s1LK3x2E5JiRhjKefkzHsNY9mokP2LzrG78G463WeP4/H8TW" +
       "SrQdAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "96vTjv8H5susexkpAAA=");
}
