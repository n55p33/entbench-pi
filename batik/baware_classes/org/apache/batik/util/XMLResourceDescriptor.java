package org.apache.batik.util;
public class XMLResourceDescriptor {
    public static final java.lang.String XML_PARSER_CLASS_NAME_KEY = "org.xml.sax.driver";
    public static final java.lang.String CSS_PARSER_CLASS_NAME_KEY = "org.w3c.css.sac.driver";
    public static final java.lang.String RESOURCES = "resources/XMLResourceDescriptor.properties";
    protected static java.util.Properties parserProps = null;
    protected static java.lang.String xmlParserClassName;
    protected static java.lang.String cssParserClassName;
    protected static synchronized java.util.Properties getParserProps() {
        if (parserProps !=
              null)
            return parserProps;
        parserProps =
          new java.util.Properties(
            );
        try {
            java.lang.Class cls =
              org.apache.batik.util.XMLResourceDescriptor.class;
            java.io.InputStream is =
              cls.
              getResourceAsStream(
                RESOURCES);
            parserProps.
              load(
                is);
        }
        catch (java.io.IOException ioe) {
            throw new java.util.MissingResourceException(
              ioe.
                getMessage(
                  ),
              RESOURCES,
              null);
        }
        return parserProps;
    }
    public static java.lang.String getXMLParserClassName() { if (xmlParserClassName ==
                                                                   null) {
                                                                 xmlParserClassName =
                                                                   getParserProps(
                                                                     ).
                                                                     getProperty(
                                                                       XML_PARSER_CLASS_NAME_KEY);
                                                             }
                                                             return xmlParserClassName;
    }
    public static void setXMLParserClassName(java.lang.String xmlParserClassName) {
        org.apache.batik.util.XMLResourceDescriptor.
          xmlParserClassName =
          xmlParserClassName;
    }
    public static java.lang.String getCSSParserClassName() {
        if (cssParserClassName ==
              null) {
            cssParserClassName =
              getParserProps(
                ).
                getProperty(
                  CSS_PARSER_CLASS_NAME_KEY);
        }
        return cssParserClassName;
    }
    public static void setCSSParserClassName(java.lang.String cssParserClassName) {
        org.apache.batik.util.XMLResourceDescriptor.
          cssParserClassName =
          cssParserClassName;
    }
    public XMLResourceDescriptor() { super(
                                       );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "yLPQ7HXCloeHyU32Shvv/wHwwZOStB8AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
