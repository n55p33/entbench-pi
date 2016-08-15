package org.apache.batik.script;
public class InterpreterPool {
    public static final java.lang.String BIND_NAME_DOCUMENT = "document";
    protected static java.util.Map defaultFactories = new java.util.HashMap(
      7);
    protected java.util.Map factories = new java.util.HashMap(7);
    static { java.util.Iterator iter = org.apache.batik.util.Service.providers(
                                                                       org.apache.batik.script.InterpreterFactory.class);
             while (iter.hasNext()) { org.apache.batik.script.InterpreterFactory factory =
                                        null;
                                      factory = (org.apache.batik.script.InterpreterFactory)
                                                  iter.
                                                  next(
                                                    );
                                      java.lang.String[] mimeTypes =
                                        factory.
                                        getMimeTypes(
                                          );
                                      for (int i = 0; i <
                                                        mimeTypes.
                                                          length;
                                           i++) { defaultFactories.
                                                    put(
                                                      mimeTypes[i],
                                                      factory);
                                      } } }
    public InterpreterPool() { super();
                               factories.putAll(defaultFactories);
    }
    public org.apache.batik.script.Interpreter createInterpreter(org.w3c.dom.Document document,
                                                                 java.lang.String language) {
        org.apache.batik.script.InterpreterFactory factory =
          (org.apache.batik.script.InterpreterFactory)
            factories.
            get(
              language);
        if (factory ==
              null)
            return null;
        org.apache.batik.script.Interpreter interpreter =
          null;
        org.apache.batik.dom.svg.SVGOMDocument svgDoc =
          (org.apache.batik.dom.svg.SVGOMDocument)
            document;
        try {
            java.net.URL url =
              new java.net.URL(
              svgDoc.
                getDocumentURI(
                  ));
            interpreter =
              factory.
                createInterpreter(
                  url,
                  svgDoc.
                    isSVG12(
                      ));
        }
        catch (java.net.MalformedURLException e) {
            
        }
        if (interpreter ==
              null)
            return null;
        if (document !=
              null)
            interpreter.
              bindObject(
                BIND_NAME_DOCUMENT,
                document);
        return interpreter;
    }
    public void putInterpreterFactory(java.lang.String language,
                                      org.apache.batik.script.InterpreterFactory factory) {
        factories.
          put(
            language,
            factory);
    }
    public void removeInterpreterFactory(java.lang.String language) {
        factories.
          remove(
            language);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "KTDR+OrXeRebP/4X5zNt52cdAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "WfiizbW2S24N96azqEe0R/hiFhrphN0KWL7aFWrazraUstAJq1xisC49aHeS" +
       "lskQgRcJI8ab5/jCKq007YJ92QfjuKPDfMy2tLyj51Grly1TEWWLYYNzi3Jq" +
       "CkYXzUa2bQrTZscq4m2/iZvduSkPtV6ENLF42BE8A+PEsUsG7UIcdxSuPZaC" +
       "QWB0pw2a8wOiJZDUZqm6S88YoANjvyTRpIf1sDW/tHxakfBxppLaKAJl17d9" +
       "og1PuiKNN814qud0yqsglLOO6no2TdiKsB9xUmpNMFchY1DXQYVdq7hMDtZU" +
       "hiywHhzhK63bQoky0wmtvrKS+R0p6FMkt4fSmB0wxjLY7JT23I4oTnB2sJyD" +
       "BbwVXGeCRNwcJTJScWd7ds17FGNbSGdjUP6WbaD0ridA+Sxi4xJahDJcCLTV" +
       "SGrxdDCBcnk3Uw0PKzozZoYvhj2b6iWLFrNY8JFECh2N6M+3GGjYVFwUUB9s" +
       "bqIOy5FUPiFDuDWRW5zZIogJZrWjLYY4ImHxWBqQAb0H3UQ2fFxRe+J4x+Ad" +
       "QVqmlGasU0ydzyhCcsNWs7mGV4tWHCADm5UgdG7qPQikxkWbQLdeJmVhT5IX" +
       "Q2tHULHJD7kyh0NZU+VX/L7XVrEcp7woXXe0eNdGMWrb4Eb61pu2B1N2K0Io" +
       "ySXWdtomiBWnOP1Cs8cwRmaLzayFzHciCa/n4Ipp0rk5TfXRGEnCBsTNdm1V" +
       "g8A9t57sC63ZGmyTzSppcJAx7ULd/jTb6U4PXESMEHnLTiJmznohMjOjMUFl" +
       "I25b7fWKT8EgB/m02EdjGIHJ4XphK7IaOjmWb8rs08pJcGR3KWuWQ5wHxZLA" +
       "dPcdVF5uNoKE2C4GZRw/MVzOIDTRQHoESHYaCsurOO43CC0KCAGeC62AFRNq" +
       "EKCF62/JPJrZKONth6vEw2NKm4aIoXhOQLQ7lMltrKK5S3JGzd0xI/EzTen2" +
       "EinN0VRBGpbfbWvevsmwjOO5Bial+DDKeruVQXR2LZ9Tlo2u33N5P8XsqWRg" +
       "hdem3NVG66URo2mZTEnL5dJ11wmMNGNzsDSm25EVSbY56DvQRokgu9fs2/R0" +
       "zVqprjhNSUbB9QjtSEwmm4ZftHpwZve70N4hOQ0nVxG6pDpSv9/igzxtCQY6" +
       "jQuEttyOlgv5SAd1wh6YwY51aAmJysXe2sIg1/W7vQbXUVrCpsUL/Lzwp24b" +
       "9gljAYobeTfo7mPfi3pddZuE6X7W8IpR3kLtXPcEqgOVibqjSvJ8EWLpcAsy" +
       "UgFFQ99r8hDWbzmBYrK84m5ibSP3yXXeCiF3A6mtBVNGHhBeYHmGsyApo/ww" +
       "ieUYlBNlFW/n3nIt0kshjcbFpO83Z46ycaHtLMI1yB74BdaYN3BrEsmTcaBA" +
       "/ZTvO+FItrfI2lp3DASd2rg4HLaWOjvKlzTFxTtniap0ZoHISuj026uMnI5y" +
       "xOjTqsxxvI46rmO0FDAqcQmrSTHN5zQRzcW25SLe1Gr7k9ihnaW7W3q9cved" +
       "8bs5mPELoQ/nckhOWHPfidn+zNSI8XyyLTId910wsRMi3o+TCWx3kc6+uaC3" +
       "I10ZqjNLwqVmO6db3WIz7UVbfjFW1QYlImB/6Kt57nXtpMVtJzHETAYWuSvz" +
       "Urez4HfUVs+N3ONgk03FObV3G9vJlhogq1DP/f6wKU58Zk4SnUKPyW0xHlg7" +
       "KjTXQnMSwPOtFYmd3mImwfAGZ3v+eOnkRbmuLPoNeTEDfcSONdg3w6HgF/Nx" +
       "z+mNejoL2cpmg8ttotUWIlBFR8lM3oWCNe9i6oAPOrzKdCNSpubYDOTilT7T" +
       "FR5qr5A9myJNVSt30j9YbbFf+e5OOZ6sD29OL6T/L45tDl0vVMUHTs+s6t81" +
       "4NIl5vn7kLNDcqA6sXjP/e6Z69OKL33y1dc07ufhk6O/IgWup0H4/a6e6+45" +
       "VA+VmF66/8kMU1+znx16f/WT/+W5+Q9tPv5dXOW99xKdl1H+IvP6742/R/2p" +
       "q8BDp0fgd30AcHHQyxcPvm/EeprF/vzC8fd7TiX7TCWxD5aPdCxZ6V6ngbce" +
       "cOL4wYPuL93dXD0cDp8clL6zunDdttQjLfCOsHNn6UQ9+qcfcPPzs1Xx2dK0" +
       "1FiXU/3cDe0J8hffwm3umfH95Hc6WjpPQN3wmYuXj2j5ZMfSSv9KpVUL5ISr" +
       "l94CV4ej9V2N8x88QIa/UBWvpcDTYZbePbwekpxzzG0KPJwHlnYmtL///yq0" +
       "fvl84lhon/irEdqVM4CDFf3qAyTwj6vijRR4Nta9INfvFkLV/4tnDH/5u2G4" +
       "jB83L305UF2DPnvXJ0mHz2jUX3nt5mPPvCb+6/ry/PRTl+s08JiRue75W6tz" +
       "9WslcsOqmbl+uMMK67+vpMAz9zGV6i6qrtQU/+YB/s0UuHUZPgUeqf/Pw/12" +
       "Ctw4gytRHSrnQX4nBR4qQarqV8N73E0dLu+KKxej86mMn/pOMj4X0F+8EIbr" +
       "T8JOQmbGH18dvfEayf7otzo/f7jbV115v6+wPEYDjx4+MzgNuy/cF9sJrmuT" +
       "D337iS9f/8DJEvHEgeAzSz1H23vvfZE+8sK0vvre/9NnfvXDv/DaH9VXCP8H" +
       "ml5VJasnAAA=");
}
