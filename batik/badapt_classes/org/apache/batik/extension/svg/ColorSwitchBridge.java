package org.apache.batik.extension.svg;
public class ColorSwitchBridge extends org.apache.batik.bridge.AbstractSVGBridge implements org.apache.batik.bridge.PaintBridge, org.apache.batik.extension.svg.BatikExtConstants {
    public ColorSwitchBridge() { super(); }
    public java.lang.String getNamespaceURI() { return BATIK_EXT_NAMESPACE_URI;
    }
    public java.lang.String getLocalName() { return BATIK_EXT_COLOR_SWITCH_TAG;
    }
    public java.awt.Paint createPaint(org.apache.batik.bridge.BridgeContext ctx,
                                      org.w3c.dom.Element paintElement,
                                      org.w3c.dom.Element paintedElement,
                                      org.apache.batik.gvt.GraphicsNode paintedNode,
                                      float opacity) { org.w3c.dom.Element clrDef =
                                                         null;
                                                       for (org.w3c.dom.Node n =
                                                              paintElement.
                                                              getFirstChild(
                                                                );
                                                            n !=
                                                              null;
                                                            n =
                                                              n.
                                                                getNextSibling(
                                                                  )) {
                                                           if (n.
                                                                 getNodeType(
                                                                   ) !=
                                                                 org.w3c.dom.Node.
                                                                   ELEMENT_NODE)
                                                               continue;
                                                           org.w3c.dom.Element ref =
                                                             (org.w3c.dom.Element)
                                                               n;
                                                           if (org.apache.batik.bridge.SVGUtilities.
                                                                 matchUserAgent(
                                                                   ref,
                                                                   ctx.
                                                                     getUserAgent(
                                                                       ))) {
                                                               clrDef =
                                                                 ref;
                                                               break;
                                                           }
                                                       }
                                                       if (clrDef ==
                                                             null)
                                                           return java.awt.Color.
                                                                    black;
                                                       org.apache.batik.bridge.Bridge bridge =
                                                         ctx.
                                                         getBridge(
                                                           clrDef);
                                                       if (bridge ==
                                                             null ||
                                                             !(bridge instanceof org.apache.batik.bridge.PaintBridge))
                                                           return java.awt.Color.
                                                                    black;
                                                       return ((org.apache.batik.bridge.PaintBridge)
                                                                 bridge).
                                                         createPaint(
                                                           ctx,
                                                           clrDef,
                                                           paintedElement,
                                                           paintedNode,
                                                           opacity);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "T7bcWcd267yI7+3fDx9s4J6XnALeerq0W91FMvw35lQu5e3lrHnVVk3Z6y8A" +
       "tw7z7BNgaKYjWvnEb4qAiVny5X3qPMhGgU4uL6xqTublIP/OzSmTfnebwm0D" +
       "WtaWchJbk8Cuaz6v3ULlO9edh8QoF2SDH/zHj3zjw49+B+iUhE6vsvUGqjwy" +
       "IxNnCfKvPPuxB257+rsfzKMUCFH8ux77tzzdoG4kcda0s4bYF/W+TFQu3/Yp" +
       "MYzoPLCoSi7tDU15EJg2iL+rvewPfurid5af/N7nt5ndSbs9Aay+/+kP/GT3" +
       "Q0/vHMmnH70qpT2Ks82pc6bv2FvhALp0o1lyDOKfnnvqj373qfdtubp4PDts" +
       "g8PP5//qf76x+4nvfu0aqcjNlvtTKDa6483dcthr7H+o4lybruVRMtXYmsqu" +
       "qvCmNFuXZbW/lD1KJcVhc+oqXKk6UbyS1jU9uue0xFkslbC4jKLKQq3KsCSQ" +
       "4jQy2J5p9indwy1fX3Pe1GpJfM/g2tSw7y9HUsThxRHJ4bbZb44GZk/sjSaw" +
       "bgxRbyWsFFSqpct+w0wjtBvYq7GWokGKqgU4CosK6U1LI8aXUpysbewR6iHw" +
       "shdNN9MqM3UltdCKpcVm2pjVS5V2sEbVNqdM5qKcDFXENJg4mtmCiCQ1w+cl" +
       "GSuOeLuVstNRrzwy6w5t+02Z0YZJuOSKzSoLvMv1u2mfazWW7ASPOlNz4Vhe" +
       "0JPHkouzzaUyTNi2MXHM2bxrVSPTI8pJitsDjbIHK0ZFdW8kSJuCtCxI8/bY" +
       "a7qpHYtRZy6u2HjVnpTs8rxkKXO6axNYd2Gb1VmTDltxya0N25Ui5hbiRWUz" +
       "2aQ03Tb9OOwQhUBQMSsSAViHYxjU3mhJQJUmWk/35+aINWoJmSCJUqddqekT" +
       "Y74YDTi3rA0HY7luqcPKojWbWLzn9rpln6tPewZJCV4x6W16dJlti3HVpTyj" +
       "CXRMSOJ0SnK+ihobRVOTYQ2VA46h5yJPFSfjDdtwNT2kl/MOObLatc0mxhjS" +
       "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");
}
