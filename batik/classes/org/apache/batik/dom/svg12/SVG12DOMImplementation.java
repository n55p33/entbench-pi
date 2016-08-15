package org.apache.batik.dom.svg12;
public class SVG12DOMImplementation extends org.apache.batik.dom.svg.SVGDOMImplementation {
    public SVG12DOMImplementation() { super();
                                      factories = svg12Factories;
                                      registerFeature("CSS", "2.0");
                                      registerFeature("StyleSheets", "2.0");
                                      registerFeature("SVG", new java.lang.String[] { "1.0",
                                                      "1.1",
                                                      "1.2" });
                                      registerFeature("SVGEvents",
                                                      new java.lang.String[] { "1.0",
                                                      "1.1",
                                                      "1.2" });
    }
    public org.apache.batik.css.engine.CSSEngine createCSSEngine(org.apache.batik.dom.AbstractStylableDocument doc,
                                                                 org.apache.batik.css.engine.CSSContext ctx,
                                                                 org.apache.batik.css.parser.ExtendedParser ep,
                                                                 org.apache.batik.css.engine.value.ValueManager[] vms,
                                                                 org.apache.batik.css.engine.value.ShorthandManager[] sms) {
        org.apache.batik.util.ParsedURL durl =
          ((org.apache.batik.dom.svg.SVGOMDocument)
             doc).
          getParsedURL(
            );
        org.apache.batik.css.engine.CSSEngine result =
          new org.apache.batik.css.engine.SVG12CSSEngine(
          doc,
          durl,
          ep,
          vms,
          sms,
          ctx);
        java.net.URL url =
          getClass(
            ).
          getResource(
            "resources/UserAgentStyleSheet.css");
        if (url !=
              null) {
            org.apache.batik.util.ParsedURL purl =
              new org.apache.batik.util.ParsedURL(
              url);
            org.w3c.css.sac.InputSource is =
              new org.w3c.css.sac.InputSource(
              purl.
                toString(
                  ));
            result.
              setUserAgentStyleSheet(
                result.
                  parseStyleSheet(
                    is,
                    purl,
                    "all"));
        }
        return result;
    }
    public org.w3c.dom.Document createDocument(java.lang.String namespaceURI,
                                               java.lang.String qualifiedName,
                                               org.w3c.dom.DocumentType doctype)
          throws org.w3c.dom.DOMException {
        org.apache.batik.dom.svg.SVGOMDocument result =
          new org.apache.batik.dom.svg12.SVG12OMDocument(
          doctype,
          this);
        result.
          setIsSVG12(
            true);
        if (qualifiedName !=
              null)
            result.
              appendChild(
                result.
                  createElementNS(
                    namespaceURI,
                    qualifiedName));
        return result;
    }
    public org.w3c.dom.Element createElementNS(org.apache.batik.dom.AbstractDocument document,
                                               java.lang.String namespaceURI,
                                               java.lang.String qualifiedName) {
        if (namespaceURI ==
              null)
            return new org.apache.batik.dom.GenericElement(
              qualifiedName.
                intern(
                  ),
              document);
        java.lang.String name =
          org.apache.batik.dom.util.DOMUtilities.
          getLocalName(
            qualifiedName);
        java.lang.String prefix =
          org.apache.batik.dom.util.DOMUtilities.
          getPrefix(
            qualifiedName);
        if (org.apache.batik.util.SVG12Constants.
              SVG_NAMESPACE_URI.
              equals(
                namespaceURI)) {
            org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory ef =
              (org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory)
                factories.
                get(
                  name);
            if (ef !=
                  null) {
                return ef.
                  create(
                    prefix,
                    document);
            }
        }
        else
            if (org.apache.batik.util.XBLConstants.
                  XBL_NAMESPACE_URI.
                  equals(
                    namespaceURI)) {
                org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory ef =
                  (org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory)
                    xblFactories.
                    get(
                      name);
                if (ef !=
                      null) {
                    return ef.
                      create(
                        prefix,
                        document);
                }
            }
        if (customFactories !=
              null) {
            org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory cef;
            cef =
              (org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory)
                customFactories.
                get(
                  namespaceURI,
                  name);
            if (cef !=
                  null) {
                return cef.
                  create(
                    prefix,
                    document);
            }
        }
        return new org.apache.batik.dom.svg12.BindableElement(
          prefix,
          document,
          namespaceURI,
          name);
    }
    public org.apache.batik.dom.events.DocumentEventSupport createDocumentEventSupport() {
        org.apache.batik.dom.events.DocumentEventSupport result =
          super.
          createDocumentEventSupport(
            );
        result.
          registerEventFactory(
            "WheelEvent",
            new org.apache.batik.dom.events.DocumentEventSupport.EventFactory(
              ) {
                public org.w3c.dom.events.Event createEvent() {
                    return new org.apache.batik.dom.svg12.SVGOMWheelEvent(
                      );
                }
            });
        result.
          registerEventFactory(
            "ShadowTreeEvent",
            new org.apache.batik.dom.events.DocumentEventSupport.EventFactory(
              ) {
                public org.w3c.dom.events.Event createEvent() {
                    return new org.apache.batik.dom.svg12.XBLOMShadowTreeEvent(
                      );
                }
            });
        return result;
    }
    public org.apache.batik.dom.events.EventSupport createEventSupport(org.apache.batik.dom.AbstractNode n) {
        return new org.apache.batik.dom.svg12.XBLEventSupport(
          n);
    }
    protected static org.apache.batik.dom.util.HashTable
      svg12Factories =
      new org.apache.batik.dom.util.HashTable(
      svg11Factories);
    static { svg12Factories.put(org.apache.batik.util.SVG12Constants.
                                  SVG_FLOW_DIV_TAG,
                                new org.apache.batik.dom.svg12.SVG12DOMImplementation.FlowDivElementFactory(
                                  ));
             svg12Factories.put(org.apache.batik.util.SVG12Constants.
                                  SVG_FLOW_LINE_TAG,
                                new org.apache.batik.dom.svg12.SVG12DOMImplementation.FlowLineElementFactory(
                                  ));
             svg12Factories.put(org.apache.batik.util.SVG12Constants.
                                  SVG_FLOW_PARA_TAG,
                                new org.apache.batik.dom.svg12.SVG12DOMImplementation.FlowParaElementFactory(
                                  ));
             svg12Factories.put(org.apache.batik.util.SVG12Constants.
                                  SVG_FLOW_REGION_BREAK_TAG,
                                new org.apache.batik.dom.svg12.SVG12DOMImplementation.FlowRegionBreakElementFactory(
                                  ));
             svg12Factories.put(org.apache.batik.util.SVG12Constants.
                                  SVG_FLOW_REGION_TAG,
                                new org.apache.batik.dom.svg12.SVG12DOMImplementation.FlowRegionElementFactory(
                                  ));
             svg12Factories.put(org.apache.batik.util.SVG12Constants.
                                  SVG_FLOW_REGION_EXCLUDE_TAG,
                                new org.apache.batik.dom.svg12.SVG12DOMImplementation.FlowRegionExcludeElementFactory(
                                  ));
             svg12Factories.put(org.apache.batik.util.SVG12Constants.
                                  SVG_FLOW_ROOT_TAG,
                                new org.apache.batik.dom.svg12.SVG12DOMImplementation.FlowRootElementFactory(
                                  ));
             svg12Factories.put(org.apache.batik.util.SVG12Constants.
                                  SVG_FLOW_SPAN_TAG,
                                new org.apache.batik.dom.svg12.SVG12DOMImplementation.FlowSpanElementFactory(
                                  ));
             svg12Factories.put(org.apache.batik.util.SVG12Constants.
                                  SVG_HANDLER_TAG,
                                new org.apache.batik.dom.svg12.SVG12DOMImplementation.HandlerElementFactory(
                                  ));
             svg12Factories.put(org.apache.batik.util.SVG12Constants.
                                  SVG_MULTI_IMAGE_TAG,
                                new org.apache.batik.dom.svg12.SVG12DOMImplementation.MultiImageElementFactory(
                                  ));
             svg12Factories.put(org.apache.batik.util.SVG12Constants.
                                  SVG_SOLID_COLOR_TAG,
                                new org.apache.batik.dom.svg12.SVG12DOMImplementation.SolidColorElementFactory(
                                  ));
             svg12Factories.put(org.apache.batik.util.SVG12Constants.
                                  SVG_SUB_IMAGE_TAG,
                                new org.apache.batik.dom.svg12.SVG12DOMImplementation.SubImageElementFactory(
                                  ));
             svg12Factories.put(org.apache.batik.util.SVG12Constants.
                                  SVG_SUB_IMAGE_REF_TAG,
                                new org.apache.batik.dom.svg12.SVG12DOMImplementation.SubImageRefElementFactory(
                                  )); }
    protected static class FlowDivElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public FlowDivElementFactory() { super(
                                           );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.dom.svg12.SVGOMFlowDivElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "5a+s+fZ/AZFOWkyIFAAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "9AF3Iug2P/AicGLXtXzcw5JWXs24Z79mvf97tKR1WOc4s38UfuupdVwyjXQ3" +
           "tBRbv7GMe7x+m53jHrzZNUV+hvv0e559Tht8prSzV2eagGP73u3RUX0C6Imb" +
           "H1Z7+RXNYfHjK+/5lyvjt8ze8SpKug+fUPKkyN/pPf81+o3qR3agswelkBsu" +
           "j44zXTteALkY6CBZdcfHyiAPHrjn/swbD4Lvd/fc893Ty6qn+v1MHmjb8DpR" +
           "w9vZBkYeYPtevSfzalJWc2cSnhpnHsu5k1eoAL4zawLgHjXQ5UjfF3b3UWF7" +
           "3j8M4vAnHamPldoi6N5TrwH2xyq96msFEDgP3HCZub2AUz//3KUL9z/H/1Ve" +
           "Qj+4JLuNgS4YsW0frV0deT4P0kjDyifktm0ly89/3h9BV26uXQSdy39zQ963" +
           "5fjVPUec5Iigs6A9SvnrEXT5JCWQmP8epftQBF08pAOe2j4cJfkIkA5IsseP" +
           "+qcUvLblvvTMkcW3Bza5O+/6Se48YDlajc8WbH7xvL+44u3V83X1C891+u98" +
           "qfaZ7W2AasubTSblAgPdur2YOFigj95U2r6s863HX77ji7e9YR9J7tgqfLhs" +
           "juj28Omld9Lxo7xYvvmD+3/vzb/13Lfz+tv/AiTBVzIRIAAA");
    }
    protected static class FlowLineElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public FlowLineElementFactory() {
            super(
              );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.dom.svg12.SVGOMFlowLineElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "m2/8F0suIBSKFAAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAAL1Ze8zjWHX3fPPY2WHZmX1vp+yTgXY36HMSJ3HSobCJHcdx" +
           "EjsPx0ncwuD4HT/jd0y3hRWvlgoQLJRKsH+B2qLloaqolSqqraoWEKgSFepL" +
           "KqCqUmkpLfsHtOq2pdfO955vFq0qNVJunOtzzj3nnnN+995zn/8+dN73oILr" +
           "mBvVdIJdOQl2V2Z1N9i4sr9L9atDwfNlCTMF32dB3w3x8S9c/tFLH9Ku7EAX" +
           "eOgewbadQAh0x/bHsu+YkSz1ocuHvW1TtvwAutJfCZEAh4Fuwn3dD673oVcd" +
           "YQ2ga/19FWCgAgxUgHMV4OYhFWB6tWyHFpZxCHbgr6Ffhs70oQuumKkXQI8d" +
           "F+IKnmDtiRnmFgAJF7P/HDAqZ0486NED27c232TwRwvws7/x1iu/exa6zEOX" +
           "dXuSqSMCJQIwCA/dYcnWUvb8piTJEg/dZcuyNJE9XTD1NNebh+72ddUWgtCT" +
           "DyYp6wxd2cvHPJy5O8TMNi8UA8c7ME/RZVPa/3deMQUV2Hr/oa1bC4msHxh4" +
           "SQeKeYogyvss5wzdlgLokZMcBzZe6wECwHqbJQeaczDUOVsAHdDdW9+Zgq3C" +
           "k8DTbRWQnndCMEoAXb2l0GyuXUE0BFW+EUAPnqQbbl8BqtvzichYAui+k2S5" +
           "JOClqye8dMQ/36ff+IG326S9k+ssyaKZ6X8RMD18gmksK7In26K8Zbzjyf7H" +
           "hPu/9L4dCALE950g3tL8/i+9+NQbHn7hK1uanz6FhlmuZDG4IX5qeec3XoM9" +
           "0TibqXHRdXw9c/4xy/PwH+69uZ64IPPuP5CYvdzdf/nC+M8W7/iM/L0d6FIX" +
           "uiA6ZmiBOLpLdCxXN2WvI9uyJwSy1IVul20Jy993odvAc1+35W0voyi+HHSh" +
           "c2bedcHJ/4MpUoCIbIpuA8+6rTj7z64QaPlz4kIQdB/4Qo+B779B28+/Zk0A" +
           "SbDmWDIsiIKt2w489JzMfh+W7WAJ5laDlyDqDdh3Qg+EIOx4KiyAONDkvReS" +
           "Y8F+pJbK8ITrlMo4M+haLkAJwJ+ny24Wbe7/0zhJZu+V+MwZ4IrXnAQCE+QQ" +
           "6ZiS7N0Qnw1b7Rc/d+NrOweJsTdTAUSCoXe3Q+/mQ++CoXfzoXdPH/oaYTpx" +
           "5qj2tpMQsnzfQGfO5Ircm2m2jQdAZABcAIh5xxOTt1Bve9/jZ0EguvE54IqM" +
           "FL41cGOHSNLN8VIE4Qy98PH4ndyvFHegneMInFkDui5l7MMMNw/w8drJzDtN" +
           "7uX3fvdHn//Y085hDh6D9D1ouJkzS+3HT86754iyBMDyUPyTjwpfvPGlp6/t" +
           "QOcAXgCMDAQwewB+Hj45xrEUv74Pl5kt54HBiuNZgpm92se4S4HmOfFhTx4Q" +
           "d+bPd4E5vpzF/OvA9wd7SZD/Zm/vcbP23m0AZU47YUUOxz8/cT/513/+T0g+" +
           "3fvIffnIWjiRg+tH0CITdjnHhbsOY4D1ZBnQ/d3Hhx/56Pff+wt5AACK1542" +
           "4LWsxQBKABeCaX73V9Z/8+1vfeqbO4dBE4DlMlyaupgcGHkxs+nOlzESjPb6" +
           "Q30A2pggE7OouTa1LUfSFV1YmnIWpf91+XWlL/7LB65s48AEPfth9IafLOCw" +
           "/6da0Du+9tZ/fzgXc0bMVrvDOTsk20LoPYeSm54nbDI9knf+xUO/+WXhkwCM" +
           "AQD6eirnmAblcwDlToNz+5/M290T70pZ84h/NPiP59eRXckN8UPf/MGruR/8" +
           "0Yu5tse3NUd9PRDc69vwyppHEyD+gZOZTgq+BugqL9C/eMV84SUgkQcSRQBw" +
           "PuMBIEqORcYe9fnb/vaP/+T+t33jLLRDQJdMR5C2gAKWARDdsq8BDEvcNz+1" +
           "dW6cuftKbip0k/HboHgw/3cWKPjErfGFyHYlhyn64H8y5vKZv/+PmyYhR5ZT" +
           "FuMT/Dz8/CeuYm/6Xs5/mOIZ98PJzeAMdnCHvOXPWD/cefzCn+5At/HQFXFv" +
           "e8gJZpglDg+2RP7+nhFsIY+9P7692a7l1w8g7DUn4eXIsCfB5XBRAM8ZdfZ8" +
           "6Sie/Bh8zoDv/2TfbLqzju2ieje2t7I/erC0u25yBmTr+fIuulvM+N+cS3ks" +
           "b69lzc9s3ZQ9/ixIaz/flwIORbcFMx/4qQCEmCle25fOgX1qtv6sTDQXcx/Y" +
           "mefhlFm/u93cbQEta8u5iG1IVG8ZPj+3pcpXrjsPhfUdsE98/z986OsffO23" +
           "gU8p6HyUzTdw5ZER6TDbOr/n+Y8+9Kpnv/P+HKUARHHveunqU5nU/stZnDXt" +
           "rCH2Tb2amTrJ9wN9wQ8GObDIUm7ty4by0NMtgL/R3r4Qfvrubxuf+O5nt3u+" +
           "k3F7glh+37O/9uPdDzy7c2Sn/dqbNrtHeba77VzpV+/NsAc99nKj5BzEP37+" +
           "6T/87affu9Xq7uP7xjY4Fn32L//767sf/85XT9minDOd/4NjgzvOkRW/29z/" +
           "9EsLZRaL42SmMAjclqyNgirqqjqgqTkmOqyne+VYcEjaqa20Imrj9SlVJddF" +
           "IrWkUKp3CnCwtJc22qf7jlBuW3p3OjJWS5Vg4argYOaSx7wRRnGGwAk9H5sa" +
           "fpugJ80Eh81uOhoLkbFS+kXER0I0QKSQGKKqSyFLC7FTPqiiEWw1aFgROa6/" +
           "Kvcmyw6bMsQGsZKuSA8NLtBqJs7YM9FpYPOpW1s7dh0uKGgb4YgJU2QEvzHi" +
           "udoKH68m1rpeGZQFh8fXcid2YyoxJ+JgNk21hp2andAaTAc1uiP6fMESnIhI" +
           "puWpI1KpMJGoHrOUSxJVSwec2KJKIetTTLvcNvUBHtcNbELrlhEUwu6yWaBw" +
           "ddyZpkPTY/hNkWrDrMx7XbFYGlL4jMSTse/74qYhcjwijxMuxJMi7BRK8Yw0" +
           "4Kg3p/F0EW5WnYKc9sUu0alpmkVsFtUk0VZrezhIOWpho5E/qG5Szd5QXI+j" +
           "GB+P3bRIeSWijbacprYsecOZuRhKdDpY2ZqRaHgENOCc3tLRWVLgev2Ox9q9" +
           "wJqEMU/T46SELJKOkEpzbzybmaZV0Wi0rckKE9gbeOJMrE07SflVB53oMTaq" +
           "9dNuC59NUHrZkUYcb9RGJYfGhouin87WQjEIXdoXl5KgDpuw1mhsMHtu9csz" +
           "ikZK4miM4nSqR2LQjSx+NFERol7q8AijrstStEYmsUb6rXiwpGl9YQudJoNI" +
           "vQafWGsq8bF63SkHK1QeY821HICJUuiK2edazpQp6guwOtIretWmizhtjZZs" +
           "p9XEBbuTCNONXSuv+z2SKpm96diYdKo93CGm0bzZZsOO0d3EFt3uTGlnphPd" +
           "1bC0sBvVpFIcO0VHFzGZE5ZOOIRLg56B0gwgT7FlzFqjdhKhhgFPUlNhxqrR" +
           "qixqI59iq/FYjhBURmR4SveWTFX1E6OwGrNy2+UnrAxHM85pNEpc2C3WNsio" +
           "iJM1qir3puzSWDXjab/TE9J1q01WGqhaczsKEsGx1DDB+W6srejR2nXRYXNR" +
           "FQiWtgV2neJpBy/zo1RapNNBcSC1Q3rFt8p1Kp3hGwml2AGvKd1kWqv1vJI2" +
           "gePplJ9226HgtJBU1BeIFxDAyDqxSbBJU6zz4EsmeLUw9st2T6c8ylxhgjsa" +
           "pcNBQo0DJyoxTU218SVKU0GvWfCs9qLAB2oHx4KOyBIkNuLlWlMIF5M0Snw4" +
           "KVM1mSELYb3C4BbTH2ibAVEXzVTXU8WBPY5uyqnoj7HuSNdLWjfANbxbFkLf" +
           "802ymyhlvFKIGDfYsN16B6vYIWUQlMBsavPVIjQq/VZxPqmLXr9RRB3XB/On" +
           "aWXWxOrLODIMrb3sjSRps0yabSqNm0Ez7ZZRN6lXFMb12WTaLHJrRzMxVWg3" +
           "KFXzNhuRXsEUuxmZEVt0Kh4sNIjJfDYJBkRPFtxVpFlFvkJSJm4jPi5b3fm8" +
           "2pmN0W6XVmseTWuC2Vx0ArNtSn2btYdLJrVdvKzGYhDJVJcVyvJcj3x7XRVn" +
           "5MouVKVwRRFrgSZxqhM2Ac7WCI4oGA26Es84dtJBIh9eNGR52NWKNZk29NSg" +
           "xMLGmmk4m6jrhSIbZh8NGsx82ovhEuYp82atlGJqm0zCmPFKJDZRB3JcGwTS" +
           "rBUn3jjlBqKW1gGOdsIlhtSGMYl5cqdOzgZsbDG1drXqokt/iqxsXiiTPJVi" +
           "Q2ZkCl182KsKcuQicKqziNiTkIiiNMFprxc8GasjEnO9domd1fxheT0oLjb9" +
           "EiLI6yVbShpol2322yuRs+zW3NqQKq2qGggID02SaoAo85JVJYdckuokXm3Q" +
           "o15r1hsHgsaKRWWxmfiBHyl4ghl4OGmtGaPBq81CAKCrmHq4Cs+H5QFaMOFG" +
           "zTPm+qgryniRR5c1tInCcLup9OPZRoGLE2Q6bo0HxT46VHCSKmhBPV0wZXYs" +
           "JWSFI5HArnmS4harTVjtD6TlwqA6+hJrFUftJV+IYWQ5RrSpUIjjMlMtqoV2" +
           "NORq2Gii23a/1PAYGw1KcqAHtRk3w/FZpTESjCGO8abYKpEysZlZU8a0RmE5" +
           "KFXAIbIQOgCvVLyjzVW+o0xaYcU3MRw3hSrfaIRKRPPVWlhct7Wihi9dihOt" +
           "ltE3moiYUs2wOPPIKDLqhAT8h2AETVkKYZLySl3yHE6DZSIk8TLQEp0HHowO" +
           "u5zKUv1aoIrcUKOKCq/VN/aYLMwMxKNofO0sCIIprdYqpkwnvVAuyVY0KaiV" +
           "VbFU0buNSllECD+RRvGcwQciLrc4e2X2BvGiwzOBYPIdp2Yu5Gip++wKZfuF" +
           "cB4E1HqR6L2aDBxj1mG9BNfiqs+1zTCYNYwOHaOeKUxEkWsnBY9F5hFDDOGa" +
           "I8HLpjcbLVEmLExYtIU0oqbq1Up+Uar0amCdDyV6XIAp21sTSb8dVAdhvAkL" +
           "gyGsWA6H9DRBdVblOdPDQm8CErrVL/b0hjNA1XbHcowGK1NFhOPb07GM8bpf" +
           "J1HHKXjNjTwKuwvgRbvVn1uao69qejsYKQRhE7o/0IebTV/plDVyhaHieqQ5" +
           "5GrCDRkK5PiwsKp1VgTOk80p00uF1qjBjwMMc1N/knaGTkQP5pbYilBSrNQl" +
           "tbRorfvSRpE5gKeFGZYKTVgUNkKtVy/rq2G/rqxDVxjCnKNG9qohNFmfj3o1" +
           "UtUa7aZQMv3ixopaU2czXkyQlI4XpTUqlZKpzhS0SceujlJ8xbUqLV3iis2F" +
           "mRaxUVztqdN5TFbZDLsrokZghVZ7OhvhYbeCRWDJtLAqVXbamG1zY9JeuRER" +
           "sqo5w4eqOpbmctiIq+HMJA1PrIoDFi+hcANnNrxJFENvZHhOK3aqc3MKd5po" +
           "SWOtmuxJNous5MW8hkid+QRDNiqCJuVq2mRm+KhrzKpuQDsLNmy0lmnB871C" +
           "CW4UJFuQKi2VrTa7GkvHXRvTTLeGrfXmMCUdvTanvQpW16YzY4AO0XJlVUIH" +
           "CVxn1yPfrISIh5WVqV6BC/Vm1C8norpwDXisuyqXNrEVY4zmA6avuaSFU1Fa" +
           "bVrp2AjjFt/Si8vSgAPbMHSUyqxgUYaRNl1Dx2MdDpmq34t4PREDim1YQeR3" +
           "G02pjza9wdAiTZzgRyTPpIg5TOcVksjyCWvDG3mhr5abcmnYG4nKCkYqChFx" +
           "WCvttG0GqwVitTCfjJUKDQ9hvY1gFN9g4VgX8XSJxHGNVrVlnQhGhSqnkFHS" +
           "V6slrbXxJvqc7Ish680joKJirBta3VvgDbvN1hCiavhdbeBFq7RW7jfEQpez" +
           "ynCdKPphtzXpEWDbnx0H3vLKTmR35YfPg2sGcBDLXpCv4CSSnD7gTgDd7npO" +
           "AE7rspSPe1jOyisZ9+4XrPd/j5azDmscZ/aPwW8+tYjbTgLZ9vWlKd9cwz1e" +
           "u83OcA/d6o4iP7996plnn5OYT5d29mpMc3Bk37s6OqqPBz1564PqIL+fOSx8" +
           "fPmZf77Kvkl72yso5z5yQsmTIn9n8PxXO68XP7wDnT0og9x0c3Sc6frx4scl" +
           "Tw5Cz2aPlUAeOnDPA5k3HgLfH+6554enl1RP9fuZPNC24XWifrezDYw8wPa9" +
           "em/m1RgRc2fijhhmHsu545ep/r09azzgHtGThUDeF3bPUWF73j8MYv8nHaeP" +
           "ldkC6P7T7wD2Byu94ksFEDkP3nSVub1+Ez/33OWLDzw3/au8fn5wRXZ7H7qo" +
           "hKZ5tHB15PmC68mKns/I7dsylpv/vCeArt5auwA6n//mhrx7y/Gre544yRFA" +
           "Z0F7lPLXA+jKSUogMf89SvfBALp0SAdctX04SvJhIB2QZI8fcU+pdm1rfcmZ" +
           "I9m3hza5P+/+Sf48YDlais8yNr923s+ucHvxfEP8/HMU/fYXa5/eXgWIppCm" +
           "mZSLfei27a3EQYY+dktp+7IukE+8dOcXbn/dPpTcuVX4MG+O6PbI6XX3tgXO" +
           "RVmlPP2DB37vjb/13Lfy4tv/AnWO/WEPIAAA");
    }
    protected static class FlowParaElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public FlowParaElementFactory() {
            super(
              );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.dom.svg12.SVGOMFlowParaElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "f2XN9/4LUar78IoUAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    protected static class FlowRegionBreakElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public FlowRegionBreakElementFactory() {
            super(
              );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.dom.svg12.SVGOMFlowRegionBreakElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "r18V+58Xr/j42n8BE2lEVJgUAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "/Tf99vPfyetx/wtl9fqXKSAAAA==");
    }
    protected static class FlowRegionElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public FlowRegionElementFactory() {
            super(
              );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.dom.svg12.SVGOMFlowRegionElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "+58Xr/j41n8B5xaNeI4UAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAAL1Ze8zjWHX3983O7Oyw7My+t8O+GaC7QZ/j2Hl1eGycxK/Y" +
           "cRI7TuIWBsePxIlf8SuO6baAeGxLtSBYKJVg/wK1RctDVVErVVRbVS0gUCUq" +
           "1JdUQFWl0lIk9o/SqtuWXjvfe2YWrSo1Um6c63POveeec3733HNf+BF0NvCh" +
           "gudam5nlhnt6Eu4trPJeuPH0YI9hyz3FD3StaSlBIIK+a+rjX774k5c/Or+0" +
           "C52TobsVx3FDJTRdJxjogWvFusZCF49625ZuByF0iV0osQJHoWnBrBmEV1no" +
           "NcdYQ+gKezAFGEwBBlOA8ynAjSMqwPRa3YnsZsahOGGwgn4F2mGhc56aTS+E" +
           "HjspxFN8xd4X08s1ABLOZ/8loFTOnPjQo4e6b3W+TuFPFODnfvOdl37vDHRR" +
           "hi6ajpBNRwWTCMEgMnS7rdtT3Q8amqZrMnSno+uaoPumYplpPm8ZuiswZ44S" +
           "Rr5+uEhZZ+Tpfj7m0crdrma6+ZEauv6heoapW9rBv7OGpcyArvcd6brVkMj6" +
           "gYIXTDAx31BU/YDllqXpaCH0yGmOQx2vdAABYL3V1sO5ezjULY4COqC7traz" +
           "FGcGC6FvOjNAetaNwCghdPmmQrO19hR1qcz0ayH0wGm63vYVoLotX4iMJYTu" +
           "PU2WSwJWunzKSsfs86PuW559t0M5u/mcNV21svmfB0wPn2Ia6Ibu646qbxlv" +
           "f5L9pHLfV5/ZhSBAfO8p4i3NH/zyS0+9+eEXv76led0NaPjpQlfDa+pnp3d8" +
           "+8HmE/Uz2TTOe25gZsY/oXnu/r39N1cTD0TefYcSs5d7By9fHPz55D2f13+4" +
           "C12goXOqa0U28KM7Vdf2TEv3Sd3RfSXUNRq6TXe0Zv6ehm4Fz6zp6Nte3jAC" +
           "PaShW6y865yb/wdLZAAR2RLdCp5Nx3APnj0lnOfPiQdB0L3gCz0GQTsPQvln" +
           "53VZG0IaPHdtHVZUxTEdF+75bqZ/AOtOOAVrO4enwOuXcOBGPnBB2PVnsAL8" +
           "YK7vv9BcGw7iGVKCBYlESi2eo20PoATgz8NlL/M27/9pnCTT99J6ZweY4sHT" +
           "QGCBGKJcS9P9a+pzEd5+6YvXvrl7GBj7KxVCDBh6bzv0Xj70Hhh6Lx9678ZD" +
           "XyEsdz3QZ/v4CLoJJYv4DbSzk0/lnmxuW48A9lwCZACYefsTwjuYdz3z+Bng" +
           "it76lswkgBS+OXQ3j7CEzhFTBQ4Nvfip9XulXy3uQrsnMTjTB3RdyNh7GXIe" +
           "IuSV07F3I7kXP/SDn3zpk0+7R1F4AtT3weF6ziy4Hz+98r6r6hqAyyPxTz6q" +
           "fOXaV5++sgvdAhADoGSoAK8GAPTw6TFOBPnVA8DMdDkLFDZc31as7NUByl0I" +
           "5767PurJXeKO/PlOsMYXM69/E1jrh/bDIP/N3t7tZe09WxfKjHZKixyQ3yp4" +
           "n/mbv/hnNF/uA+y+eGw3FPTw6jG8yIRdzJHhziMfEH1dB3R//6nexz/xow/9" +
           "Yu4AgOL1NxrwStY2AU4AE4Jl/sDXV3/7ve9+9ju7R04Tgg0zmlqmmhwqeT7T" +
           "6Y5XUBKM9saj+QC8sUAsZl5zZejYrmYapjK19MxL/+viG5Cv/Ouzl7Z+YIGe" +
           "Azd6888WcNT/czj0nm++898fzsXsqNl+d7RmR2RbEL37SHLD95VNNo/kvX/5" +
           "0G99TfkMgGMAgYGZ6jmqQfkaQLnR4Fz/J/N279Q7JGseCY47/8n4OpaXXFM/" +
           "+p0fv1b68R+/lM/2ZGJz3Nac4l3dulfWPJoA8fefjnRKCeaADnux+0uXrBdf" +
           "BhJlIFEFEBfwPoCi5IRn7FOfvfXv/uRP73vXt89AuwR0wXIVbQsoYCMA3q0H" +
           "c4Biiff2p7bWXWfmvpSrCl2n/NYpHsj/nQETfOLm+EJkeclRiD7wn7w1fd8/" +
           "/Md1i5Ajyw2241P8MvzCpy833/bDnP8oxDPuh5Pr4RnkcEe8pc/b/7b7+Lk/" +
           "24VulaFL6n6CKClWlAWODJKi4CBrBEnkifcnE5ztbn71EMIePA0vx4Y9DS5H" +
           "2wJ4zqiz5wvH8eSn4LMDvv+TfbPlzjq22+pdzf29/dHDzd3zkh0QrWdLe9W9" +
           "Ysb/9lzKY3l7JWvetDVT9vjzIKyDPDMFHIbpKFY+8FMhcDFLvXIgXQKZarYD" +
           "LaxqLuZekJvn7pRpv7dN77aAlrWlXMTWJco3dZ9f2FLlO9cdR8JYF2SKH/7H" +
           "j37rI6//HrApA52Ns/UGpjw2YjfKkucPvvCJh17z3Pc/nKMUgB/p/S9ffiqT" +
           "yr6SxlnTzhriQNXLmapCnhGwShByObDoWq7tK7pyzzdtgL/xfmYIP33X95af" +
           "/sEXtlnfab89Raw/89yv/3Tv2ed2j+Xar78u3T3Os82380m/dn+FfeixVxol" +
           "5yD+6UtP/9HvPP2h7azuOpk5tsHB6At/9d/f2vvU979xgyTlFsv9Pxg2vP12" +
           "CgvoxsGHRSZKaa1KyagQodW2Zm/iqjEbLMM5M25qksPi03CN9PnpAKFaYTJq" +
           "1ZdMmVoVyTRKw1RzxvOSvGDSBKlUia7XWTXIebvNKp43Xo0r2GpILv0BMeor" +
           "pDQ0p5MVzUrtfrvdFXprb4HNSYGXKJ1BUrkkO5qjoEPDxBkV5lEnjiJDV2tl" +
           "NHbYIB43u4i1dCo2N10YXWsmOQmHpb1hyMxqK4tl+Zm86Oi2R8Y+OkzqPDrg" +
           "rLrBL7tDPRQmljIlkvnKTrtLpEwE6UJiSLnLCdOFObfFkZqoHpEOwrEjeNJM" +
           "1IddiaGlXmXBtGaD3lBkmNLGtz2PRHnGWhNOr29jQp9RZbYtUPMK37YVRkMm" +
           "9WCI4rUB1Ug51zYMNFjMPaFcmZvpYK4WpS6Dj9hWonFBaPQRfRSsYg7rwC2M" +
           "HI/gCtZZbAzEYqM5zBvTZNGPyt2IbIqSKGrNKheUFNlTIlZsVwS7Vat4fqem" +
           "yXLN1vrLjao0uKbaEkawiJMbZdYu1hW06PFUkS0W0toK8GNyxdaXvWYDJTcB" +
           "IjD9YUnR6mPObPGt+WwalUxsNKsOq2Y4qUieIhc4UU86I0f0pXqMTdvlpcUV" +
           "9emax2l1FnB2rYD3rWUtLSargSxMe0t00p0tUEqkR6uN604r/TK7Ga2GpQQv" +
           "pJsipuAxR1BxJXZpbGaXbHZMaSyzGrcn+CauS5bEuMSoGtZHSZFN0LbaIhMB" +
           "I3F7PmMjtDlCmphrq1W6HncYF6s1xv1GczQNZqkT8uyoLq2IhkzP19zAGvly" +
           "gicNsRY1FabIN1r9cklipI7hK26XbqZTekgv6GW30OVmkrBQG/0IU/o+25wU" +
           "+7JQmnfoockVkFW/51D1Dq8QbWEm9liRYBMYD+dDqe4WhZTlmC5OLWasvdZF" +
           "sc5GSK1MNPvU3PeaaxruraxK1Ygr9RgWEEq2AwKcDIqkME0sVhhNHQQtFUxd" +
           "L/lrslEip+ZyAuMsO5Cn3ajVa+F9buL5kdsWjAUaiZVqu2bovFCtNuuD4mKA" +
           "V0xJCw2+4aIyCLyoswnSlkhydnm40Wka4ZZFg4Abotzg68xg1OMrVN+epO1C" +
           "f+RJnCTEZgGeubON28dVZD2NTHksxqjSqDF1jMVNctmEq4y4pM0StsDMUkow" +
           "G21DrwxnNGE6EsEVeyKxqNgmbPVbpDDpxiq2LLoUNp/odqk5wLkKOSn1+22K" +
           "12V+Q7mFiYDY80KZS5ki1qNEx9UtRm6Tozk8NMd6h+5GPThs1/CqVioStNXo" +
           "sAphDpsE1VqZq5ROh3XaKhRak/pAE6vpbLauDdY9dcwMtVmlaq81AompiR5h" +
           "pZan63qEq5Jk2LYkWwkx15nETMyCKLT7qjfo9cpmo4n5y0baaA1RNnGqAbnw" +
           "ajCCrBvDhSIprYZN1z19uCJIo7dIebG4jLWpEFTZdaXeVoZIU2bwQrIcJkM/" +
           "dU0ZFyoiESbFabHcqhmMv6HLjZZKmXLBFZYY1VyFQ0EqRq0YJHdgQZZcpYWv" +
           "0OZkgzmrujI2C6pTKSsSJaKptTBNxvImXZSlebJRGKeblkwUrTrdXo8tQySp" +
           "GF5jZV03iAVqKvyy5ThWUFpbpbBh4Mt40hMsT21odcYYK+t1r1mdII0qkzTp" +
           "GePU3THa4UlrMoEXRXlCci1zYaP2CvNEB9soOgcPLaMozCKiVNPWdDDxTDdc" +
           "czU9RDlCrmGlEjoLahre0+lApkcuLRcMrlytpwJc0BhtHSJaNHHbhcmkmmD9" +
           "FuFOab4/moY9e9OzJxscbehjuVqtJyDwxbXPzYJBaIkTdc2r7hCPwI6Q1pCp" +
           "wccxXF2VwrG7qPK8NsD4dSkExnDlRk9Bei4zCJgogtG00R6t+niBtl1qQUa4" +
           "uBFmRV9kOJ+CSW1WqtdCI532MV7CF8mEFePyzK/VhjWNoQs1teAaxpDpDjha" +
           "AFHKEWgXM8p8rKv9YkXs6C7ccvUq0ouLtjHvu02fLHqd4rrPDdoFusm4BWxc" +
           "17CFgypkOS0wCysZto2SVcCllWdR4nyzVEMmLVfgqYtNR8uYcFOEaY1IaryY" +
           "T1AVR3p6e6Mv6XBMzzTYqCC4MUV6w6lLtfVu229sQqXY1BO50ybJDlJCsakK" +
           "60qvWmcDIMfjbUvQNjOM6kfFptbifLDnTDm+UkUxJ2q7SlWU552Nu47JYoOa" +
           "Vmpq5JO19WSUSmh1UsO4Vlqp64QwSykcmc7WXkzU6rhBJcqirZYVccA5E26F" +
           "R8gwFsYVsMaDiV1ypI1ZTzcNExaLJuYUUwbWJBYvL3AVKwprArM0nS+6K7yh" +
           "2yEyj5jYrobBMPJr8SDtFzGqiFDKFEtwHi7VxzDqyzDFGqhZ7du2r6HxFOOI" +
           "eVzuCNzGqgw8uNSzzXqBU43WqN9DlyuAU2TBrvdFmMU0AFLBeIE2B6iTBmI9" +
           "5sdyXI37IUFXQ1oqkNK47NTcEdoqFEbsUiZmhXS4YFkycsSB2m36QcdhsKYy" +
           "c+UlVjQ7m0p1YpqO2+9yuLUcY+OBUZI2Utgg8Hp1s7GTUkj39WFfG1Fhf4pz" +
           "8qyEFFDSSeOJxSf8QhjLnUbZJLRgTsDYfNYzGrTmGXjSajWWdj9RpCEse6vG" +
           "hqiFZtXpYTxfWRbhFmz3VIwj6aHL2xFiE+UkMQEWgH2ULZSrHd8dk4UlgWiL" +
           "lljyE7QWckShNlv0W/qCL61mSpNaD5rxiNwsmkwN0ZO+32wXiAgfSQZSdLoC" +
           "I5YomhzpRDmYuDHdEUlnRjJqvWlzvOASRA2PhhhTLBWohjjQ+3aHpYlSmyPG" +
           "dDfZtFoO6i47S4ewCI8NIyJyzKXdGs+ay9iPJV0PfT4ZVBS0O1oM13UNriWp" +
           "GKrmajywBtK6hUlTv0u0CKJblyU5clZwlXbmUcimRmT6Xn/qqHy1aejIrMUP" +
           "Nq1Bq7PGRkXaQgeuK8VTFFlXanDcTet6DU9kbNnue7LaYtar8aSGj0t4S0sq" +
           "XGSnSgF3aI3wW3y9LMeObsg2DA+xISvr3RAZjcWiNXYceG0lKuoXiV7gkE2k" +
           "3UYmtFQurgaTeVlBRsIktGN+OZhSZNPB28UO09cmdLHEeBvEnogqiH7aa3ic" +
           "S63NQsxbEe3W/Y0KgFarNmOV6LQabEqlLlkGJ7JG3SW7sMeLKO7WrKnK0ayB" +
           "U+aKClgWsAzQyihKKSL1VonZloXamlmF9VlJX5qNtQbP4oYXqegcMeDGeC0W" +
           "YAyFSaqvqmS1SSm9SBsnVE3EeGfST6VytyPOVyRTj9eriFxuukZSmxSbC4cT" +
           "yPGAWqqcKToO4ddrw0K5NvbhBYY4NbycKF2dxoYg+39rdix4x6s7md2ZH0IP" +
           "LxzAgSx7Qb2KE0ly4wF3Q+g2z3dDcGrXtXzco7JWXtG456B0ffB7vKx1VOvY" +
           "OTgOv/2G5dx2EupOYE4t/fpq7skabnaWe+hmtxX5Oe6z73vueY3/HLK7X2sa" +
           "g6P7/iXS8fn40JM3P7By+U3NUQHka+/7l8vi2+bvehVl3UdOTfK0yN/lXvgG" +
           "+Ub1Y7vQmcNyyHV3SCeZrp4sglzw9TDyHfFEKeShQ/Pcn1njIaDq4/vmefzG" +
           "pdUb2n0nd7Ste52q4+1uHSN3sAOr3pNZdY2quTFbrhplFsu5169QBXx31vjA" +
           "PKqvK6F+IOzu48L2rX/kxMHPOlafKLeF0AM3uw04GA551RcMwHceuO5ac3sV" +
           "p37x+Yvn739++Nd5Jf3wuuw2FjpvRJZ1vIR17Pmc5+uGma/JbduClpf/fDCE" +
           "Lt98diF0Nv/NFfnAluPX9m1xmiOEzoD2OOVvhNCl05RAYv57nO4jIXThiA4Y" +
           "a/twnORjQDogyR4/7t2g7rWt+iU7x+JvH29yi971syx6yHK8KJ/FbH4FfRBf" +
           "0fYS+pr6peeZ7rtfqnxueymgWkqaZlLOs9Ct2/uJwxh97KbSDmSdo554+Y4v" +
           "3/aGAzC5Yzvho8g5NrdHblyBb9temNfM0z+8//ff8tvPfzcvw/0vvlYUxBsg" +
           "AAA=");
    }
    protected static class FlowRegionExcludeElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public FlowRegionExcludeElementFactory() {
            super(
              );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.dom.svg12.SVGOMFlowRegionExcludeElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "yuLXb4r9z4tXfHzrvxoDj2ecFAAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "38k6cv8LezLKiC0gAAA=");
    }
    protected static class FlowRootElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public FlowRootElementFactory() {
            super(
              );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.dom.svg12.SVGOMFlowRootElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "f56/suY7/wX988aMihQAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "3Z0fQo+uG8CBLHtBvYITSXLzAfdC6A7Pd0NwatfUfNxdWSuvaNx3WLg+/D1e" +
           "1trVOs4cHoffetNibisJNScwZUu7sZZ7soabneUevtVdRX6O+8x7nn1OZT9b" +
           "3DuoNU3B0f3gCun4fHzoqVsfWPv5Pc2uAPLV9/zLFeEt83e8grLuo6cmeVrk" +
           "7/af/3r79cpH96CzR+WQG26QTjJdO1kEuehrYeQ7wolSyMNH5nkws8bDQNUD" +
           "a29/byyt3tTuZ3JH27rXqTre3tYxcgc7tOp9mVVjVMmN2XSVKLNYzh2/TBXw" +
           "nVnjA/MoviaF2qGwe48LO7D+zomDn3asPlFuC6EHbn4XcDhY8RVfLgDPeeiG" +
           "K83tNZzyhecuXXjwudFf53X0o6uyO2jogh5Z1vEC1rHn856v6Wa+Indsy1le" +
           "/vO+ELpy69mF0Ln8N1fkvVuOXzuwxGmOEDoL2uOUvxFCl09TAon573G6D4fQ" +
           "xR0dMNX24TjJR4F0QJI9fsy7SdVrW/NLzhyLvgO0ye15z0+z5xHL8ZJ8FrH5" +
           "9fNhdEXbC+jryhef6zLvfLH62e2VANgM0zSTcoGGbt/eThxF6OO3lHYo6zz1" +
           "5Et3femO1x1CyV3bCe/i5tjcHr15/b1le2FeMU//8MHff9NvP/edvAj3v6sA" +
           "+SYXIAAA");
    }
    protected static class FlowSpanElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public FlowSpanElementFactory() {
            super(
              );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.dom.svg12.SVGOMFlowSpanElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "f1684uMb/wV3fVRSihQAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    protected static class HandlerElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public HandlerElementFactory() { super(
                                           );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.dom.svg12.SVGOMHandlerElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "z/NX9nj8v7I4iJqIFAAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    protected static class MultiImageElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public MultiImageElementFactory() {
            super(
              );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.dom.svg12.SVGOMMultiImageElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("H4sIAAAAAAAAAL1Ya2wc1RW+u37Edmyv7fiR5uEkxgmKk+5iIG2RU8Bx7GTT" +
           "9UNxEgmnZHN35u7uxLMzk5k79tqUFpAq0qpK0zRAQMK/jFArCqgqaisBcoVU" +
           "QLSVoFFbWpFW6h/6iEpUif5IX+fcmdmZnd0lSn/Ukmdn7z333HvO+c53zt0X" +
           "rpEGyyT9TONxvmQwKz6u8RlqWkweU6llHYOxtPRUHf37qQ+n7omSxjnSnqfW" +
           "pEQtNqEwVbbmyFZFszjVJGZNMSbjihmTWcxcoFzRtTnSo1jJgqEqksIndZmh" +
           "wAlqpkgn5dxUMjZnSVcBJ1tTcJKEOEliNDw9kiKtkm4s+eIbA+JjgRmULPh7" +
           "WZx0pM7QBZqwuaImUorFR4om2WPo6lJO1XmcFXn8jLrPdcGR1L4KFwy8HPv4" +
           "xoV8h3DBBqppOhfmWUeZpasLTE6RmD86rrKCdZZ8mdSlyPqAMCeDKW/TBGya" +
           "gE09a30pOH0b0+zCmC7M4Z6mRkPCA3Gyo1yJQU1acNXMiDODhibu2i4Wg7Xb" +
           "S9Y6VlaY+MSexKWnTnV8v47E5khM0WbxOBIcgsMmc+BQVsgw0xqVZSbPkU4N" +
           "gj3LTIWqyrIb6S5LyWmU2xB+zy04aBvMFHv6voI4gm2mLXHdLJmXFYByvzVk" +
           "VZoDW3t9Wx0LJ3AcDGxR4GBmlgLu3CX184omc7ItvKJk4+AXQACWriswntdL" +
           "W9VrFAZIlwMRlWq5xCxAT8uBaIMOADQ52VRTKfraoNI8zbE0IjIkN+NMgVSz" +
           "cAQu4aQnLCY0QZQ2haIUiM+1qf3nH9IOa1ESgTPLTFLx/OthUX9o0VGWZSaD" +
           "PHAWtg6lnqS9r52LEgLCPSFhR+aHX7p+/97+tbccmc1VZKYzZ5jE09Jqpv3d" +
           "LWO776nDYzQZuqVg8MssF1k2486MFA1gmN6SRpyMe5NrR3/6wCPfZX+JkpYk" +
           "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" +
           "f1684uNb/wVGLRkajhQAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "fwESlVfzGyAAAA==");
    }
    protected static class SolidColorElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public SolidColorElementFactory() {
            super(
              );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.dom.svg12.SVGOMSolidColorElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "/wviFR9f/y/JG0rjjhQAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "JuSR5SbH8Sl8EX7+U1fwX/hBjr9z8Qz7kfTG8AxyuB1u6XPOv+09cf7P9qDb" +
           "ReiycpAgjiU7zhxHBElReJg1giTyxPzJBGd7ml87CmGvOR1eji17OrjsjgXQ" +
           "z6Cz/sXj8eQn4HMGfP8n+2bbnQ1sj9V78IOz/bGjw9330zPAW8+V9tH9Yob/" +
           "lpzK43l7NWvesFVT1v054NZhnpkCDN10JTtf+OkImJitXD2kPgaZanYCWTaa" +
           "k7kf5Oa5OWXS72/Tu21Ay9pSTmJrEtVbms/Pb6Hyk+uuHTHaA5niB//xI9/8" +
           "8Gu/C3Tag86tsv0Gqjy2IhNnyfP7nv/4w6969nsfzKMUCD/jX33pytMZVfrl" +
           "JM6adtYQh6JeyUTl84yAlsKonwcWTc2lfVlTHgSmA+Lv6iAzhJ+557uLT33/" +
           "89us77TdngLWPvDsr/9k/0PP7h3LtV97Q7p7HGebb+dMv/pghwPo8ZdbJccg" +
           "/umLz/zR7zzz/i1X95zMHNvgYvT5v/rvb+5/8ntfv0mScpvt/R8UG915Z7cS" +
           "ks3DD43MpFKijNNJIS6jbdVZr1Dd4BbRvDfF1bFLY3KU2ENW5pBuK0onrfqo" +
           "V+0ui51NvIk2qjudl0Srt0mRGkrJ/HjUZHByxhdbIwuhEWW8pIdjzyAXo7k9" +
           "9pZFiseL3IhottouTJE1khutFtw01hVHdURXRSKiWzXWMrtpVKsoapVdnVXQ" +
           "aqFGM0VTFUWy4K/alemGmhEcLBSaCULz0mAZ8WsrJGa8uyzNV2gDaapCo6j2" +
           "YC71N2MiGC3JSQfRZpQdbXxC5+h2BTHHtmD1ncosFBeE1Z9ShFqUZ9UipYrt" +
           "st0c81pHiMN0WGkOkUWNVxWnspTEeIOPFayHIj22beMuPkzbfkUT/J7DC9pE" +
           "H3SYpt7lkmZKVVelBt1GpYWje81FeTYl2gKvTM0kmQhoSyyqvBPUrA2LW2mB" +
           "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" +
           "JfTowQFcyLKJ7iu4kaQ3X3Avgu7wAy8Ct3ZNzdfdlbXyisZ9h6Xrw9/jZa1d" +
           "rePM4XX4LTct57bTSHNDU7a1G6u5J2u42V3u4Vu9VuT3uM+859nnVPazyN5B" +
           "rWkKru4Hj0jH+Qmgp259Ye3nLzW7AshX3/MvV4RfmL/9FZR1Hz3F5GmSv9t/" +
           "/uud1ysf3YPOHpVDbnhDOol07WQR5GKgRXHgCidKIQ8fqefBTBsPA1HfeaCe" +
           "d968tHpTvZ/JDW1rXqfqeHtbw8gN7FCr92VaTcpKrsyWp8SZxnLs5GWqgO/I" +
           "mgCoRwk0KdIOid17nNiB9ndGHP60a/WJclsEPXSr14DD5ZBX/MAAbOehG541" +
           "t09xyheeu3ThwedGf51X0o+ey+6goQt6bNvHS1jH+uf9QNPNfE/u2Ba0/Pzn" +
           "fRF05dbcRdC5/DcX5L1bjF870MVpjAg6C9rjkL8RQZdPQwKK+e9xuA9H0MUd" +
           "HFDWtnMc5KOAOgDJuh/zb1L32lb90jPH/O8g3uQaveenafQI5XhRPvPZ/An6" +
           "0L/i7SP0deWLz/WYd7xY++z2UUCxpc0mo3KBhm7fvk8c+ejjt6R2SOt898mX" +
           "7vrSHa87DCZ3bRneec4x3h69eQW+7fhRXjPf/OGDv/+m337uO3kZ7n8BnNTL" +
           "ARsgAAA=");
    }
    protected static class SubImageElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public SubImageElementFactory() {
            super(
              );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.dom.svg12.SVGOMSubImageElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "/7x4xcfX/wt9vIVSihQAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "AAA=");
    }
    protected static class SubImageRefElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public SubImageRefElementFactory() {
            super(
              );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.dom.svg12.SVGOMSubImageRefElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "b/P9z/FX9nj8v1LEzo2QFAAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "As5xKnUdIAAA");
    }
    protected static org.apache.batik.dom.util.HashTable
      xblFactories =
      new org.apache.batik.dom.util.HashTable(
      );
    static { xblFactories.put(org.apache.batik.util.XBLConstants.
                                XBL_XBL_TAG,
                              new org.apache.batik.dom.svg12.SVG12DOMImplementation.XBLXBLElementFactory(
                                ));
             xblFactories.put(org.apache.batik.util.XBLConstants.
                                XBL_DEFINITION_TAG,
                              new org.apache.batik.dom.svg12.SVG12DOMImplementation.XBLDefinitionElementFactory(
                                ));
             xblFactories.put(org.apache.batik.util.XBLConstants.
                                XBL_TEMPLATE_TAG,
                              new org.apache.batik.dom.svg12.SVG12DOMImplementation.XBLTemplateElementFactory(
                                ));
             xblFactories.put(org.apache.batik.util.XBLConstants.
                                XBL_CONTENT_TAG,
                              new org.apache.batik.dom.svg12.SVG12DOMImplementation.XBLContentElementFactory(
                                ));
             xblFactories.put(org.apache.batik.util.XBLConstants.
                                XBL_HANDLER_GROUP_TAG,
                              new org.apache.batik.dom.svg12.SVG12DOMImplementation.XBLHandlerGroupElementFactory(
                                ));
             xblFactories.put(org.apache.batik.util.XBLConstants.
                                XBL_IMPORT_TAG,
                              new org.apache.batik.dom.svg12.SVG12DOMImplementation.XBLImportElementFactory(
                                ));
             xblFactories.put(org.apache.batik.util.XBLConstants.
                                XBL_SHADOW_TREE_TAG,
                              new org.apache.batik.dom.svg12.SVG12DOMImplementation.XBLShadowTreeElementFactory(
                                )); }
    protected static class XBLXBLElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public XBLXBLElementFactory() { super(
                                          );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.dom.svg12.XBLOMXBLElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "vvNfzQRUKIYUAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "4hP4M/j5T14l3vSDHP/QxTPsh9ObQzPI3w5x0c86/7bz+IU/24Fum0FXlL3k" +
           "UJTsOHOcGUiIwv2MESSQx+aPJzfbk/z6QQh7zcnwcmTZk8Hl8EgA/Qw66186" +
           "Gk9+Aj5nwP//ZP/ZdmcD2yP1bmLvXH/04GD3/fQM8Nbz6C62W8zw35xTeSxv" +
           "r2XNz23VlHV/Hrh1mGelAEM3XcnOF346AiZmK9f2qYsgS81On4WN5WTuA3l5" +
           "bk6Z9Lvb1G4b0LIWzUlsTaJyS/P5hS1UfnLdeUiM9UCW+IF//PA3P/TEd4FO" +
           "O9D5JNtvoMojK3bjLHF+7/Mfe+hVz37vA3mUAuFHfPdLV5/OqLIvJ3HWNLOG" +
           "2hf1aibqIM8GWCmMuDywaGou7cuashCYDoi/yV5WCD9z93etT37/c9uM76Td" +
           "ngDW3v/sr/9k94PP7hzJs5+4KdU9irPNtXOmX723wwH02MutkmNQ//SFZ/7o" +
           "d55535aru49njU1wKfrcX/33N3c/8b2vn5KgnLO9/4NiozvO0eWwje9/WGSq" +
           "j1dKPx3rMcapKEbVo5gXLK7PlxdGQ1E6UWk4wysqOVbjjbVKbFLpd/pGYbqO" +
           "NlEpgmkNc2YlZFHFqK7PLPGW0ewyxeGMXiZIKnrdztjElz0n9PsddblsSJaN" +
           "z/1lj2f0mkH3CcatNWVM2/AbDYtRtVUewSG/riczqyQXpHq9FMP12jSZNDUk" +
           "8sSqOSoP1W7TUp0O59eFaehZ66VDy8LcX0i667cEDFv3ai5WdszYdkdWqKNG" +
           "O424ZXkwlCl3NC0s0XQYcEHTJUR6ajoOi3IDKUV6SB1ML9WgM186fmh5Ltke" +
           "reaaMB0sm+iQceyZkTLWskyYrj9QGkzHLfYk0qoJvkgM5Y7JJsmiNRcMb9qe" +
           "dahkXZfbvjSq6qnQmSqA5GAQTPxRlyK0YkqOa6nfsNBe20IVJJEq7MJUUFs3" +
           "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" +
           "+FFeJ9/84QO//4bffu47eentfwEPPcE1CyAAAA==");
    }
    protected static class XBLDefinitionElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public XBLDefinitionElementFactory() {
            super(
              );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.dom.svg12.XBLOMDefinitionElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("H4sIAAAAAAAAAL1Ya2wcVxW+u37Edmyv7fgR8nAS1wmKE3brtgEqh7Z+Jg7r" +
           "h+Ikog7N5u7M3d2JZ2cmM3fstUuhrVQ1IBRCSNuAVP9yVYFKWyEqQKKVUSXa" +
           "EErVEgEFNSDxpzwiGiGVH+F1zp2ZndnZdaLwA0uenb333HPvOec73zl3X7hG" +
           "aiyTdDONx/miwaz4qManqWkxeVillnUExlLSM1X07yc+mLw3SmpnSXOOWhMS" +
           "tdiYwlTZmiVbFc3iVJOYNcmYjCumTWYxc55yRddmSYdijecNVZEUPqHLDAWO" +
           "UTNJWinnppK2ORt3FXCyNQknSYiTJAbD0wNJ0ijpxqIvvjEgPhyYQcm8v5fF" +
           "SUvyFJ2nCZsraiKpWHygYJI9hq4uZlWdx1mBx0+p+1wXHEruK3NBz8uxj26c" +
           "y7UIF2ygmqZzYZ51mFm6Os/kJIn5o6Mqy1unyRdJVZKsDwhz0pv0Nk3ApgnY" +
           "1LPWl4LTNzHNzg/rwhzuaao1JDwQJztKlRjUpHlXzbQ4M2io467tYjFYu71o" +
           "rWNlmYlP7UlceOZEy/eqSGyWxBRtBo8jwSE4bDILDmX5NDOtQVlm8ixp1SDY" +
           "M8xUqKosuZFus5SsRrkN4ffcgoO2wUyxp+8riCPYZtoS182ieRkBKPdbTUal" +
           "WbC107fVsXAMx8HABgUOZmYo4M5dUj2naDIn28Irijb2fhYEYOm6POM5vbhV" +
           "tUZhgLQ5EFGplk3MAPS0LIjW6ABAk5NNaypFXxtUmqNZlkJEhuSmnSmQqheO" +
           "wCWcdITFhCaI0qZQlALxuTa5/+zD2kEtSiJwZplJKp5/PSzqDi06zDLMZJAH" +
           "zsLGvuTTtPPVM1FCQLgjJOzI/OAL1x/Y2736piOzuYLMVPoUk3hKWkk3v7Nl" +
           "ePe9VXiMOkO3FAx+ieUiy6bdmYGCAQzTWdSIk3FvcvXwTx989DvsL1HSME5q" +
           "JV2184CjVknPG4rKzANMYyblTB4n9UyTh8X8OFkH70lFY87oVCZjMT5OqlUx" +
           "VKuL7+CiDKhAFzXAu6JldO/doDwn3gsGIaQD/slOQiI/I+IvcgmfnMiJnJ5n" +
           "CSpRTdH0xLSpo/1WAhgnDb7NJdKA+rmEpdsmQDChm9kEBRzkmDsh6/mENZ/t" +
           "vysxc+xA/10jUxPIgiwP60W6xBFtxv9pnwLau2EhEoFQbAkTgQo5dFBXZWam" +
           "pAv20Oj1F1OXHZBhYrie4mQCto47W8fF1nHYOi62jlfeuvdzQ8kRllE0xSNF" +
           "mBmjmPSLJBIRp2nH4zmggJDOATkAOzfunnno0MkzPVWARmOhGqMCoj0lVWrY" +
           "ZxCP9lPSS21NSzuu9r8eJdVJ0gY72VTFojNoZoHOpDk34xvTUL/8MrI9UEaw" +
           "/pm6xGRgsbXKiaulTp9nJo5z0h7Q4BU5TOfE2iWm4vnJ6sWFx4596c4oiZZW" +
           "DtyyBkgPl08j3xd5vTfMGJX0xp784KOXnn5E97mjpBR5FbRsJdrQE8ZL2D0p" +
           "qW87fSX16iO9wu31wO2cQi4CbXaH9yihpgGP5tGWOjA4o5t5quKU5+MGnjP1" +
           "BX9EALlVvLcDLGKYq30Aj8tu8opPnO008NnlAB9xFrJClJHPzBjP/uYXf7pb" +
           "uNurOLFAqzDD+ECA5VBZm+CzVh+2R0zGQO79i9PfeOrak8cFZkHijkob9uJz" +
           "GNgNQghufuLN0+/9/urKlaiPcw5l3k5Dt1QoGlmHNjXfxEjYbZd/HmBJFRgE" +
           "UdN7VAN8KhmFplWGifXP2M7+V/56tsXBgQojHoz23lqBP/6xIfLo5RP/6BZq" +
           "IhJWad9nvphD/Rt8zYOmSRfxHIXH3t36zTfos1BEgLgtZYkJLibCB0QEbZ+w" +
           "/07xvCc09yl87LSC4C/Nr0A3lZLOXfmw6diHr10Xpy1tx4KxnqDGgAMvfOwq" +
           "gPquMDkdpFYO5O5Znfx8i7p6AzTOgkYJiNmaMoFACyXIcKVr1v32J693nnyn" +
           "ikTHSIOqU9nhQChfgG5m5YB7C8b9DzjRXcBwtwhTSZnxZQPo4G2VQzeaN7hw" +
           "9tIPu76///nlqwJlhqNjc1Dhx8WzDx+fEONRTuoNU+egikFHVWuJVtBHpFjb" +
           "7tVK7zOISH+PiHjfyMn9FevHaIEzzVIAXuXlo7RiYEC2rtUeidZu5fELy/LU" +
           "c/1OE9NW2nKMQkf93V/96+fxi3+4VKG61brtbfDgsF9JyZkQbaNPe+83n//j" +
           "j3qzQ7dTbXCs+xb1BL9vAwv61q4e4aO88fifNx25L3fyNgrHtpAvwyq/PfHC" +
           "pQO7pPNR0SM7NaOsty5dNBD0KmxqMrgMaGgmjjSJ7LqjiKIuBM1WcPTbLore" +
           "rkzeAqL42FNOiWstDZFH1IG1B8UWkTHY6cedTt+baEeMLtwtCWiO6JKN+BPH" +
           "ePAmdJTCxxHAkGQy6FY9ZRuCylwsi7lP4+Ook04D/2Pe48CgUeBk802aLO8k" +
           "/bfdugH2N5ZdGJ1LjvTicqyua/norwXsixeRRgBwxlbVQPyDWKg1TDikcFej" +
           "w7KG+JiDu9Xap+OkRnwKQ045KzQ3TOEVnFTBMyh5GiIdlgSN4jMoxzlp8OUg" +
           "js5LUGQBtIMIvgLnlsPIuR0VIuXkKoLdcatgF5cEGwfMenG59zLUdq730Ocu" +
           "H5p8+Ponn3MaF0mlS0viMgh3W6eHKmb5jjW1ebpqD+6+0fxy/c6oi+ZW58B+" +
           "7m0OQH0Qcs3AorMpVNWt3mJxf29l/2tvnal9F1j2OIlQSITjgau14yloDWyg" +
           "1+NJn2ADPw6JdmNg97cW79ub+dvvRN1yCXnL2vIp6crzD/3y/MYVaEvWj5Ma" +
           "KAisMEsaFGtkUTvMpHlzljQp1mgBjghaFKqOkzpbU07bbFxOkmYEMkUyEH5x" +
           "3dlUHMW2l5Oesvt9hcsC1PgFZg7ptiYL3gNG9kdKfnXwiNI2jNACf6QYyvZy" +
           "21PSyJdjPz7XVjUGyVhiTlD9OstOF0k4+EOEz8otDrX+B/4i8P9v/Meg44Bz" +
           "H24bdi/l24u3cmgmnLmqVHLCMDzZurcMJ0W+go+vFnCck0ifO4o0FnEqLH79" +
           "mtj/rHjFx9f/C7y/H3KUFAAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "ISAAAA==");
    }
    protected static class XBLTemplateElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public XBLTemplateElementFactory() {
            super(
              );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.dom.svg12.XBLOMTemplateElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("H4sIAAAAAAAAAL1YfWwcxRWfO3/Edmyf7fgjJLGTGCdtnPQWA2mLnAK2YycO" +
           "5w/FTlScksvc7tzdxnu7m91Z+2xKC0iItKrSNA2QVsJ/GaFWfAmBaKWCXCEV" +
           "EC0SNCqkVdJK/Yd+RCWqRP9Iv97M7N7u7d0RpX/Ukvf2Zt68mffe7/3em3vu" +
           "KqqxLdRDdBqnSyax46M6ncaWTZQRDdv2LIwl5aeq8N+Pfzx5VxTVzqHmLLYn" +
           "ZGyTMZVoij2HulXdpliXiT1JiMJWTFvEJtYCpqqhz6EO1R7PmZoqq3TCUAgT" +
           "OIqtBGrFlFpqyqFk3FVAUXcCTiLxk0hD4enBBGqUDXPJF98YEB8JzDDJnL+X" +
           "TVFL4iRewJJDVU1KqDYdzFtot2loSxnNoHGSp/GT2l7XBYcSe0tc0PtS7NPr" +
           "Z7Mt3AUbsK4blJtnHya2oS0QJYFi/uioRnL2KfQNVJVA6wPCFPUlvE0l2FSC" +
           "TT1rfSk4fRPRndyIwc2hnqZaU2YHomh7sRITWzjnqpnmZwYNddS1nS8Ga7cV" +
           "rBVWlpj4xG7p/FPHW16uQrE5FFP1GXYcGQ5BYZM5cCjJpYhlDykKUeZQqw7B" +
           "niGWijV12Y10m61mdEwdCL/nFjbomMTie/q+gjiCbZYjU8MqmJfmgHK/1aQ1" +
           "nAFbO31bhYVjbBwMbFDhYFYaA+7cJdXzqq5QtDW8omBj330gAEvX5QjNGoWt" +
           "qnUMA6hNQETDekaaAejpGRCtMQCAFkWbKiplvjaxPI8zJMkQGZKbFlMgVc8d" +
           "wZZQ1BEW45ogSptCUQrE5+rkvjMP6gf1KIrAmRUia+z862FRT2jRYZImFoE8" +
           "EAsb+xNP4s7XT0cRAuGOkLCQee3r1+7d07P2tpDZXEZmKnWSyDQpr6aa398y" +
           "suuuKnaMOtOwVRb8Ist5lk27M4N5Exims6CRTca9ybXDv7j/4R+Tv0RRwziq" +
           "lQ3NyQGOWmUjZ6oasQ4QnViYEmUc1RNdGeHz42gdvCdUnYjRqXTaJnQcVWt8" +
           "qNbg38FFaVDBXNQA76qeNrx3E9Msf8+bCKEO+Ec7EIp8hPhf5EP2pEiRskaO" +
           "SFjGuqob0rRlMPttCRgnBb7NSilA/bxkG44FEJQMKyNhwEGWuBOKkZPshczA" +
           "7dLM0QMDt++fmmAsSHKwnqdLnKHN/D/tk2f2bliMRCAUW8JEoEEOHTQ0hVhJ" +
           "+bwzPHrtheS7AmQsMVxPUXQfbB0XW8f51nHYOs63jpffuu+rw4lZAkMQwlEx" +
           "PoZZyi+hSISfpZ0dTkACAjoP1ADc3Lhr5oFDJ073VgEWzcVqFhMQ7S2qUSM+" +
           "f3ikn5RfbGta3n5l4M0oqk6gNtjJwRorOUNWBshMnnfzvTEF1csvItsCRYRV" +
           "P8uQiQIcVqmYuFrqjAVisXGK2gMavBLHklmqXGDKnh+tXVh85Og3b4uiaHHd" +
           "YFvWAOWx5dOM7Qus3hfmi3J6Y49//OmLTz5k+MxRVIi8+lmyktnQG0ZL2D1J" +
           "uX8bfjX5+kN93O31wOwUQyYCafaE9ygipkGP5JktdWBw2rByWGNTno8baNYy" +
           "Fv0RDuNW/t4OsIixTP08wOOSm7r8k812muzZJWDPcBaygheRr8yYT3/03p/u" +
           "4O726k0s0CjMEDoY4DimrI2zWasP21mLEJC7fGH6+09cffwYxyxI3Fpuwz72" +
           "HAFugxCCmx97+9Sl319ZvRj1cU6hyDsp6JXyBSPrmE3Nn2Ek7LbTPw9wpAb8" +
           "wVDTd0QHfKppFac0whLrn7EdA6/+9UyLwIEGIx6M9txYgT9+yzB6+N3j/+jh" +
           "aiIyq9G+z3wxQfwbfM1DloWX2Dnyj3zQ/YO38NNQQoC2bXWZcCZG3AeIB20v" +
           "t/82/rwzNPcl9thhB8FfnF+BXiopn734SdPRT964xk9b3IwFYz2BzUEBL/bY" +
           "mQf1XWFyOojtLMjduTb5tRZt7TponAONMtCyPWUBfeaLkOFK16z77c/f7Dzx" +
           "fhWKjqEGzcCK4EAoXoBuYmeBefPmPfeK6C6ycLdwU1GJ8SUDzMFby4duNGdS" +
           "7uzln3S9su/ZlSscZabQsTmo8HP82c8eX+DjUYrqTcugoIpAP1Vr80bQRyRf" +
           "2+5VSu8ziEh/jwh/30jRPWWrx2ieEt1WAV6lxaO4YrCAdFdqjnhjt/ro+RVl" +
           "6pkB0cK0FTcco9BPP/+bf/0yfuEP75SpbbVucxs8OOxXVHImeNPo097l5nN/" +
           "/GlfZvhmqg0b67lBPWHft4IF/ZWrR/gobz36502zd2dP3ETh2BryZVjljyae" +
           "e+fATvlclHfIomaUdNbFiwaDXoVNLQJXAZ2ZyUaaeHbdWkBRFwNNNzj6soui" +
           "y+XJm0OUPXaXUmKlpSHyiApYe1Bs4RnD+vy46PO9iXaG0cU7ZA7N/YbsMPzx" +
           "Y9z/GXSUZI9ZwJBsEWh0PGUbgspcLPO5L7PHEZFOg/9j3rOBITNP0S0VWyzv" +
           "HAM33bYB8jeWXBbFBUd+YSVW17Vy5EMO+sIlpBHgm3Y0LRD9IBJqTYukVe6s" +
           "RsGxJv+Yh3tV5dNRVMM/uSEnxQrdDVJ4BUVV8AxKnoI4hyVBI/8MylGKGnw5" +
           "iKJ4CYosgnYQYa/AuKUgEjejfKSUWnmoO24U6sKSYNvAcp5f7L38dMTVHrrc" +
           "lUOTD1774jOibZE1vLzML4JwrxUdVCHHt1fU5umqPbjrevNL9TuiLpZbxYH9" +
           "zNscAPoQZJrJSs6mUE23+wql/dLqvjd+dbr2A+DYYyiCIQ2OBa7VwlPQGDhA" +
           "rscSPr0Gfhjizcbgrh8u3b0n/bff8arl0vGWyvJJ+eKzD/z63MZVaErWj6Ma" +
           "KAckP4caVHv/kn6YyAvWHGpS7dE8HBG0qFgbR3WOrp5yyLiSQM0MyJhRAfeL" +
           "686mwihreinqLbnbl7kqQIVfJNaw4egKZz3gY3+k6BcHjyYd0wwt8EcKoWwv" +
           "tT0p7/9W7Gdn26rGIBmLzAmqX2c7qQIFB3+E8Dm5RRDrf+AvAv//Zv8s6GxA" +
           "3IXbRtwL+bbCjRxaCTFXlUxMmKYnW/eeKVLk2+zxnTwbpyjS744yEouI+sq+" +
           "fpfvf4a/ssf3/gsDchCykBQAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAAL1Ze8zjWHX3983O7Oyw7My+lyn7ZKDsGn1O7CROOjzWTuy8" +
           "nMRxEid2C4OfiR2/4kdsh24LK14tFSBYKJVg/wK1RctDVVErVVRbVS0gUCUq" +
           "VKASD1WVSkuR2D9Kq25beu1875lZtKrUSLlxrs8595x7zv3dc8997ifQ2cCH" +
           "YM+10rnlhntaEu6ZVnkvTD0t2OswZVbyA02tW1IQjEHfNeWxL1782YsfXlza" +
           "hc6J0N2S47ihFBquE3Ba4FprTWWgi0e9lKXZQQhdYkxpLSFRaFgIYwThVQZ6" +
           "xTHWELrCHKiAABUQoAKSq4AQR1SA6ZWaE9n1jENywmAF/Qa0w0DnPCVTL4Qe" +
           "PSnEk3zJ3hfD5hYACeez/zwwKmdOfOiRQ9u3Nl9n8Mdg5JnffdulPzoDXRSh" +
           "i4YzytRRgBIhGESEbrc1W9b8gFBVTRWhOx1NU0eab0iWscn1FqG7AmPuSGHk" +
           "a4eTlHVGnubnYx7N3O1KZpsfKaHrH5qnG5qlHvw7q1vSHNh635GtWwvprB8Y" +
           "eMEAivm6pGgHLLcsDUcNoYdPcxzaeKULCADrrbYWLtzDoW5xJNAB3bX1nSU5" +
           "c2QU+oYzB6Rn3QiMEkKXbyo0m2tPUpbSXLsWQg+cpmO3rwDVbflEZCwhdO9p" +
           "slwS8NLlU1465p+f9N/4wXc4LWc311nVFCvT/zxgeugUE6fpmq85irZlvP0J" +
           "5uPSfV9+/y4EAeJ7TxFvaf7k11948g0PPf/VLc0v3YBmIJuaEl5TPi3f8c1X" +
           "1x+vncnUOO+5gZE5/4Tlefiz+2+uJh5YefcdSsxe7h28fJ77a+Gdn9V+vAtd" +
           "aEPnFNeKbBBHdyqu7RmW5jc1R/OlUFPb0G2ao9bz923oVvDMGI627R3oeqCF" +
           "begWK+865+b/wRTpQEQ2RbeCZ8PR3YNnTwoX+XPiQRB0L/hCr4Wgne9A+Wfn" +
           "21kbQiqycG0NkRTJMRwXYX03sz9ANCeUwdwuEBlE/RIJ3MgHIYi4/hyRQBws" +
           "tP0XqmsjwXpeRJER3yyijUGvbXsAJQB/vlz2smjz/p/GSTJ7L8U7O8AVrz4N" +
           "BBZYQy3XUjX/mvJMRFIvfP7a13cPF8b+TIVQFwy9tx16Lx96Dwy9lw+9d+Oh" +
           "r8xIZqyBLuBCattPS9mST6GdnVyXezLltiEBHLoE0ABA8/bHR2/tvP39j50B" +
           "sejFt2Q+AaTIzbG7fgQm7RwyFRDR0POfiN/F/2ZhF9o9CcKZQaDrQsbOZtB5" +
           "CJFXTi++G8m9+L4f/ewLH3/KPVqGJ1B9Hx2u58xW92Onp953FU0FeHkk/olH" +
           "pC9d+/JTV3ahWwBkAJgMJRDWAIEeOj3GiVV+9QAxM1vOAoN117clK3t1AHMX" +
           "woXvxkc9eUzckT/fCeb4Yhb2rwdz/d39dZD/Zm/v9rL2nm0MZU47ZUWOyG8a" +
           "eZ/6zt/8M5ZP9wF4Xzy2HY608OoxwMiEXcyh4c6jGBj7mgbovvcJ9qMf+8n7" +
           "fjUPAEDxmhsNeCVr6wAogAvBNL/nq6vv/uD7n/7W7lHQhGDHjGTLUJJDI89n" +
           "Nt3xEkaC0V53pA8AHAssxixqrkwc21UN3ZBkS8ui9L8uvrb4pX/94KVtHFig" +
           "5yCM3vCLBRz1v4qE3vn1t/37Q7mYHSXb8I7m7Ihsi6J3H0kmfF9KMz2Sd/3t" +
           "g7/3FelTAI8BBgbGRsthDcrnAMqdhuT2P5G3e6feFbPm4eB48J9cX8cSk2vK" +
           "h7/101fyP/3zF3JtT2Y2x33dk7yr2/DKmkcSIP7+0yu9JQULQFd6vv9rl6zn" +
           "XwQSRSBRARgXDHyARcmJyNinPnvr3//FX9739m+egXZp6ILlSuoWUMBOAKJb" +
           "CxYAxhLvLU9uvRtn7r6UmwpdZ/w2KB7I/50BCj5+c3yhs8TkaIk+8J8DS376" +
           "H/7juknIkeUG+/EpfhF57pOX62/+cc5/tMQz7oeS6/EZJHFHvOhn7X/bfezc" +
           "X+1Ct4rQJWU/Q+QlK8oWjgiyouAgbQRZ5In3JzOc7XZ+9RDCXn0aXo4Nexpc" +
           "jvYF8JxRZ88XjuPJz8FnB3z/J/tm0511bPfVu+r7m/sjh7u75yU7YLWeRffw" +
           "vULG/5ZcyqN5eyVrfnnrpuzx9WBZB3lqCjh0w5GsfOAnQxBilnLlQDoPUtVs" +
           "CzItPBdzL0jO83DKrN/b5ndbQMtaNBexDYnyTcPnV7ZU+c51x5EwxgWp4gf+" +
           "8cPf+NBrfgB82oHOrrP5Bq48NmI/yrLn9z73sQdf8cwPP5CjFIAf/t0vXn4y" +
           "k8q8lMVZQ2UNfWDq5czUUZ4SMFIQ9nJg0dTc2pcMZdY3bIC/6/3UEHnqrh8s" +
           "P/mjz23TvtNxe4pYe/8zv/3zvQ8+s3ss2X7NdfnucZ5twp0r/cr9GfahR19q" +
           "lJyD/qcvPPVnf/DU+7Za3XUydaTAyehzf/ff39j7xA+/doMs5RbL/T84Nrz9" +
           "UqsUtImDD1MU9GmsJNxUH2AIpdqpjutzs8M0x826GjrscEqgNuMQXVRIlUE5" +
           "RuixNVKWwVrBw42aOBFu14oijCbdesFoh11/1CfQIR90kKZET3XCJqXutD6r" +
           "UzxVL4z69dWSVztdRFBhrj5dcWytva7hPbyPR7ha4LwZMlmudVQMK1Vb1zUc" +
           "wTQbW0fd1SphVK6hkitnlEpJqdKrOIo0HYtD0LlGmXZslSVtVe3DrL5Jynwy" +
           "5jerls0wgiM203FP5F3DRFuRNVM9y5gZ42LH6HWmY3pNdUKh7q1Wi02FGhQ5" +
           "nLVFd7XCxvUJMR8P2quQbPq0RXurdEUvMZonJjOlPjaYZFlYNEqaQ5LN1aQx" +
           "Yzt0rSpQZLWzaTQ6DgPPxjzNlAxOizudBj8pdlcNQd3QoRuiljtKnL7bao48" +
           "pDlGLXxGCspIK4RKgQ1HeJ/1RbwXYsREDrol2eqETiuVUHdUGHYE2kAiw+Uc" +
           "Bu3qwz7f4YlKzNZpdmKtqYKF0qP6eFz09dGypHMs56hpO1bQhbMSpQkqtFx7" +
           "gQdcezzdmM7Kc2wxFvqqOio6o2pTwhXeJ/mp5ZmlpIl7CM22psVKNPSpMk2z" +
           "xeZMUJrDMimIvbJSNzuesLAa6bI70cThKsZJx2hODZMvokKxYFeKtkrFap1B" +
           "HNqUXbs3NjRkBc9Noy6Lgjmp9lZ2R7fnrS5SlIZFh6DlAVaUFwJvymTck+nG" +
           "QqAFiYBxpaPONqtVeRg2plXXJk0MK8wJaj0rD81+052GK2fSIyqL/pAaN7Sl" +
           "JBGa6TW5etgb1gl6OZW7hmetTSlh29VNp7ccNsWuTFu9Oa9U1VgUh0WSmpbK" +
           "7nzkhfVJZizsL9dmj63M9WK37RM2NzEkeFOtoDQ3Rk1OENs27VJVighkOOmz" +
           "pQCfjQsKR0TNwZKpDzUN84swiGacRUOvIc4o0e4601HaGHp+RZKwWjUNoijq" +
           "OlJvEA5inpOr7SAsW0sU75X6ZSox7KBS58aKVEvlWWONm0iJg8frAsfFG2Nl" +
           "DbF+OmwOpvbEFCuuFAxLQ4c3BMqeKEWurza11qaEztV1XZ04gsmtZmOp4wwV" +
           "fhpWV315jlVpWuIb5Kw/JPDKSuv7CUbVeoFeheV6lxrAlIJTba+6YBd6mWJR" +
           "jzK4YCkNRrTZjFauXPA5q8eGYZ2bO6SM90eGRSBysmyWSjTVGfa6aX8RU81p" +
           "RA66S5ENFsqGwFWmVxj2GiEM67ZNBKNWN3ZWKuN0W32kgYRLVEdBItvj6sRk" +
           "Wu1QLkUNWuNhYcEvOrAcb9iWHy60EU7Yw6DHJ+xkNtRlsjCbVvVy0WkJg6CC" +
           "mZ6uRxHsxyVLJJa9YWxRCeuKYmrAi1F7pHtiQR0viTphumyRaCgYs/DLLt3o" +
           "FHCMn1PTjcKv6EVviI/Q1WTUg3XMWDplTpeboYQ5ZavUK7irZWXeD81OzLn+" +
           "YNKfkiBpcxx9sx5TdFEJ1u0wqHMCx7PVaGgM20CiLUS0vzIJ3ghmzS4670lr" +
           "kmktLXs1aza6zgIOZ/yiWh7MMbkUGVKrpQr0ekoMpklZHfTwYRRgC902sE5F" +
           "KNUQZGAz4015CfcSjm8bVdiy02XoDJsFkUEbxU40q8q6OSvDy34NAwsqHsST" +
           "YSrUJV2iaunc8JZNttxZhuqUjFGfTKfN/thxq7LUF1IaBFgj6k+RsDQI2kYy" +
           "ZgvVeDAY2bhfXVaLqB1txM60wSqklM4XGudXU2GMIQXMQ6LSAEcry0JQqJs9" +
           "quEKpYZh+210M5UCFi3aDNWp43qzVYELNUXXYyFJkzZGe1G8wdEWQUfzpF63" +
           "kxoO10YWVqyJa84sKpPKIm0EXqUzS8kR69sU1ndQaokz8piNa7FHyNWYb4zV" +
           "wrCldz0PJMqFeMH4Dk6pRAWBa5OUidtUs51UerUwEebjGpxuyArcx0wENheS" +
           "0U5XtSa8weJkqMey3is2LHc6QxtOamKbISIMsGq/Pxy6dVSeTUWlLjYxQmuT" +
           "aGEdIlUU8eNNn1WsWrhYkFVad2iYnBmu5+BYaaSy3LhWKSXLmoy1Y1rYoORm" +
           "QpEMIgv2UC/OpnQ6cM2Q6ZlqNJbLISeG+NhzHWLQ74X1lJ1OSF2TmOWA7hYr" +
           "GxxXEB1vbBJ9Me2aK6q5UerdEkW4M5eMBFsjNZ21WV3rVuqVVGHUeFJsdqqj" +
           "SWPTo+W0pEb9pjrCo43lYKNaECGiNQoUUZKHwdh2qy22iipVbQY3zIngr8ZK" +
           "NHfbHsEWeb9akIdcyukoXOZHUXVjUAvEjBcIVjA5djr1E9TQqLA4JfiKlUiD" +
           "kuDXCZVWV6azMEPEd2GOtyrekiwo3QI9VhS3RrIsAss6Ukj1iGLx8siTZT4C" +
           "J9jqYJDM+Fbb1vqsW6jhVtnpI0jT0sX1wl7NC3IFt0h22tLDUptGxKnPIXNX" +
           "3mCVcgHdqKjKYtR4gZJ+KvKmZaaSpsE6MV5bitXS264tTdS+TBux1Ji5fJ8Z" +
           "dmaEiIrpRJK0lqxOlyRHx/1+f2NWAjcyUnjWsQuDCTuTZhO7a3mjVmoQnqAV" +
           "yaDEOQ14nZYq7KBmzKRmQZngIoH3EUEOeuwmEWobpDkbTcR2TYw7ZEBNFwW2" +
           "OZHngacw7KDM4GyLEunBHKmZmD8g2+M+WxgV+Gm6WbeIHobJAlk1temMlGly" +
           "osLCiJ8WcT4tU70BHLQtj2zNbUwoMFyj1iY7q7EQLXmtEnBBM+msYWGBhXxZ" +
           "7XN8r4dEI8pJhr7a4DslcsLzVSLpOm67tEh5so1Ue6nV7DaduGx0O6W64AZz" +
           "RxgKEkJE3cmcMjVT744mU3CsH6ClSSXojoT+mlC8so4zWFXtjfmW7yvWZDBu" +
           "FHG8ZA4MWaSKa2bTY0qd2E8mKl9vtcKiPilH9oqVTV9b95naODIYT5QToVXb" +
           "9AOFYN2h2PE7o6BiTygUg+OVhajMam2qsCr7KAE3BCE16u0hOiAlnI8tdths" +
           "LAg/UAAqFJr6wjQ2ijz3F9UIkwsOIut6VfKtwro5TdedDqx1Nw1kU8FAEihR" +
           "/tSs9KQuoSzZkiLxrTWydCpCSqynraY3wlWq2iKbhRU9lzlsOvC9cpoyxmjY" +
           "K/TSzoIjdI2pVCt2bIDDuOGsGNmRLXy5GrZ5vdOX4pI274obbC5g8LJCKi0z" +
           "FdRCHIdVSum603gdjgsejtSmeFN10IrfbJM2syHAXoAqOBBCkxhMVRt2meMa" +
           "vg4Ta2KNIOK6GlSaCYG1ZzIXxgwsy3WTS6T6mJ5Zk6RndwVnimhal2eWKLxJ" +
           "nHEse6k5wkullHKjNhysYN3T13pJQoJAx5B50FAW9XRJDsEB4E1vyo4Gb315" +
           "p7M784Po4a0DOJRlL1ov41SS3HjA3RC6zfPdEJzcNTUf96i0lVc17jmoXx/8" +
           "Hi9tHdU7dg6OxG+5YU2XSkLNCQzZ0q4v6Z6s42bnuQdvdmWRn+U+/fQzz6qD" +
           "zxR39+tNM3B8379JOq6PDz1x80NrL7+uOSqCfOXpf7k8fvPi7S+jtPvwKSVP" +
           "i/zD3nNfa75O+cgudOawJHLdRdJJpqsnCyEXfC2MfGd8ohzy4KF77s+88SAw" +
           "9Xv77vnejcurN/T7Th5o2/A6Vcvb3QZGHmAHXr0n82qMKbkzG64SZR7LueOX" +
           "qAS+I2t84B7F16RQOxB293Fh+94/CuLgFx2tT5TcQuhVN70SOBiv+LKvGUDw" +
           "PHDd5eb2Qk75/LMXz9//7OTbeTn98NLsNgY6r0eWdbyOdez5nOdrupFPym3b" +
           "qpaX/7w3hC7fXLsQOpv/5oa8Z8vxW/vOOM0RQmdAe5zyd0Lo0mlKIDH/PU73" +
           "oRC6cEQHvLV9OE7yESAdkGSPH/VuUPzalv6SnWMLcB9wcpfe9YtceshyvDKf" +
           "Ldr8IvpggUXbq+hryhee7fTf8ULlM9ubAcWSNptMynkGunV7SXG4SB+9qbQD" +
           "Wedaj794xxdve+0BmtyxVfho6RzT7eEbl+Ep2wvzwvnmT+//4zf+/rPfz2tx" +
           "/wsE/pdxISAAAA==");
    }
    protected static class XBLContentElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public XBLContentElementFactory() {
            super(
              );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.dom.svg12.XBLOMContentElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("H4sIAAAAAAAAAL1YfWwcRxWfO3/Edmyf7fgjJLGTuE6qOOG2bhugcmhrO3bi" +
           "cP5QnET0QnOZ252723hvd7M7a59dCm2lqgGhkKZpG5Dqv1xVoNJWiAqQaGVU" +
           "ibYqH2qJgIIakBBQCBGNkMof4evNzO7t3t5do/AHlry3N/Pmzbz3fu/33tzz" +
           "V1GdbaE+otM4XTKJHR/X6Sy2bKKMadi2j8BYSn66Bv/9xPvTd0VRfRK15rA9" +
           "JWObTKhEU+wk6lV1m2JdJvY0IQpbMWsRm1gLmKqGnkRdqj2ZNzVVVumUoRAm" +
           "cAxbCdSOKbXUtEPJpKuAot4EnETiJ5FGwtPDCdQsG+aSL74xID4WmGGSeX8v" +
           "m6K2xCm8gCWHqpqUUG06XLDQbtPQlrKaQeOkQOOntL2uCw4l9pa5oP+l2IfX" +
           "z+XauAs2YF03KDfPPkxsQ1sgSgLF/NFxjeTt0+gLqCaB1geEKRpIeJtKsKkE" +
           "m3rW+lJw+haiO/kxg5tDPU31pswORNH2UiUmtnDeVTPLzwwaGqhrO18M1m4r" +
           "WiusLDPxyd3ShadPtH27BsWSKKbqc+w4MhyCwiZJcCjJp4lljygKUZKoXYdg" +
           "zxFLxZq67Ea6w1azOqYOhN9zCxt0TGLxPX1fQRzBNsuRqWEVzctwQLnf6jIa" +
           "zoKt3b6twsIJNg4GNqlwMCuDAXfuktp5VVco2hpeUbRx4DMgAEvX5QnNGcWt" +
           "anUMA6hDQETDelaaA+jpWRCtMwCAFkWbqiplvjaxPI+zJMUQGZKbFVMg1cgd" +
           "wZZQ1BUW45ogSptCUQrE5+r0vrMP6Af1KIrAmRUia+z862FRX2jRYZIhFoE8" +
           "EAubBxNP4e5XzkQRAuGukLCQ+e7nr927p2/tDSGzuYLMTPoUkWlKXk23vr1l" +
           "bNddNewYDaZhqyz4JZbzLJt1Z4YLJjBMd1Ejm4x7k2uHf3TfQ98kV6KoaRLV" +
           "y4bm5AFH7bKRN1WNWAeITixMiTKJGomujPH5SbQO3hOqTsToTCZjEzqJajU+" +
           "VG/w7+CiDKhgLmqCd1XPGN67iWmOvxdMhFAX/KMdCEX+iPhf5A/sSZEi5Yw8" +
           "kbCMdVU3pFnLYPbbEjBOGnybk9KA+nnJNhwLICgZVlbCgIMccScUIy/ZC9mh" +
           "26W5YweGbt8/M8VYkORhPU+XOEOb+X/ap8Ds3bAYiUAotoSJQIMcOmhoCrFS" +
           "8gVndPzaC6m3BMhYYrieougQbB0XW8f51nHYOs63jlfeeuCzownOHzodF8MT" +
           "mGX8EopE+FE62dkEIiCe88AMQM3Nu+buP3TyTH8NQNFcrGUhAdH+khI15tOH" +
           "x/kp+cWOluXtl4dei6LaBOqAnRyssYozYmWBy+R5N92b01C8/BqyLVBDWPGz" +
           "DJkoQGHVaomrpcFYIBYbp6gzoMGrcCyXper1peL50drFxYePffG2KIqWlg22" +
           "ZR0wHls+y8i+SOoDYbqopDf22PsfvvjUg4ZPHCV1yCufZSuZDf1hsITdk5IH" +
           "t+GXU688OMDd3gjETjEkInBmX3iPEl4a9jie2dIABmcMK481NuX5uInmLGPR" +
           "H+EobufvnQCLGEvUWwEef3Izl3+y2W6TPXsE6hnOQlbwGvLpOfOZX/30z3dw" +
           "d3vlJhboE+YIHQ5QHFPWwcms3YftEYsQkHvv4uwTT1597DjHLEjcUmnDAfYc" +
           "A2qDEIKbH33j9Lu/vbx6KerjnEKNd9LQKhWKRjYwm1o/wkjYbad/HqBIDeiD" +
           "oWbgqA74VDMqTmuEJdY/YzuGXv7r2TaBAw1GPBjtubECf/xjo+iht078o4+r" +
           "icisRPs+88UE72/wNY9YFl5i5yg8/E7v117Hz0AFAda21WXCiRhxHyAetL3c" +
           "/tv4887Q3CfZY4cdBH9pfgVaqZR87tIHLcc+ePUaP21pLxaM9RQ2hwW82GNn" +
           "AdT3hMnpILZzIHfn2vTn2rS166AxCRplYGV7xgL2LJQgw5WuW/frH77WffLt" +
           "GhSdQE2agRXBgVC7AN3EzgHxFsx77hXRXWThbuOmojLjywaYg7dWDt143qTc" +
           "2cvf6/nOvudWLnOUmULH5qDCW/lzkD0+zsejFDWalkFBFYF2qt7mfaCPSL62" +
           "0yuU3mcQkf4eEf6+kaJ7KhaP8QLUBlsFeJXXjtKKwQLSW6034n3d6iMXVpSZ" +
           "Z4dEB9NR2m+MQzv9rV/868fxi797s0Jpq3d72+DBYb+SkjPFe0af9t5rPf/7" +
           "7w9kR2+m2rCxvhvUE/Z9K1gwWL16hI/y+iN/2XTk7tzJmygcW0O+DKv8xtTz" +
           "bx7YKZ+P8gZZ1Iyyxrp00XDQq7CpReAmoDMz2UgLz65biijqYaDpBUdfcVF0" +
           "pTJ5c4iyx+5ySqy2NEQeUQFrD4ptPGNYmx8Xbb430ckwuniHzKG535Adhj9+" +
           "jPs+go5S7HEEMCRbBFpVT9mGoDIXy3zuU+xxVKTT8P+Y92xgxCxA012tw/KO" +
           "MXTTTRsAf2PZVVFcb+QXVmINPStHf8kxX7yCNAN6M46mBYIfBEK9aZGMyn3V" +
           "LCjW5B/zcKuqfjqK6vgnN+SUWKG7MQqvoKgGnkHJ0xDmsCRo5J9BOUpRky8H" +
           "QRQvQZFF0A4i7BUItxxD4l5UiJQzK490140iXVwS7BpYyvNrvZeejrjYQ5O7" +
           "cmj6gWufeFZ0LbKGl5f5NRButaKBKqb49qraPF31B3ddb32pcUfUhXK7OLCf" +
           "eJsDOB+BRDNZxdkUKun2QLGyv7u679WfnKl/Byj2OIpgyILjgUu18BT0BQ5w" +
           "6/GEz66Bn4V4rzG86+tLd+/J/O03vGi5bLylunxKvvTc/T8/v3EVepL1k6gO" +
           "qgEpJFGTau9f0g8TecFKohbVHi/AEUGLirVJ1ODo6mmHTCoJ1MqAjBkTcL+4" +
           "7mwpjrKel6L+spt9hZsCFPhFYo0ajq5w0gM69kdKfm/wWNIxzdACf6QYys5y" +
           "21Py/i/FfnCuo2YCkrHEnKD6dbaTLjJw8CcIn5LbBK/+B/4i8P9v9s+CzgbE" +
           "TbhjzL2Obyvex6GTEHM1qcSUaXqyDT8zRYp8mT2+UmDjFEUG3VHGYRFRXtnX" +
           "r/L9z/JX9nj8v7D8KWyOFAAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "ihsgAAA=");
    }
    protected static class XBLHandlerGroupElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public XBLHandlerGroupElementFactory() {
            super(
              );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.dom.svg12.XBLOMHandlerGroupElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "To3Fr18T+58Vr/h47L8yxZBzmBQAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "ree+mdXk/hdwTlOfLSAAAA==");
    }
    protected static class XBLImportElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public XBLImportElementFactory() {
            super(
              );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.dom.svg12.XBLOMImportElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "/soeX/8vv7+AHYwUAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "xw2TkCPLTXbjU/wz5PlPXWm8+Qc5/26JZ9yPrG9EZ5DC7Xixz9n/tvfE7X+2" +
           "B52fQZeVg/xwLFlRtnBmICcKDpNGkEOeeH8yv9lu5teOIOw1p+Hl2LCnwWW3" +
           "K4DnjDp7vngcT34CPmfA93+ybzbdWcd2V72ncbC1P3a0t3ve+gxYreew/cp+" +
           "IeN/Sy7l8by9mjU/t3VT9vjzYFkHeWIKOHTTkax84KdDEGKWcvVQ+hgkqtkG" +
           "tLAquZj7QWqeh1Nm/f42u9sCWtZiuYhtSJRuGT6/sKXKd667dsIYFySKH/zH" +
           "j3zzw6/9LvBpBzoXZ/MNXHlsRC7Kcuf3Pf/xh1/17Pc+mKMUgKjxe1668nQm" +
           "lXk5i7OGzJrWoalXMlP5PCFgpCBkc2DR1Nzalw3lvm/aAH/jg8QQeeae7y4/" +
           "9f3Pb5O+03F7ilj7wLO//pP9Dz27dyzVfu0N2e5xnm26nSv96oMZ9qHHX26U" +
           "nKP1T1985o9+55n3b7W652TiSIJz0ef/6r+/uf/J7339JjnKbZb7f3BseOcF" +
           "qhjQ9cMPg4r6JFGG64keIRwud5AQbvSXScFSOum8F3VxmVgZChaues44Keqg" +
           "j478wbQ3w0pwEcPDWK2wFWlWUhuTsrUaNExyyYjESq8w48FoJYsTt05bk6E3" +
           "dldJh+eNwQilm2QfHi3ceYuHea4az5xZrOJyhAUjJGjwNWRm4346q9UqMaKW" +
           "ZQ0myytfCVGyVrBXTabjkwK5Wanr2YyzKJLDEHHdJmNmUxUSvADX+jgat5pT" +
           "1kXEarhSl3KH61gTs9sXYWwle1zAFwWt5A7mEiaG4pzzyTE7HvX04QZbOXwq" +
           "2ubKV1lv0CDYoiEVRuWAH01sv+3ygtddEe4k8Xp03Bb4bn9enpEjyRtxSm05" +
           "xdeDAZUgLMvajbikcqORvmq2KuRyyY2F0crj5gVvYpuxNFkwPQUzGuPu0hT6" +
           "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" +
           "gMNY9oJ6BaeR9c0H3AuhOzzfDcGJXVPzcXclrbyacd9h1frw93hJa1fnOHN4" +
           "FH7LTSu55DrUnMCULe3GQu7J+m12jnv4VhcV+RnuM+9+9jm191l076DONAXH" +
           "9oP7o+P6+NBTtz6ssvklza748dV3/8sV4c3zt7+Cku6jp5Q8LfJ32ee/3n69" +
           "8tE96OxRKeSG66OTTNdOFkAu+loY+Y5wogzy8JF7Hsy88TBwy/kD95y/eVn1" +
           "pn4/kwfaNrxO1fD2toGRB9ihV+/LvJrgSu7MpqtEmcdy7uRlKoDvyBofuEfx" +
           "NSnUDoXde1zYgfd3QRz8tCP1iVJbCD14i4uAw9HQV3y1AELnoRsuNLeXcMoX" +
           "nrt04cHnRn+dF9GPLsruYKALemRZx6tXx55v93xNN/MpuWNby/Lyn/eF0JVb" +
           "axdC5/Lf3JD3bjl+7cAVpzlC6Cxoj1P+RghdPk0JJOa/x+k+HEIXd3TAV9uH" +
           "4yQfBdIBSfb4Me8mJa9twW995tjyO4Cb3KH3/DSHHrEcr8dnSza/fD5cXtH2" +
           "+vm68sXnOtw7Xix/dnsfoFjSZpNJucBA57dXE0dL9PFbSjuUdTv15Et3femO" +
           "1x1iyV1bhXcL55huj968+E7aXpiXyzd/+ODvv/G3n/tOXoH7Xw/zfl4VIAAA");
    }
    protected static class XBLShadowTreeElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public XBLShadowTreeElementFactory() {
            super(
              );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.dom.svg12.XBLOMShadowTreeElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "/Y7Y/6x4xccT/wUliP4+lBQAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "AA==");
    }
    protected static final org.w3c.dom.DOMImplementation
      DOM_IMPLEMENTATION =
      new org.apache.batik.dom.svg12.SVG12DOMImplementation(
      );
    public static org.w3c.dom.DOMImplementation getDOMImplementation() {
        return DOM_IMPLEMENTATION;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "8Ed8Wvd/gXiucL4lAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "w8esHS9Yi7byhiH80mEIf/07DGFe/FJe");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("/L28+NXbY5X//ExefPYC53+pEParefEPL3DTP72g7Tfy4st58epOkwtofzPZ" +
       "ff/tC2h+Ky8+EpSuyp4qBurR2Dl0+7NvgIsnqIv59m++0enMSQV2njlKhrfn" +
       "lc+Az62DZLj13Zkg7jpeRxTLA+nQuMdPnXoezAg5sBZivnpGzMlw3sZMTnqJ" +
       "rLr5HFww/4u8+EpQemjn17PTzdvP6/nYi//8LXjx0UMvugdedL+rXrxzYpyc" +
       "Zg9NOvZ5IfM/XpCJf5wXXzvKxN7u/HnKHKHgSZcdtB577PW34LGn8sp8mffx" +
       "A499/LvjsZPW/Y8L2v40L/5bULp+Old6ESiY0HUBqh06oXKu19Wc0t+/I2Ph" +
       "of/+Fjz0eF75HPh89sBDn/3ueOjMkHr6wpyaOkoxMC9durMvL13OK/88KD1y" +
       "kEXn+PC9F/nwfN/9xVvwXb7iLbXAFHFjx7v7/g59dzwRdd8oxS49fEHbo3nx" +
       "AMCdlRqce71jeWTspQffjLFJUHrs/Ouk+d24x2+7xb67eS1/4aWr977zJe5f" +
       "7dath7ej7yNK92qhaZ68ynTi+YrrqZpe+OG+3cUmtzDuOhg6d77tClYnxXeu" +
       "+qXv2XE8cYDAZznAcgyUJymfCkrXzlICicX3SbobQen+Yzqw4ts9nCR5D5AO" +
       "SPLH73Mv3q0AhfNLurf5NLl0evd5lKCPvFHMTmxYb5zajRT/jnC4JQx3/5Bw" +
       "S/7iS6Ppj38L+czu5qhsilmWS7kXbBx2l1iPtpVP31Haoawr+Pu+/dCr9z17" +
       "uAV+aKfwcdaf0O3d51/T7FluUFyszH79nV/6oc++9LXiys3/BQHmYfknMgAA");
}
