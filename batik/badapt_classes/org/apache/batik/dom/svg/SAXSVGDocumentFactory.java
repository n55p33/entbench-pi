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
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "3kJLZS/37wf5Ld4d/x8s7oiqJi4AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "UaXdH05mqekK+BY211zNz1bjsKlRGB5nsZ64cBZ1Q0mw2iIST3lupCn8boj2" +
       "KXG80JGeak9UAZoQQqwRcqQ1B3jPdUdTP3OpzDOaRnU4aHImIS02nKIa7aDF" +
       "iUvbG286wCG4Picv214Ci1XWcAhm6aSr2NiOEGKx2krzjtNPuPWExDqNaQ3W" +
       "x7Jg4TIURbsRxow6gM84W/VaVWNq0D5JrA047/FjGZNyMKo1wsjCBpSvVsZw" +
       "O5/yOW+5zbhluGwer5EwRhYI1p3gGDXcTXbjnpKbvfo0UVtovUd3FbybRT1c" +
       "DDp813ZXGOGvKG3XitsGua3mGGz2Ym0Ix0POw3aoIVYhbODPZGYZuw2o0SDt" +
       "2iTPmcZilKzbFL9CTdJCB4m0FkLCmnQYzKzSRJpAPaaxhDFhLEJVk1xDEDTZ" +
       "9KE1P5u3FsmUXtcyT5aW6UxaUH6jPyOX1UiaJyOmj7khGjbYOQ3m5KyukzPS" +
       "iXWXq2ZpNWKrVasH1vjdrEHWvd0MXA2ymibOTCPB47BpjKvEhJmri1Zccxk/" +
       "QXezubRuKojm8i26pmEG3JpCUBY11W5PkTQIJvUUp0iTX0EmYY8dKPZacSvh" +
       "SX41g00k7CLKVKNpxMt4AWu4JrZsQqzHOtEG6aZeG6cJtNlGyG1f3uwkeLGp" +
       "IYy0UaZJY6R4vNSfDUjaqZKKAqX4bFP1OKztxtUZIkGzKK/uRtSiqqQjGcGz" +
       "eM0TDY2ynRYzYuX1QgksebJNdWyFCvOVBE/FbK1qzRm6qIueH+Jc2JSoamu9" +
       "1eJ2ixIFPDV3U3PXjCPJbWw8CYXq6oCTeKpRa2RSC150JJpWodESGo7aq04K" +
       "dRr+CA84psfv3MgU7UnYhbf+BN14ogTVxZEVCu0e7Mw3DY3QZQ8zlmynIyLr" +
       "KpfxuLhGO3NxO2QbbMgu0/pMkcTmRlcWI3/Q8v3cqmo7S3M6G7g34Haul2x1" +
       "D9lkQ5lA1zMFUt0+mnpCA/RDongDRGc0686D3ShvUSBm4SJ1JjS4aWQnpkd0" +
       "0yXd0neNzbw9Eud4Cs1JJ1eXCxBrCPM4izypm3TiEeFWGYQeNFFZhP1tM8fq" +
       "vMNlZt+UqMwyO5LAsRoISCJvvelMB7DMtsYA8iwAY85xDhlR2mYxB+Y0HblM" +
       "Hi6XrFNrrAVIXc6FXqqzVENAWpsFuhF43a1O/a2j2ls7l1cbr4NP3ZRYqISE" +
       "KzDsK7XY20rVOkxv4GzLW4anjWHK6bOtXLWaQl1HZvYIjiRm1t8ajZW6E112" +
       "uiYC0dmZ3W6PnGHpiEZWHRbrksLW5EREGs4CehVUsdGWAEv/fB4xc8S0qsUo" +
       "kGgLn2c5YcVqPxg6wbCvD/pLrm4hVBXE6V7NysbryPA6VSQdAxuCLCFI+kwt" +
       "8mpEtS6QvoVwaGsGocNBf2d17R3c6cNutT/mRhHFDND6mNfiUayt0Fx21k44" +
       "xWboqs2uF26f32bdOoqOqjI2sa2quRiavBOYIyP1+wqU92YhjLbHCjzw+aAv" +
       "ytCMJXUZW7rkpNNQxZnd1zDL11N41pRbOI6vRcqPTK7rNma1sZguMGLTo8Gu" +
       "cCtHc8UE68aKoaF26PRWI6GtWblk9xMEp5ExF1lWqJOrYUaFwm6uzFpJp5G3" +
       "VjWIIOlwRVqt6rq5nKhdYcckzVQye5rloYy7clYC5fJjg9/aCjdTMafdSvN2" +
       "rmpZZIcxPOdikXIFIe0vei4q7bbraTVUpooS27U2K+pzDIwL1awt1hsuyYde" +
       "z+FaeDdujLKBEdWjXUOz5XUKG00CWTkIWmdQXmYziabImMZ7XcRbtKFl2o9p" +
       "YiuYPKzwbbXpwsJWxSxFRuBUH9SZzKxiSxVqgJ1/jI12kDFboXaKzEx+G0oI" +
       "2bRmtNOxF8HAot1ESbk4JmOlLpErtS0wdVtXhKWN4Qy1WTfDNhvWhoQDkXgf" +
       "hVlxukjiXKgGg74rQds5cNDJTnEk0zfmYA8wyxvoTmFoDwRb9gSd7OpBZ9fz" +
       "qz0JJji6KUt2xtG+xUADvwkP1qY39o1sYtUgGFnT7EKAkHZmNlm9oUM5GrV9" +
       "e0PbjU6n8973Fn9X/dqd/Y32ePnv4Mmh");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("u7/G/4L5ZQ/cy8/9laMDWsffZ/5hPfP49uRoRPXWR5cunFsqnmM/e6vzd+Uz" +
       "7C9+/JUv6NzP1q8cPW4m48pDsR+82zFSwznT/SOgpXfe+unxsDx+ePoI99c/" +
       "/t+fEd+3/PAdnGZ6/hzO803+4+GXfnPwA9qPXancc/JA98LByJsrXb/5Me7D" +
       "oREnoSfe9DD32ZPReKpQ/jtAevloNF4+/3/36XhfsJyD0nL29nLuaf7BqUCt" +
       "FPiPlwscD/D+1IztH1IckWtGUOitrPcHRfZ7wBq10FBi48xwH1d9c2EbGaJd" +
       "ZhKndvr7d3KEoCz4dxeV9IkjJX3i7ijpprMkFxThBUksxIC1W1b+5q01/PVS" +
       "4E+L7L9epqnixn86VcUf3Q1VfPZIFZ/9/qni0WNVTAylOFNUFP/v22nhL4vs" +
       "f7wGLXzne9DCG4vCt4L0U0da+Knvz6w5eOA2dA8eKrIrQFd7uufnxhvPzo0L" +
       "k+Lgnruhg68d6eBrd98SiuxPSp5P3k4RTxXZ1QuKKEpfd0r48btB+DtHhL/z" +
       "/SH8FyWfF29H+G1F9pbbEX72LhA+eMO+7v77eyd8z2nYUTvNSlLvvh1rqMje" +
       "cTvWL90N1teOWF+7O6zvLQXuPcf61MKx21G/XmSN21Fv3g3qRye7Di6c7Lrb" +
       "1Pe2/ipucE99UGQfuB31zvdA/dmiEESiB+87ov6+u0P9gkcfnxM4c+zxQCgy" +
       "Fnhty4h73JByA8coeJ5GkcClP3uTS79UqtTG8HvQRnme9vlKcYxxrw327mjj" +
       "LNkbrx4QPl3QzF3nMFLy4v2Em6LCA6XIFnHl9SDmDeObFrbzT/dT/+jASqmV" +
       "D36vsQ/wBgfTI61M745Wzi8Ae0MJbmlJB2opUJwrPVgDHYT797EIL7bj7bH+" +
       "njqrv30suT/sdaIK544O1caVJy99S6Q48v70hXfS9u9Rab/0hccefOoL0u+X" +
       "L0qcvOv0EFt50Ewc5+xh0zPX9wehYdqlph7aHz0NSr4vHxnFZdvAuHIPyAvU" +
       "B7u99A8dBT/npYEkyM9KfiyuXD0vGVfuK7/Pyv3duPLwqVxcuX9/cVbkk6B1" +
       "IFJcfio4Hol3XQq6PP4DNHp+87qfAE+ftcAyXH3idqN1UuXsuxjFnrV8r/B4" +
       "f5ns3yy8oX35C/To5W+3fnb/LojmKLtd0cqDbOWB/WspZaPFHvXFW7Z23Nb9" +
       "5EvfffQrD739eD/96B7w6Ww4g+35y1+8INwgLl+V2P2zp/7pe37uC18vDwH9" +
       "Pxb+6yzwOQAA");
}
