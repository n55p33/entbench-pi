package org.apache.batik.svggen;
public class SVGHintsDescriptor implements org.apache.batik.svggen.SVGDescriptor, org.apache.batik.svggen.SVGSyntax {
    private java.lang.String colorInterpolation;
    private java.lang.String colorRendering;
    private java.lang.String textRendering;
    private java.lang.String shapeRendering;
    private java.lang.String imageRendering;
    public SVGHintsDescriptor(java.lang.String colorInterpolation, java.lang.String colorRendering,
                              java.lang.String textRendering,
                              java.lang.String shapeRendering,
                              java.lang.String imageRendering) { super(
                                                                   );
                                                                 if (colorInterpolation ==
                                                                       null ||
                                                                       colorRendering ==
                                                                       null ||
                                                                       textRendering ==
                                                                       null ||
                                                                       shapeRendering ==
                                                                       null ||
                                                                       imageRendering ==
                                                                       null)
                                                                     throw new org.apache.batik.svggen.SVGGraphics2DRuntimeException(
                                                                       org.apache.batik.svggen.ErrorConstants.
                                                                         ERR_HINT_NULL);
                                                                 this.
                                                                   colorInterpolation =
                                                                   colorInterpolation;
                                                                 this.
                                                                   colorRendering =
                                                                   colorRendering;
                                                                 this.
                                                                   textRendering =
                                                                   textRendering;
                                                                 this.
                                                                   shapeRendering =
                                                                   shapeRendering;
                                                                 this.
                                                                   imageRendering =
                                                                   imageRendering;
    }
    public java.util.Map getAttributeMap(java.util.Map attrMap) {
        if (attrMap ==
              null)
            attrMap =
              new java.util.HashMap(
                );
        attrMap.
          put(
            SVG_COLOR_INTERPOLATION_ATTRIBUTE,
            colorInterpolation);
        attrMap.
          put(
            SVG_COLOR_RENDERING_ATTRIBUTE,
            colorRendering);
        attrMap.
          put(
            SVG_TEXT_RENDERING_ATTRIBUTE,
            textRendering);
        attrMap.
          put(
            SVG_SHAPE_RENDERING_ATTRIBUTE,
            shapeRendering);
        attrMap.
          put(
            SVG_IMAGE_RENDERING_ATTRIBUTE,
            imageRendering);
        return attrMap;
    }
    public java.util.List getDefinitionSet(java.util.List defSet) {
        if (defSet ==
              null)
            defSet =
              new java.util.LinkedList(
                );
        return defSet;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "KYStzMQvZvxs5akTl1lIKrqM2cayQGJwQDAr6C0UOPvGl9489b0jY3pJsKgw" +
       "9Ln4Zv5jixjd96e/57icgV6ecsXFHw6ce3RWcPUHjN9CH8rty+QmM0Bwi/cL" +
       "Z1OfeNvKfu1F5WHUwBsF9DAnpumeDkPRqJlVNRTZjvfOAlCvdrqy6DrHjXy2" +
       "ad24ZyVR6FNq2q91QV0NXcIOeNoMFGhzQ50Hsc5mxrKQtZ20ud1ElnJFFeCQ" +
       "hV3QUl1EKBgJRRZNCFDVgkWcCYPLdWCl7V20CelCVxWMzG6nJXSiBcakCwpY" +
       "MqRbQpu+XJULcRNUx1QegFIPO1DDpu7WW1SX1ng+Y0JfAXW3FVW3EDdBtfS8" +
       "VFTb7Z/Bue3GfO0FtI0W1bYQNzhXS3IKLqou/xnU7TAm7CigrlBU3ULcoK6Q" +
       "gtNUUXV3F1E3Y027ODst+5Qh1wnAnpAt1PSayay9SG1slcUmdWsR6sFxQLgM" +
       "TTlzCx3+2MH15L7DJ2JbHluq43GT80DVLaVTP/ndv17zH7vySp5KvpLIyu0i" +
       "HsWiwxaY0pEBetm52ILTd+sOvfeML7H2VupvOtZykwqb/p4HRnQWTipuVV7a" +
       "95dZQ6uTu26hlJ7ncqdb5Jnec69s6OAPedklgI7zOZcHTqYuJ7pXqZikVWnI" +
       "gfELsoFVT+OoBZ7VRmCtdu8GK3RdMZktEguxuiokT/ZYZVtRulSD6ahGBrgx" +
       "FksRfvvChmbfio/b9CBqyUNru3E48Mtnw+GFDbxO3JZPsPOm4fSpCv6d1It/" +
       "1hluy8Og000/HXho+K3dr7HFrKDRk3WhLXIgymynhIasb+qoKxrhuWL4hn0T" +
       "tP1/PFADWypAhBTgSmBISOEYvcajNhgH9s9VPis5HZvRWrTHR8Q1H375x6t0" +
       "t7YW2DQW/TNfvXLx+MT5czoQUPcStLjQxWPubSc9JbYXOelaAfLJhrsmr743" +
       "vMNr1OZ1tPlOxkS9Wqs4hVKYDj6cJ2CnOcNEl7zuW/W/OthUsh6QpwdVpCVh" +
       "Txr3xJy7r1xLR21xY92vWXvRCJr/wMcDz7/pQ4OFDuhB0xQ07prmZy+boE6m" +
       "7wnydEKXyXmgyIHkUdrshfNEApPsnbVh77ettHT/zbJo8VqfDgQVNn5vdicw" +
       "9vnwbDZ2wuZbB5hCrAUAhv7+pnMrNsFzxpByxpTyXSblId2SA7Q5k42LOvvR" +
       "Sj+zPu6eiP48qjv/VBHnn6fND+FsCc5fh+OCxA72UOvT8dOW93/0//B+BsIl" +
       "9+qLHsNm5lyu6xfC/BMn6itmnNj6Fsug2UvbGkC9eFoU7QcFW79MUcEUZl+N" +
       "fmxQ2NfTBM0oUEgQVKZ3mO4/1+mfBb+46QkqZd92ugsEVVl0IErv2EkmCSoB" +
       "Etp9XslzoNfPSxmPrbww/MjcP/1m7s+y2G9aKPSwPzdMeEj3Gwh3/sSmvnuu" +
       "L39Mv+nhRW5igkqpBlDQL52yRUBrQWmmrLKNi27UPVnZboJYo66wtXNm2+It" +
       "CKGp0BWf5boG0XzZ25C3T6587jf7y14H+N2GPBxBU7flniwzShpy9bZQLvhB" +
       "wcTuZ7oW/WB89ZL4h++ws7sBlnMK00f4S6d2vHFo5skWL6ruQaVQMuIMO/Ku" +
       "G5cGMD+qhlGtoHVnQEWQInCiA1nraHBytKhmfjHcWZsdpfeEBLXl/L+R53a1" +
       "SpTHsLpWTksxA5urrRHHvy5mHZVWFBeDNWKrAY7Q5lhGR+6SSKhXUUwkr7qq" +
       "sF16ND+Q0PYS69Lmzf8CPfyEqfgcAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "apPOJwAA");
}
