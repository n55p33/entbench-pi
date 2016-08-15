package org.apache.batik.dom.svg;
public class SAXSVGDocumentFactory extends org.apache.batik.dom.util.SAXDocumentFactory implements org.apache.batik.dom.svg.SVGDocumentFactory {
    public static final java.lang.Object LOCK = new java.lang.Object();
    public static final java.lang.String KEY_PUBLIC_IDS = "publicIds";
    public static final java.lang.String KEY_SKIPPABLE_PUBLIC_IDS = "skippablePublicIds";
    public static final java.lang.String KEY_SKIP_DTD = "skipDTD";
    public static final java.lang.String KEY_SYSTEM_ID = "systemId.";
    protected static final java.lang.String DTDIDS = "org.apache.batik.dom.svg.resources.dtdids";
    protected static final java.lang.String HTTP_CHARSET = "charset";
    protected static java.lang.String dtdids;
    protected static java.lang.String skippable_dtdids;
    protected static java.lang.String skip_dtd;
    protected static java.util.Properties dtdProps;
    public SAXSVGDocumentFactory(java.lang.String parser) { super(org.apache.batik.dom.svg.SVGDOMImplementation.
                                                                    getDOMImplementation(
                                                                      ),
                                                                  parser);
    }
    public SAXSVGDocumentFactory(java.lang.String parser,
                                 boolean dd) { super(org.apache.batik.dom.svg.SVGDOMImplementation.
                                                       getDOMImplementation(
                                                         ),
                                                     parser,
                                                     dd);
    }
    public org.w3c.dom.svg.SVGDocument createSVGDocument(java.lang.String uri)
          throws java.io.IOException { return (org.w3c.dom.svg.SVGDocument)
                                                createDocument(
                                                  uri);
    }
    public org.w3c.dom.svg.SVGDocument createSVGDocument(java.lang.String uri,
                                                         java.io.InputStream inp)
          throws java.io.IOException { return (org.w3c.dom.svg.SVGDocument)
                                                createDocument(
                                                  uri,
                                                  inp);
    }
    public org.w3c.dom.svg.SVGDocument createSVGDocument(java.lang.String uri,
                                                         java.io.Reader r)
          throws java.io.IOException { return (org.w3c.dom.svg.SVGDocument)
                                                createDocument(
                                                  uri,
                                                  r);
    }
    public org.w3c.dom.Document createDocument(java.lang.String uri)
          throws java.io.IOException { org.apache.batik.util.ParsedURL purl =
                                         new org.apache.batik.util.ParsedURL(
                                         uri);
                                       java.io.InputStream is =
                                         purl.
                                         openStream(
                                           org.apache.batik.util.MimeTypeConstants.
                                             MIME_TYPES_SVG);
                                       org.xml.sax.InputSource isrc =
                                         new org.xml.sax.InputSource(
                                         is);
                                       java.lang.String contentType =
                                         purl.
                                         getContentType(
                                           );
                                       int cindex =
                                         -1;
                                       if (contentType !=
                                             null) {
                                           contentType =
                                             contentType.
                                               toLowerCase(
                                                 );
                                           cindex =
                                             contentType.
                                               indexOf(
                                                 HTTP_CHARSET);
                                       }
                                       java.lang.String charset =
                                         null;
                                       if (cindex !=
                                             -1) {
                                           int i =
                                             cindex +
                                             HTTP_CHARSET.
                                             length(
                                               );
                                           int eqIdx =
                                             contentType.
                                             indexOf(
                                               '=',
                                               i);
                                           if (eqIdx !=
                                                 -1) {
                                               eqIdx++;
                                               int idx =
                                                 contentType.
                                                 indexOf(
                                                   ',',
                                                   eqIdx);
                                               int semiIdx =
                                                 contentType.
                                                 indexOf(
                                                   ';',
                                                   eqIdx);
                                               if (semiIdx !=
                                                     -1 &&
                                                     (semiIdx <
                                                        idx ||
                                                        idx ==
                                                        -1))
                                                   idx =
                                                     semiIdx;
                                               if (idx !=
                                                     -1)
                                                   charset =
                                                     contentType.
                                                       substring(
                                                         eqIdx,
                                                         idx);
                                               else
                                                   charset =
                                                     contentType.
                                                       substring(
                                                         eqIdx);
                                               charset =
                                                 charset.
                                                   trim(
                                                     );
                                               isrc.
                                                 setEncoding(
                                                   charset);
                                           }
                                       }
                                       isrc.
                                         setSystemId(
                                           uri);
                                       org.apache.batik.dom.svg.SVGOMDocument doc =
                                         (org.apache.batik.dom.svg.SVGOMDocument)
                                           super.
                                           createDocument(
                                             org.apache.batik.dom.svg.SVGDOMImplementation.
                                               SVG_NAMESPACE_URI,
                                             "svg",
                                             uri,
                                             isrc);
                                       doc.
                                         setParsedURL(
                                           purl);
                                       doc.
                                         setDocumentInputEncoding(
                                           charset);
                                       doc.
                                         setXmlStandalone(
                                           isStandalone);
                                       doc.
                                         setXmlVersion(
                                           xmlVersion);
                                       return doc;
    }
    public org.w3c.dom.Document createDocument(java.lang.String uri,
                                               java.io.InputStream inp)
          throws java.io.IOException { org.w3c.dom.Document doc;
                                       org.xml.sax.InputSource is =
                                         new org.xml.sax.InputSource(
                                         inp);
                                       is.
                                         setSystemId(
                                           uri);
                                       try {
                                           doc =
                                             super.
                                               createDocument(
                                                 org.apache.batik.dom.svg.SVGDOMImplementation.
                                                   SVG_NAMESPACE_URI,
                                                 "svg",
                                                 uri,
                                                 is);
                                           if (uri !=
                                                 null) {
                                               ((org.apache.batik.dom.svg.SVGOMDocument)
                                                  doc).
                                                 setParsedURL(
                                                   new org.apache.batik.util.ParsedURL(
                                                     uri));
                                           }
                                           org.apache.batik.dom.AbstractDocument d =
                                             (org.apache.batik.dom.AbstractDocument)
                                               doc;
                                           d.
                                             setDocumentURI(
                                               uri);
                                           d.
                                             setXmlStandalone(
                                               isStandalone);
                                           d.
                                             setXmlVersion(
                                               xmlVersion);
                                       }
                                       catch (java.net.MalformedURLException e) {
                                           throw new java.io.IOException(
                                             e.
                                               getMessage(
                                                 ));
                                       }
                                       return doc;
    }
    public org.w3c.dom.Document createDocument(java.lang.String uri,
                                               java.io.Reader r)
          throws java.io.IOException { org.w3c.dom.Document doc;
                                       org.xml.sax.InputSource is =
                                         new org.xml.sax.InputSource(
                                         r);
                                       is.
                                         setSystemId(
                                           uri);
                                       try {
                                           doc =
                                             super.
                                               createDocument(
                                                 org.apache.batik.dom.svg.SVGDOMImplementation.
                                                   SVG_NAMESPACE_URI,
                                                 "svg",
                                                 uri,
                                                 is);
                                           if (uri !=
                                                 null) {
                                               ((org.apache.batik.dom.svg.SVGOMDocument)
                                                  doc).
                                                 setParsedURL(
                                                   new org.apache.batik.util.ParsedURL(
                                                     uri));
                                           }
                                           org.apache.batik.dom.AbstractDocument d =
                                             (org.apache.batik.dom.AbstractDocument)
                                               doc;
                                           d.
                                             setDocumentURI(
                                               uri);
                                           d.
                                             setXmlStandalone(
                                               isStandalone);
                                           d.
                                             setXmlVersion(
                                               xmlVersion);
                                       }
                                       catch (java.net.MalformedURLException e) {
                                           throw new java.io.IOException(
                                             e.
                                               getMessage(
                                                 ));
                                       }
                                       return doc;
    }
    public org.w3c.dom.Document createDocument(java.lang.String ns,
                                               java.lang.String root,
                                               java.lang.String uri)
          throws java.io.IOException { if (!org.apache.batik.dom.svg.SVGDOMImplementation.
                                              SVG_NAMESPACE_URI.
                                             equals(
                                               ns) ||
                                             !"svg".
                                             equals(
                                               root)) {
                                           throw new java.lang.RuntimeException(
                                             "Bad root element");
                                       }
                                       return createDocument(
                                                uri);
    }
    public org.w3c.dom.Document createDocument(java.lang.String ns,
                                               java.lang.String root,
                                               java.lang.String uri,
                                               java.io.InputStream is)
          throws java.io.IOException { if (!org.apache.batik.dom.svg.SVGDOMImplementation.
                                              SVG_NAMESPACE_URI.
                                             equals(
                                               ns) ||
                                             !"svg".
                                             equals(
                                               root)) {
                                           throw new java.lang.RuntimeException(
                                             "Bad root element");
                                       }
                                       return createDocument(
                                                uri,
                                                is);
    }
    public org.w3c.dom.Document createDocument(java.lang.String ns,
                                               java.lang.String root,
                                               java.lang.String uri,
                                               java.io.Reader r)
          throws java.io.IOException { if (!org.apache.batik.dom.svg.SVGDOMImplementation.
                                              SVG_NAMESPACE_URI.
                                             equals(
                                               ns) ||
                                             !"svg".
                                             equals(
                                               root)) {
                                           throw new java.lang.RuntimeException(
                                             "Bad root element");
                                       }
                                       return createDocument(
                                                uri,
                                                r);
    }
    public org.w3c.dom.DOMImplementation getDOMImplementation(java.lang.String ver) {
        if (ver ==
              null ||
              ver.
              length(
                ) ==
              0 ||
              ver.
              equals(
                "1.0") ||
              ver.
              equals(
                "1.1")) {
            return org.apache.batik.dom.svg.SVGDOMImplementation.
              getDOMImplementation(
                );
        }
        else
            if (ver.
                  equals(
                    "1.2")) {
                return org.apache.batik.dom.svg12.SVG12DOMImplementation.
                  getDOMImplementation(
                    );
            }
        throw new java.lang.RuntimeException(
          "Unsupport SVG version \'" +
          ver +
          "\'");
    }
    public void startDocument() throws org.xml.sax.SAXException {
        super.
          startDocument(
            );
    }
    public org.xml.sax.InputSource resolveEntity(java.lang.String publicId,
                                                 java.lang.String systemId)
          throws org.xml.sax.SAXException {
        try {
            synchronized (LOCK)  {
                if (dtdProps ==
                      null) {
                    dtdProps =
                      new java.util.Properties(
                        );
                    try {
                        java.lang.Class cls =
                          org.apache.batik.dom.svg.SAXSVGDocumentFactory.class;
                        java.io.InputStream is =
                          cls.
                          getResourceAsStream(
                            "resources/dtdids.properties");
                        dtdProps.
                          load(
                            is);
                    }
                    catch (java.io.IOException ioe) {
                        throw new org.xml.sax.SAXException(
                          ioe);
                    }
                }
                if (dtdids ==
                      null)
                    dtdids =
                      dtdProps.
                        getProperty(
                          KEY_PUBLIC_IDS);
                if (skippable_dtdids ==
                      null)
                    skippable_dtdids =
                      dtdProps.
                        getProperty(
                          KEY_SKIPPABLE_PUBLIC_IDS);
                if (skip_dtd ==
                      null)
                    skip_dtd =
                      dtdProps.
                        getProperty(
                          KEY_SKIP_DTD);
            }
            if (publicId ==
                  null)
                return null;
            if (!isValidating &&
                  skippable_dtdids.
                  indexOf(
                    publicId) !=
                  -1) {
                return new org.xml.sax.InputSource(
                  new java.io.StringReader(
                    skip_dtd));
            }
            if (dtdids.
                  indexOf(
                    publicId) !=
                  -1) {
                java.lang.String localSystemId =
                  dtdProps.
                  getProperty(
                    KEY_SYSTEM_ID +
                    publicId.
                      replace(
                        ' ',
                        '_'));
                if (localSystemId !=
                      null &&
                      !"".
                      equals(
                        localSystemId)) {
                    return new org.xml.sax.InputSource(
                      getClass(
                        ).
                        getResource(
                          localSystemId).
                        toString(
                          ));
                }
            }
        }
        catch (java.util.MissingResourceException e) {
            throw new org.xml.sax.SAXException(
              e);
        }
        return null;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "ewstlb3cvx/kt3h3/H+aVYemJi4AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "VXlmuH2rTpLk+95X/F31G3f2N9rj5b+D");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("J4fu/gb/C2aXPXAvP/dXjg5oHX+f+Yf1zOPbk6MR1VsfXbpwbql4jv3src7f" +
       "lc+wv/CxVz6/GP08fOXocXMvqTyU+MF7HGNjOGe6fwS09K5bPz3myuOHp49w" +
       "f/Nj/+0Z6f2rD9/Baabnz+E83+Q/4r74293v03/sSuWekwe6Fw5G3lzp+s2P" +
       "cR+OjCSNPOmmh7nPnozGU4Xy3wnSy0ej8fL5/7tPx/uC5RyUlrO3l3NP8w9O" +
       "BWqlwH+4XOB4gPenZiz/kBnRmW4Ehd7Ken9UZH8ArFGPDDUxzgz3cdU3F7ax" +
       "RfXLTOLUTv/wTo4QlAX/9qKSPn6kpI/fHSXddJbkgiK8IE3EBLB2y8rfuLWG" +
       "v1YK/Pci+y+Xaaq48R9PVfEnd0MVnzlSxWe+d6p49FgVY0MtzhQVxf/7dlr4" +
       "qyL7H69BC9/+LrTwxqLwbSD99JEWfvp7M2sOHrgN3YOHiuwK0NWe7vm58caz" +
       "c+PCpDi4527o4KtHOvjq3beEIvuzkueTt1PEU0V29YIiitLXnRJ+/G4Q/vYR" +
       "4W9/bwj/ZcnnhdsRfnuRveV2hJ+9C4QP3rCvu//+7gnfcxp21E6zktR7bsca" +
       "KrJ33o71i3eD9bUj1tfuDut7S4F7z7E+tfDm7ahfL7L67ahjd4P60cmugwsn" +
       "u+429b2tv4ob3FPvFtlLt6NOfhfUny0KQSR68P4j6u+/O9QveHThnMCZY48H" +
       "YpGxwGsvjYQacYwbOEbB8zSKBC792Ztc+qVSpTa470Ib5Xna5yvFMca9Nti7" +
       "o42zZG+8ekD4dEEzc53DWM2K9xNuigoP1CKbJ5XXg5g3Sm5a2M4/3d/4RwdW" +
       "Sq188LuNfYA3OFCOtKLcHa2cXwD2hhLc0pIOtFKgOFd6YAMdRPv3sWgvsZLd" +
       "sf6eOqu/fSy5P+x1ogrnjg7VJpUnL31LpDjy/vSFd9L271Hpv/L5xx586vOT" +
       "PyxflDh51+khtvKgmTrO2cOmZ67vDyLDtEpNPbQ/ehqUfF8+MorLtoFJ5R6Q" +
       "F6gP8r30DxwFP+elgSTIz0p+NKlcPS+ZVO4rv8/K/XBSefhULqncv784K/IJ" +
       "0DoQKS4/GRyPxLsvBV0e/wEaPb953U+Ap89aYBmuPnG70TqpcvZdjGLPWr5X" +
       "eLy/TPdvFt7Qv/T5/vDlbzV+fv8uiO6oeV608iBbeWD/WkrZaLFHfeGWrR23" +
       "dX/vxe88+uWH3nG8n350D/h0NpzB9vzlL17QbpCUr0rk//Spf/LeX/j818pD" +
       "QP8PD5Nv3PA5AAA=");
}
