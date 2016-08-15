package org.apache.batik.apps.svgbrowser;
public class XMLInputHandler implements org.apache.batik.apps.svgbrowser.SquiggleInputHandler {
    public static final java.lang.String[] XVG_MIME_TYPES = { "image/xml+xsl+svg" };
    public static final java.lang.String[] XVG_FILE_EXTENSIONS = { ".xml",
    ".xsl" };
    public static final java.lang.String ERROR_NO_XML_STYLESHEET_PROCESSING_INSTRUCTION =
      ("XMLInputHandler.error.no.xml.stylesheet.processing.instructi" +
       "on");
    public static final java.lang.String ERROR_TRANSFORM_OUTPUT_NOT_SVG =
      "XMLInputHandler.error.transform.output.not.svg";
    public static final java.lang.String ERROR_TRANSFORM_PRODUCED_NO_CONTENT =
      "XMLInputHandler.error.transform.produced.no.content";
    public static final java.lang.String ERROR_TRANSFORM_OUTPUT_WRONG_NS =
      "XMLInputHandler.error.transform.output.wrong.ns";
    public static final java.lang.String ERROR_RESULT_GENERATED_EXCEPTION =
      "XMLInputHandler.error.result.generated.exception";
    public static final java.lang.String XSL_PROCESSING_INSTRUCTION_TYPE =
      "text/xsl";
    public static final java.lang.String PSEUDO_ATTRIBUTE_TYPE = "type";
    public static final java.lang.String PSEUDO_ATTRIBUTE_HREF = "href";
    public java.lang.String[] getHandledMimeTypes() { return XVG_MIME_TYPES;
    }
    public java.lang.String[] getHandledExtensions() { return XVG_FILE_EXTENSIONS;
    }
    public java.lang.String getDescription() { return "";
    }
    public boolean accept(java.io.File f) { return f.isFile(
                                                       ) &&
                                              accept(
                                                f.
                                                  getPath(
                                                    )); }
    public boolean accept(org.apache.batik.util.ParsedURL purl) {
        if (purl ==
              null) {
            return false;
        }
        java.lang.String path =
          purl.
          getPath(
            );
        return accept(
                 path);
    }
    public boolean accept(java.lang.String path) { if (path ==
                                                         null) {
                                                       return false;
                                                   }
                                                   for (int i =
                                                          0;
                                                        i <
                                                          XVG_FILE_EXTENSIONS.
                                                            length;
                                                        i++) {
                                                       if (path.
                                                             endsWith(
                                                               XVG_FILE_EXTENSIONS[i])) {
                                                           return true;
                                                       }
                                                   }
                                                   return false;
    }
    public void handle(org.apache.batik.util.ParsedURL purl,
                       org.apache.batik.apps.svgbrowser.JSVGViewerFrame svgViewerFrame)
          throws java.lang.Exception { java.lang.String uri =
                                         purl.
                                         toString(
                                           );
                                       javax.xml.transform.TransformerFactory tFactory =
                                         javax.xml.transform.TransformerFactory.
                                         newInstance(
                                           );
                                       javax.xml.parsers.DocumentBuilderFactory dbf =
                                         javax.xml.parsers.DocumentBuilderFactory.
                                         newInstance(
                                           );
                                       dbf.
                                         setValidating(
                                           false);
                                       dbf.
                                         setNamespaceAware(
                                           true);
                                       javax.xml.parsers.DocumentBuilder db =
                                         dbf.
                                         newDocumentBuilder(
                                           );
                                       org.w3c.dom.Document inDoc =
                                         db.
                                         parse(
                                           uri);
                                       java.lang.String xslStyleSheetURI =
                                         extractXSLProcessingInstruction(
                                           inDoc);
                                       if (xslStyleSheetURI ==
                                             null) {
                                           xslStyleSheetURI =
                                             uri;
                                       }
                                       org.apache.batik.util.ParsedURL parsedXSLStyleSheetURI =
                                         new org.apache.batik.util.ParsedURL(
                                         uri,
                                         xslStyleSheetURI);
                                       javax.xml.transform.Transformer transformer =
                                         tFactory.
                                         newTransformer(
                                           new javax.xml.transform.stream.StreamSource(
                                             parsedXSLStyleSheetURI.
                                               toString(
                                                 )));
                                       transformer.
                                         setURIResolver(
                                           new org.apache.batik.apps.svgbrowser.XMLInputHandler.DocumentURIResolver(
                                             parsedXSLStyleSheetURI.
                                               toString(
                                                 )));
                                       java.io.StringWriter sw =
                                         new java.io.StringWriter(
                                         );
                                       javax.xml.transform.stream.StreamResult result =
                                         new javax.xml.transform.stream.StreamResult(
                                         sw);
                                       transformer.
                                         transform(
                                           new javax.xml.transform.dom.DOMSource(
                                             inDoc),
                                           result);
                                       sw.
                                         flush(
                                           );
                                       sw.
                                         close(
                                           );
                                       java.lang.String parser =
                                         org.apache.batik.util.XMLResourceDescriptor.
                                         getXMLParserClassName(
                                           );
                                       org.apache.batik.dom.svg.SAXSVGDocumentFactory f =
                                         new org.apache.batik.dom.svg.SAXSVGDocumentFactory(
                                         parser);
                                       org.w3c.dom.svg.SVGDocument outDoc =
                                         null;
                                       try {
                                           outDoc =
                                             f.
                                               createSVGDocument(
                                                 uri,
                                                 new java.io.StringReader(
                                                   sw.
                                                     toString(
                                                       )));
                                       }
                                       catch (java.lang.Exception e) {
                                           java.lang.System.
                                             err.
                                             println(
                                               "======================================");
                                           java.lang.System.
                                             err.
                                             println(
                                               sw.
                                                 toString(
                                                   ));
                                           java.lang.System.
                                             err.
                                             println(
                                               "======================================");
                                           throw new java.lang.IllegalArgumentException(
                                             org.apache.batik.apps.svgbrowser.Resources.
                                               getString(
                                                 ERROR_RESULT_GENERATED_EXCEPTION));
                                       }
                                       svgViewerFrame.
                                         getJSVGCanvas(
                                           ).
                                         setSVGDocument(
                                           outDoc);
                                       svgViewerFrame.
                                         setSVGDocument(
                                           outDoc,
                                           uri,
                                           outDoc.
                                             getTitle(
                                               ));
    }
    protected void checkAndPatch(org.w3c.dom.Document doc) {
        org.w3c.dom.Element root =
          doc.
          getDocumentElement(
            );
        org.w3c.dom.Node realRoot =
          root.
          getFirstChild(
            );
        java.lang.String svgNS =
          org.apache.batik.dom.svg.SVGDOMImplementation.
            SVG_NAMESPACE_URI;
        if (realRoot ==
              null) {
            throw new java.lang.IllegalArgumentException(
              org.apache.batik.apps.svgbrowser.Resources.
                getString(
                  ERROR_TRANSFORM_PRODUCED_NO_CONTENT));
        }
        if (realRoot.
              getNodeType(
                ) !=
              org.w3c.dom.Node.
                ELEMENT_NODE ||
              !org.apache.batik.util.SVGConstants.
                 SVG_SVG_TAG.
              equals(
                realRoot.
                  getLocalName(
                    ))) {
            throw new java.lang.IllegalArgumentException(
              org.apache.batik.apps.svgbrowser.Resources.
                getString(
                  ERROR_TRANSFORM_OUTPUT_NOT_SVG));
        }
        if (!svgNS.
              equals(
                realRoot.
                  getNamespaceURI(
                    ))) {
            throw new java.lang.IllegalArgumentException(
              org.apache.batik.apps.svgbrowser.Resources.
                getString(
                  ERROR_TRANSFORM_OUTPUT_WRONG_NS));
        }
        org.w3c.dom.Node child =
          realRoot.
          getFirstChild(
            );
        while (child !=
                 null) {
            root.
              appendChild(
                child);
            child =
              realRoot.
                getFirstChild(
                  );
        }
        org.w3c.dom.NamedNodeMap attrs =
          realRoot.
          getAttributes(
            );
        int n =
          attrs.
          getLength(
            );
        for (int i =
               0;
             i <
               n;
             i++) {
            root.
              setAttributeNode(
                (org.w3c.dom.Attr)
                  attrs.
                  item(
                    i));
        }
        root.
          removeChild(
            realRoot);
    }
    protected java.lang.String extractXSLProcessingInstruction(org.w3c.dom.Document doc) {
        org.w3c.dom.Node child =
          doc.
          getFirstChild(
            );
        while (child !=
                 null) {
            if (child.
                  getNodeType(
                    ) ==
                  org.w3c.dom.Node.
                    PROCESSING_INSTRUCTION_NODE) {
                org.w3c.dom.ProcessingInstruction pi =
                  (org.w3c.dom.ProcessingInstruction)
                    child;
                org.apache.batik.dom.util.HashTable table =
                  new org.apache.batik.dom.util.HashTable(
                  );
                org.apache.batik.dom.util.DOMUtilities.
                  parseStyleSheetPIData(
                    pi.
                      getData(
                        ),
                    table);
                java.lang.Object type =
                  table.
                  get(
                    PSEUDO_ATTRIBUTE_TYPE);
                if (XSL_PROCESSING_INSTRUCTION_TYPE.
                      equals(
                        type)) {
                    java.lang.Object href =
                      table.
                      get(
                        PSEUDO_ATTRIBUTE_HREF);
                    if (href !=
                          null) {
                        return href.
                          toString(
                            );
                    }
                    else {
                        return null;
                    }
                }
            }
            child =
              child.
                getNextSibling(
                  );
        }
        return null;
    }
    public class DocumentURIResolver implements javax.xml.transform.URIResolver {
        java.lang.String documentURI;
        public DocumentURIResolver(java.lang.String documentURI) {
            super(
              );
            this.
              documentURI =
              documentURI;
        }
        public javax.xml.transform.Source resolve(java.lang.String href,
                                                  java.lang.String base) {
            if (base ==
                  null ||
                  "".
                  equals(
                    base)) {
                base =
                  documentURI;
            }
            org.apache.batik.util.ParsedURL purl =
              new org.apache.batik.util.ParsedURL(
              base,
              href);
            return new javax.xml.transform.stream.StreamSource(
              purl.
                toString(
                  ));
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "f14Q658XTXw8/V8/LuHQaBYAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "G+a3B+kfvOb33vxbz30rr/v9L8zd0L4dIQAA");
    }
    public XMLInputHandler() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1aCXAb1Rl+kmPHceIjzknIRWJoE0AKdxmHw5HlREG2VEl2" +
       "jRNQ1qtna5PV7rL7ZCuhKUfbIYU2Q9NwtAOhMw3lGK4yZXpQaDq0HMMxw9FS" +
       "ygBtoS0tMIV2CrSU0v9/u6tdrbTy2NPUM/u82vf+9/7/+//3H2/3rndIo6GT" +
       "lVRhIbZbo0YoqrCkoBs0F5EFw8jAs6x4Q4Pw94vfHDg7SJpGSFteMPpFwaB9" +
       "EpVzxghZISkGExSRGgOU5pAiqVOD6hMCk1RlhCySjFhBkyVRYv1qjuKAIUGP" +
       "k/kCY7o0WmQ0Zk3AyIo4cBLmnIR7vN3dcTJPVLXdzvClruERVw+OLDhrGYx0" +
       "xHcKE0K4yCQ5HJcM1l3SyYmaKu8el1UWoiUW2imfYUGwNX5GFQRr7mt//6Nr" +
       "8x0cggWCoqiMi2ekqKHKEzQXJ+3O06hMC8Yl5AukIU7mugYz0hW3Fw3DomFY" +
       "1JbWGQXct1KlWIioXBxmz9SkicgQI8dVTqIJulCwpklynmGGZmbJzolB2tVl" +
       "aU0pq0S87sTwwRsu7ri/gbSPkHZJSSM7IjDBYJERAJQWRqlu9ORyNDdC5iug" +
       "7DTVJUGW9lia7jSkcUVgRVC/DQs+LGpU52s6WIEeQTa9KDJVL4s3xg3K+tU4" +
       "JgvjIOtiR1ZTwj58DgK2SMCYPiaA3Vkks3ZJSo6RVV6KsoxdF8AAIJ1doCyv" +
       "lpeapQjwgHSaJiILyng4DaanjMPQRhUMUGdkme+kiLUmiLuEcZpFi/SMS5pd" +
       "MGoOBwJJGFnkHcZnAi0t82jJpZ93Bjbuv1TZogRJAHjOUVFG/ucC0UoPUYqO" +
       "UZ3CPjAJ562PXy8sfmhfkBAYvMgz2Bzzg8+/d/5JK488bo45tsaYxOhOKrKs" +
       "eHi07dnlkXVnNyAbzZpqSKj8Csn5LktaPd0lDTzM4vKM2BmyO4+kHr3w8jvp" +
       "W0HSEiNNoioXC2BH80W1oEky1TdTheoCo7kYmUOVXIT3x8hsuI9LCjWfJsbG" +
       "DMpiZJbMHzWp/DdANAZTIEQtcC8pY6p9rwksz+9LGiFkNlxkI1znEfOP/2dE" +
       "DOfVAg0LoqBIihpO6irKb4TB44wCtvnwKFj9rrChFnUwwbCqj4cFsIM8tToE" +
       "TTPCxsT4qK5OgjcMD/fHY4pWZFsEJQeihdDYtP/PMiWUdsFkIACKWO51AzLs" +
       "oC2qnKN6VjxY3BR9757sk6aJ4bawcGJkA6wcMlcO8ZVDuHLIWTnkWZkEAnzB" +
       "hciBqXXQ2S7Y/eB+561LX7R1x741DWBu2uQsAByHrqkIQxHHRdh+PSve29m6" +
       "57hXT3kkSGbFSacgsqIgY1Tp0cfBX4m7rC09bxQClBMnVrviBAY4XRVpDtyU" +
       "X7ywZmlWJ6iOzxlZ6JrBjmK4X8P+MaQm/+TIjZNXDF22IUiClaEBl2wEr4bk" +
       "SXToZcfd5XUJteZtv+rN9++9fq/qOIeKWGOHyCpKlGGN1yS88GTF9auFB7IP" +
       "7e3isM8B580E2GzgF1d616jwPd22H0dZmkHgMVUvCDJ22Ri3sDzYj/OE2+p8" +
       "bBaZZosm5GGQh4Bz0trNv37mz6dxJO1o0e4K82nKul0eCifr5L5ovmORGZ1S" +
       "GPfKjclvXPfOVdu4OcKItbUW7MI2Ap4JtAMIfvnxS1567dXDLwQdE2YQoouj" +
       "kOmUuCwLP4G/AFz/wQu9Cj4wvUtnxHJxq8s+TsOVT3B4A28ngytA4+gaVMAM" +
       "pTFJGJUp7p9/tx9/ygNv7+8w1S3DE9taTpp6Auf5MZvI5U9e/MFKPk1AxGjr" +
       "4OcMM134AmfmHl0XdiMfpSueW/HNx4SbIRiAAzakPZT7VMLxIFyBZ3AsNvD2" +
       "dE/fWdgcb7htvHIbubKirHjtC++2Dr378Huc28q0yq33fkHrNq3I1AIsdg6x" +
       "mgofj72LNWyXlICHJV5HtUUw8jDZ6UcGtnfIRz6CZUdgWRHcsJHQwV+WKkzJ" +
       "Gt04+zc/e2TxjmcbSLCPtMiqkOsT+IYjc8DSqZEHV1vSzjvf5GOyGZoOjgep" +
       "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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL17eazr2Hmf7pt9PJtnPLYzsWfeeMaxx3IvJYoUpTzbGYoi" +
       "JUqkRHGTRMe5priJ4irukjtZjCQ2GnRqtGPXBeLJP3baBmM7KGq0QJvCRdHG" +
       "QYIACYI2KZA4LVI0qWvA/iNxUSdND6W7vfvue5PrmfYCPJciz/L9vuV3vkMe" +
       "vvbtyj1xVKmGgbux3CA5NIrkcOWih8kmNOLDAYNyahQbOuGqcSyCa0fae371" +
       "0b/4/meWj12r3KtUnlB9P0jUxA78mDfiwM0Mnak8enaVdA0vTiqPMSs1U6E0" +
       "sV2IsePkBlN5y7mmSeV55kQECIgAARGgnQgQflYLNHrY8FOPKFuofhKvKz9Z" +
       "OWAq94ZaKV5SefbmTkI1Ur3jbrgdAtDD/eVvGYDaNS6iyvVT7HvMtwD+bBV6" +
       "5R/+xGP/7K7Ko0rlUdsXSnE0IEQCBlEqD3mGtzCiGNd1Q1cqb/UNQxeMyFZd" +
       "e7uTW6k8HtuWryZpZJwqqbyYhka0G/NMcw9pJbYo1ZIgOoVn2oarn/y6x3RV" +
       "C2B9+xnWPUKqvA4APmgDwSJT1YyTJnc7tq8nlWcutjjF+PwQVABN7/OMZBmc" +
       "DnW3r4ILlcf3tnNV34KEJLJ9C1S9J0jBKEnlqdt2Wuo6VDVHtYyjpPLOi/W4" +
       "/S1Q64GdIsomSeXJi9V2PQErPXXBSufs8+3Rh17+hN/3r+1k1g3NLeW/HzR6" +
       "+kIj3jCNyPA1Y9/woQ8wn1Pf/mufvlapgMpPXqi8r/Mv/vZ3X/zg01//xr7O" +
       "D19SZ7xYGVpypH1x8cjvvIt4oX1XKcb9YRDbpfFvQr5zf+74zo0iBJH39tMe" +
       "y5uHJze/zv+H+U//ivGta5UH6cq9WuCmHvCjt2qBF9quEfUM34jUxNDpygOG" +
       "rxO7+3TlPnDO2L6xvzo2zdhI6Mrd7u7SvcHuN1CRCbooVXQfOLd9Mzg5D9Vk" +
       "uTsvwkqlch84Kh8Cx49V9n+7/0lFg5aBZ0Cqpvq2H0BcFJT4Y8jwkwXQ7RJa" +
       "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" +
       "Gs4ZumOig047CZp14CD8nIhXkYq3Ndng");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "/wu4xQRSiTkAAA==");
}
