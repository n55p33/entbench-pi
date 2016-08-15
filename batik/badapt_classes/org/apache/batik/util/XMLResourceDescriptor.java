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
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "kGeh2euELQ8Pk5vslTbe/wOOTGaKtB8AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "rSjw7VzX9vpwnxOsv3ufsi8WyecT6ElTT/jT/dsid3mqRK+/2XbP2WbLjL9z" +
       "gvpdRWZxBPDhI9QffgDUB6e6/6Ywv3Kfsn9UJF9KoKcBzDnLXLaXeor2H/5/" +
       "oL1ZZJLgsY/Q2t9DtFf2R7gluyXBr94H8leL5J8CyPFlkMsqnzjjIH4qgR7e" +
       "BLZ2KoZf+V4M+vZIDNvv06D/6/uUfa1Ifm0/6Jgo3n/Qf/17Meg/eYT2J7+f" +
       "g/5794H8+0Xy9f2gXw75X5xC/p0HgZyBRi891yqO3Z+962rc/jqX+ouvX3/s" +
       "na9P/215cePkytU1BnrMSF337CnpmferYaQbdonn2v7MNCz/vglYuPQ6DVDd" +
       "4q/k+Rt72j9MoBsXaRPokfL/LN1/SqDHT+kS6Or+5SzJtxLoIUBSvP5ReHyw" +
       "deYcYn9QnF05Py+eSPnmm0n5zFT68rkJsLyWeDxZpfuLiXfUr7w+HH3sO60v" +
       "7u+UqK6S50UrjzHQo/vrLScT3ov3bO24rauDV7775C9de9/x5PzknuFTbT3D" +
       "23suv7SBe2FSXrPI/9k7/8mP/b3Xv1EexPw/vcePSC8qAAA=");
}
