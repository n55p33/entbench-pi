package org.apache.batik.bridge;
public class SVGFeSpecularLightingElementBridge extends org.apache.batik.bridge.AbstractSVGLightingElementBridge {
    public SVGFeSpecularLightingElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_FE_SPECULAR_LIGHTING_TAG;
    }
    public org.apache.batik.ext.awt.image.renderable.Filter createFilter(org.apache.batik.bridge.BridgeContext ctx,
                                                                         org.w3c.dom.Element filterElement,
                                                                         org.w3c.dom.Element filteredElement,
                                                                         org.apache.batik.gvt.GraphicsNode filteredNode,
                                                                         org.apache.batik.ext.awt.image.renderable.Filter inputFilter,
                                                                         java.awt.geom.Rectangle2D filterRegion,
                                                                         java.util.Map filterMap) {
        float surfaceScale =
          convertNumber(
            filterElement,
            SVG_SURFACE_SCALE_ATTRIBUTE,
            1,
            ctx);
        float specularConstant =
          convertNumber(
            filterElement,
            SVG_SPECULAR_CONSTANT_ATTRIBUTE,
            1,
            ctx);
        float specularExponent =
          convertSpecularExponent(
            filterElement,
            ctx);
        org.apache.batik.ext.awt.image.Light light =
          extractLight(
            filterElement,
            ctx);
        double[] kernelUnitLength =
          convertKernelUnitLength(
            filterElement,
            ctx);
        org.apache.batik.ext.awt.image.renderable.Filter in =
          getIn(
            filterElement,
            filteredElement,
            filteredNode,
            inputFilter,
            filterMap,
            ctx);
        if (in ==
              null) {
            return null;
        }
        java.awt.geom.Rectangle2D defaultRegion =
          in.
          getBounds2D(
            );
        java.awt.geom.Rectangle2D primitiveRegion =
          org.apache.batik.bridge.SVGUtilities.
          convertFilterPrimitiveRegion(
            filterElement,
            filteredElement,
            filteredNode,
            defaultRegion,
            filterRegion,
            ctx);
        org.apache.batik.ext.awt.image.renderable.Filter filter =
          new org.apache.batik.ext.awt.image.renderable.SpecularLightingRable8Bit(
          in,
          primitiveRegion,
          light,
          specularConstant,
          specularExponent,
          surfaceScale,
          kernelUnitLength);
        handleColorInterpolationFilters(
          filter,
          filterElement);
        updateFilterMap(
          filterElement,
          filter,
          filterMap);
        return filter;
    }
    protected static float convertSpecularExponent(org.w3c.dom.Element filterElement,
                                                   org.apache.batik.bridge.BridgeContext ctx) {
        java.lang.String s =
          filterElement.
          getAttributeNS(
            null,
            SVG_SPECULAR_EXPONENT_ATTRIBUTE);
        if (s.
              length(
                ) ==
              0) {
            return 1;
        }
        else {
            try {
                float v =
                  org.apache.batik.bridge.SVGUtilities.
                  convertSVGNumber(
                    s);
                if (v <
                      1 ||
                      v >
                      128) {
                    throw new org.apache.batik.bridge.BridgeException(
                      ctx,
                      filterElement,
                      ERR_ATTRIBUTE_VALUE_MALFORMED,
                      new java.lang.Object[] { SVG_SPECULAR_CONSTANT_ATTRIBUTE,
                      s });
                }
                return v;
            }
            catch (java.lang.NumberFormatException nfEx) {
                throw new org.apache.batik.bridge.BridgeException(
                  ctx,
                  filterElement,
                  nfEx,
                  ERR_ATTRIBUTE_VALUE_MALFORMED,
                  new java.lang.Object[] { SVG_SPECULAR_CONSTANT_ATTRIBUTE,
                  s,
                  nfEx });
            }
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1YfWwUxxUfn/H3twHzbbAxIL7ugIQWYpLGGNuYnM0VE0s1" +
       "H8d4b+5u8d7usjtnn00JJGoFTVWEqJPQqvAXBNKSmFaN2jRN5IoqH0paiRQ1" +
       "TaMQpEQqaYsSFDX9g7bpm5nd2729OyPappZ2bj375s28N7/3e2/m4k1UZBqo" +
       "kajUT0d1Yvo7VBrChkki7Qo2zZ3QF5aeKsSf7r3Ru9GHigdQdRybPRI2SadM" +
       "lIg5gBbIqkmxKhGzl5AIGxEyiEmMYUxlTR1AM2WzO6ErsiTTHi1CmEA/NoKo" +
       "DlNqyINJSrotBRQtCMJKAnwlgTbv59YgqpQ0fdQRn+0Sb3d9YZIJZy6Totrg" +
       "fjyMA0kqK4GgbNLWlIFW6poyGlM06icp6t+vrLdcsC24PssFzZdqPrt9Il7L" +
       "XTAdq6pGuXnmDmJqyjCJBFGN09uhkIR5AD2CCoOowiVMUUvQnjQAkwZgUtta" +
       "RwpWX0XUZKJd4+ZQW1OxLrEFUdSUqUTHBk5YakJ8zaChlFq288Fg7aK0tcLK" +
       "LBOfWBkYf2pv7U8KUc0AqpHVPrYcCRZBYZIBcChJDBLDbItESGQA1amw2X3E" +
       "kLEij1k7XW/KMRXTJGy/7RbWmdSJwed0fAX7CLYZSYlqRtq8KAeU9V9RVMEx" +
       "sLXBsVVY2Mn6wcByGRZmRDHgzhoybUhWIxQt9I5I29jyEAjA0JIEoXEtPdU0" +
       "FUMHqhcQUbAaC/QB9NQYiBZpAECDorl5lTJf61gawjESZoj0yIXEJ5Aq445g" +
       "Qyia6RXjmmCX5np2ybU/N3s3HT+oblV9qADWHCGSwtZfAYMaPYN2kCgxCMSB" +
       "GFi5IvgkbnjpmA8hEJ7pERYyP/v6rQdXNU6+JmTm5ZDZPrifSDQsnR2svjK/" +
       "ffnGQraMUl0zZbb5GZbzKAtZX1pTOjBMQ1oj++i3P07ueOVrR35I/uJD5d2o" +
       "WNKUZAJwVCdpCV1WiNFFVGJgSiLdqIyokXb+vRuVwHtQVono3R6NmoR2o2kK" +
       "7yrW+P/goiioYC4qh3dZjWr2u45pnL+ndIRQCTyoEp4WJP74L0WJQFxLkACW" +
       "sCqrWiBkaMx+MwCMMwi+jQcGAfVDAVNLGgDBgGbEAhhwECfWh0FDjsRIoK+/" +
       "q5P06URKKkB6cixOAViMH0DPZi7iZ7DT/98TppgHpo8UFMDmzPdSgwJRtVVT" +
       "IsQIS+PJzR23ngu/IWDHQsXyHUX3wRr8Yg1+vga/WIP/zmtABQV86hlsLQIT" +
       "sKNDwA1AzpXL+/Zs23esuRDAqI9Mg+1gos0ZSardIRCb9cPSRH3VWNO1tZd9" +
       "aFoQ1WOJJrHCck6bEQM2k4asgK8chPTlZJFFrizC0p+hSSQCJJYvm1haSrVh" +
       "YrB+ima4NNg5jkVzIH+Gybl+NHlq5NH+w2t8yJeZONiURcB5bHiI0X2a1lu8" +
       "hJFLb83RG59NPHlIc6gjIxPZCTRrJLOh2QsOr3vC0opF+PnwS4dauNvLgNop" +
       "hlAE1mz0zpHBTK02yzNbSsHgqGYksMI+2T4up3FDG3F6OGrr+PsMgEUFC9XV" +
       "8Ky0Ypf/sq8NOmtnCZQznHms4Fnk/j799B9++9E93N12wqlxVQp9hLa6SI4p" +
       "q+d0VufAdqdBCMi9dyr03SduHt3FMQsSi3NN2MLadiA32EJw8zdfO/DO+9fO" +
       "XvU5OKeQ5ZODUCyl0kayflQ+hZEw21JnPUCSCvAGQ03LwyrgU47KeFAhLLD+" +
       "UbNk7fN/PV4rcKBAjw2jVXdW4PTP2YyOvLH3741cTYHEkrTjM0dMMP90R3Ob" +
       "YeBRto7Uo28t+N6r+DTkEOBtUx4jnIoR9wHim7ae27+Gt/d6vn2ZNUtMN/gz" +
       "48tVTIWlE1c/qer/5OVbfLWZ1Zh7r3uw3irgxZqlKVA/y0tOW7EZB7l7J3t3" +
       "1yqTt0HjAGiUgI7N7QawZSoDGZZ0Uckff3W5Yd+VQuTrROWKhiOdmAcZKgN0" +
       "EzMORJvSv/Kg2NyRUmhquakoy/isDubghbm3riOhU+7ssZ/P+umm82eucZTp" +
       "Qsc8t8JlrFmZxhv/K/YmRDfeMjQYaEG+moXXW2cfGz8T2X5urags6jPrgA4o" +
       "c5/9/T/f9J+6/nqOBFNGNX21QoaJ4pqzkE2ZkQt6eDnn8NF71Sc/eKEltvlu" +
       "0gDra7wD0bP/F4IRK/LTuncprz7257k7H4jvuwtGX+hxp1flMz0XX+9aKp30" +
       "8dpVkHlWzZs5qNXtWJjUIFCkq8xM1lPFYb84DYB6trGN8KyxALAmN6vmwE6a" +
       "q/INnSKqd07xrZ812ymqjEFlp0lY6QVruORsONvxAGB1u1/U7fzDBtaEBMJb" +
       "/8PoYh1tOu9/KNs9nZaNnXfvnnxDPS4o4QspsQ1dkq/eEjWVdVSzpacz6ZF7" +
       "JH9ES/it4ot9itoCTVnqYsPU32VgPS5LZi8A3pZckyXJgI9HqF9OwOHGDykd" +
       "2I8lCX+nrMCByR44h28NE4wRWMUOICfYJoWs25IZxCw6+5KDJt2BRzh9hKXd" +
       "y2obWjZ+2ix4ozGHrOtsdPzFXwwMLKuVhHBzLsWZZ6IL50uldxOvfCgGzMkx" +
       "QMjNvBD4Tv/b+9/k8VvKCCMdNS6yAGJx1Se16f2uZttbB891a7/5L0W7/8tS" +
       "H4bBgV9OANYDO+UEiVjbax8lvlD9PDNm8K+zaT8aUto+3vD0/cKtTXl40pF/" +
       "4avXr5wem7gouJ+5l6KV+a5Isu9lWH26ZIoa2wHI37rum/zog/49PotQqllj" +
       "pmycVjk5FDI26zyYDsKC9AlkRiZMhOYt36r55Yn6wk5INt2oNKnKB5KkO5JJ" +
       "uCVmctCFG+cmwKFfCzSfw18BPP9iDwML6xCgqW+3TsWL0sdiSOfsO0UFK+CV" +
       "65GmYNFvsGYvsKhkEBguQpX17XcYM/wFMOY89m0dPCesMDgxBWPydgVrVnOl" +
       "PigDdEOjAGASgfLY5NdSnvJ4xhTKPQ7xCa2cCVkT4ZOfnMJt46x5nKJZcLKB" +
       "SoDaB9uOlK6pAAkzN+OEDAggKg9bOFkX2icdawl9aCPwAGuOsGBaPsU9ZKaO" +
       "wKH694d+cONZixOzTmYZwuTY+OOf+4+Pi9gSd2OLs66n3GPE/ZiAY3p1TVPN" +
       "wkd0/mni0IsXDh21Leui7DClYeoNIfbv4ZSDtW//L7CWoqj5zvcNrFCenXUD" +
       "Km7tpOfO1JTOOvPw27xeTN+sVQLhR5OK4opjd0wX6waJytzgSnFu0PnP0wCU" +
       "PHka0CteuC3nhPwzUMB45cGB/Nctd5GickcOVIkXt8gERYUgwl4v6Ta1bchX" +
       "NLQBRg0ojsF5OV2WKsg+KvBtm3mnbXOdDRZnYJvfVNtxkgxZSWDizLbeg7e+" +
       "dE4cwyUFj40xLRXAm+JGIF0aN+XVZusq3rr8dvWlsiU2FuvEgh1+mecK7DbA" +
       "pM6QMddzRjVb0kfVd85uevk3x4rfgijahQowlFW7XPfE4lIUDrpJKGd2BbPz" +
       "Axwj+OG5dfn3Rx9YFf34XX4Ks/LJ/PzyYenq+T2/Ozn7LByyK7pREYQZSQ2g" +
       "ctncMqpCGTVsDKAq2exIwRJBi4yVjORTzUCMWS3M/WK5syrdyy5xIG6y2SD7" +
       "6gtOrCPE2Kwl1YiVviqcnowrdCswypO67hng9LjKpEcExYjkVhgO9ui6neyK" +
       "fqzz6D6cm0FYe5m/subX/wbjZQ3QxRoAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "HnlnJQAA");
}
