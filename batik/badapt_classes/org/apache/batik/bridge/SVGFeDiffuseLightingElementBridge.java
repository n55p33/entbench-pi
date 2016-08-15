package org.apache.batik.bridge;
public class SVGFeDiffuseLightingElementBridge extends org.apache.batik.bridge.AbstractSVGLightingElementBridge {
    public SVGFeDiffuseLightingElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_FE_DIFFUSE_LIGHTING_TAG;
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
        float diffuseConstant =
          convertNumber(
            filterElement,
            SVG_DIFFUSE_CONSTANT_ATTRIBUTE,
            1,
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
          new org.apache.batik.ext.awt.image.renderable.DiffuseLightingRable8Bit(
          in,
          primitiveRegion,
          light,
          diffuseConstant,
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
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1Ye2wUxxmfO+P324B5GzAGxKN30IQWapLGGBtMzsbFxFKP" +
       "xzG3O3e3eG932Z21z6Z5KlWo2lJEgdBK8BcpJKUhqhq1aZvIVaQ8lLQSKWqa" +
       "RqFI6R9JW5SgqOkf9PXNzO7t3t4diL4s7dx65ptv5vvm9/2+b/bidVRpmaiD" +
       "aDRCJw1iRfo0OoxNi8i9Kras3dCXkJ6swJ/s/2BoUxhVxVFTBluDErZIv0JU" +
       "2YqjRYpmUaxJxBoiRGYzhk1iEXMcU0XX4mi2Yg1kDVWRFDqoy4QJjGIzhlox" +
       "paaStCkZcBRQtCgGO4nynUR7gsPdMdQg6cakJz7XJ97rG2GSWW8ti6KW2EE8" +
       "jqM2VdRoTLFod85EawxdnUyrOo2QHI0cVDc4LtgR21Dkgs7nmj+9eSzTwl0w" +
       "E2uaTrl51i5i6eo4kWOo2evtU0nWOoQeQhUxVO8Tpqgr5i4ahUWjsKhrrScF" +
       "u28kmp3t1bk51NVUZUhsQxQtLVRiYBNnHTXDfM+goYY6tvPJYO2SvLXCyiIT" +
       "T66Jnnhyf8sPK1BzHDUr2gjbjgSboLBIHBxKskliWj2yTOQ4atXgsEeIqWBV" +
       "mXJOus1S0hqmNhy/6xbWaRvE5Gt6voJzBNtMW6K6mTcvxQHl/FeZUnEabG33" +
       "bBUW9rN+MLBOgY2ZKQy4c6bMGFM0maLFwRl5G7vuBwGYWp0lNKPnl5qhYehA" +
       "bQIiKtbS0RGAnpYG0UodAGhSNL+sUuZrA0tjOE0SDJEBuWExBFK13BFsCkWz" +
       "g2JcE5zS/MAp+c7n+tDmo4e17VoYhWDPMpFUtv96mNQRmLSLpIhJIA7ExIbV" +
       "sVO4/cUjYYRAeHZAWMj8+Cs37lvbMf2akFlQQmZn8iCRaEI6l2y6vLB31aYK" +
       "to0aQ7cUdvgFlvMoG3ZGunMGMEx7XiMbjLiD07te+fIjz5A/hVHdAKqSdNXO" +
       "Ao5aJT1rKCoxtxGNmJgSeQDVEk3u5eMDqBreY4pGRO/OVMoidADNUHlXlc7/" +
       "BxelQAVzUR28K1pKd98NTDP8PWcghKrhQQ3wdCHxx38pUqMZPUuiWMKaounR" +
       "YVNn9ltRYJwk+DYTTQLqx6KWbpsAwahupqMYcJAhzkDSVOQ0iY6MbusnW5VU" +
       "yrZITElnKOCK0QOo2cIlIgx1xv95vRyzf+ZEKARHszBIDCrE1HZdlYmZkE7Y" +
       "W/puPJt4Q4COBYrjOYo2wRYiYgsRvoWI2ELktltAoRBfeRbbigAEHOcYEAMw" +
       "c8OqkX07DhzprAAkGhMz4CyYaGdBhur12MOl/IR0qa1xaunV9S+H0YwYasMS" +
       "tbHKEk6PmQYqk8acaG9IQu7yUsgSXwphuc/UJSIDg5VLJY6WGn2cmKyfolk+" +
       "DW6CY6EcLZ9eSu4fTZ+eeHT04XVhFC7MGmzJSiA8Nn2YcX2e07uCbFFKb/MT" +
       "H3x66dSDuscbBWnIzZ5FM5kNnUFsBN2TkFYvwc8nXnywi7u9FnidYohDoMyO" +
       "4BoFtNTtUjyzpQYMTulmFqtsyPVxHc2Y+oTXw0Hbyt9nASzqWZyuhWeNE7j8" +
       "l422G6ydI0DOcBawgqeQe0aMM7/91Yd3cXe72abZVyaMENrtYzimrI1zWasH" +
       "290mISD33unhb5+8/sQejlmQWFZqwS7W9gKzwRGCm7/62qF3fn/13JWwh3MK" +
       "Kd5OQqWUyxvJ+lHdLYyE1VZ4+wGGVIE1GGq6HtAAn0pKwUmVsMD6W/Py9c//" +
       "+WiLwIEKPS6M1t5egdc/bwt65I39f+3gakISy9CezzwxQfszPc09pokn2T5y" +
       "j7616Duv4jOQQIC0LWWKcB5G3AeIH9oGbv863t4dGPs8a5ZbfvAXxpevkkpI" +
       "x6583Dj68Us3+G4LSzH/WQ9io1vAizUrcqB+TpCctmMrA3J3Tw/tbVGnb4LG" +
       "OGiUgIytnSaQZa4AGY50ZfXvfvFy+4HLFSjcj+pUHcv9mAcZqgV0EysDPJsz" +
       "vnifONyJGmhauKmoyPiiDubgxaWPri9rUO7sqZ/M+dHm82evcpQZQscCv8KV" +
       "rFmTxxv/qwpmQz/eCjSYaFG5goUXW+ceO3FW3vnUelFWtBUWAX1Q4/7gN39/" +
       "M3L62usl8kst1Y3PqGScqL41w2zJglwwyGs5j4/eazr+/gtd6S13kgZYX8dt" +
       "iJ79vxiMWF2e1oNbefWxP87ffW/mwB0w+uKAO4Mqnx68+Pq2FdLxMC9cBZkX" +
       "FbyFk7r9joVFTQIVusbMZD2NHPbL8gBoYwfbAc86BwDrSrNqCezkuarc1FtE" +
       "9e5bjI2yZidFDWko63QJq0NgDZecCxc7HgCsaI+Iop0PbGTNsEB4978ZXayj" +
       "x+D99xe7p9+xsf/O3VNuasAF1Xwj1a6hy8uVW6Kmcu5prvRMJj1xlxSR9WzE" +
       "Kb7YUMoVWFqkLj1OI9tMbGQUyRoCwLuS64okGfDxBI0oWbjZRCClA/uxJBHp" +
       "V1S4LbkT5/GjYYJpArvYBeQEx6SSz24tDGIWnSN20qK78ASnj4S0d2VLe9em" +
       "TzoFb3SUkPVdjI7+7Kfx+MoWSQh3llJceCG6cL5Gejf7yh/EhHklJgi52Rei" +
       "3xx9++CbPH5rGGHko8ZHFkAsvvqkJX/eTex4W+G55pw3/6Vo739Y6MM0uO0r" +
       "WcB6dLeSJbJzvO5F4n+qn2fGAv71Du37Y2rPRxu/d49w69IyPOnJv/Cla5fP" +
       "TF26KLifuZeiNeW+jxR/lGH16fJb1NgeQP6y7QvTH74/ui/sEEoTa6yci9NG" +
       "L4dCxmadh/NBGMrfQGYVwkRo3vq15p8fa6voh2QzgGpsTTlkkwG5kHCrLTvp" +
       "w433GcCjXwc0/4S/EDz/YA8DC+sQoGnrda7ES/J3YkjnbJyi0Gp45XqkW7Do" +
       "46zZDywqmQSmi1BlfQc9xkz8NxgzB+Ry2ysgq13mFn2REl9RpGfPNtfMOfvA" +
       "2zyF5790NEAMpmxV9bnW7+YqwyQphZvaIEo5g/98g6I5ZagT6m3xwk35upD/" +
       "FuSUoDxFlfzXL3ecojpPDlSJF7/ISYoqQIS9njJctG0sx+M9wDsm1Cvgu5Iu" +
       "y4WKqzd+arNvd2q+cm1ZQcDwL4cuqO1hJy4vnd0xdPjG554SNyNJxVNTTEs9" +
       "QFlc0vLVytKy2lxdVdtX3Wx6rna5G3qtYsNeklzgg2gPRJrBkDE/cG2wuvK3" +
       "h3fObX7pl0eq3gLS2INCGDLdHt93O/GRCu4eNmSYPbHikIXKjt9nuld9d/Le" +
       "tamP3uWFsRPiC8vLJ6Qr5/f9+vjcc3DvqR9AlVDbklwc1SnW1kkNMtu4GUeN" +
       "itWXgy2CFgWrBXzQxECMWXnC/eK4szHfy+7VFHUWfTws8TUCLhETxNyi25rs" +
       "MEq911PwSdMt+GzDCEzwenyZ6yHWPJITfFORiA0ahss/lRcMHtwPB3mRd/LZ" +
       "T/NX1jzzL+FKMKxVGAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "rpmSP7jn9978W89/Mzu5/h9xiKo2TSMAAA==");
}
